package dev.omergrn.movies.exception.message;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    REVIEW_NOT_FOUND_EXCEPTION("Review Not Found", "Review.not.found", HttpStatus.NOT_FOUND),
    MOVIE_NOT_FOUND_EXCEPTION("MOVIE Not Found", "movie.not.found", HttpStatus.NOT_FOUND),
    UNKNOWN_EXCEPTION("Unknown Error Occurred", "unknown.exception", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;

    private final String errorName;

    private final HttpStatus errorCode;
}