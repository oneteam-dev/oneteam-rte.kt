package io.one_team.oneteam_rte_kt.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

class Toolbar(context: Context, attr: AttributeSet?) : LinearLayout(context, attr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.toolbar_view, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }
}