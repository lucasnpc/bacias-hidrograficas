package com.example.lucas.bacias_hidrograficas.soilUse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lucas.bacias_hidrograficas.databinding.Frag4LayoutBinding

class SoilUseClassFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (Frag4LayoutBinding.inflate(layoutInflater).root)
    }

    companion object {
        const val TAG = "soilUseClassFragment"
    }
}
