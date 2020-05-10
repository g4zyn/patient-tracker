package rs.raf.projekat1.marko_gajin_RM8517.view.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.viewholders.PatientViewHolder

class PatientAdapter(patientDiffItemCallback: PatientDiffItemCallback) : ListAdapter<Patient, PatientViewHolder>(patientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val  containerView = layoutInflater.inflate(R.layout.layout_waiting_list_item, parent, false)

        return PatientViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

}

