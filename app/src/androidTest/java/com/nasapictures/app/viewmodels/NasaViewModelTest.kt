package com.nasapictures.app.viewmodels

import android.content.res.AssetManager
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import androidx.test.platform.app.InstrumentationRegistry
import com.nasapictures.app.NasaApp
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject

@HiltAndroidTest
class NasaViewModelTest{

    private lateinit var viewModel: NasaViewModel
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)

    @Inject
    lateinit var assetManager: AssetManager

    @Before
    fun setUp() {
        hiltRule.inject()
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        viewModel = NasaViewModel(context.assets)
    }

    @Test
    fun testDefaultValues() {
        runBlocking {
            Assert.assertTrue(viewModel.nasaItemList?.isNotEmpty() ?: false)
        }
    }
}