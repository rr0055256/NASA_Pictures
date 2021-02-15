package com.nasapictures.app.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nasapictures.app.NasaDetailsFragment
import com.nasapictures.app.data.NasaItem
import dagger.hilt.android.AndroidEntryPoint

class NasaDetailsPagerAdapter(fragment: Fragment,var nasaItems : List<NasaItem>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return nasaItems.size
    }

    override fun createFragment(position: Int): Fragment {
        return NasaDetailsFragment()
    }
}