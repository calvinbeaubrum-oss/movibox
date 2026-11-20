package com.facebook.ads.redexgen.uinode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1972cT {
    public final Map<DspViewableNode, C1978ca> A00 = new WeakHashMap();

    public final synchronized C1978ca A00(DspViewableNode dspViewableNode) {
        C1978ca c1978ca = this.A00.get(dspViewableNode);
        if (c1978ca != null) {
            return c1978ca;
        }
        return C1978ca.A08;
    }

    public final synchronized void A01(DspViewableNode dspViewableNode) {
        this.A00.remove(dspViewableNode);
    }

    public final synchronized void A02(DspViewableNode dspViewableNode, C1978ca c1978ca) {
        this.A00.put(dspViewableNode, c1978ca);
    }

    public final synchronized void A03(Collection<DspViewableNode> collection) {
        Iterator<DspViewableNode> it = this.A00.keySet().iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }
}
