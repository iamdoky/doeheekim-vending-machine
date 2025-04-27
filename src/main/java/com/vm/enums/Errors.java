package com.vm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {

    BAD_REQUEST(1000, "잘못된 요청입니다."),
    INSUFFICIENT_PAYMENT_AMOUNT(1001, "결제 금액이 부족합니다."),
    INTERNAL_SERVER_ERROR(9999, "요청을 처리하던 중 예상하지 못한 오류가 발생했습니다.");

    private final int code;
    private final String message;

    public String getCodeMessage() {

        return String.format("%s, %s", this.code, this.message);
    }
}
