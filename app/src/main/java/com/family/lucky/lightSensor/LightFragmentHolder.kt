package com.family.lucky.lightSensor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.family.lucky.databinding.FragmentBasicLightBinding
import com.family.lucky.lightSensor.fragments.AdjustScreenFragment
import com.family.lucky.lightSensor.fragments.BasicLightFragment

class LightFragmentHolder : AppCompatActivity() {
    private lateinit var binding: FragmentBasicLightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentBasicLightBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val basicLightFragment = BasicLightFragment.newInstance()
        val adjustScreenFragment = AdjustScreenFragment.newInstance()
    }
}