package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.Mascotas
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.database.Propietarios
import com.example.mascotasapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnOtraMascota.setOnClickListener{
            var nombre_propietario= binding.nombrePropietario.text.toString()
            var nombre_mascota= binding.nombreMascota.text.toString()
            var esPerro = binding.radioPerro.isChecked
            var raza_mascota= binding.razaMascota.text.toString()
            var fecha_nacimiento_mascota= binding.fechaNacMascota.text.toString()

            //Insertamos los nuevos datos en la tabla de mascotas para el mismo dueño
            CoroutineScope(Dispatchers.IO).launch {
                MisMascotasApp.database.mascotasDao().addMascota(
                    Mascotas(
                        nombre = nombre_mascota,
                        raza = raza_mascota,
                        esPerro = esPerro,
                        fechaNacimiento = fecha_nacimiento_mascota,
                        //Añadir el dueño de antes en la nueva mascota
                        duenio = nombre_propietario
                    )
                )
            }
        }

        //Funcion sobre boton guardar para insertar los datos introducidos en la tabla propietarios y mascotas
        binding.btnGuardar.setOnClickListener{
            var nombre_propietario= binding.nombrePropietario.text.toString()
            var telefono_propietario= binding.telefonoPropietario.text.toString()
            var direccion_propietario= binding.direccionPropietario.text.toString()
            var nombre_mascota= binding.nombreMascota.text.toString()
            var esPerro = binding.radioPerro.isChecked
            var raza_mascota= binding.razaMascota.text.toString()
            var fecha_nacimiento_mascota= binding.fechaNacMascota.text.toString()

            //Insertamos los datos en la tabla propietarios
            CoroutineScope(Dispatchers.IO).launch { //Para que se ejecute en un hilo secundario
                MisMascotasApp.database.propietariosDao().addPropietario(
                    Propietarios(
                        nombre_propietario = nombre_propietario,
                        telefono_propietario = telefono_propietario,
                        direccion_propietario = direccion_propietario
                    )
                )
            }

            //Insertamos los datos en la tabla mascotas
            CoroutineScope(Dispatchers.IO).launch {
                MisMascotasApp.database.mascotasDao().addMascota(
                    Mascotas(
                        nombre = nombre_mascota,
                        raza = raza_mascota,
                        esPerro = esPerro,
                        fechaNacimiento = fecha_nacimiento_mascota,
                        duenio = nombre_propietario
                    )
                )
            }

            binding.nombreMascota.text.clear()
            binding.radioPerro.isChecked = false
            binding.razaMascota.text.clear()
            binding.fechaNacMascota.text.clear()
        }
    }
}