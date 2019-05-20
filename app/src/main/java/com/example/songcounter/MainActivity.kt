package com.example.songcounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.content.SharedPreferences
import android.R.id.edit
import android.content.SharedPreferences.Editor
import android.R.id.edit
import android.content.Intent


class MainActivity : AppCompatActivity() {
    // Initializes variables

    var counter = 0
    private lateinit var counterVisual: TextView
    private lateinit var mPreferences: SharedPreferences
    private val COUNT_KEY = "count"
    val sharedPrefFile = "Hunter's App"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // This turns the view text into a mutable object
        counterVisual = findViewById(R.id.count);

        // mPreferences is the preference object
        mPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE)
        counter = mPreferences.getInt(COUNT_KEY,0)
        counterVisual.setText(String.format("%s",counter))



    }

    fun increaseCount(View: View){
        counter++
        counterVisual.setText(String.format("%s",counter))
    }

    fun decreaseCount(View: View){
        if (counter > 0)
            counter--
            counterVisual.setText(String.format("%s",counter))

    }

    fun resetCount(View: View){
        counter = 0
        counterVisual.setText(String.format("%s",counter))

    }

    // This will save the uer's input when the app is paused
    public override fun onPause(){
        super.onPause();

        val pref = mPreferences.edit()
        pref.putInt(COUNT_KEY, counter);
        pref.apply()
    }

    fun learnMore(View: View){
        var learnMoreIntent = Intent(this, InfoPage::class.java)
        startActivity(learnMoreIntent)
    }
}
