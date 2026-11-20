package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaex implements zzacf {
    private final zzadh zza;
    private final int zzb;
    private final zzadc zzc = new zzadc();

    public /* synthetic */ zzaex(zzadh zzadhVar, int i11, zzaew zzaewVar) {
        this.zza = zzadhVar;
        this.zzb = i11;
    }

    private final long zzc(zzacv zzacvVar) throws IOException {
        while (zzacvVar.zze() < zzacvVar.zzd() - 6) {
            zzadh zzadhVar = this.zza;
            int i11 = this.zzb;
            zzadc zzadcVar = this.zzc;
            long jZze = zzacvVar.zze();
            byte[] bArr = new byte[2];
            zzack zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i11) {
                zzacvVar.zzj();
                zzackVar.zzl((int) (jZze - zzacvVar.zzf()), false);
            } else {
                zzfp zzfpVar = new zzfp(16);
                System.arraycopy(bArr, 0, zzfpVar.zzM(), 0, 2);
                zzfpVar.zzJ(zzacy.zza(zzacvVar, zzfpVar.zzM(), 2, 14));
                zzacvVar.zzj();
                zzackVar.zzl((int) (jZze - zzacvVar.zzf()), false);
                if (zzadd.zzc(zzfpVar, zzadhVar, i11, zzadcVar)) {
                    break;
                }
            }
            zzackVar.zzl(1, false);
        }
        if (zzacvVar.zze() < zzacvVar.zzd() - 6) {
            return this.zzc.zza;
        }
        ((zzack) zzacvVar).zzl((int) (zzacvVar.zzd() - zzacvVar.zze()), false);
        return this.zza.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final zzace zza(zzacv zzacvVar, long j11) throws IOException {
        int i11 = this.zza.zzc;
        long jZzf = zzacvVar.zzf();
        long jZzc = zzc(zzacvVar);
        long jZze = zzacvVar.zze();
        ((zzack) zzacvVar).zzl(Math.max(6, i11), false);
        long jZzc2 = zzc(zzacvVar);
        long jZze2 = zzacvVar.zze();
        if (jZzc > j11 || jZzc2 <= j11) {
            return jZzc2 <= j11 ? zzace.zzf(jZzc2, jZze2) : zzace.zzd(jZzc, jZzf);
        }
        return zzace.zze(jZze);
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final /* synthetic */ void zzb() {
    }
}
