package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class K4 {
    public static byte[] A07;
    public static final ThreadFactoryC1465Lr A08;
    public static final Executor A09;
    public static final AtomicReference<K8> A0A;
    public long A00;
    public K3 A01;
    public Map<String, String> A02;
    public final C2S A03;
    public final C1795Yn A04;
    public final K5 A05;
    public final String A06;

    static {
        A0A();
        ThreadFactoryC1465Lr threadFactoryC1465Lr = new ThreadFactoryC1465Lr();
        A08 = threadFactoryC1465Lr;
        A09 = Executors.newCachedThreadPool(threadFactoryC1465Lr);
        A0A = new AtomicReference<>();
    }

    public K4(C1795Yn c1795Yn) {
        this(c1795Yn, C2T.A00(c1795Yn.A01()));
    }

    public K4(C1795Yn c1795Yn, C2S c2s) {
        this.A00 = -1L;
        this.A04 = c1795Yn;
        this.A05 = K5.A00();
        this.A06 = K9.A01(c1795Yn);
        this.A03 = c2s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1699Us A02(long j11, K1 k11) {
        return new C1699Us(this, k11, j11);
    }

    public static String A05(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 80);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        C1795Yn c1795Yn = this.A04;
        if (c1795Yn == null || !C1606Rc.A0A(c1795Yn)) {
            return;
        }
        C8B c8b = new C8B(A05(7, 5, 107));
        c8b.A05(1);
        this.A04.A07().A9a(A05(85, 7, 111), C8A.A1x, c8b);
    }

    public static void A0A() {
        A07 = new byte[]{57, 62, 105, 111, 51, 62, 51, 122, 105, 107, 119, 117, 78, 65, 68, 72, 67, 89, 82, 95, 72, 92, 88, 72, 94, 89, 82, 68, 73, 98, 88, Ascii.VT, 121, 101, 17, Ascii.VT, 100, 101, 10, 108, 99, 102, 102, 10, 88, 79, 73, 79, 67, 92, 79, 78, Ascii.DC4, 53, 122, Ascii.FS, 51, 54, 54, 122, Utf8.REPLACEMENT_BYTE, 40, 40, 53, 40, 122, 57, 53, 62, Utf8.REPLACEMENT_BYTE, 122, 1, Ascii.DEL, 41, 7, 122, Ascii.DEL, 41, Ascii.SI, Ascii.CR, 6, Ascii.CR, Ascii.SUB, 1, Ascii.VT, 81, 90, 75, 72, 80, 77, 84, 40, 41, 0, 47, 42, 42, Ascii.SO, 41, 41, 45, 41, 43, 54, 47, 48, 61, 60};
    }

    private void A0B(int i11, String str) {
        String strA05 = A05(36, 16, 122);
        String strA06 = A05(0, 7, 90);
        String strA07 = A05(92, 10, 22);
        AbstractC1414Jp.A05(strA07, strA05, strA06);
        AbstractC1414Jp.A04(strA07, String.format(Locale.US, A05(52, 26, 10), Integer.valueOf(i11), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(C1401Jb c1401Jb) {
        K3 k11 = this.A01;
        if (k11 != null) {
            k11.ABR(c1401Jb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(C1401Jb c1401Jb) {
        ExecutorC1456Li.A00(new Uq(this, c1401Jb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0K(C1697Up c1697Up) {
        K3 k11 = this.A01;
        if (k11 != null) {
            k11.ADG(c1697Up);
        }
    }

    private void A0L(C1697Up c1697Up) {
        InterfaceC11277l interfaceC11277lA05;
        ExecutorC1456Li.A00(new C1698Ur(this, c1697Up));
        if (!C1384Ih.A26(this.A04) || (interfaceC11277lA05 = this.A04.A05()) == null) {
            return;
        }
        interfaceC11277lA05.A5m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(String str, long j11, K1 k11) {
        try {
            try {
                K7 k7A06 = this.A05.A06(this.A04, str, j11);
                C8S c8sA00 = k7A06.A00();
                if (c8sA00 != null) {
                    C1384Ih.A0R(this.A04).A2X(c8sA00.A08());
                    this.A04.A07().AAL();
                    this.A03.A0N(c8sA00.A06());
                    K0.A05(c8sA00.A05().A0B(), k11);
                    M2.A01(this.A04, A09, c8sA00);
                    C8B c8b = new C8B(A05(29, 7, 123) + LE.A02());
                    c8b.A06(1);
                    c8b.A0A(false);
                    this.A04.A07().AAA(A05(78, 7, 56), C8A.A1W, c8b);
                }
                switch (K2.A00[k7A06.A01().ordinal()]) {
                    case 1:
                        C1697Up c1697Up = (C1697Up) k7A06;
                        if (c8sA00 != null) {
                            if (c8sA00.A05().A0E()) {
                                K0.A07(str, k11);
                            }
                            Map<String, String> map = this.A02;
                            String str2 = map != null ? map.get(A05(12, 17, 93)) : null;
                            if (!TextUtils.isEmpty(k7A06.A02()) && !TextUtils.isEmpty(str2)) {
                                this.A04.A02().AFL(this.A04, str2, k7A06.A02());
                            }
                        }
                        this.A04.A0E().A2w(C1453Lf.A01(this.A00));
                        A0L(c1697Up);
                        break;
                    case 2:
                        C1696Uo c1696Uo = (C1696Uo) k7A06;
                        String strA04 = c1696Uo.A04();
                        AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(c1696Uo.A03(), AdErrorType.ERROR_MESSAGE);
                        A0B(c1696Uo.A03(), strA04);
                        if (strA04 == null) {
                            strA04 = str;
                        }
                        this.A04.A0E().A2v(C1453Lf.A01(this.A00), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA04, adErrorTypeAdErrorTypeFromCode.isPublicError());
                        A0D(C1401Jb.A01(adErrorTypeAdErrorTypeFromCode, strA04));
                        break;
                    default:
                        AdErrorType adErrorType = AdErrorType.UNKNOWN_RESPONSE;
                        this.A04.A0E().A2v(C1453Lf.A01(this.A00), adErrorType.getErrorCode(), str, adErrorType.isPublicError());
                        A0D(C1401Jb.A01(adErrorType, str));
                        break;
                }
            } catch (Exception e11) {
                e = e11;
                String message = e.getMessage();
                AdErrorType adErrorType2 = AdErrorType.PARSER_FAILURE;
                this.A04.A0E().A2v(C1453Lf.A01(this.A00), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
                A0D(C1401Jb.A01(adErrorType2, message));
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N(String str, long j11, K1 k11) {
        A09.execute(new C1700Ut(this, str, j11, k11));
    }

    public final void A0O(K1 k11) {
        this.A00 = System.currentTimeMillis();
        C8J.A0B(this.A04);
        A0A.get();
        if (0 != 0) {
            throw new NullPointerException(A05(102, 7, 9));
        }
        if (!K0.A08(k11)) {
            A09.execute(new C1701Uu(this, k11));
            return;
        }
        ExecutorC1467Lt.A06.execute(new C1702Uv(this));
        String strA02 = K0.A02(k11);
        if (strA02 != null) {
            this.A04.A0E().AGt();
            A0N(strA02, 0L, k11);
        } else {
            AdErrorType adErrorType = AdErrorType.LOAD_TOO_FREQUENTLY;
            this.A04.A0E().A2v(C1453Lf.A01(this.A00), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage(), adErrorType.isPublicError());
            A0D(C1401Jb.A01(adErrorType, null));
        }
    }

    public final void A0P(K3 k11) {
        this.A01 = k11;
    }
}
