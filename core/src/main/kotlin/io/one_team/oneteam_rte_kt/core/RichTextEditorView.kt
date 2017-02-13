package io.one_team.oneteam_rte_kt.core

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.webkit.JavascriptInterface
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.rich_text_editor_view.view.*
import java.net.URL

/**
 * A View wrapping oneteam-rtd javascript library.
 */
class RichTextEditorView(context: Context, attr: AttributeSet?) : LinearLayout(context, attr) {
    var html = ""
        set(value) {
            field = value
            webView.setHTML(html)
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.rich_text_editor_view, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        webView.loadUrl("file:///android_asset/index.html")
        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(JSInterface(), "AndroidInterface")
        webView.setPlaceholder("")

        setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) webView.focus() else webView.blur()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        onFocusChangeListener = null
    }

    /**
     * Toggle line style with [BlockStyle]
     *
     * @param style a block style you want to apply or unapply
     * @see [BlockStyle]
     */
    fun toggleBlockStyle(style: BlockStyle) {
        webView.toggleBlockType(style.stringValue)
    }

    /**
     * Toggle selected text with [InlineStyle]
     * @param style a inline style you want to apply or unapply
     * @see [InlineStyle]
     */
    fun toggleInlineStyle(style: InlineStyle) {
        webView.toggleInlineStyle(style.stringValue)
    }

    /**
     * Add link href to selected text
     *
     * @param url url link you want to attach selected text
     */
    fun insertLink(url: URL) {
        webView.insertLink(url.toString())
    }

    /**
     * Insert iframe code
     *
     * @param src iframe code you want to insert in html
     */
    fun insertIFrame(src: String) {
        webView.insertIFrame(src)
    }

    /**
     * Insert a file
     *
     * @param name file name
     * @param url file url
     */
    fun insertFile(name: String, url: URL) {
        val json = """{""name": "$name", "download_url": "$url"}"""
        webView.insertImage(json)
    }

    /**
     * Insert a image
     * @param name image name that will be used by alt attribute etc...
     * @param url image url that will be shown by clicking image
     * @param previewURL image url that will be shown in editor as thumbnail
     */
    fun insertImage(name: String, url: URL, previewURL: URL) {
        val json = """{""name": "$name", "original_url": "$url", "preview_url": "$previewURL" }"""
        webView.insertFileDownload(json)
    }

    private inner class JSInterface {
        @JavascriptInterface fun didChangeEditorState(state: String?): Unit {

        }
    }
}
