package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.User
import rs.raf.projekat1.marko_gajin_RM8517.view.activity.EditProfileActivity
import rs.raf.projekat1.marko_gajin_RM8517.view.activity.LoginActivity

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var user : User? = null

    companion object {
        const val USER_EDIT_CODE = 111
        const val USER_CHANGED = "userChangedKey"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()

        this.user = getUser()
        nameTv.text = user?.firstName
        surnameTv.text = user?.lastName
        hospitalTv.text = user?.hospital
    }

    private fun initListeners() {
        logoutBtn.setOnClickListener {
            logout()
        }
        editBtn.setOnClickListener {
            editProfile()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            USER_EDIT_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    user = data?.getParcelableExtra(USER_CHANGED) ?: user
                    setUser()
                }
            }
        }
    }

    private fun setUser() {
        val sharedPreferences = this.activity?.getSharedPreferences(activity?.packageName, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString(LoginActivity.NAME_KEY, user?.firstName)
        editor?.putString(LoginActivity.SURNAME_KEY, user?.lastName)
        editor?.putString(LoginActivity.HOSPITAL_KEY, user?.hospital)
        editor?.apply()

        nameTv.text = user?.firstName
        surnameTv.text = user?.lastName
        hospitalTv.text = user?.hospital
    }

    private fun editProfile() {
        val intent = Intent(this.activity, EditProfileActivity::class.java)
        intent.putExtra(EditProfileActivity.USER_KEY, this.user)
        startActivityForResult(intent, USER_EDIT_CODE)
    }

    private fun logout() {
        val sharedPreferences = this.activity?.getSharedPreferences(activity?.packageName, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()

        editor?.clear()
        editor?.putBoolean(LoginActivity.ACTIVE_KEY, false)
        editor?.apply()

        val intent = Intent(this.activity, LoginActivity::class.java)
        startActivity(intent)
        this.activity?.finish()
    }

    private fun getUser(): User {
        val sharedPreferences = this.activity?.getSharedPreferences(activity?.packageName, Context.MODE_PRIVATE)

        val name = sharedPreferences?.getString(LoginActivity.NAME_KEY, "") ?: ""
        val surname = sharedPreferences?.getString(LoginActivity.SURNAME_KEY, "") ?: ""
        val hospital = sharedPreferences?.getString(LoginActivity.HOSPITAL_KEY, "") ?: ""

        return User(name, surname, hospital)
    }
}