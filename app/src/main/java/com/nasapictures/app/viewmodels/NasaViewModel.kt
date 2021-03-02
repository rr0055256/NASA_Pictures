package com.nasapictures.app.viewmodels

import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.nasapictures.app.data.NasaItem
import com.nasapictures.app.utilities.readAssetsFile
import dagger.hilt.android.lifecycle.HiltViewModel
import org.joda.time.DateTimeComparator
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class NasaViewModel @Inject constructor(var assetManager: AssetManager) : ViewModel() {

    val nasaItemList : List<NasaItem>? = fetchNasaItems()

    private fun fetchNasaItems() : List<NasaItem>? {
        return try {
            nasaItemList
                ?: Gson().fromJson(assetManager.readAssetsFile("nasa.json"),Array<NasaItem>::class.java).toList().asReversed()
        }catch (e : Exception){
            null
        }
    }

    fun fetchNasaItem(pos : String) : NasaItem{
        return Gson().fromJson(assetManager.readAssetsFile("nasa.json"),Array<NasaItem>::class.java).toList().asReversed()[pos.toInt()]
    }
}