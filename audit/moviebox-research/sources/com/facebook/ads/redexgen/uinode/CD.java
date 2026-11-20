package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.os.Handler;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CD implements WP, InterfaceC1235Bu, H6<WT>, H9, FA {
    public static byte[] A0c;
    public static String[] A0d = {"uM3", "HhtEoeszujhq2hqW803X6wAUFNr2yIvk", "llgRlYE2HHrDKVr9Tlv1gg4sawaKL", "gd26Zevc0BeMQVnsPvgEWj4kMHitbDqE", "B56DgxYfwXnRdFUWoxgY8ZwWxUmrPQlR", "o6X9hbG4Io42IRbcZylLcsRNIhbJFPRA", "SBfu1SOz9uKNnyoy8", "5PtJb97AhuhjIJJCziWFyl83Esr9CMYA"};
    public int A00;
    public int A01;
    public int A02;
    public long A04;
    public C1 A07;
    public WQ A08;
    public TrackGroupArray A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean[] A0L;
    public boolean[] A0M;
    public boolean[] A0N;
    public final int A0O;
    public final long A0P;
    public final Uri A0Q;
    public final C1287Ek A0S;
    public final InterfaceC1288El A0T;
    public final F1 A0U;
    public final InterfaceC1338Gm A0V;
    public final InterfaceC1346Gu A0W;
    public final String A0b;
    public final C1723Vq A0X = new C1723Vq(A07(0, 27, 27));
    public final C1357Hg A0Y = new C1357Hg();
    public final Runnable A0Z = new RunnableC1285Ei(this);
    public final Runnable A0a = new RunnableC1286Ej(this);
    public final Handler A0R = new Handler();
    public int[] A0J = new int[0];
    public WO[] A0K = new WO[0];
    public long A06 = C.TIME_UNSET;
    public long A05 = -1;
    public long A03 = C.TIME_UNSET;

    static {
        A0B();
    }

    public CD(Uri uri, InterfaceC1346Gu interfaceC1346Gu, InterfaceC1233Bs[] interfaceC1233BsArr, int i11, F1 f11, InterfaceC1288El interfaceC1288El, InterfaceC1338Gm interfaceC1338Gm, String str, int i12) {
        this.A0Q = uri;
        this.A0W = interfaceC1346Gu;
        this.A0O = i11;
        this.A0U = f11;
        this.A0T = interfaceC1288El;
        this.A0V = interfaceC1338Gm;
        this.A0b = str;
        this.A0P = i12;
        this.A0S = new C1287Ek(interfaceC1233BsArr, this);
        this.A00 = i11 == -1 ? 3 : i11;
        f11.A03();
    }

    private int A00() {
        int iA0C = 0;
        for (WO wo2 : this.A0K) {
            iA0C += wo2.A0C();
        }
        return iA0C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.H6
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final int AC2(WT wt2, long j11, long j12, IOException iOException) {
        boolean zA0N = A0N(iOException);
        this.A0U.A0H(wt2.A03, 1, -1, null, 0, null, wt2.A02, this.A03, j11, j12, wt2.A00, iOException, zA0N);
        A0E(wt2);
        if (zA0N) {
            return 3;
        }
        int iA00 = A00();
        boolean z11 = iA00 > this.A02;
        if (A0L(wt2, iA00)) {
            return z11 ? 1 : 0;
        }
        return 2;
    }

    private long A02() {
        long jMax = Long.MIN_VALUE;
        for (WO wo2 : this.A0K) {
            jMax = Math.max(jMax, wo2.A0F());
        }
        return jMax;
    }

    public static String A07(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0c, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 25);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        if (this.A0G || this.A0F || this.A07 == null || !this.A0H) {
            return;
        }
        for (WO wo2 : this.A0K) {
            if (wo2.A0G() == null) {
                return;
            }
        }
        this.A0Y.A01();
        int length = this.A0K.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        this.A0N = new boolean[length];
        this.A0L = new boolean[length];
        this.A0M = new boolean[length];
        this.A03 = this.A07.A6r();
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= length) {
                break;
            }
            Format formatA0G = this.A0K[i11].A0G();
            trackGroupArr[i11] = new TrackGroup(formatA0G);
            String str = formatA0G.A0O;
            if (!AbstractC1369Hs.A0B(str) && !AbstractC1369Hs.A09(str)) {
                z11 = false;
            }
            this.A0N[i11] = z11;
            this.A0A |= z11;
            i11++;
        }
        this.A09 = new TrackGroupArray(trackGroupArr);
        if (this.A0O == -1 && this.A05 == -1 && this.A07.A6r() == C.TIME_UNSET) {
            String[] strArr = A0d;
            if (strArr[4].charAt(19) == strArr[5].charAt(19)) {
                throw new RuntimeException();
            }
            A0d[2] = "7a3gC0RfnKvRSexgB6r2d4KLSEZ";
            this.A00 = 6;
        }
        this.A0F = true;
        this.A0T.AD9(this.A03, this.A07.A9I());
        this.A08.ACj(this);
    }

    private void A0A() {
        WT wt2 = new WT(this, this.A0Q, this.A0W, this.A0S, this.A0Y);
        if (this.A0F) {
            AbstractC1351Ha.A04(A0I());
            long j11 = this.A03;
            if (j11 != C.TIME_UNSET && this.A06 >= j11) {
                this.A0B = true;
                this.A06 = C.TIME_UNSET;
                return;
            } else {
                wt2.A04(this.A07.A7t(this.A06).A00.A00, this.A06);
                this.A06 = C.TIME_UNSET;
            }
        }
        this.A02 = A00();
        this.A0U.A0E(wt2.A03, 1, -1, null, 0, null, wt2.A02, this.A03, this.A0X.A04(wt2, this, this.A00));
    }

    public static void A0B() {
        A0c = new byte[]{78, 109, 99, 102, 103, 112, 56, 71, 122, 118, 112, 99, 97, 118, 109, 112, 79, 103, 102, 107, 99, 82, 103, 112, 107, 109, 102};
    }

    private void A0C(int i11) {
        if (this.A0M[i11]) {
            return;
        }
        Format formatA01 = this.A09.A01(i11).A01(0);
        this.A0U.A06(AbstractC1369Hs.A01(formatA01.A0O), formatA01, 0, null, this.A04);
        boolean[] zArr = this.A0M;
        if (A0d[2].length() == 31) {
            throw new RuntimeException();
        }
        A0d[2] = "eh27oOHcwVOmHzYfi8kDTS";
        zArr[i11] = true;
    }

    private void A0D(int i11) {
        if (this.A0E && this.A0N[i11] && !this.A0K[i11].A0M()) {
            String[] strArr = A0d;
            if (strArr[7].charAt(26) != strArr[1].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0d;
            strArr2[6] = "sgNFiq5UDquEcD4Be";
            strArr2[0] = "0a9";
            this.A06 = 0L;
            this.A0E = false;
            this.A0D = true;
            this.A04 = 0L;
            this.A02 = 0;
            for (WO wo2 : this.A0K) {
                wo2.A0I();
            }
            this.A08.ABC(this);
        }
    }

    private void A0E(WT wt2) {
        if (this.A05 == -1) {
            this.A05 = wt2.A01;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.H6
    /* JADX INFO: renamed from: A0F, reason: merged with bridge method [inline-methods] */
    public final void AC1(WT wt2, long j11, long j12) {
        if (this.A03 == C.TIME_UNSET) {
            long jA02 = A02();
            long j13 = jA02 == Long.MIN_VALUE ? 0L : 10000 + jA02;
            this.A03 = j13;
            this.A0T.AD9(j13, this.A07.A9I());
        }
        this.A0U.A0G(wt2.A03, 1, -1, null, 0, null, wt2.A02, this.A03, j11, j12, wt2.A00);
        A0E(wt2);
        this.A0B = true;
        this.A08.ABC(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.H6
    /* JADX INFO: renamed from: A0G, reason: merged with bridge method [inline-methods] */
    public final void ABz(WT wt2, long j11, long j12, boolean z11) {
        this.A0U.A0F(wt2.A03, 1, -1, null, 0, null, wt2.A02, this.A03, j11, j12, wt2.A00);
        if (z11) {
            return;
        }
        A0E(wt2);
        for (WO wo2 : this.A0K) {
            wo2.A0I();
        }
        if (this.A01 > 0) {
            this.A08.ABC(this);
        }
    }

    private boolean A0I() {
        return this.A06 != C.TIME_UNSET;
    }

    private boolean A0J() {
        return this.A0D || A0I();
    }

    private boolean A0K(long j11) {
        int length = this.A0K.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                return true;
            }
            WO wo2 = this.A0K[i11];
            wo2.A0J();
            if (!(wo2.A0D(j11, true, false) != -1)) {
                if (!this.A0N[i11]) {
                    boolean z11 = this.A0A;
                    String[] strArr = A0d;
                    if (strArr[4].charAt(19) == strArr[5].charAt(19)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0d;
                    strArr2[7] = "iCn5X7g6PoYVWCe4GwpQYWYt9drfTGBT";
                    strArr2[1] = "IDd3eJ2NBG0wgz78gdspZyWtrcrofueQ";
                    if (!z11) {
                    }
                }
                return false;
            }
            i11++;
        }
    }

    private boolean A0L(WT wt2, int i11) {
        C1 c11;
        if (this.A05 != -1 || ((c11 = this.A07) != null && c11.A6r() != C.TIME_UNSET)) {
            this.A02 = i11;
            if (A0d[2].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0d;
            strArr[6] = "F1SGTXFlfQdsRtCv2";
            strArr[0] = "c29";
            return true;
        }
        if (this.A0F && !A0J()) {
            this.A0E = true;
            return false;
        }
        this.A0D = this.A0F;
        this.A04 = 0L;
        this.A02 = 0;
        for (WO wo2 : this.A0K) {
            wo2.A0I();
        }
        wt2.A04(0L, 0L);
        return true;
    }

    public static boolean A0N(IOException iOException) {
        return iOException instanceof WM;
    }

    public final int A0O(int i11, long j11) {
        int iA0D;
        if (A0J()) {
            return 0;
        }
        WO wo2 = this.A0K[i11];
        if (!this.A0B || j11 <= wo2.A0F()) {
            iA0D = wo2.A0D(j11, true, true);
            String[] strArr = A0d;
            if (strArr[4].charAt(19) == strArr[5].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0d;
            strArr2[6] = "NIYG9FQCzFZSe10IE";
            strArr2[0] = "6cN";
            if (iA0D == -1) {
                iA0D = 0;
            }
        } else {
            iA0D = wo2.A0A();
        }
        if (iA0D > 0) {
            A0C(i11);
        } else {
            A0D(i11);
        }
        return iA0D;
    }

    public final int A0P(int i11, C11789p c11789p, C1773Xr c1773Xr, boolean z11) {
        if (A0J()) {
            return -3;
        }
        int iA0E = this.A0K[i11].A0E(c11789p, c1773Xr, z11, this.A0B, this.A04);
        if (iA0E == -4) {
            A0C(i11);
        } else if (iA0E == -3) {
            A0D(i11);
        }
        return iA0E;
    }

    public final void A0Q() throws IOException {
        this.A0X.A06(this.A00);
    }

    public final void A0R() {
        if (this.A0F) {
            for (WO wo2 : this.A0K) {
                wo2.A0H();
            }
        }
        this.A0X.A07(this);
        this.A0R.removeCallbacksAndMessages(null);
        this.A08 = null;
        this.A0G = true;
        this.A0U.A04();
    }

    public final boolean A0S(int i11) {
        return !A0J() && (this.A0B || this.A0K[i11].A0M());
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final boolean A4T(long j11) {
        if (this.A0B || this.A0E) {
            return false;
        }
        if (this.A0F && this.A01 == 0) {
            return false;
        }
        boolean zA02 = this.A0Y.A02();
        if (this.A0X.A08()) {
            return zA02;
        }
        A0A();
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final void A5A(long j11, boolean z11) {
        int length = this.A0K.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.A0K[i11].A0K(j11, z11, this.A0L[i11]);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1235Bu
    public final void A5Y() {
        this.A0H = true;
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long A5x(long j11, AD ad2) {
        if (!this.A07.A9I()) {
            return 0L;
        }
        C0 c0A7t = this.A07.A7t(j11);
        return IF.A0I(j11, ad2, c0A7t.A00.A01, c0A7t.A01.A01);
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long A6D() {
        long jA02;
        if (this.A0B) {
            return Long.MIN_VALUE;
        }
        if (A0I()) {
            long j11 = this.A06;
            String[] strArr = A0d;
            if (strArr[7].charAt(26) != strArr[1].charAt(26)) {
                throw new RuntimeException();
            }
            A0d[3] = "ld4wWqv9tK9nTvU7QEEl8vpde5wWqGSi";
            return j11;
        }
        if (this.A0A) {
            jA02 = Long.MAX_VALUE;
            int length = this.A0K.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (this.A0N[i11]) {
                    jA02 = Math.min(jA02, this.A0K[i11].A0F());
                }
            }
        } else {
            jA02 = A02();
        }
        return jA02 == Long.MIN_VALUE ? this.A04 : jA02;
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long A7U() {
        if (this.A01 == 0) {
            return Long.MIN_VALUE;
        }
        return A6D();
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final TrackGroupArray A8B() {
        return this.A09;
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final void AAN() throws IOException {
        A0Q();
    }

    @Override // com.facebook.ads.redexgen.uinode.H9
    public final void AC6() {
        for (WO wo2 : this.A0K) {
            wo2.A0I();
        }
        this.A0S.A03();
    }

    @Override // com.facebook.ads.redexgen.uinode.FA
    public final void ADS(Format format) {
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final void AE4(WQ wq2, long j11) {
        this.A08 = wq2;
        this.A0Y.A02();
        A0A();
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long AEL() {
        if (!this.A0C) {
            this.A0U.A05();
            this.A0C = true;
        }
        boolean z11 = this.A0D;
        String[] strArr = A0d;
        if (strArr[6].length() != strArr[0].length()) {
            A0d[2] = "";
            if (z11 && (this.A0B || A00() > this.A02)) {
                this.A0D = false;
                return this.A04;
            }
            String[] strArr2 = A0d;
            if (strArr2[7].charAt(26) == strArr2[1].charAt(26)) {
                String[] strArr3 = A0d;
                strArr3[4] = "a8TiTKBNhx8jXxPRrcAgh1BUcIw96G2f";
                strArr3[5] = "NHpS1UqcJuZi4hHtySMRiLK65X8yfSYb";
                return C.TIME_UNSET;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final void AER(long j11) {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1235Bu
    public final void AFi(C1 c11) {
        this.A07 = c11;
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long AFl(long j11) {
        if (!this.A07.A9I()) {
            j11 = 0;
        }
        this.A04 = j11;
        this.A0D = false;
        if (!A0I()) {
            boolean zA0K = A0K(j11);
            String[] strArr = A0d;
            if (strArr[4].charAt(19) == strArr[5].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0d;
            strArr2[4] = "4t4h1X84Q9aXzP6i3O1IFqP61fZwJyic";
            strArr2[5] = "YchhDxV7HDCpyjRy2lVbypcIuIxdt4SR";
            if (zA0K) {
                return j11;
            }
        }
        this.A0E = false;
        this.A06 = j11;
        this.A0B = false;
        if (this.A0X.A08()) {
            this.A0X.A05();
        } else {
            for (WO wo2 : this.A0K) {
                wo2.A0I();
            }
        }
        return j11;
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long AFm(InterfaceC1332Gg[] interfaceC1332GgArr, boolean[] zArr, FB[] fbArr, boolean[] zArr2, long j11) {
        AbstractC1351Ha.A04(this.A0F);
        int i11 = this.A01;
        int i12 = 0;
        while (true) {
            int i13 = 0;
            if (i12 >= interfaceC1332GgArr.length) {
                boolean z11 = !this.A0I ? j11 == 0 : i11 != 0;
                for (int i14 = 0; i14 < interfaceC1332GgArr.length; i14++) {
                    if (fbArr[i14] == null && interfaceC1332GgArr[i14] != null) {
                        InterfaceC1332Gg interfaceC1332Gg = interfaceC1332GgArr[i14];
                        AbstractC1351Ha.A04(interfaceC1332Gg.length() == 1);
                        AbstractC1351Ha.A04(interfaceC1332Gg.A7C(0) == 0);
                        int iA00 = this.A09.A00(interfaceC1332Gg.A8A());
                        AbstractC1351Ha.A04(!this.A0L[iA00]);
                        this.A01++;
                        this.A0L[iA00] = true;
                        fbArr[i14] = new WS(this, iA00);
                        zArr2[i14] = true;
                        if (!z11) {
                            WO wo2 = this.A0K[iA00];
                            wo2.A0J();
                            z11 = wo2.A0D(j11, true, true) == -1 && wo2.A0B() != 0;
                        }
                    }
                }
                if (this.A01 == 0) {
                    this.A0E = false;
                    this.A0D = false;
                    if (this.A0X.A08()) {
                        WO[] woArr = this.A0K;
                        int length = woArr.length;
                        while (i13 < length) {
                            woArr[i13].A0H();
                            i13++;
                        }
                        this.A0X.A05();
                    } else {
                        WO[] woArr2 = this.A0K;
                        int length2 = woArr2.length;
                        while (i13 < length2) {
                            woArr2[i13].A0I();
                            i13++;
                        }
                    }
                } else if (z11) {
                    j11 = AFl(j11);
                    for (int i15 = 0; i15 < fbArr.length; i15++) {
                        if (fbArr[i15] != null) {
                            zArr2[i15] = true;
                        }
                    }
                }
                this.A0I = true;
                return j11;
            }
            FB fb2 = fbArr[i12];
            String[] strArr = A0d;
            if (strArr[4].charAt(19) == strArr[5].charAt(19)) {
                throw new RuntimeException();
            }
            A0d[2] = "mg4ta7ka0nUwB4FGZ9fOP";
            if (fb2 != null && (interfaceC1332GgArr[i12] == null || !zArr[i12])) {
                int i16 = ((WS) fbArr[i12]).A00;
                AbstractC1351Ha.A04(this.A0L[i16]);
                this.A01--;
                this.A0L[i16] = false;
                fbArr[i12] = null;
            }
            i12++;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1235Bu
    public final C4 AGi(int i11, int i12) {
        int length = this.A0K.length;
        for (int i13 = 0; i13 < length; i13++) {
            if (this.A0J[i13] == i11) {
                return this.A0K[i13];
            }
        }
        WO wo2 = new WO(this.A0V);
        wo2.A0L(this);
        int[] iArrCopyOf = Arrays.copyOf(this.A0J, length + 1);
        this.A0J = iArrCopyOf;
        iArrCopyOf[length] = i11;
        WO[] woArr = (WO[]) Arrays.copyOf(this.A0K, length + 1);
        this.A0K = woArr;
        woArr[length] = wo2;
        return wo2;
    }
}
