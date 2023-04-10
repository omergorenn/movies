package dev.omergrn.movies.services;

import dev.omergrn.movies.model.Movie;
import dev.omergrn.movies.model.User;
import dev.omergrn.movies.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> allUsers(){
        return userRepository.findAll();
    }
    public Optional<Movie> singleUser(String userId){
        return userRepository.findByUserId(userId);
    }
}
