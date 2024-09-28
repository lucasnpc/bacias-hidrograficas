package com.example.lucas.bacias_hidrograficas.saoPauloMap.description

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lucas.bacias_hidrograficas.R
import com.example.lucas.bacias_hidrograficas.databinding.DescMapSpActivityBinding

class MapDescriptionSP : AppCompatActivity() {

    private val binding: DescMapSpActivityBinding by lazy {
        DescMapSpActivityBinding.inflate(layoutInflater)
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.close.bClose.setOnClickListener { finish() }

        setSupportActionBar(binding.content.toolbar)
        title = "Descrição"

        val text = ("<html><body align=\"justify\" style=\"font-size:15px\">"
                + getString(R.string.descricao_bacias_sp)
                + "</body></html>")
        binding.content.webview2.loadData(text, "text/html", "UTF-8")
    }
}
