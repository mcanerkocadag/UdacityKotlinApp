package com.example.udacitykotlinapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRandom: Button = findViewById(R.id.btn_random)

        val txtZar: TextView = findViewById(R.id.txt_zar)
        val randInt = Random().nextInt(6) + 1
        txtZar.text = randInt.toString()

        btnRandom.setOnClickListener {

            rollDiece()
        }
    }

    private fun rollDiece() {

        val txtZar: TextView = findViewById(R.id.txt_zar)
        val randInt = Random().nextInt(6) + 1
        txtZar.text = randInt.toString()
        val imgZar: ImageView = findViewById(R.id.img_zar)
        val drawableResource = when (randInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        imgZar.setImageResource(drawableResource)
    }
}
