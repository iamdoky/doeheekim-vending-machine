package com.vm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {

    CASH("현금"),
    CARD("카드");

    private final String type;
}
