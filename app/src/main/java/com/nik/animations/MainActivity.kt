package com.nik.animations

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import com.nik.animations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var inAnimation: Animation
    private lateinit var outAnimation: Animation
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTweenAnimation.setOnClickListener {
            val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_in)
            binding.tvText.startAnimation(fadeAnimation)
        }

        binding.btnFrameAnimation.setOnClickListener {
            val animationDrawable =
                resources.getDrawable(R.drawable.frame_animation) as AnimationDrawable
            binding.imageView.setImageDrawable(animationDrawable)
            animationDrawable.start()
        }

        binding.btnPropertyAnimation.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(binding.imageView2, "translationX", 0f, 200f)
            animator.duration = 1000
            animator.start()
        }

        binding.btnBackground.setOnClickListener {
            val layout = binding.root
            val animator = ValueAnimator.ofArgb(Color.RED, Color.BLUE)
            animator.duration = 1000
            animator.addUpdateListener { animation ->
                val color = animation.animatedValue as Int
                layout.setBackgroundColor(color)
            }
            animator.start()
        }
    }
}