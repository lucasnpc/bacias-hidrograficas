package com.example.lucas.bacias_hidrograficas.waterMap.description

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.lucas.bacias_hidrograficas.R

class WaterResourcesDescription : AppCompatActivity() {
    private val webView: WebView by lazy {
        findViewById(R.id.webview)
    }
    private val button: Button by lazy {
        findViewById(R.id.b_close)
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desc_recursos_hidricos)

        button.setOnClickListener { finish() }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        title = "Descrição"

        val text = ("<html><body align=\"justify\" style=\"font-size:15px\">"
                + getString(R.string.descricao_recursos_hidricos)
                + "</body></html>")
        webView.loadData(text, "text/html", "UTF-8")
    }
}
