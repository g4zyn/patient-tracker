package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_status.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.State
import rs.raf.projekat1.marko_gajin_RM8517.viewmodels.PatientViewModel
class StatusFragment : Fragment(R.layout.fragment_status) {

    private val patientViewModel: PatientViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        patientViewModel.getPatients(State.WAITING).observe(viewLifecycleOwner, Observer {
            waitingRoom.text = patientViewModel.getPatients(State.WAITING).value?.size.toString()
        })

        patientViewModel.getPatients(State.HOSPITALIZED).observe(viewLifecycleOwner, Observer {
            hospitalized.text = patientViewModel.getPatients(State.HOSPITALIZED).value?.size.toString()
        })

        patientViewModel.getPatients(State.RELEASED).observe(viewLifecycleOwner, Observer {
            released.text = patientViewModel.getPatients(State.RELEASED).value?.size.toString()
        })
    }
}

