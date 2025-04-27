package com.vm.payload.purchase;

import io.swagger.v3.oas.annotations.media.Schema;

public record PurchaseResponse(

    @Schema(name = "잔돈", defaultValue = "300", example = "300")
    int changeAmount) {

    public static PurchaseResponse from(int changeAmount) {
        return new PurchaseResponse(changeAmount);
    }
}
