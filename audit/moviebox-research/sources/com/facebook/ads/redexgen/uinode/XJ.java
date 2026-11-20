package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XJ implements InterfaceC1249Cl {
    public static byte[] A0C;
    public static String[] A0D = {"qlUqm53dx2wRFYI19yFYkvkmPQFopPfK", "kfzPj4jiKhQrTstJ9wOtTomcMDMJFI2R", "tio4jxSpdKgrcMNksdh3F2ai0PxCizyi", "S5qskWqDqPkhPpuUuuvRcKySD9vc4n0H", "X67UodKHNvmZa3DnASt4fZlpL2cJMcNV", "01LnOYH7rGQp5f5o2UGBiyg7bnJQxBa8", "qDTiiMVukWANjWrPbJo4riKeblMOo1tu", "5dAWhKcmsHilqUXjq3PFXu2GkNxyPnDG"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public final long A08;
    public final long A09;
    public final C1248Ck A0A = new C1248Ck();
    public final AbstractC1252Co A0B;

    static {
        A0A();
    }

    public XJ(long j11, long j12, AbstractC1252Co abstractC1252Co, int i11, long j13) {
        AbstractC1351Ha.A03(j11 >= 0 && j12 > j11);
        this.A0B = abstractC1252Co;
        this.A09 = j11;
        this.A08 = j12;
        if (i11 != j12 - j11) {
            this.A00 = 0;
        } else {
            this.A07 = j13;
            this.A00 = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A00(long j11, long j12, long j13) {
        long j14 = this.A08;
        long j15 = this.A09;
        long j16 = j11 + ((((j14 - j15) * j12) / this.A07) - j13);
        if (j16 < j15) {
            j16 = this.A09;
        }
        return j16 >= j14 ? j14 - 1 : j16;
    }

    private final long A01(long j11, InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        if (this.A04 == this.A01) {
            return -(this.A05 + 2);
        }
        long jA7i = interfaceC1234Bt.A7i();
        if (!A0D(interfaceC1234Bt, this.A01)) {
            long j12 = this.A04;
            if (j12 != jA7i) {
                return j12;
            }
            throw new IOException(A09(0, 25, 22));
        }
        this.A0A.A03(interfaceC1234Bt, false);
        interfaceC1234Bt.AFM();
        long j13 = j11 - this.A0A.A05;
        int i11 = this.A0A.A01 + this.A0A.A00;
        if (j13 >= 0 && j13 <= 72000) {
            interfaceC1234Bt.AGP(i11);
            return -(this.A0A.A05 + 2);
        }
        if (j13 < 0) {
            this.A01 = jA7i;
            this.A02 = this.A0A.A05;
        } else {
            this.A04 = interfaceC1234Bt.A7i() + ((long) i11);
            this.A05 = this.A0A.A05;
            if ((this.A01 - this.A04) + ((long) i11) < 100000) {
                interfaceC1234Bt.AGP(i11);
                return -(this.A05 + 2);
            }
        }
        long j14 = this.A01;
        long j15 = this.A04;
        String[] strArr = A0D;
        if (strArr[4].charAt(12) == strArr[0].charAt(12)) {
            throw new RuntimeException();
        }
        A0D[3] = "zvKF8WQUI0SajHpo4Xv9v8DHT9e2MTPL";
        if (j14 - j15 < 100000) {
            this.A01 = j15;
            return j15;
        }
        long j16 = i11;
        long j17 = j13 > 0 ? 1L : 2L;
        long jA7i2 = interfaceC1234Bt.A7i();
        long j18 = this.A01;
        long j19 = this.A04;
        return Math.min(Math.max((jA7i2 - (j16 * j17)) + (((j18 - j19) * j13) / (this.A02 - this.A05)), j19), this.A01 - 1);
    }

    private final long A02(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        A0C(interfaceC1234Bt);
        this.A0A.A02();
        while (true) {
            int i11 = this.A0A.A04;
            String[] strArr = A0D;
            if (strArr[4].charAt(12) == strArr[0].charAt(12)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[1] = "8L7HD1AI4we5ropKbStlQEIIPOmJrEUL";
            strArr2[2] = "xLnKc6RM4Edpr9DSdPLSxPAMnW98GKHb";
            if ((i11 & 4) == 4 || interfaceC1234Bt.A7i() >= this.A08) {
                return this.A0A.A05;
            }
            this.A0A.A03(interfaceC1234Bt, false);
            interfaceC1234Bt.AGP(this.A0A.A01 + this.A0A.A00);
        }
    }

    private final long A03(InterfaceC1234Bt interfaceC1234Bt, long j11, long j12) throws InterruptedException, IOException {
        this.A0A.A03(interfaceC1234Bt, false);
        while (this.A0A.A05 < j11) {
            interfaceC1234Bt.AGP(this.A0A.A01 + this.A0A.A00);
            j12 = this.A0A.A05;
            this.A0A.A03(interfaceC1234Bt, false);
        }
        interfaceC1234Bt.AFM();
        return j12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1249Cl
    /* JADX INFO: renamed from: A07, reason: merged with bridge method [inline-methods] */
    public final XK A4m() {
        C1246Ci c1246Ci = null;
        if (this.A07 != 0) {
            return new XK(this);
        }
        return null;
    }

    public static String A09(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0C = new byte[]{Ascii.SYN, 55, 120, 55, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 120, 40, 57, Utf8.REPLACEMENT_BYTE, 61, 120, 59, 57, 54, 120, 58, 61, 120, 62, 55, 45, 54, 60, 118};
    }

    private final void A0B() {
        this.A04 = this.A09;
        this.A01 = this.A08;
        this.A05 = 0L;
        this.A02 = this.A07;
    }

    private final void A0C(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        if (!A0D(interfaceC1234Bt, this.A08)) {
            throw new EOFException();
        }
    }

    private final boolean A0D(InterfaceC1234Bt interfaceC1234Bt, long j11) throws InterruptedException, IOException {
        long jMin = Math.min(3 + j11, this.A08);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            if (interfaceC1234Bt.A7i() + ((long) length) > jMin && (length = (int) (jMin - interfaceC1234Bt.A7i())) < 4) {
                return false;
            }
            interfaceC1234Bt.ADw(bArr, 0, length, false);
            for (int i11 = 0; i11 < length - 3; i11++) {
                if (bArr[i11] == 79 && bArr[i11 + 1] == 103 && bArr[i11 + 2] == 103 && bArr[i11 + 3] == 83) {
                    interfaceC1234Bt.AGP(i11);
                    return true;
                }
            }
            interfaceC1234Bt.AGP(length - 3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
    
        if (r1 > r3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
    
        if (r1 > r3) goto L25;
     */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1249Cl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long AEI(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        long j11;
        long jA03;
        switch (this.A00) {
            case 0:
                long jA7i = interfaceC1234Bt.A7i();
                this.A03 = jA7i;
                this.A00 = 1;
                long j12 = this.A08;
                if (A0D[5].charAt(14) == 'E') {
                    String[] strArr = A0D;
                    strArr[4] = "CYddPgWATLyxqxIaeTkpx7ccDiEA63Cn";
                    strArr[0] = "yHXSkk2QTXaOjUGCO1LifWaF4YjGjaVe";
                    j11 = j12 - 65307;
                } else {
                    String[] strArr2 = A0D;
                    strArr2[1] = "y7O6pPdi4ZltSjD6KADDWtfh1EQ3ypYE";
                    strArr2[2] = "PCOWfrd56ab6qHMTUxzEVaAjhpd6ZxlM";
                    j11 = j12 - 65307;
                }
                break;
            case 1:
                break;
            case 2:
                long j13 = this.A06;
                if (A0D[3].charAt(18) != 'v') {
                    throw new RuntimeException();
                }
                A0D[3] = "5HAo5Th3dlJMt4bYi9vd99sok2AKRnDx";
                if (j13 == 0) {
                    jA03 = 0;
                } else {
                    long jA01 = A01(j13, interfaceC1234Bt);
                    if (jA01 >= 0) {
                        return jA01;
                    }
                    jA03 = A03(interfaceC1234Bt, this.A06, -(jA01 + 2));
                }
                this.A00 = 3;
                return -(2 + jA03);
            case 3:
                return -1L;
            default:
                throw new IllegalStateException();
        }
        this.A07 = A02(interfaceC1234Bt);
        this.A00 = 3;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1249Cl
    public final long AGX(long j11) {
        int i11 = this.A00;
        AbstractC1351Ha.A03(i11 == 3 || i11 == 2);
        this.A06 = j11 != 0 ? this.A0B.A04(j11) : 0L;
        this.A00 = 2;
        A0B();
        return this.A06;
    }
}
