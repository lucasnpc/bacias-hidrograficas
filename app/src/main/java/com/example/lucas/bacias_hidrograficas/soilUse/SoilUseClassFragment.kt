package com.example.lucas.bacias_hidrograficas.soilUse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lucas.bacias_hidrograficas.R

class SoilUseClassFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag4_layout, null)
        return (view)
    }
}
