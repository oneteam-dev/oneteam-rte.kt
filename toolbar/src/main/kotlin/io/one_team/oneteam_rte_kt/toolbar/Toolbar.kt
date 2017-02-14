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
        imageButton.setOnClickListener {
            listener()
            imageButton.toggleResourceWithState(imageButton.isPressed, R.drawable.ic_photo_active, R.drawable.ic_photo)
        }
    }

    fun addOnClickInsertLinkButtonListener(listener: () -> Unit) {
        linkButton.setOnClickListener {
            listener()
            linkButton.toggleResourceWithState(linkButton.isPressed, R.drawable.ic_links_active, R.drawable.ic_links)
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        headingButton.setOnClickListener {
            editor?.toggleBlockStyle(BlockStyle.Heading1)
            headingButton.toggleResourceWithState(headingButton.isPressed, R.drawable.ic_h2_active, R.drawable.ic_heading)
        }

        boldButton.setOnClickListener {
            editor?.toggleInlineStyle(InlineStyle.Bold)
            boldButton.toggleResourceWithState(boldButton.isPressed, R.drawable.ic_bold_active, R.drawable.ic_bold)
        }

        checkListButton.setOnClickListener {
            editor?.toggleBlockStyle(BlockStyle.CheckableListItem)

            checkListButton.toggleResourceWithState(checkListButton.isPressed, R.drawable.ic_checkbox_active, R.drawable.ic_checkbox)
        }

        listButton.setOnClickListener {
            editor?.toggleBlockStyle(BlockStyle.UnorderedListItem)
            listButton.toggleResourceWithState(listButton.isPressed, R.drawable.ic_list_ul_active, R.drawable.ic_list_ul)
        }

        orderedListButton.setOnClickListener {
            editor?.toggleBlockStyle(BlockStyle.OrderedListItem)
            orderedListButton.toggleResourceWithState(orderedListButton.isPressed, R.drawable.ic_list_ol_active, R.drawable.ic_list_ol)
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
    }

    private fun ImageButton.toggleResourceWithState(isActive: Boolean, active: Int, normal: Int) {
        val resource = if (isActive) active else normal
        setImageResource(resource)
    }
}