package com.Coffee.CoffeeNetwork.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
