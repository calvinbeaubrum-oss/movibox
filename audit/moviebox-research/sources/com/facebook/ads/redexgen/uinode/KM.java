package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KM implements InterfaceC1587Qj {
    public TransitionDrawable A00;
    public TransitionDrawable A01;
    public final int A03;
    public final Drawable A04;
    public final Drawable A05;
    public final View A07;
    public final Handler A06 = new Handler();
    public EnumC1586Qi A02 = EnumC1586Qi.A05;

    public KM(View view, int i11, Drawable drawable, Drawable drawable2) {
        this.A03 = i11;
        this.A07 = view;
        this.A05 = drawable;
        this.A04 = drawable2;
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable, drawable2});
        this.A01 = transitionDrawable;
        transitionDrawable.setCrossFadeEnabled(true);
        TransitionDrawable transitionDrawable2 = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        this.A00 = transitionDrawable2;
        transitionDrawable2.setCrossFadeEnabled(true);
        AbstractC1462Lo.A0S(view, this.A01);
    }

    private void A04(boolean z11) {
        this.A06.removeCallbacksAndMessages(null);
        if (!z11) {
            AbstractC1462Lo.A0S(this.A07, this.A05);
            this.A02 = EnumC1586Qi.A05;
        } else {
            this.A02 = EnumC1586Qi.A06;
            AbstractC1462Lo.A0S(this.A07, this.A00);
            this.A00.startTransition(this.A03);
            this.A06.postDelayed(new KN(this), this.A03);
        }
    }

    private void A05(boolean z11) {
        this.A06.removeCallbacksAndMessages(null);
        if (!z11) {
            AbstractC1462Lo.A0S(this.A07, this.A04);
            this.A02 = EnumC1586Qi.A03;
        } else {
            this.A02 = EnumC1586Qi.A04;
            AbstractC1462Lo.A0S(this.A07, this.A01);
            this.A01.startTransition(this.A03);
            this.A06.postDelayed(new KO(this), this.A03);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final void A3Y(boolean z11, boolean z12) {
        if (z12) {
            A04(z11);
        } else {
            A05(z11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final EnumC1586Qi A82() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final void cancel() {
        this.A06.removeCallbacksAndMessages(null);
        this.A01.resetTransition();
        this.A00.resetTransition();
        this.A02 = this.A02 == EnumC1586Qi.A04 ? EnumC1586Qi.A05 : EnumC1586Qi.A03;
    }
}
