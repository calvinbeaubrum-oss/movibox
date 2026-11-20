package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1720Vn implements InterfaceC1346Gu {
    public static String[] A04 = {"X6WlBdbGeBIUy9RcgyD1kPyvMH5gl65h", "mWixtdhRvEEOtO49Z6LrUITCnd", "19dVuEeyHaOsnSLi", "Fh0FDziHvuuc46M8RjDn", "TMNOdV", "BntQd7XboiQ5Pp5LCDj1cbVKSXS32D1x", "NrlP0Z8V9f9J6rKzzcCufZh8yiDjfbRh", "BOidXQkRBMfwkg7VYmAkrOpgeHcKVKv0"};
    public long A00;
    public boolean A01;
    public final InterfaceC1344Gs A02;
    public final InterfaceC1346Gu A03;

    public C1720Vn(InterfaceC1346Gu interfaceC1346Gu, InterfaceC1344Gs interfaceC1344Gs) {
        this.A03 = (InterfaceC1346Gu) AbstractC1351Ha.A01(interfaceC1346Gu);
        this.A02 = (InterfaceC1344Gs) AbstractC1351Ha.A01(interfaceC1344Gs);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final Uri A8E() {
        return this.A03.A8E();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final long ADl(C1350Gy c1350Gy) throws IOException {
        long jADl = this.A03.ADl(c1350Gy);
        this.A00 = jADl;
        if (jADl == 0) {
            return 0L;
        }
        if (c1350Gy.A02 == -1 && this.A00 != -1) {
            c1350Gy = new C1350Gy(c1350Gy.A04, c1350Gy.A01, c1350Gy.A03, this.A00, c1350Gy.A05, c1350Gy.A00);
        }
        this.A01 = true;
        this.A02.ADn(c1350Gy);
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final void close() throws IOException {
        try {
            this.A03.close();
            if (this.A01) {
                this.A01 = false;
                this.A02.close();
            }
        } catch (Throwable th2) {
            boolean z11 = this.A01;
            if (A04[5].charAt(29) != 'a') {
                A04[1] = "CXpRjqYaQVmivrsYVOmY1oz";
                if (z11) {
                    this.A01 = false;
                    InterfaceC1344Gs interfaceC1344Gs = this.A02;
                    if (A04[1].length() != 2) {
                        A04[5] = "FmRI3fMemMJaQGBcEYhbAky7hUfnuUR1";
                        interfaceC1344Gs.close();
                    }
                }
                throw th2;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.A00 == 0) {
            return -1;
        }
        int i13 = this.A03.read(bArr, i11, i12);
        if (i13 > 0) {
            this.A02.write(bArr, i11, i13);
            long j11 = this.A00;
            if (j11 != -1) {
                this.A00 = j11 - ((long) i13);
            }
        }
        return i13;
    }
}
