package com.nasapictures.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nasapictures.app.databinding.FragmentBottomNasaMetaDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NasaBottomMetaDetailsFragment : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBottomNasaMetaDetailsBinding.inflate(inflater, container, false)
        context ?: return binding.root
        return binding.root
    }
}