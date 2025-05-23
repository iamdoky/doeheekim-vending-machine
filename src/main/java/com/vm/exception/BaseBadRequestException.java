package com.vm.exception;

import com.vm.enums.Errors;
import org.springframework.http.HttpStatus;

/**
 * 잘못된 요청 예외
 */
public class BaseBadRequestException extends BaseRuntimeException {

    public BaseBadRequestException(String message) {
        super(message);
    }

    public BaseBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseBadRequestException(Errors errors) {
        super(errors, HttpStatus.BAD_REQUEST);
    }
}
