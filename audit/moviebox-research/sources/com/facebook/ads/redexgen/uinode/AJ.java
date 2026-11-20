package com.facebook.ads.redexgen.uinode;

import java.util.ArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AJ {
    public static String[] A06 = {"rmgpPCWB7BYHQ3azE8yCiRChgWLX4K1O", "ESYL8WQp59BjyyK9DI9xkUBJ1yOk4QLd", "YweXfGig2PVNilG2mJZlv3ovQAOkP8UY", "CAftEyLXQvcAYYqOnK17yfwScyM6Y9GQ", "5ZUx", "CHSAxwc6W9B6bhcUywJKjVUar2kzl0Sb", "G9dVYOs473", "8VVZpCzafohaQpJb3SOOvVZNRfYg5osa"};
    public AK A01;
    public AK A02;
    public boolean A03;
    public final ArrayList<AK> A05 = new ArrayList<>();
    public final AF A04 = new AF();
    public AH A00 = AH.A01;

    private AK A00(AK ak2, AH ah2) {
        if (ah2.A0E() || this.A00.A0E()) {
            return ak2;
        }
        AH ah3 = this.A00;
        int i11 = ak2.A01.A02;
        if (A06[5].charAt(2) == 'm') {
            throw new RuntimeException();
        }
        A06[3] = "6Z7kXvoTE0GMRlV8X7ahHWF28Ir1JA8U";
        int iA04 = ah2.A04(ah3.A0A(i11, this.A04, true).A03);
        return iA04 == -1 ? ak2 : new AK(ah2.A09(iA04, this.A04).A00, ak2.A01.A00(iA04));
    }

    private void A02() {
        if (this.A05.isEmpty()) {
            return;
        }
        this.A01 = this.A05.get(0);
    }

    public final AK A03() {
        return this.A01;
    }

    public final AK A04() {
        if (this.A05.isEmpty()) {
            return null;
        }
        ArrayList<AK> arrayList = this.A05;
        int size = arrayList.size() - 1;
        if (A06[3].charAt(28) == 'b') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[6] = "IuVtQJyFuB";
        strArr[7] = "VEjGs0KHAo6Qkjlg0Fq6YAYYmbb9RMII";
        return arrayList.get(size);
    }

    public final AK A05() {
        if (this.A05.isEmpty() || this.A00.A0E() || this.A03) {
            return null;
        }
        return this.A05.get(0);
    }

    public final AK A06() {
        return this.A02;
    }

    public final C1291Eo A07(int i11) {
        C1291Eo c1291Eo = null;
        AH ah2 = this.A00;
        if (ah2 != null) {
            int iA00 = ah2.A00();
            for (int i12 = 0; i12 < this.A05.size(); i12++) {
                AK ak2 = this.A05.get(i12);
                int i13 = ak2.A01.A02;
                if (i13 < iA00 && this.A00.A09(i13, this.A04).A00 == i11) {
                    if (c1291Eo != null) {
                        return null;
                    }
                    c1291Eo = ak2.A01;
                }
            }
        }
        return c1291Eo;
    }

    public final void A08() {
        this.A03 = false;
        A02();
    }

    public final void A09() {
        this.A03 = true;
    }

    public final void A0A(int i11) {
        A02();
    }

    public final void A0B(int i11, C1291Eo c1291Eo) {
        this.A05.add(new AK(i11, c1291Eo));
        if (this.A05.size() != 1 || this.A00.A0E()) {
            return;
        }
        A02();
    }

    public final void A0C(int i11, C1291Eo c1291Eo) {
        AK ak2 = new AK(i11, c1291Eo);
        this.A05.remove(ak2);
        if (ak2.equals(this.A02)) {
            this.A02 = this.A05.isEmpty() ? null : this.A05.get(0);
        }
    }

    public final void A0D(int i11, C1291Eo c1291Eo) {
        this.A02 = new AK(i11, c1291Eo);
    }

    public final void A0E(AH ah2) {
        for (int i11 = 0; i11 < this.A05.size(); i11++) {
            ArrayList<AK> arrayList = this.A05;
            arrayList.set(i11, A00(arrayList.get(i11), ah2));
        }
        AK ak2 = this.A02;
        if (ak2 != null) {
            this.A02 = A00(ak2, ah2);
        }
        this.A00 = ah2;
        A02();
    }

    public final boolean A0F() {
        return this.A03;
    }
}
