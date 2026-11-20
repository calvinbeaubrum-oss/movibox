package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgcx extends zzgcz {
    public zzgcx(s sVar, Class cls, zzgdu zzgduVar) {
        super(sVar, cls, zzgduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgcz
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th2) throws Exception {
        zzgdu zzgduVar = (zzgdu) obj;
        s sVarZza = zzgduVar.zza(th2);
        zzfxe.zzd(sVarZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgduVar);
        return sVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgcz
    public final /* synthetic */ void zzf(Object obj) {
        zzs((s) obj);
    }
}
