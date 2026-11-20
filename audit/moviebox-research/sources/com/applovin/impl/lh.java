package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class lh implements bf.b {
    public static final Parcelable.Creator<lh> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20462d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f20463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f20464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f20465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f20466i;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public lh createFromParcel(Parcel parcel) {
            return new lh(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public lh[] newArray(int i11) {
            return new lh[i11];
        }
    }

    public lh(int i11, String str, String str2, int i12, int i13, int i14, int i15, byte[] bArr) {
        this.f20459a = i11;
        this.f20460b = str;
        this.f20461c = str2;
        this.f20462d = i12;
        this.f20463f = i13;
        this.f20464g = i14;
        this.f20465h = i15;
        this.f20466i = bArr;
    }

    public lh(Parcel parcel) {
        this.f20459a = parcel.readInt();
        this.f20460b = (String) xp.a((Object) parcel.readString());
        this.f20461c = (String) xp.a((Object) parcel.readString());
        this.f20462d = parcel.readInt();
        this.f20463f = parcel.readInt();
        this.f20464g = parcel.readInt();
        this.f20465h = parcel.readInt();
        this.f20466i = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    @Override // com.applovin.impl.bf.b
    public void a(vd.b bVar) {
        bVar.a(this.f20466i, this.f20459a);
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ byte[] a() {
        return jt.b(this);
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ f9 b() {
        return jt.c(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || lh.class != obj.getClass()) {
            return false;
        }
        lh lhVar = (lh) obj;
        return this.f20459a == lhVar.f20459a && this.f20460b.equals(lhVar.f20460b) && this.f20461c.equals(lhVar.f20461c) && this.f20462d == lhVar.f20462d && this.f20463f == lhVar.f20463f && this.f20464g == lhVar.f20464g && this.f20465h == lhVar.f20465h && Arrays.equals(this.f20466i, lhVar.f20466i);
    }

    public int hashCode() {
        return ((((((((((((((this.f20459a + 527) * 31) + this.f20460b.hashCode()) * 31) + this.f20461c.hashCode()) * 31) + this.f20462d) * 31) + this.f20463f) * 31) + this.f20464g) * 31) + this.f20465h) * 31) + Arrays.hashCode(this.f20466i);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f20460b + ", description=" + this.f20461c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f20459a);
        parcel.writeString(this.f20460b);
        parcel.writeString(this.f20461c);
        parcel.writeInt(this.f20462d);
        parcel.writeInt(this.f20463f);
        parcel.writeInt(this.f20464g);
        parcel.writeInt(this.f20465h);
        parcel.writeByteArray(this.f20466i);
    }
}
