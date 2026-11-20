package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EI implements Handler.Callback, WQ, InterfaceC1334Gi, InterfaceC1292Ep, C9Z, A6 {
    public static byte[] A0V;
    public static String[] A0W = {"TSIQGmaqgvrUxo0yYDewkVNDuuioOpPV", "LhstooR1wZsH8RVMZSyyF7FJZ5wrHutR", "WZmkRBn8iXpnqDBIN644YOqcruHieEQJ", "OBm1ApV8rqkCiyt7FxArHXpNA0", "RSLtmQKc5IgtmDXEpea3qKBmF", "cT5hSyxhu4oYAFMn61C1ja3cHbuAf9wl", "QQz6Qig88n9IGtqyO", "pBG4ezF2k8D44jdvacVEPM0q7VNUtk0G"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public C11759l A04;
    public C11859w A05;
    public InterfaceC1293Eq A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public Y5[] A0C;
    public final long A0D;
    public final Handler A0E;
    public final HandlerThread A0F;
    public final Y8 A0G;
    public final Y6 A0H;
    public final InterfaceC11809r A0J;
    public final AF A0L;
    public final AG A0M;
    public final AbstractC1335Gj A0N;
    public final C1336Gk A0O;
    public final InterfaceC1354Hd A0P;
    public final InterfaceC1364Hn A0Q;
    public final ArrayList<C11739j> A0R;
    public final boolean A0S;
    public final Y5[] A0T;
    public final AA[] A0U;
    public final C11839u A0K = new C11839u();
    public AD A06 = AD.A03;
    public final C11749k A0I = new C11749k();

    static {
        A0K();
    }

    public EI(Y5[] y5Arr, AbstractC1335Gj abstractC1335Gj, C1336Gk c1336Gk, InterfaceC11809r interfaceC11809r, boolean z11, int i11, boolean z12, Handler handler, Y6 y11, InterfaceC1354Hd interfaceC1354Hd) {
        this.A0T = y5Arr;
        this.A0N = abstractC1335Gj;
        this.A0O = c1336Gk;
        this.A0J = interfaceC11809r;
        this.A08 = z11;
        this.A02 = i11;
        this.A0B = z12;
        this.A0E = handler;
        this.A0H = y11;
        this.A0P = interfaceC1354Hd;
        this.A0D = interfaceC11809r.A65();
        this.A0S = interfaceC11809r.AFO();
        this.A05 = new C11859w(AH.A01, C.TIME_UNSET, TrackGroupArray.A04, c1336Gk);
        this.A0U = new AA[y5Arr.length];
        for (int i12 = 0; i12 < y5Arr.length; i12++) {
            y5Arr[i12].AG2(i12);
            this.A0U[i12] = y5Arr[i12].A6I();
        }
        this.A0G = new Y8(this, interfaceC1354Hd);
        this.A0R = new ArrayList<>();
        this.A0C = new Y5[0];
        this.A0M = new AG();
        this.A0L = new AF();
        abstractC1335Gj.A00(this);
        HandlerThread handlerThread = new HandlerThread(A06(21, 29, 0), -16);
        this.A0F = handlerThread;
        handlerThread.start();
        this.A0Q = interfaceC1354Hd.A4c(handlerThread.getLooper(), this);
    }

    private int A00() {
        AH ah2 = this.A05.A03;
        if (ah2.A0E()) {
            return 0;
        }
        return ah2.A0B(ah2.A05(this.A0B), this.A0M).A00;
    }

    private int A01(int i11, AH ah2, AH ah3) {
        int iA03 = i11;
        int iA04 = -1;
        int iA00 = ah2.A00();
        for (int i12 = 0; i12 < iA00 && iA04 == -1; i12++) {
            iA03 = ah2.A03(iA03, this.A0L, this.A0M, this.A02, this.A0B);
            if (iA03 == -1) {
                break;
            }
            iA04 = ah3.A04(ah2.A0A(iA03, this.A0L, true).A03);
        }
        return iA04;
    }

    private long A02(C1291Eo c1291Eo, long j11) throws C11669c {
        return A03(c1291Eo, j11, this.A0K.A0G() != this.A0K.A0H());
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0080  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b2  */
    private long A03(C1291Eo c1291Eo, long j11, boolean z11) throws C11669c {
        WP wp2;
        long j12;
        boolean z12;
        A0H();
        this.A09 = false;
        A0N(2);
        C11819s c11819sA0G = this.A0K.A0G();
        C11819s c11819sA0C = c11819sA0G;
        while (c11819sA0C != null) {
            boolean zA0t = A0t(c1291Eo, j11, c11819sA0C);
            String[] strArr = A0W;
            if (strArr[1].charAt(10) != strArr[0].charAt(10)) {
                A0W[7] = "3g90ZjAQy8gphAPE4L2ghHg16cmQ019E";
                if (zA0t) {
                    this.A0K.A0S(c11819sA0C);
                    break;
                }
                c11819sA0C = this.A0K.A0C();
            }
            throw new RuntimeException();
        }
        if (c11819sA0G != c11819sA0C || z11) {
            for (Y5 y11 : this.A0C) {
                A0b(y11);
            }
            this.A0C = new Y5[0];
            c11819sA0G = null;
        }
        if (c11819sA0C != null) {
            A0V(c11819sA0G);
            String[] strArr2 = A0W;
            if (strArr2[1].charAt(10) != strArr2[0].charAt(10)) {
                String[] strArr3 = A0W;
                strArr3[4] = "JYav744H3005gGdd3wHQ67gij";
                strArr3[3] = "FVGbgJ3f5rxs8oy2Mt1O3WpPvx";
                if (c11819sA0C.A05) {
                    j11 = c11819sA0C.A08.AFl(j11);
                    wp2 = c11819sA0C.A08;
                    j12 = j11 - this.A0D;
                    z12 = this.A0S;
                    if (A0W[7].charAt(9) == '8') {
                        A0W[7] = "LvYFslBjN8wEk55S4mS5Jlrj4VNptxmz";
                        wp2.A5A(j12, z12);
                    }
                    throw new RuntimeException();
                }
            } else if (c11819sA0C.A05) {
                j11 = c11819sA0C.A08.AFl(j11);
                wp2 = c11819sA0C.A08;
                j12 = j11 - this.A0D;
                z12 = this.A0S;
                if (A0W[7].charAt(9) == '8') {
                    A0W[7] = "LvYFslBjN8wEk55S4mS5Jlrj4VNptxmz";
                    wp2.A5A(j12, z12);
                }
                throw new RuntimeException();
            }
            A0P(j11);
            A09();
        } else {
            this.A0K.A0O(true);
            A0P(j11);
        }
        this.A0Q.AFn(2);
        if (A0W[2].charAt(12) != 'N') {
            A0W[2] = "qbdkiXSPlbFYutVyIKxCWSr3uDHCS3n2";
            return j11;
        }
        throw new RuntimeException();
    }

    private Pair<Integer, Long> A04(C11759l c11759l, boolean z11) {
        int iA01;
        AH ah2 = this.A05.A03;
        AH ah3 = c11759l.A02;
        if (ah2.A0E()) {
            return null;
        }
        if (ah3.A0E()) {
            ah3 = ah2;
        }
        try {
            Pair<Integer, Long> pairA07 = ah3.A07(this.A0M, this.A0L, c11759l.A00, c11759l.A01);
            if (ah2 == ah3) {
                return pairA07;
            }
            int iA04 = ah2.A04(ah3.A0A(((Integer) pairA07.first).intValue(), this.A0L, true).A03);
            if (iA04 != -1) {
                return Pair.create(Integer.valueOf(iA04), (Long) pairA07.second);
            }
            if (!z11 || (iA01 = A01(((Integer) pairA07.first).intValue(), ah3, ah2)) == -1) {
                return null;
            }
            Pair<Integer, Long> pairA05 = A05(ah2, ah2.A09(iA01, this.A0L).A00, C.TIME_UNSET);
            String[] strArr = A0W;
            if (strArr[4].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0W;
            strArr2[1] = "LZRu6qU1d7MAJxELkyp6D6bqJ9pCtQWv";
            strArr2[0] = "5OOlDtGsHYXmvjCA2lYHypc4I8JTMes9";
            return pairA05;
        } catch (IndexOutOfBoundsException unused) {
            throw new C11799q(ah2, c11759l.A00, c11759l.A01);
        }
    }

    private Pair<Integer, Long> A05(AH ah2, int i11, long j11) {
        return ah2.A07(this.A0M, this.A0L, i11, j11);
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0V, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 42);
        }
        return new String(bArrCopyOfRange);
    }

    private void A07() throws IOException, C11669c {
        long jAGs = this.A0P.AGs();
        A0I();
        if (!this.A0K.A0P()) {
            A0B();
            A0R(jAGs, 10L);
            return;
        }
        C11819s c11819sA0G = this.A0K.A0G();
        IC.A02(A06(150, 10, 20));
        A0J();
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        c11819sA0G.A08.A5A(this.A05.A0A - this.A0D, this.A0S);
        boolean z11 = true;
        boolean z12 = true;
        for (Y5 y11 : this.A0C) {
            y11.AFB(this.A03, jElapsedRealtime);
            boolean z13 = true;
            z11 = z11 && y11.A91();
            boolean z14 = y11.A9C() || y11.A91() || A0s(y11);
            if (!z14) {
                y11.AAP();
            }
            if (!z12 || !z14) {
                z13 = false;
            }
            z12 = z13;
        }
        if (!z12) {
            A0B();
        }
        long j11 = c11819sA0G.A02.A01;
        if (z11 && ((j11 == C.TIME_UNSET || j11 <= this.A05.A0A) && c11819sA0G.A02.A05)) {
            A0N(4);
            A0H();
        } else if (this.A05.A00 == 2 && A0u(z12)) {
            A0N(3);
            if (this.A08) {
                A0G();
            }
        } else if (this.A05.A00 == 3) {
            int length = this.A0C.length;
            String[] strArr = A0W;
            if (strArr[4].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0W;
            strArr2[4] = "Eggx5Ft4Lgnx6HVrotcHBkscR";
            strArr2[3] = "Urp4oA4mdP1paz0o5Y10JqXrCe";
            if (length != 0 ? !z12 : !A0q()) {
                this.A09 = this.A08;
                A0N(2);
                A0H();
            }
        }
        if (this.A05.A00 == 2) {
            for (Y5 y12 : this.A0C) {
                y12.AAP();
            }
        }
        boolean z15 = this.A08;
        if (A0W[7].charAt(9) != '8') {
            throw new RuntimeException();
        }
        A0W[5] = "rTELFOhgZqImPwKgVJI0nXuoysvpkaxO";
        if ((z15 && this.A05.A00 == 3) || this.A05.A00 == 2) {
            A0R(jAGs, 10L);
        } else if (this.A0C.length == 0 || this.A05.A00 == 4) {
            this.A0Q.AF8(2);
        } else {
            A0R(jAGs, 1000L);
        }
        IC.A00();
    }

    private void A08() {
        A0N(4);
        A0o(false, true, false);
    }

    private void A09() {
        C11819s c11819sA0F = this.A0K.A0F();
        long jA06 = c11819sA0F.A06();
        if (jA06 == Long.MIN_VALUE) {
            A0k(false);
            return;
        }
        boolean zAGI = this.A0J.AGI(jA06 - c11819sA0F.A08(this.A03), this.A0G.A7h().A01);
        A0k(zAGI);
        if (zAGI) {
            c11819sA0F.A0F(this.A03);
        }
    }

    private void A0A() {
        if (this.A0I.A06(this.A05)) {
            this.A0E.obtainMessage(0, this.A0I.A01, this.A0I.A03 ? this.A0I.A00 : -1, this.A05).sendToTarget();
            this.A0I.A05(this.A05);
        }
    }

    private void A0B() throws IOException {
        C11819s c11819sA0F = this.A0K.A0F();
        C11819s c11819sA0H = this.A0K.A0H();
        if (c11819sA0F == null || c11819sA0F.A06) {
            return;
        }
        if (c11819sA0H == null || c11819sA0H.A01 == c11819sA0F) {
            Y5[] y5Arr = this.A0C;
            if (A0W[2].charAt(12) == 'N') {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[4] = "M2PhxJTgTMxoek0nGdRGZ8ED7";
            strArr[3] = "JhH24KrsERDOvzAX41swXn1Uhz";
            for (Y5 y11 : y5Arr) {
                if (!y11.A8a()) {
                    return;
                }
            }
            c11819sA0F.A08.AAN();
        }
    }

    private void A0C() throws IOException {
        this.A0K.A0M(this.A03);
        if (this.A0K.A0Q()) {
            C11829t c11829tA0I = this.A0K.A0I(this.A03, this.A05);
            if (c11829tA0I == null) {
                this.A07.AAO();
                return;
            }
            this.A0K.A0K(this.A0U, this.A0N, this.A0J.A60(), this.A07, this.A05.A03.A0A(c11829tA0I.A04.A02, this.A0L, true).A03, c11829tA0I).AE4(this, c11829tA0I.A03);
            A0k(true);
        }
    }

    private void A0D() {
        A0o(true, true, true);
        this.A0J.ACr();
        A0N(1);
        this.A0F.quit();
        synchronized (this) {
            this.A0A = true;
            notifyAll();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:46:0x0106  */
    /* JADX WARN: Code duplicated, block: B:47:0x0111  */
    /* JADX WARN: Code duplicated, block: B:48:0x0113  */
    /* JADX WARN: Code duplicated, block: B:56:0x0143  */
    /* JADX WARN: Code duplicated, block: B:58:0x014c  */
    /* JADX WARN: Code duplicated, block: B:76:0x019e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x00ef A[SYNTHETIC] */
    private void A0E() throws C11669c {
        C11819s c11819sA0G;
        boolean[] zArr;
        long jA0B;
        int i11;
        boolean[] zArr2;
        int i12;
        Y5[] y5Arr;
        Y5 y11;
        boolean z11;
        FB fb2;
        long j11;
        if (this.A0K.A0P()) {
            float f11 = this.A0G.A7h().A01;
            C11819s c11819sA0H = this.A0K.A0H();
            if (A0W[6].length() == 17) {
                String[] strArr = A0W;
                strArr[1] = "D9etX6yGBrwjRzOUEpEFU5ER5XUfrbIh";
                strArr[0] = "v3YP09X53VrDeZJkDNiGeietvmwAimn0";
                boolean z12 = true;
                for (C11819s c11819sA0G2 = this.A0K.A0G(); c11819sA0G2 != null && c11819sA0G2.A06; c11819sA0G2 = c11819sA0G2.A01) {
                    if (c11819sA0G2.A0I(f11)) {
                        if (A0W[2].charAt(12) != 'N') {
                            A0W[2] = "qdzsaLeT6GVLLZLLIHWPE1kBVsafqqMr";
                            if (z12) {
                                c11819sA0G = this.A0K.A0G();
                                boolean zA0S = this.A0K.A0S(c11819sA0G);
                                zArr = new boolean[this.A0T.length];
                                jA0B = c11819sA0G.A0B(this.A05.A0A, zA0S, zArr);
                                A0i(c11819sA0G.A03, c11819sA0G.A04);
                                if (this.A05.A00 != 4 && jA0B != this.A05.A0A) {
                                    C11859w c11859w = this.A05;
                                    this.A05 = c11859w.A04(c11859w.A04, jA0B, this.A05.A01);
                                    this.A0I.A04(4);
                                    A0P(jA0B);
                                }
                                i11 = 0;
                                if (A0W[2].charAt(12) != 'N') {
                                    String[] strArr2 = A0W;
                                    strArr2[1] = "v6rigB8My08mC5ZvZtTcxONYTtnHkhiY";
                                    strArr2[0] = "jJJ7EyTzSHhVUQBMBNjuu6IlWzfsi9o6";
                                    zArr2 = new boolean[this.A0T.length];
                                    i12 = 0;
                                } else {
                                    A0W[7] = "5RhHFxqKf8KludlSzI9zDK8m295dvAFV";
                                    zArr2 = new boolean[this.A0T.length];
                                    i12 = 0;
                                }
                                while (true) {
                                    y5Arr = this.A0T;
                                    if (i12 < y5Arr.length) {
                                        this.A05 = this.A05.A05(c11819sA0G.A03, c11819sA0G.A04);
                                        A0p(zArr2, i11);
                                        break;
                                    }
                                    y11 = y5Arr[i12];
                                    if (y11.A81() != 0) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    zArr2[i12] = z11;
                                    fb2 = c11819sA0G.A0A[i12];
                                    if (fb2 != null) {
                                        i11++;
                                    }
                                    if (!zArr2[i12]) {
                                        if (fb2 != y11.A84()) {
                                            A0b(y11);
                                        } else if (zArr[i12]) {
                                            j11 = this.A03;
                                            if (A0W[5].charAt(1) != 'w') {
                                                throw new RuntimeException();
                                            }
                                            A0W[7] = "kUW5tsmcM8CZIAjkj84TOGdyZAx2gWc6";
                                            y11.AFN(j11);
                                        } else {
                                            continue;
                                        }
                                    }
                                    i12++;
                                }
                            } else {
                                this.A0K.A0S(c11819sA0G2);
                                if (c11819sA0G2.A06) {
                                    c11819sA0G2.A0A(Math.max(c11819sA0G2.A02.A03, c11819sA0G2.A08(this.A03)), false);
                                    A0i(c11819sA0G2.A03, c11819sA0G2.A04);
                                }
                            }
                        } else {
                            A0W[5] = "7WrBcNkU6uNk4nx5t1RXmqyIgKSjjx3l";
                            if (z12) {
                                c11819sA0G = this.A0K.A0G();
                                boolean zA0S2 = this.A0K.A0S(c11819sA0G);
                                zArr = new boolean[this.A0T.length];
                                jA0B = c11819sA0G.A0B(this.A05.A0A, zA0S2, zArr);
                                A0i(c11819sA0G.A03, c11819sA0G.A04);
                                if (this.A05.A00 != 4) {
                                    C11859w c11859w2 = this.A05;
                                    this.A05 = c11859w2.A04(c11859w2.A04, jA0B, this.A05.A01);
                                    this.A0I.A04(4);
                                    A0P(jA0B);
                                }
                                i11 = 0;
                                if (A0W[2].charAt(12) != 'N') {
                                    String[] strArr3 = A0W;
                                    strArr3[1] = "v6rigB8My08mC5ZvZtTcxONYTtnHkhiY";
                                    strArr3[0] = "jJJ7EyTzSHhVUQBMBNjuu6IlWzfsi9o6";
                                    zArr2 = new boolean[this.A0T.length];
                                    i12 = 0;
                                } else {
                                    A0W[7] = "5RhHFxqKf8KludlSzI9zDK8m295dvAFV";
                                    zArr2 = new boolean[this.A0T.length];
                                    i12 = 0;
                                }
                                while (true) {
                                    y5Arr = this.A0T;
                                    if (i12 < y5Arr.length) {
                                        this.A05 = this.A05.A05(c11819sA0G.A03, c11819sA0G.A04);
                                        A0p(zArr2, i11);
                                        break;
                                    }
                                    y11 = y5Arr[i12];
                                    if (y11.A81() != 0) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    zArr2[i12] = z11;
                                    fb2 = c11819sA0G.A0A[i12];
                                    if (fb2 != null) {
                                        i11++;
                                    }
                                    if (!zArr2[i12]) {
                                        if (fb2 != y11.A84()) {
                                            A0b(y11);
                                        } else if (zArr[i12]) {
                                            j11 = this.A03;
                                            if (A0W[5].charAt(1) != 'w') {
                                                throw new RuntimeException();
                                            }
                                            A0W[7] = "kUW5tsmcM8CZIAjkj84TOGdyZAx2gWc6";
                                            y11.AFN(j11);
                                        } else {
                                            continue;
                                        }
                                    }
                                    i12++;
                                }
                            } else {
                                this.A0K.A0S(c11819sA0G2);
                                if (c11819sA0G2.A06) {
                                    c11819sA0G2.A0A(Math.max(c11819sA0G2.A02.A03, c11819sA0G2.A08(this.A03)), false);
                                    A0i(c11819sA0G2.A03, c11819sA0G2.A04);
                                }
                            }
                        }
                        int i13 = this.A05.A00;
                        if (A0W[6].length() == 17) {
                            String[] strArr4 = A0W;
                            strArr4[4] = "GCKjwcvTJfMpQgG8NpKVbaI1H";
                            strArr4[3] = "kOcbaoLdOMGBVdRezVYeBIh2yM";
                            if (i13 == 4) {
                                return;
                            }
                            A09();
                            A0J();
                            InterfaceC1364Hn interfaceC1364Hn = this.A0Q;
                            if (A0W[6].length() == 17) {
                                A0W[5] = "0v8QL5oJXgBRdj6LoWxDDzyaCLbuPlQC";
                                interfaceC1364Hn.AFn(2);
                                return;
                            }
                        }
                    } else {
                        if (c11819sA0G2 == c11819sA0H) {
                            z12 = false;
                        }
                    }
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    private void A0F() {
        for (int size = this.A0R.size() - 1; size >= 0; size--) {
            if (!A0r(this.A0R.get(size))) {
                this.A0R.get(size).A03.A0A(false);
                this.A0R.remove(size);
            }
        }
        Collections.sort(this.A0R);
    }

    private void A0G() throws C11669c {
        this.A09 = false;
        this.A0G.A05();
        for (Y5 y11 : this.A0C) {
            y11.start();
        }
    }

    private void A0H() throws C11669c {
        this.A0G.A06();
        for (Y5 y11 : this.A0C) {
            A0c(y11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0098  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    private void A0I() throws IOException, C11669c {
        int i11;
        EI ei2 = this;
        InterfaceC1293Eq interfaceC1293Eq = ei2.A07;
        if (interfaceC1293Eq == null) {
            return;
        }
        if (ei2.A01 > 0) {
            interfaceC1293Eq.AAO();
            return;
        }
        A0C();
        C11819s c11819sA0F = ei2.A0K.A0F();
        if (c11819sA0F == null || c11819sA0F.A0H()) {
            ei2.A0k(false);
        } else if (!ei2.A05.A08) {
            A09();
        }
        if (!ei2.A0K.A0P()) {
            return;
        }
        C11819s c11819sA0G = ei2.A0K.A0G();
        C11819s c11819sA0H = ei2.A0K.A0H();
        boolean z11 = false;
        while (true) {
            boolean z12 = ei2.A08;
            if (A0W[6].length() != 17) {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[4] = "7VXwhx8w334qXwwhe6EPuoxrs";
            strArr[3] = "i8G0S3EG91lb4Tbi5TJ2bFfoM2";
            if (z12 && c11819sA0G != c11819sA0H && ei2.A03 >= c11819sA0G.A01.A00) {
                if (z11) {
                    A0A();
                }
                boolean z13 = c11819sA0G.A02.A06;
                String[] strArr2 = A0W;
                if (strArr2[1].charAt(10) != strArr2[0].charAt(10)) {
                    A0W[7] = "JHuaS3X828K0z1yeMtavkm7JkVnfol1Z";
                    if (z13) {
                        i11 = 0;
                    } else {
                        i11 = 3;
                    }
                } else {
                    A0W[5] = "wtrsjVL1JaCAi24uhunV07R35PJNTCvI";
                    if (z13) {
                        i11 = 0;
                    } else {
                        i11 = 3;
                    }
                }
                C11819s c11819s = c11819sA0G;
                c11819sA0G = ei2.A0K.A0C();
                ei2.A0V(c11819s);
                ei2.A05 = ei2.A05.A04(c11819sA0G.A02.A04, c11819sA0G.A02.A03, c11819sA0G.A02.A00);
                ei2.A0I.A04(i11);
                A0J();
                z11 = true;
            } else if (c11819sA0H.A02.A05) {
                int i12 = 0;
                while (true) {
                    Y5[] y5Arr = ei2.A0T;
                    if (i12 >= y5Arr.length) {
                        return;
                    }
                    Y5 y11 = y5Arr[i12];
                    FB fb2 = c11819sA0H.A0A[i12];
                    if (fb2 != null && y11.A84() == fb2 && y11.A8a()) {
                        y11.AFy();
                    }
                    i12++;
                }
            } else {
                if (c11819sA0H.A01 == null || !c11819sA0H.A01.A06) {
                    return;
                }
                int i13 = 0;
                while (true) {
                    Y5[] y5Arr2 = ei2.A0T;
                    if (i13 < y5Arr2.length) {
                        Y5 y12 = y5Arr2[i13];
                        FB fb3 = c11819sA0H.A0A[i13];
                        FB fbA84 = y12.A84();
                        String[] strArr3 = A0W;
                        if (strArr3[1].charAt(10) != strArr3[0].charAt(10)) {
                            A0W[2] = "GzZd6F7lJVp08TeGQitpN19OrvCnG4PK";
                            if (fbA84 != fb3) {
                                return;
                            }
                        } else {
                            A0W[5] = "G5Kl7lcZBM87T4fNUwO1IYVdGnNcsgpo";
                            if (fbA84 != fb3) {
                                return;
                            }
                        }
                        if (fb3 != null && !y12.A8a()) {
                            return;
                        } else {
                            i13++;
                        }
                    } else {
                        C1336Gk c1336Gk = c11819sA0H.A04;
                        C11819s c11819sA0D = ei2.A0K.A0D();
                        C1336Gk c1336Gk2 = c11819sA0D.A04;
                        boolean z14 = c11819sA0D.A08.AEL() != C.TIME_UNSET;
                        int i14 = 0;
                        while (true) {
                            Y5[] y5Arr3 = ei2.A0T;
                            String[] strArr4 = A0W;
                            if (strArr4[1].charAt(10) != strArr4[0].charAt(10)) {
                                A0W[5] = "zgqvIFw9hHXttypZtkJx3efsgqUZ32NO";
                                if (i14 >= y5Arr3.length) {
                                    return;
                                }
                            } else if (i14 >= y5Arr3.length) {
                                return;
                            }
                            Y5 y13 = y5Arr3[i14];
                            if (c1336Gk.A00(i14)) {
                                if (z14) {
                                    y13.AFy();
                                } else if (!y13.A8y()) {
                                    InterfaceC1332Gg interfaceC1332GgA00 = c1336Gk2.A01.A00(i14);
                                    boolean zA00 = c1336Gk2.A00(i14);
                                    boolean z15 = ei2.A0U[i14].A8C() == 5;
                                    AB ab2 = c1336Gk.A03[i14];
                                    AB ab3 = c1336Gk2.A03[i14];
                                    if (zA00 && ab3.equals(ab2) && !z15) {
                                        y13.AFD(A0v(interfaceC1332GgA00), c11819sA0D.A0A[i14], c11819sA0D.A07());
                                    } else {
                                        y13.AFy();
                                    }
                                }
                            }
                            i14++;
                            ei2 = this;
                        }
                    }
                }
            }
        }
    }

    private void A0J() throws C11669c {
        if (this.A0K.A0P()) {
            C11819s c11819sA0G = this.A0K.A0G();
            WP wp2 = c11819sA0G.A08;
            if (A0W[6].length() != 17) {
                throw new RuntimeException();
            }
            A0W[7] = "e9etinPRA8BQH2CZknXr4yAbSJ3blA39";
            long jAEL = wp2.AEL();
            if (jAEL != C.TIME_UNSET) {
                A0P(jAEL);
                if (jAEL != this.A05.A0A) {
                    C11859w c11859w = this.A05;
                    this.A05 = c11859w.A04(c11859w.A04, jAEL, this.A05.A01);
                    this.A0I.A04(4);
                }
            } else {
                long jA04 = this.A0G.A04();
                this.A03 = jA04;
                long jA08 = c11819sA0G.A08(jA04);
                A0Q(this.A05.A0A, jA08);
                this.A05.A0A = jA08;
            }
            this.A05.A09 = this.A0C.length == 0 ? c11819sA0G.A02.A01 : c11819sA0G.A0C(true);
        }
    }

    public static void A0K() {
        byte[] bArr = {68, 121, 110, 81, 109, 96, 120, 100, 115, 72, 108, 113, 109, 72, 111, 117, 100, 115, 111, 96, 109, 111, 82, 69, 122, 70, 75, 83, 79, 88, 99, 71, 90, 70, 99, 68, 94, 79, 88, 68, 75, 70, Ascii.DLE, 98, 75, 68, 78, 70, 79, 88, 66, 108, 101, 100, 121, 98, 101, 108, 43, 102, 110, 120, 120, 106, 108, 110, 120, 43, 120, 110, 101, Ascii.DEL, 43, 106, 109, Ascii.DEL, 110, 121, 43, 121, 110, 103, 110, 106, 120, 110, 37, 69, 98, 120, 105, 126, 98, 109, 96, 44, 126, 121, 98, 120, 101, 97, 105, 44, 105, 126, 126, 99, 126, 34, Ascii.CAN, 36, 41, 49, 42, 41, 43, 35, 104, 45, 58, 58, 39, 58, 102, 74, 118, 108, 107, 122, 124, 57, 124, 107, 107, 118, 107, 55, 72, 111, 116, 107, 59, 125, 122, 114, 119, 126, Ascii.DEL, 53, 90, 81, 109, 81, 83, 91, 105, 81, 76, 85};
        String[] strArr = A0W;
        if (strArr[1].charAt(10) == strArr[0].charAt(10)) {
            throw new RuntimeException();
        }
        A0W[7] = "OuUcfGxYs8HKuxzYIQS3N8YCcqwYwO9D";
        A0V = bArr;
    }

    private void A0L(float f11) {
        for (C11819s c11819sA0E = this.A0K.A0E(); c11819sA0E != null; c11819sA0E = c11819sA0E.A01) {
            C1336Gk c1336Gk = c11819sA0E.A04;
            if (A0W[7].charAt(9) != '8') {
                throw new RuntimeException();
            }
            A0W[5] = "TmHCYSIZuHNmxK6kBnR58JopztOBcNrn";
            if (c1336Gk != null) {
                for (InterfaceC1332Gg interfaceC1332Gg : c11819sA0E.A04.A01.A01()) {
                    if (interfaceC1332Gg != null) {
                        interfaceC1332Gg.ACc(f11);
                    }
                }
            }
        }
    }

    private void A0M(int i11) throws C11669c {
        this.A02 = i11;
        if (this.A0K.A0R(i11)) {
            return;
        }
        A0j(true);
    }

    private void A0N(int i11) {
        if (this.A05.A00 != i11) {
            C11859w c11859wA02 = this.A05.A02(i11);
            if (A0W[7].charAt(9) != '8') {
                throw new RuntimeException();
            }
            A0W[2] = "kM2qExU4ybhQ7HWfawBquzR2zjX0F4jA";
            this.A05 = c11859wA02;
        }
    }

    private void A0O(int i11, boolean z11, int i12) throws C11669c {
        C11819s c11819sA0G = this.A0K.A0G();
        Y5 y11 = this.A0T[i11];
        this.A0C[i12] = y11;
        if (y11.A81() == 0) {
            AB ab2 = c11819sA0G.A04.A03[i11];
            String[] strArr = A0W;
            if (strArr[1].charAt(10) == strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            A0W[2] = "NYdCxyfB4qBB5fQElsuicf6C6huVudSr";
            Format[] formatArrA0v = A0v(c11819sA0G.A04.A01.A00(i11));
            boolean z12 = this.A08 && this.A05.A00 == 3;
            y11.A5V(ab2, formatArrA0v, c11819sA0G.A0A[i11], this.A03, !z11 && z12, c11819sA0G.A07());
            this.A0G.A09(y11);
            if (z12) {
                y11.start();
            }
        }
    }

    private void A0P(long j11) throws C11669c {
        if (this.A0K.A0P()) {
            j11 = this.A0K.A0G().A09(j11);
        }
        this.A03 = j11;
        this.A0G.A07(j11);
        for (Y5 y11 : this.A0C) {
            y11.AFN(this.A03);
        }
    }

    private void A0Q(long j11, long j12) throws C11669c {
        if (this.A0R.isEmpty() || this.A05.A04.A01()) {
            return;
        }
        if (this.A05.A02 == j11) {
            j11--;
        }
        C11859w c11859w = this.A05;
        if (A0W[2].charAt(12) == 'N') {
            throw new RuntimeException();
        }
        A0W[2] = "iI9novLuZIFAEfCO4qiE3Y1J9OFTcxg5";
        int i11 = c11859w.A04.A02;
        int i12 = this.A00;
        C11739j c11739j = i12 > 0 ? this.A0R.get(i12 - 1) : null;
        while (c11739j != null) {
            if (c11739j.A00 <= i11) {
                int i13 = c11739j.A00;
                if (A0W[7].charAt(9) == '8') {
                    A0W[2] = "hDlIvL5rLgyE5VG4VUIth4YrdDyvlxxs";
                    if (i13 != i11 || c11739j.A01 <= j11) {
                        break;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            int i14 = this.A00 - 1;
            this.A00 = i14;
            c11739j = i14 > 0 ? this.A0R.get(i14 - 1) : null;
        }
        C11739j c11739j2 = this.A00 < this.A0R.size() ? this.A0R.get(this.A00) : null;
        while (c11739j2 != null && c11739j2.A02 != null && (c11739j2.A00 < i11 || (c11739j2.A00 == i11 && c11739j2.A01 <= j11))) {
            int i15 = this.A00 + 1;
            this.A00 = i15;
            c11739j2 = i15 < this.A0R.size() ? this.A0R.get(this.A00) : null;
        }
        while (c11739j2 != null && c11739j2.A02 != null && c11739j2.A00 == i11 && c11739j2.A01 > j11 && c11739j2.A01 <= j12) {
            A0Z(c11739j2.A03);
            if (c11739j2.A03.A0B() || c11739j2.A03.A0D()) {
                this.A0R.remove(this.A00);
            } else {
                this.A00++;
            }
            if (this.A00 < this.A0R.size()) {
                ArrayList<C11739j> arrayList = this.A0R;
                int i16 = this.A00;
                if (A0W[5].charAt(1) == 'w') {
                    throw new RuntimeException();
                }
                A0W[6] = "2inRqgHKNmW90mXz8";
                c11739j2 = arrayList.get(i16);
            } else {
                c11739j2 = null;
            }
        }
    }

    private void A0R(long j11, long j12) {
        this.A0Q.AF8(2);
        this.A0Q.AFo(2, j11 + j12);
    }

    private void A0S(C11729i c11729i) throws C11669c {
        if (c11729i.A01 != this.A07) {
            return;
        }
        AH ah2 = this.A05.A03;
        AH ah3 = c11729i.A00;
        Object obj = c11729i.A02;
        this.A0K.A0N(ah3);
        this.A05 = this.A05.A03(ah3, obj);
        A0F();
        int i11 = this.A01;
        if (i11 > 0) {
            this.A0I.A03(i11);
            this.A01 = 0;
            C11759l c11759l = this.A04;
            if (c11759l != null) {
                Pair<Integer, Long> pairA04 = A04(c11759l, true);
                this.A04 = null;
                if (pairA04 == null) {
                    A08();
                    return;
                }
                int iIntValue = ((Integer) pairA04.first).intValue();
                long jLongValue = ((Long) pairA04.second).longValue();
                C1291Eo c1291EoA0L = this.A0K.A0L(iIntValue, jLongValue);
                this.A05 = this.A05.A04(c1291EoA0L, c1291EoA0L.A01() ? 0L : jLongValue, jLongValue);
                return;
            }
            if (this.A05.A02 == C.TIME_UNSET) {
                if (ah3.A0E()) {
                    A08();
                    return;
                }
                Pair<Integer, Long> pairA05 = A05(ah3, ah3.A05(this.A0B), C.TIME_UNSET);
                int iIntValue2 = ((Integer) pairA05.first).intValue();
                long jLongValue2 = ((Long) pairA05.second).longValue();
                C1291Eo c1291EoA0L2 = this.A0K.A0L(iIntValue2, jLongValue2);
                this.A05 = this.A05.A04(c1291EoA0L2, c1291EoA0L2.A01() ? 0L : jLongValue2, jLongValue2);
                return;
            }
            return;
        }
        int i12 = this.A05.A04.A02;
        long j11 = this.A05.A01;
        if (ah2.A0E()) {
            if (ah3.A0E()) {
                return;
            }
            C1291Eo c1291EoA0L3 = this.A0K.A0L(i12, j11);
            this.A05 = this.A05.A04(c1291EoA0L3, c1291EoA0L3.A01() ? 0L : j11, j11);
            return;
        }
        C11819s c11819sA0E = this.A0K.A0E();
        int iA04 = ah3.A04(c11819sA0E == null ? ah2.A0A(i12, this.A0L, true).A03 : c11819sA0E.A09);
        if (iA04 != -1) {
            if (iA04 != i12) {
                this.A05 = this.A05.A01(iA04);
            }
            C1291Eo c1291Eo = this.A05.A04;
            if (c1291Eo.A01()) {
                C1291Eo c1291EoA0L4 = this.A0K.A0L(iA04, j11);
                if (!c1291EoA0L4.equals(c1291Eo)) {
                    this.A05 = this.A05.A04(c1291EoA0L4, A02(c1291EoA0L4, c1291EoA0L4.A01() ? 0L : j11), j11);
                    return;
                }
            }
            if (this.A0K.A0U(c1291Eo, this.A03)) {
                return;
            }
            A0j(false);
            return;
        }
        int iA01 = A01(i12, ah2, ah3);
        if (A0W[2].charAt(12) == 'N') {
            throw new RuntimeException();
        }
        String[] strArr = A0W;
        strArr[4] = "W6zkXP9eIZkyJx4uPbHf9NTX6";
        strArr[3] = "m3yrwIeXeqUIkhQgLJp1WNCsrl";
        if (iA01 == -1) {
            A08();
            return;
        }
        Pair<Integer, Long> pairA06 = A05(ah3, ah3.A09(iA01, this.A0L).A00, C.TIME_UNSET);
        int iIntValue3 = ((Integer) pairA06.first).intValue();
        long jLongValue3 = ((Long) pairA06.second).longValue();
        C1291Eo c1291EoA0L5 = this.A0K.A0L(iIntValue3, jLongValue3);
        ah3.A0A(iIntValue3, this.A0L, true);
        if (c11819sA0E != null) {
            Object obj2 = this.A0L.A03;
            c11819sA0E.A02 = c11819sA0E.A02.A00(-1);
            while (c11819sA0E.A01 != null) {
                c11819sA0E = c11819sA0E.A01;
                if (c11819sA0E.A09.equals(obj2)) {
                    C11839u c11839u = this.A0K;
                    C11829t c11829t = c11819sA0E.A02;
                    if (A0W[2].charAt(12) == 'N') {
                        throw new RuntimeException();
                    }
                    A0W[5] = "ODoCru5Men7rnsumvsVlRJsOWyiHNrdt";
                    c11819sA0E.A02 = c11839u.A0J(c11829t, iIntValue3);
                } else {
                    c11819sA0E.A02 = c11819sA0E.A02.A00(-1);
                }
            }
        }
        boolean zA01 = c1291EoA0L5.A01();
        if (A0W[6].length() != 17) {
            throw new RuntimeException();
        }
        A0W[7] = "hRbRvIJE18IQkSZp4h0fxN12mLMfZDhd";
        this.A05 = this.A05.A04(c1291EoA0L5, A02(c1291EoA0L5, zA01 ? 0L : jLongValue3), jLongValue3);
    }

    private void A0T(C11759l c11759l) throws Throwable {
        long jLongValue;
        C1291Eo c1291EoA0L;
        long jLongValue2;
        boolean z11;
        this.A0I.A03(1);
        Pair<Integer, Long> pairA04 = A04(c11759l, true);
        if (pairA04 == null) {
            c1291EoA0L = new C1291Eo(A00());
            jLongValue2 = C.TIME_UNSET;
            jLongValue = C.TIME_UNSET;
            z11 = true;
        } else {
            int iIntValue = ((Integer) pairA04.first).intValue();
            jLongValue = ((Long) pairA04.second).longValue();
            c1291EoA0L = this.A0K.A0L(iIntValue, jLongValue);
            if (c1291EoA0L.A01()) {
                jLongValue2 = 0;
                z11 = true;
            } else {
                jLongValue2 = ((Long) pairA04.second).longValue();
                z11 = c11759l.A01 == C.TIME_UNSET;
            }
        }
        try {
            try {
                if (this.A07 != null && this.A01 <= 0) {
                    if (A0W[5].charAt(1) != 'w') {
                        A0W[5] = "YfoxJXVxtggAgJ3C0qUN5WGXkfVCteCk";
                        try {
                            if (jLongValue2 == C.TIME_UNSET) {
                                A0N(4);
                                A0o(false, true, false);
                            } else {
                                long jA5x = jLongValue2;
                                if (c1291EoA0L.equals(this.A05.A04)) {
                                    C11819s c11819sA0G = this.A0K.A0G();
                                    if (c11819sA0G != null && jA5x != 0) {
                                        jA5x = c11819sA0G.A08.A5x(jA5x, this.A06);
                                    }
                                    if (C9W.A01(jA5x) == C9W.A01(this.A05.A0A)) {
                                        this.A05 = this.A05.A04(c1291EoA0L, this.A05.A0A, jLongValue);
                                        if (z11) {
                                            this.A0I.A04(2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                long jA02 = A02(c1291EoA0L, jA5x);
                                z11 |= jLongValue2 != jA02;
                                if (A0W[6].length() == 17) {
                                    A0W[7] = "LtwUHLpv08wEzos7LWvR75PA6MqqEvuh";
                                    jLongValue2 = jA02;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            this.A05 = this.A05.A04(c1291EoA0L, jLongValue2, jLongValue);
                            if (z11) {
                                this.A0I.A04(2);
                            }
                            throw th;
                        }
                    }
                    throw new RuntimeException();
                }
                this.A04 = c11759l;
                this.A05 = this.A05.A04(c1291EoA0L, jLongValue2, jLongValue);
                if (z11) {
                    C11749k c11749k = this.A0I;
                    String[] strArr = A0W;
                    if (strArr[4].length() == strArr[3].length()) {
                        c11749k.A04(2);
                    } else {
                        A0W[6] = "NnvGpWmx2ly54VvtA";
                        c11749k.A04(2);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private void A0V(C11819s c11819s) throws C11669c {
        C11819s c11819sA0G = this.A0K.A0G();
        if (c11819sA0G == null || c11819s == c11819sA0G) {
            return;
        }
        int i11 = 0;
        boolean[] zArr = new boolean[this.A0T.length];
        int i12 = 0;
        while (true) {
            Y5[] y5Arr = this.A0T;
            if (i12 >= y5Arr.length) {
                this.A05 = this.A05.A05(c11819sA0G.A03, c11819sA0G.A04);
                A0p(zArr, i11);
                return;
            }
            Y5 y11 = y5Arr[i12];
            zArr[i12] = y11.A81() != 0;
            if (c11819sA0G.A04.A00(i12)) {
                i11++;
            }
            if (zArr[i12] && (!c11819sA0G.A04.A00(i12) || (y11.A8y() && y11.A84() == c11819s.A0A[i12]))) {
                A0b(y11);
            }
            i12++;
        }
    }

    private void A0W(C11869x c11869x) {
        this.A0G.AGA(c11869x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0X(A8 a11) throws C11669c {
        if (a11.A0D()) {
            return;
        }
        try {
            a11.A04().A8V(a11.A00(), a11.A09());
            a11.A0A(true);
            String[] strArr = A0W;
            if (strArr[1].charAt(10) == strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0W;
            strArr2[4] = "j7cBoz179DrNpy3qD7RptXNd9";
            strArr2[3] = "0iwSWX3dM4PAnuiRq1LulMUFPW";
        } catch (Throwable th2) {
            a11.A0A(true);
            throw th2;
        }
    }

    private void A0Y(A8 a11) throws C11669c {
        if (a11.A02() == C.TIME_UNSET) {
            A0Z(a11);
            return;
        }
        if (this.A07 == null || this.A01 > 0) {
            this.A0R.add(new C11739j(a11));
            return;
        }
        C11739j c11739j = new C11739j(a11);
        if (!A0r(c11739j)) {
            a11.A0A(false);
        } else {
            this.A0R.add(c11739j);
            Collections.sort(this.A0R);
        }
    }

    private void A0Z(A8 a11) throws C11669c {
        if (a11.A03().getLooper() != this.A0Q.A7L()) {
            this.A0Q.AAb(15, a11).sendToTarget();
            return;
        }
        A0X(a11);
        C11859w c11859w = this.A05;
        if (A0W[6].length() != 17) {
            throw new RuntimeException();
        }
        A0W[5] = "cBEQE15IFXZqMCE104UHZMDgeC8qTiqN";
        if (c11859w.A00 == 3 || this.A05.A00 == 2) {
            this.A0Q.AFn(2);
        }
    }

    private void A0a(final A8 a11) {
        a11.A03().post(new Runnable() { // from class: com.facebook.ads.redexgen.X.9h
            public static byte[] A02;

            static {
                A01();
            }

            public static String A00(int i11, int i12, int i13) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
                for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
                    bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 14);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A02 = new byte[]{-60, -9, -18, -49, -21, -32, -8, -28, -15, -56, -20, -17, -21, -56, -19, -13, -28, -15, -19, -32, -21, -52, -27, -36, -17, -25, -36, -38, -21, -36, -37, -105, -36, -23, -23, -26, -23, -105, -37, -36, -29, -32, -19, -36, -23, -32, -27, -34, -105, -28, -36, -22, -22, -40, -34, -36, -105, -26, -27, -105, -36, -17, -21, -36, -23, -27, -40, -29, -105, -21, -33, -23, -36, -40, -37, -91};
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    try {
                        this.A00.A0X(a11);
                    } catch (C11669c e11) {
                        Log.e(A00(0, 21, 113), A00(21, 55, 105), e11);
                        throw new RuntimeException(e11);
                    }
                } catch (Throwable th2) {
                    KL.A00(th2, this);
                }
            }
        });
    }

    private void A0b(Y5 y11) throws C11669c {
        this.A0G.A08(y11);
        A0c(y11);
        y11.A58();
    }

    private void A0c(Y5 y11) throws C11669c {
        if (y11.A81() == 2) {
            y11.stop();
        }
    }

    private void A0d(AD ad2) {
        this.A06 = ad2;
    }

    private void A0e(WP wp2) {
        if (this.A0K.A0T(wp2)) {
            this.A0K.A0M(this.A03);
            A09();
        }
    }

    private void A0f(WP wp2) throws C11669c {
        if (this.A0K.A0T(wp2)) {
            C11819s c11819sA0F = this.A0K.A0F();
            c11819sA0F.A0E(this.A0G.A7h().A01);
            A0i(c11819sA0F.A03, c11819sA0F.A04);
            if (!this.A0K.A0P()) {
                A0P(this.A0K.A0C().A02.A03);
                A0V(null);
            }
            A09();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.FC
    /* JADX INFO: renamed from: A0g, reason: merged with bridge method [inline-methods] */
    public final void ABC(WP wp2) {
        this.A0Q.AAb(10, wp2).sendToTarget();
    }

    private void A0h(InterfaceC1293Eq interfaceC1293Eq, boolean z11, boolean z12) {
        this.A01++;
        A0o(true, z11, z12);
        this.A0J.onPrepared();
        this.A07 = interfaceC1293Eq;
        A0N(2);
        interfaceC1293Eq.AE7(this.A0H, true, this);
        this.A0Q.AFn(2);
    }

    private void A0i(TrackGroupArray trackGroupArray, C1336Gk c1336Gk) {
        this.A0J.ADN(this.A0T, trackGroupArray, c1336Gk.A01);
    }

    private void A0j(boolean z11) throws C11669c {
        C1291Eo c1291Eo = this.A0K.A0G().A02.A04;
        long jA03 = A03(c1291Eo, this.A05.A0A, true);
        if (jA03 != this.A05.A0A) {
            C11859w c11859w = this.A05;
            this.A05 = c11859w.A04(c1291Eo, jA03, c11859w.A01);
            if (z11) {
                this.A0I.A04(4);
            }
        }
    }

    private void A0k(boolean z11) {
        if (this.A05.A08 != z11) {
            this.A05 = this.A05.A06(z11);
        }
    }

    private void A0l(boolean z11) throws C11669c {
        this.A09 = false;
        this.A08 = z11;
        if (!z11) {
            A0H();
            A0J();
        } else if (this.A05.A00 == 3) {
            A0G();
            this.A0Q.AFn(2);
        } else if (this.A05.A00 == 2) {
            this.A0Q.AFn(2);
        }
    }

    private void A0m(boolean z11) throws C11669c {
        this.A0B = z11;
        if (this.A0K.A0V(z11)) {
            return;
        }
        A0j(true);
    }

    private void A0n(boolean z11, boolean z12) {
        A0o(true, z11, z11);
        this.A0I.A03(this.A01 + (z12 ? 1 : 0));
        this.A01 = 0;
        this.A0J.ADF();
        A0N(1);
    }

    private void A0o(boolean z11, boolean z12, boolean z13) {
        InterfaceC1293Eq interfaceC1293Eq;
        this.A0Q.AF8(2);
        this.A09 = false;
        this.A0G.A06();
        this.A03 = 0L;
        for (Y5 y11 : this.A0C) {
            try {
                A0b(y11);
            } catch (C11669c | RuntimeException e11) {
                Log.e(A06(0, 21, 43), A06(TsExtractor.TS_STREAM_TYPE_DTS, 12, 49), e11);
            }
        }
        this.A0C = new Y5[0];
        this.A0K.A0O(!z12);
        A0k(false);
        if (z12) {
            this.A04 = null;
        }
        if (z13) {
            this.A0K.A0N(AH.A01);
            Iterator<C11739j> it = this.A0R.iterator();
            while (it.hasNext()) {
                it.next().A03.A0A(false);
            }
            this.A0R.clear();
            this.A00 = 0;
        }
        AH ah2 = z13 ? AH.A01 : this.A05.A03;
        Object obj = z13 ? null : this.A05.A07;
        C1291Eo c1291Eo = z12 ? new C1291Eo(A00()) : this.A05.A04;
        long j11 = C.TIME_UNSET;
        long j12 = z12 ? -9223372036854775807L : this.A05.A0A;
        if (!z12) {
            j11 = this.A05.A01;
        }
        this.A05 = new C11859w(ah2, obj, c1291Eo, j12, j11, this.A05.A00, false, z13 ? TrackGroupArray.A04 : this.A05.A05, z13 ? this.A0O : this.A05.A06);
        if (!z11 || (interfaceC1293Eq = this.A07) == null) {
            return;
        }
        interfaceC1293Eq.AEb(this);
        this.A07 = null;
    }

    private void A0p(boolean[] zArr, int i11) throws C11669c {
        this.A0C = new Y5[i11];
        int i12 = 0;
        C11819s c11819sA0G = this.A0K.A0G();
        for (int i13 = 0; i13 < this.A0T.length; i13++) {
            if (c11819sA0G.A04.A00(i13)) {
                A0O(i13, zArr[i13], i12);
                i12++;
            }
        }
    }

    private boolean A0q() {
        C11819s c11819sA0G = this.A0K.A0G();
        long j11 = c11819sA0G.A02.A01;
        if (j11 != C.TIME_UNSET && this.A05.A0A >= j11) {
            C11819s c11819s = c11819sA0G.A01;
            if (A0W[7].charAt(9) != '8') {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[1] = "YaIhV2LltIG4HuclCS5WOO9hjwkCXeMt";
            strArr[0] = "X0pypN8zwLPsNLuJVHuHfetSc0yM8k9B";
            if (c11819s == null || (!c11819sA0G.A01.A06 && !c11819sA0G.A01.A02.A04.A01())) {
                return false;
            }
        }
        return true;
    }

    private boolean A0r(C11739j c11739j) {
        if (c11739j.A02 == null) {
            Pair<Integer, Long> pairA04 = A04(new C11759l(c11739j.A03.A08(), c11739j.A03.A01(), C9W.A00(c11739j.A03.A02())), false);
            if (pairA04 == null) {
                return false;
            }
            int iIntValue = ((Integer) pairA04.first).intValue();
            long jLongValue = ((Long) pairA04.second).longValue();
            AH ah2 = this.A05.A03;
            Integer num = (Integer) pairA04.first;
            String[] strArr = A0W;
            if (strArr[1].charAt(10) == strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            A0W[6] = "Qe4SjxIsSBa3x6HAW";
            c11739j.A01(iIntValue, jLongValue, ah2.A0A(num.intValue(), this.A0L, true).A03);
        } else {
            int iA04 = this.A05.A03.A04(c11739j.A02);
            if (iA04 == -1) {
                return false;
            }
            c11739j.A00 = iA04;
        }
        return true;
    }

    private boolean A0s(Y5 y11) {
        C11819s c11819sA0H = this.A0K.A0H();
        return c11819sA0H.A01 != null && c11819sA0H.A01.A06 && y11.A8a();
    }

    private boolean A0t(C1291Eo c1291Eo, long j11, C11819s c11819s) {
        if (!c1291Eo.equals(c11819s.A02.A04) || !c11819s.A06) {
            return false;
        }
        this.A05.A03.A09(c11819s.A02.A04.A02, this.A0L);
        int iA04 = this.A0L.A04(j11);
        return iA04 == -1 || this.A0L.A09(iA04) == c11819s.A02.A02;
    }

    private boolean A0u(boolean z11) {
        if (this.A0C.length == 0) {
            return A0q();
        }
        if (!z11) {
            return false;
        }
        if (!this.A05.A08) {
            return true;
        }
        C11819s c11819sA0F = this.A0K.A0F();
        long jA0C = c11819sA0F.A0C(!c11819sA0F.A02.A05);
        return jA0C == Long.MIN_VALUE || this.A0J.AGL(jA0C - c11819sA0F.A08(this.A03), this.A0G.A7h().A01, this.A09);
    }

    public static Format[] A0v(InterfaceC1332Gg interfaceC1332Gg) {
        int length = interfaceC1332Gg != null ? interfaceC1332Gg.length() : 0;
        Format[] formatArr = new Format[length];
        String[] strArr = A0W;
        if (strArr[1].charAt(10) == strArr[0].charAt(10)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0W;
        strArr2[4] = "X04sVE4WijYjotgv6w3bASzS6";
        strArr2[3] = "U1jCIvxI6fY8JZE6Ili1DHAvIg";
        for (int i11 = 0; i11 < length; i11++) {
            formatArr[i11] = interfaceC1332Gg.A76(i11);
        }
        return formatArr;
    }

    public final Looper A0w() {
        return this.A0F.getLooper();
    }

    public final synchronized void A0x() {
        if (this.A0A) {
            return;
        }
        this.A0Q.AFn(7);
        boolean z11 = false;
        while (!this.A0A) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z11 = true;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    public final void A0y(AH ah2, int i11, long j11) {
        this.A0Q.AAb(3, new C11759l(ah2, i11, j11)).sendToTarget();
    }

    public final void A0z(InterfaceC1293Eq interfaceC1293Eq, boolean z11, boolean z12) {
        this.A0Q.AAa(0, z11 ? 1 : 0, z12 ? 1 : 0, interfaceC1293Eq).sendToTarget();
    }

    public final void A10(boolean z11) {
        this.A0Q.AAZ(1, z11 ? 1 : 0, 0).sendToTarget();
    }

    public final void A11(boolean z11) {
        this.A0Q.AAZ(6, z11 ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.uinode.C9Z
    public final void ACb(C11869x c11869x) {
        this.A0E.obtainMessage(1, c11869x).sendToTarget();
        A0L(c11869x.A01);
    }

    @Override // com.facebook.ads.redexgen.uinode.WQ
    public final void ACj(WP wp2) {
        this.A0Q.AAb(9, wp2).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1292Ep
    public final void ADA(InterfaceC1293Eq interfaceC1293Eq, AH ah2, Object obj) {
        this.A0Q.AAb(8, new C11729i(interfaceC1293Eq, ah2, obj)).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.uinode.A6
    public final synchronized void AFp(A8 a11) {
        if (!this.A0A) {
            this.A0Q.AAb(14, a11).sendToTarget();
        } else {
            Log.w(A06(0, 21, 43), A06(50, 37, 33));
            a11.A0A(false);
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        String strA06 = A06(0, 21, 43);
        try {
            switch (message.what) {
                case 0:
                    A0h((InterfaceC1293Eq) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    A0l(message.arg1 != 0);
                    break;
                case 2:
                    A07();
                    break;
                case 3:
                    A0T((C11759l) message.obj);
                    break;
                case 4:
                    A0W((C11869x) message.obj);
                    break;
                case 5:
                    A0d((AD) message.obj);
                    break;
                case 6:
                    A0n(message.arg1 != 0, true);
                    break;
                case 7:
                    A0D();
                    return true;
                case 8:
                    A0S((C11729i) message.obj);
                    break;
                case 9:
                    A0f((WP) message.obj);
                    break;
                case 10:
                    A0e((WP) message.obj);
                    break;
                case 11:
                    A0E();
                    break;
                case 12:
                    A0M(message.arg1);
                    break;
                case 13:
                    A0m(message.arg1 != 0);
                    break;
                case 14:
                    A0Y((A8) message.obj);
                    break;
                case 15:
                    A0a((A8) message.obj);
                    break;
                default:
                    return false;
            }
            A0A();
        } catch (C11669c e11) {
            Log.e(strA06, A06(Worker.WHAT_QUIT, 15, 98), e11);
            A0n(false, false);
            this.A0E.obtainMessage(2, e11).sendToTarget();
            A0A();
        } catch (IOException e12) {
            Log.e(strA06, A06(125, 13, 51), e12);
            A0n(false, false);
            this.A0E.obtainMessage(2, C11669c.A00(e12)).sendToTarget();
            A0A();
        } catch (RuntimeException e13) {
            Log.e(strA06, A06(87, 23, 38), e13);
            A0n(false, false);
            this.A0E.obtainMessage(2, C11669c.A02(e13)).sendToTarget();
            A0A();
        }
        return true;
    }
}
