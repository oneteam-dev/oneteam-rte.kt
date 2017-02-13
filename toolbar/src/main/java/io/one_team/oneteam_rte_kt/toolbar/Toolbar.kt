package io.one_team.oneteam_rte_kt.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import io.one_team.oneteam_rte_kt.core.BlockStyle
import io.one_team.oneteam_rte_kt.core.InlineStyle
import io.one_team.oneteam_rte_kt.core.RichTextEditorView
import kotlinx.android.synthetic.main.toolbar_view.view.*

class Toolbar(context: Context, attr: AttributeSet?) : LinearLayout(context, attr) {
    var editor: RichTextEditorView? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.toolbar_view, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        imageButton.setOnClickListener { }
        fileButton.setOnClickListener { }
        h1Button.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.Heading1) }
        h2Button.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.Heading2) }
        h3Button.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.Heading3) }
        h4Button.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.Heading4) }
        h5Button.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.Heading5) }
        boldButton.setOnClickListener { editor?.toggleInlineStyle(InlineStyle.Bold) }
        italicButton.setOnClickListener { editor?.toggleInlineStyle(InlineStyle.Italic) }
        codeButton.setOnClickListener { editor?.toggleInlineStyle(InlineStyle.Code) }
        quoteButton.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.Blockquote) }
        strikeThroughButton.setOnClickListener { editor?.toggleInlineStyle(InlineStyle.Strikethrough) }
        checkListButton.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.CheckableListItem) }
        listButton.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.UnorderedListItem) }
        orderedListButton.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.OrderedListItem) }
        insertLinkButton.setOnClickListener { }
        removeLinkButton.setOnClickListener { }
        iframeButton.setOnClickListener { }
        codeBlockButton.setOnClickListener { editor?.toggleBlockStyle(BlockStyle.CodeBlock) }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        imageButton.setOnClickListener(null)
        fileButton.setOnClickListener(null)
        h1Button.setOnClickListener(null)
        h2Button.setOnClickListener(null)
        h3Button.setOnClickListener(null)
        h4Button.setOnClickListener(null)
        h5Button.setOnClickListener(null)
        boldButton.setOnClickListener(null)
        italicButton.setOnClickListener(null)
        codeButton.setOnClickListener(null)
        quoteButton.setOnClickListener(null)
        strikeThroughButton.setOnClickListener(null)
        checkListButton.setOnClickListener(null)
        listButton.setOnClickListener(null)
        orderedListButton.setOnClickListener(null)
        insertLinkButton.setOnClickListener(null)
        removeLinkButton.setOnClickListener(null)
        iframeButton.setOnClickListener(null)
        codeBlockButton.setOnClickListener(null)
    }
}