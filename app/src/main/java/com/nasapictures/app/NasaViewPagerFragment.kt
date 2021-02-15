package com.nasapictures.app

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.nasapictures.app.adapters.NasaDetailsPagerAdapter
import com.nasapictures.app.databinding.FragmentNasaDetailsBinding
import com.nasapictures.app.utilities.setToolbarBackgroundAndText
import com.nasapictures.app.viewmodels.NasaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NasaViewPagerFragment : Fragment() {

    private val viewModel: NasaViewModel by viewModels()
    private lateinit var nasaDetailsAdapter: NasaDetailsPagerAdapter

    private val nasaViewPagerFragmentArgs: NasaViewPagerFragmentArgs by navArgs()

    private var pos: Int? = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNasaDetailsBinding.inflate(inflater, container, false)
        fetchNasaItems(binding)

        binding.toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
        pos = nasaViewPagerFragmentArgs.index.toInt()
        loadSwatchColors(pos?.let { viewModel.nasaItemList?.get(it)?.url },binding.toolbar,activity?.window)
        binding.toolbar.title = pos?.let {viewModel.nasaItemList?.get(it)?.title}
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_info -> {
                    val directions =
                        NasaViewPagerFragmentDirections.actionNasaMetaDetailsFragmentToNasaBottomMetaDetailsFragment(
                            pos.toString()
                        )
                    findNavController().navigate(directions)
                    true
                }
                else -> false
            }
        }

        binding.toolbar.inflateMenu(R.menu.menu_nasa_details)

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun fetchNasaItems(binding: FragmentNasaDetailsBinding) {
        val nasaItems = viewModel.nasaItemList
        nasaDetailsAdapter = NasaDetailsPagerAdapter(this@NasaViewPagerFragment, nasaItems)
        binding.vpImages.adapter = nasaDetailsAdapter
        binding.vpImages.currentItem = nasaViewPagerFragmentArgs.index.toInt()
        binding.vpImages.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                binding.toolbar.title = nasaItems?.get(position)?.title
                pos = position
                loadSwatchColors(nasaItems?.get(position)?.url, binding.toolbar, activity?.window)
            }
        })
    }

    private fun loadSwatchColors(url: String?, toolbar: Toolbar, window: Window?) {
        Glide.with(requireContext()).asBitmap().load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                ) {
                    setToolbarBackgroundAndText(
                        resource, toolbar, window
                    )
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }
            })
    }
}

