package com.example.cooldroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val COUNTER_KEY = "COUNTER"
    internal val LOG_TAG = MainActivity::class.java.simpleName
    var counter = 0

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER_KEY, counter)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState!=null) {
            counter = savedInstanceState.getInt(COUNTER_KEY)
            tvCoolDroid.text = getMessageText()
        }
        ivCoolDroid.setOnClickListener{
            counter++
            Log.d(LOG_TAG, "onCreate(), counter: ${counter}")
            tvCoolDroid.text = getMessageText()

        }
    }

    private fun getMessageText() =
        when (counter) {
            1 -> getString(R.string.once)
            2 -> getString(R.string.twice)
            else -> getString(R.string.text_view_numbers, counter)
        }
}
