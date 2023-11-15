package com.dev.horoscapp.ui.luck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dev.horoscapp.databinding.FragmentLockBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LuckFragment : Fragment() {

    private var _binding: FragmentLockBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLockBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}