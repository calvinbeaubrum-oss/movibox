package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3m, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10343m {
    public static final C10333l A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A00 = new C1290En();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A00 = new C1829Zw();
        } else {
            A00 = new C10333l();
        }
    }

    public static int A00(AccessibilityEvent accessibilityEvent) {
        return A00.A00(accessibilityEvent);
    }

    public static void A01(AccessibilityEvent accessibilityEvent, int i11) {
        A00.A01(accessibilityEvent, i11);
    }
}
