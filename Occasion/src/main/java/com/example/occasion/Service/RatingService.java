package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.DTO.CustomerDTO;
import com.example.occasion.DTO.RatingDTO;
import com.example.occasion.Model.*;
import com.example.occasion.Repostiroy.CustomerRepository;
import com.example.occasion.Repostiroy.MyorderRepository;
import com.example.occasion.Repostiroy.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final MyorderRepository myorderRepository;
    private final CustomerRepository customerRepository;

    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    public void addRating(MyUser myUser,RatingDTO dto) {
        Myorder myorder = myorderRepository.findMyOrderById(dto.getMyOrder_id());
        Customer customer=myorder.getCustomer();
        Customer customer1=myUser.getCustomer();
        if (customer1 != customer) {
            throw new ApiException("sorry you can't ");
        }
        Rating rating = new Rating(null, dto.getContent(), dto.getRating(),myorder);
        ratingRepository.save(rating);
    }


    public void updateRating(RatingDTO dto,Integer id) {
        Myorder myorder = myorderRepository.findMyOrderById(id);
        if (myorder == null) {
            throw new ApiException("MyOrder not found");
        }

        Rating rating = ratingRepository.getReferenceById(dto.getMyOrder_id());
        rating.setContent(dto.getContent());
        rating.setRating(dto.getRating());
    }

    public void deleteRating(Integer id) {
        Rating rating = ratingRepository.findRatingById(id);
        if (rating == null) {
            throw new ApiException("Not found");
        }
        ratingRepository.delete(rating);
    }

    }

