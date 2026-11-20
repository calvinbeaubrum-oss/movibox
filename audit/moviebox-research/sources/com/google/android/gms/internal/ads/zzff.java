package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzff {
    private static final Object zza = new Object();
    private static final zzfe zzb = zzfe.zza;

    public static String zza(String str, @Nullable Throwable th2) {
        String strReplace;
        if (th2 != null) {
            synchronized (zza) {
                Throwable cause = th2;
                while (true) {
                    if (cause == null) {
                        strReplace = Log.getStackTraceString(th2).trim().replace("\t", "    ");
                        break;
                    }
                    try {
                        if (cause instanceof UnknownHostException) {
                            strReplace = "UnknownHostException (no network)";
                            break;
                        }
                        cause = cause.getCause();
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        } else {
            strReplace = null;
        }
        if (TextUtils.isEmpty(strReplace)) {
            return str;
        }
        return str + "\n  " + strReplace.replace("\n", "\n  ") + "\n";
    }

    public static void zzb(String str, String str2) {
        synchronized (zza) {
            zza(str2, null);
        }
    }

    public static void zzc(String str, String str2) {
        synchronized (zza) {
            Log.e(str, zza(str2, null));
        }
    }

    public static void zzd(String str, String str2, @Nullable Throwable th2) {
        synchronized (zza) {
            Log.e(str, zza(str2, th2));
        }
    }

    public static void zze(String str, String str2) {
        synchronized (zza) {
            zza(str2, null);
        }
    }

    public static void zzf(String str, String str2) {
        synchronized (zza) {
            Log.w(str, zza(str2, null));
        }
    }

    public static void zzg(String str, String str2, @Nullable Throwable th2) {
        synchronized (zza) {
            Log.w(str, zza(str2, th2));
        }
    }
}
