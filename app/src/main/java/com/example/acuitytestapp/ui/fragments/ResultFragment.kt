package com.example.acuitytestapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.acuitytestapp.databinding.FragmentResultBinding
import com.example.acuitytestapp.viewmodel.ResultViewModel
import kotlinx.android.synthetic.main.fragment_result.*
import org.koin.androidx.viewmodel.ext.android.getViewModel


class ResultFragment : Fragment() {

    private lateinit var resultViewModel: ResultViewModel
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        resultViewModel = getViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            with(resultViewModel){
                right_result.text = resultRightEye
                left_result.text = resultLeftEye
                right_len.text = lenPowerRightEye
                left_len.text = lenPowerLeftEye
                comment_text.text = comment
            }

            resultFinishButton.setOnClickListener { view ->
                val action = ResultFragmentDirections.actionResultFragmentToModeChoiceFragment()
                Navigation.findNavController(requireView()).navigate(action)
            }
        }
    }
}