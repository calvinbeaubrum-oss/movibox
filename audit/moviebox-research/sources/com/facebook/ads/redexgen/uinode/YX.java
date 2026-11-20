package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YX implements KJ {
    @Override // com.facebook.ads.redexgen.uinode.KJ
    public final void AFC(Throwable th2, Object obj) {
        if (obj instanceof InterfaceC11197b) {
            C1795Yn c1795YnA5t = ((InterfaceC11197b) obj).A5t();
            if (c1795YnA5t != null) {
                c1795YnA5t.A0O(th2);
                return;
            }
            return;
        }
        if (obj instanceof View) {
            Context context = ((View) obj).getContext();
            if (context instanceof C1795Yn) {
                ((C1795Yn) context).A0O(th2);
            }
        }
    }
}
