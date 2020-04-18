package rs.raf.projekat1.marko_gajin_RM8517.view.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.marko_gajin_RM8517.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        val firstName = sharedPreferences.getString(LoginActivity.NAME_KEY, "") ?: ""
        val lastName = sharedPreferences.getString(LoginActivity.SURNAME_KEY, "") ?: ""

        val activeUser = "$firstName $lastName"

        userTv.text = activeUser

    }
}
