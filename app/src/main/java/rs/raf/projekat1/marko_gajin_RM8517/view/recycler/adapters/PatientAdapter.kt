package rs.raf.projekat1.marko_gajin_RM8517.view.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.viewholders.WaitingPatientVH

class PatientAdapter(
    patientDiffItemCallback: PatientDiffItemCallback,
    private val onHealthyBtnClicked: (Patient) -> Unit,
    private val onHospitalizeBtnClicked: (Patient) -> Unit
) : ListAdapter<Patient, WaitingPatientVH>(patientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaitingPatientVH {

        val layoutInflater = LayoutInflater.from(parent.context)
        val  containerView = layoutInflater.inflate(R.layout.layout_waiting_list_item, parent, false)

        return WaitingPatientVH(
            containerView,
            { onHealthyBtnClicked.invoke(getItem(it)) },
            { onHospitalizeBtnClicked.invoke(getItem(it)) }
        )
    }

    override fun onBindViewHolder(holder: WaitingPatientVH, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

}

