package com.facebook.ads.redexgen.uinode;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class KL {
    public static final Set<Object> A00 = Collections.newSetFromMap(new WeakHashMap());
    public static final AtomicBoolean A01 = new AtomicBoolean(true);
    public static final AtomicReference<KJ> A02 = new AtomicReference<>();

    public static void A00(Throwable th2, Object obj) throws Throwable {
        if (!A01.get()) {
            throw th2;
        }
        A00.add(obj);
        AbstractC1425Ka.A00().A9S(3306, th2);
        KJ kj2 = A02.get();
        if (kj2 != null) {
            kj2.AFC(th2, obj);
        }
    }

    public static void A01(boolean z11, KJ kj2) {
        A01.set(z11);
        A02.set(kj2);
    }

    public static boolean A02(Object obj) {
        return A00.contains(obj);
    }
}
