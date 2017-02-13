package io.one_team.oneteam_rte_kt

sealed class BlockStyle {
    abstract val stringValue: String

    class Unstyled : BlockStyle() { override val stringValue = "unstyled" }
    class Heading1 : BlockStyle() { override val stringValue = "header-one" }
    class Heading2 : BlockStyle() { override val stringValue = "header-two" }
    class Heading3 : BlockStyle() { override val stringValue = "header-three" }
    class Heading4 : BlockStyle() { override val stringValue = "header-four" }
    class Heading5 : BlockStyle() { override val stringValue = "header-five" }
    class Blockquote : BlockStyle() { override val stringValue = "blockquote" }
    class OrderedListItem : BlockStyle() { override val stringValue = "ordered-list-item" }
    class UnorderedListItem : BlockStyle() { override val stringValue = "unordered-list-item" }
    class CheckableListItem : BlockStyle() { override val stringValue = "checkable-list-item" }
    class Atomic : BlockStyle() { override val stringValue = "atomic" }
}