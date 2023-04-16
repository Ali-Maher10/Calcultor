package com.example.calcultor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput:TextView?=null
    var LastNumber:Boolean=false
    var LastDot:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput=findViewById(R.id.tvInput)

    }
    fun OnDigit(view: View){
        tvInput?.append((view as Button).text)
        LastNumber=true
        LastDot=false
    }
    fun OnClr(view: View){
        tvInput?.text=""
    }
  fun OnDecimilNumber(view:View){
      if(LastNumber&&!LastDot)
      {
          tvInput?.append(".")
          LastNumber=false
          LastDot=true
      }
  }
      fun OnOperator(view: View){
          if (LastNumber&&!IsOperatorAdd(tvInput?.text.toString()))
          {
              tvInput?.append((view as Button).text)
              LastNumber=false
              LastDot=false
          }
      }
    fun equle(view: View){
        if (LastNumber){
            var tvValue =tvInput?.text.toString()
            var prefix=""
            try {
                if (tvValue.startsWith("-")) {
                    prefix="-"
                    tvValue=tvValue.substring(1)
                }
                if (tvValue.contains("-")){
                val spiltValue = tvValue.split("-")
                var one = spiltValue[0]
                var two = spiltValue[1]
                if (prefix.isNotEmpty()){
                   one =one +prefix
                }
                tvInput?.text = removeZeroAfterResult((one.toDouble() - two.toDouble()).toString())
                }else if (tvValue.contains("+")){
                    val spiltValue = tvValue.split("+")
                    var one = spiltValue[0]
                    var two = spiltValue[1]
                    if (prefix.isNotEmpty()){
                        one =one +prefix
                    }
                    tvInput?.text = removeZeroAfterResult((one.toDouble() + two.toDouble()).toString())
                } else if (tvValue.contains("x")){
                    val spiltValue = tvValue.split("x")
                    var one = spiltValue[0]
                    var two = spiltValue[1]
                    if (prefix.isNotEmpty()){
                        one =one +prefix
                    }
                    tvInput?.text = removeZeroAfterResult((one.toDouble() * two.toDouble()).toString())
                } else if (tvValue.contains("/")){
                    val spiltValue = tvValue.split("/")
                    var one = spiltValue[0]
                    var two = spiltValue[1]
                    if (prefix.isNotEmpty()){
                        one =one +prefix
                    }
                    tvInput?.text = removeZeroAfterResult((one.toDouble() / two.toDouble()).toString())
                }
            }catch (e:ArithmeticException)
            {
                e.printStackTrace()
            }
    }
    }
    fun removeZeroAfterResult(result:String):String{
        var value=result
        if (result.contains(".0")){
            value =result.substring(0,result.length - 2)
        }
return value
    }
    private fun IsOperatorAdd(value: String):Boolean{
  return if(value.startsWith("-")){
    return false
}else{
    value.contains("/")
            ||value.contains("*")
            ||value.contains("+")
            ||value.contains("-")
}
    }
  }

