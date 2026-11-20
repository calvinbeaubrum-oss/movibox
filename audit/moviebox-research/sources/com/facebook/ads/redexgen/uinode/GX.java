package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.trackselection.DefaultTrackSelector$Parameters;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GX implements Comparable<GX> {
    public static String[] A07 = {"eb8CGYK3prt3t", "dQfQVH0VaiNJA", "r8fXA", "r3rHNRtipUDB7ufPa7P3AvdqyjlNLgla", "2m", "YPC8s", "obzEXxZAmH6P4FrObF", "ImIsZWaiqjX9J"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final DefaultTrackSelector$Parameters A06;

    public GX(Format format, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int i11) {
        this.A06 = defaultTrackSelector$Parameters;
        this.A05 = C1229Bo.A0H(i11, false) ? 1 : 0;
        this.A03 = C1229Bo.A0K(format, defaultTrackSelector$Parameters.A07) ? 1 : 0;
        this.A02 = (format.A0D & 1) != 0 ? 1 : 0;
        this.A01 = format.A05;
        this.A04 = format.A0C;
        this.A00 = format.A04;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(GX gx2) {
        int i11 = this.A05;
        int i12 = gx2.A05;
        if (i11 != i12) {
            return C1229Bo.A01(i11, i12);
        }
        int i13 = this.A03;
        int i14 = gx2.A03;
        if (i13 != i14) {
            return C1229Bo.A01(i13, i14);
        }
        int i15 = this.A02;
        int i16 = gx2.A02;
        if (i15 != i16) {
            return C1229Bo.A01(i15, i16);
        }
        if (this.A06.A0D) {
            return C1229Bo.A01(gx2.A00, this.A00);
        }
        int i17 = this.A05 != 1 ? -1 : 1;
        int i18 = this.A01;
        int i19 = gx2.A01;
        if (i18 == i19) {
            int i21 = this.A04;
            int i22 = gx2.A04;
            return i21 != i22 ? C1229Bo.A01(i21, i22) * i17 : C1229Bo.A01(this.A00, gx2.A00) * i17;
        }
        int iA01 = C1229Bo.A01(i18, i19) * i17;
        String[] strArr = A07;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[7] = "P8pKjaXeFiun6";
        strArr2[0] = "9cxjYqXmdfp1O";
        return iA01;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GX gx2 = (GX) obj;
        if (this.A05 == gx2.A05 && this.A03 == gx2.A03 && this.A02 == gx2.A02 && this.A01 == gx2.A01) {
            int i11 = this.A04;
            if (A07[3].charAt(10) != 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[5] = "D3QBn";
            strArr[2] = "QopBq";
            if (i11 == gx2.A04 && this.A00 == gx2.A00) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.A05 * 31) + this.A03) * 31) + this.A02) * 31) + this.A01) * 31) + this.A04) * 31) + this.A00;
    }
}
