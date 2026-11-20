package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1756Xa implements CA {
    public static byte[] A07;
    public static String[] A08 = {"S6y5l6jxI9", "6mnEH66ZFffSlH4yeHJS8qNG", "YOAMbMDgHDJdJlquETda64yXe2Dsnigk", "hsyrHKVntalAWTsGKMDD", "vPfGZ", "fU8euoLNwl", "f8hQ6WKdo4yu3", "0USUeFTSnT76dGHmDwgcSkrJJgtZvyOb"};
    public int A00;
    public int A01;
    public long A02;
    public CC A03;
    public final byte[] A06 = new byte[8];
    public final ArrayDeque<C9> A05 = new ArrayDeque<>();
    public final CH A04 = new CH();

    static {
        A05();
    }

    private double A00(InterfaceC1234Bt interfaceC1234Bt, int i11) throws InterruptedException, IOException {
        long jA02 = A02(interfaceC1234Bt, i11);
        return i11 == 4 ? Float.intBitsToFloat((int) jA02) : Double.longBitsToDouble(jA02);
    }

    private long A01(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        interfaceC1234Bt.AFM();
        while (true) {
            interfaceC1234Bt.ADv(this.A06, 0, 4);
            int iA00 = CH.A00(this.A06[0]);
            if (iA00 != -1 && iA00 <= 4) {
                int iA01 = (int) CH.A01(this.A06, iA00, false);
                if (this.A03.A96(iA01)) {
                    interfaceC1234Bt.AGP(iA00);
                    return iA01;
                }
            }
            interfaceC1234Bt.AGP(1);
        }
    }

    private long A02(InterfaceC1234Bt interfaceC1234Bt, int i11) throws InterruptedException, IOException {
        interfaceC1234Bt.readFully(this.A06, 0, i11);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 << 8) | ((long) (this.A06[i12] & 255));
        }
        return j11;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 40);
        }
        return new String(bArrCopyOfRange);
    }

    private String A04(InterfaceC1234Bt interfaceC1234Bt, int i11) throws InterruptedException, IOException {
        if (i11 == 0) {
            return A03(0, 0, Worker.WHAT_SYNC_DATA);
        }
        byte[] bArr = new byte[i11];
        interfaceC1234Bt.readFully(bArr, 0, i11);
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        return new String(bArr, 0, i11);
    }

    public static void A05() {
        A07 = new byte[]{124, -95, -87, -108, -97, -100, -105, 83, -104, -97, -104, -96, -104, -95, -89, 83, -89, -84, -93, -104, 83, -100, -63, -55, -76, -65, -68, -73, 115, -71, -65, -62, -76, -57, 115, -58, -68, -51, -72, -115, 115, -27, 10, Ascii.DC2, -3, 8, 5, 0, -68, 5, 10, Ascii.DLE, 1, 3, 1, Ascii.SO, -68, Ascii.SI, 5, Ascii.SYN, 1, -42, -68, -127, -94, -96, -105, -100, -107, 78, -109, -102, -109, -101, -109, -100, -94, 78, -95, -105, -88, -109, 104, 78};
    }

    @Override // com.facebook.ads.redexgen.uinode.CA
    public final void A8p(CC cc2) {
        this.A03 = cc2;
    }

    @Override // com.facebook.ads.redexgen.uinode.CA
    public final boolean AEJ(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        AbstractC1351Ha.A04(this.A03 != null);
        while (true) {
            if (!this.A05.isEmpty()) {
                long jA7i = interfaceC1234Bt.A7i();
                C9 c9Peek = this.A05.peek();
                if (A08[4].length() == 19) {
                    throw new RuntimeException();
                }
                A08[1] = "iTM85rd";
                if (jA7i >= c9Peek.A01) {
                    this.A03.A5X(this.A05.pop().A00);
                    return true;
                }
            }
            if (this.A01 == 0) {
                long jA05 = this.A04.A05(interfaceC1234Bt, true, false, 4);
                if (jA05 == -2) {
                    jA05 = A01(interfaceC1234Bt);
                }
                if (jA05 == -1) {
                    return false;
                }
                this.A00 = (int) jA05;
                this.A01 = 1;
            }
            if (this.A01 == 1) {
                this.A02 = this.A04.A05(interfaceC1234Bt, false, true, 8);
                this.A01 = 2;
            }
            int iA6s = this.A03.A6s(this.A00);
            switch (iA6s) {
                case 0:
                    interfaceC1234Bt.AGP((int) this.A02);
                    this.A01 = 0;
                    break;
                case 1:
                    long jA7i2 = interfaceC1234Bt.A7i();
                    this.A05.push(new C9(this.A00, jA7i2 + this.A02));
                    this.A03.AGU(this.A00, jA7i2, this.A02);
                    this.A01 = 0;
                    return true;
                case 2:
                    long j11 = this.A02;
                    if (j11 > 8) {
                        throw new C11849v(A03(41, 22, 116) + this.A02);
                    }
                    this.A03.A8t(this.A00, A02(interfaceC1234Bt, (int) j11));
                    this.A01 = 0;
                    return true;
                case 3:
                    long j12 = this.A02;
                    if (j12 > 2147483647L) {
                        throw new C11849v(A03(63, 21, 6) + this.A02);
                    }
                    this.A03.AGc(this.A00, A04(interfaceC1234Bt, (int) j12));
                    this.A01 = 0;
                    return true;
                case 4:
                    this.A03.A42(this.A00, (int) this.A02, interfaceC1234Bt);
                    if (A08[7].charAt(2) != 'S') {
                        A08[2] = "x8X2xTnJq9Kheln0ABdW7PO8kghsREvE";
                        this.A01 = 0;
                        return true;
                    }
                    A08[4] = "mGqeeb15RRoJ11oGs7LhfnjQvY";
                    this.A01 = 0;
                    return true;
                case 5:
                    long j13 = this.A02;
                    if (j13 != 4 && j13 != 8) {
                        throw new C11849v(A03(21, 20, 43) + this.A02);
                    }
                    this.A03.A5j(this.A00, A00(interfaceC1234Bt, (int) j13));
                    this.A01 = 0;
                    return true;
                default:
                    throw new C11849v(A03(0, 21, 11) + iA6s);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.CA
    public final void reset() {
        this.A01 = 0;
        this.A05.clear();
        this.A04.A06();
    }
}
