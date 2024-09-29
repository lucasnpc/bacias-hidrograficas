package com.example.lucas.bacias_hidrograficas.waterMap.description

import android.webkit.WebView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lucas.bacias_hidrograficas.R
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WaterResourcesActivityTest {

    private val expectedWebViewContent =
        "\"A Política Nacional de Recursos Hídricos, estabelecida pela Lei Federal nº. 9.433, de 8 de janeiro de 1997 " +
                "(BRASIL, 1997), definiu que a gestão dos recursos hídricos seria feita por bacias hidrográficas. A Constituição Federal (BRASIL, 1988)" +
                " determina que a dominialidade seja por corpos d’água, ou seja, por rios, lagos e águas subterrâneas. Dessa forma, " +
                "têm-se dois níveis de domínio e um impasse a ser negociado. Os níveis de domínio são:\\u003Cbr>\\u003Cbr>° Domínio da União: lagos, " +
                "rios e quaisquer correntes em terrenos de seu domínio ou que banhem mais de um Estado, sirvam de limites com outros Países, ou se " +
                "estendam a território estrangeiro ou dele provenham, bem como terrenos marginais e as praias fluviais. (Art. 20, inciso III)." +
                "\\u003Cbr>\\u003Cbr>° Domínio dos Estados: águas superficiais e subterrâneas, fluentes, emergentes e em depósito, ressalvadas nesse caso, " +
                "na forma da lei, as decorrentes de obras da União (Art.26, inciso I).\\u003Cbr>\\u003Cbr>A UGRHI-1 está localizada no noroeste do estado de " +
                "São Paulo. Possui como principais rios o Rio Sapucaí-Guaçu e Sapucaí-Mirim e tem como limítrofes a UGRHI- 2 (Paraíba do Sul), ao sul," +
                " e é margeada pelo estado de Minas Gerais.\""

    @Test
    fun testActivityLaunchesSuccessfully() {
        val scenario = ActivityScenario.launch(WaterResourcesActivity::class.java)
        onView(withId(R.id.desc_rec_hidricos)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_recursos_hidricos_appbar)).check(matches(isDisplayed()))

        scenario.onActivity {
            val webView = it.findViewById<WebView>(R.id.webview)
            assertThat(webView).isNotNull()
            webView.evaluateJavascript("(function() { return document.body.innerHTML; })();") { result ->
                assertThat(result).isEqualTo(expectedWebViewContent)
            }
        }

        onView(withId(R.id.b_close)).perform(click())

        scenario.close()
    }
}