package practice

import c03.joinToString
import java.time.Instant
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
    fun getClassification(): Char = 'X' // default classification value
    val date:String get() { return Date.from(Instant.now()).toString()    }
}

class IntList(var num:List<Int>):List<Int> by num{ // only interfaces can be delegated to
    override fun toString(): String {
        // calculated on each call
        return this.num.joinToString("_", "Your list: ")
    }

    fun doS(){}
}

open class Robo(val rm: RoboModel) : Classifiable { // open for extension
    val S: Char = 'S'
    val il:IntList? = IntList(listOf(1,3,4))
    var i: Int = 0

    constructor(i: Int?) : this(RoboModel.OPTRON) {// val and var on secondary constructor is not allowed
        // remember that this is the secondary constructor, thus the primary constructor must be 'inherited' from this()
        this.i = checkI(i)
    }

    private fun checkI(i: Int?): Int = when {
        i == null -> 0
        i > 0 -> 1
        i < 0 -> when(i){ // both whens for with and without pram
            is Int -> -10 // checks type
            else -> -1
        }
        else -> {
            println("i is already 0")
            0 // returns 0
        }
    }

    override fun getClassification(): Char = rm.mark.last()

    object DieRoll {
        fun roll(min: Int = 1, max: Int = 6): Int = (min..max).rand()
        fun ClosedRange<Int>.rand(): Int = Random().nextInt(endInclusive - start + 1) + start
        // want the 6 to be included too
    }
}

fun main(args: Array<String>) {
    val r = Robo(RoboModel.OPTRON)
//    println(r.getClassification())
//    println(r.rm.getClassSet()) // accessing the property
//    (1..10).forEach { println(Robo.DieRoll.roll(max = 7)) }
    println(IntList(listOf(1,3,4)).toString())
    println(r.date)
    Thread.sleep(2000)
    println(r.date)
    val list:List<Int> = r.il as IntList
//    list.doS() // unresolved reference
    (list as IntList).doS()
    list.doS()
}