package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_waiting_room.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.State
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.adapters.PatientAdapter
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.marko_gajin_RM8517.viewmodels.PatientViewModel

class WaitingRoomFragment : Fragment(R.layout.fragment_waiting_room) {

    private val patientViewModel: PatientViewModel by activityViewModels()

    private lateinit var patientAdapter: PatientAdapter

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
        waitingListRv.layoutManager = LinearLayoutManager(activity)
        patientAdapter = PatientAdapter(
            PatientDiffItemCallback(),
            { patientViewModel.removeFromWaitingList(it) },
            { patientViewModel.addToHospitalizedList(it) }
        )
        waitingListRv.adapter = patientAdapter
    }

    private fun initObservers() {
        patientViewModel.getPatients(State.WAITING).observe(viewLifecycleOwner, Observer {
            patientAdapter.submitList(it)
        })
    }

    private fun initListeners() {}

}
