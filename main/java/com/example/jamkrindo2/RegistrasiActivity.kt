package com.example.jamkrindo2

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.alert_dialog_berhasil.view.*
import kotlinx.android.synthetic.main.alert_kode_verifikasi_salah.view.*
import kotlinx.android.synthetic.main.exit_alert_dalog.view.*
import kotlinx.android.synthetic.main.registrasi_view.*

class RegistrasiActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrasi_view)

        val ET_username    = findViewById<EditText>(R.id.regUsername)
        val ET_password    = findViewById<EditText>(R.id.regPassword)
        val ET_nama    = findViewById<EditText>(R.id.nama)
        val ET_alamat    = findViewById<EditText>(R.id.alamatUser)
        val ET_noHP    = findViewById<EditText>(R.id.noHP)
        val ET_namaPerusahaan    = findViewById<EditText>(R.id.namaPerusahaan)
        val ET_alamatPerusahaan    = findViewById<EditText>(R.id.alamatPerusahaan)
        val ET_namaPIC    = findViewById<EditText>(R.id.namaPICTerjamin)
        val ET_noHPPIC    = findViewById<EditText>(R.id.noHPPICTerjamin)
        val ET_emailPIC    = findViewById<EditText>(R.id.emailPICTerjamin)
        val ET_konfirmasiPass    = findViewById<EditText>(R.id.konfirmasiPassword)

        var data_username = ET_username.getText().toString()
        var data_password = ET_password.getText().toString()
        var data_nama = ET_nama.getText().toString()
        var data_alamat = ET_alamat.getText().toString()
        var data_noHP = ET_noHP.getText()
        var data_namaPerusahaan = ET_namaPerusahaan.getText().toString()
        var data_alamatPerusahaan = ET_alamatPerusahaan.getText().toString()
        var data_namaPIC = ET_namaPIC.getText().toString()
        var data_noHPPIC = ET_noHPPIC.getText()
        var data_emailPIC = ET_emailPIC.getText()
        var data_konfirmasiPass = ET_konfirmasiPass.getText().toString()


        val BT_daftar = findViewById<Button>(R.id.daftarButton)

        BT_daftar.setOnClickListener {
            setContentView(R.layout.input_kode_validasi)
            val BT_enter_Code = findViewById<Button>(R.id.enterCode)
            BT_enter_Code.setOnClickListener {
                val kode_val = findViewById<EditText>(R.id.kode_validasi)
                var datakode_val = kode_val.getText().toString()
                println(datakode_val)
                val kode_ver = "123"
                if (datakode_val.equals(kode_ver)){
                    val alertView = LayoutInflater.from(this).inflate(R.layout.alert_dialog_berhasil,null)
                    val mBuilder = AlertDialog.Builder(this)
                        .setView(alertView)
                    //show dialog
                    val  alertDialog = mBuilder.show()
                    alertView.button_ok.setOnClickListener {
                        val intent  =   Intent (this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                        alertDialog.dismiss()
                    }

                }else{
                    val alertView = LayoutInflater.from(this).inflate(R.layout.alert_kode_verifikasi_salah,null)
                    val mBuilder = AlertDialog.Builder(this)
                        .setView(alertView)

                    //show dialog
                    val  alertDialog = mBuilder.show()
                    alertView.button_okSalah.setOnClickListener {
                        alertDialog.dismiss()
                    }
                }
            }

        }
    }

    override fun onBackPressed() {

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
        Toast.makeText(this, "Exit Registrasi", Toast.LENGTH_SHORT).show()

    }
}