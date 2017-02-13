package io.one_team.oneteam_rte_kt.core

sealed class InlineStyle {
    abstract val stringValue: String

    object Bold : InlineStyle() { override val stringValue = "BOLD" }
    object Italic : InlineStyle() { override val stringValue =  "ITALIC" }
    object Strikethrough : InlineStyle() { override val stringValue = "STRIKETHROUGH" }
    object Code : InlineStyle() { override val stringValue = "CODE" }
}