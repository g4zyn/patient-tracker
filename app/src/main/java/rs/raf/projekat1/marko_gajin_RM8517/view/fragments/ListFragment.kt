package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.adapters.PatientAdapter
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.marko_gajin_RM8517.viewmodels.PatientViewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private val patientViewModel: PatientViewModel by viewModels()

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
        initListeners()
        initRecycler()
    }

    private fun initListeners() {}

    private fun initRecycler() {
        listRv.layoutManager = LinearLayoutManager(this.activity)
        patientAdapter = PatientAdapter(PatientDiffItemCallback())
        listRv.adapter = patientAdapter
    }

    private fun initObservers() {
        patientViewModel.getPatients().observe(viewLifecycleOwner, Observer {
            patientAdapter.submitList(it)
        })
    }

}







