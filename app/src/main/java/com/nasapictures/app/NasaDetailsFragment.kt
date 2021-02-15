package com.nasapictures.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nasapictures.app.databinding.FragmentNasaMetaDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NasaDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNasaMetaDetailsBinding.inflate(inflater, container, false)
        context ?: return binding.root
        return binding.root
    }
}