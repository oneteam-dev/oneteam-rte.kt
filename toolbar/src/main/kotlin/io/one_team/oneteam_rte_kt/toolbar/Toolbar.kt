package io.one_team.oneteam_rte_kt.toolbar

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageButton
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

    fun addOnClickImageButtonListener(listener: () -> Unit) {
        imageButton.setOnClickListener { listener() }
    }

    fun addOnClickInsertLinkButtonListener(listener: () -> Unit) {
        linkButton.setOnClickListener { listener() }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        headingButton.setOnClickListener {
            editor?.toggleBlockStyle(BlockStyle.Heading1)
        }

        boldButton.setOnClickListener {
            editor?.toggleInlineStyle(InlineStyle.Bold)
        }

        checkListButton.setOnClickListener {
            editor?.toggleBlockStyle(BlockStyle.CheckableListItem)
        }

        listButton.setOnClickListener {
            editor?.toggleBlockStyle(BlockStyle.UnorderedListItem)
        }

        orderedListButton.setOnClickListener {
            editor?.toggleBlockStyle(BlockStyle.OrderedListItem)
        }

        editor?.onInlineStylesChanged = {
            boldButton.toggleResourceWithState(
                    it.contains(InlineStyle.Bold),
                    R.drawable.ic_bold_active,
                    R.drawable.ic_bold
            )
        }

        editor?.onBlockStyleChanged = {
            headingButton.toggleResourceWithState(
                    it == BlockStyle.Heading1,
                    R.drawable.ic_h2_active,
                    R.drawable.ic_heading
            )
            checkListButton.toggleResourceWithState(
                    it == BlockStyle.CheckableListItem,
                    R.drawable.ic_checkbox_active,
                    R.drawable.ic_checkbox
            )
            listButton.toggleResourceWithState(
                    it == BlockStyle.UnorderedListItem,
                    R.drawable.ic_list_ul_active,
                    R.drawable.ic_list_ul
            )
            orderedListButton.toggleResourceWithState(
                    it == BlockStyle.OrderedListItem,
                    R.drawable.ic_list_ol_active,
                    R.drawable.ic_list_ol
            )
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        imageButton.setOnClickListener(null)
        headingButton.setOnClickListener(null)
        boldButton.setOnClickListener(null)
        checkListButton.setOnClickListener(null)
        listButton.setOnClickListener(null)
        orderedListButton.setOnClickListener(null)
        linkButton.setOnClickListener(null)
        editor?.onInlineStylesChanged = null
        editor?.onBlockStyleChanged = null
    }

    private fun ImageButton.toggleResourceWithState(isActive: Boolean, active: Int, normal: Int) {
        val resource = if (isActive) active else normal
        setImageResource(resource)
    }
}