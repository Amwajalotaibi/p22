package com.example.occasion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Myorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



//    @NotEmpty(message = "day should be not null")
//    @Column(columnDefinition = "varchar(100)")
    private Integer day;


//    @NotEmpty(message = "data should  be not null")
//    @Column(columnDefinition = "varchar(100)")
    private String date;



//    @NotEmpty(message = "time should be not null")
//    @Column(columnDefinition = "varchar(100)")
    private String time;


//    @NotNull(message = "totalPrice should be not null")
    private Integer totalPrice;



//    @NotEmpty(message = "stutas should be not null ")
//    @Column(columnDefinition = "varchar(100)")
    private String stutas;



//    @NotEmpty(message = "category should be not null ")
//    @Column(columnDefinition = "varchar(100) check(category='daily' or category='weekly' or category='monthly')")
    private String category;



//    @NotNull(message = "totalPrice should be not null")
    private Integer numbarofrepeat;


//    private LocalDateTime createAt;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;


    @ManyToOne
    @JoinColumn(name = "myService_id")
    @JsonIgnore
    private MyService myService;


    @OneToOne(cascade =CascadeType.ALL,mappedBy = "myOrder")
    @PrimaryKeyJoinColumn
    private Rating rating;

}
