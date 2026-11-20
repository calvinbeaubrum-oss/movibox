package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfcr implements zzeqt {
    final /* synthetic */ zzfcs zza;

    public zzfcr(zzfcs zzfcsVar) {
        this.zza = zzfcsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzctz zzctzVar = (zzctz) obj;
        synchronized (this.zza) {
            try {
                zzctz zzctzVar2 = this.zza.zza;
                if (zzctzVar2 != null) {
                    zzctzVar2.zzb();
                }
                zzfcs zzfcsVar = this.zza;
                zzfcsVar.zza = zzctzVar;
                zzctzVar.zzc(zzfcsVar);
                zzfcs zzfcsVar2 = this.zza;
                zzfcsVar2.zzg.zzk(new zzcua(zzctzVar, zzfcsVar2, zzfcsVar2.zzg, zzfcsVar2.zzi));
                zzctzVar.zzj();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
