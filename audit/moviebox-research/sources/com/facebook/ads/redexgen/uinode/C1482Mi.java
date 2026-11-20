package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1482Mi extends View {
    public InterfaceC1481Mh A00;

    public C1482Mi(C1795Yn c1795Yn, InterfaceC1481Mh interfaceC1481Mh) {
        super(c1795Yn);
        this.A00 = interfaceC1481Mh;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i11) {
        InterfaceC1481Mh interfaceC1481Mh = this.A00;
    }
}
