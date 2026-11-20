package com.facebook.ads.redexgen.uinode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class OL extends RelativeLayout {
    public static final int A07 = (int) (LD.A02 * 16.0f);
    public static final int A08 = (int) (LD.A02 * 28.0f);
    public C1P A00;
    public boolean A01;
    public final C1795Yn A02;
    public final J2 A03;
    public final ViewOnClickListenerC1667Tl A04;
    public final O9 A05;
    public final OP A06;

    public OL(OP op2, boolean z11) {
        super(op2.A05());
        this.A06 = op2;
        C1795Yn c1795YnA05 = op2.A05();
        this.A02 = c1795YnA05;
        this.A03 = op2.A06();
        this.A00 = op2.A00() == 1 ? op2.A04().A0w().A01() : op2.A04().A0w().A00();
        this.A01 = z11;
        ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl = new ViewOnClickListenerC1667Tl(op2.A05(), op2.A04(), this.A00, op2.A06(), op2.A09(), op2.A0B(), op2.A07());
        this.A04 = viewOnClickListenerC1667Tl;
        viewOnClickListenerC1667Tl.setRoundedCornersEnabled(A00());
        viewOnClickListenerC1667Tl.setViewShowsOverMedia(A0D());
        AbstractC1462Lo.A0G(1001, viewOnClickListenerC1667Tl);
        O9 o11 = new O9(c1795YnA05, this.A00, this.A01, A01(), A02());
        this.A05 = o11;
        AbstractC1462Lo.A0K(o11);
    }

    public boolean A00() {
        return true;
    }

    public boolean A01() {
        return true;
    }

    public boolean A02() {
        return true;
    }

    public void A0B(C9H c9h) {
    }

    public void A0C(AnonymousClass93 anonymousClass93) {
    }

    public boolean A0D() {
        return true;
    }

    public void A0v() {
    }

    public void A0w() {
    }

    public void A0x() {
    }

    public void A0y() {
    }

    public void A0z() {
    }

    public void A10(C1G c1g, String str, double d11, Bundle bundle) {
        this.A05.A03(c1g.A0E().A05(), c1g.A0E().A01(), null, false, !A11() && d11 > 0.0d && d11 < 1.0d);
        this.A04.setCta(c1g.A0F(), str, new HashMap());
    }

    public abstract boolean A11();

    public boolean A12(boolean z11) {
        return false;
    }

    public C1795Yn getAdContextWrapper() {
        return this.A02;
    }

    public J2 getAdEventManager() {
        return this.A03;
    }

    public int getCloseButtonStyle() {
        return 0;
    }

    public C1P getColors() {
        return this.A00;
    }

    public ViewOnClickListenerC1667Tl getCtaButton() {
        return this.A04;
    }

    public O9 getTitleDescContainer() {
        return this.A05;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.A00 = configuration.orientation == 1 ? this.A06.A04().A0w().A01() : this.A06.A04().A0w().A00();
        this.A04.setViewShowsOverMedia(A0D());
        this.A04.setUpButtonColors(this.A00);
        this.A05.A02(this.A00, this.A01);
    }
}
