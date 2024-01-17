package com.family.lucky.lightSensor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.family.lucky.R
import com.family.lucky.databinding.FragmentAdjustScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AdjustScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdjustScreenFragment : Fragment() {
    private lateinit var binding: FragmentAdjustScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdjustScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = AdjustScreenFragment()
    }
}