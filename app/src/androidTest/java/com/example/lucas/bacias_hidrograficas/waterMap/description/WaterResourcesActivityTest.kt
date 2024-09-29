package com.example.lucas.bacias_hidrograficas.waterMap.description

import android.content.Context
import android.view.View
import android.webkit.WebView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lucas.bacias_hidrograficas.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WaterResourcesActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(WaterResourcesActivity::class.java)
    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun testActivityLaunchesSuccessfully() {
        activityRule.scenario.use {
            onView(withId(R.id.desc_rec_hidricos)).check(matches(isDisplayed()))
            onView(withId(R.id.desc_recursos_hidricos_appbar)).check(matches(isDisplayed()))

            onView(withId(R.id.b_close)).perform(click())
        }
//        val expectedString = ("<html><body align=\"justify\" style=\"font-size:15px\">"
//                + context.getString(R.string.descricao_recursos_hidricos)
//                + "</body></html>")
////        onView(withId(R.id.webview))
////            .check(matches(withWebViewContent(containsString(expectedString))))
//
//
//        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
//
//            onView(withId(R.id.desc_rec_hidricos)).check(doesNotExist())

    }

    private fun withWebViewContent(expectedContent: Matcher<String>): Matcher<View> {
        return object : BoundedMatcher<View, WebView>(WebView::class.java) {
            override fun matchesSafely(webView: WebView): Boolean {
                val webViewContent = webView.evaluateJavascript("document.body.innerHTML", null)
                return expectedContent.matches(webViewContent)
            }

            override fun describeTo(description: Description) {
                description.appendText("with WebView content: ")
                expectedContent.describeTo(description)
            }
        }
    }
}