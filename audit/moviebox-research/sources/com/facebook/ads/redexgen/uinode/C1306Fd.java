package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1306Fd extends AbstractC1928bZ {
    public static byte[] A02;
    public static final String A03;
    public final Uri A00;
    public final Map<String, String> A01;

    static {
        A01();
        A03 = C1306Fd.class.getSimpleName();
    }

    public C1306Fd(C1795Yn c1795Yn, J2 j11, String str, Uri uri, Map<String, String> map, C09580o c09580o, boolean z11) {
        super(c1795Yn, j11, str, c09580o, z11);
        this.A00 = uri;
        this.A01 = map;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{122, 93, 85, 80, 89, 88, Ascii.FS, 72, 83, Ascii.FS, 83, 76, 89, 82, Ascii.FS, 80, 85, 82, 87, Ascii.FS, 73, 78, 80, 6, Ascii.FS, 43, 46, 41, 44};
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1928bZ
    public final EnumC09510g A0D() {
        EnumC09510g enumC09510gA0G = EnumC09510g.A08;
        if (((AbstractC1928bZ) this).A02) {
            enumC09510gA0G = A0G();
        }
        A0E(this.A01, enumC09510gA0G);
        return enumC09510gA0G;
    }

    public final EnumC09510g A0G() {
        EnumC09510g enumC09510g = EnumC09510g.A08;
        try {
            C1443Kv.A0C(new C1443Kv(), ((AbstractC09520h) this).A00, AbstractC1446Ky.A00(this.A00.getQueryParameter(A00(25, 4, 8))), ((AbstractC09520h) this).A02);
            return enumC09510g;
        } catch (Exception unused) {
            String str = A00(0, 25, 115) + this.A00.toString();
            return EnumC09510g.A03;
        }
    }
}
