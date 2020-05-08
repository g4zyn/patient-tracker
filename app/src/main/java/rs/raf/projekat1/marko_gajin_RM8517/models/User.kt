package rs.raf.projekat1.marko_gajin_RM8517.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (var firstName: String, var lastName: String, var hospital: String) : Parcelable