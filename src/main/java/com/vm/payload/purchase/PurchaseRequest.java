package com.vm.payload.purchase;

import com.vm.enums.PaymentType;
import com.vm.payload.vending.VendingMachineRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "자판기 구매 요청", example = """
    {
      "paymentType": "CASH",
      "cashInputs": [
        {
          "cashType": "WON_1000",
          "quantity": 2
        },
        {
          "cashType": "WON_500",
          "quantity": 2
        }
      ],
      "items": [
        {
          "item": "COLA",
          "drinkQuantity": 2
        },
        {
          "item": "WATER",
          "drinkQuantity": 1
        }
      ]
    }
    """)
public record PurchaseRequest(

    @Schema(description = "결제 수단", defaultValue = "CARD", example = "CARD")
    PaymentType paymentType,

    @Schema(description = "현금 투입")
    List<CashInput> cashInputs,

    @Schema(description = "구매할 음료 목록")
    List<VendingMachineRequest> items) {

}
