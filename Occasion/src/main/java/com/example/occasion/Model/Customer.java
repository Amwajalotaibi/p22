package com.example.occasion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


//    @NotEmpty(message = "Name should be not null")
//    @Column(columnDefinition = "varchar(10)")
    private String UserName;


//    @NotEmpty(message = "phoneNumber should be not null")
//    @Column(columnDefinition = "varchar(10)")
//    @Positive
    private String phoneNumber;



    @NotEmpty(message = "email should be not null")
    @Column(columnDefinition = "varchar(20)")
    @Email(message = "Invalid Email",regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
     private String Email;



    @NotEmpty(message = "password should be not null")
    @Column(columnDefinition = "varchar(10)")
    private String password;


    private boolean loyalty = false;


    private Integer numberOfVisit=0;



    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser myUser;


    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "customer")
    @JsonIgnore
    private Set<Myorder> myOrderSet;

}
