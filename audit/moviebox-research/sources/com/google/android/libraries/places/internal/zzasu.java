package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzasu extends IOException {
    public zzasu() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzasu(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    public zzasu(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
