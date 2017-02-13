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
}