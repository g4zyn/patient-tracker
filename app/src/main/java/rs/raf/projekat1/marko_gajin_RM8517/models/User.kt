package rs.raf.projekat1.marko_gajin_RM8517.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User (val firstName: String, val lastName: String, val hospital: String) : Parcelable {}