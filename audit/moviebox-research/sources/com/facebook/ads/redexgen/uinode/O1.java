package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.facebook.ads.RewardData;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class O1 extends FrameLayout {
    public static String[] A07 = {"Lu0oG19N", "JNY", "Ev6F9eDhg42RHlCeRuJfEtiFO07AluFn", "qSbaO4FE34QcNqD1YWxCxyT8wr5s9kWw", "hZddA1hSD7Y", "v9TnLSaOxYneacolptRVdRHaZQ0ab06L", "iyW9tyIIQvF7WQz3LOxNHXxa074IcWbN", "vzh"};
    public MB A00;
    public final AbstractC1898b5 A01;
    public final C1795Yn A02;
    public final MC A03;
    public final O0 A04;
    public final SA A05;
    public final View[] A06;

    public O1(OP op2, AbstractC1898b5 abstractC1898b5, SA sa2, KP kp2, AbstractC1514No abstractC1514No, MC mc2, O0 o11) {
        this(op2, abstractC1898b5, sa2, mc2, o11, kp2, abstractC1514No);
    }

    public O1(OP op2, AbstractC1898b5 abstractC1898b5, SA sa2, MC mc2, O0 o11, View... viewArr) {
        this(op2.A05(), op2.A08(), abstractC1898b5, sa2, mc2, o11, viewArr);
    }

    public O1(C1795Yn c1795Yn, MB mb2, AbstractC1898b5 abstractC1898b5, SA sa2, MC mc2, O0 o11, View... viewArr) {
        super(c1795Yn);
        this.A02 = c1795Yn;
        this.A00 = mb2;
        this.A01 = abstractC1898b5;
        this.A06 = viewArr;
        this.A03 = mc2;
        this.A05 = sa2;
        this.A04 = o11;
        A03();
    }

    private void A03() {
        RewardData rewardDataA0J = this.A01.A0J();
        MQ mq2 = new MQ(this.A02, -1, ViewCompat.MEASURED_STATE_MASK, rewardDataA0J == null ? this.A01.A0z().A05() : this.A01.A0z().A06(rewardDataA0J.getCurrency(), rewardDataA0J.getQuantity()), null, this.A01.A0z().A04(), this.A01.A0z().A03(), AbstractC1471Lx.A01(EnumC1470Lw.REWARD_ICON));
        mq2.A02.setOnClickListener(new ViewOnClickListenerC1524Ny(this));
        mq2.A01.setOnClickListener(new ViewOnClickListenerC1525Nz(this));
        addView(mq2, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        SA sa2 = this.A05;
        if (sa2 != null) {
            sa2.A0a(QH.A07);
        }
        this.A04.AAh();
        if (this.A01.A0x().A0O()) {
            return;
        }
        this.A01.A15(this.A03);
    }

    public final void A07(ViewGroup viewGroup) {
        SA sa2 = this.A05;
        if (sa2 != null && !sa2.A0j()) {
            this.A05.A0f(false, false, 11);
            AbstractC1462Lo.A0N(this.A05, 4);
        }
        MB mb2 = this.A00;
        String[] strArr = A07;
        if (strArr[7].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A07[0] = "vGH3jzSu";
        if (mb2 != null) {
            AbstractC1462Lo.A0H(mb2);
        }
        for (View view : this.A06) {
            view.clearAnimation();
            AbstractC1462Lo.A0N(view, 4);
        }
        viewGroup.addView(this, new RelativeLayout.LayoutParams(-1, -1));
        this.A04.ACC();
    }
}
