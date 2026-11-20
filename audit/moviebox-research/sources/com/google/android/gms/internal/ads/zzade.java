package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzade {
    @Nullable
    public static zzby zza(zzacv zzacvVar, boolean z11) throws IOException {
        zzby zzbyVarZza = new zzadm().zza(zzacvVar, z11 ? null : zzagq.zza);
        if (zzbyVarZza == null || zzbyVarZza.zza() == 0) {
            return null;
        }
        return zzbyVarZza;
    }

    public static zzadg zzb(zzfp zzfpVar) {
        zzfpVar.zzL(1);
        int iZzo = zzfpVar.zzo();
        long jZzd = zzfpVar.zzd();
        long j11 = iZzo;
        int i11 = iZzo / 18;
        long[] jArrCopyOf = new long[i11];
        long[] jArrCopyOf2 = new long[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            long jZzt = zzfpVar.zzt();
            if (jZzt == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i12);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i12);
                break;
            }
            jArrCopyOf[i12] = jZzt;
            jArrCopyOf2[i12] = zzfpVar.zzt();
            zzfpVar.zzL(2);
        }
        zzfpVar.zzL((int) ((jZzd + j11) - ((long) zzfpVar.zzd())));
        return new zzadg(jArrCopyOf, jArrCopyOf2);
    }
}
