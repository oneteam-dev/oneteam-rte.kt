package io.one_team.oneteam_rte_kt.core

import android.webkit.WebView

fun WebView.blur() = runScript("window.editor.blur()")
fun WebView.focus() = runScript("window.editor.focus()")
fun WebView.setBodyPlaceholder(value: String)  = runScript("""window.editor.setPlaceholder("$value");""")
fun WebView.setHTML(html: String) = runScript("""window.editor.setHTML("${html.replace("\"", "\\\"")}")""")
fun WebView.setMentions(mentions: List<Mentionable>) = runScript("""window.editor.rawMentions = [${mentions.joinToString { it.toJson() }}]""")
fun WebView.setHashTagList(hashtagList: List<String>) = runScript("""window.editor.hashtagList = ${hashtagList.map { "\"$it\"" }.joinToString(",", "[", "]")}""")
fun WebView.toggleBlockType(type: String) = runScript("""window.editor.toggleBlockType("$type")""")
fun WebView.toggleInlineStyle(type: String) = runScript("""window.editor.toggleInlineStyle("$type")""")
fun WebView.insertLink(url: String) = runScript("""window.editor.toggleLink("$url")""")
fun WebView.removeLink() = runScript("""window.editor.toggleLink(null)""")
fun WebView.insertIFrame(src: String) = runScript("""window.editor.insertIFrame("$src")""")
fun WebView.insertImage(imgJson: String) = runScript("""window.editor.insertImage($imgJson)""")
fun WebView.insertFileDownload(fileJson: String) = runScript("""window.editor.insertDownloadLink($fileJson)""")

private fun WebView.runScript(script: String) = loadUrl("javascript: $script")
