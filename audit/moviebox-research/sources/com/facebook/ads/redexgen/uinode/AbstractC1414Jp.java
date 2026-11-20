package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1414Jp {
    public static byte[] A00;
    public static final DateFormat A01;
    public static final AtomicBoolean A02;

    static {
        A03();
        A01 = new SimpleDateFormat(A01(34, 12, 118), Locale.US);
        A02 = new AtomicBoolean();
    }

    public static String A00() {
        return A01.format(Calendar.getInstance().getTime());
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02.set(true);
    }

    public static void A03() {
        A00 = new byte[]{-128, -50, -121, 123, -128, -50, -78, 0, -71, -83, -24, -78, 0, -22, -83, -78, 0, -35, -32, -22, -13, -5, -32, -31, -34, -15, -29, -5, -24, -21, -29, -29, -31, -18, -2, -2, -16, 35, 35, -16, 41, 41, -28, 9, 9, 9};
    }

    public static void A04(String str, String str2) {
        if (A02.get()) {
            Log.i(A01(17, 17, 92), String.format(Locale.US, A01(0, 6, 27), A00(), str2));
        }
    }

    public static void A05(String str, String str2, String str3) {
        if (A02.get()) {
            Log.i(A01(17, 17, 92), String.format(Locale.US, A01(6, 11, 77), A00(), str3, str2));
        }
    }
}
