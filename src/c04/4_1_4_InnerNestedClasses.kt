package c04

import java.io.Serializable

class A(){
    // good for helper class, or code localization
    class B(){
        // don't have access to outer class instance

    }
}

interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class ButtonB:View {

    override fun restoreState(state:State){}
    override fun getCurrentState(): State = ButtonState()

    class ButtonState:State{} // same as static nested class in java, where the
    // implicit reference from that class to its enclosing class is removed

    inner class ButtonStateInner:State{ // now has a reference to ButtonB
        fun getOuterRef():ButtonB = this@ButtonB
    }
}

// nesting may be useful when creating hierarchy containing limited number of classes
