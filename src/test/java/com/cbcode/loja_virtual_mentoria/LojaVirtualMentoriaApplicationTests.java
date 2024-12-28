package com.cbcode.loja_virtual_mentoria;

import com.cbcode.loja_virtual_mentoria.controller.RoleController;
import com.cbcode.loja_virtual_mentoria.model.Role;
import com.cbcode.loja_virtual_mentoria.repository.RoleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class LojaVirtualMentoriaApplicationTests extends TestCase {

    @Autowired
    private RoleController roleController;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    // Test to save a role in the database and check if it was saved correctly by the API endpoint /role/save.
    @Test
    public void testRestApiRegisterRole() throws Exception {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);

        MockMvc mockMvc = builder.build();

        Role role = new Role();
        role.setRole("ROLE_BUYER_SAVE");

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders.post("/role/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(role))
                .accept(MediaType.APPLICATION_JSON));

        System.out.println("Api return " + resultActions.andReturn().getResponse().getContentAsString());
        /* Converter the return to a Role object */
        Role objectReturn = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Role.class);

        assertEquals(role.getRole(), objectReturn.getRole());
    }

    // Test to delete a role in the database and check if it was deleted correctly by the API endpoint /role/delete/{id}.
    @Test
    public void testRestApiDeleteRoleById() throws Exception {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);

        MockMvc mockMvc = builder.build();

        Role role = new Role();
        role.setRole("ROLE_BUYER_DELETE");

        roleRepository.save(role);

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders.delete("/role/delete/" + role.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(role))
                        .accept(MediaType.APPLICATION_JSON));

        System.out.println("Api return = " + resultActions.andReturn().getResponse().getContentAsString());
        System.out.println("status = " + resultActions.andReturn().getResponse().getStatus());

        assertEquals("Role deleted successfully", resultActions.andReturn().getResponse().getContentAsString());
        assertEquals(200, resultActions.andReturn().getResponse().getStatus());
    }

    // Test to find a role in the database and check if it was found correctly by the API endpoint /role/find/{id}.
    @Test
    public void testRestApiFindRoleById() throws Exception {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);

        MockMvc mockMvc = builder.build();

        Role role = new Role();
        role.setRole("ROLE_BUYER_FIND");

        roleRepository.save(role);

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders.get("/role/find/" + role.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(role))
                        .accept(MediaType.APPLICATION_JSON));

        assertEquals(200, resultActions.andReturn().getResponse().getStatus());

        Role returnRole = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Role.class);

        assertEquals(role.getRole(), returnRole.getRole());
    }

    // Test to find a role in the database and check if it was found correctly by the API endpoint /role/find/{role}.
    @Test
    public void testRestApiFindRoleByRole() throws Exception {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);

        MockMvc mockMvc = builder.build();

        Role role = new Role();
        role.setRole("ROLE_BUYER_FIND_BY_ROLE");

        role = roleRepository.save(role);

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders.get("/role/findByRole/" + role.getRole())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(role))
                        .accept(MediaType.APPLICATION_JSON));

        assertEquals(200, resultActions.andReturn().getResponse().getStatus());

        List<Role> returnRole = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), new TypeReference<List<Role>>() {});

        //assertEquals(1, returnRole.size());

        assertEquals(role.getRole(), returnRole.get(0).getRole());
        System.out.println("Role found = " + returnRole.get(0).getRole());

        roleRepository.delete(role);
    }

}
