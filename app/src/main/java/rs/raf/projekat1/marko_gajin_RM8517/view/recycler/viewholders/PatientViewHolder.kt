package rs.raf.projekat1.marko_gajin_RM8517.view.recycler.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_waiting_list_item.*
import kotlinx.android.synthetic.main.layout_waiting_list_item.view.*
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient

class PatientViewHolder(
    override val containerView: View,
    private val onHealthyBtnClicked: (Int) -> Unit,
    private val onHospitalizeBtnClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        initListeners()
    }

    private fun initListeners() {
        containerView.healthyBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onHealthyBtnClicked.invoke(adapterPosition)
            }
        }

        containerView.hospitalizeBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onHospitalizeBtnClicked.invoke(adapterPosition)
            }
        }
    }

    fun bind(patient: Patient) {
        nameTv.text = patient.firstName
        surnameTv.text = patient.lastName
        symptomsTv.text = patient.symptoms
    }

}