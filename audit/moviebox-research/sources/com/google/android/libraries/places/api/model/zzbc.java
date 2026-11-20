package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbc extends zzp {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbb();

    public zzbc(int i11, int i12) {
        super(i11, i12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(getHours());
        parcel.writeInt(getMinutes());
    }
}
