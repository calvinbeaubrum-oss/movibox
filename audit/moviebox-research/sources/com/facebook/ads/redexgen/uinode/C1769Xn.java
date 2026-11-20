package com.facebook.ads.redexgen.uinode;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1769Xn implements InterfaceC1234Bt {
    public static String[] A07 = {"WXHfHzHth2Al5uPNAeAj07mTCizYfL", "Ea4PVszhPWUkUOAzwMvLCDFSUaducjj7", "YmMP3hbiPsyrKpNosY6PcrNT297v1Qrn", "DJcyMwta", "hLB8mG9dKKyMH1LM5ESzC", "Vr0ZnTk4fnCFSbIFCLxfH748g1DMsTn2", "7kDa6eDxYJ9kj6HJXeCECzm6I99XwLPU", "QseCjdkBkHi9C8DCiNRIrV91qCtwuZnL"};
    public int A00;
    public int A01;
    public long A02;
    public final long A04;
    public final InterfaceC1346Gu A05;
    public byte[] A03 = new byte[65536];
    public final byte[] A06 = new byte[4096];

    public C1769Xn(InterfaceC1346Gu interfaceC1346Gu, long j11, long j12) {
        this.A05 = interfaceC1346Gu;
        this.A02 = j11;
        this.A04 = j12;
    }

    private int A00(int i11) {
        int iMin = Math.min(this.A00, i11);
        A05(iMin);
        return iMin;
    }

    private int A01(byte[] bArr, int i11, int i12) {
        int i13 = this.A00;
        if (i13 == 0) {
            return 0;
        }
        int iMin = Math.min(i13, i12);
        System.arraycopy(this.A03, 0, bArr, i11, iMin);
        A05(iMin);
        return iMin;
    }

    private int A02(byte[] bArr, int i11, int i12, int i13, boolean z11) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int i14 = this.A05.read(bArr, i11 + i13, i12 - i13);
        if (i14 != -1) {
            return i13 + i14;
        }
        if (i13 == 0 && z11) {
            return -1;
        }
        throw new EOFException();
    }

    private void A03(int i11) {
        if (i11 != -1) {
            this.A02 += (long) i11;
        }
    }

    private void A04(int i11) {
        int i12 = this.A01 + i11;
        byte[] bArr = this.A03;
        if (i12 > bArr.length) {
            this.A03 = Arrays.copyOf(this.A03, IF.A06(bArr.length * 2, 65536 + i12, 524288 + i12));
        }
    }

    private void A05(int i11) {
        int i12 = this.A00 - i11;
        this.A00 = i12;
        this.A01 = 0;
        byte[] bArr = this.A03;
        byte[] bArr2 = this.A03;
        if (i12 < bArr2.length - 524288) {
            bArr = new byte[65536 + i12];
        }
        System.arraycopy(bArr2, i11, bArr, 0, i12);
        this.A03 = bArr;
    }

    public final boolean A06(int i11, boolean z11) throws InterruptedException, IOException {
        A04(i11);
        int iMin = Math.min(this.A00 - this.A01, i11);
        while (iMin < i11) {
            iMin = A02(this.A03, this.A01, i11, iMin, z11);
            if (iMin == -1) {
                return false;
            }
        }
        int i12 = this.A01 + i11;
        this.A01 = i12;
        this.A00 = Math.max(this.A00, i12);
        return true;
    }

    public final boolean A07(int i11, boolean z11) throws InterruptedException, IOException {
        int iA00 = A00(i11);
        while (iA00 < i11 && iA00 != -1) {
            iA00 = A02(this.A06, -iA00, Math.min(i11, this.A06.length + iA00), iA00, z11);
        }
        A03(iA00);
        return iA00 != -1;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final void A3W(int i11) throws InterruptedException, IOException {
        A06(i11, false);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final long A7I() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final long A7d() {
        return this.A02 + ((long) this.A01);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final long A7i() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final void ADv(byte[] bArr, int i11, int i12) throws InterruptedException, IOException {
        ADw(bArr, i11, i12, false);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final boolean ADw(byte[] bArr, int i11, int i12, boolean z11) throws InterruptedException, IOException {
        if (!A06(i12, z11)) {
            return false;
        }
        System.arraycopy(this.A03, this.A01 - i12, bArr, i11, i12);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0051 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0056 A[RETURN, SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final boolean AEM(byte[] bArr, int i11, int i12, boolean z11) throws InterruptedException, IOException {
        int iA01 = A01(bArr, i11, i12);
        while (true) {
            String[] strArr = A07;
            if (strArr[5].charAt(6) != strArr[7].charAt(6)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "Jrnjt2kK808bOfAL2dwi4gGQEivMT1gd";
            strArr2[7] = "BeMd7gkFpNMGNNjn1C0ltMDP7X04qF1j";
            if (iA01 >= i12 || iA01 == -1) {
                A03(iA01);
                if (A07[3].length() == 12) {
                    if (iA01 != -1) {
                        return true;
                    }
                    return false;
                }
                A07[6] = "kVyK5NlwbVR8i9TPL7EEmQ28yX1F3goU";
                if (iA01 != -1) {
                    return true;
                }
                return false;
            }
            iA01 = A02(bArr, i11, i12, iA01, z11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final void AFM() {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final int AGM(int i11) throws InterruptedException, IOException {
        int iA00 = A00(i11);
        if (iA00 == 0) {
            byte[] bArr = this.A06;
            iA00 = A02(bArr, 0, Math.min(i11, bArr.length), 0, true);
        }
        A03(iA00);
        return iA00;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final void AGP(int i11) throws InterruptedException, IOException {
        A07(i11, false);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final int read(byte[] bArr, int i11, int i12) throws InterruptedException, IOException {
        int iA01 = A01(bArr, i11, i12);
        if (iA01 == 0) {
            iA01 = A02(bArr, i11, i12, 0, true);
        }
        A03(iA01);
        return iA01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1234Bt
    public final void readFully(byte[] bArr, int i11, int i12) throws InterruptedException, IOException {
        AEM(bArr, i11, i12, false);
    }
}
