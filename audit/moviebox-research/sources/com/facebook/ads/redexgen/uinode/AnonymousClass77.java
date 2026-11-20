package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.77, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass77 extends AbstractC1683Ub<RE> implements InterfaceC11197b {
    public static String[] A02 = {"iVby5wy6H7l4dzY0Hld0xs9tuHtnGk", "Nr0U5YnFPaRVMsCPPiWFbDdqiRS3TX59", "NmHEOi9mcJk9OQjZmIqLk3AYwOx5ICK3", "j6OxXppfxNxejmkkIb10P2S2ED13bfax", "YxA", "okdCTGqDBxOQkU", "XAA3rxsPdfTGxXL8JCFSxOB2RupP9g", "Mu"};
    public C1795Yn A00;
    public boolean A01;

    public AnonymousClass77(RE re2, C1795Yn c1795Yn) {
        super(re2);
        this.A00 = c1795Yn;
        this.A01 = false;
    }

    private void A00(int i11) {
        if (!this.A01) {
            this.A00.A0E().A3K(i11);
        }
        String[] strArr = A02;
        if (strArr[0].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        A02[1] = "k6Oe58jhR2JQ133LIP7LsY5lW6eco9l5";
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        RE reA07 = A07();
        if (reA07 == null) {
            A00(0);
            return;
        }
        View view = reA07.A0C;
        RD rd2 = (RD) reA07.A0E.get();
        boolean z11 = view == null;
        if (z11 || rd2 == null) {
            if (reA07.A07) {
                A00(z11 ? 1 : 2);
                return;
            }
            return;
        }
        RF rfA0E = RE.A0E(view, reA07.A0A, this.A00);
        if (rfA0E.A04()) {
            RE.A05(reA07);
        } else {
            reA07.A00 = 0;
        }
        boolean z12 = reA07.A00 > reA07.A09;
        boolean z13 = reA07.A05 != null && reA07.A05.A04();
        if (z12 || !rfA0E.A04()) {
            reA07.A05 = rfA0E;
        }
        String strValueOf = String.valueOf(rfA0E.A01());
        synchronized (reA07) {
            reA07.A06.put(strValueOf, Integer.valueOf((reA07.A06.containsKey(strValueOf) ? ((Integer) reA07.A06.get(strValueOf)).intValue() : 0) + 1));
        }
        if (z12 && !z13) {
            this.A01 = true;
            reA07.A03 = System.currentTimeMillis();
            if (reA07.A07) {
                this.A00.A0E().A3L();
            }
            rd2.A03();
            if (BuildConfigApi.isDebug() && AdInternalSettings.isVisibleAnimation()) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500L);
                view.startAnimation(alphaAnimation);
            }
            if (!reA07.A0F) {
                return;
            }
        } else if (z12 || !z13) {
            rd2.A02();
            if (!this.A01 && reA07.A07) {
                this.A00.A0E().A3J(rfA0E.A02());
            }
            this.A01 = true;
        } else {
            this.A01 = true;
            if (reA07.A07) {
                this.A00.A0E().A2r(rfA0E.A02());
            }
            rd2.A00();
        }
        if (reA07.A08 || reA07.A04 == null) {
            return;
        }
        reA07.A0B.postDelayed(reA07.A04, reA07.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11197b
    public final C1795Yn A5t() {
        return this.A00;
    }
}
