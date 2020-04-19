package rs.raf.projekat1.marko_gajin_RM8517.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import rs.raf.projekat1.marko_gajin_RM8517.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isActive()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        finish()
    }

//    Check if user is logged in
    private fun isActive(): Boolean {

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        return sharedPreferences.getBoolean(LoginActivity.ACTIVE_KEY, false)
    }
}
