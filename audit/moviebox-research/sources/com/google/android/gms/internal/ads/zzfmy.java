package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.s;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfmy {
    public static void zza(s sVar, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        zzg(sVar, zzfmzVar, zzfmoVar, false);
    }

    public static void zzb(s sVar, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        zzg(sVar, zzfmzVar, zzfmoVar, true);
    }

    public static void zzc(s sVar, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzgen.zzr(zzgee.zzu(sVar), new zzfmx(zzfmzVar, zzfmoVar), zzcep.zzf);
        }
    }

    public static void zzd(s sVar, zzfmo zzfmoVar) {
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzgen.zzr(zzgee.zzu(sVar), new zzfmv(zzfmoVar), zzcep.zzf);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziH), str);
    }

    public static int zzf(zzfhh zzfhhVar) {
        int iZze = com.google.android.gms.ads.nonagon.signalgeneration.zzf.zze(zzfhhVar) - 1;
        return (iZze == 0 || iZze == 1) ? 7 : 23;
    }

    private static void zzg(s sVar, zzfmz zzfmzVar, zzfmo zzfmoVar, boolean z11) {
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzgen.zzr(zzgee.zzu(sVar), new zzfmw(zzfmzVar, zzfmoVar, z11), zzcep.zzf);
        }
    }
}
