package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzmc extends zzuf {
    private final zzcw zzd;

    public zzmc(zzmd zzmdVar, zzcx zzcxVar) {
        super(zzcxVar);
        this.zzd = new zzcw();
    }

    @Override // com.google.android.gms.internal.ads.zzuf, com.google.android.gms.internal.ads.zzcx
    public final zzcu zzd(int i11, zzcu zzcuVar, boolean z11) {
        zzcu zzcuVarZzd = this.zzc.zzd(i11, zzcuVar, z11);
        if (this.zzc.zze(zzcuVarZzd.zzd, this.zzd, 0L).zzb()) {
            zzcuVarZzd.zzl(zzcuVar.zzb, zzcuVar.zzc, zzcuVar.zzd, zzcuVar.zze, 0L, zzd.zza, true);
        } else {
            zzcuVarZzd.zzg = true;
        }
        return zzcuVarZzd;
    }
}
