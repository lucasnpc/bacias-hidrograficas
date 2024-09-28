package com.example.lucas.bacias_hidrograficas.measurePoints

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lucas.bacias_hidrograficas.R
import com.example.lucas.bacias_hidrograficas.databinding.PointsFragmentBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MeasurementPointsFragment : Fragment(), OnMapReadyCallback {

    private var binding: PointsFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PointsFragmentBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.run {
            mapView.onCreate(savedInstanceState)
            mapView.onResume()
            mapView.getMapAsync(this@MeasurementPointsFragment)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val latLgnCDJ = LatLng(-22.66670000, -45.56666667)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLgnCDJ, 11f))
        googleMap.addMarker(
            MarkerOptions().position(LatLng(-22.70000000, -45.48333333))
                .title("Horto Florestal")
        )
        googleMap.addMarker(
            MarkerOptions().position(LatLng(-22.75000000, -45.66666667))
                .title("EMÍLIO RIBAS - 7.DM")
        )
        googleMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    -22.716666666666665,
                    -45.56666666666667
                )
            )
                .title("Campos do Jordão - Capivari")
        )
        googleMap.addMarker(
            MarkerOptions().position(LatLng(-22.7333333333333, -45.4833333333333))
                .title("Campos do Jordão")
        )
        googleMap.addMarker(
            MarkerOptions().position(LatLng(-22.69360000, -45.50555556))
                .title("JUSANTE DA ETE DE CAMPOS DO JORDÃO")
        )
        googleMap.addMarker(
            MarkerOptions().position(LatLng(-22.71610000, -45.56000000))
                .title("PONTE AV. EMILIO LANG JR.")
        )
        googleMap.addMarker(
            MarkerOptions().position(LatLng(-22.6878, -45.4797))
                .title("FAZENDA DA GUARDA")
        )
        googleMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    -22.833333333333332,
                    -45.63333333333333
                )
            )
                .title("EUGENIO LEFREVE")
        )
        googleMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    -22.716666666666665,
                    -45.53333333333333
                )
            )
                .title("Usina do Fojo")
        )
        googleMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    -22.683333333333334,
                    -45.733333333333334
                )
            )
                .title("São Bento do Sapucaí")
        )


        googleMap.setOnMarkerClickListener { marker: Marker ->
            binding?.rain?.run {
                bChuva.visibility = View.VISIBLE
                bChuva.setOnClickListener {
                    when (marker.title) {
                        "Campos do Jordão - Capivari" -> {
                            tornavisivel(R.drawable.chuva_capivari)
                        }

                        "Campos do Jordão" -> {
                            tornavisivel(R.drawable.chuva_cdj)
                        }

                        "FAZENDA DA GUARDA" -> {
                            tornavisivel(R.drawable.chuva_fazendaguarda)
                        }

                        "EUGENIO LEFREVE" -> {
                            tornavisivel(R.drawable.chuva_eugeniolefevre)
                        }

                        "Usina do Fojo" -> {
                            tornavisivel(R.drawable.chuva_usinafojo)
                        }

                        "São Bento do Sapucaí" -> {
                            tornavisivel(R.drawable.chuva_sbs)
                        }

                        else -> Toast.makeText(
                            context,
                            "Não existe dados para este ponto",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            false
        }
        googleMap.setOnMapClickListener {
            binding?.infoRain?.infoChuva?.visibility = View.INVISIBLE
            binding?.rain?.bChuva?.visibility = View.INVISIBLE
        }
    }

    private fun tornavisivel(drawable: Int) {
        binding?.run {
            binding?.infoRain?.infoChuva?.visibility = View.VISIBLE
            binding?.rain?.bChuva?.visibility = View.INVISIBLE
            binding?.infoRain?.rainInfoImage?.setImageResource(drawable)
        }
    }
}
