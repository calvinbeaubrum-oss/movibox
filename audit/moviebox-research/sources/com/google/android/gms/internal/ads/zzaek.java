package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaek implements zzadu {
    final /* synthetic */ zzaen zza;
    private final long zzb;

    public zzaek(zzaen zzaenVar, long j11) {
        this.zza = zzaenVar;
        this.zzb = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        zzads zzadsVarZza = this.zza.zzg[0].zza(j11);
        int i11 = 1;
        while (true) {
            zzaen zzaenVar = this.zza;
            if (i11 >= zzaenVar.zzg.length) {
                return zzadsVarZza;
            }
            zzads zzadsVarZza2 = zzaenVar.zzg[i11].zza(j11);
            if (zzadsVarZza2.zza.zzc < zzadsVarZza.zza.zzc) {
                zzadsVarZza = zzadsVarZza2;
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
