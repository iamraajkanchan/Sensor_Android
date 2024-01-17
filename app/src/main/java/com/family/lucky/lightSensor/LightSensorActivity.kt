package com.family.lucky.lightSensor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.family.lucky.databinding.ActivityLightSensorBinding

class LightSensorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLightSensorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLightSensorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}