package com.facebook.ads.redexgen.uinode;

import android.os.Parcel;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Du {
    public static String[] A0B = {"WSNeg6N0n7AIShfXSzX5HQmTc8kFkZEc", "6rZRvoV62oNyzf", "F27AMpNiqyccCa5EB6sKY7eKfEMSqhrd", "FVKbL9f5FAHwz7hiZMN0u1v1YdCbdeYK", "vVfLkZocD1NxPHhP9fXAXrt0GsgaX4xN", "cFmUa63iy9OAJJOa0jT7jB1cdvdJ4hQa", "2QFrNOOxadMtahUuhILPt16xKsmCtJsL", "J"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final List<C1274Dt> A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;

    public Du(long j11, boolean z11, boolean z12, boolean z13, List<C1274Dt> list, long j12, boolean z14, long j13, int i11, int i12, int i13) {
        this.A04 = j11;
        this.A0A = z11;
        this.A08 = z12;
        this.A09 = z13;
        this.A06 = Collections.unmodifiableList(list);
        this.A05 = j12;
        this.A07 = z14;
        this.A03 = j13;
        this.A02 = i11;
        this.A00 = i12;
        this.A01 = i13;
    }

    public Du(Parcel parcel) {
        this.A04 = parcel.readLong();
        this.A0A = parcel.readByte() == 1;
        this.A08 = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        int i11 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(C1274Dt.A00(parcel));
        }
        this.A06 = Collections.unmodifiableList(arrayList);
        this.A05 = parcel.readLong();
        this.A07 = parcel.readByte() == 1;
        this.A03 = parcel.readLong();
        this.A02 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A01 = parcel.readInt();
    }

    public static Du A00(Parcel parcel) {
        return new Du(parcel);
    }

    public static Du A02(C1376Hz c1376Hz) {
        long jA0M = c1376Hz.A0M();
        boolean z11 = (c1376Hz.A0E() & 128) != 0;
        boolean z12 = false;
        boolean z13 = false;
        long jA0M2 = C.TIME_UNSET;
        ArrayList arrayList = new ArrayList();
        int iA0I = 0;
        int iA0E = 0;
        int iA0E2 = 0;
        boolean z14 = false;
        long jA0M3 = C.TIME_UNSET;
        if (!z11) {
            int iA0E3 = c1376Hz.A0E();
            z12 = (iA0E3 & 128) != 0;
            z13 = (iA0E3 & 64) != 0;
            if (A0B[7].length() != 1) {
                throw new RuntimeException();
            }
            A0B[1] = "02B3CRg7kTq01s";
            boolean z15 = (iA0E3 & 32) != 0;
            if (z13) {
                jA0M2 = c1376Hz.A0M();
            }
            if (!z13) {
                int iA0E4 = c1376Hz.A0E();
                arrayList = new ArrayList(iA0E4);
                for (int i11 = 0; i11 < iA0E4; i11++) {
                    arrayList.add(new C1274Dt(c1376Hz.A0E(), c1376Hz.A0M(), null));
                }
                String[] strArr = A0B;
                if (strArr[0].charAt(5) == strArr[5].charAt(5)) {
                    A0B[1] = "Wfp3iGqyia9VmI";
                }
            }
            if (z15) {
                long jA0E = c1376Hz.A0E();
                z14 = (128 & jA0E) != 0;
                jA0M3 = (1000 * (((1 & jA0E) << 32) | c1376Hz.A0M())) / 90;
            }
            iA0I = c1376Hz.A0I();
            iA0E = c1376Hz.A0E();
            iA0E2 = c1376Hz.A0E();
        }
        return new Du(jA0M, z11, z12, z13, arrayList, jA0M2, z14, jA0M3, iA0I, iA0E, iA0E2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(Parcel parcel) {
        parcel.writeLong(this.A04);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        int size = this.A06.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.A06.get(i11).A02(parcel);
        }
        parcel.writeLong(this.A05);
        byte b11 = this.A07 ? (byte) 1 : (byte) 0;
        if (A0B[1].length() != 14) {
            throw new RuntimeException();
        }
        A0B[1] = "FoD8YYsiaA11j5";
        parcel.writeByte(b11);
        parcel.writeLong(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }
}
