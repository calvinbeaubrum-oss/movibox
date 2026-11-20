package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.84, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass84 {
    public static SparseIntArray A00;
    public static Executor A01;
    public static boolean A02;
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05 = {"lfqbOpCQc8eNVWWSF0ti", "aQ5ZOD0I", "7f7up0GBGRCd1p0enpCjG4lcj76", "dHBYXWbpLBdqteinvxBO5bOixoP3oT04", "DPNUUQYEctncegz3shse9IBb8Vdl47", "4q0rwT09y0cbatV7Yp", "6l64E9SK9p5G", "edaEIeRSccYYgTnyelVwcwdzoe4C2sfO"};
    public static final List<Integer> A06;
    public static final List<AnonymousClass85> A07;
    public static final AtomicBoolean A08;
    public static final AtomicInteger A09;
    public static final AtomicReference<AnonymousClass82> A0A;
    public static final AtomicReference<AnonymousClass83> A0B;
    public static final AtomicReference<Boolean> A0C;

    static {
        A04();
        A00 = new SparseIntArray();
        A03 = false;
        A0B = new AtomicReference<>();
        A0A = new AtomicReference<>();
        A01 = Executors.newSingleThreadExecutor();
        A06 = Arrays.asList(10, 50, 100, 1000);
        A07 = Collections.synchronizedList(new ArrayList());
        A09 = new AtomicInteger();
        A08 = new AtomicBoolean();
        A0C = new AtomicReference<>(false);
        A02 = false;
    }

    public static int A00(String str, int i11, C11237f c11237f) {
        if ((A01(465, 7, 107).equals(str) && C8A.A20 == i11) || A01(422, 5, 56).equals(str) || A01(445, 6, 63).equals(str)) {
            return 200;
        }
        if (A01(386, 36, 98).equals(str)) {
            return 50;
        }
        if (A01(371, 15, 18).equals(str)) {
            return Ij.A05(c11237f);
        }
        if (A05[3].charAt(3) != 'Y') {
            throw new RuntimeException();
        }
        A05[7] = "MSKlPe4okWTggpeViHGlBF3nlCraGBz9";
        return -1;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static /* synthetic */ List A02() {
        List<AnonymousClass85> list = A07;
        String[] strArr = A05;
        if (strArr[4].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        A05[1] = "TV2BvPAOYvnRV0R5I88rwwfNZOOU8";
        return list;
    }

    public static void A04() {
        A04 = new byte[]{-93, -105, -40, -37, -37, -32, -21, -32, -26, -27, -40, -29, -64, -27, -35, -26, -105, -76, -105, -110, -122, -45, -53, -39, -39, -57, -51, -53, -122, -93, -122, 91, 79, -94, -92, -111, -93, -88, -97, -108, 114, -98, -109, -108, 79, 108, 79, 116, -66, -36, -23, -94, -17, -101, -25, -22, -30, -101, -65, -32, -35, -16, -30, -101, -64, -15, -32, -23, -17, -87, -101, -66, -22, -23, -17, -32, -13, -17, -101, -28, -18, -101, -23, -16, -25, -25, -87, 119, -93, -87, -94, -88, -103, -90, 110, 84, -79, -46, -49, -30, -44, -115, -48, -33, -50, -32, -43, -115, -49, -46, -48, -50, -30, -32, -46, -115, -36, -45, -115, -46, -29, -46, -37, -31, -115, -28, -42, -31, -43, -115, -32, -30, -49, -31, -26, -35, -46, -115, -86, -115, 108, -97, -118, -116, -116, -117, -116, -117, 71, -112, -107, 84, -108, -116, -108, -106, -103, -96, 71, -109, -106, -114, 71, -109, -112, -108, -112, -101, 72, 71, 115, -120, -102, -101, 71, -116, -99, -116, -107, -101, 97, 71, -108, -57, -78, -76, -65, -61, -72, -66, -67, 111, -109, -76, -79, -60, -74, 111, -108, -59, -76, -67, -61, 111, -58, -72, -61, -73, 111, -62, -60, -79, -61, -56, -65, -76, 111, -116, 111, -97, -46, -67, -65, -54, -50, -61, -55, -56, 122, -66, -49, -52, -61, -56, -63, 122, -58, -55, -63, -63, -61, -56, -63, 122, -66, -65, -68, -49, -63, 122, -65, -48, -65, -56, -50, -120, -27, Ascii.CAN, 3, 5, Ascii.DLE, Ascii.DC4, 9, Ascii.SI, Ascii.SO, -64, 19, 8, Ascii.SI, Ascii.NAK, Ascii.FF, 4, -64, Ascii.SO, Ascii.SI, Ascii.DC4, -64, 8, 1, Ascii.DLE, Ascii.DLE, 5, Ascii.SO, -64, 8, 5, Ascii.DC2, 5, -50, -101, -105, -106, -54, -71, -66, -70, -61, -72, -70, -93, -70, -55, -52, -60, -57, -64, -28, 9, 1, 10, -69, -33, 0, -3, Ascii.DLE, 2, -69, -32, 17, 0, 9, Ascii.SI, -69, Ascii.DC2, 4, Ascii.SI, 3, -69, Ascii.SO, Ascii.DLE, -3, Ascii.SI, Ascii.DC4, Ascii.VT, 0, -69, -40, -69, -53, -26, -26, -105, -28, -40, -27, -16, -105, -36, -19, -36, -27, -21, -22, -105, -26, -35, -105, -22, -20, -39, -21, -16, -25, -36, -105, -38, -26, -37, -36, -79, -105, -101, -99, -104, -99, -102, -83, -102, -104, -91, -88, -96, -96, -94, -89, -96, -21, -8, -3, -24, -19, -18, -3, -18, -20, -3, -14, -8, -9, -24, 0, -8, -24, -4, -14, -16, -9, -22, -11, -24, -19, -22, -3, -22, -24, -11, -8, -16, -16, -14, -9, -16, -62, -64, -62, -57, -60, -57, -58, -49, -62, -41, -56, -42, -41, -4, -3, -9, 4, 7, -1, -1, 1, 6, -1, -52, -37, -44, -44, -53, -46, -41, -34, -47, -51, -28, -49, -38, -41, -46, -49, -30, -41, -35, -36, 0, -9, 6, 9, 1, 4, -3};
    }

    public static void A05(C11237f c11237f, int i11, int i12) {
        c11237f.A07().A9a(A01(435, 10, 113), C8A.A2X, new C8B(A01(338, 33, 80) + i11, A01(87, 9, 13) + i12));
    }

    @Deprecated
    public static void A06(C11237f c11237f, String str, int i11, C8B c8b) {
        if (c11237f == null) {
            A0F(new RuntimeException(A01(48, 39, 84)));
            return;
        }
        AbstractC11227e.A01(c11237f.A01());
        if (A02 && c8b.A01() == 0) {
            A0D(new RuntimeException(A01(96, 44, 70) + str + A01(31, 16, 8) + i11, c8b));
        }
        try {
            if (A0J(c11237f, str, i11, Math.random(), c8b)) {
                A09(c11237f, str, i11, c8b);
            }
        } catch (Throwable th2) {
            A0F(th2);
        }
    }

    @Deprecated
    public static void A07(C11237f c11237f, String str, int i11, C8B c8b) {
        try {
            c8b.A05(2);
            c8b.A0A(false);
            c8b.A06(1);
            if (Ij.A0Q(c11237f)) {
                c8b.A08(true);
            } else {
                c8b.A08(false);
            }
            A06(c11237f, str, i11, c8b);
        } catch (Throwable th2) {
            A0F(th2);
        }
    }

    @Deprecated
    public static void A08(C11237f c11237f, String str, int i11, C8B c8b) {
        try {
            c8b.A05(2);
            c8b.A08(false);
            A06(c11237f, str, i11, c8b);
        } catch (Throwable th2) {
            A0F(th2);
        }
    }

    public static void A09(C11237f c11237f, String str, int i11, C8B c8b) {
        synchronized (AnonymousClass84.class) {
            if (A03) {
                A0A(c11237f, str, i11, c8b, true);
            } else {
                int iA01 = Ij.A01(c11237f);
                AtomicInteger atomicInteger = A09;
                if (atomicInteger.getAndIncrement() < iA01 - 1) {
                    A07.add(new AnonymousClass85(str, i11, c8b));
                } else if (atomicInteger.get() == iA01) {
                    A07.add(new AnonymousClass85(A01(435, 10, 113), C8A.A2U, new C8B(A01(140, 42, 0) + str + A01(47, 1, 19) + i11)));
                }
            }
        }
    }

    public static void A0A(C11237f c11237f, String str, int i11, C8B c8b, boolean z11) throws Throwable {
        AnonymousClass83 anonymousClass83 = A0B.get();
        boolean z12 = anonymousClass83 != null && anonymousClass83.A9G();
        if (A08.get() || z12) {
            int iA01 = c8b.A01();
            String strA01 = A01(289, 17, 46);
            String strA02 = A01(31, 16, 8);
            if (iA01 == 0) {
                Log.e(strA01, A01(182, 37, 40) + str + strA02 + i11, c8b);
            } else {
                Log.i(strA01, A01(306, 32, 116) + str + strA02 + i11 + A01(19, 12, 63) + c8b.getMessage() + A01(0, 19, 80) + c8b.A03());
            }
        }
        C1786Ye c1786Ye = new C1786Ye(c11237f, str, i11, c8b, anonymousClass83);
        if (z11) {
            A01.execute(c1786Ye);
        } else {
            c1786Ye.run();
        }
    }

    public static void A0C(C1794Ym c1794Ym, AnonymousClass83 anonymousClass83, AnonymousClass82 anonymousClass82, boolean z11) {
        A0A.set(anonymousClass82);
        A0B.set(anonymousClass83);
        A08.set(z11);
        synchronized (AnonymousClass84.class) {
            if (!A03) {
                A03 = true;
                A01.execute(new C1787Yf(c1794Ym));
            }
        }
    }

    public static void A0D(final RuntimeException runtimeException) {
        if (A02) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.ads.redexgen.X.81
                @Override // java.lang.Runnable
                public final void run() {
                    throw runtimeException;
                }
            });
        }
    }

    @Deprecated
    public static void A0E(Throwable th2) {
        if (A02) {
            A0D(new RuntimeException(A01(256, 33, 121), th2));
        }
    }

    public static void A0F(Throwable th2) {
        Log.e(A01(289, 17, 46), A01(219, 37, 51), th2);
        if (A02) {
            A0D(new RuntimeException(th2));
        }
    }

    public static boolean A0H(C11237f c11237f) {
        Boolean bool = A0C.get();
        return (bool == null || !bool.booleanValue()) && Ij.A0A(c11237f) != 0;
    }

    public static boolean A0I(C11237f c11237f) {
        Boolean bool = A0C.get();
        if (bool == null || !bool.booleanValue()) {
            return c11237f.A08().A00() <= 1.0d / ((double) Ij.A0A(c11237f));
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x01c5, code lost:
    
        if (r10 != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01ca, code lost:
    
        if (r8 > (r6 * r2)) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01cc, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01cd, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01db, code lost:
    
        if (r10 != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01e0, code lost:
    
        if (r8 > r6) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01e2, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01e3, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0J(C11237f c11237f, String str, int i11, double d11, C8B c8b) {
        double d12;
        boolean z11;
        try {
            int iA04 = Ij.A04(c11237f);
            if (iA04 < 1) {
                return false;
            }
            HashMap<String, Integer> mapA0M = Ij.A0M(c11237f);
            Set<String> setKeySet = mapA0M.keySet();
            String str2 = str + A01(47, 1, 19) + i11;
            boolean zContains = setKeySet.contains(str2);
            if (zContains) {
                Integer num = mapA0M.get(str2);
                int iIntValue = num != null ? num.intValue() : -1;
                if (iIntValue == 0) {
                    return false;
                }
                if (iIntValue > 0) {
                    return d11 <= 1.0d / ((double) iIntValue);
                }
                int iA03 = Ij.A03(c11237f);
                if (iA03 < 1) {
                    return false;
                }
                d12 = ((double) (iA04 * iA03)) / 10000.0d;
            } else {
                d12 = !c8b.A0B() ? 0.0d : ((double) iA04) / 100.0d;
            }
            double dA00 = c11237f.A08().A00();
            if (A01(422, 5, 56).equals(str)) {
                if (c11237f.A04().A8z()) {
                    return true;
                }
                int iA06 = Ij.A06(c11237f);
                if (iA06 == 0) {
                    return false;
                }
                if (iA06 > 0) {
                    double d13 = 1.0d / ((double) iA06);
                    if (zContains) {
                        return dA00 <= d13 * d12;
                    }
                    return dA00 <= d13;
                }
            }
            if (A01(465, 7, 107).equals(str) && C8A.A20 == i11) {
                int iA0E = A08.get() ? 1 : Ij.A0E(c11237f);
                if (iA0E == 0) {
                    return false;
                }
                if (iA0E > 0) {
                    double d14 = 1.0d / ((double) iA0E);
                    if (zContains) {
                        return dA00 <= d14 * d12;
                    }
                    return dA00 <= d14;
                }
            }
            if (A01(427, 8, 60).equals(str)) {
                return true;
            }
            if (A01(445, 6, 63).equals(str)) {
                if ((!Ij.A0S(c11237f) || !c8b.A0C()) && c8b.A00() != 1) {
                    if (c8b.A00() == 2) {
                        return false;
                    }
                    AtomicReference<Boolean> atomicReference = A0C;
                    Boolean bool = atomicReference.get();
                    if (bool != null && bool.booleanValue()) {
                        return false;
                    }
                    int iA0A = Ij.A0A(c11237f);
                    if (iA0A == 0) {
                        atomicReference.set(true);
                        return false;
                    }
                    if (iA0A > 0) {
                        double d15 = 1.0d / ((double) iA0A);
                        if (!zContains) {
                            return dA00 <= d15;
                        }
                        double d16 = d15 * d12;
                        if (A05[7].charAt(14) == 'T') {
                            throw new RuntimeException();
                        }
                        A05[1] = "";
                        return dA00 <= d16;
                    }
                }
                return !zContains || d11 >= 1.0d - d12;
            }
            if (!A01(451, 14, 71).equals(str)) {
                z11 = true;
            } else {
                if (c11237f.A04().A8z()) {
                    return true;
                }
                z11 = true;
                int iA0B = Ij.A0B(c11237f);
                if (iA0B == 0) {
                    return false;
                }
                if (iA0B > 0) {
                    double d17 = 1.0d / ((double) iA0B);
                    String[] strArr = A05;
                    if (strArr[4].length() != strArr[0].length()) {
                        String[] strArr2 = A05;
                        strArr2[5] = "ZRfXbaaC8JHltzId8j";
                        strArr2[2] = "p93qQE3ecw2IkDe7w04Viu4gQwe";
                    } else {
                        String[] strArr3 = A05;
                        strArr3[4] = "G6VE2UuXyW1KY5FJsZ9oDF6i4Fckld";
                        strArr3[0] = "Rw4UZ8099etu0WhLVqAg";
                    }
                }
            }
            if (d11 >= 1.0d - d12) {
                return z11;
            }
            return false;
        } catch (Throwable th2) {
            A0F(th2);
            return false;
        }
    }

    public static boolean A0K(C11237f c11237f, String str, int i11, C8B c8b) {
        if (!Ij.A0P(c11237f)) {
            return true;
        }
        int i12 = A00.get(i11);
        int iA00 = Ij.A00(c11237f);
        if (c8b.A02() != -1) {
            iA00 = c8b.A02();
        } else {
            int iA01 = A00(str, i11, c11237f);
            if (iA00 < iA01) {
                iA00 = iA01;
            }
        }
        if (i12 < iA00) {
            A00.put(i11, i12 + 1);
            return false;
        }
        if (A06.contains(Integer.valueOf(i12))) {
            boolean zA0D = c8b.A0D();
            if (A05[3].charAt(3) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[5] = "DtDXz8TrFQQZw1pkgy";
            strArr[2] = "wKGFu6BM2pQR03pr0dyvmA98nTz";
            if (zA0D) {
                A05(c11237f, i11, i12);
            }
        }
        A00.put(i11, i12 + 1);
        return true;
    }
}
