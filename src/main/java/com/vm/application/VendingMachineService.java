package com.vm.application;

import com.vm.payload.payment.PaymentAmountResponse;
import com.vm.payload.purchase.PurchaseRequest;
import com.vm.payload.purchase.PurchaseResponse;
import com.vm.payload.vending.VendingMachineRequest;
import com.vm.payload.vending.VendingMachineResponse;
import java.util.List;

public interface VendingMachineService {

    List<VendingMachineResponse> getVendingMachine();

    PaymentAmountResponse totalAmount(List<VendingMachineRequest> requests);

    PurchaseResponse purchase(PurchaseRequest request);
}
