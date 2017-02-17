package io.one_team.oneteam_rte_kt.core

import org.junit.Assert.assertEquals
import org.junit.Test

class InlineStyleTest {
    @Test fun from_should_return_bold() {
        assertEquals(InlineStyle.from(InlineStyle.Bold.stringValue), InlineStyle.Bold)
    }

    @Test fun from_should_return_italic() {
        assertEquals(InlineStyle.from(InlineStyle.Italic.stringValue), InlineStyle.Italic)
    }

    @Test fun from_should_return_strike_through() {
        assertEquals(InlineStyle.from(InlineStyle.Strikethrough.stringValue), InlineStyle.Strikethrough)
    }

    @Test fun from_should_return_code() {
        assertEquals(InlineStyle.from(InlineStyle.Code.stringValue), InlineStyle.Code)
    }
}