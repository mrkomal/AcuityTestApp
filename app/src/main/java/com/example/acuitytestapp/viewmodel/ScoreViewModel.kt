package com.example.acuitytestapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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


    fun triggerButtonProcedure (answerIsCorrect : Boolean) {
        _numOfAllAnswers.value = _numOfAllAnswers.value!! + 1
        if(answerIsCorrect) {
            _numOfCorrectAnswers.value = _numOfCorrectAnswers.value!! + 1
        }
    }
}
