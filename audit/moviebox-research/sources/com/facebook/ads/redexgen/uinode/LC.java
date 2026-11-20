package com.facebook.ads.redexgen.uinode;

import android.util.DisplayMetrics;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class LC {
    public static final AtomicReference<DisplayMetrics> A00 = new AtomicReference<>();

    public static DisplayMetrics A00() {
        AtomicReference<DisplayMetrics> atomicReference = A00;
        return atomicReference.get() != null ? atomicReference.get() : LD.A03;
    }
}
