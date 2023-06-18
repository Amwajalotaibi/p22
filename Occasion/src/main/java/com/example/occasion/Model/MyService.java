package com.example.occasion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MyService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


//    @NotEmpty(message = "name should be not null")
//    @Column(columnDefinition = "varchar(10)")
    private String name;

//     @NotEmpty(message = "category should not null")
//     @Pattern(regexp = "(?:bigparty|mediumparty|smallparty)",message = "Category Not Valid")
//     @Column(columnDefinition = "varchar(20) (category='bigparty' or category='mediumparty' or category='smallparty' )")
    private String category;




    @ManyToOne
    @JoinColumn(name = "myOrder_id")
    @JsonIgnore
    private Myorder myOrder;


    @ManyToMany (mappedBy = "myServiceSet")
    @JsonIgnore
    private Set<Company> companySet;


    @OneToOne(cascade =CascadeType.ALL,mappedBy = "myService")
    @PrimaryKeyJoinColumn
    private Servicetype servicetype;
}
