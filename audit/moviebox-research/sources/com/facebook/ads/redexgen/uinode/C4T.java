package com.facebook.ads.redexgen.uinode;

import android.view.View;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C4T {
    public int A00;
    public int A01;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public boolean A09;
    public boolean A0B = true;
    public int A02 = 0;
    public boolean A0A = false;
    public List<AnonymousClass56> A08 = null;

    private View A00() {
        int size = this.A08.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.A08.get(i11).A0H;
            C10624p c10624p = (C10624p) view.getLayoutParams();
            if (!c10624p.A02() && this.A01 == c10624p.A00()) {
                A02(view);
                return view;
            }
        }
        return null;
    }

    private final View A01(View view) {
        int iA00;
        int size = this.A08.size();
        View view2 = null;
        int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i12 = 0; i12 < size; i12++) {
            View view3 = this.A08.get(i12).A0H;
            C10624p c10624p = (C10624p) view3.getLayoutParams();
            if (view3 != view && !c10624p.A02() && (iA00 = (c10624p.A00() - this.A01) * this.A03) >= 0 && iA00 < i11) {
                view2 = view3;
                i11 = iA00;
                if (iA00 == 0) {
                    break;
                }
            }
        }
        return view2;
    }

    private final void A02(View view) {
        View viewA01 = A01(view);
        if (viewA01 == null) {
            this.A01 = -1;
        } else {
            this.A01 = ((C10624p) viewA01.getLayoutParams()).A00();
        }
    }

    public final View A03(C10684w c10684w) {
        if (this.A08 != null) {
            return A00();
        }
        View viewA0G = c10684w.A0G(this.A01);
        this.A01 += this.A03;
        return viewA0G;
    }

    public final void A04() {
        A02(null);
    }

    public final boolean A05(AnonymousClass53 anonymousClass53) {
        int i11 = this.A01;
        return i11 >= 0 && i11 < anonymousClass53.A03();
    }
}
