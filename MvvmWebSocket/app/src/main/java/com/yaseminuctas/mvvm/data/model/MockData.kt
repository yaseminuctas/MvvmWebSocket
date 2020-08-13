package com.yaseminuctas.mvvm.data.model

import android.os.Parcelable
import com.yaseminuctas.mvvm.data.network.Datum
import kotlinx.android.parcel.Parcelize

@Parcelize
class MockData(var data: List<Datum>): Parcelable

