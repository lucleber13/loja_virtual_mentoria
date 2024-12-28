package com.cbcode.loja_virtual_mentoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.cbcode.loja_virtual_mentoria.model") // Indica onde estão as entidades do projeto para o Spring Data JPA encontrar e gerenciar as entidades do projeto automaticamente
@ComponentScan(basePackages = {"com.*"}) // Indica onde estão os componentes do projeto para o Spring encontrar e gerenciar os componentes do projeto automaticamente
@EnableJpaRepositories(basePackages = {"com.cbcode.loja_virtual_mentoria.repository"}) // Indica onde estão os repositórios do projeto para o Spring Data JPA encontrar e gerenciar os repositórios do projeto automaticamente
@EnableTransactionManagement // Habilita o gerenciamento de transações do Spring Data JPA para o projeto automaticamente
public class LojaVirtualMentoriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojaVirtualMentoriaApplication.class, args);
    }

}
