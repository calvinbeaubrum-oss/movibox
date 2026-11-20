package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class RR {
    public static byte[] A07;
    public RI A05;
    public int A04 = 60000;
    public int A03 = 100;
    public int A00 = 10000;
    public int A02 = 8000;
    public int A01 = 3;
    public Map<String, String> A06 = new HashMap();

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{49, Ascii.GS, 4, Ascii.NAK, 17, 9, 17, 92, Ascii.SO, Ascii.EM, 8, Ascii.SO, Ascii.NAK, Ascii.EM, Ascii.SI, 92, 17, 9, Ascii.SI, 8, 92, Ascii.RS, Ascii.EM, 92, Ascii.RS, Ascii.EM, 8, Ascii.VT, Ascii.EM, Ascii.EM, Ascii.DC2, 92, 77, 92, Ascii.GS, Ascii.DC2, Ascii.CAN, 92, 77, 68};
    }

    public final RR A02(int i11) {
        this.A00 = i11;
        return this;
    }

    public final RR A03(int i11) {
        if (i11 < 1 || i11 > 18) {
            throw new IllegalArgumentException(A00(0, 40, 56));
        }
        this.A01 = i11;
        return this;
    }

    public final RR A04(int i11) {
        this.A02 = i11;
        return this;
    }

    public final RR A05(int i11) {
        this.A03 = i11;
        return this;
    }

    public final RR A06(int i11) {
        this.A04 = i11;
        return this;
    }

    public final RR A07(RI ri2) {
        this.A05 = ri2;
        return this;
    }

    public final RR A08(Map<String, String> map) {
        this.A06 = map;
        return this;
    }

    public final RS A09() {
        return new RS(this.A04, this.A00, this.A02, this.A03, this.A01, this.A06, this.A05);
    }
}
