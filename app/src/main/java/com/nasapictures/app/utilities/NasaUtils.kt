package com.nasapictures.app.utilities

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.view.Window
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.nasapictures.app.R
import org.joda.time.format.DateTimeFormat

const val DISPLAY_FORMAT = "dd MMM, YYYY"
const val PARSE_FORMAT = "YYYY-MM-dd"

fun AssetManager.readAssetsFile(fileName : String): String = open(fileName).bufferedReader().use{it.readText()}

fun fetchDisplayDate(date : String) : String{
    val dateTimeFormat = DateTimeFormat.forPattern(PARSE_FORMAT)
    return dateTimeFormat.parseDateTime(date).toString(DISPLAY_FORMAT)
}

fun setToolbarBackgroundAndText(bitmap: Bitmap, toolbar: Toolbar, window: Window?) {
    Palette.from(bitmap).generate { palette ->
        toolbar.apply {
            setBackgroundColor(palette?.vibrantSwatch?.rgb ?:
            ContextCompat.getColor(context, R.color.primaryColor))
            window?.statusBarColor = palette?.vibrantSwatch?.rgb ?:
                    ContextCompat.getColor(context, R.color.primaryColor)
        }
    }
}