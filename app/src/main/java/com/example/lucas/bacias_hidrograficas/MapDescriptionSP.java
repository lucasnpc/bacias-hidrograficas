package com.example.lucas.bacias_hidrograficas;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MapDescriptionSP extends AppCompatActivity {

    WebView webView;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_map_sp);
        button = findViewById(R.id.b_close);
        button.setOnClickListener(view -> finish());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Descrição");

        webView = findViewById(R.id.webview2);
        String text = "<html><body align=\"justify\" style=\"font-size:15px\">"
                + getString(R.string.descricao_bacias_sp)
                + "</body></html>";
        webView.loadData(text, "text/html", "UTF-8");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.desc_map_sp);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
