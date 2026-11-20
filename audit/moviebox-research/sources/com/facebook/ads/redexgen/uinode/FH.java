package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FH extends AbstractC1683Ub<C1873ag> {
    public static String[] A00 = {"ByMq6MLqhjUJsdWB3RBIp", "zuOr3", "msyHKBX3wHVeYE5obxbctQprcgEzI02t", "I3sOgeRwcNYGF4oixOV5Q17", "dcB", "ibtCqc8qysdz0E5AMIDmPhuL1XZA", "mNtKCg4kzaH6sXUtb2oDuqx2", "ObFvkEusatMYzjWaq72f4FkWXHrQjerH"};

    public FH(C1873ag c1873ag) {
        super(c1873ag);
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        C1873ag c1873agA07 = A07();
        if (c1873agA07 == null) {
            return;
        }
        C1795Yn c1795Yn = c1873agA07.A08;
        String[] strArr = A00;
        if (strArr[3].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        A00[5] = "SiVLKh";
        if (M5.A02(c1795Yn)) {
            c1873agA07.A07();
        } else {
            c1873agA07.A05.postDelayed(c1873agA07.A0C, 5000L);
        }
    }
}
