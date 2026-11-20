package com.facebook.ads.redexgen.uinode;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KA implements InterfaceC1587Qj {
    public static String[] A06 = {"Zp1jBMTXyTngXAjRlLP1q6RZbaUI", "nHljDkT3i8Wirocu51jroGsoJHOhv1cR", "sP6X6aS", "KZL6M4", "KoOjzqZIxieUbLbPf8D", "B1jmqrSafv9jI6Lw73IRSYcL6IlnF6YH", "FLN3m70EKIfdw8", "ppmNyXlbfQKy53gkSU0tUatt7Y3PBdXb"};
    public ValueAnimator A00;
    public EnumC1586Qi A01 = EnumC1586Qi.A05;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    public KA(View view, int i11, int i12, int i13) {
        this.A05 = view;
        this.A02 = i11;
        this.A04 = i12;
        this.A03 = i13;
    }

    private ValueAnimator A00(View view, int i11, int i12) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i11, i12);
        valueAnimatorOfInt.setDuration(this.A02);
        valueAnimatorOfInt.addUpdateListener(new C1596Qs(this, view));
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        ValueAnimator valueAnimator = this.A00;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            if (A06[1].charAt(28) != 'v') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[7] = "75AaLozsvbqC7RPKNa9MBDOQqsQ1eQ5U";
            strArr[5] = "oWQ9IgFva7oIaP1s8z2NxAvwjcynmKEe";
            this.A00 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z11) {
        if (!z11) {
            this.A05.setTranslationY(this.A04);
            AbstractC1462Lo.A0H(this.A05);
            this.A01 = EnumC1586Qi.A05;
        } else {
            this.A01 = EnumC1586Qi.A06;
            ValueAnimator valueAnimatorA00 = A00(this.A05, this.A03, this.A04);
            this.A00 = valueAnimatorA00;
            valueAnimatorA00.addListener(new C1595Qr(this));
            this.A00.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z11) {
        AbstractC1462Lo.A0L(this.A05);
        if (z11) {
            this.A01 = EnumC1586Qi.A04;
            ValueAnimator valueAnimatorA00 = A00(this.A05, this.A04, this.A03);
            this.A00 = valueAnimatorA00;
            valueAnimatorA00.addListener(new C1594Qq(this));
            this.A00.start();
            return;
        }
        View view = this.A05;
        if (A06[1].charAt(28) != 'v') {
            throw new RuntimeException();
        }
        A06[4] = "CRQ3If4kF9c";
        view.setTranslationY(this.A03);
        this.A01 = EnumC1586Qi.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final void A3Y(boolean z11, boolean z12) {
        if (z12) {
            A08(z11);
        } else {
            A09(z11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final EnumC1586Qi A82() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final void cancel() {
        ValueAnimator valueAnimator = this.A00;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
