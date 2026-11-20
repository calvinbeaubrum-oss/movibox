package com.facebook.ads.redexgen.uinode;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1899b6 extends AbstractC10494c<UR> {
    public static final int A05 = (int) (LD.A02 * 4.0f);
    public C1B A00;
    public final List<V2> A01;
    public final int A02;
    public final C1795Yn A03;
    public final RD A04 = new C1901b8(this);

    public AbstractC1899b6(C3C c3c, List<V2> list, C1795Yn c1795Yn) {
        this.A03 = c1795Yn;
        this.A02 = c3c.getChildSpacing();
        this.A01 = list;
    }

    private ViewGroup.MarginLayoutParams A02(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i12 = this.A02;
        if (i11 == 0) {
            i12 *= 2;
        }
        marginLayoutParams.setMargins(i12, 0, i11 >= this.A01.size() + (-1) ? this.A02 * 2 : this.A02, 0);
        return marginLayoutParams;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    public final int A0E() {
        return this.A01.size();
    }

    public final void A0F(ImageView imageView, int i11) {
        V2 v11 = this.A01.get(i11);
        JP adCoverImage = v11.getAdCoverImage();
        if (adCoverImage != null) {
            AsyncTaskC1672Tq asyncTaskC1672TqA04 = new AsyncTaskC1672Tq(imageView, this.A03).A04();
            asyncTaskC1672TqA04.A06(new C1900b7(this, i11, v11));
            asyncTaskC1672TqA04.A07(adCoverImage.getUrl());
        }
    }

    public final void A0G(C1B c1b) {
        this.A00 = c1b;
    }

    public void A0H(UR ur2, int i11) {
        ur2.A0j().setLayoutParams(A02(i11));
    }
}
