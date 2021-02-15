package com.nasapictures.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.viewpager2.widget.ViewPager2
import com.nasapictures.app.adapters.NasaDetailsPagerAdapter
import com.nasapictures.app.adapters.NasaItemAdapter
import com.nasapictures.app.databinding.FragmentNasaDetailsBinding
import com.nasapictures.app.viewmodels.NasaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NasaViewPagerFragment : Fragment() {

    private val viewModel: NasaViewModel by viewModels()
    private lateinit var nasaDetailsAdapter : NasaDetailsPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNasaDetailsBinding.inflate(inflater, container, false)
        fetchNasaItems(binding)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        return binding.root
    }

    private fun fetchNasaItems(binding: FragmentNasaDetailsBinding) {
        viewModel.fetchNasaItems().asLiveData().observe(viewLifecycleOwner) { result ->
            binding.vpImages.adapter = nasaDetailsAdapter
            nasaDetailsAdapter = NasaDetailsPagerAdapter(this,result)
        }
    }
}