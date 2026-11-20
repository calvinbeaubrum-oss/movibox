package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X3 implements InterfaceC1259Cy {
    public static byte[] A06;
    public static String[] A07 = {"c0KpkRjZorNQD76", "v", "0d4inMg3wDkuo1aYYl0ssqqGC", "DDXERfdvXnPt4luj6e7N9DVUtx6ZaQcR", "MB0SdpAzdDPGS5LRihVQgeZ9YJgSZ4OW", "1ftUnjVA0zWQWzcI2VyXZGsvfHTse3XE", "DWX3euW52jSmR8J8g1ui9PfHl", "CNcDYli8yhj93EfpNTcuq0KbKbZRyRug"};
    public int A00;
    public int A01;
    public long A02;
    public boolean A03;
    public final List<D9> A04;
    public final C4[] A05;

    static {
        A01();
    }

    public X3(List<D9> list) {
        this.A04 = list;
        this.A05 = new C4[list.size()];
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 85);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{52, 67, 67, Utf8.REPLACEMENT_BYTE, 60, 54, 52, 71, 60, 66, 65, 2, 55, 73, 53, 70, 72, 53, 70};
    }

    private boolean A02(C1376Hz c1376Hz, int i11) {
        if (c1376Hz.A04() == 0) {
            return false;
        }
        if (c1376Hz.A0E() != i11) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4R(C1376Hz c1376Hz) {
        if (this.A03) {
            if (this.A00 != 2 || A02(c1376Hz, 32)) {
                if (this.A00 != 1 || A02(c1376Hz, 0)) {
                    int iA06 = c1376Hz.A06();
                    if (A07[5].charAt(6) != 'V') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A07;
                    strArr[2] = "JHIe8W9CfwFDjJjaFpf1hCiFr";
                    strArr[6] = "vBjglJY7hKXluELD1o7ad0wQv";
                    int iA04 = c1376Hz.A04();
                    for (C4 c11 : this.A05) {
                        c1376Hz.A0Y(iA06);
                        c11.AFR(c1376Hz, iA04);
                    }
                    this.A01 += iA04;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4p(InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        for (int i11 = 0; i11 < this.A05.length; i11++) {
            D9 d11 = this.A04.get(i11);
            dc2.A05();
            C4 c4AGi = interfaceC1235Bu.AGi(dc2.A03(), 3);
            c4AGi.A5n(Format.A0A(dc2.A04(), A00(0, 19, WebSocketProtocol.PAYLOAD_SHORT), null, -1, 0, Collections.singletonList(d11.A02), d11.A01, null));
            this.A05[i11] = c4AGi;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADs() {
        if (this.A03) {
            for (C4 c11 : this.A05) {
                c11.AFS(this.A02, 1, this.A01, 0, null);
            }
            this.A03 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADt(long j11, boolean z11) {
        if (z11) {
            this.A03 = true;
            this.A02 = j11;
            this.A01 = 0;
            this.A00 = 2;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void AFg() {
        this.A03 = false;
    }
}
