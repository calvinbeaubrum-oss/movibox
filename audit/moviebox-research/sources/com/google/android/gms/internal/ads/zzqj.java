package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqj {
    private Boolean zza;

    public zzqj() {
    }

    public zzqj(@Nullable Context context) {
    }

    public final zzpg zza(zzam zzamVar, zzk zzkVar) {
        zzamVar.getClass();
        zzkVar.getClass();
        int i11 = zzfy.zza;
        if (i11 < 29 || zzamVar.zzA == -1) {
            return zzpg.zza;
        }
        Boolean bool = this.zza;
        if (bool != null) {
            bool.booleanValue();
        } else {
            Boolean bool2 = Boolean.FALSE;
            this.zza = bool2;
            bool2.booleanValue();
        }
        String str = zzamVar.zzm;
        str.getClass();
        int iZza = zzcb.zza(str, zzamVar.zzj);
        if (iZza == 0 || i11 < zzfy.zzf(iZza)) {
            return zzpg.zza;
        }
        int iZzg = zzfy.zzg(zzamVar.zzz);
        if (iZzg == 0) {
            return zzpg.zza;
        }
        try {
            AudioFormat audioFormatZzv = zzfy.zzv(zzamVar.zzA, iZzg, iZza);
            return i11 >= 31 ? zzqi.zza(audioFormatZzv, zzkVar.zza().zza, false) : zzqh.zza(audioFormatZzv, zzkVar.zza().zza, false);
        } catch (IllegalArgumentException unused) {
            return zzpg.zza;
        }
    }
}
