package com.example.acuitytestapp.snellenchart

class DefaultSnellenChart : ISnellenChart{

    override val distanceFromPhoneInMeters : Double = 2.9

    override val mapOfLettersForEachRow : Map<Int, String> = mapOf(
        1 to "E",
        2 to "FP",
        3 to "TOZ",
        4 to "LPED",
        5 to "PECFD",
        6 to "EDFCZP",
        7 to "FELOPZD",
        8 to "DEFPOTEC",
        9 to "LEFODPCT",
        10 to "FDPLTCEO",
        11 to "PEZOLCFTD"
    )

    override val mapOfLetterSizesInMmForEachRow: Map<Int, Double> = mapOf(
        1 to 43.0,
        2 to 21.5,
        3 to 15.0,
        4 to 11.0,
        5 to 9.0,
        6 to 6.5,
        7 to 5.5,
        8 to 4.5,
        9 to 3.0,
        10 to 2.5,
        11 to 2.0
    )

    override val mapOfLensPowerForEachRow: Map<Int, Double> = mapOf(
        1 to -3.55,
        2 to -2.37,
        3 to -1.5,
        4 to -1.32,
        5 to -1.05,
        6 to -0.5,
        7 to -0.25,
        8 to 0.0,
        9 to 0.0,
        10 to 0.0,
        11 to 0.0
    )

}