package io.one_team.oneteam_rte_kt.core

sealed class InlineStyle {
    abstract val stringValue: String

    object Bold : InlineStyle() { override val stringValue = "BOLD" }
    object Italic : InlineStyle() { override val stringValue =  "ITALIC" }
    object Strikethrough : InlineStyle() { override val stringValue = "STRIKETHROUGH" }
    object Code : InlineStyle() { override val stringValue = "CODE" }

    companion object {
        fun from(value: String): InlineStyle? = when (value) {
            Bold.stringValue -> Bold
            Italic.stringValue -> Italic
            Strikethrough.stringValue -> Strikethrough
            Code.stringValue -> Code
            else -> null
        }
    }
}