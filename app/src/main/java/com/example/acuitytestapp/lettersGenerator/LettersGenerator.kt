package com.example.acuitytestapp.lettersGenerator

import android.util.Log
import com.example.acuitytestapp.snellenchart.DefaultSnellenChart
import com.example.acuitytestapp.snellenchart.ISnellenChart
import kotlin.collections.toMutableList

class LettersGenerator(chart : ISnellenChart = DefaultSnellenChart()) {

    private var snellenChart = chart
    private var currentRowNumber = 0
    private var currentRowLength = 0
    private var currentRowLetters: MutableList<String> = mutableListOf()
    private var currentLetterSizeInPixels = 0
    private var numberOfCorrectAnswersInRow = 0

    var isTestOver = false


    fun checkTestState(): Boolean {
        if(currentRowNumber == snellenChart.mapOfLettersForEachRow.keys.max() && currentRowLetters.isEmpty()) {
            isTestOver = true
        }

        val minValueToPassRow: Float = (currentRowLength.toFloat()/2)
        if(numberOfCorrectAnswersInRow < minValueToPassRow && currentRowLetters.isEmpty()) {
            isTestOver= true
        }
        return isTestOver
    }

    fun yieldLetter(): String {
        /* czy robimy z tym warunkiem? - do rozwazenia
        val minValueToPassRow: Float = (currentRowLength.toFloat()/2)
        || numberOfCorrectAnswersInRow > minValueToPassRow
         */
        if(currentRowLetters.isEmpty() && currentRowNumber != snellenChart.mapOfLettersForEachRow.keys.max()) {
            updateCurrentRowAttributes()
        }

        return if (currentRowLetters.isNotEmpty()) currentRowLetters.removeAt(0) else ""
    }

    fun incrementNumOfCorrectAnsInRow(){
        numberOfCorrectAnswersInRow += 1
    }

    fun getLettersSize(): Int {
        return currentLetterSizeInPixels
    }


    private fun updateCurrentRowAttributes() {
        //going to next row
        currentRowNumber = currentRowNumber.plus(1)

        //splitting string into list of letters
        val row =  snellenChart.mapOfLettersForEachRow[currentRowNumber]
        currentRowLetters = row!!.split("")
            .filter { it.isNotEmpty() }
            .shuffled()
            .toMutableList()

        //updating length of the row
        currentRowLength = row.length

        //updating number of correct answer in a row
        numberOfCorrectAnswersInRow = 0

        //updating letter size
        val currentLetterSizeInMm = snellenChart.mapOfLetterSizesInMmForEachRow[currentRowNumber]
        currentLetterSizeInPixels = getSizeOfLettersInPix(currentLetterSizeInMm!!)
    }

    private fun getSizeOfLettersInPix(mmSize: Double): Int {
        //getting size in mm's and returning size in pixels (approximated)
        return (mmSize/0.26).toInt()
    }

    fun estimateLenPower(): Double {
        return snellenChart.mapOfLensPowerForEachRow[currentRowNumber] ?: error("")
    }

}