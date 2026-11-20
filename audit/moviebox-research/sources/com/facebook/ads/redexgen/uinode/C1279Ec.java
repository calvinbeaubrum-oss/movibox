package com.facebook.ads.redexgen.uinode;

import android.graphics.PointF;
import android.view.View;
import com.google.android.gms.common.api.Api;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ec, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1279Ec extends ZY {
    public static String[] A02 = {"C44Ajl3kvJruV1G0pt7gVRuztfjSJyFq", "J5x5lFquh7whloqA7FngbvBzLsCb", "NWBvU5bW0Pue", "3", "BTAVkHunqM91yRRN2KcoYuZCergWfboL", "2NY5ANPTvwBPWrnTgdotgLNYCmp8", "bg7eF9CjngMlwdFplTojabi", "lLeEucKPPYu6Z0yxrpg2o1MG4v3W39r2"};
    public C4Y A00;
    public C4Y A01;

    private int A00(AbstractC10614o abstractC10614o, View view, C4Y c4y) {
        return (c4y.A0F(view) + (c4y.A0D(view) / 2)) - (abstractC10614o.A1T() ? c4y.A0A() + (c4y.A0B() / 2) : c4y.A06() / 2);
    }

    private View A01(AbstractC10614o abstractC10614o, C4Y c4y) {
        int iA06;
        int iA0W = abstractC10614o.A0W();
        if (iA0W == 0) {
            return null;
        }
        View view = null;
        if (abstractC10614o.A1T()) {
            int iA0A = c4y.A0A();
            int iA0B = c4y.A0B();
            if (A02[3].length() != 1) {
                throw new RuntimeException();
            }
            A02[4] = "QSrTWOl4jyYASaYHeqwJw7nAVlZS9nVf";
            iA06 = iA0A + (iA0B / 2);
        } else {
            iA06 = c4y.A06() / 2;
        }
        int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i12 = 0; i12 < iA0W; i12++) {
            View viewA0t = abstractC10614o.A0t(i12);
            int iAbs = Math.abs((c4y.A0F(viewA0t) + (c4y.A0D(viewA0t) / 2)) - iA06);
            if (iAbs < i11) {
                i11 = iAbs;
                view = viewA0t;
            }
        }
        return view;
    }

    private View A02(AbstractC10614o abstractC10614o, C4Y c4y) {
        int iA0W = abstractC10614o.A0W();
        if (iA0W == 0) {
            return null;
        }
        View view = null;
        int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i12 = 0; i12 < iA0W; i12++) {
            View viewA0t = abstractC10614o.A0t(i12);
            int iA0F = c4y.A0F(viewA0t);
            if (iA0F < i11) {
                i11 = iA0F;
                if (A02[3].length() != 1) {
                    throw new RuntimeException();
                }
                A02[3] = "0";
                view = viewA0t;
            }
        }
        return view;
    }

    private C4Y A03(AbstractC10614o abstractC10614o) {
        C4Y c4y = this.A00;
        if (c4y == null || c4y.A02 != abstractC10614o) {
            this.A00 = C4Y.A00(abstractC10614o);
        }
        return this.A00;
    }

    private C4Y A04(AbstractC10614o abstractC10614o) {
        C4Y c4y = this.A01;
        if (c4y == null || c4y.A02 != abstractC10614o) {
            this.A01 = C4Y.A01(abstractC10614o);
        }
        return this.A01;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0087  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.ads.redexgen.uinode.ZY
    public final int A0C(AbstractC10614o abstractC10614o, int i11, int i12) {
        int iA0p;
        boolean z11;
        int iA0Z = abstractC10614o.A0Z();
        if (iA0Z == 0) {
            return -1;
        }
        View viewA02 = null;
        if (abstractC10614o.A21()) {
            viewA02 = A02(abstractC10614o, A04(abstractC10614o));
        } else if (abstractC10614o.A20()) {
            C4Y c4yA03 = A03(abstractC10614o);
            if (A02[3].length() != 1) {
                throw new RuntimeException();
            }
            A02[4] = "gb7KateBwDTMhlVKT6fWGE4qrSBelOuo";
            viewA02 = A02(abstractC10614o, c4yA03);
        }
        if (viewA02 == null || (iA0p = abstractC10614o.A0p(viewA02)) == -1) {
            return -1;
        }
        if (abstractC10614o.A20()) {
            z11 = i11 > 0;
        } else {
            z11 = i12 > 0;
        }
        boolean z12 = false;
        if (abstractC10614o instanceof AnonymousClass50) {
            PointF pointFA4O = ((AnonymousClass50) abstractC10614o).A4O(iA0Z - 1);
            if (A02[3].length() != 1) {
                String[] strArr = A02;
                strArr[6] = "yuw4mNpzW34AqVSRehlxNeo";
                strArr[2] = "wkUUhZpWZ02e";
                if (pointFA4O != null) {
                    z12 = pointFA4O.x >= 0.0f || pointFA4O.y < 0.0f;
                }
            } else {
                A02[0] = "mSLQWLSJnMsLfeZB8hd0gvJZQvTgwPgU";
                if (pointFA4O != null) {
                    z12 = pointFA4O.x >= 0.0f || pointFA4O.y < 0.0f;
                }
            }
        }
        if (z12) {
            return z11 ? iA0p - 1 : iA0p;
        }
        return z11 ? iA0p + 1 : iA0p;
    }

    @Override // com.facebook.ads.redexgen.uinode.ZY
    public final View A0D(AbstractC10614o abstractC10614o) {
        if (abstractC10614o.A21()) {
            return A01(abstractC10614o, A04(abstractC10614o));
        }
        if (abstractC10614o.A20()) {
            return A01(abstractC10614o, A03(abstractC10614o));
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.uinode.ZY
    public final C1820Zn A0E(AbstractC10614o abstractC10614o) {
        if (abstractC10614o instanceof AnonymousClass50) {
            return new C1280Ed(this, super.A00.getContext());
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.uinode.ZY
    public final int[] A0H(AbstractC10614o abstractC10614o, View view) {
        int[] iArr = new int[2];
        if (abstractC10614o.A20()) {
            iArr[0] = A00(abstractC10614o, view, A03(abstractC10614o));
        } else {
            iArr[0] = 0;
        }
        boolean zA21 = abstractC10614o.A21();
        String[] strArr = A02;
        if (strArr[1].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A02[0] = "E62MX6H1I4NpqQbgkpQnwXfK7jhgOp7C";
        if (zA21) {
            iArr[1] = A00(abstractC10614o, view, A04(abstractC10614o));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
