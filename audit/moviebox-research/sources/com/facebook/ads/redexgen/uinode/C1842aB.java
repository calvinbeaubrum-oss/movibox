package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1842aB implements InterfaceC10012f {
    public Drawable A00;
    public final /* synthetic */ AbstractC10002e A01;

    public C1842aB(AbstractC10002e abstractC10002e) {
        this.A01 = abstractC10002e;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10012f
    public final Drawable A6J() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10012f
    public final AbstractC10002e A6K() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10012f
    public final boolean A7l() {
        return this.A01.getPreventCornerOverlap();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10012f
    public final boolean A8G() {
        return this.A01.getUseCompatPadding();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10012f
    public final void AFu(Drawable drawable) {
        this.A00 = drawable;
        this.A01.setBackgroundDrawable(drawable);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10012f
    public final void AG7(int i11, int i12) {
        if (i11 > this.A01.A01) {
            super/*android.widget.FrameLayout*/.setMinimumWidth(i11);
        }
        if (i12 > this.A01.A00) {
            super/*android.widget.FrameLayout*/.setMinimumHeight(i12);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10012f
    public final void AGE(int i11, int i12, int i13, int i14) {
        this.A01.A05.set(i11, i12, i13, i14);
        AbstractC10002e abstractC10002e = this.A01;
        super/*android.widget.FrameLayout*/.setPadding(abstractC10002e.A04.left + i11, this.A01.A04.top + i12, this.A01.A04.right + i13, this.A01.A04.bottom + i14);
    }
}
