package com.cinar.okan.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    //primary key özelliğinin artırım stratejisini belirleriz
    @SequenceGenerator(name = "user_seq_gen",sequenceName = "user_gen", initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "user_seq_gen")
    //Burayı tam anlamadım 
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST NAME" , length = 100)
    private String firstName;
    @Column(name = "LAST NAME", length = 100)
    private String lastName;
}
