package com.example.calculator.model

sealed class CalculateOperation(val Symbol:String){
    object Add:CalculateOperation("+")
    object Minus:CalculateOperation("-")
    object Multiply:CalculateOperation("×")
    object Divide:CalculateOperation("÷")
    object None:CalculateOperation("")
}
