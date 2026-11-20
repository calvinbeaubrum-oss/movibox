package com.facebook.ads.redexgen.uinode;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class KG implements Runnable {
    public static final AtomicReference<Throwable> A00 = new AtomicReference<>();

    public static Throwable A00() {
        return A00.get();
    }

    public abstract void A01();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            A01();
        } catch (Throwable th2) {
            A00.set(th2);
            throw th2;
        }
    }
}
