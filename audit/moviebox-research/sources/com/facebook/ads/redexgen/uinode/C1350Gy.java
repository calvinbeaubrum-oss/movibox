package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1350Gy {
    public static byte[] A07;
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final Uri A04;
    public final String A05;
    public final byte[] A06;

    static {
        A01();
    }

    public C1350Gy(Uri uri, long j11, long j12, long j13, String str, int i11) {
        this(uri, null, j11, j12, j13, str, i11);
    }

    public C1350Gy(Uri uri, long j11, long j12, String str) {
        this(uri, j11, j11, j12, str, 0);
    }

    public C1350Gy(Uri uri, long j11, long j12, String str, int i11) {
        this(uri, j11, j11, j12, str, i11);
    }

    public C1350Gy(Uri uri, byte[] bArr, long j11, long j12, long j13, String str, int i11) {
        boolean z11 = true;
        AbstractC1351Ha.A03(j11 >= 0);
        AbstractC1351Ha.A03(j12 >= 0);
        if (j13 <= 0 && j13 != -1) {
            z11 = false;
        }
        AbstractC1351Ha.A03(z11);
        this.A04 = uri;
        this.A06 = bArr;
        this.A01 = j11;
        this.A03 = j12;
        this.A02 = j13;
        this.A05 = str;
        this.A00 = i11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-125, 119, 105, -122, -103, -122, 120, -107, -118, -120, -128, -50};
    }

    public final boolean A02(int i11) {
        return (this.A00 & i11) == i11;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder().append(A00(2, 9, 16)).append(this.A04);
        String strA00 = A00(0, 2, 66);
        return sbAppend.append(strA00).append(Arrays.toString(this.A06)).append(strA00).append(this.A01).append(strA00).append(this.A03).append(strA00).append(this.A02).append(strA00).append(this.A05).append(strA00).append(this.A00).append(A00(11, 1, 92)).toString();
    }
}
