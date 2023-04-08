package dev.omergrn.movies.controllers;

import dev.omergrn.movies.model.response.ReviewResponse;
import dev.omergrn.movies.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping()
    public ResponseEntity<ReviewResponse> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<ReviewResponse>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")),
                                                  HttpStatus.OK);
    }

}