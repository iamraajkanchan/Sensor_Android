package com.family.lucky.proximitySensor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.family.lucky.databinding.ActivityProximitySensorBinding

class ProximitySensorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProximitySensorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProximitySensorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}