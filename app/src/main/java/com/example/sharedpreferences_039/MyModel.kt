package com.example.sharedpreferences_039

import android.content.SharedPreferences


///  MyModel. Toma un parámetro en su constructor, que es una instancia de SharedPreferences.
// Este objeto SharedPreferences es utilizado para almacenar datos clave-valor en Android
// Pais   3
class MyModel ( private val sharedPreferences: SharedPreferences) {

    //Este  toma función toma una clave como parámetro y devuelve el valor asociado con esa clave desde
    // las SharedPreferences. Si no se encuentra ningún valor asociado con la clave proporcionada,
    // devuelve null
    // buscar

    fun getEmailFromPreferences( key : String ): String?{
        return  sharedPreferences.getString(key, "")
    }

    // guardar en la preferencias
    // Este funcion toma una clave y un valor (en este caso, una dirección de correo electrónico)
    // y los guarda en las SharedPreferences asociadas con la clave proporcionada.

   fun setEmailPreferences( emailKey : String , email : String, keykey : String , key : String ) {
       sharedPreferences.edit().apply {

           putString(emailKey, email)
           putString(keykey, key)
           apply()
       }

   }
       fun removeEmailAndKeyFromPreferences(emailKey: String, keykey: String){

           sharedPreferences.edit().apply {

               remove(emailKey)
               remove(keykey)
               apply()
           }
       }








   }







