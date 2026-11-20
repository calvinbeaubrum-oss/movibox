package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzj extends IOException {
    public zzzj(Throwable th2) {
        super("Unexpected " + th2.getClass().getSimpleName() + (th2.getMessage() != null ? ": ".concat(String.valueOf(th2.getMessage())) : ""), th2);
    }
}
