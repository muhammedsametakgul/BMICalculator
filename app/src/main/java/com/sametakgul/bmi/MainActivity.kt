package com.sametakgul.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.sametakgul.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
             binding.btnHesapla.setOnClickListener {
            val Kilo=binding.etKilo.text.toString()
            val Boy=binding.etBoy.text.toString()
                 try {
                     if(Boy == "" && Kilo== ""){
                         Toast.makeText(this,"Lütfen değer giriniz",Toast.LENGTH_SHORT).show()
                     }
                     if(Boy.toInt() == 0 ){
                         Toast.makeText(this,"Boyu 0'dan farklı sayı giriniz",Toast.LENGTH_SHORT).show()

                     }else if(Boy.toInt()<0 && Kilo.toInt()<=0){
                         Toast.makeText(this,"Lütfen Geçerli değerler giriniz",Toast.LENGTH_SHORT).show()
                     }
                     else{
                         val bmi=(Kilo.toFloat())/((Boy.toFloat()/100)*(Boy.toFloat()/100))
                         binding.txtsonuc.text=String.format("%.2f",bmi)
                         binding.cvSonuc.visibility=View.VISIBLE
                         if(bmi<16)
                         {
                             binding.txtSonuc2.text="Aşırı Zayıf"

                         }
                         if(16<bmi && bmi<16.9)
                         {
                             binding.txtSonuc2.text="Ilımlı Zayıf"


                         }
                         if(17<bmi && bmi<18.4)
                         {
                             binding.txtSonuc2.text="Hafif Zayıf"

                         }
                         if(18.5<bmi && bmi<24.9)
                         {
                             binding.txtSonuc2.text="Normal"

                         }
                         if(25<bmi && bmi<29.9)
                         {
                             binding.txtSonuc2.text="Hafif Kilolu"

                         }
                         if(30<bmi )
                         {
                             binding.txtSonuc2.text="Obez"

                         }

                     }
                 }catch (e:Exception){
                     Toast.makeText(this,"Lütfen gecerli bir deger giriniz",Toast.LENGTH_SHORT).show()
                 }








        }
    }
}