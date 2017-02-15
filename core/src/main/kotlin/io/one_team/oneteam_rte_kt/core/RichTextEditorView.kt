package io.one_team.oneteam_rte_kt.core

import android.content.Context
import android.os.Build
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.webkit.*
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.rich_text_editor_view.view.*
import java.net.URL

/**
 * A View wrapping oneteam-rte javascript library.
 * @see https://github.com/oneteam-dev/oneteam-rte
 */
class RichTextEditorView(context: Context, attr: AttributeSet?) : LinearLayout(context, attr) {
    /**
     * Html content in a editor
     * This is two-way bound value so that make exactly same as a value in the editor.
     */
    var content: String
        get() = _content
        set(value) {
            _content = value
            webView.setHTML(value)
        }

    private var _content = ""
        set(value) {
            field = value
            onContentChanged?.invoke(value)
        }

    /**
     * Inline styles applied to selected line
     * @see [InlineStyle]
     */
    var inlineStyles: List<InlineStyle> = listOf()
        set(value) {
            field = value
            onInlineStylesChanged?.invoke(value)
        }

    /**
     * Block style applied to selected line
     * @see [BlockStyle]
     */
    var blockStyle: BlockStyle = BlockStyle.Unstyled
        set(value) {
            field = value
            onBlockStyleChanged?.invoke(value)
        }

    var onContentChanged: ((String) -> Unit)? = null
    var onInlineStylesChanged: ((List<InlineStyle>) -> Unit)? = null
    var onBlockStyleChanged: ((BlockStyle) -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.rich_text_editor_view, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        setupWebView()

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
     * Remove link href from selected text
     */
    fun removeLink() {
        webView.removeLink()
    }

    /**
     * Insert iframe code
     *
     * @param src iframe code you want to insert into content
     */
    fun insertIFrame(src: String) {
        webView.insertIFrame(src.replace("\"", "\\\""))
    }

    /**
     * Insert a file
     *
     * @param name file name
     * @param url file url
     */
    fun insertFile(name: String, url: URL) {
        val json = """{"name": "$name", "url": "$url"}"""
        webView.insertFileDownload(json)
    }

    /**
     * Insert a image
     * @param name image name that will be used by alt attribute etc...
     * @param url image url that will be shown by clicking image
     */
    fun insertImage(name: String, url: URL) {
        val json = """{"alt": "$name", "title": "$name", "url": "$url"}"""
        webView.insertImage(json)
    }

    /**
     * Set cookie value to webView
     * @param host host to set cookie
     * @param cookie key=value string
     */
    fun setCookie(host: String, cookie: String) {
        val cookieManager = CookieManager.getInstance()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(webView, true)
        } else {
            cookieManager.setAcceptCookie(true)
        }
        cookieManager.setCookie(host, cookie)
    }

    private fun setupWebView() {
        webView.loadUrl("file:///android_asset/index.html")
        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(JSInterface(), "AndroidInterface")
        webView.setWebViewClient(WebViewClient())
        webView.setWebChromeClient(WebChromeClient())
    }

    private inner class JSInterface {
        @JavascriptInterface
        fun didMountComponent(): Unit {
            Handler(context.mainLooper).post { webView.setHTML(_content) }
        }

        @JavascriptInterface
        fun didChangeInlineStyles(styles: String?): Unit {
            Handler(context.mainLooper).post {
                inlineStyles = styles
                        ?.split(",")
                        ?.map { InlineStyle.from(it) }
                        ?.filterNotNull()
                        ?: listOf()
            }
        }

        @JavascriptInterface
        fun didChangeBlockType(type: String?): Unit {
            Handler(context.mainLooper).post {
                blockStyle = type
                        ?.let { BlockStyle.from(it) }
                        ?: BlockStyle.Unstyled
            }
        }

        @JavascriptInterface
        fun didChangeContent(content: String?): Unit {
            Handler(context.mainLooper).post {
                _content = content ?: ""
            }
        }
    }
}
