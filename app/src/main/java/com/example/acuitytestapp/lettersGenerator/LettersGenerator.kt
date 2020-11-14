package com.example.acuitytestapp.lettersGenerator

class LettersGenerator {

    // initial ideas for generating letters

    //mapy - liczba jako klucz + lista przechowujaca kazdą linijke tablicy Snella
    val snellenLettersMap: Map<Int, ArrayList<String>> = mapOf(1 to ArrayList<String>("E"))

    //Stringi to byl pierwszy pomysl, raczej nienajlpeszy, ale znostawiam
    val line1:String = "E"
    val line2:String = "FP"
    val line3:String = "TOZ"
    val line4:String = "LPED"
    val line5:String = "PECFD"
    val line6:String = "EDFCZP"
    val line7:String = "FELOPZD"
    val line8:String = "DEFPOTEC"
    val line9:String = "LEFODPCT"
    val line10:String = "FDPLTCEO"
    val line11:String = "PEZOLCFTD"

    val randomLetter1: String = List(1) { line1.random() }.joinToString("")
    val randomLetter2: String = List(1) { line2.random() }.joinToString("")

}