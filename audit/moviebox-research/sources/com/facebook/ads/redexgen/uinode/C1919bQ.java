package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1919bQ implements P0 {
    public final /* synthetic */ C1916bN A00;

    public C1919bQ(C1916bN c1916bN) {
        this.A00 = c1916bN;
    }

    @Override // com.facebook.ads.redexgen.uinode.P0
    public final void A9L() {
        String strA00 = this.A00.A03.A10().A00();
        if (TextUtils.isEmpty(strA00)) {
            return;
        }
        C1443Kv.A0M(new C1443Kv(), this.A00.A04, AbstractC1446Ky.A00(strA00), this.A00.A6T());
    }

    @Override // com.facebook.ads.redexgen.uinode.P0
    public final void ABO(B0 b11) {
        new Handler(Looper.getMainLooper()).postDelayed(new C1920bR(this, b11), 1L);
    }

    @Override // com.facebook.ads.redexgen.uinode.P0
    public final void ABd() {
    }

    @Override // com.facebook.ads.redexgen.uinode.P0
    public final void ADL(View view, MotionEvent motionEvent) {
    }
}
