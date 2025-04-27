package com.vm.exception;

import com.vm.enums.Errors;
import org.springframework.http.HttpStatus;

/**
 * 잘못된 인자 예외
 */
public class BaseIllegalArgumentException extends BaseRuntimeException {

    public BaseIllegalArgumentException(String message) {
        super(message);
    }

    public BaseIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseIllegalArgumentException(Errors errors) {
        super(errors, HttpStatus.BAD_REQUEST);
    }

    public BaseIllegalArgumentException(Errors errors, String message) {
        super(errors, message, HttpStatus.BAD_REQUEST);
    }
}
