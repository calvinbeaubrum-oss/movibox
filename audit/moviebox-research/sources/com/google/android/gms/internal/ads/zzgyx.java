package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgyx extends IOException {
    public zzgyx() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzgyx(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    public zzgyx(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
