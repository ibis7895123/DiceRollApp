package com.example.dicerollapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)

        // rollボタンが押されたときの挙動
        rollButton.setOnClickListener {
            // トーストでテキストを表示する
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

            // ダイスを振って結果を出力する
            rollDices()
        }
    }

    /**
     * ダイスを振る
     */
    private fun rollDices() {
        val dice1 = Dice(6)
        val resultDiceRoll1 = dice1.roll()

        val resultTextView1: TextView = findViewById(R.id.resultTextView)
        resultTextView1.text = resultDiceRoll1.toString()

        val dice2 = Dice(6)
        val resultDiceRoll2 = dice2.roll()

        val resultTextView2: TextView = findViewById(R.id.resultTextView2)
        resultTextView2.text = resultDiceRoll2.toString()
    }
}

/**
 * 入力した数のダイス
 * (ダイスの範囲内でランダムに結果を出力)
 */
class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}