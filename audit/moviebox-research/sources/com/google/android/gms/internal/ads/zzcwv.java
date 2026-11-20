package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcwv implements zzgej {
    final /* synthetic */ zzgej zza;
    final /* synthetic */ zzcww zzb;

    public zzcwv(zzcww zzcwwVar, zzgej zzgejVar) {
        this.zza = zzgejVar;
        this.zzb = zzcwwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcwq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
        this.zza.zza(th2);
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcwq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
        this.zza.zzb((zzcwh) obj);
    }
}
