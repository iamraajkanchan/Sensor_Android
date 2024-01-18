package com.family.lucky.lightSensor.fragments

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.family.lucky.databinding.FragmentLightAccuracyBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LightAccuracyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LightAccuracyFragment : Fragment(), SensorEventListener {
    private lateinit var binding: FragmentLightAccuracyBinding
    private lateinit var sensorManager: SensorManager
    private var lightSensor: Sensor? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLightAccuracyBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.accuracy != SensorManager.SENSOR_DELAY_NORMAL) return
        val lux = event.values?.get(0)
        binding.tvValue.text = "$lux"
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    companion object {
        @JvmStatic
        fun newInstance() = LightAccuracyFragment()
    }
}