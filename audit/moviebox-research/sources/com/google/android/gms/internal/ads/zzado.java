package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzado {
    public int zza;

    @Nullable
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public final boolean zza(int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        if (!zzadp.zzm(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
            return false;
        }
        int i16 = i14 - 1;
        this.zza = i12;
        this.zzb = zzadp.zza[3 - i13];
        int i17 = zzadp.zzb[i15];
        this.zzd = i17;
        if (i12 == 2) {
            i17 /= 2;
            this.zzd = i17;
        } else if (i12 == 0) {
            i17 /= 4;
            this.zzd = i17;
        }
        int i18 = (i11 >>> 9) & 1;
        this.zzg = zzadp.zzl(i12, i13);
        if (i13 == 3) {
            int i19 = i12 == 3 ? zzadp.zzc[i16] : zzadp.zzd[i16];
            this.zzf = i19;
            this.zzc = (((i19 * 12) / i17) + i18) * 4;
        } else {
            if (i12 == 3) {
                int i21 = i13 == 2 ? zzadp.zze[i16] : zzadp.zzf[i16];
                this.zzf = i21;
                this.zzc = ((i21 * 144) / i17) + i18;
            } else {
                int i22 = zzadp.zzg[i16];
                this.zzf = i22;
                this.zzc = (((i13 == 1 ? 72 : 144) * i22) / i17) + i18;
            }
        }
        this.zze = ((i11 >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
