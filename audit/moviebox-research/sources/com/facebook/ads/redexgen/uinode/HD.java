package com.facebook.ads.redexgen.uinode;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HD implements InterfaceC1974cV {
    public final /* synthetic */ C1973cU A00;

    public HD(C1973cU c1973cU) {
        this.A00 = c1973cU;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1974cV
    public final void AD2() {
        ArrayList arrayList;
        synchronized (this.A00.A05) {
            arrayList = new ArrayList(this.A00.A05.size());
            for (Runnable runnable : this.A00.A05.values()) {
                if (runnable != null) {
                    arrayList.add(runnable);
                }
            }
            this.A00.A05.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        if (this.A00.A00 != null) {
            this.A00.A00.AD2();
        }
    }
}
