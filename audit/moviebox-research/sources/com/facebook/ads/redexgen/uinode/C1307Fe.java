package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1307Fe extends AbstractC1928bZ {
    public static byte[] A02;
    public static String[] A03 = {"EO73VH", "Qgz5bq7vpM6wgaeZrwJ0N", "K0RixItTLV229tIQ9volfY9Fr2yfBG4Z", "0XJd0xzB9RaoqzSBbOWrwbmO5Qd7B1Hm", "", "cDFQfUnzrKwrnb1BC8KnyL9IHyRAK9fC", "Q7Q0M0vYffDRrtcuJmKxnq", "hygqtGcON2Cep"};
    public static final String A04;
    public final Uri A00;
    public final Map<String, String> A01;

    static {
        A01();
        A04 = C1307Fe.class.getSimpleName();
    }

    public C1307Fe(C1795Yn c1795Yn, J2 j11, String str, Uri uri, Map<String, String> map, C09580o c09580o, boolean z11) {
        super(c1795Yn, j11, str, c09580o, z11);
        this.A00 = uri;
        this.A01 = map;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {Ascii.SO, 41, 49, 52, 45, 44, -24, 60, 55, -24, 55, 56, 45, 54, -24, 52, 49, 54, 51, -24, 61, 58, 52, 2, -24, -14, -17, -12, -15};
        if (A03[0].length() == 23) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[3] = "z2LBMWL3UZ6mgEOfq1wT6wdWGhdUBaxY";
        strArr[2] = "LNV6u0tAGiEAXpu6l5ZCQkq7c5KJBKxy";
        A02 = bArr;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1928bZ
    public final EnumC09510g A0D() {
        EnumC09510g enumC09510gA0G = EnumC09510g.A08;
        if (((AbstractC1928bZ) this).A02) {
            enumC09510gA0G = A0G();
        }
        if (!AbstractC1462Lo.A0e(((AbstractC09520h) this).A00, enumC09510gA0G, this.A01)) {
            A0E(this.A01, enumC09510gA0G);
        }
        return enumC09510gA0G;
    }

    public final EnumC09510g A0G() {
        if (A0F(this.A00)) {
            return EnumC09510g.A09;
        }
        try {
            return C1443Kv.A05(new C1443Kv(), ((AbstractC09520h) this).A00, AbstractC1446Ky.A00(this.A00.getQueryParameter(A00(25, 4, 35))), ((AbstractC09520h) this).A02, this.A01);
        } catch (Exception unused) {
            String str = A00(0, 25, 101) + this.A00.toString();
            return EnumC09510g.A03;
        }
    }
}
