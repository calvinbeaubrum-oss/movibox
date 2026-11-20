package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class zzx {
    private static final zzx zze = new zzx(true, 3, 1, null, null);
    final boolean zza;
    final String zzb;
    final Throwable zzc;
    final int zzd;

    private zzx(boolean z11, int i11, int i12, String str, Throwable th2) {
        this.zza = z11;
        this.zzd = i11;
        this.zzb = str;
        this.zzc = th2;
    }

    @Deprecated
    public static zzx zzb() {
        return zze;
    }

    public static zzx zzc(@NonNull String str) {
        return new zzx(false, 1, 5, str, null);
    }

    public static zzx zzd(@NonNull String str, @NonNull Throwable th2) {
        return new zzx(false, 1, 5, str, th2);
    }

    public static zzx zzf(int i11) {
        return new zzx(true, i11, 1, null, null);
    }

    public static zzx zzg(int i11, int i12, @NonNull String str, Throwable th2) {
        return new zzx(false, i11, i12, str, th2);
    }

    public String zza() {
        return this.zzb;
    }

    public final void zze() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.zzc != null) {
            zza();
        } else {
            zza();
        }
    }
}
