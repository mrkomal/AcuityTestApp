package com.example.acuitytestapp.lettersGenerator

import android.util.Log
import com.example.acuitytestapp.snellenchart.DefaultSnellenChart
import com.example.acuitytestapp.snellenchart.ISnellenChart
import kotlin.collections.toMutableList

class LettersGenerator(chart : ISnellenChart = DefaultSnellenChart()) {

    private var snellenChart = chart
    private var currentRowNumber = 0
    private var currentRowLength = 0
    private var currentRowLetters: MutableList<String> = mutableListOf() //mutableListOf(snellenChart.mapOfLettersForEachRow[currentRowNumber])
    private var numberOfCorrectAnswersInRow = 0
    var isTestOver = false

    fun checkTestState(): Boolean {
        if(currentRowNumber == snellenChart.mapOfLettersForEachRow.keys.max() && currentRowLetters.isEmpty()) {
            isTestOver = true
        }

        if(numberOfCorrectAnswersInRow < currentRowLength/2 && currentRowLetters.isEmpty()) {
            isTestOver = true
        }
        return isTestOver
    }

    fun yieldLetter(): String {
        if(currentRowLetters.isEmpty() || numberOfCorrectAnswersInRow > currentRowLength/2) {
            updateCurrentRowAttributes()
        }

        return currentRowLetters.removeAt(0)
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
        setNumOfCorrectAnswersInRow(0)
    }

    fun setNumOfCorrectAnswersInRow(newNumber: Int) {
        numberOfCorrectAnswersInRow = newNumber
    }

    fun getNumOfCorrectAnswersInRow() : Int {
        return numberOfCorrectAnswersInRow
    }

/*
    // trial
    val exampleString : String = "abcdefghijk"

    //shuffled list from String
    var exampleList = exampleString.split("")
        .filter { it.isNotEmpty() }
        .shuffled()
        .toMutableList()

    fun yieldLetter() : String {
        //Log.d("Generator", currentRow.toString())
        return if(exampleList.isNotEmpty()) exampleList.removeAt(0) else "Over"
    }
*/
}