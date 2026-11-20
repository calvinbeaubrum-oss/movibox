package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgcu extends zzgcv {
    public static int zza(long j11) {
        int i11 = (int) j11;
        zzfxe.zzg(((long) i11) == j11, "Out of range: %s", j11);
        return i11;
    }

    public static int zzb(int i11, int i12, int i13) {
        return Math.min(Math.max(i11, i12), 1073741823);
    }

    public static int zzc(long j11) {
        if (j11 > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (j11 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j11;
    }
}
