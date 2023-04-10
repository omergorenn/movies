package dev.omergrn.movies.controllers;

import dev.omergrn.movies.model.Movie;
import dev.omergrn.movies.services.UserService;
import dev.omergrn.movies.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userDetailsService;


    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<List<User>>(userDetailsService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<Movie>> getUser(@PathVariable String  userId){
        return new ResponseEntity<Optional<Movie>>(userDetailsService.singleUser(userId),HttpStatus.OK);}


}
