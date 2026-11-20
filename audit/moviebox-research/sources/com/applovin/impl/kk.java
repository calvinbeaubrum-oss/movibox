package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class kk implements bf.b {
    public static final Parcelable.Creator<kk> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f20258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20259b;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public kk createFromParcel(Parcel parcel) {
            return new kk(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public kk[] newArray(int i11) {
            return new kk[i11];
        }
    }

    public kk(float f11, int i11) {
        this.f20258a = f11;
        this.f20259b = i11;
    }

    private kk(Parcel parcel) {
        this.f20258a = parcel.readFloat();
        this.f20259b = parcel.readInt();
    }

    public /* synthetic */ kk(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ void a(vd.b bVar) {
        jt.a(this, bVar);
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
        if (obj == null || kk.class != obj.getClass()) {
            return false;
        }
        kk kkVar = (kk) obj;
        return this.f20258a == kkVar.f20258a && this.f20259b == kkVar.f20259b;
    }

    public int hashCode() {
        return ((d9.a(this.f20258a) + 527) * 31) + this.f20259b;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f20258a + ", svcTemporalLayerCount=" + this.f20259b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeFloat(this.f20258a);
        parcel.writeInt(this.f20259b);
    }
}
