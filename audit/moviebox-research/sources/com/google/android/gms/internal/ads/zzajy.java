package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajy {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzfp zzg = new zzfp(255);

    public final void zza() {
        this.zza = 0;
        this.zzb = 0L;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzacv zzacvVar, boolean z11) throws IOException {
        zza();
        this.zzg.zzH(27);
        if (zzacy.zzc(zzacvVar, this.zzg.zzM(), 0, 27, z11) && this.zzg.zzu() == 1332176723) {
            if (this.zzg.zzm() != 0) {
                if (z11) {
                    return false;
                }
                throw zzcc.zzc("unsupported bit stream revision");
            }
            this.zza = this.zzg.zzm();
            this.zzb = this.zzg.zzr();
            this.zzg.zzs();
            this.zzg.zzs();
            this.zzg.zzs();
            int iZzm = this.zzg.zzm();
            this.zzc = iZzm;
            this.zzd = iZzm + 27;
            this.zzg.zzH(iZzm);
            if (zzacy.zzc(zzacvVar, this.zzg.zzM(), 0, this.zzc, z11)) {
                for (int i11 = 0; i11 < this.zzc; i11++) {
                    this.zzf[i11] = this.zzg.zzm();
                    this.zze += this.zzf[i11];
                }
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzacv zzacvVar, long j11) throws IOException {
        zzek.zzd(zzacvVar.zzf() == zzacvVar.zze());
        this.zzg.zzH(4);
        while (true) {
            if ((j11 != -1 && zzacvVar.zzf() + 4 >= j11) || !zzacy.zzc(zzacvVar, this.zzg.zzM(), 0, 4, true)) {
                break;
            }
            this.zzg.zzK(0);
            if (this.zzg.zzu() == 1332176723) {
                zzacvVar.zzj();
                return true;
            }
            ((zzack) zzacvVar).zzo(1, false);
        }
        do {
            if (j11 != -1 && zzacvVar.zzf() >= j11) {
                break;
            }
        } while (zzacvVar.zzc(1) != -1);
        return false;
    }
}
