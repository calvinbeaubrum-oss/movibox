package com.facebook.ads.redexgen.uinode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HH implements InterfaceC1982ce {
    public final List<InterfaceC1621Rr> A00 = new ArrayList();

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1982ce
    public final InterfaceC1621Rr A5q(int i11) {
        this.A00.get(i11);
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<InterfaceC1621Rr> iterator() {
        return this.A00.iterator();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1982ce
    public final int size() {
        return this.A00.size();
    }
}
