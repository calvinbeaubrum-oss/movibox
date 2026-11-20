package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.RewardData;
import java.util.EnumSet;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FF extends AbstractC1867aa {
    public static String[] A02 = {"Wdifh5HSN4RyvogFUrIVqQJQULlKdEei", "S34yOHPbjBOZXrhEKXqsFwPvtnd1qciy", "vu9eRI", "x0OqZ", "VYF0eZRg0jpnLcLhIoRoBnoO3djZf6SI", "33GTCt01Ki3rQT8tpwoWMPFpMqFvVQrj", "pa13jV0ykdfTm6Oo414mEZE7qu5xzGka", "tj8XsVszyFe6dIsjKXzcwTwgC3z6jHVp"};
    public static final AnonymousClass27 A03 = new C1855aO();
    public C1860aT A00;
    public final AnonymousClass26 A01;

    public FF(AnonymousClass26 anonymousClass26, String str) {
        super(anonymousClass26.A05(), str, A03.A4h(anonymousClass26));
        this.A01 = anonymousClass26;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1867aa
    public final void A08() {
        C1860aT c1860aT = this.A00;
        if (c1860aT != null) {
            c1860aT.destroy();
        }
        AnonymousClass21 anonymousClass21 = super.A00;
        AnonymousClass20 anonymousClass20 = AnonymousClass20.A04;
        if (A02[1].charAt(8) == 'f') {
            throw new RuntimeException();
        }
        A02[4] = "bjBCaQy28rNQq0pISHtZZouKJ3cbndZJ";
        anonymousClass21.AFw(anonymousClass20);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1867aa
    public final void A09() {
        C1860aT c1860aT = new C1860aT(this.A01, this, A04());
        this.A00 = c1860aT;
        c1860aT.A0G(this.A01.A0B(), this.A01.A07());
    }

    public final void A0D(InterstitialAd interstitialAd, EnumSet<CacheFlag> enumSet, String str) {
        if (super.A00.A5d()) {
            return;
        }
        this.A01.A0D(interstitialAd);
        C1860aT c1860aT = this.A00;
        if (c1860aT != null) {
            c1860aT.A0G(enumSet, str);
            return;
        }
        this.A01.A0K(enumSet);
        this.A01.A0H(str);
        if (AbstractC1386Ik.A07(this.A02) && AbstractC1386Ik.A08(this.A02)) {
            A05();
        } else {
            A09();
        }
    }

    public final void A0E(RewardData rewardData) {
        this.A01.A0F(rewardData);
        if (super.A01.A01) {
            super.A01.A0F(PointerIconCompat.TYPE_ALL_SCROLL, C2M.A00(new Bundle(), rewardData));
        }
    }

    public final boolean A0F() {
        C1860aT c1860aT = this.A00;
        if (c1860aT != null) {
            return c1860aT.A0H();
        }
        if (this.A01.A00() > 0) {
            long jA00 = C1453Lf.A00();
            long jA01 = this.A01.A00();
            if (A02[0].charAt(6) == 'y') {
                throw new RuntimeException();
            }
            A02[4] = "spPOKGUnJm6foAMMjUQWH3rPbfiGZlB3";
            if (jA00 > jA01) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0G() {
        C1860aT c1860aT = this.A00;
        if (c1860aT != null) {
            return c1860aT.A0I();
        }
        return super.A00.A5v() == AnonymousClass20.A06;
    }

    public final boolean A0H(InterstitialAd interstitialAd, InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        if (super.A00.A5e()) {
            return false;
        }
        this.A01.A0D(interstitialAd);
        if (super.A01.A01) {
            A0A(-1);
            return true;
        }
        C1860aT c1860aT = this.A00;
        if (c1860aT != null) {
            return c1860aT.A0J();
        }
        C1860aT c1860aT2 = new C1860aT(this.A01, this, A04());
        this.A00 = c1860aT2;
        c1860aT2.A0J();
        return false;
    }
}
