package dev.omergrn.movies.services;

import dev.omergrn.movies.model.Movie;
import dev.omergrn.movies.model.Review;
import dev.omergrn.movies.model.response.ReviewResponse;
import dev.omergrn.movies.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;

    private final MongoTemplate mongoTemplate;

    public ReviewResponse createReview(String reviewBody, String imdbId) {
        var review = repository.save(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));
        mongoTemplate.update(Movie.class)
                     .matching(Criteria.where("imdbId").is(imdbId))
                     .apply(new Update().push("reviews").value(review))
                     .first();
        return new ReviewResponse(review.getBody(), review.getCreated());
    }
}