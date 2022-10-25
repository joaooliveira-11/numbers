package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    Integer testnumber;
    Integer divisor = 3;
    boolean res;
    DivisibleByFilter filter;
    @BeforeEach
    public void helper() {
        testnumber = 10;
        filter = new DivisibleByFilter(divisor);
    }
    @Test
    public void Accept() {
        res = filter.accept(testnumber);
        Assertions.assertEquals(false,res);
    }
}

