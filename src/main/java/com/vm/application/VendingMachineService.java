package com.vm.application;

import com.vm.enums.Drink;
import com.vm.payload.payment.PaymentAmountResponse;
import com.vm.payload.purchase.PurchaseRequest;
import com.vm.payload.purchase.PurchaseResponse;
import com.vm.payload.vending.VendingMachineResponse;
import java.util.List;

public interface VendingMachineService {

    List<VendingMachineResponse> getVendingMachine();

    PaymentAmountResponse select(Drink item);

    PurchaseResponse purchase(PurchaseRequest request);
}
