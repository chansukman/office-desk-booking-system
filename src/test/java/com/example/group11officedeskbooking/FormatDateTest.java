package com.example.group11officedeskbooking;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FormatDateTest {


    private static DateFormatter prettyDate;

    @BeforeAll
    public static void before(){
        prettyDate = new DateFormatter();
    }

    @Test
    public void whenFormatDateThenProvideFormattedString(){
        assertEquals("Friday 31st Dec 2021", prettyDate.formatDate("2021-12-31"));
        assertEquals("Saturday 1st Jan 2022", prettyDate.formatDate("2022-01-01"));
        assertEquals("Friday 22nd Apr 2022", prettyDate.formatDate("2022-04-22"));
    }



}
