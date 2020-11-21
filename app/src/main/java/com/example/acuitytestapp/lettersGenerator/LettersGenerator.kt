package com.example.acuitytestapp.lettersGenerator

import com.example.acuitytestapp.snellenchart.DefaultSnellenChart
import com.example.acuitytestapp.snellenchart.ISnellenChart

class LettersGenerator(chart : ISnellenChart = DefaultSnellenChart()) {

    private var snellenChart = chart

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