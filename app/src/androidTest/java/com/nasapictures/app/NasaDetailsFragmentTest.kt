package com.nasapictures.app

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.nasapictures.app.utilities.waitUntilViewIsDisplayed
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
class NasaDetailsFragmentTest {

    private val hiltRule = HiltAndroidRule(this)
    private val activityTestRule = ActivityTestRule(NasaActivity::class.java)

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(activityTestRule)

    @Before
    fun jumpToPlantDetailFragment() {
        activityTestRule.activity.apply {
            runOnUiThread {
                val bundle = Bundle().apply { putString("index", "1") }
                findNavController(R.id.nav_host).navigate(R.id.nasaDetailsFragment, bundle)
            }
        }
    }

    @Test
    fun checkDisplayOfDataOnBottomSheet(){
        waitUntilViewIsDisplayed(withId(R.id.ivNasaDetails))
        onView(withId(R.id.action_info)).perform(click())
        waitUntilViewIsDisplayed(withId(R.id.tvDate))
        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
    }
}