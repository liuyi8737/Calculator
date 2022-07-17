package com.example.calculator

import android.view.View
import androidx.databinding.BindingAdapter
import com.example.calculator.model.CalculateOperation
import com.example.calculator.model.CalculatorAction
import com.example.calculator.model.MainViewModel

class ClickEvents {
    @BindingAdapter("clearBtnClicked")
    fun clearBtnClicked(view: View, viewModel: MainViewModel){
        viewModel.onAction(CalculatorAction.Clear)
    }
    @BindingAdapter("deleteBtnClicked")
    fun deleteBtnClicked(view: View, viewModel: MainViewModel){
        viewModel.onAction(CalculatorAction.Delete)
    }
    @BindingAdapter("operationBtnClicked")
    fun operationBtnClicked(view: View, viewModel: MainViewModel){
        val operation = when(view.tag){
            "1"->CalculateOperation.Divide
            "2"->CalculateOperation.Multiply
            "3"->CalculateOperation.Minus
            "4"->CalculateOperation.Add
            else->CalculateOperation.None
        }
        viewModel.onAction(CalculatorAction.Operation(operation))
    }
    @BindingAdapter("numberBtnClicked")
    fun numberBtnClicked(view: View, viewModel: MainViewModel){
        viewModel.onAction(CalculatorAction.Number(view.tag as String))
    }
    @BindingAdapter("equalBtnClicked")
    fun equalBtnClicked(view: View, viewModel: MainViewModel){
        viewModel.onAction(CalculatorAction.Equal)
    }
}


