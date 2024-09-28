package com.example.lucas.bacias_hidrograficas;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class desc_recursos_hidricos extends AppCompatActivity {

    WebView webView;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_recursos_hidricos);
        button = findViewById(R.id.b_close);

        button.setOnClickListener(view -> finish());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        webView = findViewById(R.id.webview);
        setTitle("Descrição");

        String text = "<html><body align=\"justify\" style=\"font-size:15px\">"
                + getString(R.string.descricao_recursos_hidricos)
                + "</body></html>";
        webView.loadData(text, "text/html", "UTF-8");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.desc_rec_hidricos);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
