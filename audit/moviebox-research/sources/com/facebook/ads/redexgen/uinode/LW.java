package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class LW {
    public static byte[] A00;
    public static final Pattern A01;

    static {
        A07();
        A01 = Pattern.compile(A02(0, 24, 13));
    }

    public static String A00() {
        return A06(new Exception(A02(24, 19, 71)), -1, -1, false);
    }

    public static String A01(int i11) {
        if (i11 > 0 && new Random().nextFloat() < 1.0f / i11) {
            return A00();
        }
        return null;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A03(Context context, Throwable th2) {
        return A06(th2, C1384Ih.A0I(context), C1384Ih.A02(context), C1384Ih.A1G(context));
    }

    public static String A04(String str) {
        Matcher matcher = A01.matcher(str);
        return matcher.matches() ? matcher.group(1) : str;
    }

    public static String A06(Throwable th2, int i11, int i12, boolean z11) {
        String strA02 = A02(0, 0, 122);
        if (th2 == null) {
            return strA02;
        }
        try {
            C1689Uh c1689Uh = new C1689Uh();
            LU c1688Ug = c1689Uh;
            if (i12 >= 0) {
                c1688Ug = new C1687Uf(c1688Ug, i12);
            }
            if (i11 >= 0) {
                c1688Ug = new C1686Ue(c1688Ug, i11, i11);
            }
            if (z11) {
                c1688Ug = new C1688Ug(c1688Ug);
            }
            C1690Ui c1690Ui = new C1690Ui(c1689Uh, 1, c1688Ug);
            th2.printStackTrace(new PrintWriter(new LV(c1690Ui)));
            c1690Ui.flush();
            return c1689Uh.toString();
        } catch (Exception unused) {
            return strA02;
        }
    }

    public static void A07() {
        A00 = new byte[]{89, 45, 2, 90, Ascii.DLE, 5, 45, 2, 90, 42, Ascii.DLE, 92, Ascii.VT, 95, 44, 90, 88, 42, 48, 92, 43, 44, 95, 91, 120, 78, 73, 73, 94, 85, 79, Ascii.ESC, 72, 79, 90, 88, 80, Ascii.ESC, 79, 73, 90, 88, 94, 33, 45, 47, 108, 36, 35, 33, 39, 32, 45, 45, 41, 108, 35, 38, 49};
    }

    public static boolean A08(LT lt2) {
        String strA02 = lt2.A02();
        if (strA02 == null) {
            return false;
        }
        if (A0A(strA02)) {
            return true;
        }
        Iterator<String> it = lt2.A01().iterator();
        while (it.hasNext()) {
            if (A0A(it.next())) {
                return true;
            }
        }
        Iterator<String> it2 = lt2.A00().iterator();
        while (it2.hasNext()) {
            if (A0A(it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0A(String str) {
        return str.contains(A02(43, 16, 62));
    }
}
