package dev.omergrn.movies.model.response;

import dev.omergrn.movies.exception.message.ExceptionMessage;

import java.time.LocalDateTime;

public record ErrorResponse(ExceptionMessage message, LocalDateTime occuredAt) {

}