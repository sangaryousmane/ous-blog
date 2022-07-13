package com.example.facebook.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;
    private boolean enabled;

    @ManyToMany(
            cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(name = "user_role_FK")
    )
    private Set<Role> roles=new HashSet<>();

    public User(String name, String email, String password){
        this.name=name;
        this.email=email;
        this.password=password;
        this.enabled=true;
    }

    public void addRole(Role role){
        roles.add(role);
    }

    public void removeRole(Role role){
        roles.remove(role);
    }
}
