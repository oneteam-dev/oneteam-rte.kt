package io.one_team.oneteam_rte_kt.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.one_team.oneteam_rte_kt.core.Mentionable
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
            editor?.insertImage("example",
                originalUrl = URL("http://placehold.it/350x500"),
                previewUrl = URL("http://placehold.it/350x150")
            )
        }

        editor.content = "Type @ for mentions"
        editor.rawMentions = listOf(
            Mentionable(1, "testuser1", "Test User 1", "testuser1@example.com", "http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802?d=identicon"),
            Mentionable(2, "testuser2", "Test User 2", "testuser2@example.com", "https://www.gravatar.com/avatar/00000000000000000000000000000000?d=retro&f=y")
        )

        contentLogButton.setOnClickListener {
            Log.d("DEBUG", editor.content)
        }
    }
}
