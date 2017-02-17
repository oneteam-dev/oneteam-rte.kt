package io.one_team.oneteam_rte_kt.core

import org.junit.Assert.assertEquals
import org.junit.Test

class BlockStyleTest {
    @Test fun from_should_return_unstyled() {
        assertEquals(BlockStyle.from(BlockStyle.Unstyled.stringValue), BlockStyle.Unstyled)
    }

    @Test fun from_should_return_heading1() {
        assertEquals(BlockStyle.from(BlockStyle.Heading1.stringValue), BlockStyle.Heading1)
    }

    @Test fun from_should_return_heading2() {
        assertEquals(BlockStyle.from(BlockStyle.Heading2.stringValue), BlockStyle.Heading2)
    }

    @Test fun from_should_return_heading3() {
        assertEquals(BlockStyle.from(BlockStyle.Heading3.stringValue), BlockStyle.Heading3)
    }

    @Test fun from_should_return_heading4() {
        assertEquals(BlockStyle.from(BlockStyle.Heading4.stringValue), BlockStyle.Heading4)
    }

    @Test fun from_should_return_heading5() {
        assertEquals(BlockStyle.from(BlockStyle.Heading5.stringValue), BlockStyle.Heading5)
    }

    @Test fun from_should_return_block_quote() {
        assertEquals(BlockStyle.from(BlockStyle.Blockquote.stringValue), BlockStyle.Blockquote)
    }

    @Test fun from_should_return_ordered_list_item() {
        assertEquals(BlockStyle.from(BlockStyle.OrderedListItem.stringValue), BlockStyle.OrderedListItem)
    }

    @Test fun from_should_return_unordered_list_item() {
        assertEquals(BlockStyle.from(BlockStyle.UnorderedListItem.stringValue), BlockStyle.UnorderedListItem)
    }

    @Test fun from_should_return_checkable_list_item() {
        assertEquals(BlockStyle.from(BlockStyle.CheckableListItem.stringValue), BlockStyle.CheckableListItem)
    }

    @Test fun from_should_return_atomic() {
        assertEquals(BlockStyle.from(BlockStyle.Atomic.stringValue), BlockStyle.Atomic)
    }

    @Test fun from_should_return_code_block() {
        assertEquals(BlockStyle.from(BlockStyle.CodeBlock.stringValue), BlockStyle.CodeBlock)
    }
}
