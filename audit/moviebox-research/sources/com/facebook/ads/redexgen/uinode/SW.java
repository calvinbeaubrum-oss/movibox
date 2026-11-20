package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SW implements InterfaceC1542Oq {
    public static String[] A02 = {"z07VqEjGvJ", "HVUavbLQzawZdZVBJZvs2mdfMmVurwko", "OXCJr9QWCT6iNhGP7b2SKXpA8jzUGtxO", "XfWPaMhvYm", "d0mI5Otk4DkPTVLBqA06pYB2qhxVYO4x", "4lS6eLthtLYEvbxsvILcFz16jeQVP", "9TNy9PrFUeRgfy9Rk5pKZK4U", "r8zM3TRfMT7OJmVxj71ND5jlCBdKG"};
    public final /* synthetic */ C1567Pp A00;
    public final /* synthetic */ SV A01;

    public SW(SV sv2, C1567Pp c1567Pp) {
        this.A01 = sv2;
        this.A00 = c1567Pp;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1542Oq
    public final void AAn() {
        if (this.A00.A02() == 0) {
            RE re2 = this.A01.A02;
            String[] strArr = A02;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "rJocaZsUv9";
            strArr2[6] = "3nzpDtzjz9tePwbisyAfJiul";
            re2.A0U();
        }
        if (this.A01.A03 != null) {
            this.A01.A03.A0U();
        }
    }
}
