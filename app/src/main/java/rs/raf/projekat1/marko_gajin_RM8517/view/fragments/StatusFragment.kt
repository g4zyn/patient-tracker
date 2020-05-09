package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_status.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.viewmodels.PatientViewModel

class StatusFragment : Fragment(R.layout.fragment_status) {

    private val patientViewModel: PatientViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

//    TODO get filtered list of patients based on their status
    private fun init() {
        waitingRoom.text = patientViewModel.getPatients().value?.size.toString()
        hospitalized.text = patientViewModel.getPatients().value?.size.toString()
        released.text = patientViewModel.getPatients().value?.size.toString()
    }

}