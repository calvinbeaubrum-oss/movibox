package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WT implements H8 {
    public static String[] A0C = {"G7jWD6ulf4YNSZyKFTHtDKYEexnehBFD", "eAcypqsPfTTSG9tYkNPVa4Ur1OSgM6nM", "x", "tNQG44GENbPBCr6MlCIr3t4n4NF0MmxZ", "OwErIGDXAeY1H11Nt9UmuNZTMubue4sT", "f", "eBkibdjxFKT4WmP6H51EPZ9055c0bCkp", "0Ce9TygyYiJS1KV85oyrWWiGz76nCu"};
    public long A00;
    public long A02;
    public C1350Gy A03;
    public final Uri A05;
    public final C1287Ek A07;
    public final InterfaceC1346Gu A08;
    public final C1357Hg A09;
    public volatile boolean A0A;
    public final /* synthetic */ CD A0B;
    public final C1238Bz A06 = new C1238Bz();
    public boolean A04 = true;
    public long A01 = -1;

    public WT(CD cd2, Uri uri, InterfaceC1346Gu interfaceC1346Gu, C1287Ek c1287Ek, C1357Hg c1357Hg) {
        this.A0B = cd2;
        this.A05 = (Uri) AbstractC1351Ha.A01(uri);
        this.A08 = (InterfaceC1346Gu) AbstractC1351Ha.A01(interfaceC1346Gu);
        this.A07 = (C1287Ek) AbstractC1351Ha.A01(c1287Ek);
        this.A09 = c1357Hg;
    }

    public final void A04(long j11, long j12) {
        this.A06.A00 = j11;
        this.A02 = j12;
        this.A04 = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.H8
    public final void A4A() {
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.H8
    public final void A9P() throws InterruptedException, IOException {
        int iAEH = 0;
        while (iAEH == 0 && !this.A0A) {
            InterfaceC1234Bt interfaceC1234Bt = null;
            try {
                long jA7i = this.A06.A00;
                C1350Gy c1350Gy = new C1350Gy(this.A05, jA7i, -1L, this.A0B.A0b);
                this.A03 = c1350Gy;
                long jADl = this.A08.ADl(c1350Gy);
                this.A01 = jADl;
                if (jADl != -1) {
                    this.A01 = jADl + jA7i;
                }
                C1769Xn c1769Xn = new C1769Xn(this.A08, jA7i, this.A01);
                InterfaceC1233Bs interfaceC1233BsA02 = this.A07.A02(c1769Xn, this.A08.A8E());
                if (this.A04) {
                    interfaceC1233BsA02.AFh(jA7i, this.A02);
                    this.A04 = false;
                }
                while (iAEH == 0 && !this.A0A) {
                    this.A09.A00();
                    iAEH = interfaceC1233BsA02.AEH(c1769Xn, this.A06);
                    if (c1769Xn.A7i() > this.A0B.A0P + jA7i) {
                        jA7i = c1769Xn.A7i();
                        this.A09.A01();
                        this.A0B.A0R.post(this.A0B.A0a);
                    }
                }
                if (iAEH == 1) {
                    iAEH = 0;
                } else {
                    C1238Bz c1238Bz = this.A06;
                    if (A0C[7].length() == 32) {
                        throw new RuntimeException();
                    }
                    A0C[7] = "RP5F3MQdpmYGlMxTR22UmyqYUd";
                    c1238Bz.A00 = c1769Xn.A7i();
                    this.A00 = this.A06.A00 - this.A03.A01;
                }
                IF.A0W(this.A08);
            } catch (Throwable th2) {
                String[] strArr = A0C;
                if (strArr[3].charAt(18) != strArr[0].charAt(18)) {
                    String[] strArr2 = A0C;
                    strArr2[1] = "eRCRzQ7PqS4RXHh1qWIeZ2INrCYp7IVM";
                    strArr2[6] = "eZFPNfTqDUJk6uZFjeWmQVerr07XVEhG";
                    if (iAEH != 1 && 0 != 0) {
                        this.A06.A00 = interfaceC1234Bt.A7i();
                        this.A00 = this.A06.A00 - this.A03.A01;
                    }
                    IF.A0W(this.A08);
                    throw th2;
                }
            }
        }
    }
}
