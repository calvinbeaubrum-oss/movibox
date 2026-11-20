package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.55, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass55 implements Runnable {
    public static byte[] A07;
    public static String[] A08 = {"c4xSVVt4fNiIZ9aJ0ftrOCVpKy2EJW", "bj77oS7wYHzhrY124YppwtIfPTuDoAHL", "mRmZUQV2DMpprRsDQaH8Mtbq5JuQtR14", "UXM5", "qfxFRQLCBxpF20va4RNO9ygLlTXV5cTV", "Bw29gSSAA0erG37CQVEqOkFPeCj6ZZr8", "KVIri1u0fbW7r5jnncTGzAnirlJcKx", "TA0EOfT3Z02jNldii3VIEnkki3"};
    public OverScroller A01;
    public int A02;
    public int A03;
    public final /* synthetic */ C1278Eb A06;
    public Interpolator A00 = C1278Eb.A1A;
    public boolean A04 = false;
    public boolean A05 = false;

    static {
        A03();
    }

    public AnonymousClass55(C1278Eb c1278Eb) {
        this.A06 = c1278Eb;
        this.A01 = new OverScroller(c1278Eb.getContext(), C1278Eb.A1A);
    }

    private float A00(float f11) {
        return (float) Math.sin((f11 - 0.5f) * 0.47123894f);
    }

    private int A01(int i11, int i12, int i13, int i14) {
        int iRound;
        int iAbs = Math.abs(i11);
        int iAbs2 = Math.abs(i12);
        boolean z11 = iAbs > iAbs2;
        int iSqrt = (int) Math.sqrt((i13 * i13) + (i14 * i14));
        int iSqrt2 = (int) Math.sqrt((i11 * i11) + (i12 * i12));
        C1278Eb c1278Eb = this.A06;
        int width = z11 ? c1278Eb.getWidth() : c1278Eb.getHeight();
        int i15 = width / 2;
        float fA00 = i15 + (i15 * A00(Math.min(1.0f, (iSqrt2 * 1.0f) / width)));
        if (iSqrt > 0) {
            iRound = Math.round(Math.abs(fA00 / iSqrt) * 1000.0f) * 4;
        } else {
            if (!z11) {
                iAbs = iAbs2;
            }
            iRound = (int) (((iAbs / width) + 1.0f) * 300.0f);
        }
        return Math.min(iRound, 2000);
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{-46, -42, -96, -45, -29, -14, -17, -20, -20};
    }

    private final void A04() {
        this.A05 = false;
        this.A04 = true;
    }

    private final void A05() {
        this.A04 = false;
        if (this.A05) {
            A07();
        }
    }

    private final void A06(int i11, int i12, int i13, int i14) {
        A0B(i11, i12, A01(i11, i12, i13, i14));
    }

    public final void A07() {
        if (this.A04) {
            this.A05 = true;
            return;
        }
        this.A06.removeCallbacks(this);
        if (A08[4].charAt(10) == 'o') {
            throw new RuntimeException();
        }
        A08[2] = "DBTzn4opHB64KJUt1kyQdTPFEm6jko5S";
        C3T.A0D(this.A06, this);
    }

    public final void A08() {
        this.A06.removeCallbacks(this);
        this.A01.abortAnimation();
    }

    public final void A09(int i11, int i12) {
        this.A06.setScrollState(2);
        this.A03 = 0;
        this.A02 = 0;
        this.A01.fling(0, 0, i11, i12, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        A07();
    }

    public final void A0A(int i11, int i12) {
        A06(i11, i12, 0, 0);
    }

    public final void A0B(int i11, int i12, int i13) {
        A0C(i11, i12, i13, C1278Eb.A1A);
    }

    public final void A0C(int i11, int i12, int i13, Interpolator interpolator) {
        if (this.A00 != interpolator) {
            this.A00 = interpolator;
            this.A01 = new OverScroller(this.A06.getContext(), interpolator);
        }
        this.A06.setScrollState(2);
        this.A03 = 0;
        this.A02 = 0;
        this.A01.startScroll(0, 0, i11, i12, i13);
        if (Build.VERSION.SDK_INT < 23) {
            OverScroller overScroller = this.A01;
            if (A08[7].length() != 26) {
                throw new RuntimeException();
            }
            A08[2] = "UeYo97OquvC2FnZv3LivDSVIricXCoYT";
            overScroller.computeScrollOffset();
        }
        A07();
    }

    public final void A0D(int i11, int i12, Interpolator interpolator) {
        int iA01 = A01(i11, i12, 0, 0);
        if (interpolator == null) {
            interpolator = C1278Eb.A1A;
        }
        A0C(i11, i12, iA01, interpolator);
    }

    /* JADX WARN: Code duplicated, block: B:127:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:129:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:130:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:24:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:30:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:56:0x017d  */
    @Override // java.lang.Runnable
    public final void run() {
        int iA03;
        if (this.A06.A06 != null) {
            A04();
            this.A06.A1I();
            OverScroller overScroller = this.A01;
            AnonymousClass51 anonymousClass51 = this.A06.A06.A02;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = this.A06.A16;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i11 = currX - this.A02;
                int i12 = currY - this.A03;
                int iA1d = 0;
                int iA1e = 0;
                this.A02 = currX;
                this.A03 = currY;
                int i13 = 0;
                int i14 = 0;
                if (this.A06.A1u(i11, i12, iArr, null, 1)) {
                    i11 -= iArr[0];
                    i12 -= iArr[1];
                }
                if (this.A06.A04 != null) {
                    this.A06.A1J();
                    this.A06.A1K();
                    AbstractC10122q.A01(A02(0, 9, 96));
                    C1278Eb c1278Eb = this.A06;
                    c1278Eb.A1h(c1278Eb.A0s);
                    if (i11 != 0) {
                        iA1d = this.A06.A06.A1d(i11, this.A06.A0r, this.A06.A0s);
                        i13 = i11 - iA1d;
                    }
                    if (i12 != 0) {
                        iA1e = this.A06.A06.A1e(i12, this.A06.A0r, this.A06.A0s);
                        i14 = i12 - iA1e;
                    }
                    AbstractC10122q.A00();
                    if (A08[4].charAt(10) != 'o') {
                        A08[7] = "AEnMZuqp98GVRFTkSbmwbA51QL";
                        this.A06.A1O();
                        this.A06.A1L();
                        this.A06.A1n(false);
                        if (anonymousClass51 != null) {
                            if (!anonymousClass51.A0E() && anonymousClass51.A0F()) {
                                iA03 = this.A06.A0s.A03();
                                if (iA03 == 0) {
                                    anonymousClass51.A09();
                                } else if (anonymousClass51.A07() >= iA03) {
                                    anonymousClass51.A0A(iA03 - 1);
                                    anonymousClass51.A04(i11 - i13, i12 - i14);
                                } else {
                                    anonymousClass51.A04(i11 - i13, i12 - i14);
                                }
                            }
                        }
                    } else {
                        this.A06.A1O();
                        this.A06.A1L();
                        this.A06.A1n(false);
                        if (anonymousClass51 != null) {
                            if (!anonymousClass51.A0E()) {
                                iA03 = this.A06.A0s.A03();
                                if (iA03 == 0) {
                                    anonymousClass51.A09();
                                } else if (anonymousClass51.A07() >= iA03) {
                                    anonymousClass51.A0A(iA03 - 1);
                                    anonymousClass51.A04(i11 - i13, i12 - i14);
                                } else {
                                    anonymousClass51.A04(i11 - i13, i12 - i14);
                                }
                            }
                        }
                    }
                    if (A08[4].charAt(10) == 'o') {
                        throw new RuntimeException();
                    }
                    A08[3] = "TGS8taa2nLIFayhr7f7v";
                }
                if (!this.A06.A0v.isEmpty()) {
                    this.A06.invalidate();
                }
                if (this.A06.getOverScrollMode() != 2) {
                    this.A06.A1Z(i11, i12);
                }
                if (!this.A06.A1t(iA1d, iA1e, i13, i14, null, 1) && (i13 != 0 || i14 != 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i15 = 0;
                    if (i13 != currX) {
                        if (i13 < 0) {
                            i15 = -currVelocity;
                        } else {
                            i15 = i13 > 0 ? currVelocity : 0;
                        }
                    }
                    if (i14 == currY) {
                        currVelocity = 0;
                    } else if (i14 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i14 <= 0) {
                        currVelocity = 0;
                    }
                    int overScrollMode = this.A06.getOverScrollMode();
                    String[] strArr = A08;
                    if (strArr[5].charAt(12) != strArr[1].charAt(12)) {
                        A08[7] = "VAPByUbSVbCRl876Iw5SK7wrPn";
                        if (overScrollMode != 2) {
                            this.A06.A1Y(i15, currVelocity);
                        }
                    } else if (overScrollMode != 2) {
                        this.A06.A1Y(i15, currVelocity);
                    }
                    if ((i15 != 0 || i13 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i14 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (iA1d != 0 || iA1e != 0) {
                    C1278Eb c1278Eb2 = this.A06;
                    String[] strArr2 = A08;
                    if (strArr2[6].length() != strArr2[0].length()) {
                        c1278Eb2.A1b(iA1d, iA1e);
                    } else {
                        String[] strArr3 = A08;
                        strArr3[6] = "bSHjdsVkhDQdmG1cm4T37Ejfm8kVFC";
                        strArr3[0] = "uWlM2d1CCrIfar3HOPPYeFU5881RH0";
                        c1278Eb2.A1b(iA1d, iA1e);
                    }
                }
                if (!this.A06.awakenScrollBars()) {
                    this.A06.invalidate();
                }
                boolean z11 = (i11 == 0 && i12 == 0) || (i11 != 0 && this.A06.A06.A20() && iA1d == i11) || (i12 != 0 && this.A06.A06.A21() && iA1e == i12);
                boolean zIsFinished = overScroller.isFinished();
                if (A08[4].charAt(10) == 'o') {
                    throw new RuntimeException();
                }
                A08[2] = "98aPJs2vUpcbHQSYyxrV3zG03CSHn11I";
                if (zIsFinished || !(z11 || this.A06.A1r(1))) {
                    this.A06.setScrollState(0);
                    if (C1278Eb.A1E) {
                        this.A06.A02.A02();
                    }
                    this.A06.A1X(1);
                } else {
                    A07();
                    if (this.A06.A03 != null) {
                        this.A06.A03.A0B(this.A06, i11, i12);
                    }
                }
            }
            if (anonymousClass51 != null) {
                boolean zA0E = anonymousClass51.A0E();
                String[] strArr4 = A08;
                if (strArr4[5].charAt(12) != strArr4[1].charAt(12)) {
                    String[] strArr5 = A08;
                    strArr5[6] = "1QtdEsEbLTCaQSWKyl1hJXPObs6yvI";
                    strArr5[0] = "gIBnLdKBfiMzk6Ug2irxti7V3sW67K";
                    if (zA0E) {
                        anonymousClass51.A04(0, 0);
                    }
                    if (!this.A05) {
                        anonymousClass51.A09();
                    }
                }
            }
            A05();
            return;
        }
        A08();
        if (A08[2].charAt(8) != 'G') {
            A08[3] = "wyRlewweBEsEMs9L1doa5ZD019uED4";
            return;
        }
        throw new RuntimeException();
    }
}
