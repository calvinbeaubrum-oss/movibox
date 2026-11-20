package com.facebook.ads.redexgen.uinode;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class BQ extends C1631Sb {
    public static String[] A00 = {"4DJOkXe9rib7uWc4nLa4kcuSPdxs7gf4", "Dyxr4XzeXsq4jjw5BU630cyoQdL32ISv", "MScpZjpz", "3XC0FNsyX3k6WX9dbHhU9IwCEOagJZ1X", "JEKgPGdFYfe9RoD8dW0t8x0Mvi1GtEmi", "N5tdloXdcly7PUtxD1ZshZXdUDk2Lr2A", "5elKCHWntj6O1Wqi1faAvLWvEV4yzp2T", "JBMx9492vmjOwkRP6"};

    public BQ(C10393r c10393r, int i11, List<C1567Pp> list, RE re2, Bundle bundle) {
        super(c10393r, i11, list, re2, bundle);
        c10393r.A1f(this);
        this.A03 = new U0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00() {
        int iA23 = this.A0C.A23();
        if (this.A05 == null || iA23 == -1 || iA23 >= this.A05.size() - 1) {
            return;
        }
        A0U(iA23 + 1);
    }

    private void A01(int i11) {
        int iA24 = this.A0C.A24();
        int iA25 = this.A0C.A25();
        int iA23 = this.A0C.A23();
        if (iA23 != iA24) {
            A0S(iA24);
        }
        if (iA23 != iA25) {
            A0S(iA25);
        }
        A0T(iA23);
        A0V(iA24, iA25, i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1631Sb, com.facebook.ads.redexgen.uinode.AbstractC10664t
    public final void A0L(C1278Eb c1278Eb, int i11) {
    }

    @Override // com.facebook.ads.redexgen.uinode.C1631Sb, com.facebook.ads.redexgen.uinode.AbstractC10664t
    public final void A0M(C1278Eb c1278Eb, int i11, int i12) {
        if (this.A0C.A23() != -1) {
            TS ts2 = (TS) this.A0C.A1m(this.A0C.A23());
            if (A00[2].length() == 4) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[3] = "IxYVUA16uQkbjXwNztolao4gyOA0tKzF";
            strArr[6] = "jcO9EzcXxFOxyF2BSjZiD0vteRj0mA5y";
            if (ts2 != null && ts2.A18() && !ts2.A17()) {
                ts2.A15();
            }
            A01(i11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C1631Sb
    public final void A0X(View view, boolean z11) {
        view.setAlpha(z11 ? 1.0f : 0.8f);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1631Sb
    public final void A0Z(TS ts2, boolean z11) {
        A0X(ts2, z11);
        if (z11 || !ts2.A17()) {
            return;
        }
        ts2.A14();
    }

    @Override // com.facebook.ads.redexgen.uinode.C1631Sb
    public final boolean A0a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.75f;
    }

    public final RE A0b() {
        return this.A04;
    }

    public final void A0c(RE re2) {
        this.A04 = re2;
    }

    public final void A0d(List<C1567Pp> list) {
        this.A05 = list;
    }
}
