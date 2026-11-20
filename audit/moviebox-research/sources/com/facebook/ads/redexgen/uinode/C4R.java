package com.facebook.ads.redexgen.uinode;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C4R {
    public static byte[] A05;
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final /* synthetic */ C1821Zo A04;

    static {
        A01();
    }

    public C4R(C1821Zo c1821Zo) {
        this.A04 = c1821Zo;
        A03();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{Ascii.CR, 1, 76, 98, 78, 78, 83, 69, 72, 79, 64, 85, 68, Ascii.FS, 111, 99, 46, Ascii.SI, 34, 58, 44, 54, 55, 5, 49, 44, 46, 6, 45, 39, 126, 91, 87, Ascii.SUB, 33, Ascii.SYN, Ascii.ESC, Ascii.RS, 19, 74, 116, 91, 86, 93, 90, 71, 124, 91, 83, 90, 78, 88, 101, 90, 70, 92, 65, 92, 90, 91, 8};
    }

    public final void A02() {
        this.A00 = this.A02 ? this.A04.A04.A07() : this.A04.A04.A0A();
    }

    public final void A03() {
        this.A01 = -1;
        this.A00 = Integer.MIN_VALUE;
        this.A02 = false;
        this.A03 = false;
    }

    public final void A04(View view) {
        if (this.A02) {
            this.A00 = this.A04.A04.A0C(view) + this.A04.A04.A05();
        } else {
            this.A00 = this.A04.A04.A0F(view);
        }
        this.A01 = this.A04.A0p(view);
    }

    public final void A05(View view) {
        int iA05 = this.A04.A04.A05();
        if (iA05 >= 0) {
            A04(view);
            return;
        }
        this.A01 = this.A04.A0p(view);
        if (this.A02) {
            int iA07 = (this.A04.A04.A07() - iA05) - this.A04.A04.A0C(view);
            this.A00 = this.A04.A04.A07() - iA07;
            if (iA07 > 0) {
                int iA0D = this.A00 - this.A04.A04.A0D(view);
                int iA0A = this.A04.A04.A0A();
                int iMin = iA0D - (Math.min(this.A04.A04.A0F(view) - iA0A, 0) + iA0A);
                if (iMin < 0) {
                    this.A00 += Math.min(iA07, -iMin);
                    return;
                }
                return;
            }
            return;
        }
        int iA0F = this.A04.A04.A0F(view);
        int iA0A2 = iA0F - this.A04.A04.A0A();
        this.A00 = iA0F;
        if (iA0A2 > 0) {
            int iA08 = (this.A04.A04.A07() - Math.min(0, (this.A04.A04.A07() - iA05) - this.A04.A04.A0C(view))) - (this.A04.A04.A0D(view) + iA0F);
            if (iA08 < 0) {
                this.A00 -= Math.min(iA0A2, -iA08);
            }
        }
    }

    public final boolean A06(View view, AnonymousClass53 anonymousClass53) {
        C10624p c10624p = (C10624p) view.getLayoutParams();
        return !c10624p.A02() && c10624p.A00() >= 0 && c10624p.A00() < anonymousClass53.A03();
    }

    public final String toString() {
        return A00(40, 21, 73) + this.A01 + A00(0, 14, 93) + this.A00 + A00(14, 17, 63) + this.A02 + A00(31, 9, 11) + this.A03 + '}';
    }
}
