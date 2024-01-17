package com.family.lucky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.family.lucky.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.btnLightSensor.setOnClickListener {

        }
        binding.btnGravitySensor.setOnClickListener {

        }
        binding.btnProximitySensor.setOnClickListener {

        }
    }
}