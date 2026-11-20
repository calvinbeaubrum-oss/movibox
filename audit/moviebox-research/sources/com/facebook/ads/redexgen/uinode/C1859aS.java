package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.RewardedVideoAdListener;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1859aS extends AbstractC09600q {
    public static byte[] A01;
    public static String[] A02 = {"7kSkrPID5YMo1WnvaMIgpKB6WIhQPZTc", "kYnVnFR0h3Yv", "", "4OZGrpocgzJPR2XOpe36kiptmUtlR1IY", "AELVZqmE3v", "ezzX0t3o6v3ClFiCUOYeN27kq8G", "mBbxV2ZqaJcWXY", "eL94qTtIFL"};
    public final /* synthetic */ C1857aQ A00;

    static {
        A01();
    }

    public C1859aS(C1857aQ c1857aQ) {
        this.A00 = c1857aQ;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-28, -13, -20, -53, -41, -42, -36, -38, -41, -44, -44, -51, -38, -120, -47, -37, -120, -42, -35, -44, -44};
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A06() {
        this.A00.A08.onRewardServerFailed();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A07() {
        this.A00.A08.onRewardServerSuccess();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A08() {
        if (this.A00.A03 == null) {
            this.A00.A08.onRewardedVideoCompleted();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A09() {
        if (this.A00.A03 == null) {
            this.A00.A08.onRewardedVideoActivityDestroyed();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0A() {
        if (this.A00.A03 == null) {
            this.A00.A08.onRewardedVideoClosed();
            return;
        }
        C10975z c10975z = (C10975z) this.A00.A03.buildShowAdConfig();
        c10975z.A02(System.currentTimeMillis() - this.A00.A02);
        this.A00.A03.show(c10975z.build());
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0C() {
        this.A00.A07.A0E().A2j();
        this.A00.A08.onAdClicked(this.A00.A09.A00());
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0D() {
        this.A00.A08.onLoggingImpression(this.A00.A09.A00());
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0F(InterfaceC09590p interfaceC09590p) {
        if (this.A00.A05 == null) {
            this.A00.A07.A07().A9a(A00(0, 3, 70), C8A.A0N, new C8B(A00(3, 18, 43)));
            return;
        }
        AbstractC1902b9 abstractC1902b9 = (AbstractC1902b9) interfaceC09590p;
        if (this.A00.A09.A03 != null) {
            abstractC1902b9.A02(this.A00.A09.A03);
        }
        C2F c2f = this.A00.A09;
        int iA0G = abstractC1902b9.A0G();
        String[] strArr = A02;
        if (strArr[4].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[4] = "61YjDYRNNN";
        strArr2[7] = "vT3ubuaNP5";
        c2f.A00 = iA0G;
        this.A00.A06 = true;
        C1857aQ c1857aQ = this.A00;
        c1857aQ.A04 = c1857aQ.A05.A0G();
        if (this.A00.A04 != null) {
            int iA0v = this.A00.A04.A0j() ? 0 : ((AbstractC1898b5) this.A00.A04).A0v();
            if (iA0v > 0) {
                C1447Kz c1447Kz = new C1447Kz();
                if (c1447Kz.A09(this.A00.A07, this.A00.A09.A06, iA0v)) {
                    c1447Kz.A08(this.A00.A07, true);
                    C1857aQ c1857aQ2 = this.A00;
                    c1857aQ2.A03 = c1447Kz.A07(c1857aQ2.A07, this.A00.A09.A0D, this.A00.A09.A06);
                } else {
                    C1857aQ c1857aQ3 = this.A00;
                    String[] strArr3 = A02;
                    if (strArr3[4].length() != strArr3[7].length()) {
                        String[] strArr4 = A02;
                        strArr4[4] = "df15N9yr5s";
                        strArr4[7] = "rrfEFjVt4q";
                        c1447Kz.A08(c1857aQ3.A07, false);
                    } else {
                        String[] strArr5 = A02;
                        strArr5[1] = "7AaEv1vCH3bw";
                        strArr5[5] = "Y1uo0lYkjhkOAjcvNvodbhiOq3C";
                        c1447Kz.A08(c1857aQ3.A07, false);
                    }
                }
            }
        }
        if (this.A00.A03 == null) {
            this.A00.A08.onAdLoaded(this.A00.A09.A00());
        } else {
            ((AbstractC1898b5) this.A00.A04).A17(true);
            this.A00.A03.loadAd(this.A00.A03.buildLoadAdConfig().withFailOnCacheFailureEnabled(true).withRewardData(this.A00.A04.A0J()).withAdExperience(this.A00.A09.A02).withAdListener(new RewardedVideoAdListener() { // from class: com.facebook.ads.redexgen.X.25
                @Override // com.facebook.ads.AdListener
                public final void onAdClicked(Ad ad2) {
                }

                @Override // com.facebook.ads.AdListener
                public final void onAdLoaded(Ad ad2) {
                    this.A00.A00.A08.onAdLoaded(this.A00.A00.A09.A00());
                }

                @Override // com.facebook.ads.AdListener
                public final void onError(Ad ad2, AdError adError) {
                    this.A00.A00.A03 = null;
                    ((AbstractC1898b5) this.A00.A00.A04).A17(false);
                    this.A00.A00.A08.onAdLoaded(this.A00.A00.A09.A00());
                }

                @Override // com.facebook.ads.AdListener
                public final void onLoggingImpression(Ad ad2) {
                }

                @Override // com.facebook.ads.RewardedVideoAdListener
                public final void onRewardedVideoClosed() {
                    this.A00.A00.A08.onRewardedVideoClosed();
                }

                @Override // com.facebook.ads.RewardedVideoAdListener
                public final void onRewardedVideoCompleted() {
                    this.A00.A00.A08.onRewardedVideoCompleted();
                }
            }).build());
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0G(C1401Jb c1401Jb) {
        this.A00.A0D(true);
        this.A00.A09.A0B.A0E().A2m(C1453Lf.A01(this.A00.A01), c1401Jb.A03().getErrorCode(), c1401Jb.A04());
        this.A00.A08.onError(this.A00.A09.A00(), L1.A00(c1401Jb));
    }
}
