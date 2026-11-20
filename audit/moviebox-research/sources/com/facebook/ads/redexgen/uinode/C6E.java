package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6E, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C6E {
    public static byte[] A00;
    public static String[] A01 = {"zJ7sRo3sU3MwvYkxVq5sKXU", "uwqdBBQkb", "sk1pAaPClwmr1DZFuM4XEVJDjMgj4luU", "2DEAuAVf", "LM1sVeBw6DNfIdZzIYsj5hqYQDPEhJFy", "hYSBjzGCwuKpFZFqojmwIwdxMJLMCyYz", "BWOi5Qn34m6VEGTMmYfzcDYeX0GTjOOy", "rscTiGR64sMWr7IEiXLU0M2EjoTwZlLg"};
    public static final AtomicReference<C6C> A02;
    public static final AtomicReference<String> A03;

    static {
        A05();
        A02 = new AtomicReference<>();
        A03 = new AtomicReference<>(A04(0, 0, 68));
    }

    public static C6C A00() {
        C6C c6c = A02.get();
        if (A01[6].charAt(15) == 'M') {
            String[] strArr = A01;
            strArr[3] = "GQnQs3ZS";
            strArr[1] = "yTwJu7KeR";
            C6C c6c2 = c6c;
            if (c6c2 != null) {
                return c6c2;
            }
            C6C c6cA00 = C6C.A00();
            String[] strArr2 = A01;
            if (strArr2[3].length() != strArr2[1].length()) {
                A01[0] = "yvynwBtI7EoQ7kGRkYf58OE";
                return c6cA00;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (android.text.TextUtils.isEmpty(r6.A03()) != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C6C A01(C11237f c11237f, C6C c6c) {
        if (c6c != null) {
            try {
            } catch (Throwable th2) {
                c11237f.A07().A9a(A04(12, 7, 6), C8A.A1Q, new C8B(th2));
            }
        }
        return C6K.A00(c11237f);
        return c6c;
    }

    public static C6C A02(C11237f c11237f, C6C c6c, C6D c6d) {
        C6F c6fA00 = null;
        try {
            if (AbstractC1383Ig.A06(c11237f) && (c6c == null || TextUtils.isEmpty(c6c.A03()))) {
                c6fA00 = C6G.A00(c11237f.getContentResolver());
            }
        } catch (Throwable th2) {
            c11237f.A07().A9a(A04(12, 7, 6), C8A.A1S, new C8B(th2));
        }
        if (c6fA00 != null && c6fA00.A01 != null) {
            A03.set(c6fA00.A01);
            c6d.A05(c6fA00.A01);
        }
        return (c6c != null || c6fA00 == null || TextUtils.isEmpty(c6fA00.A00)) ? c6c : new C6C(c6fA00.A00, c6fA00.A02, C6B.A05);
    }

    public static String A03() {
        String str = A03.get();
        return str == null ? A04(0, 0, 68) : str;
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-98, -90, -95, -100, -84, -77, -94, -81, -81, -90, -95, -94, -95, -97, -88, -97, -84, -93, -99, -20, -25, -23, -28, -30, -14, -7, -24, -11, -11, -20, -25, -24};
    }

    public static void A06(C6D c6d) {
        A02.set(c6d.A02());
        A03.set(c6d.A03());
    }

    public static void A07(C11237f c11237f) {
        try {
            C6D c6d = new C6D(c11237f);
            A06(c6d);
            if (A08()) {
                return;
            }
            AtomicReference<C6C> atomicReference = A02;
            C6C c6c = atomicReference.get();
            long jA01 = (c6c == null || TextUtils.isEmpty(c6c.A03())) ? -1L : c6c.A01();
            if (jA01 <= 0 || System.currentTimeMillis() - jA01 >= AbstractC1383Ig.A00(c11237f)) {
                C6C c6cA01 = AbstractC1383Ig.A07(c11237f) ? A01(c11237f, A02(c11237f, null, c6d)) : A02(c11237f, A01(c11237f, null), c6d);
                if (c6cA01 == null || TextUtils.isEmpty(c6cA01.A03())) {
                    return;
                }
                atomicReference.set(c6cA01);
                c6d.A04(c6cA01);
            }
        } catch (Throwable th2) {
            c11237f.A07().A9a(A04(12, 7, 6), C8A.A1R, new C8B(th2));
        }
    }

    public static boolean A08() {
        boolean z11 = false;
        if (L0.A04()) {
            if (A01[0].length() != 23) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "OqjdKmMb";
            strArr[1] = "Sbvi0a9C0";
            String strA04 = A04(0, 12, 9);
            if (L0.A05(strA04)) {
                A03.set(L0.A01(strA04));
                z11 = true;
            }
        }
        boolean zA04 = L0.A04();
        String[] strArr2 = A01;
        if (strArr2[5].charAt(29) != strArr2[4].charAt(29)) {
            A01[6] = "1QSggKSi3jrfAw1MbHCsavUz8mNGSj1M";
            if (!zA04) {
                return z11;
            }
        } else {
            A01[6] = "SqTb5lTJEle7YRZML8ItyxwGEN07wws1";
            if (!zA04) {
                return z11;
            }
        }
        String strA05 = A04(19, 13, 79);
        if (!L0.A05(strA05)) {
            return z11;
        }
        String strA01 = L0.A01(strA05);
        AtomicReference<C6C> atomicReference = A02;
        if (strA01 == null) {
            strA01 = A04(0, 0, 68);
        }
        atomicReference.set(new C6C(strA01, false, C6B.A04));
        return true;
    }
}
