package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzxo extends zzyc implements Comparable {
    private final int zze;
    private final int zzf;

    public zzxo(int i11, zzcz zzczVar, int i12, zzxu zzxuVar, int i13) {
        super(i11, zzczVar, i12);
        this.zze = zzyg.zzo(i13, zzxuVar.zzT) ? 1 : 0;
        this.zzf = this.zzd.zza();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxo zzxoVar) {
        return Integer.compare(this.zzf, zzxoVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        return false;
    }
}
