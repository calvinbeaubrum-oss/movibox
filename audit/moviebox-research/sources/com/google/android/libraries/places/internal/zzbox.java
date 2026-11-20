package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbox {
    private final AtomicLong zza = new AtomicLong();

    public final long zza(long j11) {
        return this.zza.addAndGet(j11);
    }
}
