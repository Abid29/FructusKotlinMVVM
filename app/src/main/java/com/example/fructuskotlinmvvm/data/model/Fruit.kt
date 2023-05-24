package com.example.fructuskotlinmvvm.data.model

import android.os.Parcel
import android.os.Parcelable

data class Fruit(
    val id:Int, val title: String?, val headline: String?, val image: String?, val description: String?,
    val gradientColors: ArrayList<String?>, val nutritions: ArrayList<String?>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList() ?: ArrayList(),
        parcel.createStringArrayList()?:ArrayList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(headline)
        parcel.writeString(image)
        parcel.writeString(description)

        parcel.writeStringList(gradientColors)
        parcel.writeStringList(nutritions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Fruit> {
        override fun createFromParcel(parcel: Parcel): Fruit {
            return Fruit(parcel)
        }

        override fun newArray(size: Int): Array<Fruit?> {
            return arrayOfNulls(size)
        }
    }
}