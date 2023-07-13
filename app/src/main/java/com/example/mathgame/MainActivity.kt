package com.example.mathgame

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var edtAnswer: EditText
    private lateinit var tvQuestion: TextView
    private lateinit var btnJavob: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtAnswer = findViewById(R.id.edt_Answer)
        tvQuestion = findViewById(R.id.tv_Question)
        btnJavob = findViewById(R.id.btn_Javob)
        randomMisol()
        btnJavob.setOnClickListener {
            // bu shart shunde diyaptiki javobimiz nechchi xonali bolsa
            // shuncha hona kirita olsin unda uyogini olmasin deyapti
            if (tJavob.toString().length == edtAnswer.text.toString().length)
                myChecking()

        }
    }

    var number1 = 0
    var number2 = 0
    var amal = 0
    var tJavob = 0
    fun randomMisol() {
        number1 = Random.nextInt(20)
        number2 = Random.nextInt(20)
        amal = Random.nextInt(4)
        when (amal) {
            0 -> {
                tvQuestion.text = "$number1 + $number2"
                tJavob = number1 + number2
            }
            1 -> {
                if (number1 < number2) {
                    randomMisol()
                    return
                }
                tvQuestion.text = "$number1 - $number2"
                tJavob = number1 - number2
            }
            2 -> {
                tvQuestion.text = "$number1 * $number2"
                tJavob = number1 * number2
            }
            3 -> {
                try {
                    if (number1 % number2 != 0) {
                        randomMisol()
                    }
                    tvQuestion.text = "$number1 / $number2"
                    tJavob = number1 / number2
                } catch (e: Exception) {
                    randomMisol()
                    return
                }
            }
        }
    }

    fun myChecking() {
        if (tJavob == edtAnswer.text.toString().toInt()) {
            /* val mediaPlayer = MediaPlayer.create(this, R.raw.golos_1)
             mediaPlayer.start()*///bu tori javon bolsa musika qoyiladi
            Toast.makeText(this, "to'g'ri javop", Toast.LENGTH_SHORT).show()
        } else {
            /*    val mediaPlayer = MediaPlayer.create(this, R.raw.golos_2)
                mediaPlayer.start()*///bu tori javon bolsa musika qoyiladi
            Toast.makeText(this, "noto'g'ri javop", Toast.LENGTH_SHORT).show()
        }
        //bu yerda javob kitilib button bosilgandan keyin misolni tozalab
        // boshqa misol ber diyapti
        edtAnswer.text.clear()
        randomMisol()
    }
}