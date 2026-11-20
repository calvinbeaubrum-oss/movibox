package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgea extends zzgdm {
    private zzgdz zza;

    public zzgea(zzfzv zzfzvVar, boolean z11, Executor executor, Callable callable) {
        super(zzfzvVar, z11, false);
        this.zza = new zzgdy(this, callable, executor);
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgdm
    public final void zzf(int i11, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final void zzq() {
        zzgdz zzgdzVar = this.zza;
        if (zzgdzVar != null) {
            zzgdzVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdm
    public final void zzu() {
        zzgdz zzgdzVar = this.zza;
        if (zzgdzVar != null) {
            zzgdzVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdm
    public final void zzy(int i11) {
        super.zzy(i11);
        if (i11 == 1) {
            this.zza = null;
        }
    }
}
