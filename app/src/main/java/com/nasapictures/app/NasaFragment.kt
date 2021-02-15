package com.nasapictures.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nasapictures.app.adapters.NasaItemAdapter
import com.nasapictures.app.databinding.FragmentNasaBinding
import com.nasapictures.app.utilities.EqualSpacingItemDecoration
import com.nasapictures.app.viewmodels.NasaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NasaFragment : Fragment() {

    private val adapter = NasaItemAdapter()
    private val viewModel: NasaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNasaBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.rvNasaItems.adapter = adapter
        binding.rvNasaItems.addItemDecoration(EqualSpacingItemDecoration(16))

        fetchNasaItems(adapter)
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(),R.color.primaryColor)
        return binding.root
    }

    private fun fetchNasaItems(adapter: NasaItemAdapter) {
        adapter.submitList(viewModel.nasaItemList)
    }
}