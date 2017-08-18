package practice

import java.util.*



enum class RoboModel(val mark: String) {
    OPTRON("OPT-345-A"), EMPRON("EMP-199-A"), GLADIOR("GLD-366-S");

    fun getClassSet(): Set<Char> {
        val classSet = HashSet<Char>()
        RoboModel.values().forEach { classSet.add(it.mark.last()) }
        return classSet
        // what I wanted to do was check to see if S is in the set, and the set is larger than 1, then move S to the first position
        // also override HashSet toString
    }
}

interface Classifiable {
    fun getClassification(): Char
}

open class Robo(val rm: RoboModel) : Classifiable {
    val S: Char = 'S'
    override fun getClassification(): Char = rm.mark.last()

    object DieRoll{
        fun roll(min:Int = 1, max:Int = 6):Int = (min..max).rand()
        fun ClosedRange<Int>.rand():Int = Random().nextInt(endInclusive - start +1) + start
        // want the 6 to be included too
    }

}

fun main(args: Array<String>) {
    val r = Robo(RoboModel.OPTRON)
    println(r.getClassification())
    println(r.rm.getClassSet())
    (1..10).forEach { println(Robo.DieRoll.roll(max = 7)) }
}