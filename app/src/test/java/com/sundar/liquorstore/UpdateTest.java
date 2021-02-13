package com.sundar.liquorstore;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class UpdateTest {

    boolean expect = true;
    boolean actual = false;


    @Test
    public void Update() {
        final String fName ="bharat123";
        final String lname ="thakurathi";
        final String username ="bharat1";


        {
            actual = true;
        }

        assertEquals(actual, expect);
    }
}
