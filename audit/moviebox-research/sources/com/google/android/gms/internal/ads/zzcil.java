package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcil implements zzgw {
    private final zzgw zza;
    private final long zzb;
    private final zzgw zzc;
    private long zzd;
    private Uri zze;

    public zzcil(zzgw zzgwVar, int i11, zzgw zzgwVar2) {
        this.zza = zzgwVar;
        this.zzb = i11;
        this.zzc = zzgwVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        long j11 = this.zzd;
        long j12 = this.zzb;
        if (j11 < j12) {
            int iZza = this.zza.zza(bArr, i11, (int) Math.min(i12, j12 - j11));
            long j13 = this.zzd + ((long) iZza);
            this.zzd = j13;
            i13 = iZza;
            j11 = j13;
        } else {
            i13 = 0;
        }
        if (j11 < this.zzb) {
            return i13;
        }
        int iZza2 = this.zzc.zza(bArr, i11 + i13, i12 - i13);
        int i14 = i13 + iZza2;
        this.zzd += (long) iZza2;
        return i14;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws IOException {
        zzhb zzhbVar2;
        this.zze = zzhbVar.zza;
        long j11 = this.zzb;
        long j12 = zzhbVar.zzf;
        zzhb zzhbVar3 = null;
        if (j12 >= j11) {
            zzhbVar2 = null;
        } else {
            long j13 = zzhbVar.zzg;
            long jMin = j11 - j12;
            if (j13 != -1) {
                jMin = Math.min(j13, jMin);
            }
            zzhbVar2 = new zzhb(zzhbVar.zza, null, j12, j12, jMin, null, 0);
        }
        long j14 = zzhbVar.zzg;
        if (j14 == -1 || zzhbVar.zzf + j14 > this.zzb) {
            long jMax = Math.max(this.zzb, zzhbVar.zzf);
            long j15 = zzhbVar.zzg;
            zzhbVar3 = new zzhb(zzhbVar.zza, null, jMax, jMax, j15 != -1 ? Math.min(j15, (zzhbVar.zzf + j15) - this.zzb) : -1L, null, 0);
        }
        long jZzb = zzhbVar2 != null ? this.zza.zzb(zzhbVar2) : 0L;
        long jZzb2 = zzhbVar3 != null ? this.zzc.zzb(zzhbVar3) : 0L;
        this.zzd = zzhbVar.zzf;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Map zze() {
        return zzgad.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzf(zzhy zzhyVar) {
    }
}
