package io.one_team.oneteam_rte_kt.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import io.one_team.oneteam_rte_kt.core.RichTextEditorView
import kotlinx.android.synthetic.main.toolbar_view.view.*

class Toolbar(context: Context, attr: AttributeSet?) : LinearLayout(context, attr) {
    var editor: RichTextEditorView? = null
    var listeners: List<OnClickListener> = listOf()

    init {
        LayoutInflater.from(context).inflate(R.layout.toolbar_view, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        imageButton.setOnClickListener { }
        fileButton.setOnClickListener { }
        h1Button.setOnClickListener { }
        h2Button.setOnClickListener { }
        h3Button.setOnClickListener { }
        h4Button.setOnClickListener { }
        h5Button.setOnClickListener { }
        boldButton.setOnClickListener { }
        italicButton.setOnClickListener { }
        codeButton.setOnClickListener { }
        quoteButton.setOnClickListener { }
        strikeThroughButton.setOnClickListener { }
        checkListButton.setOnClickListener { }
        listButton.setOnClickListener { }
        orderedListButton.setOnClickListener { }
        insertLinkButton.setOnClickListener { }
        removeLinkButton.setOnClickListener { }
        iframeButton.setOnClickListener { }
        codeBlockButton.setOnClickListener { }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        listeners.forEach { }
    }
}