package com.example.acuitytestapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acuitytestapp.repository.ResultRepository
import kotlinx.coroutines.launch

class ResultViewModel(private val repository: ResultRepository) : ViewModel() {

    private val positiveComment = "Your eyes seem to be OK."
    private val negativeComment = "Your should definitely visit ophthalmologist."

    val resultRightEye = formResult(repository.numRightEye, repository.maxRightEye)
    val resultLeftEye = formResult(repository.numLeftEye, repository.maxLeftEye)
    val lenPowerRightEye = formLenPower(repository.lenPowerRightEye)
    val lenPowerLeftEye = formLenPower(repository.lenPowerLeftEye)

    val comment = if(repository.lenPowerRightEye < -0.5 || repository.lenPowerLeftEye < -0.5) negativeComment else positiveComment

    private fun formResult(result: Int, max: Int): String  {
        return String.format("%d/%d", result, max)
    }

    private fun formLenPower(power: Double): String {
        return String.format("%s 1/m", power.toString())
    }
}