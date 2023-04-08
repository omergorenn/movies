package dev.omergrn.movies.exception.base;

import dev.omergrn.movies.exception.message.ExceptionMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseException extends RuntimeException{
    protected final ExceptionMessage exceptionMessage;

}
