package com.example.lucas.bacias_hidrograficas

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var fragmentManager: FragmentManager = supportFragmentManager
    private var idControl: Int = 0

    private val drawer: DrawerLayout by lazy {
        findViewById(R.id.drawer_layout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.nav_inicio)
        idControl = R.id.nav_inicio

        if (savedInstanceState == null) {
            val measurementPointsFragment =
                MeasurementPointsFragment()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.content_main, measurementPointsFragment)
            fragmentTransaction.commit()
            title = "Início"
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawer.closeDrawer(GravityCompat.START)
        when (val id = item.itemId) {
            R.id.nav_inicio -> {
                if (id == idControl) return false
                idControl = id
                val measurementPointsFragment =
                    MeasurementPointsFragment()
                selecionaFragmento(measurementPointsFragment, null)
                title = "Início"
            }

            R.id.mapa_bacias_sp -> {
                if (id == idControl) return false
                idControl = id
                val saoPauloMapFragment =
                    SaoPauloMapFragment()
                selecionaFragmento(saoPauloMapFragment, "pilha")
                title = "Bacias de São Paulo"
            }

            R.id.mapa_bacias_serra -> {
                if (id == idControl) return false
                idControl = id
                val fragment3 = Fragment3()
                selecionaFragmento(fragment3, "pilha")
                title = "Bacia Serra da Mantiqueira"
            }

            R.id.nav_ocupacao -> {
                if (id == idControl) return false
                idControl = id
                val fragment4 = Fragment4()
                selecionaFragmento(fragment4, "pilha")
                title = "Ocupaçao do solo"
            }

            R.id.nav_industria -> {
                if (id == idControl) return false
                idControl = id
            }

            R.id.nav_sair -> {
                finish()
            }
        }

        return true
    }

    private fun selecionaFragmento(fragment: Fragment, string: String?) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content_main, fragment)
        fragmentTransaction.addToBackStack(string)
        fragmentTransaction.commit()
    }
}