package com.facebook.ads.redexgen.uinode;

import android.os.Parcel;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1274Dt {
    public final int A00;
    public final long A01;

    public C1274Dt(int i11, long j11) {
        this.A00 = i11;
        this.A01 = j11;
    }

    public /* synthetic */ C1274Dt(int i11, long j11, C1273Ds c1273Ds) {
        this(i11, j11);
    }

    public static C1274Dt A00(Parcel parcel) {
        return new C1274Dt(parcel.readInt(), parcel.readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A01);
    }
}
