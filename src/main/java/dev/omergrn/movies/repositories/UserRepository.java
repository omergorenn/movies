package dev.omergrn.movies.repositories;

import dev.omergrn.movies.model.Movie;
import dev.omergrn.movies.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Id> {
    Optional<User> findByUsername(String username);
    Optional<Movie> findByUserId(String userId);

}


