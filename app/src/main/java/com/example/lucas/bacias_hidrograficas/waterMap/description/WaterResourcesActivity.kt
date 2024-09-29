package com.example.lucas.bacias_hidrograficas.waterMap.description

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lucas.bacias_hidrograficas.R
import com.example.lucas.bacias_hidrograficas.databinding.DescRecursosHidricosBinding

class WaterResourcesActivity : AppCompatActivity() {

    private val binding by lazy {
        DescRecursosHidricosBinding.inflate(layoutInflater)
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.close.bClose.setOnClickListener { finish() }

        setSupportActionBar(binding.content.toolbar)
        title = "Descrição"

        val text = ("<html><body align=\"justify\" style=\"font-size:15px\">"
                + getString(R.string.descricao_recursos_hidricos)
                + "</body></html>")
        binding.content.webview.settings.javaScriptEnabled = true
        binding.content.webview.loadData(text, "text/html", "UTF-8")
    }
}
