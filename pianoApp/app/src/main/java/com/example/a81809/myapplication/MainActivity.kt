package com.example.a81809.myapplication

import android.media.AudioAttributes
import android.media.SoundPool
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool
    private var soundC1 = 0
    private var soundD1 = 0
    private var soundE1 = 0
    private var soundF1 = 0
    private var soundG1 = 0
    private var soundA2 = 0
    private var soundB2 = 0
    private var soundC2 = 0
    private var soundD2 = 0
    private var soundE2 = 0
    private var soundF2 = 0
    private var soundG2 = 0
    private var soundA3 = 0
    private var soundB3 = 0
    private var soundC3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var c1Button = findViewById<Button>(R.id.c1)
        var d1Button = findViewById<Button>(R.id.d1)
        var e1Button = findViewById<Button>(R.id.e1)
        var f1Button = findViewById<Button>(R.id.f1)
        var g1Button = findViewById<Button>(R.id.g1)
        var a2Button = findViewById<Button>(R.id.a2)
        var b2Button = findViewById<Button>(R.id.b2)
        var c2Button = findViewById<Button>(R.id.c2)
        var d2Button = findViewById<Button>(R.id.d2)
        var e2Button = findViewById<Button>(R.id.e2)
        var f2Button = findViewById<Button>(R.id.f2)
        var g2Button = findViewById<Button>(R.id.g2)
        var a3Button = findViewById<Button>(R.id.a3)
        var b3Button = findViewById<Button>(R.id.b3)
        var c3Button = findViewById<Button>(R.id.c3)

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()

        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(2)
            .build()
        soundC1 = soundPool.load(this, R.raw.c1, 1)
        soundD1 = soundPool.load(this, R.raw.d1, 1)
        soundE1 = soundPool.load(this, R.raw.e1, 1)
        soundF1 = soundPool.load(this, R.raw.f1, 1)
        soundG1 = soundPool.load(this, R.raw.g1, 1)
        soundA2 = soundPool.load(this, R.raw.a2, 1)
        soundB2 = soundPool.load(this, R.raw.b2, 1)
        soundC2 = soundPool.load(this, R.raw.c2, 1)
        soundD2 = soundPool.load(this, R.raw.d2, 1)
        soundE2 = soundPool.load(this, R.raw.e2, 1)
        soundF2 = soundPool.load(this, R.raw.f2, 1)
        soundG2 = soundPool.load(this, R.raw.g2, 1)
        soundA3 = soundPool.load(this, R.raw.a3, 1)
        soundB3 = soundPool.load(this, R.raw.b3, 1)
        soundC3 = soundPool.load(this, R.raw.c3, 1)

        soundPool.setOnLoadCompleteListener { soundPool, sampleId, status ->

        }

        c1Button.setOnClickListener {
            soundPool.play(soundC1, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        d1Button.setOnClickListener {
            soundPool.play(soundD1, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        e1Button.setOnClickListener {
            soundPool.play(soundE1, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        f1Button.setOnClickListener {
            soundPool.play(soundF1, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        g1Button.setOnClickListener {
            soundPool.play(soundG1, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        a2Button.setOnClickListener {
            soundPool.play(soundA2, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        b2Button.setOnClickListener {
            soundPool.play(soundB2, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        c2Button.setOnClickListener {
            soundPool.play(soundC2, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        d2Button.setOnClickListener {
            soundPool.play(soundD2, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        e2Button.setOnClickListener {
            soundPool.play(soundE2, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        f2Button.setOnClickListener {
            soundPool.play(soundF2, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        g2Button.setOnClickListener {
            soundPool.play(soundG2, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        a3Button.setOnClickListener {
            soundPool.play(soundA3, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        b3Button.setOnClickListener {
            soundPool.play(soundB3, 1.0f, 1.0f, 1, 0, 1.0f)
        }
        c3Button.setOnClickListener {
            soundPool.play(soundC3, 1.0f, 1.0f, 1, 0, 1.0f)
        }

    }
}
