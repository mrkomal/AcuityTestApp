package com.example.acuitytestapp.viewmodel

import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    //tag for logging
    val TAG = "ScoreViewModel"

    //variable that holds the number of already displayed letters
    var numOfDisLetters : Int = 0

    //variable that keeps track of the user's correct answers
    var numOfCorrAnswers : Int = 0

}