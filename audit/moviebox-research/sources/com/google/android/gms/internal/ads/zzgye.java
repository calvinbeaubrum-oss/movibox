package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgye extends zzgyh {
    private final int zzc;
    private final int zzd;

    public zzgye(byte[] bArr, int i11, int i12) {
        super(bArr);
        zzgyl.zzq(i11, i11 + i12, bArr.length);
        this.zzc = i11;
        this.zzd = i12;
    }

    @Override // com.google.android.gms.internal.ads.zzgyh, com.google.android.gms.internal.ads.zzgyl
    public final byte zza(int i11) {
        zzgyl.zzy(i11, this.zzd);
        return this.zza[this.zzc + i11];
    }

    @Override // com.google.android.gms.internal.ads.zzgyh, com.google.android.gms.internal.ads.zzgyl
    public final byte zzb(int i11) {
        return this.zza[this.zzc + i11];
    }

    @Override // com.google.android.gms.internal.ads.zzgyh
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgyh, com.google.android.gms.internal.ads.zzgyl
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgyh, com.google.android.gms.internal.ads.zzgyl
    public final void zze(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zza, this.zzc + i11, bArr, i12, i13);
    }
}
