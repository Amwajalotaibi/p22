package com.example.occasion.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RatingDTO {
    private Integer myOrder_id;

    @NotEmpty(message = "Content is my order")
    @Column(columnDefinition = "varchar(70) not empty")
    private String content;


    @NotNull(message = "Rating is My order")
    @Positive
    @Min(value=1)
    @Max(value = 5)
    private Double rating;

    }

