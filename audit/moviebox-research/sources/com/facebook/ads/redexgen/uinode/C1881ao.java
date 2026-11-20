package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1881ao extends KT {
    public static byte[] A03;
    public InterfaceC09590p A00;
    public String A01;
    public final /* synthetic */ FR A02;

    static {
        A02();
    }

    public C1881ao(FR fr2, InterfaceC09590p interfaceC09590p, String str) {
        this.A02 = fr2;
        this.A00 = interfaceC09590p;
        this.A01 = str;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{105, -116, -119, -104, -100, -115, -102, 72, -100, -111, -107, -115, -105, -99, -100, 86};
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        this.A02.A0S(this.A01);
        this.A02.A0N(this.A00);
        this.A02.ABR(new C1401Jb(AdErrorType.NETWORK_ERROR, A00(0, 16, 38)));
    }
}
