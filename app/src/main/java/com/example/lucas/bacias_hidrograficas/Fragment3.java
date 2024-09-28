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

public class Fragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag3_layout, null);

        TextView textView = view.findViewById(R.id.textView2);
        textView.setOnClickListener(view1 -> {
            Intent intent;
            intent = new Intent(getContext(), WaterResourcesDescription.class);
            startActivity(intent);
        });

        return (view);
    }

}
