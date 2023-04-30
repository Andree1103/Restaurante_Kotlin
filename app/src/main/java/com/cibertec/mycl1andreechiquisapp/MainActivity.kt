package com.cibertec.mycl1andreechiquisapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.webkit.WebView.FindListener
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend : Button = findViewById(R.id.btnSend)
        val rdefectivo: RadioButton = findViewById(R.id.rdefectivo)
        val btnImprimir: Button = findViewById(R.id.btnImprimir)
        val splPlatos: AutoCompleteTextView = findViewById(R.id.spaPlatos)
        val platosList : List<String> = listOf("Ceviche", "Arroz con Pollo", "Lomo Saltado", "Mostrito")
        val cbdelivery:CheckBox = findViewById(R.id.cbdelivery)
        val cbbolsas: CheckBox = findViewById(R.id.cbbolsas)
        val edtDni: EditText = findViewById(R.id.edtDni)
        val edtName: EditText = findViewById(R.id.edtName)

        val tvmenu:TextView = findViewById(R.id.tvmenu)
        val tvbolsas:TextView = findViewById(R.id.tvbolsas)
        val tvdelivery:TextView = findViewById(R.id.tvdelivery)
        val tvadicional:TextView = findViewById(R.id.tvadicional)
        val tvtotal:TextView = findViewById(R.id.tvtotal)

        splPlatos.setAdapter(
            ArrayAdapter(this,R.layout.item_spinner_platos,platosList)
        )

        splPlatos.onItemClickListener=AdapterView.OnItemClickListener{
                adapterView, view,position, l->
            val selected = platosList[position]
            println(selected)
        }

        //BOTON CALCULAR
        btnSend.setOnClickListener {
            val plato = splPlatos.text.toString() // cevichhe
            //pintas
            var costoplato=0
            var pricebolsa = 0
            if(plato == "Ceviche") {
                tvmenu.text= "18"
                costoplato= 18
            }
            if (plato == "Arroz con Pollo"){
                tvmenu.text="17"
                costoplato=17
            }
            if (plato == "Lomo Saltado"){
                tvmenu.text="20"
                costoplato=20
            }
            if (plato == "Mostrito"){
                tvmenu.text="15"
                costoplato=15
            }

            if (cbbolsas.isChecked){
             tvbolsas.text="1"
                pricebolsa = 1
            } else {
                 tvbolsas.text="0"
                pricebolsa = 0
            }
            var privedelivery=0
            if (cbdelivery.isChecked){
                 tvdelivery.text="5"
                privedelivery=5
            } else {
                 tvdelivery.text="0"
                privedelivery=0
            }
            val add= pricebolsa + privedelivery
            val pricetotal = pricebolsa+privedelivery+costoplato
            tvadicional.text=add.toString()
            tvtotal.text=pricetotal.toString()
        }
        btnImprimir.setOnClickListener {
            val dni =edtDni.text.toString()
            val name = edtName.text.toString()
            if (name.isEmpty()) {
                //Toast.makeText(this, getString(R.string.validatorname), Toast.LENGTH_SHORT).show()
                toast("Por Favor Ingrese su Nombre")
                return@setOnClickListener
            }
            if (dni.isEmpty())
            {
                Toast.makeText(this, "Porfavor Ingrese su DNI", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val plato = splPlatos.text.toString()
            var costoplato=0
            var pricebolsa = 0
            if(plato == "Ceviche") {
                    tvmenu.text= "18"
                    costoplato= 18
            }
            if (plato == "Arroz con Pollo"){
                    tvmenu.text="17"
                    costoplato=17
            }
            if (plato == "Lomo Saltado"){
                    tvmenu.text="20"
                    costoplato=20
            }
            if (plato == "Mostrito"){
                    tvmenu.text="15"
                    costoplato=15
            }

            if (cbbolsas.isChecked){
                    tvbolsas.text="1"
                    pricebolsa = 1
            } else {
                    tvbolsas.text="0"
                    pricebolsa = 0
            }
            var privedelivery=0
            if (cbdelivery.isChecked){
                    tvdelivery.text="5"
                    privedelivery=5
            } else {
                    tvdelivery.text="0"
                    privedelivery=0
            }
            val gastos= pricebolsa + privedelivery
            val pricetotal = gastos+costoplato
            val page = if(rdefectivo.isChecked) "Efectivo" else "Tarjeta"
            val bundle = Bundle()
            bundle.apply {
                putString("KEY_DNI",dni)
                putString("KEY_NAME",name)
                putString("KEY_PLATO", plato)
                putString("KEY_COSTOPLATO", costoplato.toString())
                putString("KEY_BOLSA", pricebolsa.toString())
                putString("KEY_DELIVERY", privedelivery.toString())
                putString("KEY_GASTO", gastos.toString())
                putString("KEY_TOTAL", pricetotal.toString())
                putString("KEY_PAGE", page)
            }
            val intent = Intent(this,ResumenDelPedido::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }


}

    fun toast(message:String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }