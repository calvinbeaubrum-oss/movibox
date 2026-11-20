package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10453x {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.3v] */
    public static C10433v A00(final InterfaceC10443w interfaceC10443w) {
        return new AccessibilityNodeProvider() { // from class: com.facebook.ads.redexgen.X.3v
            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i11) {
                return (AccessibilityNodeInfo) interfaceC10443w.A4W(i11);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i11) {
                return interfaceC10443w.A5h(str, i11);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final boolean performAction(int i11, int i12, Bundle bundle) {
                return interfaceC10443w.ADx(i11, i12, bundle);
            }
        };
    }
}
