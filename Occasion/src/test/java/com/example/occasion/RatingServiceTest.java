package com.example.occasion;

import com.example.occasion.Model.MyService;
import com.example.occasion.Model.Myorder;
import com.example.occasion.Model.Rating;
import com.example.occasion.Repostiroy.MyServiceRepository;
import com.example.occasion.Repostiroy.MyorderRepository;
import com.example.occasion.Repostiroy.RatingRepository;
import com.example.occasion.Service.MyServiceService;
import com.example.occasion.Service.RatingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class RatingServiceTest {
    @InjectMocks
    RatingService ratingService;


    @Mock
    MyorderRepository myorderRepository;
    @Mock
    RatingRepository ratingRepository;

    Rating rating;

    Rating rating1, rating2, rating3;

    List<Rating> ratingList;

    @BeforeEach
    void setUp() {
        rating = new Rating(null,"5",4.55,null);
        rating1 = new Rating(null,"7",3.55,null);
        rating2 = new Rating(null,"4",2.55,null);
        rating3 = new Rating(null,"2",4.00,null);

        ratingList = new ArrayList<>();

        ratingList.add(rating1);
        ratingList.add(rating2);
        ratingList.add(rating3);
    }
    @Test
    public void getRating(){
        when(ratingRepository.findAll()).thenReturn(ratingList);
        List<Rating> ratingList=ratingService.getAll();
        Assertions.assertEquals(ratingList,ratingList);
        Assertions.assertEquals(3,ratingList.size());
    }

    @Test
    public void deleteMyService(){
        when(ratingRepository.findRatingById(rating1.getId())).thenReturn(rating1);
        ratingService.deleteRating(rating1.getId());
        verify(ratingRepository,times(1)).findRatingById(rating1.getId());
    }

}
