package com.facebook.ads.redexgen.uinode;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1681Tz extends AbstractC10494c<SV> {
    public int A00;
    public int A01;
    public int A02;
    public MC A03;
    public RE A04;
    public String A05;
    public List<C1567Pp> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AbstractC1898b5 A08;
    public final C11006c A09;
    public final C1795Yn A0A;
    public final J2 A0B;
    public final V2 A0C;
    public final C1454Lg A0D;
    public final BQ A0E;
    public final KP A0F;

    public C1681Tz(C1795Yn c1795Yn, List<C1567Pp> list, AbstractC1898b5 abstractC1898b5, J2 j11, V2 v11, MC mc2, String str, BQ bq2, KP kp2) {
        this.A0A = c1795Yn;
        this.A0B = j11;
        this.A0C = v11;
        this.A09 = v11.A10();
        this.A04 = v11.A1A();
        this.A0D = v11.A19();
        this.A03 = mc2;
        this.A08 = abstractC1898b5;
        this.A06 = list;
        this.A05 = str;
        this.A0E = bq2;
        this.A0F = kp2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final SV A0C(ViewGroup viewGroup, int i11) {
        return new SV(AbstractC1518Ns.A00(new OO(this.A0A, this.A0B, this.A03, this.A08, null, this.A04, this.A0D).A0I(this.A0F).A0G(this.A0C).A0K(), this.A0C, this.A05, this.A0E), this.A07, this.A04, this.A06.size(), this.A0A, this.A08.A0y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0D(SV sv2, int i11) {
        C1567Pp c1567Pp = this.A06.get(i11);
        sv2.A0k(this.A04);
        sv2.A0j(c1567Pp, this.A0B, this.A09, this.A0D, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    public final int A0E() {
        return this.A06.size();
    }

    public final void A0F(int i11, int i12, int i13) {
        boolean z11 = i11 != this.A00;
        this.A00 = i11;
        this.A02 = i12;
        this.A01 = i13;
        if (z11) {
            A06();
        }
    }

    public final void A0G(RE re2) {
        this.A04 = re2;
    }
}
