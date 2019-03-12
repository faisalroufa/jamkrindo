package com.example.jamkrindo2

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.jamkrindo2.ui.alert.error_login_fragment
import com.example.jamkrindo2.util.SharedModel
import com.squareup.picasso.Picasso

class LoginActivity :AppCompatActivity() {
    private var sharedViewModel: SharedModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_view_material)
        val image = findViewById<ImageView>(R.id.logoJamkrindo)
        let {
            sharedViewModel = ViewModelProviders.of(this).get(SharedModel::class.java)
        }
        Picasso.get()
            .load("http://jamkrindosyariah.co.id/addons/shared_addons/themes/Jamkrindo/img/img-1.png")
            .into(image);
        val input_username     = findViewById<EditText>(R.id.username)
        val input_password     = findViewById<EditText>(R.id.password)

//        //mendefinisikan button daftar akun dan login
        val button_register = findViewById(R.id.daftarButton) as Button
        val button_login = findViewById(R.id.loginButton) as Button
////

        //membuat fungsi listener ketika button daftar di click
        button_register.setOnClickListener {
            //            setContentView(R.layout.registrasi_view)
            val intent = Intent(this, RegistrasiActivity::class.java)
            startActivity(intent)
            finish()
        }
        //membuat fungsi listener ketika button login di click
        button_login.setOnClickListener {

            var username = input_username.text.toString()
            var password = input_password.text.toString()
            val data_username = "fafa"
            val data_password = "123"
            if (username.isNotEmpty()and password.isNotEmpty()){
                if(username.equals(data_username) and data_password.equals(password)){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    val error_msg = "Username Atau Password Anda Salah"
                    sharedViewModel?.input_error_msg?.postValue(error_msg)
                    newFragment()
                }
            }else{
                val error_msg = "Username Atau Password Anda Kosong"
                sharedViewModel?.input_error_msg?.postValue(error_msg)
                newFragment()
            }
        }
    }
    fun  newFragment(){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.login_frame_container, error_login_fragment())
        fragment.commit()
    }
    override fun onBackPressed() {
        Toast.makeText(this, "Exit Application", Toast.LENGTH_SHORT).show()
        super.onBackPressed()
        finish()
    }
}



// To pass any data to next activity
//        intent.putExtra("keyIdentifier", value)
// start your next activity



//Jaminan		Jaminan		Jaminan		Jaminan		Jaminan
//Penawaran		Uang Muka		Pelaksanaan		Pembayaran		Pemeliharaan