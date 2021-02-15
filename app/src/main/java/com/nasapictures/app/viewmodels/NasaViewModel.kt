package com.nasapictures.app.viewmodels

import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.nasapictures.app.data.NasaItem
import com.nasapictures.app.utilities.readAssetsFile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class NasaViewModel @Inject constructor(var assetManager: AssetManager) : ViewModel() {
    fun fetchNasaItems() : Flow<List<NasaItem>> {
        return flow {  Gson().fromJson(assetManager.readAssetsFile("nasa.json"),Array<NasaItem>::class.java).toList() }
    }
}