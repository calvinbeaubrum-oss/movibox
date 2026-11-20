package com.facebook.ads.redexgen.uinode;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.51, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AnonymousClass51 {
    public static byte[] A07;
    public static String[] A08 = {"ffTcX10Z9", "veDPHJ", "R", "iWatF5LLo", "0slLts", "p92m", PrepareException.ERROR_MINI_APP_CLOSE, "eFvKPH9TFpfstHyCObyNN72zUjBGeH"};
    public View A01;
    public AbstractC10614o A02;
    public C1278Eb A03;
    public boolean A04;
    public boolean A05;
    public int A00 = -1;
    public final C10714z A06 = new C10714z(0, 0);

    static {
        A03();
    }

    private final int A00(View view) {
        return this.A03.A1B(view);
    }

    private final View A01(int i11) {
        return this.A03.A06.A1m(i11);
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {78, 105, 113, 102, 107, 110, 99, 39, 115, 102, 117, 96, 98, 115, 39, 119, 104, 116, 110, 115, 110, 104, 105, Ascii.SYN, 39, 53, 53, 35, 34, 102, 41, 48, 35, 52, 102, 50, 39, 52, 33, 35, 50, 102, 54, 41, 53, 47, 50, 47, 41, 40, 102, 49, 46, 47, 42, 35, 102, 53, 43, 41, 41, 50, 46, 102, 53, 37, 52, 41, 42, 42, 47, 40, 33, 104, 78, 121, Ascii.DEL, 101, Ascii.DEL, 112, 121, 110, 74, 117, 121, 107};
        String[] strArr = A08;
        if (strArr[4].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A08[7] = "8BqCBekg5p6xdwXQXpIxknueaPhzjw";
        A07 = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(int i11, int i12) {
        C1278Eb c1278Eb = this.A03;
        if (!this.A05 || this.A00 == -1 || c1278Eb == null) {
            A09();
        }
        this.A04 = false;
        View view = this.A01;
        if (view != null) {
            int iA00 = A00(view);
            int i13 = this.A00;
            String[] strArr = A08;
            if (strArr[4].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "1zDtC4ICw";
            strArr2[0] = "WYaFIbeKL";
            if (iA00 == i13) {
                A0I(this.A01, c1278Eb.A0s, this.A06);
                C10714z c10714z = this.A06;
                if (A08[5].length() != 9) {
                    String[] strArr3 = A08;
                    strArr3[6] = "M";
                    strArr3[2] = "Q";
                    c10714z.A05(c1278Eb);
                    A09();
                } else {
                    A08[5] = "sldJFA0K947j";
                    c10714z.A05(c1278Eb);
                    A09();
                }
            } else {
                Log.e(A02(74, 12, 0), A02(23, 51, 90));
                this.A01 = null;
            }
        }
        if (this.A05) {
            A0H(i11, i12, c1278Eb.A0s, this.A06);
            boolean zA06 = this.A06.A06();
            this.A06.A05(c1278Eb);
            if (zA06) {
                if (!this.A05) {
                    A09();
                } else {
                    this.A04 = true;
                    c1278Eb.A08.A07();
                }
            }
        }
    }

    public final int A06() {
        return this.A03.A06.A0W();
    }

    public final int A07() {
        return this.A00;
    }

    public final AbstractC10614o A08() {
        return this.A02;
    }

    public final void A09() {
        if (this.A05) {
            A0G();
            this.A03.A0s.A0F = -1;
            this.A01 = null;
            this.A00 = -1;
            this.A04 = false;
            this.A05 = false;
            this.A02.A0M(this);
            this.A02 = null;
            this.A03 = null;
        }
    }

    public final void A0A(int i11) {
        this.A00 = i11;
    }

    public final void A0B(PointF pointF) {
        float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
        pointF.x /= fSqrt;
        pointF.y /= fSqrt;
    }

    public final void A0C(View view) {
        if (A00(view) == A07()) {
            this.A01 = view;
        }
    }

    public final void A0D(C1278Eb c1278Eb, AbstractC10614o abstractC10614o) {
        this.A03 = c1278Eb;
        this.A02 = abstractC10614o;
        if (this.A00 == -1) {
            throw new IllegalArgumentException(A02(0, 23, 27));
        }
        c1278Eb.A0s.A0F = this.A00;
        this.A05 = true;
        this.A04 = true;
        this.A01 = A01(A07());
        this.A03.A08.A07();
    }

    public final boolean A0E() {
        return this.A04;
    }

    public final boolean A0F() {
        return this.A05;
    }

    public abstract void A0G();

    public abstract void A0H(int i11, int i12, AnonymousClass53 anonymousClass53, C10714z c10714z);

    public abstract void A0I(View view, AnonymousClass53 anonymousClass53, C10714z c10714z);
}
