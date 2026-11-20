package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfie {
    public static void zza(Context context, boolean z11) {
        if (z11) {
            zzcec.zzi("This request is sent from a test device.");
            return;
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        zzcec.zzi("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"" + zzcdv.zzy(context) + "\")) to get test ads on this device.");
    }

    public static void zzb(int i11, Throwable th2, String str) {
        zzcec.zzi("Ad failed to load : " + i11);
        com.google.android.gms.ads.internal.util.zze.zzb(str, th2);
        if (i11 == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzo().zzv(th2, str);
    }
}
