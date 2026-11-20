package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1820Zn extends AnonymousClass51 {
    public static byte[] A06;
    public PointF A02;
    public final float A03;
    public final LinearInterpolator A05 = new LinearInterpolator();
    public final DecelerateInterpolator A04 = new DecelerateInterpolator();
    public int A00 = 0;
    public int A01 = 0;

    static {
        A06();
    }

    public C1820Zn(Context context) {
        this.A03 = A0J(context.getResources().getDisplayMetrics());
    }

    private final int A00() {
        PointF pointF = this.A02;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.A02.y > 0.0f ? 1 : -1;
    }

    private int A01(int i11, int i12) {
        int i13 = i11 - i12;
        if (i11 * i13 <= 0) {
            return 0;
        }
        return i13;
    }

    private final int A03(View view, int i11) {
        AbstractC10614o abstractC10614oA08 = A08();
        if (abstractC10614oA08 == null || !abstractC10614oA08.A21()) {
            return 0;
        }
        C10624p c10624p = (C10624p) view.getLayoutParams();
        return A0N(abstractC10614oA08.A0o(view) - c10624p.topMargin, abstractC10614oA08.A0j(view) + c10624p.bottomMargin, abstractC10614oA08.A0g(), abstractC10614oA08.A0X() - abstractC10614oA08.A0d(), i11);
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 35);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A06 = new byte[]{41, Ascii.FF, Ascii.VT, 0, 4, Ascii.ETB, 54, 8, 10, 10, 17, Ascii.CR, 54, 6, Ascii.ETB, 10, 9, 9, 0, Ascii.ETB, Ascii.NAK, 35, 57, 108, Utf8.REPLACEMENT_BYTE, 36, 35, 57, 32, 40, 108, 35, 58, 41, 62, 62, 37, 40, 41, 108, 47, 35, 33, 60, 57, 56, 41, Ascii.US, 47, 62, 35, 32, 32, Ascii.SUB, 41, 47, 56, 35, 62, 10, 35, 62, Ascii.FS, 35, Utf8.REPLACEMENT_BYTE, 37, 56, 37, 35, 34, 108, 59, 36, 41, 34, 108, 56, 36, 41, 108, 0, 45, 53, 35, 57, 56, 1, 45, 34, 45, 43, 41, 62, 108, 40, 35, 41, Utf8.REPLACEMENT_BYTE, 108, 34, 35, 56, 108, 37, 33, 60, 32, 41, 33, 41, 34, 56, 108, 42, 55, 56, 41, 121, 41, 43, 60, Utf8.REPLACEMENT_BYTE, 60, 43, 60, 55, 58, 60, 121, 42, 49, 54, 44, 53, 61, 121, 59, 60, 121, 54, 55, 60, 121, 54, Utf8.REPLACEMENT_BYTE, 121, 45, 49, 60, 121, 58, 54, 55, 42, 45, 56, 55, 45, 42, 121, 61, 60, Utf8.REPLACEMENT_BYTE, 48, 55, 60, 61, 121, 48, 55, 121, 10, 52, 54, 54, 45, 49, 10, 58, 43, 54, 53, 53, 60, 43, 117, 121, 42, 45, 56, 43, 45, 48, 55, 62, 121, 46, 48, 45, 49, 121, 10, Ascii.ETB, Ascii.CAN, 9, 6};
    }

    private final void A07(C10714z c10714z) {
        PointF pointFA0P = A0P(A07());
        if (pointFA0P == null || (pointFA0P.x == 0.0f && pointFA0P.y == 0.0f)) {
            c10714z.A03(A07());
            A09();
            return;
        }
        A0B(pointFA0P);
        this.A02 = pointFA0P;
        this.A00 = (int) (pointFA0P.x * 10000.0f);
        this.A01 = (int) (pointFA0P.y * 10000.0f);
        c10714z.A04((int) (this.A00 * 1.2f), (int) (this.A01 * 1.2f), (int) (A0L(10000) * 1.2f), this.A05);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass51
    public final void A0G() {
        this.A01 = 0;
        this.A00 = 0;
        this.A02 = null;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass51
    public final void A0H(int i11, int i12, AnonymousClass53 anonymousClass53, C10714z c10714z) {
        if (A06() == 0) {
            A09();
            return;
        }
        this.A00 = A01(this.A00, i11);
        int iA01 = A01(this.A01, i12);
        this.A01 = iA01;
        if (this.A00 == 0 && iA01 == 0) {
            A07(c10714z);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass51
    public void A0I(View view, AnonymousClass53 anonymousClass53, C10714z c10714z) {
        int iA0O = A0O(view, A0K());
        int iA03 = A03(view, A00());
        int iA0M = A0M((int) Math.sqrt((iA0O * iA0O) + (iA03 * iA03)));
        if (iA0M > 0) {
            c10714z.A04(-iA0O, -iA03, iA0M, this.A04);
        }
    }

    public float A0J(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int A0K() {
        PointF pointF = this.A02;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.A02.x > 0.0f ? 1 : -1;
    }

    public int A0L(int i11) {
        return (int) Math.ceil(Math.abs(i11) * this.A03);
    }

    public final int A0M(int i11) {
        return (int) Math.ceil(((double) A0L(i11)) / 0.3356d);
    }

    public final int A0N(int i11, int i12, int i13, int i14, int i15) {
        switch (i15) {
            case -1:
                return i13 - i11;
            case 0:
                int i16 = i13 - i11;
                if (i16 > 0) {
                    return i16;
                }
                int i17 = i14 - i12;
                if (i17 < 0) {
                    return i17;
                }
                return 0;
            case 1:
                return i14 - i12;
            default:
                throw new IllegalArgumentException(A04(113, 93, 122));
        }
    }

    public int A0O(View view, int i11) {
        AbstractC10614o abstractC10614oA08 = A08();
        if (abstractC10614oA08 == null || !abstractC10614oA08.A20()) {
            return 0;
        }
        C10624p c10624p = (C10624p) view.getLayoutParams();
        return A0N(abstractC10614oA08.A0k(view) - c10624p.leftMargin, abstractC10614oA08.A0n(view) + c10624p.rightMargin, abstractC10614oA08.A0e(), abstractC10614oA08.A0h() - abstractC10614oA08.A0f(), i11);
    }

    public PointF A0P(int i11) {
        Object objA08 = A08();
        if (objA08 instanceof AnonymousClass50) {
            return ((AnonymousClass50) objA08).A4O(i11);
        }
        Log.w(A04(0, 20, 70), A04(20, 93, 111) + AnonymousClass50.class.getCanonicalName());
        return null;
    }
}
