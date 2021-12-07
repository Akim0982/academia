package com.academia.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date createdAt;
    private Date updatedAt;
    @Enumerated(value = EnumType.STRING)
    private Role role;


//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "users_id"),
//            inverseJoinColumns = @JoinColumn(name = "roles_id")
//    )
    //  private Set<Role> roles = new HashSet<>();

//    public void addRole(Role role) {
//        roles.add(role);
//        role.getUsers().add(this);
//    }
//
//    public void removeRole(Role role) {
//        roles.remove(role);
//        role.getUsers().remove(this);
//    }
}