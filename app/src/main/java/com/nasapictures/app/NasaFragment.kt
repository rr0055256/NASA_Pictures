package com.nasapictures.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.nasapictures.app.adapters.NasaItemAdapter
import com.nasapictures.app.databinding.FragmentNasaBinding
import com.nasapictures.app.viewmodels.NasaViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

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

        binding.toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }

        fetchNasaItems(adapter,binding)
        return binding.root
    }

        private fun fetchNasaItems(adapter: NasaItemAdapter, binding: FragmentNasaBinding) {
        lifecycleScope.launch {
            viewModel.fetchNasaItems().collect {
                run {
                    binding.hasItems = !it.isNullOrEmpty()
                    adapter.submitList(it)
                }
            }
        }

    }
}