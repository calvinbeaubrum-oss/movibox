package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.57, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AnonymousClass57 {
    public static String[] A00 = {"UqypfisWbLbbWLDfIVvpiaUsz0iS", "wEiCJDeLGzLJebV", "cX", "dRMEhdR7kDOm9Ob", "SmhGT229bW5LAFpAZzaxeRYqKvMDeGhX", "QcSoUKFtoryhyFMFYIfDI81ChPsDlMu7", "SBvSWfqovIH0ljTVzoffsyrdWCNw", "n"};

    public static int A00(AnonymousClass53 anonymousClass53, C4Y c4y, View view, View view2, AbstractC10614o abstractC10614o, boolean z11) {
        if (abstractC10614o.A0W() == 0 || anonymousClass53.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z11) {
            return Math.abs(abstractC10614o.A0p(view) - abstractC10614o.A0p(view2)) + 1;
        }
        int iA0C = c4y.A0C(view2);
        int iA0F = c4y.A0F(view);
        String[] strArr = A00;
        if (strArr[4].charAt(28) == strArr[5].charAt(28)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A00;
        strArr2[3] = "xd2oZUwi45Npmqe";
        strArr2[1] = "1k2xoHfklbXXQiR";
        return Math.min(c4y.A0B(), iA0C - iA0F);
    }

    public static int A01(AnonymousClass53 anonymousClass53, C4Y c4y, View view, View view2, AbstractC10614o abstractC10614o, boolean z11) {
        if (abstractC10614o.A0W() == 0 || anonymousClass53.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z11) {
            return anonymousClass53.A03();
        }
        return (int) (((c4y.A0C(view2) - c4y.A0F(view)) / (Math.abs(abstractC10614o.A0p(view) - abstractC10614o.A0p(view2)) + 1)) * anonymousClass53.A03());
    }

    public static int A02(AnonymousClass53 anonymousClass53, C4Y c4y, View view, View view2, AbstractC10614o abstractC10614o, boolean z11, boolean z12) {
        if (abstractC10614o.A0W() != 0) {
            int iA03 = anonymousClass53.A03();
            String[] strArr = A00;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[6] = "xSzU3PMpL9LC7k2G9V08vNIV3nIP";
            strArr2[0] = "UsrmTbcEPDcBULmsiiLKltF5MwgK";
            if (iA03 != 0 && view != null && view2 != null) {
                int iMax = z12 ? Math.max(0, (anonymousClass53.A03() - Math.max(abstractC10614o.A0p(view), abstractC10614o.A0p(view2))) - 1) : Math.max(0, Math.min(abstractC10614o.A0p(view), abstractC10614o.A0p(view2)));
                if (z11) {
                    return Math.round((iMax * (Math.abs(c4y.A0C(view2) - c4y.A0F(view)) / (Math.abs(abstractC10614o.A0p(view) - abstractC10614o.A0p(view2)) + 1))) + (c4y.A0A() - c4y.A0F(view)));
                }
                return iMax;
            }
        }
        return 0;
    }
}
