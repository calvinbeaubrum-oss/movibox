package com.facebook.ads.redexgen.uinode;

import android.graphics.Rect;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VX {
    public static String[] A02 = {"AMQNzlG2eGPOJo74lPpddO6twtMEce", "8uZuLGh3CZSzV4eSaK74M9a8aAW81o1g", "CYs8BZmCr6kO5jRRUq4laItl384RlovT", "PO4hUmmCpilEicL1R3sLdD9hI0Kiey5Z", "WmgRsP13YsLJamj9MMjVCco3tjnpIVCq", "0ErvOAeoLZJf3MJzf6jF5Cw5BrHPqp", "S0kgbIpbc64QMPj8XCJtTK8zDrzNpUnW", "MO6xPizLQkqntlkNHRrNVg7dZ2stU5UP"};
    public final Rect A00 = new Rect();
    public final Rect A01 = new Rect();

    public static boolean A00(C1978ca<C1389Io, C1394It> c1978ca) {
        if (c1978ca.A02.A05()) {
            return c1978ca.A03.A07();
        }
        if (!c1978ca.A02.A06()) {
            return true;
        }
        C1394It c1394It = c1978ca.A03;
        String[] strArr = A02;
        if (strArr[3].charAt(7) != strArr[2].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "8O0EOVeCMdEJdeSbYPFIeNjJXhTUSITs";
        strArr2[2] = "Km62DwbCV8Ma1ecjtuIU72b1y8KakI9d";
        return c1394It.A06();
    }

    private boolean A01(C1978ca<C1389Io, C1394It> c1978ca, InterfaceC1968cP interfaceC1968cP) {
        float fA8M = -1.0f;
        try {
            fA8M = interfaceC1968cP.A8M(c1978ca);
        } catch (IllegalStateException unused) {
        }
        if (fA8M > 0.0f && A00(c1978ca)) {
            return true;
        }
        if (c1978ca.A02.A00().getGlobalVisibleRect(this.A01) && this.A01.bottom - this.A01.top > 0 && A00(c1978ca)) {
            return true;
        }
        interfaceC1968cP.A8L(this.A00);
        interfaceC1968cP.A78(c1978ca, this.A01);
        return (this.A00.bottom - this.A00.top > 0 && this.A01.bottom - this.A00.top > 0) && A00(c1978ca);
    }

    public final void A02(C1978ca<C1389Io, C1394It> c1978ca, InterfaceC1968cP interfaceC1968cP) {
        if (c1978ca.A03.A04() && A01(c1978ca, interfaceC1968cP)) {
            c1978ca.A03.A01();
            c1978ca.A02.A02().AA0(c1978ca.A02.A03(), c1978ca.A02.A04());
        }
        if (c1978ca.A03.A05() && C1384Ih.A1J(c1978ca.A02.A01())) {
            c1978ca.A03.A02();
            c1978ca.A02.A02().A9i(c1978ca.A02.A03(), c1978ca.A02.A04());
        }
    }
}
