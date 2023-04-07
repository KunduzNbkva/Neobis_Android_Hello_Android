package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage:ImageView
    private lateinit var rollButton: Button
    private var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        if (savedInstanceState != null) {
            val num = savedInstanceState.getInt("diceNum")
            rollDice(num)
        }
        setClickListeners()
    }

    private fun rollDice(num:Int) {
        val drawableRes = when(num){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
           else-> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableRes)
    }

    private fun initViews(){
        rollButton = findViewById(R.id.btn_roll)
        diceImage = findViewById(R.id.dice_image)
    }

    private fun setClickListeners(){
        rollButton.setOnClickListener {
            num = Random().nextInt(6)+1
            rollDice(num)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("diceNum",num)
    }

}