package com.natura.android.sample.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.natura.android.sample.R
import com.natura.android.sample.components.AppBarActivity
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@Ignore
@RunWith(AndroidJUnit4::class)
class AppBarActivityTest : ScreenShotActivityTestBase() {
    @get:Rule
    var activityTestRule = ActivityTestRule(AppBarActivity::class.java, false, false)

    @Test
    fun test_Snapshot_With_SearchExpanded() {
        val activity = activityTestRule.launchActivity(null)

        checkScreenshot(activity, "default")
        performClick(R.id.searchMenuBtn)
        checkScreenshot(activity, "search_expanded")
    }

    @Test
    fun test_Snapshot_With_Notification_Badge(){
        val activity = activityTestRule.launchActivity(null)
        checkScreenshot(activity, "badge_count_hide")
        performClick(R.id.btnIncrement)
        checkScreenshot(activity, "badge_count_incremented")
    }
}
