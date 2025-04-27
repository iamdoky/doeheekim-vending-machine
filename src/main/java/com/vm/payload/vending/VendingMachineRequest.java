package com.vm.payload.vending;

import com.vm.enums.Drink;
import io.swagger.v3.oas.annotations.media.Schema;

public record VendingMachineRequest(

    @Schema(description = "상품", defaultValue = "COLA", example = "COLA")
    Drink item,

    @Schema(description = "개수", defaultValue = "2", example = "2")
    int drinkQuantity) {

    public int calculateAmount() {

        return this.item.getPrice() * this.drinkQuantity;
    }
}
