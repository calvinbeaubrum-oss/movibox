package com.facebook.ads.redexgen.uinode;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1862aV extends AbstractC09600q {
    public static byte[] A01;
    public static String[] A02 = {"", "lR4UvBki6PSdVcLREjEHAbqRd1OmLUQf", "DjKPGQUWmMf7x", "ODfaPUPPzX7KhktdCz15RADFZIjUcUTH", "SOtQhTlfKwNvvZXzwoqU2I3z2iEV30z7", "BHtVd6ktyCMEATMZK8J5wjGrCvXYI9tG", "P8UTzFKpwpJ94", "IxNcf87J3g"};
    public final /* synthetic */ C1860aT A00;

    static {
        A01();
    }

    public C1862aV(C1860aT c1860aT) {
        this.A00 = c1860aT;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ WebSocketProtocol.PAYLOAD_SHORT);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{99, 114, 107, Ascii.GS, 17, Ascii.DLE, 10, Ascii.FF, 17, Ascii.DC2, Ascii.DC2, Ascii.ESC, Ascii.FF, 94, Ascii.ETB, Ascii.CR, 94, Ascii.DLE, Ascii.VT, Ascii.DC2, Ascii.DC2};
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A02() {
        if (this.A00.A01 == null) {
            this.A00.A04 = false;
            this.A00.A07.onInterstitialActivityDestroyed();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A04() {
        if (this.A00.A01 != null) {
            this.A00.A01.show();
            return;
        }
        this.A00.A04 = false;
        if (this.A00.A03 != null && C1384Ih.A1j(this.A00.A06)) {
            this.A00.A03.A0P(new C1863aW(this));
            this.A00.A03.A0K();
            this.A00.A03 = null;
        }
        this.A00.A07.onInterstitialDismissed(this.A00.A08.A01());
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A05() {
        this.A00.A07.onInterstitialDisplayed(this.A00.A08.A01());
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A06() {
        this.A00.A07.onRewardedAdServerFailed();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A07() {
        this.A00.A07.onRewardedAdServerSucceeded();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A08() {
        this.A00.A07.onRewardedAdCompleted();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0C() {
        this.A00.A06.A0E().A2j();
        this.A00.A07.onAdClicked(this.A00.A08.A01());
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0D() {
        this.A00.A07.onLoggingImpression(this.A00.A08.A01());
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0E(View view) {
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0098  */
    /* JADX WARN: Code duplicated, block: B:18:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:24:0x0137  */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0F(InterfaceC09590p interfaceC09590p) {
        C1447Kz c1447Kz;
        if (this.A00.A03 == null) {
            this.A00.A06.A07().A9a(A00(0, 3, 124), C8A.A0N, new C8B(A00(3, 18, 0)));
            return;
        }
        this.A00.A05 = true;
        C1860aT c1860aT = this.A00;
        c1860aT.A02 = c1860aT.A03.A0G();
        boolean z11 = this.A00.A02 instanceof AbstractC1898b5;
        String[] strArr = A02;
        if (strArr[6].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[1] = "VeASnUkJuhfeOmGjJqk9CbDFf3FFhRFx";
        strArr2[5] = "TZLIDWk0RuIbUDThQePy8NEYvQ7OtG1H";
        if (!z11) {
            this.A00.A07.onAdLoaded(this.A00.A08.A01());
            return;
        }
        final AbstractC1898b5 abstractC1898b5 = (AbstractC1898b5) this.A00.A02;
        int iA0v = abstractC1898b5.A0v();
        String[] strArr3 = A02;
        if (strArr3[0].length() != strArr3[3].length()) {
            String[] strArr4 = A02;
            strArr4[6] = "g2LThTD3HDKTh";
            strArr4[2] = "DwNNkt8z8VoEk";
            if (iA0v > 0) {
                c1447Kz = new C1447Kz();
                if (c1447Kz.A09(this.A00.A06, this.A00.A08.A08(), abstractC1898b5.A0v())) {
                    c1447Kz.A08(this.A00.A06, true);
                    C1860aT c1860aT2 = this.A00;
                    c1860aT2.A01 = c1447Kz.A06(c1860aT2.A06, this.A00.A08.A0A(), this.A00.A08.A08());
                } else {
                    c1447Kz.A08(this.A00.A06, false);
                }
            }
        } else if (iA0v > 0) {
            c1447Kz = new C1447Kz();
            if (c1447Kz.A09(this.A00.A06, this.A00.A08.A08(), abstractC1898b5.A0v())) {
                c1447Kz.A08(this.A00.A06, true);
                C1860aT c1860aT3 = this.A00;
                c1860aT3.A01 = c1447Kz.A06(c1860aT3.A06, this.A00.A08.A0A(), this.A00.A08.A08());
            } else {
                c1447Kz.A08(this.A00.A06, false);
            }
        }
        if (this.A00.A01 == null) {
            this.A00.A07.onAdLoaded(this.A00.A08.A01());
            return;
        }
        abstractC1898b5.A17(true);
        this.A00.A01.loadAd(this.A00.A01.buildLoadAdConfig().withAdListener(new InterstitialAdListener() { // from class: com.facebook.ads.redexgen.X.24
            @Override // com.facebook.ads.AdListener
            public final void onAdClicked(Ad ad2) {
            }

            @Override // com.facebook.ads.AdListener
            public final void onAdLoaded(Ad ad2) {
                this.A01.A00.A07.onAdLoaded(this.A01.A00.A08.A01());
            }

            @Override // com.facebook.ads.AdListener
            public final void onError(Ad ad2, AdError adError) {
                this.A01.A00.A01 = null;
                abstractC1898b5.A17(false);
                this.A01.A00.A07.onAdLoaded(this.A01.A00.A08.A01());
            }

            @Override // com.facebook.ads.InterstitialAdListener
            public final void onInterstitialDismissed(Ad ad2) {
                this.A01.A00.A04 = false;
                if (this.A01.A00.A03 != null) {
                    this.A01.A00.A03.A0P(new C1864aX(this));
                    this.A01.A00.A03.A0K();
                    this.A01.A00.A03 = null;
                }
                this.A01.A00.A07.onInterstitialDismissed(this.A01.A00.A08.A01());
            }

            @Override // com.facebook.ads.InterstitialAdListener
            public final void onInterstitialDisplayed(Ad ad2) {
            }

            @Override // com.facebook.ads.AdListener
            public final void onLoggingImpression(Ad ad2) {
            }
        }).withCacheFlags(this.A00.A08.A0B()).withRewardData(this.A00.A08.A03()).build());
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0G(C1401Jb c1401Jb) {
        this.A00.A06.A0E().A2m(C1453Lf.A01(this.A00.A00), c1401Jb.A03().getErrorCode(), c1401Jb.A04());
        this.A00.A07.onError(this.A00.A08.A01(), L1.A00(c1401Jb));
    }
}
