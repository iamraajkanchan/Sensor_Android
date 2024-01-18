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
import android.view.WindowManager
import com.family.lucky.databinding.FragmentAdjustScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AdjustScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdjustScreenFragment : Fragment(), SensorEventListener {
    private lateinit var binding: FragmentAdjustScreenBinding
    private lateinit var sensorManager: SensorManager
    private var lightSensor: Sensor? = null
    private lateinit var windowManager: WindowManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdjustScreenBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        windowManager = requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() = AdjustScreenFragment()
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val lux = event?.values?.get(0)
        val layoutParams = requireActivity().window.attributes
        layoutParams.screenBrightness = 1.0f.coerceAtLeast((lux ?: 100.0f) / 500.0f)
        requireActivity().window.attributes = layoutParams
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}