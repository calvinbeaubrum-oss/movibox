package com.facebook.ads.redexgen.uinode;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9Y, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9Y extends AbstractC1648Ss {
    public OL A00;
    public final ImageView A01;
    public final C5T A02;
    public final AtomicBoolean A03;
    public final AtomicBoolean A04;
    public final AtomicBoolean A05;

    public C9Y(C1795Yn c1795Yn, InterfaceC1483Mj interfaceC1483Mj, J2 j11, AbstractC1898b5 abstractC1898b5, C11006c c11006c, MC mc2) {
        super(c1795Yn, interfaceC1483Mj, j11, abstractC1898b5, c11006c, mc2);
        this.A02 = new C1643Sn(this);
        this.A04 = new AtomicBoolean(false);
        this.A03 = new AtomicBoolean(false);
        this.A05 = new AtomicBoolean(false);
        ImageView imageView = new ImageView(getContext());
        this.A01 = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        new AsyncTaskC1672Tq(imageView, super.A03).A05(super.A01.A0x().A0D().A00(), super.A01.A0x().A0D().A01()).A06(new C1642Sm(this)).A07(super.A01.A0x().A0D().A07());
    }

    private OL A01(int i11) {
        if (this.A01.getParent() != null) {
            AbstractC1462Lo.A0J(this.A01);
        }
        return OM.A00(new OO(super.A03, super.A04, this.A08, super.A01, this.A01, this.A0A, this.A06).A0E(this.A07.getToolbarHeight()).A0H(this.A07).A0D(i11).A0K(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A04.get() && this.A03.get()) {
            A0P();
        }
    }

    private void A06(int i11) {
        AbstractC1462Lo.A0J(this.A00);
        OL olA01 = A01(i11);
        this.A00 = olA01;
        C1P colors = olA01.getColors();
        OL ol2 = this.A00;
        AbstractC1462Lo.A0M(this, colors.A07(ol2 != null && (ol2.A11() || (this.A00 instanceof AbstractC1662Tg))));
        this.A07.setFullscreen(this.A00.A11());
        this.A07.A06(colors, ViewOnClickListenerC1667Tl.A08(super.A01));
        addView(this.A00, 0, AbstractC1648Ss.A0E);
        OL ol3 = this.A00;
        setUpFullscreenMode(ol3 != null && ol3.A11());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCloseButtonStyle() {
        OL ol2 = this.A00;
        if (ol2 != null) {
            return ol2.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1648Ss
    public final void A0Q() {
        AbstractC1462Lo.A0L(this.A00);
        AbstractC1462Lo.A0L(this.A07);
        this.A03.set(true);
        A05();
        int iA03 = super.A01.A0x().A0D().A03();
        if (iA03 <= 0) {
            this.A05.set(true);
            this.A07.setToolbarActionMode(getCloseButtonStyle());
        } else {
            OL ol2 = this.A00;
            if (ol2 != null) {
                ol2.A0z();
            }
            A0R(iA03, new C1641Sl(this));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1648Ss
    public final void A0S(C5V c5v) {
        c5v.A0N(this.A02);
        A06(c5v.A0J().getResources().getConfiguration().orientation);
        addView(this.A07, new FrameLayout.LayoutParams(-1, this.A07.getToolbarHeight()));
        AbstractC1462Lo.A0H(this.A00);
        AbstractC1462Lo.A0H(this.A07);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1648Ss
    public final boolean A0T() {
        OL ol2 = this.A00;
        return ol2 != null && ol2.A12(false);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACW(boolean z11) {
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACu(boolean z11) {
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1648Ss, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (super.A01.A0x().A0N()) {
            return;
        }
        A06(configuration.orientation);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1648Ss, com.facebook.ads.redexgen.uinode.MD
    public final void onDestroy() {
        if (C1384Ih.A1W(super.A03)) {
            super.A03.A0A().AGk(this.A01);
        }
        OL ol2 = this.A00;
        if (ol2 != null) {
            ol2.A0v();
        }
        super.onDestroy();
    }
}
