package io.one_team.oneteam_rte_kt.core

sealed class BlockStyle {
    abstract val stringValue: String

    object Unstyled : BlockStyle() { override val stringValue = "unstyled" }
    object Heading1 : BlockStyle() { override val stringValue = "header-one" }
    object Heading2 : BlockStyle() { override val stringValue = "header-two" }
    object Heading3 : BlockStyle() { override val stringValue = "header-three" }
    object Heading4 : BlockStyle() { override val stringValue = "header-four" }
    object Heading5 : BlockStyle() { override val stringValue = "header-five" }
    object Blockquote : BlockStyle() { override val stringValue = "blockquote" }
    object OrderedListItem : BlockStyle() { override val stringValue = "ordered-list-item" }
    object UnorderedListItem : BlockStyle() { override val stringValue = "unordered-list-item" }
    object CheckableListItem : BlockStyle() { override val stringValue = "checkable-list-item" }
    object Atomic : BlockStyle() { override val stringValue = "atomic" }
    object CodeBlock: BlockStyle() { override val stringValue = "code-block" }

    companion object {
        fun from(value: String): BlockStyle? = when (value) {
            Unstyled.stringValue -> Unstyled
            Heading1.stringValue -> Heading1
            Heading2.stringValue -> Heading2
            Heading3.stringValue -> Heading3
            Heading4.stringValue -> Heading4
            Heading5.stringValue -> Heading5
            Blockquote.stringValue -> Blockquote
            OrderedListItem.stringValue -> OrderedListItem
            UnorderedListItem.stringValue -> UnorderedListItem
            CheckableListItem.stringValue -> CheckableListItem
            Atomic.stringValue -> Atomic
            CodeBlock.stringValue -> CodeBlock
            else -> null
        }
    }
}