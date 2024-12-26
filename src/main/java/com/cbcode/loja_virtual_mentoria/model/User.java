package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)
public class User implements UserDetails,Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date actualDatePassword;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"}, name = "unique_role_user"),
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", table = "users",
                    foreignKey = @ForeignKey(name = "user_fk", value = ConstraintMode.CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "roles",
                    foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)))
    private List<Role> roles;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "person_fk", value = ConstraintMode.CONSTRAINT))
    private Person person;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getActualDatePassword() {
        return actualDatePassword;
    }

    public void setActualDatePassword(Date actualDatePassword) {
        this.actualDatePassword = actualDatePassword;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
