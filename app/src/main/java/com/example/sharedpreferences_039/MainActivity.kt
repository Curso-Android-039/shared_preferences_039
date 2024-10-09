package com.example.sharedpreferences_039

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.sharedpreferences_039.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // referencias a bindin  2. referenciar a clase ViewModel

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

               binding = ActivityMainBinding.inflate(layoutInflater)
              setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("sharedPreferences_039", Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val key1 = "key1"
        val email ="M_canedo@gmail.com"

        val key2= "key2"
        val password ="M_canedo@gmail.com"

        // guardando las preferencias
        viewModel.setEmailToPreferences(key1,email, key2, password)

        viewModel.emailLiveData.observe(this){

            email ->

            binding.textView.text = email
        }

    }
}