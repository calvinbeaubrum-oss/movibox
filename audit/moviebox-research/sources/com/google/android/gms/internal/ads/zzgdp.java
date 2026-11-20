package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgdp extends zzgdo {
    final AtomicReferenceFieldUpdater zza;
    final AtomicIntegerFieldUpdater zzb;

    public zzgdp(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super(null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final int zza(zzgds zzgdsVar) {
        return this.zzb.decrementAndGet(zzgdsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final void zzb(zzgds zzgdsVar, Set set, Set set2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.zza;
            if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, zzgdsVar, null, set2)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(zzgdsVar) == null);
    }
}
