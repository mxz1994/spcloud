package com.mxz.service;

import org.springframework.stereotype.Service;

@Service
public class MathCalactor {

    public <T extends Number> T div(T x, T y) {
        return x;
    }
}
