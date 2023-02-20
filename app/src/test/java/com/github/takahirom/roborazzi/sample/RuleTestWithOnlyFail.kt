package com.github.takahirom.roborazzi.sample

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.RoborazziRule.Options
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RuleTestWithOnlyFail {
  @get:Rule val roborazziRule = RoborazziRule(
    captureRoot = onView(isRoot()),
    options = Options(
      onlyFail = true
    )
  )

  @Test
  fun captureRoboGifSample() {
    // launch
    launch(MainActivity::class.java)
    // move to next page
    onView(withId(R.id.button_first))
      .perform(click())
    // back
    pressBack()
    // move to next page
    onView(withId(R.id.button_first))
      .perform(click())
  }
}
