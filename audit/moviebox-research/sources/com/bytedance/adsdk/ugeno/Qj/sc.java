package com.bytedance.adsdk.ugeno.Qj;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc implements Parcelable {
    private final Parcelable pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final sc f26350sc = new sc() { // from class: com.bytedance.adsdk.ugeno.Qj.sc.1
    };
    public static final Parcelable.Creator<sc> CREATOR = new Parcelable.ClassLoaderCreator<sc>() { // from class: com.bytedance.adsdk.ugeno.Qj.sc.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public sc createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public sc createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return sc.f26350sc;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public sc[] newArray(int i11) {
            return new sc[i11];
        }
    };

    private sc() {
        this.pFF = null;
    }

    public sc(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.pFF = parcelable == null ? f26350sc : parcelable;
    }

    public sc(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.pFF = parcelable == f26350sc ? null : parcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable sc() {
        return this.pFF;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.pFF, i11);
    }
}
