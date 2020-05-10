package rs.raf.projekat1.marko_gajin_RM8517.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.User

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    companion object {
        const val ACTIVE_KEY = "activeKey"
        const val NAME_KEY = "nameKey"
        const val SURNAME_KEY = "surnameKey"
        const val HOSPITAL_KEY = "hospitalKey"

        const val PIN_CODE = "1234"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        submitBtn.setOnClickListener {
            val firstName = firstNameEt.text.toString()
            val lastName = lastNameEt.text.toString()
            val hospital = hospitalEt.text.toString()
            val pinCode = passwordEt.text.toString()

            if (isInputValid(firstName, lastName, hospital) && isValidPin(pinCode)) {
                login(User(firstName, lastName, hospital))
            }
        }
    }

    private fun isInputValid(firstName: String, lastName: String, hospital: String): Boolean {
        when {
            firstName == "" -> {
                Toast.makeText(applicationContext, "Name field can't be empty!", Toast.LENGTH_SHORT).show()
            }
            lastName == "" -> {
                Toast.makeText(applicationContext, "Surname field can't be empty!", Toast.LENGTH_SHORT).show()
            }
            hospital == "" -> {
                Toast.makeText(applicationContext, "Hospital field can't be empty!", Toast.LENGTH_SHORT).show()
            }
            else -> {
                return true
            }
        }

        return false
    }

    private fun isValidPin(pinCode: String): Boolean {
        when {
            pinCode == "" -> {
                Toast.makeText(applicationContext, "Enter pin code!", Toast.LENGTH_SHORT).show()
            }
            pinCode.length != 4 -> {
                Toast.makeText(applicationContext, "Invalid pin code length!", Toast.LENGTH_SHORT).show()
            }
            pinCode != PIN_CODE -> {
                Toast.makeText(applicationContext, "Invalid pin!", Toast.LENGTH_SHORT).show()
            }
            else -> {
                return true
            }
        }

        return false
    }

    private fun login(user:User) {
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(NAME_KEY, user.firstName)
        editor.putString(SURNAME_KEY, user.lastName)
        editor.putString(HOSPITAL_KEY, user.hospital)
        editor.putBoolean(ACTIVE_KEY, true)
        editor.apply()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
