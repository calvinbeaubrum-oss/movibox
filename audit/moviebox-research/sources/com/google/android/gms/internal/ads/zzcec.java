package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzcec {
    protected static final zzfxr zza = zzfxr.zzb(4000);

    public static String zzd(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        return str + " @" + stackTrace[3].getLineNumber();
    }

    public static void zze(String str) {
        if (!zzm(3) || str == null || str.length() <= 4000) {
            return;
        }
        for (String str2 : zza.zzd(str)) {
        }
    }

    public static void zzf(String str, Throwable th2) {
        zzm(3);
    }

    public static void zzg(String str) {
        if (zzm(6)) {
            if (str == null || str.length() <= 4000) {
                Log.e("Ads", str);
                return;
            }
            boolean z11 = true;
            for (String str2 : zza.zzd(str)) {
                if (z11) {
                    Log.e("Ads", str2);
                } else {
                    Log.e("Ads-cont", str2);
                }
                z11 = false;
            }
        }
    }

    public static void zzh(String str, Throwable th2) {
        if (zzm(6)) {
            Log.e("Ads", str, th2);
        }
    }

    public static void zzi(String str) {
        if (!zzm(4) || str == null || str.length() <= 4000) {
            return;
        }
        for (String str2 : zza.zzd(str)) {
        }
    }

    public static void zzj(String str) {
        if (zzm(5)) {
            if (str == null || str.length() <= 4000) {
                Log.w("Ads", str);
                return;
            }
            boolean z11 = true;
            for (String str2 : zza.zzd(str)) {
                if (z11) {
                    Log.w("Ads", str2);
                } else {
                    Log.w("Ads-cont", str2);
                }
                z11 = false;
            }
        }
    }

    public static void zzk(String str, Throwable th2) {
        if (zzm(5)) {
            Log.w("Ads", str, th2);
        }
    }

    public static void zzl(String str, @Nullable Throwable th2) {
        if (zzm(5)) {
            if (th2 != null) {
                zzk(zzd(str), th2);
            } else {
                zzj(zzd(str));
            }
        }
    }

    public static boolean zzm(int i11) {
        return i11 >= 5 || Log.isLoggable("Ads", i11);
    }
}
