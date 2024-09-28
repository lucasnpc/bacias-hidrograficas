package com.example.lucas.bacias_hidrograficas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Fragment1 extends Fragment implements OnMapReadyCallback {

    MapView mapView;
    Button button;
    ImageView imageView;
    private RelativeLayout relativeLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1_layout, null);
        button = view.findViewById(R.id.b_chuva);
        imageView = view.findViewById(R.id.image_teste);
        relativeLayout = view.findViewById(R.id.info_chuva);

        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
        return (view);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng CDJ = new LatLng(-22.66670000, -45.56666667);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CDJ, 11));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.70000000, -45.48333333))
                .title("Horto Florestal"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.75000000, -45.66666667))
                .title("EMÍLIO RIBAS - 7.DM"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.716666666666666666666666666667, -45.566666666666666666666666666667))
                .title("Campos do Jordão - Capivari"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.7333333333333, -45.4833333333333))
                .title("Campos do Jordão"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.69360000, -45.50555556))
                .title("JUSANTE DA ETE DE CAMPOS DO JORDÃO"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.71610000, -45.56000000))
                .title("PONTE AV. EMILIO LANG JR."));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.6878, -45.4797))
                .title("FAZENDA DA GUARDA"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.833333333333333333333333333333, -45.633333333333333333333333333333))
                .title("EUGENIO LEFREVE"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.716666666666666666666666666667, -45.533333333333333333333333333333))
                .title("Usina do Fojo"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.683333333333333333333333333333, -45.733333333333333333333333333333))
                .title("São Bento do Sapucaí"));


        googleMap.setOnMarkerClickListener(marker -> {
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(view -> {
                if (marker.getTitle().equals("Campos do Jordão - Capivari")) {
                    tornavisivel(R.drawable.chuva_capivari);
                } else if (marker.getTitle().equals("Campos do Jordão")) {
                    tornavisivel(R.drawable.chuva_cdj);
                } else if (marker.getTitle().equals("FAZENDA DA GUARDA")) {
                    tornavisivel(R.drawable.chuva_fazendaguarda);
                } else if (marker.getTitle().equals("EUGENIO LEFREVE")) {
                    tornavisivel(R.drawable.chuva_eugeniolefevre);
                } else if (marker.getTitle().equals("Usina do Fojo")) {
                    tornavisivel(R.drawable.chuva_usinafojo);
                } else if (marker.getTitle().equals("São Bento do Sapucaí")) {
                    tornavisivel(R.drawable.chuva_sbs);
                } else
                    Toast.makeText(getContext(), "Não existe dados para este ponto",
                            Toast.LENGTH_SHORT).show();
            });
            return false;
        });
        googleMap.setOnMapClickListener(latLng -> {
            relativeLayout.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
        });
    }

    private void tornavisivel(int drawable) {
        relativeLayout.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        imageView.setImageResource(drawable);
    }
}
