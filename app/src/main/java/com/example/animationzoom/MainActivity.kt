package com.example.animationzoom

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    lateinit var card: CardView
    lateinit var rotateBtn: Button
    lateinit var scale: Button
    lateinit var translateBtn: Button
    lateinit var SlideU: Button
    lateinit var SlideD: Button
    lateinit var SlideL: Button
    lateinit var SlideR: Button
    lateinit var fadeIn: Button
    lateinit var fadeOut: Button
    lateinit var zoomIn: Button
    lateinit var zoomOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        card = findViewById(R.id.imgvw)
        rotateBtn = findViewById<Button>(R.id.Rotate)
        translateBtn = findViewById<Button>(R.id.translate)
        SlideU = findViewById<Button>(R.id.SlideUp)
        SlideD = findViewById<Button>(R.id.SlideDown)
        SlideL = findViewById<Button>(R.id.SlideLeft)
        SlideR = findViewById<Button>(R.id.SlideRight)
        fadeIn = findViewById<Button>(R.id.btnFadeIn)
        fadeOut = findViewById<Button>(R.id.btnFadeOut)
        zoomIn = findViewById<Button>(R.id.zoomIn)
        zoomOut = findViewById<Button>(R.id.zoomOut)
        scale = findViewById<Button>(R.id.Scale)




        fadeIn.setOnClickListener {
            val animZoomIn = AnimationUtils.loadAnimation(this,
                R.anim.fade_in)
            card.startAnimation(animZoomIn)
        }
        fadeOut.setOnClickListener {
            val animZoomIn = AnimationUtils.loadAnimation(this,
                R.anim.fade_out)
            card.startAnimation(animZoomIn)
        }
        zoomIn.setOnClickListener {
            val animZoomIn = AnimationUtils.loadAnimation(this,
                R.anim.zoom_in)
            card.startAnimation(animZoomIn)
        }
        rotateBtn.setOnClickListener {
            rotater()
        }
        translateBtn.setOnClickListener {
            translater()
        }
        scale.setOnClickListener {
            scaler()
        }
    }

    private fun rotater() {
        val animator = ObjectAnimator.ofFloat(card, View.ROTATION, -360f, 0f)
        animator.duration = 1000
        animator.start()
    }
    private fun translater() {
        val animator = ObjectAnimator.ofFloat(card, View.TRANSLATION_X, 200f)
        animator.repeatCount = 1
        animator.duration = 1500
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
    private fun scaler() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            card, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
}
