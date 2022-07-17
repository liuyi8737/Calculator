package com.example.calculator.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.replaceLast

class MainViewModel:ViewModel() {
    var num1:StringBuilder = StringBuilder()
    var num2:String = ""
    set(value){
        field = value
        if (value.isNotEmpty()) {
            calculate()
        }
    }

    var mOperation:CalculateOperation= CalculateOperation.None
    var details = MutableLiveData("")
    var result = MutableLiveData("")
    var isFirst = true//1
    var lastIsOperation = false//5

    
    fun  onAction(action:CalculatorAction){
         when(action){
             is CalculatorAction.Clear->clearAll()
             is CalculatorAction.Delete->delete()
             is CalculatorAction.Equal->calculate()
             is CalculatorAction.Operation->saveOperation(action.operation)
             is CalculatorAction.Number->buildNumber(action.number)
         }
    }
    fun clearAll(){
        num1.clear()
        num2 = ""
        result.postValue("")
        mOperation = CalculateOperation.None
        isFirst = true
        lastIsOperation = false
        details.postValue("")
    }
    fun delete(){}
    fun calculate(){
        val v1 = num1.toString().toDouble()
        val v2 = num2.toDouble()
        val value = when(mOperation){
            is CalculateOperation.Add->v1+v2
            is CalculateOperation.Minus->v1-v2
            is CalculateOperation.Multiply->v1*v2
            is CalculateOperation.Divide->v1/v2
            else->0.0
        }
        result.postValue(value.toString())
    }
    fun saveOperation(operation:CalculateOperation){
        //3
        if (isFirst){
            isFirst = false
        }
        //4
        if (num1.isNotEmpty()){
            if (lastIsOperation){
                   details.postValue(details.value?.replaceLast(operation.Symbol))
            }else{
                details.postValue(details.value?.plus(operation.Symbol))
                lastIsOperation = true
            }
            this.mOperation = operation

            if (result.value!!.isNotEmpty()){
                num1.clear()
                num1.append(result.value)
                num2 = ""
            }
        }
    }
    fun buildNumber(number:String){
        //2
        details.postValue(details.value?.plus(number))
        if (lastIsOperation){
            lastIsOperation = false
        }
        //1
        if (isFirst){
            num1.append(number)
        }else{
            num2 =  num2.plus(number)
        }
    }
}
