package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.uinode.C1270Dp;
import com.facebook.ads.redexgen.uinode.C1271Dq;
import com.facebook.ads.redexgen.uinode.C1376Hz;
import com.facebook.ads.redexgen.uinode.IB;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static String[] A0D = {"rwcuqOJ6EdQ67q2Mv0J2HHeiL", "WP4j4wUrwc9dHeO22M7i1JH5Vq97obJg", "mJZdPTUXLZu74", "VLU2rxkJGeQdQarAjhhUo7gMPCvQOQS9", "TorhhvAEpNk7fEbKtUMeNjy7yeYkErzW", "2cgHesvtXq3tKj0PCMbQTWS3l1m9KzOv", "jB5ZWs0uqsLPN", "ipEqGNR1nINtqeP5fHPEDulQW"};
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new C1270Dp();
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final List<C1271Dq> A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    public SpliceInsertCommand(long j11, boolean z11, boolean z12, boolean z13, boolean z14, long j12, long j13, List<C1271Dq> list, boolean z15, long j14, int i11, int i12, int i13) {
        this.A06 = j11;
        this.A0B = z11;
        this.A09 = z12;
        this.A0A = z13;
        this.A0C = z14;
        this.A05 = j12;
        this.A04 = j13;
        this.A07 = Collections.unmodifiableList(list);
        this.A08 = z15;
        this.A03 = j14;
        this.A02 = i11;
        this.A00 = i12;
        this.A01 = i13;
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.A06 = parcel.readLong();
        this.A0B = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        this.A0A = parcel.readByte() == 1;
        this.A0C = parcel.readByte() == 1;
        this.A05 = parcel.readLong();
        this.A04 = parcel.readLong();
        int i11 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(C1271Dq.A00(parcel));
        }
        this.A07 = Collections.unmodifiableList(arrayList);
        this.A08 = parcel.readByte() == 1;
        this.A03 = parcel.readLong();
        this.A02 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A01 = parcel.readInt();
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, C1270Dp c1270Dp) {
        this(parcel);
    }

    public static SpliceInsertCommand A00(C1376Hz c1376Hz, long j11, IB ib2) {
        long jA0M = c1376Hz.A0M();
        boolean z11 = (c1376Hz.A0E() & 128) != 0;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        long jA00 = C.TIME_UNSET;
        List listEmptyList = Collections.emptyList();
        int iA0I = 0;
        int iA0E = 0;
        int iA0E2 = 0;
        boolean z15 = false;
        long jA0M2 = C.TIME_UNSET;
        if (!z11) {
            int iA0E3 = c1376Hz.A0E();
            if (A0D[1].charAt(24) == '7') {
                throw new RuntimeException();
            }
            A0D[4] = "wCIdN9eSc7apWAr1IiSVHk4IDh7dTuFq";
            z12 = (iA0E3 & 128) != 0;
            z13 = (iA0E3 & 64) != 0;
            boolean z16 = (iA0E3 & 32) != 0;
            z14 = (iA0E3 & 16) != 0;
            if (z13 && !z14) {
                jA00 = TimeSignalCommand.A00(c1376Hz, j11);
            }
            if (!z13) {
                int iA0E4 = c1376Hz.A0E();
                listEmptyList = new ArrayList(iA0E4);
                for (int i11 = 0; i11 < iA0E4; i11++) {
                    int iA0E5 = c1376Hz.A0E();
                    long jA01 = C.TIME_UNSET;
                    if (!z14) {
                        jA01 = TimeSignalCommand.A00(c1376Hz, j11);
                    }
                    listEmptyList.add(new C1271Dq(iA0E5, jA01, ib2.A07(jA01), null));
                }
            }
            if (z16) {
                long jA0E = c1376Hz.A0E();
                z15 = (jA0E & 128) != 0;
                jA0M2 = (1000 * (((jA0E & 1) << 32) | c1376Hz.A0M())) / 90;
            }
            iA0I = c1376Hz.A0I();
            iA0E = c1376Hz.A0E();
            iA0E2 = c1376Hz.A0E();
        }
        return new SpliceInsertCommand(jA0M, z11, z12, z13, z14, jA00, ib2.A07(jA00), listEmptyList, z15, jA0M2, iA0I, iA0E, iA0E2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.A06);
        parcel.writeByte(this.A0B ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0C ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A05);
        parcel.writeLong(this.A04);
        int size = this.A07.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            List<C1271Dq> list = this.A07;
            if (A0D[3].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[6] = "cIZczz40pT0Gu";
            strArr[2] = "8BKfMUSS1QcQc";
            list.get(i12).A01(parcel);
        }
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }
}
