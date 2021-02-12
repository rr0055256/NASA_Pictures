package com.nasapictures.app.viewmodels

import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.nasapictures.app.NasaApp
import com.nasapictures.app.data.NasaItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class NasaViewModel @Inject constructor(var app: NasaApp) : ViewModel() {
    fun fetchNasaItems() : Flow<List<NasaItem>> {
        val gson = Gson()
        return flow {  gson.fromJson(app.applicationContext.assets.readAssetsFile("nasa.json"),Array<NasaItem>::class.java).toList() }
    }
}

private fun AssetManager.readAssetsFile(fileName : String): String = open(fileName).bufferedReader().use{it.readText()}