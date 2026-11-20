package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class WW implements InterfaceC1293Eq {
    public static String[] A05 = {"2", "A1R5XmGNdue", "Xf2fF", "2MZr802CwBgh98iwI2LX9r8AFH0stAP", "PWtCslqWMOhLlWMecFeGOSMcL", "Nab9jbcw8W2RSLeSFi8qaY40Uhnm56i", "UlYKNWRAV2IAyBS", "QHLbHyQnMMy3J3Z"};
    public Y6 A00;
    public AH A01;
    public Object A02;
    public final ArrayList<InterfaceC1292Ep> A04 = new ArrayList<>(1);
    public final F1 A03 = new F1();

    public final F1 A00(C1291Eo c1291Eo) {
        return this.A03.A02(0, c1291Eo, 0L);
    }

    public final void A01(AH ah2, Object obj) {
        this.A01 = ah2;
        this.A02 = obj;
        Iterator<InterfaceC1292Ep> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().ADA(this, ah2, obj);
        }
    }

    public abstract void A02();

    public abstract void A03(Y6 y11, boolean z11);

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1293Eq
    public final void A3O(Handler handler, F4 f11) {
        this.A03.A07(handler, f11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1293Eq
    public final void AE7(Y6 y11, boolean z11, InterfaceC1292Ep interfaceC1292Ep) {
        Y6 y12 = this.A00;
        AbstractC1351Ha.A03(y12 == null || y12 == y11);
        this.A04.add(interfaceC1292Ep);
        if (this.A00 == null) {
            this.A00 = y11;
            A03(y11, z11);
        } else {
            AH ah2 = this.A01;
            if (ah2 != null) {
                interfaceC1292Ep.ADA(this, ah2, this.A02);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1293Eq
    public final void AEb(InterfaceC1292Ep interfaceC1292Ep) {
        this.A04.remove(interfaceC1292Ep);
        if (this.A04.isEmpty()) {
            this.A00 = null;
            this.A01 = null;
            if (A05[2].length() == 23) {
                throw new RuntimeException();
            }
            A05[2] = "TEgrTEJPhaeJK53iaQZF";
            this.A02 = null;
            A02();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1293Eq
    public final void AF7(F4 f11) {
        this.A03.A0D(f11);
    }
}
