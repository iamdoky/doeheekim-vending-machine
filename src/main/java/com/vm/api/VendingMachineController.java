package com.vm.api;

import com.vm.application.VendingMachineService;
import com.vm.payload.payment.PaymentAmountResponse;
import com.vm.payload.purchase.PurchaseRequest;
import com.vm.payload.purchase.PurchaseResponse;
import com.vm.payload.vending.VendingMachineRequest;
import com.vm.payload.vending.VendingMachineResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/vending-machine")
public class VendingMachineController {

    private final VendingMachineService vendingMachineService;

    @Tag(name = "[자판기] 음료 재고")
    @Operation(
        description = "음료별 재고 상태 조회 API",
        responses = {@ApiResponse(responseCode = "200", description = "OK")})
    @GetMapping("inventory")
    public ResponseEntity<List<VendingMachineResponse>> inventory() {

        return ResponseEntity.ok(vendingMachineService.getVendingMachine());
    }

    @Tag(name = "[자판기] 음료 선택")
    @Operation(
        description = "선택 음료 결제 금액 API",
        responses = {@ApiResponse(responseCode = "200", description = "OK")})
    @GetMapping("amount")
    public ResponseEntity<PaymentAmountResponse> totalAmount(List<VendingMachineRequest> requests) {

        return ResponseEntity.ok(vendingMachineService.totalAmount(requests));
    }

    @Tag(name = "[자판기] 음료 구매")
    @Operation(
        description = "음료 결제 API",
        responses = {@ApiResponse(responseCode = "200", description = "OK")})
    @PostMapping()
    public ResponseEntity<PurchaseResponse> purchase(@RequestBody PurchaseRequest request) {

        return ResponseEntity.ok(vendingMachineService.purchase(request));
    }
}
