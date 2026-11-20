package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfdp implements zzfed {
    private final zzfiv zza;
    private final Executor zzb;
    private final zzgej zzc = new zzfdn(this);

    public zzfdp(zzfiv zzfivVar, Executor executor) {
        this.zza = zzfivVar;
        this.zzb = executor;
    }

    public final /* synthetic */ s zza(zzdae zzdaeVar, zzfdy zzfdyVar) throws Exception {
        zzfiv zzfivVar = this.zza;
        zzfjf zzfjfVar = zzfdyVar.zzb;
        zzbze zzbzeVar = zzfdyVar.zza;
        zzfje zzfjeVarZzb = zzfivVar.zzb(zzfjfVar);
        if (zzfjeVarZzb != null && zzbzeVar != null) {
            zzgen.zzr(zzdaeVar.zzb().zzh(zzbzeVar), this.zzc, this.zzb);
        }
        return zzgen.zzh(new zzfdo(zzfjfVar, zzbzeVar, zzfjeVarZzb));
    }

    public final s zzb(zzfee zzfeeVar, zzfec zzfecVar, final zzdae zzdaeVar) {
        return zzgen.zze(zzgen.zzn(zzgee.zzu(new zzfdz(this.zza, zzdaeVar, this.zzb).zzc()), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfdl
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zza(zzdaeVar, (zzfdy) obj);
            }
        }, this.zzb), Exception.class, new zzfdm(this), this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* bridge */ /* synthetic */ s zzc(zzfee zzfeeVar, zzfec zzfecVar, Object obj) {
        return zzb(zzfeeVar, zzfecVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
