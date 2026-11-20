package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1221Bg extends C1821Zo {
    public static String[] A08 = {"bHvO3zM", "7z8VpEP", "iw2Y0c", "LME8njBPiXs011hhslbtp", "9K0lNzbR5X2b0vS5", "Pt0EnZUFnGQLsNks8pQcEgn0FivkNzUh", "t6anbflpJj2CGicCnIMdWTRCydsD", "D9TL9YTSSd0lWzGeUvgWfvwaUF0YdAOx"};
    public float A00;
    public int A01;
    public int A02;
    public C1222Bh A03;
    public int[] A04;
    public final C1795Yn A05;
    public final C1560Pi A06;
    public final C1561Pj A07;

    public C1221Bg(C1795Yn c1795Yn, C1561Pj c1561Pj, C1560Pi c1560Pi) {
        super(c1795Yn);
        this.A02 = 0;
        this.A00 = 50.0f;
        this.A05 = c1795Yn;
        this.A07 = c1561Pj;
        this.A06 = c1560Pi;
        this.A01 = -1;
        this.A03 = new C1222Bh(this, c1795Yn);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00f7  */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final void A1J(C10684w c10684w, AnonymousClass53 anonymousClass53, int i11, int i12) {
        int[] iArrA02;
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        if ((mode == 1073741824 && A26() == 1) || (mode2 == 1073741824 && A26() == 0)) {
            super.A1J(c10684w, anonymousClass53, i11, i12);
            return;
        }
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (this.A06.A01(this.A01)) {
            iArrA02 = this.A06.A02(this.A01);
        } else {
            iArrA02 = new int[]{0, 0};
            if (anonymousClass53.A03() >= 1) {
                int iA0W = A0W() > 0 ? 1 : A0W();
                for (int i13 = 0; i13 < iA0W; i13++) {
                    View viewA1m = A1m(i13);
                    if (A08[5].length() != 32) {
                        throw new RuntimeException();
                    }
                    A08[4] = "FajaHWp";
                    if (viewA1m == null) {
                        break;
                    }
                    this.A04 = this.A07.A00(viewA1m, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (A26() == 0) {
                        int i14 = iArrA02[0];
                        int[] iArr = this.A04;
                        iArrA02[0] = i14 + iArr[0];
                        if (i13 == 0) {
                            int iA0g = iArr[1] + A0g();
                            if (A08[6].length() == 1) {
                                throw new RuntimeException();
                            }
                            A08[6] = "o1L5u";
                            iArrA02[1] = iA0g + A0d();
                        } else {
                            continue;
                        }
                    } else {
                        int i15 = iArrA02[1];
                        int[] iArr2 = this.A04;
                        if (A08[6].length() != 1) {
                            A08[5] = "6nCDHSOFLCCkeDdRDThHGlolS6KLs45E";
                            iArrA02[1] = i15 + iArr2[1];
                            if (i13 == 0) {
                                iArrA02[0] = iArr2[0] + A0e() + A0f();
                            }
                        } else {
                            A08[3] = "KFvpvLkhCjqU9hzA1pvFB";
                            iArrA02[1] = i15 + iArr2[1];
                            if (i13 == 0) {
                                iArrA02[0] = iArr2[0] + A0e() + A0f();
                            }
                        }
                    }
                }
                int i16 = this.A01;
                if (i16 != -1) {
                    this.A06.A00(i16, iArrA02);
                }
            }
        }
        if (mode == 1073741824) {
            iArrA02[0] = size;
        }
        if (mode2 == 1073741824) {
            iArrA02[1] = size2;
        }
        A13(iArrA02[0], iArrA02[1]);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1821Zo, com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final void A1p(int i11) {
        A2B(i11, this.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1821Zo, com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final void A1x(C1278Eb c1278Eb, AnonymousClass53 anonymousClass53, int i11) {
        this.A03.A0A(i11);
        A1L(this.A03);
    }

    public final void A2G(double d11) {
        if (d11 <= 0.0d) {
            d11 = 1.0d;
        }
        this.A00 = (float) (50.0d / d11);
        this.A03 = new C1222Bh(this, this.A05);
    }

    public final void A2H(int i11) {
        this.A01 = i11;
    }

    public final void A2I(int i11) {
        this.A02 = i11;
    }
}
