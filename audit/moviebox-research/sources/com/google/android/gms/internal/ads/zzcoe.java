package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcoe implements zzdxg {
    private final zzcnc zza;
    private final zzcok zzb;
    private Long zzc;
    private String zzd;

    public /* synthetic */ zzcoe(zzcnc zzcncVar, zzcok zzcokVar, zzcod zzcodVar) {
        this.zza = zzcncVar;
        this.zzb = zzcokVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg
    public final /* synthetic */ zzdxg zza(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg
    public final /* bridge */ /* synthetic */ zzdxg zzb(long j11) {
        this.zzc = Long.valueOf(j11);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg
    public final zzdxh zzc() {
        zzhhl.zzc(this.zzc, Long.class);
        zzhhl.zzc(this.zzd, String.class);
        return new zzcog(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
