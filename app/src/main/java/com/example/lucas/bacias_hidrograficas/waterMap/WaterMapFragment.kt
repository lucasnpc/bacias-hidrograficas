package com.example.lucas.bacias_hidrograficas.waterMap

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lucas.bacias_hidrograficas.databinding.Frag3LayoutBinding
import com.example.lucas.bacias_hidrograficas.waterMap.description.WaterResourcesActivity

class WaterMapFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = Frag3LayoutBinding.inflate(layoutInflater)

        view.textView2.setOnClickListener {
            val intent = Intent(context, WaterResourcesActivity::class.java)
            startActivity(intent)
        }

        return (view.root)
    }

    companion object {
        const val TAG = "WaterMapFragment"
    }
}
