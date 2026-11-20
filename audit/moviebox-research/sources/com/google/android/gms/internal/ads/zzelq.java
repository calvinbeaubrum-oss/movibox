package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzelq implements zzgej {
    final /* synthetic */ zzfgm zza;
    final /* synthetic */ zzelr zzb;

    public zzelq(zzelr zzelrVar, zzfgm zzfgmVar) {
        this.zza = zzfgmVar;
        this.zzb = zzelrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        synchronized (this.zzb) {
            try {
                this.zzb.zzh.zzb(th2, this.zza);
                if (this.zzb.zzh.zze()) {
                    zzelr zzelrVar = this.zzb;
                    zzelrVar.zze(zzelrVar.zzh.zza());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzemi zzemiVar = (zzemi) obj;
        synchronized (this.zzb) {
            try {
                this.zzb.zzh.zzc(zzemiVar, this.zza);
                if (this.zzb.zzh.zze()) {
                    zzelr zzelrVar = this.zzb;
                    zzelrVar.zze(zzelrVar.zzh.zza());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
