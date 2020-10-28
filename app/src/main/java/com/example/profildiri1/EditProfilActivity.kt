package com.example.profildiri1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_edit_profil.*
import kotlinx.android.synthetic.main.activity_main.*

class EditProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)
        //menerima data yang dikirimkan dari ProfilActivity.kt
        val intentData = intent.extras
        val namaUser = intentData?.getString("nama")
        val genderUser = intentData?.getString("gender")
        val emailUser = intentData?.getString("email")
        val telpUser = intentData?.getString("telp")
        val alamatUser = intentData?.getString("alamat")
        //set edittext dengan data yang dikirimkan tadi
        edtProfilName.setText(namaUser)
        edtProfilGender.setSelection(genderUser, Int)
        edtProfilEmail.setText(emailUser)
        edtProfilTelp.setText(telpUser)
        edtProfilAlamat.setText(alamatUser)
        //memberikan action click ke tombol Simpan
        btnEditSave.setOnClickListener { saveData() }

        setSpinnerGender()
    }
    private fun setSpinnerGender(){
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.jenis_kelamin, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        edtProfilGender.adapter = adapter
    }

    //mengirimkan kembali ke ProfilActivity.kt
    private fun saveData(){
        val namaEdit = edtProfilName.text.toString()
        val genderEdit = edtProfilGender.selectedItem.toString()
        val emailEdit = edtProfilEmail.text.toString()
        val telpEdit = edtProfilTelp.text.toString()
        val alamatEdit = edtProfilAlamat.text.toString()
        if (!namaEdit.isEmpty() || !genderEdit.isEmpty() || !emailEdit.isEmpty() || !telpEdit.isEmpty() || !alamatEdit.isEmpty()) {
//jika editText namaEdit tidak kosong, maka kirimkan value nya ke ProfilActivity, dan beri tanda RESULT_OK
            val result = Intent()
            result.putExtra("nama", namaEdit)
            result.putExtra("gender", genderEdit)
            result.putExtra("email", emailEdit)
            result.putExtra("telp", telpEdit)
            result.putExtra("alamat", alamatEdit)
            setResult(Activity.RESULT_OK, result)
        } else {
//jika editText namaEdit kosong, maka kirimkan tanda RESULT_CANCELED
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}

private fun Spinner.setSelection(genderUser: String?, int: Int.Companion) {

}
