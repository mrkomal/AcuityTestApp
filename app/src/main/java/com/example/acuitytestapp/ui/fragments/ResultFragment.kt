package com.example.acuitytestapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.acuitytestapp.R
import kotlinx.android.synthetic.main.fragment_info1.*
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result_finish_button.setOnClickListener{view ->
            val action = ResultFragmentDirections.actionResultFragmentToModeChoiceFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }
    }
}