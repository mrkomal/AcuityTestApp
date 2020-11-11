package com.example.acuitytestapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.acuitytestapp.R
import com.example.acuitytestapp.viewmodel.ScoreViewModel
import com.example.acuitytestapp.viewmodel.ScoreViewModelFactory
import com.example.acuitytestapp.viewmodel.scorehandler.ScoreHandler
import kotlinx.android.synthetic.main.fragment_literkowo.*

class LiterkowoFragment : Fragment() {

    private lateinit var scoreViewModelFactory : ScoreViewModelFactory
    private lateinit var scoreViewModel: ScoreViewModel

    private lateinit var scoreHandler: ScoreHandler

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_literkowo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scoreViewModelFactory = ScoreViewModelFactory()
        scoreViewModel = ViewModelProvider(this, scoreViewModelFactory).get(ScoreViewModel::class.java)

        scoreHandler = ScoreHandler()

        button.setOnClickListener { triggerButtonProcedure(true) }
        button2.setOnClickListener { triggerButtonProcedure(false) }
    }

    private fun triggerButtonProcedure (answerIsCorrect : Boolean) {
        val newVal = scoreHandler.incrementValue(scoreViewModel.numOfDisLetters)
        scoreViewModel.numOfDisLetters = newVal
        Log.d(scoreViewModel.TAG, "New number of displayed letters is: $newVal")

        if(answerIsCorrect) {
            val newVal2 = scoreHandler.incrementValue(scoreViewModel.numOfCorrAnswers)
            scoreViewModel.numOfCorrAnswers = newVal2
            Log.d(scoreViewModel.TAG, "New number of correct answers is: $newVal2")
        }
    }

}