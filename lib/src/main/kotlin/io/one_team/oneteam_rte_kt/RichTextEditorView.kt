package io.one_team.oneteam_rte_kt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.rich_text_editor_view.view.*

class RichTextEditorView(context: Context, attr: AttributeSet?) : LinearLayout(context, attr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.rich_text_editor_view, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        WebView.setWebContentsDebuggingEnabled(true)
        webView.loadUrl("file:///android_asset/index.html")
        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(JSInterface(), "AndroidInterface")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }
}

class JSInterface {
    @JavascriptInterface fun setCallbackToken(token: String?): Unit {}
    @JavascriptInterface fun didChangeEditorState(state: String?): Unit {}
}