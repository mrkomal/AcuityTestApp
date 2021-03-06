package com.example.acuitytestapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.acuitytestapp.R
import com.example.acuitytestapp.databinding.FragmentLiterkowoBinding
import com.example.acuitytestapp.viewmodel.ScoreViewModel
import com.example.acuitytestapp.viewmodel.ScoreViewModelFactory
import kotlinx.android.synthetic.main.fragment_literkowo.*
import kotlinx.android.synthetic.main.fragment_mode_choice.*
import org.koin.androidx.viewmodel.ext.android.getViewModel


class LiterkowoFragment : Fragment() {

//    private lateinit var scoreViewModelFactory : ScoreViewModelFactory
    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var binding: FragmentLiterkowoBinding
    val args: LiterkowoFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_literkowo, container, false)
        binding.lifecycleOwner = this
        scoreViewModel = getViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        scoreViewModelFactory = ScoreViewModelFactory()
//        scoreViewModel = ViewModelProvider(this, scoreViewModelFactory).get(ScoreViewModel::class.java)
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

            scoreViewModel.lettersSize.observe(viewLifecycleOwner, Observer {
                //converting pixels to sp (scale-independent pixels, required for fonts)
                textView.textSize = it * resources.displayMetrics.scaledDensity
            })

            scoreViewModel.letterToDisplay.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })

            scoreViewModel.isTestOver.observe(viewLifecycleOwner, Observer {
                if (it) {
                    when(args.previousInfoFragmentId){
                        1 -> {
                            scoreViewModel.setRightEyeResults()
                            view.findNavController().navigate(R.id.action_literkowoFragment_to_infoFragment2)
                        }
                        else -> {
                            scoreViewModel.setLeftEyeResults()
                            view.findNavController().navigate(R.id.action_literkowoFragment_to_resultFragment)
                        }
                    }
                }
            })
        }
    }
}