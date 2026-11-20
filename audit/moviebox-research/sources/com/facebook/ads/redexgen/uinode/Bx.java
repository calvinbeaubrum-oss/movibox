package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Bx {
    public static String[] A01 = {"jIa5nEsghJXI3YtRygMiM4nRYP", "Ly9ufvl5ownJqyYsGEEXhuulkxQO72eL", "sMPtg", "IfecpjktAKGmFhJKDBvdKsFSs", "x3OFnvvirXrPXrYRolaRsAtReKUP", "t7Io5cjMF1OaMgplIhuUmJuHh", "FmC7xp59Mv4zEWANQ3dHM2IzVgPFt2kt", "Z77KJEO3n3QLGnllHMFWIwXSkpKCnreC"};
    public final C1376Hz A00 = new C1376Hz(10);

    public final Metadata A00(InterfaceC1234Bt interfaceC1234Bt, InterfaceC1266Di interfaceC1266Di) throws InterruptedException, IOException {
        int i11 = 0;
        Metadata metadataA0O = null;
        while (true) {
            try {
                interfaceC1234Bt.ADv(this.A00.A00, 0, 10);
                this.A00.A0Y(0);
                if (this.A00.A0G() != C1734Wd.A03) {
                    break;
                }
                this.A00.A0Z(3);
                int iA0D = this.A00.A0D();
                int i12 = iA0D + 10;
                if (metadataA0O == null) {
                    byte[] bArr = new byte[i12];
                    System.arraycopy(this.A00.A00, 0, bArr, 0, 10);
                    interfaceC1234Bt.ADv(bArr, 10, iA0D);
                    metadataA0O = new C1734Wd(interfaceC1266Di).A0O(bArr, i12);
                } else {
                    interfaceC1234Bt.A3W(iA0D);
                }
                i11 += i12;
            } catch (EOFException unused) {
            }
        }
        interfaceC1234Bt.AFM();
        interfaceC1234Bt.A3W(i11);
        if (A01[1].charAt(2) != '9') {
            throw new RuntimeException();
        }
        A01[6] = "WrSJC1Ub8dr1CYR3Oq5fRcEdvzu2UCyy";
        return metadataA0O;
    }
}
