package com.example.songcounter

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ToggleButton


class InfoPage : AppCompatActivity() {

    lateinit var song: MediaPlayer
    lateinit var toggleButton: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_page)

        toggleButton = findViewById(R.id.playButton)
        song = MediaPlayer.create(this, R.raw.wayttgoes)

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                song.start()
            } else {
                song.stop()
                song.prepare()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        song.stop()
    }
}
