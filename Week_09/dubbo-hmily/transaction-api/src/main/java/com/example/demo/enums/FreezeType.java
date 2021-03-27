package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FreezeType {
    IN((byte)1),
    OUT((byte)2);

    private byte val;
}
