package rs.raf.projekat1.marko_gajin_RM8517.view.recycler.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_released_list_item.*
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient

class ReleasedPatientVH (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(patient: Patient) {
        nameTv.text = patient.firstName
        surnameTv.text = patient.lastName
        releasedTv.text = patient.releasedDate.toString()
    }

}