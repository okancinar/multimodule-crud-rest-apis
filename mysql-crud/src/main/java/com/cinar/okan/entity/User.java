package com.cinar.okan.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Long id;
    @Column(name = "first_name" , length = 100)
    private String firstName;
    @Column(name = "last_name", length = 100)
    private String lastName;
}
