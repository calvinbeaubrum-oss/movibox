package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CG {
    public static String[] A02 = {"ESBDEf5TGpIlPNlaK", "CFy8tTB", "6qe0qu0ibVEcKGfh7EvVwRhtqHBuEa1w", "V1Y5IBnxryXU9mIwJ4bJ5ToLD3C0Yk13", "4NTFTO6GqkeHPDwUARd0ySppWOd6l1dR", "CrEf7MIuMgaulYPqfRythdBqg4S56GJr", "vnXboZq45YJMaiP9ml0KXw1b9fE53h1M", "mdidS6i6KL2UNszMr3NEyBGV7VKvKKkC"};
    public int A00;
    public final C1376Hz A01 = new C1376Hz(8);

    private long A00(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        interfaceC1234Bt.ADv(this.A01.A00, 0, 1);
        int i11 = this.A01.A00[0] & 255;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int i12 = 128;
        int i13 = 0;
        while ((i11 & i12) == 0) {
            i12 >>= 1;
            i13++;
        }
        int i14 = i11 & (i12 ^ (-1));
        interfaceC1234Bt.ADv(this.A01.A00, 1, i13);
        for (int i15 = 0; i15 < i13; i15++) {
            i14 = (i14 << 8) + (this.A01.A00[i15 + 1] & 255);
        }
        this.A00 += i13 + 1;
        return i14;
    }

    public final boolean A01(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        long jA7I = interfaceC1234Bt.A7I();
        long j11 = 1024;
        if (jA7I != -1 && jA7I <= 1024) {
            j11 = jA7I;
        }
        int i11 = (int) j11;
        interfaceC1234Bt.ADv(this.A01.A00, 0, 4);
        long jA0M = this.A01.A0M();
        this.A00 = 4;
        while (jA0M != 440786851) {
            int i12 = this.A00 + 1;
            this.A00 = i12;
            String[] strArr = A02;
            if (strArr[0].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "l1PkIDTfiQThV6hLB2tjOKdQnzuVnbjV";
            strArr2[7] = "5y1xvAdDSVehJ56urXHmNFO2pNzfP9GT";
            if (i12 == i11) {
                return false;
            }
            interfaceC1234Bt.ADv(this.A01.A00, 0, 1);
            jA0M = ((jA0M << 8) & (-256)) | ((long) (this.A01.A00[0] & 255));
        }
        long jA00 = A00(interfaceC1234Bt);
        long j12 = this.A00;
        if (jA00 == Long.MIN_VALUE || (jA7I != -1 && j12 + jA00 >= jA7I)) {
            return false;
        }
        while (true) {
            int i13 = this.A00;
            if (i13 >= j12 + jA00) {
                return ((long) i13) == j12 + jA00;
            }
            long jA01 = A00(interfaceC1234Bt);
            if (A02[2].charAt(30) == 'F') {
                throw new RuntimeException();
            }
            A02[4] = "KE3nQOOCyGcxuS2VNFQSv9Xwlad9oCTx";
            if (jA01 == Long.MIN_VALUE) {
                return false;
            }
            long jA02 = A00(interfaceC1234Bt);
            if (jA02 >= 0) {
                if (A02[5].charAt(8) != 'M') {
                    throw new RuntimeException();
                }
                A02[4] = "oAhGCMJduqwag2F3qzvWFprzvodLwUMc";
                if (jA02 <= 2147483647L) {
                    if (jA02 != 0) {
                        int i14 = (int) jA02;
                        String[] strArr3 = A02;
                        if (strArr3[0].length() != strArr3[1].length()) {
                            String[] strArr4 = A02;
                            strArr4[3] = "DpgTASio69ZqWxB525eChTWXhoKF6GpR";
                            strArr4[7] = "IdVdUYmR5RRrY4br74pFew5qFgYpPWK6";
                            interfaceC1234Bt.A3W(i14);
                            this.A00 += i14;
                        } else {
                            A02[4] = "dJss32nVjAcsiV2OBHnTjFQq6mdmK3qb";
                            interfaceC1234Bt.A3W(i14);
                            this.A00 += i14;
                        }
                    }
                }
            }
            return false;
        }
    }
}
