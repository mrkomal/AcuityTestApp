package com.example.acuitytestapp.lettersGenerator

import com.example.acuitytestapp.snellenchart.DefaultSnellenChart

class LettersGenerator {

    var snellenChart : DefaultSnellenChart = DefaultSnellenChart()

    // trial
    val exampleString : String = "abcdefghijk"

    //shuffled list from String
    var exampleList = exampleString.split("")
        .filter { it.isNotEmpty() }
        .shuffled()
        .toMutableList()

    fun yieldLetter() : String {
        return if(exampleList.isNotEmpty()) exampleList.removeAt(0) else "Over"
    }

}