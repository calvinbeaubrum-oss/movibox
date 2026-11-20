package com.facebook.ads.redexgen.uinode;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1966cN {
    public final Map<String, C1978ca> A00;
    public final Set<C1978ca> A01;

    public C1966cN() {
        this.A00 = new HashMap();
        this.A01 = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<C1978ca> A00() {
        return this.A01;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<C1978ca> A01() {
        return this.A00.values();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        this.A00.clear();
        for (C1978ca c1978ca : this.A01) {
            this.A00.put(c1978ca.A04, c1978ca);
        }
        this.A01.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A06(C1978ca c1978ca) {
        if (!this.A01.add(c1978ca)) {
            return false;
        }
        this.A00.remove(c1978ca.A04);
        return true;
    }
}
