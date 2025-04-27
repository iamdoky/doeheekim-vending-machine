package com.vm.exception;

import com.vm.enums.Errors;
import com.vm.payload.common.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> BadRequestExceptionHandler(BindException e) {

        log.error("잘못된 인자 오류가 발생했습니다.", e);
        return ErrorResponse.toResponseEntity(HttpStatus.BAD_REQUEST, Errors.BAD_REQUEST);
    }

    @ExceptionHandler(BaseRuntimeException.class)
    public ResponseEntity<ErrorResponse> BaseRunTimeExceptionHandler(BaseRuntimeException e) {

        log.error("런타임 오류가 발생했습니다.", e);
        return ErrorResponse.toResponseEntity(e);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> ThrowableHandler(Throwable t) {

        log.error("요청을 처리하던 중 예상하지 못한 오류가 발생했습니다.", t);

        return ErrorResponse.toResponseEntity(
            HttpStatus.INTERNAL_SERVER_ERROR,
            Errors.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {
        BeanInstantiationException.class,
        MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<ErrorResponse> beanInstantiationExceptionHandler(Throwable t) {

        log.error(t.getCause().getMessage(), t);
        return ErrorResponse.toResponseEntity(
            HttpStatus.BAD_REQUEST,
            Errors.BAD_REQUEST);
    }
}
