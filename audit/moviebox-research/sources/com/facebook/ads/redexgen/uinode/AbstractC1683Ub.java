package com.facebook.ads.redexgen.uinode;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ub, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1683Ub<T> extends KT {
    public final WeakReference<T> A00;

    public AbstractC1683Ub(T t11) {
        this.A00 = new WeakReference<>(t11);
    }

    public final T A07() {
        return this.A00.get();
    }
}
