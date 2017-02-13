package io.one_team.oneteam_rte_kt.core

import android.webkit.WebView

fun WebView.blur() = runScript("window.editor.blur()")
fun WebView.focus() = runScript("window.editor.focus()")
fun WebView.setPlaceholder(value: String) = runScript("""window.editor.placeholder = "$value" """)
fun WebView.setHTML(html: String) = runScript("""window.editor.setHTML("$html")""")
fun WebView.toggleBlockType(type: String) = runScript("""window.editor.toggleBlockType("$type")""")
fun WebView.toggleInlineStyle(type: String) = runScript("""window.editor.toggleInlineStyle("$type")""")
fun WebView.insertLink(url: String) = runScript("""window.editor.toggleLink("$url")""")
fun WebView.insertIFrame(src: String) = runScript("""window.editor.insertIFrame("$src")""")
fun WebView.insertImage(imgJson: String) = runScript("""window.editor.insertImage("$imgJson")""")
fun WebView.insertFileDownload(fileJson: String) = runScript("""window.editor.insertDownloadLink("$fileJson")""")

private fun WebView.runScript(script: String) = loadUrl("javascript: $script")
