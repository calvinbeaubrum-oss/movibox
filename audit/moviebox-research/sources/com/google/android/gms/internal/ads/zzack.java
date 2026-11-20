package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzack implements zzacv {
    private final zzu zzb;
    private final long zzc;
    private long zzd;
    private int zzf;
    private int zzg;
    private byte[] zze = new byte[65536];
    private final byte[] zza = new byte[4096];

    static {
        zzbq.zzb("media3.extractor");
    }

    public zzack(zzu zzuVar, long j11, long j12) {
        this.zzb = zzuVar;
        this.zzd = j11;
        this.zzc = j12;
    }

    private final int zzp(byte[] bArr, int i11, int i12) {
        int i13 = this.zzg;
        if (i13 == 0) {
            return 0;
        }
        int iMin = Math.min(i13, i12);
        System.arraycopy(this.zze, 0, bArr, i11, iMin);
        zzu(iMin);
        return iMin;
    }

    private final int zzq(byte[] bArr, int i11, int i12, int i13, boolean z11) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int iZza = this.zzb.zza(bArr, i11 + i13, i12 - i13);
        if (iZza != -1) {
            return i13 + iZza;
        }
        if (i13 == 0 && z11) {
            return -1;
        }
        throw new EOFException();
    }

    private final int zzr(int i11) {
        int iMin = Math.min(this.zzg, i11);
        zzu(iMin);
        return iMin;
    }

    private final void zzs(int i11) {
        if (i11 != -1) {
            this.zzd += (long) i11;
        }
    }

    private final void zzt(int i11) {
        int i12 = this.zzf + i11;
        int length = this.zze.length;
        if (i12 > length) {
            this.zze = Arrays.copyOf(this.zze, Math.max(65536 + i12, Math.min(length + length, i12 + 524288)));
        }
    }

    private final void zzu(int i11) {
        int i12 = this.zzg - i11;
        this.zzg = i12;
        this.zzf = 0;
        byte[] bArr = this.zze;
        byte[] bArr2 = i12 < bArr.length + (-524288) ? new byte[65536 + i12] : bArr;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        this.zze = bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzacv, com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws IOException {
        int iZzp = zzp(bArr, i11, i12);
        if (iZzp == 0) {
            iZzp = zzq(bArr, i11, i12, 0, true);
        }
        zzs(iZzp);
        return iZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final int zzb(byte[] bArr, int i11, int i12) throws IOException {
        int iMin;
        zzt(i12);
        int i13 = this.zzg;
        int i14 = this.zzf;
        int i15 = i13 - i14;
        if (i15 == 0) {
            iMin = zzq(this.zze, i14, i12, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.zzg += iMin;
        } else {
            iMin = Math.min(i12, i15);
        }
        System.arraycopy(this.zze, this.zzf, bArr, i11, iMin);
        this.zzf += iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final int zzc(int i11) throws IOException {
        int iZzr = zzr(1);
        if (iZzr == 0) {
            iZzr = zzq(this.zza, 0, Math.min(1, 4096), 0, true);
        }
        zzs(iZzr);
        return iZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final long zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final long zze() {
        return this.zzd + ((long) this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final long zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzg(int i11) throws IOException {
        zzl(i11, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzh(byte[] bArr, int i11, int i12) throws IOException {
        zzm(bArr, i11, i12, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzi(byte[] bArr, int i11, int i12) throws IOException {
        zzn(bArr, i11, i12, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzj() {
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final void zzk(int i11) throws IOException {
        zzo(i11, false);
    }

    public final boolean zzl(int i11, boolean z11) throws IOException {
        zzt(i11);
        int iZzq = this.zzg - this.zzf;
        while (iZzq < i11) {
            iZzq = zzq(this.zze, this.zzf, i11, iZzq, z11);
            if (iZzq == -1) {
                return false;
            }
            this.zzg = this.zzf + iZzq;
        }
        this.zzf += i11;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final boolean zzm(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        if (!zzl(i12, z11)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i12, bArr, i11, i12);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzacv
    public final boolean zzn(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        int iZzp = zzp(bArr, i11, i12);
        while (iZzp < i12 && iZzp != -1) {
            iZzp = zzq(bArr, i11, i12, iZzp, z11);
        }
        zzs(iZzp);
        return iZzp != -1;
    }

    public final boolean zzo(int i11, boolean z11) throws IOException {
        int iZzr = zzr(i11);
        while (iZzr < i11 && iZzr != -1) {
            iZzr = zzq(this.zza, -iZzr, Math.min(i11, iZzr + 4096), iZzr, false);
        }
        zzs(iZzr);
        return iZzr != -1;
    }
}
