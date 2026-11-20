package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class UL extends RelativeLayout implements MD {
    public static byte[] A0F;
    public static String[] A0G = {"fqT9snXDZkE2N6bIU2twhbCcrvrF5wQR", "W8MK3buqarkLhDixdfnbfGeXuw3i87xB", "M5iWaw3OwwKxChS5bTa9KUrj63pwu1Od", "QKu8TlGQ3D7NsDDaY", "OUnrWL6BanKvWJF", "644mHU9zQQHAcSiNB", "MqQzuM0GD0HqxOL2854PPJvoiao7nama", "mSpdOD621tCilusEUOf234Jx9LR3KzyX"};
    public View A00;
    public L9 A01;
    public C1558Pg A02;
    public boolean A03;
    public boolean A04;
    public C1C A05;
    public Q7 A06;
    public boolean A07;
    public final ViewOnSystemUiVisibilityChangeListenerC1449Lb A08;
    public final MC A09;
    public final AbstractC1898b5 A0A;
    public final C1795Yn A0B;
    public final J2 A0C;
    public final JA A0D;
    public final MB A0E;

    static {
        A0O();
    }

    public UL(C1795Yn c1795Yn, J2 j11, MC mc2, AbstractC1898b5 abstractC1898b5) {
        super(c1795Yn);
        this.A07 = false;
        this.A04 = false;
        this.A03 = false;
        this.A0B = c1795Yn;
        this.A0C = j11;
        this.A09 = mc2;
        this.A08 = new ViewOnSystemUiVisibilityChangeListenerC1449Lb(this);
        this.A0A = abstractC1898b5;
        JA ja2 = new JA(abstractC1898b5.A12(), j11);
        this.A0D = ja2;
        this.A0E = new FullScreenAdToolbar(c1795Yn, getAudienceNetworkListener(), ja2, 0, abstractC1898b5.A0r());
    }

    private C1P A0J(int i11) {
        if (i11 == 1) {
            return this.A05.A01();
        }
        C1C c1c = this.A05;
        if (A0G[2].charAt(7) != 'O') {
            throw new RuntimeException();
        }
        A0G[0] = "MYlveE6g4wScBr3MsnlZwbj0w3RA4Q0m";
        return c1c.A00();
    }

    public static String A0L(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    private void A0M() {
        removeAllViews();
        AbstractC1462Lo.A0J(this);
    }

    private void A0N() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (!A0X() || this.A02 != null) {
            this.A09.A3T(this, 0, layoutParams);
            return;
        }
        this.A04 = true;
        C1558Pg c1558PgA0B = new C1556Pe(this.A0B, this.A0A.A0x().A0E(), this.A0A.A10()).A08(this.A0A.A0w().A01()).A0B();
        this.A02 = c1558PgA0B;
        JC.A04(c1558PgA0B, this.A0D, J9.A0U);
        this.A09.A3T(this, 0, layoutParams);
        this.A09.A3T(this.A02, 1, layoutParams);
        this.A02.A04(new UN(this));
    }

    public static void A0O() {
        A0F = new byte[]{88, 84, 86, Ascii.NAK, 93, 90, 88, 94, 89, 84, 84, 80, Ascii.NAK, 90, 95, 72, Ascii.NAK, 82, 85, 79, 94, 73, 72, 79, 82, 79, 82, 90, 87, Ascii.NAK, 82, 86, 75, 73, 94, 72, 72, 82, 84, 85, Ascii.NAK, 87, 84, 92, 92, 94, 95};
    }

    private void A0P(C1P c1p, boolean z11) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0E.getToolbarHeight());
        layoutParams.addRule(10);
        this.A0E.A06(c1p, ViewOnClickListenerC1667Tl.A08(this.A0A));
        addView(this.A0E, layoutParams);
    }

    public final void A0S() {
        View view = this.A00;
        if (view == null || !(view instanceof OL)) {
            return;
        }
        if (A0Y()) {
            ((OL) this.A00).A0z();
        } else {
            ((OL) this.A00).A0y();
        }
    }

    public final void A0T(int i11) {
        this.A01 = new L9(i11, new UM(this, i11));
        this.A03 = true;
        A0S();
        this.A01.A07();
    }

    public final void A0U(View view, boolean z11, int i11) {
        this.A0E.setFullscreen(z11);
        this.A00 = view;
        this.A08.A05(EnumC1448La.A03);
        A0M();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, z11 ? 0 : this.A0E.getToolbarHeight(), 0, 0);
        layoutParams.addRule(12);
        addView(view, layoutParams);
        C1P c1pA0J = A0J(i11);
        A0P(c1pA0J, z11);
        AbstractC1462Lo.A0M(this, c1pA0J.A07(false));
        if (this.A09 != null) {
            A0N();
            String[] strArr = A0G;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A0G[0] = "NsWlVTe7e8AxmZfep9MsD1WsEVvEb3lR";
            if (!z11 || Build.VERSION.SDK_INT < 19) {
                return;
            }
            ViewOnSystemUiVisibilityChangeListenerC1449Lb viewOnSystemUiVisibilityChangeListenerC1449Lb = this.A08;
            if (A0G[0].charAt(10) == 'o') {
                throw new RuntimeException();
            }
            A0G[2] = "LlUUcmlOaTawHlOzciUSj9DhXPbTXBAe";
            viewOnSystemUiVisibilityChangeListenerC1449Lb.A05(EnumC1448La.A04);
        }
    }

    public final void A0V(C5V c5v) {
        this.A08.A04(c5v.A0J().getWindow());
        this.A05 = this.A0A.A0w();
        C1G c1gA0x = null;
        if (this.A0A.A0x() != null && this.A0A.A0x() != null) {
            c1gA0x = this.A0A.A0x();
        }
        this.A0E.setPageDetails(this.A0A.A10(), this.A0A.A12(), c1gA0x != null ? c1gA0x.A0D().A03() : 0, this.A0A.A11());
        this.A0E.setToolbarListener(new UP(this, c5v));
    }

    public final void A0W(C5V c5v) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setAnimationListener(new MO(this, this, c5v));
        startAnimation(alphaAnimation);
    }

    public final boolean A0X() {
        if (!this.A0A.A14().isEmpty()) {
            boolean zA0P = this.A0A.A0x().A0P();
            if (A0G[6].charAt(3) != 'z') {
                throw new RuntimeException();
            }
            A0G[2] = "rwsNokIOLx9Fj0KMvDMbhHWjcozH5rOe";
            if (zA0P) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0Y() {
        return this.A03;
    }

    public final boolean A0Z() {
        return this.A04;
    }

    public abstract boolean A0a();

    public void ACW(boolean z11) {
        L9 l11 = this.A01;
        if (l11 == null || !l11.A05()) {
            return;
        }
        this.A01.A06();
    }

    public void ACu(boolean z11) {
        L9 l11 = this.A01;
        if (l11 == null || l11.A04()) {
            return;
        }
        this.A01.A07();
    }

    public J2 getAdEventManager() {
        return this.A0C;
    }

    public MC getAudienceNetworkListener() {
        return this.A09;
    }

    public abstract int getCloseButtonStyle();

    @Override // com.facebook.ads.redexgen.uinode.MD
    public String getCurrentClientToken() {
        return this.A0A.A12();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final boolean onActivityResult(int i11, int i12, Intent intent) {
        return false;
    }

    public void onDestroy() {
        this.A08.A03();
        this.A0E.setToolbarListener(null);
        A0M();
    }

    public void setImpressionRecordingFlag(C1454Lg c1454Lg) {
        c1454Lg.A05();
        if (getAudienceNetworkListener() != null) {
            if (this.A07) {
                getAudienceNetworkListener().A43(new U8().A7B());
            } else {
                getAudienceNetworkListener().A43(A0L(0, 47, 106));
            }
        }
    }

    public void setListener(MC mc2) {
    }

    public void setServerSideRewardHandler(Q7 q11) {
        this.A06 = q11;
    }
}
