package com.example.contactapp

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.contactapp.databinding.UserBinding

class UserActivity : ComponentActivity() {
    private lateinit var binding: UserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = intent.getStringExtra("name")
        val id = intent.getStringExtra("id")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")

        binding.userchar.text = name?.get(0).toString()
        binding.username.text = name
        binding.userid.text = id
        binding.userphone.text = phone
        binding.useremail.text = email
    }
}