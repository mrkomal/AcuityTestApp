package com.example.acuitytestapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acuitytestapp.lettersGenerator.LettersGenerator

class ScoreViewModel : ViewModel() {

    //tag for logging
    var TAG = "ScoreViewModel"

    //variables that keeps track of the user's all/correct answers
    private var _numOfAllAnswers = MutableLiveData(0)
    val numOfAllAnswers: LiveData<Int>
        get() = _numOfAllAnswers

    private var _numOfCorrectAnswers = MutableLiveData(0)
    val numOfCorrectAnswers: LiveData<Int>
        get() = _numOfCorrectAnswers


    //letters info
    private val lettersGenerator = LettersGenerator()

    private var _letterToDisplay = MutableLiveData(lettersGenerator.yieldLetter())
    val letterToDisplay: LiveData<String>
        get() = _letterToDisplay

    private var lettersSize = MutableLiveData(lettersGenerator.getLettersSize())
    val lettersSize : LiveData<Int>
        get() = lettersSize


    //test over information
    private var _isTestOver = MutableLiveData(lettersGenerator.isTestOver)
    val isTestOver: LiveData<Boolean>
        get() = _isTestOver

    fun triggerButtonProcedure (answerIsCorrect : Boolean) {
        _numOfAllAnswers.value = _numOfAllAnswers.value!! + 1
        if(answerIsCorrect) {
            _numOfCorrectAnswers.value = _numOfCorrectAnswers.value!! + 1

            val numOfCorrectAnswersInRow = lettersGenerator.getNumOfCorrectAnswersInRow() + 1
            Log.d("corr", numOfCorrectAnswersInRow.toString())
            lettersGenerator.setNumOfCorrectAnswersInRow(numOfCorrectAnswersInRow)
        }

        _isTestOver.value = lettersGenerator.checkTestState()
        _letterToDisplay.value = lettersGenerator.yieldLetter()
    }
}
