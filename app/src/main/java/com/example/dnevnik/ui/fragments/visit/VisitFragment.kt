package com.example.dnevnik.ui.fragments.visit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dnevnik.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VisitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visit, container, false)
    }

}