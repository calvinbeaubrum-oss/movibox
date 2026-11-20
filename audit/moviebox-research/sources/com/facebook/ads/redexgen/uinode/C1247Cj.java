package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggPageHeader;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1247Cj {
    public static String[] A05 = {"lKy0YI5EGjXv2", "kqfQDU0iwDhqaMHC0BsTfGE6FjC2jeup", "jv6iVn6YCI", "Kbod1kIlqRm2x7YGttwPvO3kKDdBerP9", "AKxPCvcOfBY8Sui08oZDK8EPANpoB5ev", "JY0GDhLNZiQYBqJ9WzpbNW6VWiMf19In", "nhad57ygvI1TjLq62wNjXmGRomNY9pWS", "x2lvOIXYuZTotm1szSwJqESRclSL2a8b"};
    public int A01;
    public boolean A02;
    public final C1248Ck A03 = new C1248Ck();
    public final C1376Hz A04 = new C1376Hz(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    public int A00 = -1;

    private int A00(int i11) {
        int i12;
        this.A01 = 0;
        int i13 = 0;
        do {
            int i14 = this.A01 + i11;
            C1248Ck c1248Ck = this.A03;
            if (A05[0].length() == 13) {
                A05[5] = "SgZ2PRj4NlkJ3BHKSnaMRED72QUEdulA";
                if (i14 >= c1248Ck.A02) {
                    break;
                }
                int[] iArr = this.A03.A09;
                int i15 = this.A01;
                this.A01 = i15 + 1;
                i12 = iArr[i15 + i11];
                i13 += i12;
            } else {
                throw new RuntimeException();
            }
        } while (i12 == 255);
        return i13;
    }

    public final C1248Ck A01() {
        return this.A03;
    }

    public final C1376Hz A02() {
        return this.A04;
    }

    public final void A03() {
        this.A03.A02();
        this.A04.A0V();
        this.A00 = -1;
        this.A02 = false;
    }

    public final void A04() {
        if (this.A04.A00.length == 65025) {
            return;
        }
        C1376Hz c1376Hz = this.A04;
        byte[] bArr = c1376Hz.A00;
        C1376Hz c1376Hz2 = this.A04;
        if (A05[2].length() == 26) {
            throw new RuntimeException();
        }
        A05[0] = "HnsfJzdopseCo";
        c1376Hz.A00 = Arrays.copyOf(bArr, Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, c1376Hz2.A07()));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0097 A[PHI: r3
  0x0097: PHI (r3v5 int) = (r3v1 int), (r3v6 int) binds: [B:46:0x0108, B:30:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:56:0x0111 A[SYNTHETIC] */
    public final boolean A05(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        int i11;
        boolean z11;
        C1376Hz c1376Hz;
        byte[] bArr;
        int iA07;
        AbstractC1351Ha.A04(interfaceC1234Bt != null);
        if (this.A02) {
            this.A02 = false;
            this.A04.A0V();
        }
        while (!this.A02) {
            if (this.A00 < 0) {
                if (!this.A03.A03(interfaceC1234Bt, true)) {
                    return false;
                }
                int i12 = 0;
                int iA00 = this.A03.A01;
                int i13 = this.A03.A04 & 1;
                if (A05[0].length() != 13) {
                    throw new RuntimeException();
                }
                A05[3] = "DGX3mlcDy37xJAmSOrUIcVUM6emcoPwG";
                if (i13 == 1 && this.A04.A07() == 0) {
                    iA00 += A00(0);
                    int i14 = this.A01;
                    if (A05[5].charAt(15) != '3') {
                        A05[3] = "AFkKoUuE7mshfLpTVlvrzPrYfrcgxZ46";
                        i12 = 0 + i14;
                    } else {
                        i12 = 0 + i14;
                    }
                }
                interfaceC1234Bt.AGP(iA00);
                this.A00 = i12;
            }
            int iA01 = A00(this.A00);
            int i15 = this.A00;
            int i16 = this.A01;
            if (A05[3].charAt(7) != 'W') {
                A05[0] = "rNz5xQDnDJbSd";
                i11 = i15 + i16;
                if (iA01 > 0) {
                    if (this.A04.A05() < this.A04.A07() + iA01) {
                        c1376Hz = this.A04;
                        bArr = c1376Hz.A00;
                        iA07 = this.A04.A07() + iA01;
                        if (A05[5].charAt(15) != '3') {
                            throw new RuntimeException();
                        }
                        A05[2] = "JzmWwV1YqYi";
                        c1376Hz.A00 = Arrays.copyOf(bArr, iA07);
                    }
                    interfaceC1234Bt.readFully(this.A04.A00, this.A04.A07(), iA01);
                    C1376Hz c1376Hz2 = this.A04;
                    c1376Hz2.A0X(c1376Hz2.A07() + iA01);
                    if (this.A03.A09[i11 - 1] != 255) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    this.A02 = z11;
                }
            } else {
                A05[4] = "eWsMjGJOzbCV7BMGMZrvqQ3qOIA8iUo3";
                i11 = i15 + i16;
                if (iA01 > 0) {
                    if (this.A04.A05() < this.A04.A07() + iA01) {
                        c1376Hz = this.A04;
                        bArr = c1376Hz.A00;
                        iA07 = this.A04.A07() + iA01;
                        if (A05[5].charAt(15) != '3') {
                            throw new RuntimeException();
                        }
                        A05[2] = "JzmWwV1YqYi";
                        c1376Hz.A00 = Arrays.copyOf(bArr, iA07);
                    }
                    interfaceC1234Bt.readFully(this.A04.A00, this.A04.A07(), iA01);
                    C1376Hz c1376Hz3 = this.A04;
                    c1376Hz3.A0X(c1376Hz3.A07() + iA01);
                    if (this.A03.A09[i11 - 1] != 255) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    this.A02 = z11;
                }
            }
            if (i11 == this.A03.A02) {
                i11 = -1;
            }
            this.A00 = i11;
        }
        return true;
    }
}
