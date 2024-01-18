package com.family.lucky.lightSensor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.family.lucky.databinding.ActivityLightFragmentHolderBinding
import com.family.lucky.lightSensor.fragments.AdjustScreenFragment
import com.family.lucky.lightSensor.fragments.BasicLightFragment
import com.family.lucky.lightSensor.fragments.UsingLightFragment

class LightFragmentHolder : AppCompatActivity() {
    private lateinit var binding: ActivityLightFragmentHolderBinding
    private var fragmentExtra = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLightFragmentHolderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra(FRAGMENT_EXTRA)) {
            fragmentExtra = intent.getStringExtra(FRAGMENT_EXTRA) ?: BASIC_LIGHT
        }
        initViews()
    }

    private fun initViews() {
        val basicLightFragment = BasicLightFragment.newInstance()
        val adjustScreenFragment = AdjustScreenFragment.newInstance()
        val usingLightFragment = UsingLightFragment.newInstance()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        when (fragmentExtra) {
            BASIC_LIGHT -> {
                fragmentTransaction.replace(binding.fcvFragment.id, basicLightFragment)
            }

            ADJUST_SCREEN -> {
                fragmentTransaction.replace(binding.fcvFragment.id, adjustScreenFragment)
            }

            USING_LIGHT -> {
                fragmentTransaction.replace(binding.fcvFragment.id, usingLightFragment)
            }
            else -> {
                return
            }
        }
        fragmentTransaction.disallowAddToBackStack()
        fragmentTransaction.commit()
    }

    companion object {
        const val FRAGMENT_EXTRA = "fragment"
        const val BASIC_LIGHT = "basic light fragment"
        const val ADJUST_SCREEN = "adjust screen fragment"
        const val USING_LIGHT = "using light fragment"
    }
}