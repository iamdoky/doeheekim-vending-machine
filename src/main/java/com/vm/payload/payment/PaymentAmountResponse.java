package com.vm.payload.payment;

import io.swagger.v3.oas.annotations.media.Schema;

public record PaymentAmountResponse(

    @Schema(description = "결제금액", defaultValue = "5000", example = "5000")
    int amount) {

    public static PaymentAmountResponse from(int amount) {

        return new PaymentAmountResponse(amount);
    }
}
