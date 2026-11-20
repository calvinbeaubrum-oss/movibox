package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsa {
    public static final boolean zza;

    static {
        boolean z11 = false;
        if ("Amazon".equals(zzfy.zzc)) {
            String str = zzfy.zzd;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z11 = true;
            }
        }
        zza = z11;
    }
}
