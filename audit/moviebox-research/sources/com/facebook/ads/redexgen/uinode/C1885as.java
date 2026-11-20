package com.facebook.ads.redexgen.uinode;

import android.webkit.WebView;
import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.as, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1885as implements C6U {
    public final C09721c A00;
    public final InterfaceC09861q A01;
    public final C11006c A02;
    public final C1795Yn A03;
    public final boolean A04;

    public C1885as(C1795Yn c1795Yn, InterfaceC09861q interfaceC09861q, C11006c c11006c, C09721c c09721c, boolean z11) {
        this.A03 = c1795Yn;
        this.A01 = interfaceC09861q;
        this.A02 = c11006c;
        this.A00 = c09721c;
        this.A04 = z11;
    }

    private final void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        webView.setWebViewClient(new C09871r(this.A00, this.A01, this.A04));
        webView.loadUrl(this.A00.A0E());
    }

    private void A01(boolean z11) {
        if (this.A00.A09() == EnumC09731d.A05) {
            A00();
            return;
        }
        String strA0E = this.A00.A0E();
        if (z11) {
            strA0E = this.A02.A0R(this.A00.A0E());
        }
        this.A00.A0H(strA0E);
        this.A01.ACa();
    }

    @Override // com.facebook.ads.redexgen.uinode.C6U
    public final void AB2() {
        if (this.A04) {
            this.A01.ACZ(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C6U
    public final void ABB() {
        A01(true);
    }
}
