package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class OA {
    public static final int A00 = AbstractC1462Lo.A00();

    public static void A00(C1795Yn c1795Yn, ViewGroup viewGroup, String str) {
        new AsyncTaskC1672Tq(viewGroup, c1795Yn).A07(str);
        View view = new View(c1795Yn);
        view.setId(A00);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AbstractC1462Lo.A0R(view, c1795Yn);
        viewGroup.addView(view, 0);
    }
}
