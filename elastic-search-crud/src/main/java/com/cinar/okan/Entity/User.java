package com.cinar.okan.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


import java.io.Serializable;
import java.lang.annotation.Documented;


@Data

@Document(indexName = "users")
public class User {


    //private static final long serialVersionUID = -7817224776021728682L;

    @Id
    private Long id;
    private String firstName;
    private String lastName;

    public User() {}

    public User(Long id, String title, String content) {
        this.id = id;
        this.firstName = title;
        this.lastName = content;
    }
}
