package MODELO

import java.sql.Connection
import java.sql.DriverManager

class Clase_conexion {
    fun cadenaConexion(): Connection? {
        try {
            val url = "jdbc:oracle:thin:@10.10.1.168:1521:xe"
            val user = "system"
            val clave = "desarrollo"
            val conecc = DriverManager.getConnection(url, user, clave)
            return conecc
        } catch (e: Exception) {
            println("Error: $e")
            return null
        }
    }
}