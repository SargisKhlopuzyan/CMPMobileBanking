package com.sargis.khlopuzyan.designsystem.util

import com.sargis.khlopuzyan.designsystem.unit.formatAsAmount
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberFormatterTest {

    @Test
    fun format_examples_match_expected_output() {
        assertEquals("1.00", 1.0.formatAsAmount())
        assertEquals("10.00", 10.0.formatAsAmount())
        assertEquals("100.00", 100.00.formatAsAmount())
        assertEquals("1,000.00", 1000.0.formatAsAmount())
        assertEquals("100,000.00", 100000.0.formatAsAmount())
        assertEquals("1,000,000.00", 1000000.0.formatAsAmount())
    }

    @Test
    fun format_rounds_to_two_decimals() {
        assertEquals("1.24", 1.235.formatAsAmount())
        assertEquals("1.23", 1.234.formatAsAmount())
    }

    @Test
    fun format_supports_negative_values() {
        assertEquals("-10.50", (-10.5).formatAsAmount())
    }
}

