package com.facebook.ads.redexgen.uinode;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1569Pr extends FrameLayout {
    public static final int A08 = (int) (LD.A02 * 16.0f);
    public BZ A00;
    public SF A01;
    public C9I A02;
    public C1444Kw A03;
    public C7R A04;
    public C7C A05;
    public final C1795Yn A06;
    public final JA A07;

    public C1569Pr(C1795Yn c1795Yn, JA ja2) {
        super(c1795Yn);
        this.A07 = ja2;
        this.A06 = c1795Yn;
        setUpView(c1795Yn);
    }

    private void setUpPlugins(C1795Yn c1795Yn) {
        this.A00.A0X();
        C7R c7r = new C7R(c1795Yn);
        this.A04 = c7r;
        this.A00.A0c(c7r);
        this.A03 = new C1444Kw(c1795Yn, this.A07);
        this.A00.A0c(new AnonymousClass86(c1795Yn));
        this.A00.A0c(this.A03);
        C7C c7c = new C7C(c1795Yn, true, this.A07);
        this.A05 = c7c;
        this.A00.A0c(c7c);
        this.A00.A0c(new L7(this.A05, QZ.A03, true, true));
        if (this.A00.A0g()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i11 = A08;
            layoutParams.setMargins(i11, i11, i11, i11);
            this.A03.setLayoutParams(layoutParams);
            this.A00.addView(this.A03);
        }
    }

    private void setUpVideo(C1795Yn c1795Yn) {
        BZ bz2 = new BZ(c1795Yn);
        this.A00 = bz2;
        bz2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        AbstractC1462Lo.A0K(this.A00);
        addView(this.A00);
        setOnClickListener(new ViewOnClickListenerC1568Pq(this));
    }

    private void setUpView(C1795Yn c1795Yn) {
        setUpVideo(c1795Yn);
        setUpPlugins(c1795Yn);
    }

    public final void A01() {
        this.A00.A0e(true, 10);
    }

    public final void A02() {
        SF sf2 = this.A01;
        if (sf2 != null) {
            sf2.A0C();
            this.A01 = null;
        }
        C9I c9i = this.A02;
        if (c9i != null) {
            c9i.A0i();
            this.A02 = null;
        }
    }

    public final void A03(AbstractC11578s abstractC11578s) {
        this.A00.getEventBus().A05(abstractC11578s);
    }

    public final void A04(J2 j11, String str, Map<String, String> map) {
        A02();
        this.A02 = new C9I(this.A06, j11, this.A00, str, map);
        if (C1384Ih.A1X(this.A06)) {
            this.A01 = new SF(this.A06, j11, this.A00, str, this.A02, map);
        } else {
            this.A01 = null;
        }
    }

    public final void A05(QM qm2) {
        this.A00.A0b(qm2, 13);
    }

    public final boolean A06() {
        return this.A00.A0k();
    }

    public SA getSimpleVideoView() {
        return this.A00;
    }

    public float getVolume() {
        return this.A00.getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.A04.setImage(str);
    }

    public void setVideoURI(String str) {
        this.A00.setVideoURI(str);
    }

    public void setVolume(float f11) {
        this.A00.setVolume(f11);
        this.A03.A09();
    }
}
