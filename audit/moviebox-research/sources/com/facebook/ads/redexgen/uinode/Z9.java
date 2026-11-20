package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Z9 implements InterfaceC10865o {
    public final /* synthetic */ ImageView A00;
    public final /* synthetic */ C10885q A01;
    public final /* synthetic */ V2 A02;

    public Z9(C10885q c10885q, ImageView imageView, V2 v11) {
        this.A01 = c10885q;
        this.A00 = imageView;
        this.A02 = v11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10865o
    public final void ABi(Drawable drawable) {
        V2.A0e(drawable, this.A00);
        this.A02.A1J(drawable);
    }
}
