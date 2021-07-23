package com.example.dicerollapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
            rollDice()
        }

        // アプリ起動時にダイスを振る
        rollDice()
    }

    /**
     * ダイスを振る
     */
    private fun rollDice() {
        val dice = Dice(6)
        val resultDiceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

        // ダイスの値に応じた画像をセット
        val imageId = when (resultDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1 // エラーハンドリング, 念の為
        }
        diceImage.setImageResource(imageId)

        // コンテンツの説明に出目の数字を入れる
        // スクリーンリーダー用
        diceImage.contentDescription = resultDiceRoll.toString()
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