package rs.raf.projekat1.marko_gajin_RM8517.view.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.marko_gajin_RM8517.view.recycler.viewholders.HospitalizedPatientVH

class HospitalizedPatientAdapter(
    patientDiffItemCallback: PatientDiffItemCallback,
    private val onCardBtnClicked: (Patient) -> Unit,
    private val onReleaseBtnClicked: (Patient) -> Unit
) : ListAdapter<Patient, HospitalizedPatientVH>(patientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalizedPatientVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val  containerView = layoutInflater.inflate(R.layout.layout_hospitalized_list_item, parent, false)

        return HospitalizedPatientVH(
            containerView,
            { onCardBtnClicked.invoke(getItem(it)) },
            { onReleaseBtnClicked.invoke(getItem(it)) }
        )
    }

    override fun onBindViewHolder(holder: HospitalizedPatientVH, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }
}