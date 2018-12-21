package com.example.android.codelabs.navigation

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MyTest {

    private val scenario: FragmentScenario<TestFragment> by lazy {

        val arg1 = "my arg 1"
        val arg2 = "my arg 2"

        val directions = HomeFragmentDirections.actionHomeDestToTestFragment()
        directions.setTestArgument1(arg1)
        directions.setTestArgument2(arg2)

        launchFragmentInContainer<TestFragment>(directions.arguments)
    }


    @Test
    fun testArguments() {
        scenario.onFragment { fragment ->
            val args = TestFragmentArgs.fromBundle(fragment.arguments)
            assertThat(args.testArgument1, equalTo("my arg 1"))
            assertThat(args.testArgument2, equalTo("my arg 2"))
        }
    }

    @Test
    fun testShowMessage() {
        scenario
        onView(withId(R.id.tvMessage)).check(matches(withText("waiting for msg")))
        onView(withId(R.id.bShowMessage)).perform(click())
        onView(withId(R.id.tvMessage)).check(matches(withText("message arrived")))
    }

    @Test
    fun testChangeName() {
        scenario.onFragment { fragment ->
            fragment.setTheName("iClaude")
            assertThat(fragment.myName, equalTo("iClaude"))
        }
    }

    @Test
    fun testChangeFragmentState() {
        scenario.moveToState(Lifecycle.State.DESTROYED)
    }

}