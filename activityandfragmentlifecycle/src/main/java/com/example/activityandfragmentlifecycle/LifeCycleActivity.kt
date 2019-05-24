package com.example.activityandfragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LifeCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }
}
