package c04

// majority of where you need overloaded constructors in java are covered by default values
// but its common to extend a framework class that has multiple constructors to initialize

open class SecondaryConstructors{
    constructor(i:Int)
    constructor(s:String)
}
class SecondaryExtended:SecondaryConstructors {
    constructor(i:Int):super(i)
    constructor(s:String):super(s)
    constructor():super(if(true)1 else 0)
//    constructor(intOrString:Boolean):super( if(intOrString) 3 else "hey")
    // conditional branch result of int/string is implicitly cast to Any
    // error - none of the following functions can be called with the arguments supplied
}
// @see https://stackoverflow.com/questions/45665485/kotlin-secondary-constructor-of-extended-class-conditional-branch-super-value
