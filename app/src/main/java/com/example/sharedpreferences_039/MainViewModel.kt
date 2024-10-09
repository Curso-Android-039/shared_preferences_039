package com.example.sharedpreferences_039

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// 1 para que una clase sea View Model tiene quen heredar de AndroidViewMdel
class MainViewModel(application: Application): AndroidViewModel(application){



 // 2 envolver las cosas en LiveData
      private val sharedPreferences: SharedPreferences = application.getSharedPreferences("sharedPreferences_039",Context.MODE_PRIVATE)
 private val myModel = MyModel(sharedPreferences)

 private val _emailLiveData = MutableLiveData<String?>()
 val emailLiveData: LiveData<String?>
  get() = _emailLiveData

 private val _emailKeyLiveData = MutableLiveData<String?>()
 val emailKeyLiveData: LiveData<String?>
  get() = _emailKeyLiveData




 // paso 3 llamar funciones del MODELO

     fun setEmailToPreferences( emailKey : String , email : String, keykey : String , key : String){
          myModel.setEmailPreferences(emailKey,email,keykey, key)

                 _emailLiveData.value = email
         _emailKeyLiveData.value = key
     }



    fun removeEmailAndKeyFromPreferences (emailKey: String, keykey: String){

     myModel.removeEmailAndKeyFromPreferences(emailKey,keykey)

        // Actualiza los LiveData después de eliminar los datos de SharedPreferences
        _emailLiveData.value = null
        _emailKeyLiveData.value = null
    }










}
