package com.example.lucas.bacias_hidrograficas

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lucas.bacias_hidrograficas.databinding.ActivityMainBinding
import com.example.lucas.bacias_hidrograficas.measurePoints.MeasurementPointsFragment
import com.example.lucas.bacias_hidrograficas.saoPauloMap.SaoPauloMapFragment
import com.example.lucas.bacias_hidrograficas.soilUse.SoilUseClassFragment
import com.example.lucas.bacias_hidrograficas.waterMap.WaterMapFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var idControl: Int = 0

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()
                } else {
                    finish()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val toolbar = binding.appbarMain.toolbar
        setSupportActionBar(toolbar)

        val drawer = binding.drawerLayout
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)
        binding.navView.setCheckedItem(R.id.nav_inicio)
        idControl = R.id.nav_inicio

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        if (savedInstanceState == null) {
            val measurementPointsFragment =
                MeasurementPointsFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(
                R.id.content_main,
                measurementPointsFragment
            )
            fragmentTransaction.addToBackStack(MeasurementPointsFragment.TAG)
            fragmentTransaction.commit()
            title = "Início"
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        when (val id = item.itemId) {
            R.id.nav_inicio -> {
                if (id == idControl) return false
                idControl = id
                val measurementPointsFragment =
                    MeasurementPointsFragment()
                selectFragment(measurementPointsFragment, null, MeasurementPointsFragment.TAG)
                title = "Início"
            }

            R.id.mapa_bacias_sp -> {
                if (id == idControl) return false
                idControl = id
                val saoPauloMapFragment =
                    SaoPauloMapFragment()
                selectFragment(saoPauloMapFragment, "pilha", SaoPauloMapFragment.TAG)
                title = "Bacias de São Paulo"
            }

            R.id.mapa_bacias_serra -> {
                if (id == idControl) return false
                idControl = id
                val waterMapFragment = WaterMapFragment()
                selectFragment(waterMapFragment, "pilha", WaterMapFragment.TAG)
                title = "Bacia Serra da Mantiqueira"
            }

            R.id.nav_ocupacao -> {
                if (id == idControl) return false
                idControl = id
                val soilUseClassFragment = SoilUseClassFragment()
                selectFragment(soilUseClassFragment, "pilha", SoilUseClassFragment.TAG)
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

    private fun selectFragment(fragment: Fragment, string: String?, tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content_main, fragment, tag)
        fragmentTransaction.addToBackStack(string)
        fragmentTransaction.commit()
    }
}
