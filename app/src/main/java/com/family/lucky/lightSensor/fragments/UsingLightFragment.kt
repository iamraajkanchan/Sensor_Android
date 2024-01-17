package com.family.lucky.lightSensor.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.family.lucky.R
import com.family.lucky.databinding.FragmentUsingLightBinding

/**
 * A simple [Fragment] subclass.
 * Use the [UsingLightFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UsingLightFragment : Fragment() {
    private lateinit var binding: FragmentUsingLightBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsingLightBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = UsingLightFragment()
    }
}