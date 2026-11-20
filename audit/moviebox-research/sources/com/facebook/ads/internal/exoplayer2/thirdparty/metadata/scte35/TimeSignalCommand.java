package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.uinode.C1376Hz;
import com.facebook.ads.redexgen.uinode.Dv;
import com.facebook.ads.redexgen.uinode.IB;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static String[] A02 = {"sG", "SKgiCa5d9ZEELz", "pKJUtOIsmSdeWRhSmfkg", "RYqFvMPt4ygOGY", "4ulFqSy6k9HwIYoxn5tcLFNrNsE", "F6U", "Ool37D46w9DvUWXVHkToeSd93UD8I33w", "iJFoxGzstNUDxHZj"};
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Dv();
    public final long A00;
    public final long A01;

    public TimeSignalCommand(long j11, long j12) {
        this.A01 = j11;
        this.A00 = j12;
    }

    public /* synthetic */ TimeSignalCommand(long j11, long j12, Dv dv2) {
        this(j11, j12);
    }

    public static long A00(C1376Hz c1376Hz, long j11) {
        long jA0E = c1376Hz.A0E();
        if ((128 & jA0E) == 0) {
            return C.TIME_UNSET;
        }
        long j12 = (1 & jA0E) << 32;
        long jA0M = c1376Hz.A0M();
        String[] strArr = A02;
        if (strArr[7].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[1] = "aue9bKRLYwGt4M";
        strArr2[3] = "U8dfBAcmUh1N3t";
        return ((j12 | jA0M) + j11) & 8589934591L;
    }

    public static TimeSignalCommand A01(C1376Hz c1376Hz, long j11, IB ib2) {
        long jA00 = A00(c1376Hz, j11);
        return new TimeSignalCommand(jA00, ib2.A07(jA00));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
    }
}
