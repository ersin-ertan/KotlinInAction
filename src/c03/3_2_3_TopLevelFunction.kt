// changing the name of the generated class can be done with
//@file:JvmName("TLF")
// now we just call TLF.topLevelFunc()

package c03

// calling from java, compiler creates a public class TopLevelFunctionKt {
// public static boolean topLevelfunc(){return true}
// } // compiled to static methods thus TopLevelFunctionKt.topLevelFunc()


fun topLevelFunc():Boolean = true