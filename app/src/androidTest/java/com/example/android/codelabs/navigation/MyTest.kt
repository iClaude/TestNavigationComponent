package com.example.android.codelabs.navigation

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.runner.AndroidJUnit4
import com.example.android.codelabs.navigation.HomeFragmentDirections
import com.example.android.codelabs.navigation.TestFragment
import com.example.android.codelabs.navigation.TestFragmentArgs
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText


@RunWith(AndroidJUnit4::class)
class MyTest {

    @Test
    fun testArguments() {
        val arg1 = "my arg 1"
        val arg2 = "my arg 2"

        val directions = HomeFragmentDirections.actionHomeDestToTestFragment()
        directions.setTestArgument1(arg1)
        directions.setTestArgument2(arg2)
        val scenario = launchFragmentInContainer<TestFragment>(directions.arguments)

        scenario.onFragment { fragment ->
            val args = TestFragmentArgs.fromBundle(fragment.arguments)
            assertThat(args.testArgument1, equalTo("my arg 1"))
            assertThat(args.testArgument2, equalTo("my arg 2"))
        }
    }

    @Test
    fun testShowMessage() {
        val arg1 = "my arg 1"
        val arg2 = "my arg 2"

        val directions = HomeFragmentDirections.actionHomeDestToTestFragment()
        directions.setTestArgument1(arg1)
        directions.setTestArgument2(arg2)
        val scenario = launchFragmentInContainer<TestFragment>(directions.arguments)

        onView(withId(R.id.tvMessage)).check(matches(withText("waiting for msg")))
        onView(withId(R.id.bShowMessage)).perform(click())
        onView(withId(R.id.tvMessage)).check(matches(withText("message arrived")))
    }

}