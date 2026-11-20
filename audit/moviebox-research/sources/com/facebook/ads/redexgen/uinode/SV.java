package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SV extends AnonymousClass56 implements MJ {
    public C1U A00;
    public RD A01;
    public RE A02;
    public RE A03;
    public final int A04;
    public final SparseBooleanArray A05;
    public final C1795Yn A06;
    public final BK A07;

    public SV(BK bk2, SparseBooleanArray sparseBooleanArray, RE re2, int i11, C1795Yn c1795Yn, C1U c1u) {
        super(bk2);
        this.A06 = c1795Yn;
        this.A07 = bk2;
        this.A05 = sparseBooleanArray;
        this.A02 = re2;
        this.A04 = i11;
        this.A00 = c1u;
    }

    private void A0A(J2 j11, C1454Lg c1454Lg, String str, C1567Pp c1567Pp) {
        if (this.A05.get(c1567Pp.A02())) {
            return;
        }
        RE re2 = this.A03;
        if (re2 != null) {
            re2.A0V();
            this.A03 = null;
        }
        this.A01 = new SX(this, str, c1567Pp, j11, c1567Pp.A04(), c1454Lg);
        RE re3 = new RE(this.A07, 10, new WeakReference(this.A01), this.A06);
        this.A03 = re3;
        re3.A0Y(false);
        this.A03.A0W(100);
        this.A03.A0X(100);
        this.A07.setOnAssetsLoadedListener(new SW(this, c1567Pp));
    }

    public final void A0j(C1567Pp c1567Pp, J2 j11, C11006c c11006c, C1454Lg c1454Lg, String str, int i11, int i12, int i13) {
        int iA02 = c1567Pp.A02();
        this.A07.setTag(-1593835536, Integer.valueOf(iA02));
        this.A07.setupNativeCtaExtension(c1567Pp);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i11, -2);
        int i14 = iA02 == 0 ? i13 : i12;
        if (iA02 < this.A04 - 1) {
            i13 = i12;
        }
        marginLayoutParams.setMargins(i14, 0, i13, 0);
        String strA07 = c1567Pp.A03().A0D().A07();
        String strA08 = c1567Pp.A03().A0D().A08();
        this.A07.setIsVideo(!TextUtils.isEmpty(strA08));
        if (this.A07.A18()) {
            this.A07.setVideoPlaceholderUrl(strA07);
            this.A07.setVideoUrl(c11006c.A0S(strA08));
        } else {
            this.A07.setImageUrl(strA07);
        }
        this.A07.setLayoutParams(marginLayoutParams);
        this.A07.setCTAInfo(c1567Pp.A03().A0F(), c1567Pp.A04());
        this.A07.A19(c1567Pp.A04());
        A0A(j11, c1454Lg, str, c1567Pp);
    }

    public final void A0k(RE re2) {
        this.A02 = re2;
    }

    @Override // com.facebook.ads.redexgen.uinode.MJ
    public final void AFr() {
        this.A07.A13();
    }
}
