package com.family.lucky.lightSensor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.family.lucky.databinding.ActivityLightSensorBinding

class LightSensorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLightSensorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLightSensorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.btnBasicLight.setOnClickListener {
            Intent(this@LightSensorActivity, LightFragmentHolder::class.java).apply {
                putExtra(LightFragmentHolder.FRAGMENT_EXTRA, LightFragmentHolder.BASIC_LIGHT)
                startActivity(this)
            }
        }
        binding.btnAdjustScreen.setOnClickListener {
            Intent(this@LightSensorActivity, LightFragmentHolder::class.java).apply {
                putExtra(LightFragmentHolder.FRAGMENT_EXTRA, LightFragmentHolder.ADJUST_SCREEN)
                startActivity(this)
            }
        }
        binding.btnUsingLight.setOnClickListener {
            Intent(this@LightSensorActivity, LightFragmentHolder::class.java).apply {
                putExtra(LightFragmentHolder.FRAGMENT_EXTRA, LightFragmentHolder.LIGHT_ACCURACY)
                startActivity(this)
            }
        }
    }
}