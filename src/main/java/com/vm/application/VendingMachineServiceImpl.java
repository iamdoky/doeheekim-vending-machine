package com.vm.application;

import com.vm.enums.Errors;
import com.vm.enums.PaymentType;
import com.vm.exception.BaseBadRequestException;
import com.vm.payload.payment.PaymentAmountResponse;
import com.vm.payload.purchase.CashInput;
import com.vm.payload.purchase.PurchaseRequest;
import com.vm.payload.purchase.PurchaseResponse;
import com.vm.payload.vending.VendingMachineRequest;
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

    public PaymentAmountResponse totalAmount(List<VendingMachineRequest> requests) {

        return PaymentAmountResponse.from(
            requests.stream()
                .mapToInt(VendingMachineRequest::calculateAmount)
                .sum()
        );
    }

    public PurchaseResponse purchase(PurchaseRequest request) {

        if (PaymentType.CARD.equals(request.paymentType()))
            return PurchaseResponse.from(purchaseByCard(request));

        if (PaymentType.CASH.equals(request.paymentType()))
            return PurchaseResponse.from(purchaseByCash(request));

        return PurchaseResponse.from(0);
    }

    private int purchaseByCard(PurchaseRequest request) {

        return request.items().stream()
            .mapToInt(VendingMachineRequest::calculateAmount)
            .sum();
    }

    private int purchaseByCash(PurchaseRequest request) {

        int inputCash = request.cashInputs().stream()
            .mapToInt(cashInput -> cashInput.cashType().getAmount() * cashInput.quantity())
            .sum();

        int amount = request.items().stream()
            .mapToInt(VendingMachineRequest::calculateAmount)
            .sum();

        if (inputCash < amount)
            throw new BaseBadRequestException(Errors.INSUFFICIENT_PAYMENT_AMOUNT);

        return inputCash - amount;
    }
}
