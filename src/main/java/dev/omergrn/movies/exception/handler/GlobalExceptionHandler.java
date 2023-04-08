package dev.omergrn.movies.exception.handler;

import dev.omergrn.movies.exception.base.BaseException;
import dev.omergrn.movies.exception.message.ExceptionMessage;
import dev.omergrn.movies.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    private ResponseEntity<ErrorResponse> handle(BaseException exception) {

        log.error("Error occurred. Error: ", exception);

        return new ResponseEntity<>(new ErrorResponse(exception.getExceptionMessage(), LocalDateTime.now()),
                                    exception.getExceptionMessage().getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> handle(Exception exception) {

        log.error("Error occurred. Error: ", exception);

        return new ResponseEntity<>(new ErrorResponse(ExceptionMessage.UNKNOWN_EXCEPTION, LocalDateTime.now()),
                                    ExceptionMessage.UNKNOWN_EXCEPTION.getErrorCode());
    }

}