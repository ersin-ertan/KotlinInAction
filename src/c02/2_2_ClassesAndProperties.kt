package c02

class Person(val name:String) // value objects, set is when you create via constructor

fun usingPerson(){
    val p:Person = Person("has constructor")
    p.name // has getter, public by default
    // p.name = "can't chane vals"
}

// properties
class P2(var name:String, var someVar:Boolean = false){ // default false
    fun flipBoolean(inp:Boolean) = !inp
}

fun usingVar(){
    val p:P2 = P2("first")
    p.name = "mutable"
    p.name = "variable"
    p.flipBoolean(p.someVar)
}

class P3(var isTrue:Boolean)
fun isPrefixForBooleans(){
    println(P3(false).isTrue)
    // calling from java, no need to call getIsTrue, just call isTrue, but still
    // you must call setIsTrue for setting
}

// custom accessors
class Rect(val height:Int, val width:Int){
    val isSquare:Boolean get(){ return height == width} // property declaration
    //or
    val isSquar:Boolean get() = height == width
    // is computed on each access
    // if you describe the characteristic (the property) of a class,
    // you should declare it as a property
}