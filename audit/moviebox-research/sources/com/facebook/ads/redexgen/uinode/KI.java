package com.facebook.ads.redexgen.uinode;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KI implements InterfaceC1587Qj {
    public int A00;
    public ValueAnimator A01;
    public EnumC1586Qi A02 = EnumC1586Qi.A05;
    public final int A03;
    public final int A04;
    public final View A05;

    public KI(View view, int i11, int i12, int i13) {
        this.A05 = view;
        this.A03 = i11;
        this.A00 = i12;
        this.A04 = i13;
    }

    private ValueAnimator A00(int i11, int i12, View view) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i11, i12);
        valueAnimatorOfInt.setDuration(this.A03);
        valueAnimatorOfInt.addUpdateListener(new C1590Qm(this, view));
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(boolean z11) {
        if (z11) {
            this.A02 = EnumC1586Qi.A06;
            ValueAnimator valueAnimatorA00 = A00(this.A00, this.A04, this.A05);
            this.A01 = valueAnimatorA00;
            valueAnimatorA00.addListener(new C1589Ql(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A04;
        this.A05.setLayoutParams(layoutParams);
        AbstractC1462Lo.A0H(this.A05);
        this.A02 = EnumC1586Qi.A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z11) {
        AbstractC1462Lo.A0L(this.A05);
        if (!z11) {
            ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
            layoutParams.height = this.A00;
            this.A05.setLayoutParams(layoutParams);
            this.A02 = EnumC1586Qi.A03;
            return;
        }
        this.A02 = EnumC1586Qi.A04;
        ValueAnimator valueAnimatorA00 = A00(this.A04, this.A00, this.A05);
        this.A01 = valueAnimatorA00;
        valueAnimatorA00.addListener(new C1588Qk(this));
        this.A01.start();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final void A3Y(boolean z11, boolean z12) {
        if (z12) {
            A07(z11);
        } else {
            A08(z11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final EnumC1586Qi A82() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final void cancel() {
        ValueAnimator valueAnimator = this.A01;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
