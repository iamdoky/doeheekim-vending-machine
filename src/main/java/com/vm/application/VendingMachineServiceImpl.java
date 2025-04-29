package com.vm.application;

import com.vm.enums.Drink;
import com.vm.enums.Errors;
import com.vm.enums.PaymentType;
import com.vm.exception.BaseBadRequestException;
import com.vm.payload.payment.PaymentAmountResponse;
import com.vm.payload.purchase.PurchaseRequest;
import com.vm.payload.purchase.PurchaseResponse;
import com.vm.payload.vending.VendingMachineResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendingMachineServiceImpl implements VendingMachineService {

    public List<VendingMachineResponse> getVendingMachine() {

        return VendingMachineResponse.drinkMockList();
    }

    public PaymentAmountResponse select(Drink item) {

        return PaymentAmountResponse.from(item.getPrice());
    }

    public PurchaseResponse purchase(PurchaseRequest request) {

        if (PaymentType.CARD.equals(request.paymentType()))
            return PurchaseResponse.from(purchaseByCard());

        if (PaymentType.CASH.equals(request.paymentType()))
            return PurchaseResponse.from(purchaseByCash(request));

        return PurchaseResponse.from(0);
    }

    private int purchaseByCard() {

        // 카드 잔액 확인 및 결제 처리 로직 필요
        return 0;
    }

    private int purchaseByCash(PurchaseRequest request) {

        int inputCash = request.cashInputs().stream()
            .mapToInt(cashInput -> cashInput.cashType().getAmount() * cashInput.quantity())
            .sum();

        int amount = request.item().getPrice();

        if (inputCash < amount)
            throw new BaseBadRequestException(Errors.INSUFFICIENT_PAYMENT_AMOUNT);

        return inputCash - amount;
    }
}
