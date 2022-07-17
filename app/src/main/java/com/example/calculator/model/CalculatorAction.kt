package com.example.calculator.model

sealed class CalculatorAction{
    object Clear:CalculatorAction()
    object Delete:CalculatorAction()
    object Equal:CalculatorAction()
    class Operation(val operation: CalculateOperation): CalculatorAction()
    class Number(val number:String):CalculatorAction()

}
