package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class yh extends sk {
    public static final Parcelable.Creator<yh> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f24673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f24674c;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public yh createFromParcel(Parcel parcel) {
            return new yh(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public yh[] newArray(int i11) {
            return new yh[i11];
        }
    }

    private yh(long j11, byte[] bArr, long j12) {
        this.f24672a = j12;
        this.f24673b = j11;
        this.f24674c = bArr;
    }

    private yh(Parcel parcel) {
        this.f24672a = parcel.readLong();
        this.f24673b = parcel.readLong();
        this.f24674c = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    public /* synthetic */ yh(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static yh a(bh bhVar, int i11, long j11) {
        long jY = bhVar.y();
        int i12 = i11 - 4;
        byte[] bArr = new byte[i12];
        bhVar.a(bArr, 0, i12);
        return new yh(jY, bArr, j11);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.f24672a);
        parcel.writeLong(this.f24673b);
        parcel.writeByteArray(this.f24674c);
    }
}
