package com.vm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Drink {

    COLA("콜라", 1100),
    WATER("물", 600),
    COFFEE("커피", 700);

    private final String displayName;
    private final int price;
}
