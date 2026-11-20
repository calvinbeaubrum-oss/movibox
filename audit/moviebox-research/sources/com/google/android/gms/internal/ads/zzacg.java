package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzacg {
    protected final zzaca zza;
    protected final zzacf zzb;

    @Nullable
    protected zzacc zzc;
    private final int zzd;

    public zzacg(zzacd zzacdVar, zzacf zzacfVar, long j11, long j12, long j13, long j14, long j15, long j16, int i11) {
        this.zzb = zzacfVar;
        this.zzd = i11;
        this.zza = new zzaca(zzacdVar, j11, 0L, j13, j14, j15, j16);
    }

    public static final int zzf(zzacv zzacvVar, long j11, zzadr zzadrVar) {
        if (j11 == zzacvVar.zzf()) {
            return 0;
        }
        zzadrVar.zza = j11;
        return 1;
    }

    public static final boolean zzg(zzacv zzacvVar, long j11) throws IOException {
        long jZzf = j11 - zzacvVar.zzf();
        if (jZzf < 0 || jZzf > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        ((zzack) zzacvVar).zzo((int) jZzf, false);
        return true;
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        while (true) {
            zzacc zzaccVar = this.zzc;
            zzek.zzb(zzaccVar);
            long j11 = zzaccVar.zzf;
            long j12 = zzaccVar.zzg - j11;
            int i11 = this.zzd;
            long j13 = zzaccVar.zzh;
            if (j12 <= i11) {
                zzc(false, j11);
                return zzf(zzacvVar, j11, zzadrVar);
            }
            if (!zzg(zzacvVar, j13)) {
                return zzf(zzacvVar, j13, zzadrVar);
            }
            zzacvVar.zzj();
            zzace zzaceVarZza = this.zzb.zza(zzacvVar, zzaccVar.zzb);
            int i12 = zzaceVarZza.zzb;
            if (i12 == -3) {
                zzc(false, j13);
                return zzf(zzacvVar, j13, zzadrVar);
            }
            if (i12 == -2) {
                zzacc.zzh(zzaccVar, zzaceVarZza.zzc, zzaceVarZza.zzd);
            } else {
                if (i12 != -1) {
                    zzg(zzacvVar, zzaceVarZza.zzd);
                    zzc(true, zzaceVarZza.zzd);
                    return zzf(zzacvVar, zzaceVarZza.zzd, zzadrVar);
                }
                zzacc.zzg(zzaccVar, zzaceVarZza.zzc, zzaceVarZza.zzd);
            }
        }
    }

    public final zzadu zzb() {
        return this.zza;
    }

    public final void zzc(boolean z11, long j11) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j11) {
        zzacc zzaccVar = this.zzc;
        if (zzaccVar == null || zzaccVar.zza != j11) {
            zzaca zzacaVar = this.zza;
            this.zzc = new zzacc(j11, zzacaVar.zzf(j11), 0L, zzacaVar.zzc, zzacaVar.zzd, zzacaVar.zze, zzacaVar.zzf);
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
