package com.example.lucas.bacias_hidrograficas.saoPauloMap

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lucas.bacias_hidrograficas.databinding.SpMapFragmentBinding
import com.example.lucas.bacias_hidrograficas.saoPauloMap.description.MapDescriptionSP

class SaoPauloMapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = SpMapFragmentBinding.inflate(layoutInflater)

        view.textView3.setOnClickListener {
            val intent = Intent(context, MapDescriptionSP::class.java)
            startActivity(intent)
        }

        return (view.root)
    }
}
