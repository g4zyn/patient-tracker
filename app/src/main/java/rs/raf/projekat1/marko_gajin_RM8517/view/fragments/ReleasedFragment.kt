package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_released.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.State
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.adapters.ReleasedPatientAdapter
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.marko_gajin_RM8517.viewmodels.PatientViewModel

class ReleasedFragment : Fragment(R.layout.fragment_released) {

    private val patientViewModel: PatientViewModel by activityViewModels()

    private lateinit var patientAdapter: ReleasedPatientAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initRecycler()
        initObservers()
    }

    private fun initRecycler() {
        releasedRv.layoutManager = GridLayoutManager(activity, 2)
        patientAdapter = ReleasedPatientAdapter(PatientDiffItemCallback())
        releasedRv.adapter = patientAdapter
    }

    private fun initObservers() {
        patientViewModel.getPatients(State.WAITING).observe(viewLifecycleOwner, Observer {
            patientAdapter.submitList(it)
        })
    }

}