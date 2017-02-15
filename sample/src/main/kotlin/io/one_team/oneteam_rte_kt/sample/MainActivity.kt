package io.one_team.oneteam_rte_kt.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        toolbar.editor = editor

        // These are just examples. You should make users to choose files or images or link
        toolbar.addOnClickImageButtonListener {
            editor?.insertImage("example", URL("http://placehold.it/350x150"))
        }

        toolbar.addOnClickInsertLinkButtonListener {
            editor?.insertLink(URL("https://example.com/content"))
        }
    }
}
