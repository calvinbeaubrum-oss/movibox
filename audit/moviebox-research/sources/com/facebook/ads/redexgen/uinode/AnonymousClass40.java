package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.40, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AnonymousClass40 {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.3y] */
    public static C3y A00(final InterfaceC10463z interfaceC10463z) {
        return new AccessibilityNodeProvider() { // from class: com.facebook.ads.redexgen.X.3y
            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i11) {
                return (AccessibilityNodeInfo) interfaceC10463z.A4W(i11);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i11) {
                return interfaceC10463z.A5h(str, i11);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final AccessibilityNodeInfo findFocus(int i11) {
                return (AccessibilityNodeInfo) interfaceC10463z.A5i(i11);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final boolean performAction(int i11, int i12, Bundle bundle) {
                return interfaceC10463z.ADx(i11, i12, bundle);
            }
        };
    }
}
