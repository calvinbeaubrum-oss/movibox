package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: renamed from: com.applovin.impl.do, reason: invalid class name */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Cdo extends sk {
    public static final Parcelable.Creator<Cdo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18482b;

    /* JADX INFO: renamed from: com.applovin.impl.do$a */
    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cdo createFromParcel(Parcel parcel) {
            return new Cdo(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cdo[] newArray(int i11) {
            return new Cdo[i11];
        }
    }

    private Cdo(long j11, long j12) {
        this.f18481a = j11;
        this.f18482b = j12;
    }

    public /* synthetic */ Cdo(long j11, long j12, a aVar) {
        this(j11, j12);
    }

    public static long a(bh bhVar, long j11) {
        long jW = bhVar.w();
        return (128 & jW) != 0 ? 8589934591L & ((((jW & 1) << 32) | bhVar.y()) + j11) : C.TIME_UNSET;
    }

    public static Cdo a(bh bhVar, long j11, ho hoVar) {
        long jA = a(bhVar, j11);
        return new Cdo(jA, hoVar.b(jA));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.f18481a);
        parcel.writeLong(this.f18482b);
    }
}
