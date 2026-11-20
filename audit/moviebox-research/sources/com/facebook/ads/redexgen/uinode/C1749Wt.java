package com.facebook.ads.redexgen.uinode;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1749Wt implements DD {
    public static String[] A06 = {"f3ASEvE0MACuH7PXtcW6SQzpVLuDWBs6", "UAkl7YLcJ73MhJIfOQ7gtBxP58V39hXf", "sKTt9gGYn0qCOxzPnchEZBW", "TIj2tKxLfGdHgu1Q1GnzrxOOh9OPKkUY", "NlS114awdnJt6ePSWIiXVyR", "Ttbg6FQm3oQML", "hnRFaN1D1NI4WPLkXSYbmAvKq8H9o2zk", "6DjXFLFEMVHWeegs6rtlgiLmiwpKRWRw"};
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final D6 A04;
    public final C1376Hz A05 = new C1376Hz(32);

    public C1749Wt(D6 d11) {
        this.A04 = d11;
    }

    @Override // com.facebook.ads.redexgen.uinode.DD
    public final void A4S(C1376Hz c1376Hz, boolean z11) {
        int i11 = -1;
        if (z11) {
            int iA0E = c1376Hz.A0E();
            int iA06 = c1376Hz.A06();
            String[] strArr = A06;
            if (strArr[4].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            A06[5] = "fX8Qw0M3arh1i";
            i11 = iA06 + iA0E;
        }
        if (this.A03) {
            if (!z11) {
                return;
            }
            this.A03 = false;
            c1376Hz.A0Y(i11);
            this.A00 = 0;
        }
        while (c1376Hz.A04() > 0) {
            int i12 = this.A00;
            if (i12 < 3) {
                if (i12 == 0) {
                    int iA0E2 = c1376Hz.A0E();
                    c1376Hz.A0Y(c1376Hz.A06() - 1);
                    if (iA0E2 == 255) {
                        this.A03 = true;
                        return;
                    }
                }
                int iMin = Math.min(c1376Hz.A04(), 3 - this.A00);
                c1376Hz.A0c(this.A05.A00, this.A00, iMin);
                int i13 = this.A00 + iMin;
                this.A00 = i13;
                if (i13 == 3) {
                    this.A05.A0W(3);
                    this.A05.A0Z(1);
                    int iA0E3 = this.A05.A0E();
                    int iA0E4 = this.A05.A0E();
                    this.A02 = (iA0E3 & 128) != 0;
                    this.A01 = (((iA0E3 & 15) << 8) | iA0E4) + 3;
                    if (this.A05.A05() < this.A01) {
                        byte[] bArr = this.A05.A00;
                        this.A05.A0W(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(this.A01, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.A05.A00, 0, 3);
                    }
                }
            } else {
                int iMin2 = Math.min(c1376Hz.A04(), this.A01 - this.A00);
                c1376Hz.A0c(this.A05.A00, this.A00, iMin2);
                int i14 = this.A00 + iMin2;
                this.A00 = i14;
                int i15 = this.A01;
                if (i14 != i15) {
                    continue;
                } else {
                    if (!this.A02) {
                        this.A05.A0W(i15);
                    } else {
                        if (IF.A09(this.A05.A00, 0, this.A01, -1) != 0) {
                            this.A03 = true;
                            return;
                        }
                        this.A05.A0W(this.A01 - 4);
                    }
                    this.A04.A4R(this.A05);
                    this.A00 = 0;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.DD
    public final void A8q(IB ib2, InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        this.A04.A8q(ib2, interfaceC1235Bu, dc2);
        this.A03 = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.DD
    public final void AFg() {
        this.A03 = true;
    }
}
