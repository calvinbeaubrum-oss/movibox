package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1m, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C09821m extends C09972b {
    @Override // com.facebook.ads.redexgen.uinode.C3S
    public final C10323k A08(View view, C10323k c10323k) {
        WindowInsets windowInsets = (WindowInsets) C10323k.A01(c10323k);
        WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (windowInsetsDispatchApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(windowInsetsDispatchApplyWindowInsets);
        }
        return C10323k.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.uinode.C3S
    public final C10323k A09(View view, C10323k c10323k) {
        WindowInsets windowInsets = (WindowInsets) C10323k.A01(c10323k);
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (windowInsetsOnApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(windowInsetsOnApplyWindowInsets);
        }
        return C10323k.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.uinode.C3S
    public final void A0B(View view) {
        view.stopNestedScroll();
    }

    @Override // com.facebook.ads.redexgen.uinode.C3S
    public final void A0F(View view, final C3D c3d) {
        if (c3d == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.facebook.ads.redexgen.X.3R
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    return (WindowInsets) C10323k.A01(c3d.AAk(view2, C10323k.A00(windowInsets)));
                }
            });
        }
    }
}
