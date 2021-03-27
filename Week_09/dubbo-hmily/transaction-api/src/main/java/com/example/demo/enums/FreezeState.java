package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FreezeState {
    PRE((byte)1),
    CONFIRM((byte)2),
    CANCEL((byte)3);

    private byte val;
}
