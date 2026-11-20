package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzbgm {
    public static boolean zza(@Nullable zzbgu zzbguVar, @Nullable zzbgr zzbgrVar, String... strArr) {
        if (zzbgrVar == null) {
            return false;
        }
        zzbguVar.zze(zzbgrVar, com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime(), strArr);
        return true;
    }
}
