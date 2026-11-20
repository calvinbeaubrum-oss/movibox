package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zze extends zzcec {
    public static void zza(String str) {
        if (zzc()) {
            if (str == null || str.length() <= 4000) {
                Log.v("Ads", str);
                return;
            }
            boolean z11 = true;
            for (String str2 : zzcec.zza.zzd(str)) {
                if (z11) {
                    Log.v("Ads", str2);
                } else {
                    Log.v("Ads-cont", str2);
                }
                z11 = false;
            }
        }
    }

    public static void zzb(String str, Throwable th2) {
        if (zzc()) {
            Log.v("Ads", str, th2);
        }
    }

    public static boolean zzc() {
        return zzcec.zzm(2) && ((Boolean) zzbid.zza.zze()).booleanValue();
    }
}
