package com.cibertec.mycl1andreechiquisapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResumenDelPedido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen_del_pedido)
        val bundle = intent.extras

        val tvresult :TextView = findViewById(R.id.tvresult)
        val btnvolver : Button =  findViewById(R.id.btnVolver)
        val dni = bundle?.getString("KEY_DNI") ?: getString(R.string.desconocido)
        val name = bundle?.getString("KEY_NAME") ?: getString(R.string.desconocido)
        val plato = bundle?.getString("KEY_PLATO") ?: getString(R.string.desconocido)
        val costoplato = bundle?.getString("KEY_COSTOPLATO") ?: getString(R.string.desconocido)
        val pricebolsa = bundle?.getString("KEY_BOLSA") ?: getString(R.string.desconocido)
        val privedelivery = bundle?.getString("KEY_DELIVERY") ?: getString(R.string.desconocido)
        val gastos = bundle?.getString("KEY_GASTO") ?: getString(R.string.desconocido)
        val pricetotal = bundle?.getString("KEY_TOTAL") ?: getString(R.string.desconocido)
        val page = bundle?.getString("KEY_PAGE") ?: getString(R.string.desconocido)

        val resultConcat =
            "Cliente: \n" +
                    "$name \n" +
                    "\n" +
                    "Dni:\n" +
                    "$dni \n" +
                    "\n" +
                    "Plato del día:\n" +
                    "$plato \n"+
                    "\n"+
                    "Costo del plato: \n" +
                    "$costoplato \n"+
                    "\n"+
                    "Medio de Pago: \n" +
                    "$page \n"+
                    "\n"+
                    "Gastos Adicionales: \n" +
                    "\n"+
                    "--------- \n"+
                    "Bolsas: \n" +
                    "$pricebolsa \n"+
                    "\n"+
                    "Delivery: \n" +
                    "$privedelivery \n"+
                    "\n"+
                    "Total Adicionales: \n" +
                    "$gastos \n"+
                    "\n" +
                    "Total: \n" +
                    "$pricetotal \n"+
                    "\n"+" "

        tvresult.text=resultConcat

        btnvolver.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}