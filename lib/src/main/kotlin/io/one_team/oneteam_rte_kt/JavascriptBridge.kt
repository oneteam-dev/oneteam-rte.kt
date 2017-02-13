package io.one_team.oneteam_rte_kt

import android.webkit.WebView

interface JavascriptBridge {
    var webView: WebView

    fun blur() {
        runScript("window.editor.blur()")
    }

    fun focus() {
        runScript("window.editor.focus()")
    }

    fun scrollY(offset: Int) {
        runScript("window.scrollTo(0, $offset)")
    }

    fun setDOMPlaceholder(value: String) {
        runScript("""window.editor.placeholder = "$value" """)
    }

    fun setHTML(html: String) {
        runScript("window.editor.setHTML($html)")
    }

    fun setCallbackToken(token: String) {
        runScript("""window.editor.setCallbackToken("$token")""")
    }

    fun toggleBlockType(type: String) {
        runScript("""window.editor.toggleBlockType("$type")""")
    }

    fun toggleInlineStyle(type: String) {
        runScript(""""window.editor.toggleInlineStyle("$type")""")
    }

    fun insertLink(url: String) {
        runScript("""window.editor.toggleLink("$url")""")
    }

    fun insertIFrame(src: String) {
        runScript("""window.editor.insertIFrame("$src")""")
    }

    fun insertImage(imgJson: String) {
        runScript("""window.editor.insertImage("$imgJson")""")
    }

    fun insertFileDownload(fileJson: String) {
        runScript("window.editor.insertDownloadLink($fileJson)")
    }

    private fun runScript(script: String) {
        webView.loadUrl("javascript: $script")
    }
}