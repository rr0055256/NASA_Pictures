package com.nasapictures.app

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nasapictures.app.databinding.FragmentNasaMetaDetailsBinding
import com.nasapictures.app.viewmodels.NasaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NasaDetailsFragment : Fragment() {

    companion object{
        const val POS = "pos"
    }

    private val viewModel: NasaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNasaMetaDetailsBinding.inflate(inflater, container, false).apply {
            nasaItem = viewModel.fetchNasaItem(arguments?.getInt(POS).toString())
        }
        context ?: return binding.root
        return binding.root
    }
}