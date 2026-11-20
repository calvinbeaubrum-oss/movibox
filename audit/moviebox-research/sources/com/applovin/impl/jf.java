package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class jf extends ya {
    public static final Parcelable.Creator<jf> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19945d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f19946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f19947g;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public jf createFromParcel(Parcel parcel) {
            return new jf(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public jf[] newArray(int i11) {
            return new jf[i11];
        }
    }

    public jf(int i11, int i12, int i13, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f19943b = i11;
        this.f19944c = i12;
        this.f19945d = i13;
        this.f19946f = iArr;
        this.f19947g = iArr2;
    }

    public jf(Parcel parcel) {
        super("MLLT");
        this.f19943b = parcel.readInt();
        this.f19944c = parcel.readInt();
        this.f19945d = parcel.readInt();
        this.f19946f = (int[]) xp.a(parcel.createIntArray());
        this.f19947g = (int[]) xp.a(parcel.createIntArray());
    }

    @Override // com.applovin.impl.ya, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jf.class != obj.getClass()) {
            return false;
        }
        jf jfVar = (jf) obj;
        return this.f19943b == jfVar.f19943b && this.f19944c == jfVar.f19944c && this.f19945d == jfVar.f19945d && Arrays.equals(this.f19946f, jfVar.f19946f) && Arrays.equals(this.f19947g, jfVar.f19947g);
    }

    public int hashCode() {
        return ((((((((this.f19943b + 527) * 31) + this.f19944c) * 31) + this.f19945d) * 31) + Arrays.hashCode(this.f19946f)) * 31) + Arrays.hashCode(this.f19947g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f19943b);
        parcel.writeInt(this.f19944c);
        parcel.writeInt(this.f19945d);
        parcel.writeIntArray(this.f19946f);
        parcel.writeIntArray(this.f19947g);
    }
}
