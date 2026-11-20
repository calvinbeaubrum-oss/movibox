package com.facebook.ads.redexgen.uinode;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KC implements InterfaceC1587Qj {
    public static byte[] A06;
    public static String[] A07 = {"A7BI5", "gKWOMBrJHuMwvM90e1kQxbLVjOWHbC33", "UYN9ptwwhG6kseDSIUjMW4tKOOJXD2Z7", "Ja75eMPfNEu2gmMNMrA6", "IMMQ3U1D8CAOequczoeO", "aOtgKGua3vuGYyvCOzm8c8DJStBVo0w", "j", "V23k2coZlnHKKs"};
    public ValueAnimator A00;
    public EnumC1586Qi A01 = EnumC1586Qi.A05;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    static {
        A05();
    }

    public KC(View view, int i11, int i12, int i13) {
        this.A02 = i11;
        this.A05 = view;
        this.A04 = i12;
        this.A03 = i13;
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{40, Ascii.EM, 44, 40, -9, 35, 32, 35, 38};
    }

    private void A06(int i11, int i12) {
        this.A01 = i11 == this.A04 ? EnumC1586Qi.A04 : EnumC1586Qi.A06;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt((TextView) this.A05, A04(0, 9, 82), i11, i12);
        this.A00 = objectAnimatorOfInt;
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        this.A00.setDuration(this.A02);
        this.A00.addListener(new C1593Qp(this, i11, i12));
        this.A00.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i11, int i12, boolean z11) {
        if (z11) {
            A06(i11, i12);
            return;
        }
        View view = this.A05;
        if (A07[4].length() != 20) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[7] = "Y4rCa4lywlEdVv";
        strArr[0] = "Hdg5N";
        ((TextView) view).setTextColor(i12);
        this.A01 = i12 == this.A03 ? EnumC1586Qi.A03 : EnumC1586Qi.A05;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1587Qj
    public final void A3Y(boolean z11, boolean z12) {
        A07(z12 ? this.A03 : this.A04, z12 ? this.A04 : this.A03, z11);
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
