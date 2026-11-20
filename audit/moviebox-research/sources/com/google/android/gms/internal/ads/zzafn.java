package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzafn extends zzadi {
    private final long zza;

    public zzafn(zzacv zzacvVar, long j11) {
        super(zzacvVar);
        zzek.zzd(zzacvVar.zzf() >= j11);
        this.zza = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzadi, com.google.android.gms.internal.ads.zzacv
    public final long zzd() {
        return super.zzd() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzadi, com.google.android.gms.internal.ads.zzacv
    public final long zze() {
        return super.zze() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzadi, com.google.android.gms.internal.ads.zzacv
    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
