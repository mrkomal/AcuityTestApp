package com.example.acuitytestapp.snellenchart

interface ISnellenChart {

    val distanceFromPhoneInMeters : Double

    val mapOfLettersForEachRow : Map<Int, String>

    val mapOfLetterSizesInMmForEachRow : Map<Int, Double>

    val mapOfLensPowerForEachRow : Map<Int, Double>
}