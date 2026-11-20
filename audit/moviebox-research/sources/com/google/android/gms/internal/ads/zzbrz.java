package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbrz implements zzcew {
    final /* synthetic */ zzceu zza;
    final /* synthetic */ zzbrd zzb;

    public zzbrz(zzbsb zzbsbVar, zzceu zzceuVar, zzbrd zzbrdVar) {
        this.zza = zzceuVar;
        this.zzb = zzbrdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcew
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbrm("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
