package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_input.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.viewmodels.PatientViewModel
import timber.log.Timber

class InputFragment : Fragment(R.layout.fragment_input) {

    private val patientViewModel: PatientViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        addPatientBtn.setOnClickListener {
            Timber.e("Adding new patient to waiting list...")

            val firstName = firstNameEt.text.toString()
            val lastName =  lastNameEt.text.toString()
            val symptoms = symptomsEt.text.toString()

            patientViewModel.addPatient(firstName, lastName, symptoms)
        }
    }

}