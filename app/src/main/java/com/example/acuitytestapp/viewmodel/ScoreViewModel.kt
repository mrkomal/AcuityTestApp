package com.example.acuitytestapp.viewmodel

import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    //variable that holds the number of already displayed letters
    private var numOfDisLetters : Int = 0

    //variable that keeps track of the user's correct answers
    private var numOfCorrAnswers : Int = 0

}