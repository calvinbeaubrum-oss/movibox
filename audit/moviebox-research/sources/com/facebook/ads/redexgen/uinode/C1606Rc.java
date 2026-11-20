package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1606Rc {
    public static RI A00;
    public static byte[] A01;
    public static String[] A02 = {DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "jWWIi2TrnHAAyoG5itvaKpzBpE6rwsKb", "4piz2zd6PBPCOA5LKuru6huyc0Gk9hmI", "ThWxRwfxtMClt6xxWNEGrvPqHoOGiBgN", "VC0ltrZe3ujZ5yBmE9F34w5pTHRf8GMT", "g0Z7XyqsbnnTrD4DkPgr08gcmreNHhpx", "VVYGWntGozQ2sTcwE1XxLnyTeGzWkyyX", "XVqTwdXEkxL4UUDwn3dakWK60VTsxJd5"};
    public static final Set<String> A03;
    public static final Set<String> A04;
    public static final AtomicBoolean A05;

    static {
        A07();
        HashSet hashSet = new HashSet();
        A03 = hashSet;
        HashSet hashSet2 = new HashSet();
        A04 = hashSet2;
        hashSet.add(A05(6, 29, 2));
        hashSet2.add(A05(168, 29, 95));
        hashSet2.add(A05(35, 29, 116));
        hashSet2.add(A05(64, 29, 119));
        hashSet2.add(A05(116, 29, 17));
        A05 = new AtomicBoolean();
    }

    public static RK A00(C11237f c11237f) {
        return A03(true, c11237f);
    }

    public static RK A01(C11237f c11237f) {
        return A02(true, c11237f);
    }

    public static RK A02(boolean z11, C11237f c11237f) {
        RO ro2 = new RO();
        RR rrA04 = A04(c11237f);
        if (!A0B(c11237f)) {
            ro2.A02(A04);
            ro2.A01(A03);
        }
        if (L0.A04()) {
            Map<String, String> mapA02 = L0.A02();
            String[] strArr = A02;
            if (strArr[2].charAt(7) == strArr[1].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[5] = "6CjO7LbqJIONUadrRHmx0RuGBypxStir";
            strArr2[3] = "VKsjD9ddp6JrHwn0FL0Df9QGs7RhJ4JT";
            rrA04.A08(mapA02);
        }
        return RM.A00().A00(ro2.A00(rrA04.A09()).A03(z11).A04(c11237f.A04().A8z()).A05(), c11237f.A07(), ExecutorC1467Lt.A01());
    }

    public static RK A03(boolean z11, C11237f c11237f) {
        return RM.A00().A00(new RO().A03(z11).A00(A04(c11237f).A09()).A04(c11237f.A04().A8z()).A05(), c11237f.A07(), ExecutorC1467Lt.A01());
    }

    public static RR A04(C11237f c11237f) {
        A08(c11237f);
        RR rr2 = new RR();
        if (A0B(c11237f) || L0.A04()) {
            rr2.A02(360000).A04(120000);
        } else {
            rr2.A02(C1384Ih.A08(c11237f)).A04(C1384Ih.A0A(c11237f));
        }
        rr2.A03(C1384Ih.A09(c11237f)).A05(C1384Ih.A0B(c11237f)).A06(C1384Ih.A0C(c11237f));
        synchronized (C1606Rc.class) {
            RI ri2 = A00;
            if (ri2 != null && (ri2 instanceof RI)) {
                rr2.A07(ri2);
            }
        }
        return rr2;
    }

    public static String A05(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05.set(true);
    }

    public static void A07() {
        A01 = new byte[]{36, 101, 110, 8, 85, 68, Ascii.VT, 77, 77, 2, Ascii.DEL, 10, 123, 99, 73, 104, 8, 85, 98, Ascii.SI, 86, 84, 94, 81, 8, 82, 77, 74, 8, 111, 85, 73, 81, 7, 48, Ascii.DEL, 32, 7, 58, 38, 2, Utf8.REPLACEMENT_BYTE, 42, 33, 62, 34, 103, Ascii.ESC, 33, 42, 8, 36, 58, 62, 126, 37, Ascii.SUB, 36, 99, 53, Ascii.RS, Utf8.REPLACEMENT_BYTE, 113, 70, Ascii.CR, Ascii.DEL, 119, Ascii.RS, 59, 10, 123, 54, 3, Ascii.FF, 43, 35, 38, 123, 61, Utf8.REPLACEMENT_BYTE, 59, 54, 62, Ascii.SO, 10, 44, 53, Ascii.ETB, 0, 42, Ascii.SO, 114, 69, 107, 64, 81, 82, 74, 87, 78, 76, 75, 66, 5, 71, 64, 67, 74, 87, 64, 5, 76, 75, 76, 81, 4, 113, 115, 113, 96, Ascii.US, 72, 71, 115, 75, 77, 98, 79, 2, 93, 72, 124, 123, 77, 71, 80, 124, 97, Ascii.FS, 64, 89, 78, 100, Ascii.DC4, 35, 54, 62, 37, 39, 59, 54, 57, 50, 8, 58, 56, 51, 50, 8, 56, 57, 7, Ascii.FF, Ascii.GS, Ascii.RS, 6, Ascii.ESC, 2, 19, 8, 61, 85, 32, 53, 9, 53, Ascii.CR, 36, 94, 55, 82, 49, 49, 50, 3, 36, Ascii.ETB, 40, Ascii.NAK, 33, 47, 95, Ascii.VT, 1, 54, 90, 109};
    }

    public static void A08(C11237f c11237f) {
        if (A05.get()) {
            return;
        }
        c11237f.A07().A9a(A05(161, 7, 81), C8A.A21, new C8B(A05(93, 23, 29)));
    }

    public static synchronized void A09(RI ri2) {
        A00 = ri2;
    }

    public static boolean A0A(C11237f c11237f) {
        int i11 = Build.VERSION.SDK_INT;
        String strA05 = A05(145, 16, 111);
        if (i11 < 17) {
            return Settings.System.getInt(c11237f.getContentResolver(), strA05, 0) != 0;
        }
        int i12 = Settings.Global.getInt(c11237f.getContentResolver(), strA05, 0);
        if (A02[0].length() != 1) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[2] = "6SlcDzdssqL5L6jmaJN4q0YtRJ9ZiIN0";
        strArr[1] = "IhCDgNyX5tEXKuNPsF1SGphg5lyX1n5g";
        return i12 != 0;
    }

    public static boolean A0B(C11237f c11237f) {
        String strA8F = c11237f.A04().A8F();
        return !TextUtils.isEmpty(strA8F) && (strA8F.endsWith(A05(3, 3, 30)) || strA8F.endsWith(A05(0, 3, 50)));
    }
}
