package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaeb {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza(zzaea zzaeaVar, @Nullable zzadz zzadzVar) {
        if (this.zzc > 0) {
            zzaeaVar.zzt(this.zzd, this.zze, this.zzf, this.zzg, zzadzVar);
            this.zzc = 0;
        }
    }

    public final void zzb() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzc(zzaea zzaeaVar, long j11, int i11, int i12, int i13, @Nullable zzadz zzadzVar) {
        if (this.zzg > i12 + i13) {
            throw new IllegalStateException("TrueHD chunk samples must be contiguous in the sample queue.");
        }
        if (this.zzb) {
            int i14 = this.zzc;
            int i15 = i14 + 1;
            this.zzc = i15;
            if (i14 == 0) {
                this.zzd = j11;
                this.zze = i11;
                this.zzf = 0;
            }
            this.zzf += i12;
            this.zzg = i13;
            if (i15 >= 16) {
                zza(zzaeaVar, zzadzVar);
            }
        }
    }

    public final void zzd(zzacv zzacvVar) throws IOException {
        if (this.zzb) {
            return;
        }
        zzacvVar.zzh(this.zza, 0, 10);
        zzacvVar.zzj();
        byte[] bArr = this.zza;
        int i11 = zzabv.zza;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.zzb = true;
        }
    }
}
