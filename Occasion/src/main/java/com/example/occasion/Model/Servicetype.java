package com.example.occasion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicetype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty(message = "name should be not null")
//    @Pattern(regexp = "(?:staff|eat|coordination)",message = "Category Not Valid")
//    @Column(columnDefinition = "varchar(20) check (name='staff' or name='eat' or name='coordination')")
    private String name;

//    @NotEmpty (message = "Content should be not null")
//    @Column(columnDefinition = "varchar(20)")
    private String details;

//    @NotNull(message = "price can't be Null")
//    @Min(3)
//    @Max(1000)
//    @Column(columnDefinition = "int not null")
    private Integer price;




    @OneToOne
    @MapsId
    @JsonIgnore
    private MyService myService;
}
