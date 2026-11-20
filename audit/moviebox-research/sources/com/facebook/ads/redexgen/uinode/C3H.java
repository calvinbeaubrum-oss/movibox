package com.facebook.ads.redexgen.uinode;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C3H extends C11076k {
    @Override // com.facebook.ads.redexgen.uinode.C10363o
    public Object A00(int i11, int i12, int i13, int i14, boolean z11, boolean z12) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i11, i12, i13, i14, z11);
    }

    @Override // com.facebook.ads.redexgen.uinode.C10363o
    public Object A01(int i11, int i12, boolean z11, int i13) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i11, i12, z11);
    }

    @Override // com.facebook.ads.redexgen.uinode.C10363o
    public final void A03(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj);
    }

    @Override // com.facebook.ads.redexgen.uinode.C10363o
    public final void A04(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj);
    }
}
