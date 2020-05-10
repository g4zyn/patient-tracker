package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_waiting_room.*
import rs.raf.projekat1.marko_gajin_RM8517.R
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
        initUI()
        initObservers()
    }

    private fun initUI() {
        initRecycler()
    }

    private fun initRecycler() {
        waitingRoomRv.layoutManager = LinearLayoutManager(this.activity)
        patientAdapter = PatientAdapter(PatientDiffItemCallback())
        waitingRoomRv.adapter = patientAdapter
    }

    private fun initObservers() {
        patientViewModel.getPatients().observe(viewLifecycleOwner, Observer {
            patientAdapter.submitList(it)
        })
    }

}