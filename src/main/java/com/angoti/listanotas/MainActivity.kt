package com.angoti.listanotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.getProdutos()?.enqueue(object : Callback<List<Produto>> {
            override fun onResponse(call: Call<List<Produto>?>?, response: Response<List<Produto>?>?) {
                val listaDeProduto = response?.body()
                produto1.text = listaDeProduto?.get(0)?.descricao
                produto2.text = listaDeProduto?.get(1)?.descricao
                produto3.text = listaDeProduto?.get(2)?.descricao

                imageView1.setImageResource(R.drawable.donut_circle)
                imageView2.setImageResource(R.drawable.icecream_circle)
                imageView3.setImageResource(R.drawable.froyo_circle)

                valor1.text = listaDeProduto?.get(0)?.valor.toString()
                valor2.text = listaDeProduto?.get(1)?.valor.toString()
                valor3.text = listaDeProduto?.get(2)?.valor.toString()

            }

            override fun onFailure(call: Call<List<Produto>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n"+t?.message.toString())
            }
        })

    }
}