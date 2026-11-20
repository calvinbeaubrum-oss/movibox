package com.facebook.ads.redexgen.uinode;

import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.En, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1290En extends C1829Zw {
    @Override // com.facebook.ads.redexgen.uinode.C10333l
    public final int A00(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    @Override // com.facebook.ads.redexgen.uinode.C10333l
    public final void A01(AccessibilityEvent accessibilityEvent, int i11) {
        accessibilityEvent.setContentChangeTypes(i11);
    }
}
