package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzawm extends RuntimeException {
    public zzawm(zzavf zzavfVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzauf zza() {
        return new zzauf(getMessage());
    }
}
