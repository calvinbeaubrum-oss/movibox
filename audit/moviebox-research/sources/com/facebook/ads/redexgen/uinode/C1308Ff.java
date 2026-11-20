package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ff, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1308Ff extends AbstractC1928bZ {
    public static byte[] A03;
    public static String[] A04 = {"OXbCEMjwdPN5xvU2NT0kKgep5UeL1Sqr", "SX0ygsPxRN6KiRybC8JMsMv996SDI", "L77PzfY5dGd9ppcaJeqEYdg5mL", "qaE4mxmFDXDzve4pMTR5s0xQhV", "rrEUCxltihDw1phZ7LTyezPpJ6vgfWBl", "FdpTQfSalwXKw6iuOYHl49ZbqEAaQDuv", "IFg4N7XoM6S2Rxr", "IzcF2xeWDVSzXIhxKqlgaOjlVHZ1W1Z3"};
    public Map<String, String> A00;
    public boolean A01;
    public final Uri A02;

    static {
        A01();
    }

    public C1308Ff(C1795Yn c1795Yn, J2 j11, String str, Uri uri, Map<String, String> map) {
        super(c1795Yn, j11, str, null, true, true);
        this.A02 = uri;
        this.A00 = map;
    }

    public C1308Ff(C1795Yn c1795Yn, J2 j11, String str, Uri uri, Map<String, String> map, boolean z11) {
        this(c1795Yn, j11, str, uri, map);
        this.A01 = z11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {104, 109, 106, 111, 37, 34, 57, 36, 51, 9, 35, 36, 58, 9, 33, 51, 52, 9, 48, 55, 58, 58, 52, 55, 53, 61};
        if (A04[5].charAt(30) != 'u') {
            throw new RuntimeException();
        }
        A04[5] = "82m81CO1d0OwjHPL38rD7xdABiLQ6kup";
        A03 = bArr;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1928bZ
    public final EnumC09510g A0D() {
        A0E(this.A00, null);
        return EnumC09510g.A08;
    }

    public final Uri A0G() {
        String queryParameter = this.A02.getQueryParameter(A00(4, 22, 70));
        return (!this.A01 || TextUtils.isEmpty(queryParameter)) ? AbstractC1446Ky.A00(this.A02.getQueryParameter(A00(0, 4, 20))) : AbstractC1446Ky.A00(queryParameter);
    }
}
