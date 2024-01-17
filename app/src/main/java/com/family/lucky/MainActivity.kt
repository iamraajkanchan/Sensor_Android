package com.family.lucky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.family.lucky.databinding.ActivityMainBinding
import com.family.lucky.lightSensor.LightSensorActivity
import com.family.lucky.proximitySensor.ProximitySensorActivity

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
            Intent(this@MainActivity, LightSensorActivity::class.java).apply {
                startActivity(this)
            }
        }
        binding.btnGravitySensor.setOnClickListener {

        }
        binding.btnProximitySensor.setOnClickListener {
            Intent(this@MainActivity, ProximitySensorActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}