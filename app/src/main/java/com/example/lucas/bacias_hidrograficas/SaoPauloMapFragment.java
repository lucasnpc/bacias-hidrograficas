package com.example.lucas.bacias_hidrograficas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SaoPauloMapFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2_layout, null);

        TextView textView = view.findViewById(R.id.textView3);
        textView.setOnClickListener(view1 -> {
            Intent intent;
            intent = new Intent(getContext(), MapDescriptionSP.class);
            startActivity(intent);
        });

        return (view);
    }


}