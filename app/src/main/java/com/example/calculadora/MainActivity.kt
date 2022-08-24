package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar!!.hide()

        zero.setOnClickListener { acrescentarExpressao("0", true) }
        um.setOnClickListener { acrescentarExpressao("1", true) }
        dois.setOnClickListener { acrescentarExpressao("2", true) }
        tres.setOnClickListener { acrescentarExpressao("3", true) }
        quatro.setOnClickListener { acrescentarExpressao("4", true) }
        cinco.setOnClickListener { acrescentarExpressao("5", true) }
        seis.setOnClickListener { acrescentarExpressao("6", true) }
        sete.setOnClickListener { acrescentarExpressao("7", true) }
        oito.setOnClickListener { acrescentarExpressao("8", true) }
        nove.setOnClickListener { acrescentarExpressao("9", true) }
        ponto.setOnClickListener { acrescentarExpressao(".", true) }

        soma.setOnClickListener { acrescentarExpressao("+", false) }
        subtracao.setOnClickListener { acrescentarExpressao("-", false) }
        multiplicacao.setOnClickListener { acrescentarExpressao("*", false) }
        divisao.setOnClickListener { acrescentarExpressao("/", false) }

        limpar.setOnClickListener {
            expressao.text = ""
            resultado.text = ""
        }

        backSpace.setOnClickListener {
            val string = expressao.text.toString()
            if(string.isNotBlank()){
                expressao.text = string.substring(0,string.length-1)

            }
            resultado.text = ""
        }

        igual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder( expressao.text.toString()).build()

                val result = expressao.evaluate()
                val longresult = result.toLong()

                if(result == longresult.toDouble()){
                    resultado.text = longresult.toString()
                }
                else{
                    resultado.text = result.toString()
                }

            }catch (e: Exception){

            }
        }

    }

    fun acrescentarExpressao(string: String, limpar_dados : Boolean){

        if(resultado.text.isNotEmpty()){
            expressao.text = ""
        }

        if(limpar_dados){
            resultado.text = ""
            expressao.append(string)
        }else{
            expressao.append(resultado.text)
            expressao.append(string)
            resultado.text = ""
        }

    }
}