package com.nasapictures.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nasapictures.app.databinding.FragmentBottomNasaMetaDetailsBinding
import com.nasapictures.app.viewmodels.NasaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NasaBottomMetaDetailsFragment : BottomSheetDialogFragment(){

    private val viewModel: NasaViewModel by viewModels()

    private val args : NasaBottomMetaDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBottomNasaMetaDetailsBinding.inflate(inflater, container, false).apply {
            nasaItem = viewModel.fetchNasaItem(args.index)
        }
        context ?: return binding.root
        return binding.root
    }

}