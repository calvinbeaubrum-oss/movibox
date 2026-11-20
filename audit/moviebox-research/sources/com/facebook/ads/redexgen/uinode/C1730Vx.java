package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1730Vx implements InterfaceC1346Gu {
    public static byte[] A00;
    public static final InterfaceC1345Gt A01;
    public static final C1730Vx A02;

    static {
        A01();
        A02 = new C1730Vx();
        A01 = new C1731Vy();
    }

    public C1730Vx() {
    }

    public /* synthetic */ C1730Vx(C1731Vy c1731Vy) {
        this();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{51, 2, Ascii.SUB, Ascii.SUB, Ascii.SO, 87, 4, Ascii.CAN, 2, 5, Ascii.DC4, Ascii.DC2};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final Uri A8E() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final long ADl(C1350Gy c1350Gy) throws IOException {
        throw new IOException(A00(0, 12, 28));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final void close() throws IOException {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        throw new UnsupportedOperationException();
    }
}
