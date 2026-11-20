package com.facebook.ads.redexgen.uinode;

import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1225Bk implements InterfaceC1715Vi, Comparator<HO> {
    public long A00;
    public final long A01;
    public final TreeSet<HO> A02 = new TreeSet<>(this);

    public C1225Bk(long j11) {
        this.A01 = j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(HO ho2, HO ho3) {
        if (ho2.A00 - ho3.A00 == 0) {
            return ho2.compareTo(ho3);
        }
        return ho2.A00 < ho3.A00 ? -1 : 1;
    }

    private void A01(HK hk2, long j11) {
        while (this.A00 + j11 > this.A01 && !this.A02.isEmpty()) {
            try {
                hk2.AF9(this.A02.first());
            } catch (HI unused) {
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.HJ
    public final void ADB(HK hk2, HO ho2) {
        this.A02.add(ho2);
        this.A00 += ho2.A01;
        A01(hk2, 0L);
    }

    @Override // com.facebook.ads.redexgen.uinode.HJ
    public final void ADC(HK hk2, HO ho2) {
        this.A02.remove(ho2);
        this.A00 -= ho2.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.HJ
    public final void ADD(HK hk2, HO ho2, HO ho3) {
        ADC(hk2, ho2);
        ADB(hk2, ho3);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1715Vi
    public final void ADE(HK hk2, String str, long j11, long j12) {
        A01(hk2, j12);
    }
}
