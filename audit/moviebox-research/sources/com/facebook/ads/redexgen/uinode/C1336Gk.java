package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1336Gk {
    public static String[] A04 = {"1e59kXQlLqMkYu", "73uDxCsdQKWLV7ukq8JJdZs18UKd6swo", "mCuMZDHsEtXcrT2f0", "82", "pR5c7vVXcuaoTTpQp", "OeCOW4uYvzA4LVqnaAabDbQ1U", "2mUnq0j6yY0W6wQrn1U3Lg5rNBUJPBqf", "6oWLaazoE5vpCSBDL9uHOzoNvgEAVE9"};
    public final int A00;
    public final C1333Gh A01;
    public final Object A02;
    public final AB[] A03;

    public C1336Gk(AB[] abArr, InterfaceC1332Gg[] interfaceC1332GgArr, Object obj) {
        this.A03 = abArr;
        this.A01 = new C1333Gh(interfaceC1332GgArr);
        this.A02 = obj;
        this.A00 = abArr.length;
    }

    public final boolean A00(int i11) {
        return this.A03[i11] != null;
    }

    public final boolean A01(C1336Gk c1336Gk) {
        if (c1336Gk == null || c1336Gk.A01.A01 != this.A01.A01) {
            return false;
        }
        for (int i11 = 0; i11 < this.A01.A01; i11++) {
            if (!A02(c1336Gk, i11)) {
                return false;
            }
        }
        return true;
    }

    public final boolean A02(C1336Gk c1336Gk, int i11) {
        if (c1336Gk == null) {
            return false;
        }
        AB[] abArr = this.A03;
        String[] strArr = A04;
        if (strArr[0].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "XY11p18RHVDFci";
        strArr2[3] = "x2";
        return IF.A0g(abArr[i11], c1336Gk.A03[i11]) && IF.A0g(this.A01.A00(i11), c1336Gk.A01.A00(i11));
    }
}
