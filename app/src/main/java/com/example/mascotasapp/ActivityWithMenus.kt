package com.example.mascotasapp

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenus: AppCompatActivity() {
    companion object {
        // Variable que nos indica en qué opción del menú estamos
        var foco = 1;
    }

    //Relacionamos la clase con el layout del menú que hemos creado
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    // Cuando se pulsa un botón del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.anadir -> {
                item.isEnabled = false // Deshabilitamos el botón para que no se pueda pulsar varias veces
                foco = 1
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.eliminar -> {
                item.isEnabled = false // Deshabilitamos el botón para que no se pueda pulsar varias veces
                foco = 2
                val intent = Intent(this, DeleteActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.actualizar -> {
                item.isEnabled = false // Deshabilitamos el botón para que no se pueda pulsar varias veces
                foco = 3
                val intent = Intent(this, UpdateActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.mostrarNumMasc -> {
                item.isEnabled = false // Deshabilitamos el botón para que no se pueda pulsar varias veces
                foco = 4
                val intent = Intent(this, MostrarActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item) // Si no se pulsa ninguna opción del menú
        }
    }
}