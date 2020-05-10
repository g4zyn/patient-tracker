package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_hospitalized.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient
import rs.raf.projekat1.marko_gajin_RM8517.models.State
import rs.raf.projekat1.marko_gajin_RM8517.view.activity.PatientCard
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.adapters.HospitalizedPatientAdapter
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.marko_gajin_RM8517.viewmodels.PatientViewModel

class HospitalizedFragment : Fragment(R.layout.fragment_hospitalized) {

    companion object {
        const val REQ_CODE = 23
        const val RES_CODE = 32
    }

    private val patientViewModel: PatientViewModel by activityViewModels()

    private lateinit var patientAdapter: HospitalizedPatientAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initRecycler()
        initObservers()
        initListeners()
    }

    private fun initRecycler() {
        hospitalizedRv.layoutManager = LinearLayoutManager(this.activity)
        patientAdapter = HospitalizedPatientAdapter(
            PatientDiffItemCallback(),
            {
                val intent = Intent(activity, PatientCard::class.java)
                intent.putExtra(PatientCard.PATIENT_KEY, it)
                startActivityForResult(intent, REQ_CODE)

            },
            { patientViewModel.addPatientToReleasedList(it) }
        )
        hospitalizedRv.adapter = patientAdapter
    }

    private fun initObservers() {
        patientViewModel.getPatients(State.HOSPITALIZED).observe(viewLifecycleOwner, Observer {
            patientAdapter.submitList(it)
        })
    }

    private fun initListeners() {}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK) {
            val newPatient = data?.getParcelableExtra(PatientCard.PATIENT_KEY) as Patient
            patientViewModel.updateData(newPatient)
        }
    }

}