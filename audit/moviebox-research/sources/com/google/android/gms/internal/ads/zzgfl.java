package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgfl extends zzgew {
    final /* synthetic */ zzgfn zza;
    private final zzgdt zzb;

    public zzgfl(zzgfn zzgfnVar, zzgdt zzgdtVar) {
        this.zza = zzgfnVar;
        this.zzb = zzgdtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzgdt zzgdtVar = this.zzb;
        s sVarZza = zzgdtVar.zza();
        zzfxe.zzd(sVarZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgdtVar);
        return sVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    public final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    public final void zzd(Throwable th2) {
        this.zza.zzd(th2);
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    public final /* synthetic */ void zze(Object obj) {
        this.zza.zzs((s) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    public final boolean zzg() {
        return this.zza.isDone();
    }
}
