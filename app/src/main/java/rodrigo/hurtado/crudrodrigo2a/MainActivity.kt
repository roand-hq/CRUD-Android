package rodrigo.hurtado.crudrodrigo2a

import MODELO.Clase_conexion
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.UTFDataFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtPrecio = findViewById<EditText>(R.id.txtPrecio)
        val txtCantidad = findViewById<EditText>(R.id.txtCantidad)
        btnAgregar.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {//como cambiar de rama/ cortina
                val conect = Clase_conexion().cadenaConexion()
                    val addProducto = conect?.prepareStatement("insert into tbProductos(nombreProducto,precio,cantidad) values(?, ?, ?)")!!
                    addProducto.setString(1, txtNombre.text.toString())
                    addProducto.setInt(2,txtPrecio.text.toString().toInt())
                    addProducto.setInt(3,txtCantidad.text.toString().toInt())
                    addProducto.executeUpdate()

                }
            }
        }
    }