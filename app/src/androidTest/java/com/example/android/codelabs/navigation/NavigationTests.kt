package com.example.android.codelabs.navigation

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class NavigationTests {

    @Test
    fun testNavigationToTestFragment() {
        val scenario = launchFragmentInContainer<HomeFragment>()
        val navController = mock(NavController::class.java)
        scenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.view!!, navController)
        }

        onView(withId(R.id.test_navigation_button)).perform(click())
        val directions = HomeFragmentDirections.actionHomeDestToTestFragment()
        verify(navController).navigate(directions)
    }
}