package com.example.occasion.Controller;

import com.example.occasion.DTO.RatingDTO;
import com.example.occasion.Model.MyUser;
import com.example.occasion.Model.Rating;
import com.example.occasion.Service.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rating")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(ratingService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addRating(@Valid @RequestBody RatingDTO ratingDTO, @AuthenticationPrincipal MyUser myUser){
        ratingService.addRating(myUser,ratingDTO);
        return ResponseEntity.status(200).body("Rating added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRating(@Valid @RequestBody RatingDTO ratingDTO,@PathVariable Integer id){
        ratingService.updateRating(ratingDTO, id);
        return ResponseEntity.status(200).body("Rating updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRating(@PathVariable Integer id){
        ratingService.deleteRating(id);
        return ResponseEntity.status(200).body("Rating deleted");
    }

}
