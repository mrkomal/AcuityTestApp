package com.example.acuitytestapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.acuitytestapp.R
import com.example.acuitytestapp.databinding.FragmentLiterkowoBinding
import com.example.acuitytestapp.viewmodel.ScoreViewModel
import com.example.acuitytestapp.viewmodel.ScoreViewModelFactory
import kotlinx.android.synthetic.main.fragment_literkowo.*
import kotlinx.android.synthetic.main.fragment_mode_choice.*


class LiterkowoFragment : Fragment() {

    private lateinit var scoreViewModelFactory : ScoreViewModelFactory
    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var binding: FragmentLiterkowoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_literkowo, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scoreViewModelFactory = ScoreViewModelFactory()
        scoreViewModel = ViewModelProvider(this, scoreViewModelFactory).get(ScoreViewModel::class.java)

        binding.apply {
            // Click listeners on wrong/right buttons
            buttonWrong.setOnClickListener{scoreViewModel.triggerButtonProcedure(false)}
            buttonRight.setOnClickListener{scoreViewModel.triggerButtonProcedure(true)}

            // Observe viewmodel's livedata
            scoreViewModel.numOfAllAnswers.observe(viewLifecycleOwner, Observer {
                numOfAllAnswersTextView.text = "All: " + it.toString()
            })

            scoreViewModel.numOfCorrectAnswers.observe(viewLifecycleOwner, Observer {
                numOfCorrectAnswersTextView.text = "Correct: " + it.toString()
            })

            scoreViewModel.isTestOver.observe(viewLifecycleOwner, Observer {
                if(it) {
                    view.findNavController().navigate(R.id.action_literkowoFragment_to_resultFragment)
                }
            })

            scoreViewModel.lettersSize.observe(viewLifecycleOwner, Observer {
                textView.textSize = it.toFloat()
            })

            scoreViewModel.letterToDisplay.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })

        }
    }
}