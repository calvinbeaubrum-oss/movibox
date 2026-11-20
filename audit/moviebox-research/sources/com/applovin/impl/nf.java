package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class nf implements bf.b {
    public static final Parcelable.Creator<nf> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f21328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f21330d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f21331f;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public nf createFromParcel(Parcel parcel) {
            return new nf(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public nf[] newArray(int i11) {
            return new nf[i11];
        }
    }

    public nf(long j11, long j12, long j13, long j14, long j15) {
        this.f21327a = j11;
        this.f21328b = j12;
        this.f21329c = j13;
        this.f21330d = j14;
        this.f21331f = j15;
    }

    private nf(Parcel parcel) {
        this.f21327a = parcel.readLong();
        this.f21328b = parcel.readLong();
        this.f21329c = parcel.readLong();
        this.f21330d = parcel.readLong();
        this.f21331f = parcel.readLong();
    }

    public /* synthetic */ nf(Parcel parcel, a aVar) {
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
        if (obj == null || nf.class != obj.getClass()) {
            return false;
        }
        nf nfVar = (nf) obj;
        return this.f21327a == nfVar.f21327a && this.f21328b == nfVar.f21328b && this.f21329c == nfVar.f21329c && this.f21330d == nfVar.f21330d && this.f21331f == nfVar.f21331f;
    }

    public int hashCode() {
        return ((((((((sc.a(this.f21327a) + 527) * 31) + sc.a(this.f21328b)) * 31) + sc.a(this.f21329c)) * 31) + sc.a(this.f21330d)) * 31) + sc.a(this.f21331f);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f21327a + ", photoSize=" + this.f21328b + ", photoPresentationTimestampUs=" + this.f21329c + ", videoStartPosition=" + this.f21330d + ", videoSize=" + this.f21331f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.f21327a);
        parcel.writeLong(this.f21328b);
        parcel.writeLong(this.f21329c);
        parcel.writeLong(this.f21330d);
        parcel.writeLong(this.f21331f);
    }
}
