package com.example.acuitytestapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ScoreViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // this method returns true if the specified Class parameter is exactly this Class object; otherwise it returns false.
        if(modelClass.isAssignableFrom(ScoreViewModel::class.java)){
            return ScoreViewModel() as T
        }

        // invalid ViewModel type
        throw IllegalArgumentException("Unknown ViewModel")
    }

}