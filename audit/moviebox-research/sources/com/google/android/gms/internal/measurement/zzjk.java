package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjk extends IOException {
    public zzjk() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzjk(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    public zzjk(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
