package com.ing;

import org.junit.Test;

public class AssertionsTest {

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; 
    }

}
