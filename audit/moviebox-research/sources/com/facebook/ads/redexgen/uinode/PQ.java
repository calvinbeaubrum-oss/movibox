package com.facebook.ads.redexgen.uinode;

import android.content.res.Configuration;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class PQ extends RelativeLayout {
    public boolean A00;
    public final int A01;
    public final RD A02;
    public final boolean A03;
    public final boolean A04;
    public final AbstractC1898b5 A05;
    public final C1795Yn A06;
    public final J2 A07;
    public final C1454Lg A08;
    public final MC A09;
    public final InterfaceC1483Mj A0A;
    public final RE A0B;

    public PQ(C1795Yn c1795Yn, InterfaceC1483Mj interfaceC1483Mj, J2 j11, AbstractC1898b5 abstractC1898b5, int i11, boolean z11, boolean z12, MC mc2) {
        super(c1795Yn);
        this.A08 = new C1454Lg();
        this.A00 = false;
        TB tb2 = new TB(this);
        this.A02 = tb2;
        this.A01 = i11;
        this.A06 = c1795Yn;
        this.A04 = z11;
        this.A03 = z12;
        this.A09 = mc2;
        this.A0A = interfaceC1483Mj;
        this.A05 = abstractC1898b5;
        this.A07 = j11;
        RE re2 = new RE(this, 1, new WeakReference(tb2), c1795Yn);
        this.A0B = re2;
        re2.A0W(abstractC1898b5.A0C());
        re2.A0X(abstractC1898b5.A0D());
    }

    public final void A03() {
        if (this.A00) {
            return;
        }
        this.A0B.A0U();
        this.A00 = true;
    }

    public abstract void A0z();

    public abstract void A10();

    public abstract void A11();

    public abstract void A12(boolean z11);

    public abstract void A13(boolean z11);

    public abstract boolean A14();

    public abstract boolean A15();

    public AbstractC1898b5 getAdDataBundle() {
        return this.A05;
    }

    public RE getAdViewabilityChecker() {
        return this.A0B;
    }

    public abstract C1554Pc getFullScreenAdStyle();

    public C1454Lg getTouchDataRecorder() {
        return this.A08;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
