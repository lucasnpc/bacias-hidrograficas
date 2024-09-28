package com.example.lucas.bacias_hidrograficas;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager = getSupportFragmentManager();
    int idControl = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_inicio);
        idControl = R.id.nav_inicio;

        if (savedInstanceState == null) {
            Fragment1 fragment1 = new Fragment1();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.content_main, fragment1);
            fragmentTransaction.commit();
            setTitle("Início");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_inicio && idControl != R.id.nav_inicio) {
            Fragment1 fragment1 = new Fragment1();
            selecionaFragmento(fragment1, null);
            idControl = R.id.nav_inicio;
            setTitle("Início");
        } else if (id == R.id.mapa_bacias_sp && idControl != R.id.mapa_bacias_sp) {
            Fragment2 fragment2 = new Fragment2();
            selecionaFragmento(fragment2, "pilha");
            idControl = R.id.mapa_bacias_sp;
            setTitle("Bacias de São Paulo");

        } else if (id == R.id.mapa_bacias_serra && idControl != R.id.mapa_bacias_serra) {
            Fragment3 fragment3 = new Fragment3();
            selecionaFragmento(fragment3, "pilha");
            idControl = R.id.mapa_bacias_serra;
            setTitle("Bacia Serra da Mantiqueira");
        } else if (id == R.id.nav_ocupacao && idControl != R.id.nav_ocupacao) {
            Fragment4 fragment4 = new Fragment4();
            selecionaFragmento(fragment4, "pilha");
            idControl = R.id.nav_ocupacao;
            setTitle("Ocupaçao do solo");
        } else if (id == R.id.nav_industria) {

        } else if (id == R.id.nav_sair) {
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void selecionaFragmento(Fragment fragment, String string) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.addToBackStack(string);
        fragmentTransaction.commit();
    }
}
