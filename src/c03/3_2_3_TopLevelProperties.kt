package c03

var opCount = 0

fun performOp() = ++opCount
fun reportOpCount():Int = opCount
// getOpCount didn't work, due to platform declaration clash

val UNIX_LINE_SEPARATOR = "\n" // define constants

// exposed via getter for val, and getter/setter for var

// public static final must be prefixed with const, works with primitives and String
const val PUBLIC_STATIC_FINAL_VAL = "hello"
// java produces
// public static final String PUBLIC_STATIC_FINAL_VAL = "hello";

