package com.cinar.okan.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {


    //private static final long serialVersionUID = -7817224776021728682L;

    @Id
    private Long id;

    private String firstName;

    private String lastName;
}
