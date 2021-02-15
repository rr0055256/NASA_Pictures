package com.nasapictures.app.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nasapictures.app.NasaDetailsFragment
import com.nasapictures.app.data.NasaItem
import dagger.hilt.android.AndroidEntryPoint

class NasaDetailsPagerAdapter(fragment: Fragment,var nasaItems : List<NasaItem>?) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return nasaItems?.size ?: 0
    }

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putInt(NasaDetailsFragment.POS,position)
        val nasaDetailsFragment = NasaDetailsFragment()
        nasaDetailsFragment.arguments = bundle
        return nasaDetailsFragment
    }
}