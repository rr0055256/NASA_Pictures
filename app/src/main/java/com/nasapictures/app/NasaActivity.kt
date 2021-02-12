package com.nasapictures.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nasapictures.app.databinding.ActivityNasaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NasaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityNasaBinding>(this,R.layout.activity_nasa)
    }
}