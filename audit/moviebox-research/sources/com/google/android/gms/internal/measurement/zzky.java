package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzky extends zzla {
    private zzky() {
        super(null);
    }

    public /* synthetic */ zzky(zzkx zzkxVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zza(Object obj, long j11) {
        ((zzkm) zzmy.zzf(obj, j11)).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zzb(Object obj, Object obj2, long j11) {
        zzkm zzkmVarZzd = (zzkm) zzmy.zzf(obj, j11);
        zzkm zzkmVar = (zzkm) zzmy.zzf(obj2, j11);
        int size = zzkmVarZzd.size();
        int size2 = zzkmVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzkmVarZzd.zzc()) {
                zzkmVarZzd = zzkmVarZzd.zzd(size2 + size);
            }
            zzkmVarZzd.addAll(zzkmVar);
        }
        if (size > 0) {
            zzkmVar = zzkmVarZzd;
        }
        zzmy.zzs(obj, j11, zzkmVar);
    }
}
