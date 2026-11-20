package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y9 implements InterfaceC11809r {
    public static byte[] A0A;
    public static String[] A0B = {"QBw2naITCC87BBmeZEHB", "QG9qcoN67OZ9HCiBeCwQ37yZ8k9VzRIx", "huClURZcVSvs210svchTpygB", "SPjUxwmyMxCkovVHB3ukUPObWP0MyL9L", "Qo3gDbJmZiOUOvD4YrLGADsp8gVNY68y", "aCbITSFANaeoynFt6tlPTZT3Ud0BkJzi", "LC42BZreN0Trrj0tndAjNl8pur2kDdxK", "yIqlj0SUGgDzqSotNJk32MbE6gj6YGfF"};
    public int A00;
    public boolean A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final W2 A07;
    public final I3 A08;
    public final boolean A09;

    static {
        A02();
    }

    public Y9() {
        this(new W2(true, 65536));
    }

    @Deprecated
    public Y9(W2 w11) {
        this(w11, DefaultLoadControl.DEFAULT_MIN_BUFFER_MS, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 5000, -1, true);
    }

    @Deprecated
    public Y9(W2 w11, int i11, int i12, int i13, int i14, int i15, boolean z11) {
        this(w11, i11, i12, i13, i14, i15, z11, null);
    }

    @Deprecated
    public Y9(W2 w11, int i11, int i12, int i13, int i14, int i15, boolean z11, I3 i16) {
        String strA01 = A01(54, 19, 78);
        String strA02 = A01(21, 1, 70);
        A03(i13, 0, strA01, strA02);
        String strA03 = A01(22, 32, 48);
        A03(i14, 0, strA03, strA02);
        String strA04 = A01(84, 11, 0);
        A03(i11, i13, strA04, strA01);
        A03(i11, i14, strA04, strA03);
        A03(i12, i11, A01(73, 11, 89), strA04);
        this.A07 = w11;
        this.A06 = ((long) i11) * 1000;
        this.A05 = ((long) i12) * 1000;
        this.A04 = ((long) i13) * 1000;
        this.A03 = ((long) i14) * 1000;
        this.A02 = i15;
        this.A09 = z11;
        this.A08 = i16;
    }

    private final int A00(Y5[] y5Arr, C1333Gh c1333Gh) {
        int iA01 = 0;
        for (int i11 = 0; i11 < y5Arr.length; i11++) {
            if (c1333Gh.A00(i11) != null) {
                iA01 += IF.A01(y5Arr[i11].A8C());
            }
        }
        return iA01;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{-97, -30, -32, -19, -19, -18, -13, -97, -31, -28, -97, -21, -28, -14, -14, -97, -13, -25, -32, -19, -97, -55, -27, -8, -23, -23, -24, -11, -55, -14, -11, -45, -17, -28, -4, -27, -28, -26, -18, -60, -23, -9, -24, -11, -43, -24, -27, -8, -23, -23, -24, -11, -48, -10, 3, Ascii.SYN, 7, 7, 6, 19, -25, Ascii.DLE, 19, -15, Ascii.CR, 2, Ascii.SUB, 3, 2, 4, Ascii.FF, -18, Ascii.DC4, Ascii.EM, Ascii.CR, 36, -18, 33, Ascii.DC2, Ascii.DC2, 17, Ascii.RS, -7, Ascii.US, -64, -68, -63, -107, -56, -71, -71, -72, -59, -96, -58};
    }

    public static void A03(int i11, int i12, String str, String str2) {
        AbstractC1351Ha.A05(i11 >= i12, str + A01(0, 21, 44) + str2);
    }

    private void A04(boolean z11) {
        this.A00 = 0;
        I3 i11 = this.A08;
        if (i11 != null && this.A01) {
            i11.A03(0);
        }
        this.A01 = false;
        if (z11) {
            this.A07.A03();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11809r
    public final W2 A60() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11809r
    public final long A65() {
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11809r
    public final void ACr() {
        A04(true);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11809r
    public final void ADF() {
        A04(true);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11809r
    public final void ADN(Y5[] y5Arr, TrackGroupArray trackGroupArray, C1333Gh c1333Gh) {
        int iA00 = this.A02;
        if (iA00 == -1) {
            iA00 = A00(y5Arr, c1333Gh);
        }
        this.A00 = iA00;
        this.A07.A04(iA00);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11809r
    public final boolean AFO() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11809r
    public final boolean AGI(long j11, float f11) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = this.A07.A02() >= this.A00;
        boolean z14 = this.A01;
        long jMin = this.A06;
        if (f11 > 1.0f) {
            jMin = Math.min(IF.A0C(jMin, f11), this.A05);
        }
        if (j11 < jMin) {
            if (!this.A09 && z13) {
                z12 = false;
            }
            this.A01 = z12;
        } else if (j11 > this.A05 || z13) {
            this.A01 = false;
        }
        I3 i11 = this.A08;
        if (A0B[0].length() != 20) {
            throw new RuntimeException();
        }
        String[] strArr = A0B;
        strArr[1] = "QKQzs8A5eNnCMvZO6Czn4VC5jQwn3nPR";
        strArr[4] = "QpEe5JzrMZm1KKJ9dYBmwnmG628Fesko";
        if (i11 != null && (z11 = this.A01) != z14) {
            if (z11) {
                i11.A00(0);
            } else {
                i11.A03(0);
            }
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11809r
    public final boolean AGL(long j11, float f11, boolean z11) {
        long jA0D = IF.A0D(j11, f11);
        long j12 = z11 ? this.A03 : this.A04;
        return j12 <= 0 || jA0D >= j12 || (!this.A09 && this.A07.A02() >= this.A00);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11809r
    public final void onPrepared() {
        A04(false);
    }
}
