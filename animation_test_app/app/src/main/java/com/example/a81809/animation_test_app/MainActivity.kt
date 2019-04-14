package com.example.a81809.animation_test_app

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
    var menuOpenFlg: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttons: Array<Button?> = arrayOfNulls(5)
        buttons[0] = findViewById(R.id.button1)
        buttons[1] = findViewById(R.id.button2)
        buttons[2] = findViewById(R.id.button3)
        buttons[3] = findViewById(R.id.button4)
        buttons[4] = findViewById(R.id.button5)
        val menuLayout: FrameLayout = findViewById(R.id.menuLayout)
        val testButton: Button = findViewById(R.id.test_Button)


        val clickListener = View.OnClickListener {
            when (it) {
                menuLayout -> {
                    if (menuOpenFlg)
                        animateAlphaCloseMenu(menuLayout)
                }
                testButton -> {
                    if (!menuOpenFlg)
                        animateOpenMenu(buttons, menuLayout)
                    else
                        animateTranslateCloneMenu(buttons, menuLayout)
                }
            }
        }

        menuLayout.setOnClickListener(clickListener)
        testButton.setOnClickListener(clickListener)
    }

    fun animateOpenMenu(buttons: Array<Button?>, menuLayout: FrameLayout) {
        val radius = 400f
        val time: Long = 300
        val array = Array(5, { arrayOfNulls<PropertyValuesHolder>(2) })
        array[0][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI / 2).toFloat())
        array[0][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI / 2).toFloat())
        array[1][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI * 112.5 / 180).toFloat())
        array[1][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI * 112.5 / 180).toFloat())
        array[2][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI * 135 / 180).toFloat())
        array[2][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI * 135 / 180).toFloat())
        array[3][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI * 157.5 / 180).toFloat())
        array[3][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI * 157.5 / 180).toFloat())
        array[4][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(1 * PI).toFloat())
        array[4][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(1 * PI).toFloat())

        val menuLayoutAnimation = ObjectAnimator.ofFloat(menuLayout, "alpha", 0f, 0.5f)
        menuLayoutAnimation.setDuration(time)
        menuLayoutAnimation.start()
        visiable(menuLayout)
        for (i in array.indices) {
            visiable(buttons[i])
            val objectAnimator: ObjectAnimator =
                ObjectAnimator.ofPropertyValuesHolder(buttons[i], array[i][0], array[i][1])
            objectAnimator.setDuration(time)
            objectAnimator.start()
        }
        menuOpenFlg = true
    }

    fun animateTranslateCloneMenu(buttons: Array<Button?>, menuLayout: FrameLayout) {
        val radius = 400f
        val time: Long = 200
        val array = Array(5, { arrayOfNulls<PropertyValuesHolder>(2) })
        array[0][0] = PropertyValuesHolder.ofFloat("translationX", radius * cos(PI / 2).toFloat(), 0f)
        array[0][1] = PropertyValuesHolder.ofFloat("translationY", -radius * sin(PI / 2).toFloat(), 0f)
        array[1][0] = PropertyValuesHolder.ofFloat("translationX", radius * cos(PI * 112.5 / 180).toFloat(), 0f)
        array[1][1] = PropertyValuesHolder.ofFloat("translationY", -radius * sin(PI * 112.5 / 180).toFloat(), 0f)
        array[2][0] = PropertyValuesHolder.ofFloat("translationX", radius * cos(PI * 135 / 180).toFloat(), 0f)
        array[2][1] = PropertyValuesHolder.ofFloat("translationY", -radius * sin(PI * 135 / 180).toFloat(), 0f)
        array[3][0] = PropertyValuesHolder.ofFloat("translationX", radius * cos(PI * 157.5 / 180).toFloat(), 0f)
        array[3][1] = PropertyValuesHolder.ofFloat("translationY", -radius * sin(PI * 157.5 / 180).toFloat(), 0f)
        array[4][0] = PropertyValuesHolder.ofFloat("translationX", radius * cos(1 * PI).toFloat(), 0f)
        array[4][1] = PropertyValuesHolder.ofFloat("translationY", -radius * sin(1 * PI).toFloat(), 0f)
        for (i in array.indices) {
            visiable(buttons[i])
            val objectAnimator: ObjectAnimator =
                ObjectAnimator.ofPropertyValuesHolder(buttons[i], array[i][0], array[i][1])
            objectAnimator.setDuration(time)
            objectAnimator.start()
        }
        animateAlphaCloseMenu(menuLayout)
    }

    fun animateAlphaCloseMenu(menuLayout: FrameLayout) {
        val time: Long = 200

        val objectAnimator = ObjectAnimator.ofFloat(menuLayout, "alpha", 0.5f, 0f)
        objectAnimator.setDuration(time)
        objectAnimator.start()
//        gone(menuLayout)
        menuOpenFlg = false
    }

    fun visiable(view: View?) {
        if (view != null) {
            if (view.visibility == View.INVISIBLE || view.visibility == View.GONE)
                view.visibility = View.VISIBLE
        }
    }

    fun gone(view: View?) {
        if (view != null) {
            if (view.visibility == View.VISIBLE)
                view.visibility = View.GONE
        }
    }
}