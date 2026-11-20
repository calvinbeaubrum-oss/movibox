package com.facebook.ads.redexgen.uinode;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class PC {
    public static final Map<String, WeakReference<PB>> A00 = new HashMap();

    public static int A00() {
        return A00.size();
    }

    public static PB A01(C1795Yn c1795Yn, AbstractC1898b5 abstractC1898b5, int i11, P9 p11) {
        PB pb2 = new PB(c1795Yn, abstractC1898b5, c1795Yn.A01().A09(), i11);
        pb2.A0b(p11);
        pb2.A0X();
        A00.put(abstractC1898b5.A0S(), new WeakReference<>(pb2));
        return pb2;
    }

    public static PB A02(String str) {
        WeakReference<PB> weakReference = A00.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC1898b5 abstractC1898b5, PB pb2) {
        A00.put(abstractC1898b5.A0S(), new WeakReference<>(pb2));
    }

    public static void A04(String str) {
        A00.remove(str);
    }
}
