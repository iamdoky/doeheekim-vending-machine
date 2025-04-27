package com.vm.payload.purchase;

import com.vm.enums.CashType;
import io.swagger.v3.oas.annotations.media.Schema;

public record CashInput(

    @Schema(description = "투입한 현금 종류", defaultValue = "WON_500", example = "WON_500")
    CashType cashType,

    @Schema(description = "투입한 현금 개수", defaultValue = "5", example = "5")
    int quantity) {

}
