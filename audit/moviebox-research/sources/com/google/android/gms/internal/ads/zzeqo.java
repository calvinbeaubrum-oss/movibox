package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzeqo implements zzeqt {
    final /* synthetic */ zzeqp zza;

    public zzeqo(zzeqp zzeqpVar) {
        this.zza = zzeqpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzc = ((zzcwh) obj).zzl();
            ((zzcwh) obj).zzj();
        }
    }
}
