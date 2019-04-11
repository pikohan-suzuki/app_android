package com.example.suzukis.animationtest

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttons: Array<Button?> = arrayOfNulls(5)
        buttons.set(0, findViewById(R.id.button1))
        buttons.set(1, findViewById(R.id.button2))
        buttons.set(2, findViewById(R.id.button3))
        buttons.set(3, findViewById(R.id.button4))
        buttons.set(4, findViewById(R.id.button5))
        val menuLayout :FrameLayout = findViewById(R.id.menuLayout)
        val textView: TextView = findViewById(R.id.test_textView)
        val testButton: Button = findViewById(R.id.test_Button)

        testButton.setOnClickListener(View.OnClickListener {
            animateOpenMenu(buttons,menuLayout)
        })

        menuLayout.setOnClickListener(View.OnClickListener {
            animateCloneMenu(buttons,menuLayout)
        })
    }

    fun animateOpenMenu(buttons: Array<Button?>, menuLayout:FrameLayout) {
        val radius = 400f
        val time :Long=300
        val array = Array(5, { arrayOfNulls<PropertyValuesHolder>(2) })
        array[0][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI / 2).toFloat())
        array[0][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI / 2).toFloat())
        array[1][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI * 112.5 / 180).toFloat())
        array[1][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI * 112.5 / 180).toFloat())
        array[2][0] = PropertyValuesHolder.ofFloat("translationX", 0f,radius * cos(PI * 135 / 180).toFloat())
        array[2][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI * 135 / 180).toFloat())
        array[3][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI * 157.5 / 180).toFloat())
        array[3][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI * 157.5 / 180).toFloat())
        array[4][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(1 * PI).toFloat())
        array[4][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(1 * PI).toFloat())

        val menuLayoutAnimation = ObjectAnimator.ofFloat(menuLayout,"alpha",0f,1f)
        menuLayoutAnimation.setDuration(time)
        menuLayoutAnimation.start()
        visiable(menuLayout)
         for (i in array.indices) {
            visiable(buttons[i])
            val objectAnimator: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(buttons[i], array[i][0], array[i][1])
            objectAnimator.setDuration(time)
            objectAnimator.start()
        }

    }

    fun animateCloneMenu(buttons:Array<Button?>,menuLayout: FrameLayout){
        val time: Long = 200
//        val array = Array(5, { arrayOfNulls<PropertyValuesHolder>(2) })
//        array[0][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI / 2).toFloat())
//        array[0][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI / 2).toFloat())
//        array[1][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI * 112.5 / 180).toFloat())
//        array[1][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI * 112.5 / 180).toFloat())
//        array[2][0] = PropertyValuesHolder.ofFloat("translationX", 0f,radius * cos(PI * 135 / 180).toFloat())
//        array[2][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI * 135 / 180).toFloat())
//        array[3][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(PI * 157.5 / 180).toFloat())
//        array[3][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(PI * 157.5 / 180).toFloat())
//        array[4][0] = PropertyValuesHolder.ofFloat("translationX", 0f, radius * cos(1 * PI).toFloat())
//        array[4][1] = PropertyValuesHolder.ofFloat("translationY", 0f, -radius * sin(1 * PI).toFloat())
    }

    fun visiable(view: View?) {
        if (view != null) {
            if (view.visibility == View.INVISIBLE || view.visibility == View.GONE)
                view.visibility = View.VISIBLE
        }
    }
    fun gone(view: View?){
        if (view != null) {
            if (view.visibility == View.VISIBLE)
                view.visibility = View.GONE
        }
    }
}
