package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ss, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1648Ss extends FrameLayout implements MD {
    public static String[] A0D = {"2Xyaln6pEv", "U0a3JqFqqkDVhXbmlhDLXicSxteMexx", "xzpI97Jg3aS17fwtqg1jZWsfReheMZxV", "0HUxaz9ggnFIA", "Uunhkc3", "kqN9", "fWeU9xYsODnan54TmlbSL1hNy6Lef7fu", "qbKhPFfRzVPGu"};
    public static final RelativeLayout.LayoutParams A0E = new RelativeLayout.LayoutParams(-1, -1);
    public boolean A00;
    public final AbstractC1898b5 A01;
    public final C11006c A02;
    public final C1795Yn A03;
    public final J2 A04;
    public final JA A05;
    public final C1454Lg A06;
    public final MB A07;
    public final MC A08;
    public final InterfaceC1483Mj A09;
    public final RE A0A;
    public final ViewOnSystemUiVisibilityChangeListenerC1449Lb A0B;
    public final RD A0C;

    public AbstractC1648Ss(C1795Yn c1795Yn, InterfaceC1483Mj interfaceC1483Mj, J2 j11, AbstractC1898b5 abstractC1898b5, C11006c c11006c, MC mc2) {
        super(c1795Yn);
        C1652Sw c1652Sw = new C1652Sw(this);
        this.A0C = c1652Sw;
        this.A06 = new C1454Lg();
        this.A00 = false;
        this.A03 = c1795Yn;
        this.A09 = interfaceC1483Mj;
        this.A04 = j11;
        this.A01 = abstractC1898b5;
        this.A02 = c11006c;
        this.A08 = mc2;
        this.A05 = new JA(abstractC1898b5.A12(), j11);
        RE re2 = new RE(this, 1, new WeakReference(c1652Sw), c1795Yn);
        this.A0A = re2;
        re2.A0W(abstractC1898b5.A0C());
        re2.A0X(abstractC1898b5.A0D());
        this.A07 = A0N();
        ViewOnSystemUiVisibilityChangeListenerC1449Lb viewOnSystemUiVisibilityChangeListenerC1449Lb = new ViewOnSystemUiVisibilityChangeListenerC1449Lb(this);
        this.A0B = viewOnSystemUiVisibilityChangeListenerC1449Lb;
        viewOnSystemUiVisibilityChangeListenerC1449Lb.A05(EnumC1448La.A03);
    }

    private FullScreenAdToolbar A0N() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A03, this.A08, this.A05, 1, this.A01.A0r());
        fullScreenAdToolbar.setFullscreen(true);
        int iA03 = this.A01.A0x().A0D().A03();
        fullScreenAdToolbar.setPageDetails(this.A01.A10(), this.A01.A12(), iA03, this.A01.A11());
        fullScreenAdToolbar.A06(this.A01.A0w().A01(), ViewOnClickListenerC1667Tl.A08(this.A01));
        if (iA03 < 0) {
            C1G c1gA0x = this.A01.A0x();
            if (A0D[4].length() == 31) {
                throw new RuntimeException();
            }
            A0D[5] = "3phQ";
            if (c1gA0x.A0M()) {
                fullScreenAdToolbar.setToolbarActionMode(4);
            }
        }
        fullScreenAdToolbar.setToolbarListener(new C1649St(this));
        return fullScreenAdToolbar;
    }

    private void A0O() {
        if (!this.A01.A0x().A0P()) {
            A0Q();
            return;
        }
        C1558Pg c1558PgA0B = new C1556Pe(this.A03, this.A01.A0x().A0E(), this.A01.A10()).A08(this.A01.A0w().A01()).A0B();
        JC.A04(c1558PgA0B, this.A05, J9.A0U);
        addView(c1558PgA0B, A0E);
        c1558PgA0B.A04(new C1650Su(this));
    }

    public final void A0P() {
        if (this.A00) {
            return;
        }
        this.A0A.A0U();
        this.A00 = true;
    }

    public abstract void A0Q();

    public final void A0R(int i11, KT kt2) {
        new L9(i11, new C1651Sv(this, i11, kt2)).A07();
    }

    public abstract void A0S(C5V c5v);

    public abstract boolean A0T();

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void A9Q(Intent intent, Bundle bundle, C5V c5v) {
        this.A08.A3U(this, A0E);
        A0S(c5v);
        A0O();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void AFT(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public String getCurrentClientToken() {
        return this.A01.A12();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final boolean onActivityResult(int i11, int i12, Intent intent) {
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        this.A0B.A03();
        if (TextUtils.isEmpty(this.A01.A12())) {
            return;
        }
        this.A04.A9X(this.A01.A12(), new C1508Ni().A03(this.A0A).A02(this.A06).A05());
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A06.A06(this.A03, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(MC mc2) {
    }

    public void setUpFullscreenMode(boolean z11) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.A0B.A05(z11 ? EnumC1448La.A04 : EnumC1448La.A03);
    }
}
