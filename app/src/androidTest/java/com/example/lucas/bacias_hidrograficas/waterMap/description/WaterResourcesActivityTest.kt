package com.example.lucas.bacias_hidrograficas.waterMap.description

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lucas.bacias_hidrograficas.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WaterResourcesActivityTest {

    @Test
    fun testActivityLaunchesSuccessfully() {
        val scenario = ActivityScenario.launch(WaterResourcesActivity::class.java)
        onView(withId(R.id.desc_rec_hidricos)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_recursos_hidricos_appbar)).check(matches(isDisplayed()))


        onView(withId(R.id.b_close)).perform(click())

        scenario.close()
    }

//    private fun withWebViewContent(expectedContent: Matcher<String>): Matcher<View> {
//        return object : BoundedMatcher<View, WebView>(WebView::class.java) {
//            override fun matchesSafely(webView: WebView): Boolean {
//                var webViewContent: String? = null
//                val latch = CountDownLatch(1)
//
//                webView.evaluateJavascript("document.body.innerHTML") { result ->
//                    webViewContent = result?.trim('"')
//                    latch.countDown()
//                }
//
//                latch.await(2, TimeUnit.SECONDS) // Wait for the JavaScript evaluation to complete
//
//                assertThat(webViewContent).isEqualTo(expectedContent)
//                return expectedContent.matches(webViewContent)
//            }
//
//            override fun describeTo(description: Description) {
//                description.appendText("with WebView content: ")
//                expectedContent.describeTo(description)
//            }
//        }
//    }


}