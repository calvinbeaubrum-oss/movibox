package com.facebook.ads.redexgen.uinode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1796Yo implements InterfaceC11046g {
    public final Map<String, Set<String>> A00 = new HashMap();

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11046g
    public final synchronized void A4H(String str) {
        this.A00.remove(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11046g
    public final synchronized boolean A8x(String str, String str2) {
        Set<String> set;
        set = this.A00.get(str2);
        return set != null && set.contains(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11046g
    public final synchronized void AFq(String str, String str2) {
        Set<String> hashSet = this.A00.get(str2);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.A00.put(str2, hashSet);
        }
        hashSet.add(str);
    }
}
