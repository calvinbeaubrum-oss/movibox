package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzafo extends zzadj {
    final /* synthetic */ zzadu zza;
    final /* synthetic */ zzafp zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzafo(zzafp zzafpVar, zzadu zzaduVar, zzadu zzaduVar2) {
        super(zzaduVar);
        this.zza = zzaduVar2;
        this.zzb = zzafpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadj, com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        zzads zzadsVarZzg = this.zza.zzg(j11);
        zzadv zzadvVar = zzadsVarZzg.zza;
        zzadv zzadvVar2 = new zzadv(zzadvVar.zzb, zzadvVar.zzc + this.zzb.zzb);
        zzadv zzadvVar3 = zzadsVarZzg.zzb;
        return new zzads(zzadvVar2, new zzadv(zzadvVar3.zzb, zzadvVar3.zzc + this.zzb.zzb));
    }
}
