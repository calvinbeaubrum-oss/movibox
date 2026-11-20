package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzce extends Exception {
    public final int zzb;
    public final long zzc;
    private static final String zzd = Integer.toString(0, 36);
    private static final String zze = Integer.toString(1, 36);
    private static final String zzf = Integer.toString(2, 36);
    private static final String zzg = Integer.toString(3, 36);
    private static final String zzh = Integer.toString(4, 36);

    @Deprecated
    public static final zzn zza = new zzn() { // from class: com.google.android.gms.internal.ads.zzcd
    };

    public zzce(@Nullable String str, @Nullable Throwable th2, int i11, long j11) {
        super(str, th2);
        this.zzb = i11;
        this.zzc = j11;
    }
}
