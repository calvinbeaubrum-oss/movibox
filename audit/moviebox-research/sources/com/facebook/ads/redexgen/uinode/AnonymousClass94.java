package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.94, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass94 {
    public static byte[] A01;
    public final File A00;

    static {
        A02();
    }

    public AnonymousClass94(File file) {
        this.A00 = file;
    }

    public static AnonymousClass94 A00(String str, Context context) throws IOException {
        File file = new File(context.getFilesDir(), A01(64, 9, 55));
        A03(file);
        File file2 = new File(file, str);
        A03(file2);
        return new AnonymousClass94(file2);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-90, -60, -47, -47, -46, -41, -125, -56, -47, -42, -40, -43, -56, -125, -118, -120, -42, -118, -125, -52, -42, -125, -60, -125, -57, -52, -43, -56, -58, -41, -46, -43, -36, -118, -91, -83, -80, -87, -88, 100, -72, -77, 100, -89, -74, -87, -91, -72, -87, 100, -88, -83, -74, -87, -89, -72, -77, -74, -67, 100, 107, 105, -73, 107, -58, -62, -45, -60, -53, -65, -52, -49, -57};
    }

    public static void A03(File file) throws IOException {
        if (!file.exists() && !file.mkdir()) {
            final String str = String.format(Locale.US, A01(33, 31, 27), file.getCanonicalPath());
            throw new RuntimeException(str) { // from class: com.facebook.ads.redexgen.X.95
            };
        }
        if (file.isDirectory()) {
            return;
        }
        final String str2 = String.format(Locale.US, A01(0, 33, 58), file.getCanonicalPath());
        throw new RuntimeException(str2) { // from class: com.facebook.ads.redexgen.X.95
        };
    }

    public final AnonymousClass94 A04(String str) throws IOException {
        File file = new File(this.A00, str);
        A03(file);
        return new AnonymousClass94(file);
    }

    public final File A05() {
        return this.A00;
    }
}
