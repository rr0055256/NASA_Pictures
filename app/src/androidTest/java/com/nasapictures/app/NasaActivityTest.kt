package com.nasapictures.app

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.nasapictures.app.utilities.waitUntilViewIsDisplayed
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
class NasaActivityTest{

    private val hiltRule = HiltAndroidRule(this)
    private val activityTestRule = ActivityTestRule(NasaActivity::class.java)

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(activityTestRule)

    @Test
    fun testNavigationToDetailsFromHome(){
        waitUntilViewIsDisplayed(withId(R.id.rvNasaItems))
        onView(withId(R.id.rvNasaItems))
            .perform(
                scrollTo<RecyclerView.ViewHolder>(hasDescendant(withText("M27: The Dumbbell Nebula")))
            ).perform(
                actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    1,
                    click()
                )
            )
        waitUntilViewIsDisplayed(withId(R.id.ivNasaDetails))
        onView(withId(R.id.ivNasaDetails)).check(ViewAssertions.matches(isDisplayed()))

    }

}