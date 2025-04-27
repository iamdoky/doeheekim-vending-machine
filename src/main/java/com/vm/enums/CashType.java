package com.vm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CashType {

    WON_100(100),
    WON_500(500),
    WON_1000(1000),
    WON_5000(5000),
    WON_10000(10000);

    private final int amount;
}
