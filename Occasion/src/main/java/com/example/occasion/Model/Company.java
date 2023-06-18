package com.example.occasion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



//    @NotEmpty(message = "Name should be not null")
//    @Column(columnDefinition = "varchar(50)")
    private String UserName;



//    @NotEmpty(message = "password should be not null ")
//    @Column(columnDefinition = "varchar")
    private String password;



//    @NotEmpty(message = "licensenumber should be not null")
//    @Column(columnDefinition = "varchar(50)")
    private String licensenumber;



//    @NotEmpty(message = "city should be not null ")
//    @Column(columnDefinition = "varchar(50)")
    private String city;


//    @NotEmpty(message = "timecatgory should be not null ")
   // @Column(columnDefinition = "varchar(50) check(timecatgory='available' or timecatgory='busy')")
    private String timecatgory;

//    @NotEmpty(message = "rating can't be empty")
////    @Column(columnDefinition = "varchar(20) not null")
//    private String rating;

//    @NotNull(message = "price can't be Null")
//    @Min(3)
//    @Max(50)
//    @Column(columnDefinition = "int not null")
//    private Integer Price;



    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser myUser;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    @JsonIgnore
    private Set<Myorder> myOrderSet;


    @ManyToMany
    @JsonIgnore
    @JoinColumn(name = "company_id")
    private Set<MyService> myServiceSet;
 }



