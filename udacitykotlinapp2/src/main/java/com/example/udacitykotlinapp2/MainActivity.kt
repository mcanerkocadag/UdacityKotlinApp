package com.example.udacitykotlinapp2

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.udacitykotlinapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var databing: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databing = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val myObject = MyName("denemeee", "")
        databing.myName = myObject
        val starBtn: ImageView = findViewById(R.id.star_img)
        starBtn.setOnClickListener {
            Log.i("Test", "click1")
        }
        databing.starImg.setBackgroundResource(R.drawable.abc_ic_clear_material)
        databing.starImg.setOnClickListener {
            Log.i("Test", "click2")
        }
        //myObject.name = "basıldı"
        // databing.invalidateAll()

    }
}
