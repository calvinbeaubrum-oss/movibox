package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzadi implements zzacv {
    private final zzacv zza;

    public zzadi(zzacv zzacvVar) {
        this.zza = zzacvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacv, com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws IOException {
        return this.zza.zza(bArr, i11, i12);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final int zzb(byte[] bArr, int i11, int i12) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final int zzc(int i11) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public long zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public long zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public long zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzg(int i11) throws IOException {
        ((zzack) this.zza).zzl(i11, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzh(byte[] bArr, int i11, int i12) throws IOException {
        ((zzack) this.zza).zzm(bArr, i11, i12, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzi(byte[] bArr, int i11, int i12) throws IOException {
        ((zzack) this.zza).zzn(bArr, i11, i12, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzj() {
        this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzk(int i11) throws IOException {
        ((zzack) this.zza).zzo(i11, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final boolean zzm(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        return this.zza.zzm(bArr, 0, 8, true);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final boolean zzn(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        return this.zza.zzn(bArr, 0, 8, true);
    }
}
