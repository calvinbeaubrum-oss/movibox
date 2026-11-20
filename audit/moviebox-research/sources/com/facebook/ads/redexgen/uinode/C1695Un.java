package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Un, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1695Un implements KZ {
    public static byte[] A00;
    public static String[] A01 = {"8dTs7O5twSBYJQLkIxmvSEVrFVEvVCci", "69NA9D5Z6BuLX3eP6NdAfQAgnNKJrDbv", "acKGpr4PBH5WFf0tOIi0bMoNuU2uM3j", "PyBLhH8YgyLL4rtY0CuV5vjOqs5FO6aV", "QGo0VGIKP6OUkgre", "Fn5N", "qAtdKl9ehcjQMJLKj9xOFxL36VJ6lS2D", "CGei2tUyEESFCVHjI0JHW7BbjnmVvUdx"};

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {119, 115, 114, -90, -107, -102, -106, -97, -108, -106, Ascii.DEL, -106, -91, -88, -96, -93, -100, -42, -17, -20, -17, -16, -8, -17, -95, -26, -7, -28, -26, -15, -11, -22, -16, -17, -81};
        if (A01[5].length() != 4) {
            throw new RuntimeException();
        }
        A01[1] = "MK2VCqgBd9SNnNeGly9LCo5Q0MZYLIwM";
        A00 = bArr;
    }

    @Override // com.facebook.ads.redexgen.uinode.KZ
    public final void A9S(int i11, Throwable th2) {
        Log.e(A00(0, 17, 10), A00(17, 18, 90), th2);
    }
}
