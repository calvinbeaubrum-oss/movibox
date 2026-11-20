package com.facebook.ads.redexgen.uinode;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1832a0 implements C3D {
    public final Rect A00 = new Rect();
    public final /* synthetic */ C10293h A01;

    public C1832a0(C10293h c10293h) {
        this.A01 = c10293h;
    }

    @Override // com.facebook.ads.redexgen.uinode.C3D
    public final C10323k AAk(View view, C10323k c10323k) {
        C10323k c10323kA06 = C3T.A06(view, c10323k);
        if (c10323kA06.A07()) {
            return c10323kA06;
        }
        Rect rect = this.A00;
        rect.left = c10323kA06.A03();
        rect.top = c10323kA06.A05();
        rect.right = c10323kA06.A04();
        rect.bottom = c10323kA06.A02();
        int childCount = this.A01.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            C10323k c10323kA05 = C3T.A05(this.A01.getChildAt(i11), c10323kA06);
            rect.left = Math.min(c10323kA05.A03(), rect.left);
            rect.top = Math.min(c10323kA05.A05(), rect.top);
            rect.right = Math.min(c10323kA05.A04(), rect.right);
            rect.bottom = Math.min(c10323kA05.A02(), rect.bottom);
        }
        return c10323kA06.A06(rect.left, rect.top, rect.right, rect.bottom);
    }
}
