package com.example.calculator

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var num1:StringBuilder = StringBuilder()
    var num2:StringBuilder = StringBuilder()
    lateinit var operation:String
    var isFirstNumber = true//是不是输入一个运算数
    //用来保存运算的过程
    var details = StringBuilder()
    var currentOperation:String? = null//记录当前运算符

    /**
     * 新东西
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clearBtn.setOnClickListener{
            details.clear()
            num1.clear()
            num2.clear()
            isFirstNumber = true
            currentOperation = null
            detailTextView.text = "0"
            resultTextView.text = "0"
        }
        divideBtn.setOnClickListener {
            operationBtnClicked(it)
        }
        multiplyBtn.setOnClickListener {
            operationBtnClicked(it)
        }
        minusBtn.setOnClickListener {
            operationBtnClicked(it)
        }
        addBtn.setOnClickListener {
            operationBtnClicked(it)
        }

        oneBtn.setOnClickListener {
            numberBtnClicked(it)
        }
        twoBtn.setOnClickListener {
            numberBtnClicked(it)
        }
       threeBtn.setOnClickListener {
            numberBtnClicked(it)
        }
       fourBtn.setOnClickListener {
            numberBtnClicked(it)
        }
        fiveBtn.setOnClickListener {
            numberBtnClicked(it)
        }
        sixBtn.setOnClickListener {
            numberBtnClicked(it)
        }
        sevenBtn.setOnClickListener {
            numberBtnClicked(it)
        }
        eightBtn.setOnClickListener {
            numberBtnClicked(it)
        }
        nineBtn.setOnClickListener {
            numberBtnClicked(it)
        }
       zeroBtn.setOnClickListener {
            numberBtnClicked(it)
        }
        dzeroBtn.setOnClickListener {
            numberBtnClicked(it)
        }

        dotBtn.setOnClickListener {
        }


        equalBtn.setOnClickListener {
            if(num1.isNotEmpty()&&num2.isNotEmpty()&&operation.isNotEmpty()){
                val v1 = num1.toString().toDouble()
                val v2 = num2.toString().toDouble()
               val result =  when(operation){
                    "1"->v1/v2
                   "2"->v1*v2
                   "3"->v1-v2
                   "4"->v1+v2
                   else->{0f}
                }
                resultTextView.text = "$result"
                num1.clear()
                num2.clear()
                num1.append("$result")
            }
        }


        deleteBtn.setOnClickListener{
            if(details.isNotEmpty()){
                //删除最后一个内容
                details.replace(details.length-1,details.length,"")
                //重新显示
                if(details.isEmpty()){
                    detailTextView.text ="0"
                    isFirstNumber=true
                }else {
                    detailTextView.text = details.toString()
                }
            }
        }
    }

    //任务
    fun operationBtnClicked(view: View) {
        //判断num1是否有数字
        if (num1.isNotEmpty()) {
            //第一个运算数输入结束
                isFirstNumber = false
            operation = view.tag as String

            //判断当前输入是不是多次输入运算符
            if(currentOperation ==null){
                details.append(getOperation(operation))
                currentOperation=operation
                }else{
                    //多次输入运算符 需要用当前的运算符去替换最后一个运算符
                    details.replace(details.length-1,details.length,getOperation(operation))
            }
            detailTextView.text = details.toString()
        }
    }


        fun numberBtnClicked(view: View) {
            //记录当前过程
            val numString = view.tag as String
            //记录当前过程
            details.append(numString)
            //显示详情
            detailTextView.text = details.toString()
            //输入数字之后又可以输入运算符
            if(currentOperation!=null){
                currentOperation=null
            }
            //判断是不是在输入第一个操作数
            if (isFirstNumber) {
                num1.append(numString)
            } else {
                num2.append(numString)
            }
        }


    //获取tag对应的运算符
    fun getOperation(tag:String):String{
        return  when (operation) {
            "1" -> "÷"
            "2" -> "×"
            "3" -> "-"
            "4" -> "+"
            else -> {""}
            //显示详情
        }
    }
    }

