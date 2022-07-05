package com.hrishikesh.newsapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.loginButton
import kotlinx.android.synthetic.main.fragment_login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ft=supportFragmentManager.beginTransaction()
        ft.replace(R.id.frameLayout,LoginFragment())
        ft.commit()
        loginButton.setOnClickListener{
            loginButton.background= ContextCompat.getDrawable(this, R.drawable.custombg)
            loginButton.setTextColor(Color.parseColor("#ffffff"))
            signUpButton.setTextColor(Color.parseColor("#000000"))
            signUpButton.background=null
            val ft1=supportFragmentManager.beginTransaction()
            ft1.replace(R.id.frameLayout,LoginFragment())
            ft1.commit()
        }
        signUpButton.setOnClickListener{
            signUpButton.background= ContextCompat.getDrawable(this, R.drawable.custombg)
            signUpButton.setTextColor(Color.parseColor("#ffffff"))
            loginButton.setTextColor(Color.parseColor("#000000"))
            loginButton.background=null
            val ft2=supportFragmentManager.beginTransaction()
            ft2.replace(R.id.frameLayout,RegisterFragment())
            ft2.commit()
        }
    }
}