package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1746Wq implements D6 {
    public static String[] A02 = {"KDcVXuz53RpoF9UEOZ96l2VZuhVX9ip0", "CKRJ1Pqx0SMvAzHTc14bPVY1Im6KLWKe", "CZRg2SIX1VWZgfyXTOdEl1", "FcRR7mDk42dnDG0ym1pZJ2", "QPo", "3iSkzhZlTwG2jcdx249ci8whKDsXKTKF", "nuc6nRuUqT3GqwIih", "HhkYvD09GQfRAuSaGWngxJEfFHmtitdD"};
    public final C1375Hy A00 = new C1375Hy(new byte[4]);
    public final /* synthetic */ C1744Wo A01;

    public C1746Wq(C1744Wo c1744Wo) {
        this.A01 = c1744Wo;
    }

    @Override // com.facebook.ads.redexgen.uinode.D6
    public final void A4R(C1376Hz c1376Hz) {
        if (c1376Hz.A0E() != 0) {
            return;
        }
        c1376Hz.A0Z(7);
        int iA04 = c1376Hz.A04() / 4;
        for (int i11 = 0; i11 < iA04; i11++) {
            c1376Hz.A0a(this.A00, 4);
            int iA05 = this.A00.A04(16);
            this.A00.A08(3);
            if (iA05 == 0) {
                this.A00.A08(13);
            } else {
                int iA06 = this.A00.A04(13);
                this.A01.A06.put(iA06, new C1749Wt(new C1745Wp(this.A01, iA06)));
                C1744Wo.A01(this.A01);
            }
        }
        int i12 = this.A01.A05;
        if (A02[4].length() == 11) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "4awIAPS5zJKVkKN48BLjJX";
        strArr[2] = "yyhTqQNSKamLuuIUjTGErW";
        if (i12 != 2) {
            this.A01.A06.remove(0);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.D6
    public final void A8q(IB ib2, InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
    }
}
