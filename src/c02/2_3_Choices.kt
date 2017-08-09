package c02

import java.util.*

// enums and when

// enum is a soft keyword, only meaningful if it precedes class keyword

enum class Colour{ RED, ORANGE, GREEN, BLACK, FLASHING }

enum class Colour1(val r:Int, val g:Int, val b:Int){
    RED     (255, 0,0),
    ORANGE  (255, 165, 0),
    GREEN   (0, 255, 0); // semicolon is required

    fun averageColour() = (r + g + b) * 0.333
}

fun enumFunction(){
    println(Colour1.ORANGE.averageColour())
    println(Colour1.ORANGE.g)
    println(Arrays.toString(Colour1.values())) // will [print, the, array]
    for (colourEnumVal in Colour1.values()) println(colourEnumVal) // will list out one by one
}

fun getMapper(col:Colour) = when(col){
    Colour.GREEN    -> "GOGOGO"
    Colour.RED      -> "STOP"
    Colour.ORANGE   -> "SLOW"
    Colour.BLACK, Colour.FLASHING-> "Maintenence"
}

