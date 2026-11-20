package com.facebook.ads.redexgen.uinode;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WF implements InterfaceC1315Fo {
    public static String[] A02 = {"rC2J7AwmmaBlZB1ox11LDA9ZAB6fxVsC", "FZKyzMmy9TivpD2nKj9z4jyUnxaUeLwM", "SgCjuagBwk99AmsF9yO8OoMMvubs4clZ", "SMyqq5yIGtEsHah", "ZWugu9oJugVg9n7ZMlc8zaFASnxpD2Hj", "S8p9iTCEp8NZOaZR39SQR", "XhPs2dbFqyZTAL6Xfbqo6", "a7gb9qnnbjI1KAE"};
    public final long[] A00;
    public final C1314Fn[] A01;

    public WF(C1314Fn[] c1314FnArr, long[] jArr) {
        this.A01 = c1314FnArr;
        this.A00 = jArr;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final List<C1314Fn> A6Z(long j11) {
        int iA0B = IF.A0B(this.A00, j11, true, false);
        if (iA0B != -1) {
            C1314Fn[] c1314FnArr = this.A01;
            if (A02[0].charAt(18) != '1') {
                throw new RuntimeException();
            }
            A02[1] = "utRrKVvY3UrlqyIa0tu41Z4MJfpwxdGA";
            C1314Fn c1314Fn = c1314FnArr[iA0B];
            if (c1314Fn != null) {
                return Collections.singletonList(c1314Fn);
            }
        }
        return Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final long A70(int i11) {
        AbstractC1351Ha.A03(i11 >= 0);
        AbstractC1351Ha.A03(i11 < this.A00.length);
        return this.A00[i11];
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A71() {
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A7T(long j11) {
        int iA0A = IF.A0A(this.A00, j11, false, false);
        if (iA0A < this.A00.length) {
            return iA0A;
        }
        return -1;
    }
}
