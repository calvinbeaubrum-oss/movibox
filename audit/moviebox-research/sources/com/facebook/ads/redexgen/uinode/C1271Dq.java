package com.facebook.ads.redexgen.uinode;

import android.os.Parcel;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1271Dq {
    public final int A00;
    public final long A01;
    public final long A02;

    public C1271Dq(int i11, long j11, long j12) {
        this.A00 = i11;
        this.A02 = j11;
        this.A01 = j12;
    }

    public /* synthetic */ C1271Dq(int i11, long j11, long j12, C1270Dp c1270Dp) {
        this(i11, j11, j12);
    }

    public static C1271Dq A00(Parcel parcel) {
        return new C1271Dq(parcel.readInt(), parcel.readLong(), parcel.readLong());
    }

    public final void A01(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A02);
        parcel.writeLong(this.A01);
    }
}
