package com.example.lucas.bacias_hidrograficas.waterMap

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lucas.bacias_hidrograficas.R
import com.example.lucas.bacias_hidrograficas.waterMap.description.WaterResourcesDescription

class WaterMapFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag3_layout, null)

        val textView = view.findViewById<TextView>(R.id.textView2)
        textView.setOnClickListener { view1: View? ->
            val intent = Intent(context, WaterResourcesDescription::class.java)
            startActivity(intent)
        }

        return (view)
    }
}
