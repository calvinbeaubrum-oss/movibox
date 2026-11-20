package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h2 extends ya {
    public static final Parcelable.Creator<h2> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f19333b;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h2 createFromParcel(Parcel parcel) {
            return new h2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h2[] newArray(int i11) {
            return new h2[i11];
        }
    }

    public h2(Parcel parcel) {
        super((String) xp.a((Object) parcel.readString()));
        this.f19333b = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    public h2(String str, byte[] bArr) {
        super(str);
        this.f19333b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h2.class != obj.getClass()) {
            return false;
        }
        h2 h2Var = (h2) obj;
        return this.f24575a.equals(h2Var.f24575a) && Arrays.equals(this.f19333b, h2Var.f19333b);
    }

    public int hashCode() {
        return ((this.f24575a.hashCode() + 527) * 31) + Arrays.hashCode(this.f19333b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f24575a);
        parcel.writeByteArray(this.f19333b);
    }
}
