package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1742Wm implements InterfaceC1233Bs {
    public static byte[] A05;
    public static String[] A06 = {"4UYaWsXN1cGpTlRGsO1EVWVYv3mJMVWU", "hbK8JAe0mxfaYRX1PJWZwY", "A0tXjRJ", "osk77A0r9", "0YYQ7Ec", "0ahCLR5uyRlwKx93emwBc8GJDT750HRT", "YIO", "F1mMZvBQ8EiEftVGCLgPL0zcj9avMacR"};
    public static final InterfaceC1236Bv A07;
    public int A00;
    public int A01;
    public InterfaceC1235Bu A02;
    public C4 A03;
    public C1741Wl A04;

    static {
        A01();
        A07 = new C1743Wn();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{53, 78, 83, 85, 80, 80, 79, 82, 84, 69, 68, 0, 79, 82, 0, 85, 78, 82, 69, 67, 79, 71, 78, 73, 90, 69, 68, 0, 87, 65, 86, 0, 72, 69, 65, 68, 69, 82, Ascii.SO, 52, 72, 55, 60, 66, 2, 69, 52, 74};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A02 = interfaceC1235Bu;
        this.A03 = interfaceC1235Bu.AGi(0, 1);
        this.A04 = null;
        interfaceC1235Bu.A5Y();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        if (this.A04 == null) {
            C1741Wl c1741WlA00 = DF.A00(interfaceC1234Bt);
            this.A04 = c1741WlA00;
            if (c1741WlA00 == null) {
                throw new C11849v(A00(0, 39, WebSocketProtocol.PAYLOAD_SHORT));
            }
            this.A03.A5n(Format.A06(null, A00(39, 9, 113), null, c1741WlA00.A00(), 32768, this.A04.A03(), this.A04.A04(), this.A04.A02(), null, null, 0, null));
            this.A00 = this.A04.A01();
        }
        C1741Wl c1741Wl = this.A04;
        if (A06[0].charAt(24) != 'v') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[6] = "XBd";
        strArr[3] = "hS3DTCCH9";
        if (!c1741Wl.A07()) {
            DF.A03(interfaceC1234Bt, this.A04);
            this.A02.AFi(this.A04);
        }
        int iAFQ = this.A03.AFQ(interfaceC1234Bt, 32768 - this.A01, true);
        if (iAFQ != -1) {
            this.A01 += iAFQ;
        }
        int i11 = this.A01 / this.A00;
        if (i11 > 0) {
            long jA05 = this.A04.A05(interfaceC1234Bt.A7i() - ((long) this.A01));
            int i12 = this.A00 * i11;
            int i13 = this.A01 - i12;
            this.A01 = i13;
            this.A03.AFS(jA05, 1, i12, i13, null);
        }
        return iAFQ == -1 ? -1 : 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        return DF.A00(interfaceC1234Bt) != null;
    }
}
