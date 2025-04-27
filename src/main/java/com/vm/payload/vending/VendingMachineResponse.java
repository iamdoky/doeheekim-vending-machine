package com.vm.payload.vending;

import com.vm.enums.Drink;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;

@Builder
public record VendingMachineResponse(

    @Schema(description = "상품", defaultValue = "COLA", example = "COLA")
    Drink item,

    @Schema(description = "재고", defaultValue = "25", example = "25")
    int inventory,

    @Schema(description = "가격", defaultValue = "1100", example = "1100")
    int price) {

    public static List<VendingMachineResponse> drinkMockList() {

        return List.of(
            VendingMachineResponse.builder()
                .item(Drink.COLA)
                .price(Drink.COLA.getPrice())
                .inventory(50)
                .build(),
            VendingMachineResponse.builder()
                .item(Drink.COFFEE)
                .price(Drink.COFFEE.getPrice())
                .inventory(0)
                .build(),
            VendingMachineResponse.builder()
                .item(Drink.WATER)
                .price(Drink.WATER.getPrice())
                .inventory(25)
                .build()
        );
    }
}
