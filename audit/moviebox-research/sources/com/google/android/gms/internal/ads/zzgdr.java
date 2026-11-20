package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgdr extends zzgdo {
    private zzgdr() {
        super(null);
    }

    public /* synthetic */ zzgdr(zzgdq zzgdqVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final int zza(zzgds zzgdsVar) {
        int i11;
        synchronized (zzgdsVar) {
            i11 = zzgdsVar.remaining - 1;
            zzgdsVar.remaining = i11;
        }
        return i11;
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final void zzb(zzgds zzgdsVar, Set set, Set set2) {
        synchronized (zzgdsVar) {
            try {
                if (zzgdsVar.seenExceptions == null) {
                    zzgdsVar.seenExceptions = set2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
