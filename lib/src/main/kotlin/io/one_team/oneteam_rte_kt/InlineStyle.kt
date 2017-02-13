package io.one_team.oneteam_rte_kt

sealed class InlineStyle {
    abstract val stringValue: String

    class Bold : InlineStyle() { override val stringValue = "BOLD" }
    class Italic : InlineStyle() { override val stringValue =  "ITALIC" }
    class Strikethrough : InlineStyle() { override val stringValue = "STRIKETHROUGH" }
}