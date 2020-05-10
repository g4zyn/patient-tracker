package rs.raf.projekat1.marko_gajin_RM8517.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profile.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.User
import rs.raf.projekat1.marko_gajin_RM8517.view.fragments.ProfileFragment

class EditProfileActivity : AppCompatActivity(R.layout.activity_edit_profile) {

    companion object {
        const val USER_KEY = "userKey"
    }

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        parseIntent()
        initListeners()
    }

    private fun parseIntent() {
        intent.let {
            user = it.getParcelableExtra(USER_KEY) as User
            nameEt.setText(user.firstName)
            surnameEt.setText(user.lastName)
            hospitalEt.setText(user.hospital)
        }
    }

    private fun initListeners() {
        saveBtn.setOnClickListener {
            save()
        }
        cancelBtn.setOnClickListener {
            cancel()
        }
    }

    private fun save() {
        val returnIntent = Intent()
        user.firstName = nameEt.text.toString()
        user.lastName = surnameEt.text.toString()
        user.hospital = hospitalEt.text.toString()

        returnIntent.putExtra(USER_KEY, user)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

    private fun cancel() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}
