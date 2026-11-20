package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfzp {
    private static final zzfzp zza = new zzfzm();
    private static final zzfzp zzb = new zzfzn(-1);
    private static final zzfzp zzc = new zzfzn(1);

    public /* synthetic */ zzfzp(zzfzo zzfzoVar) {
    }

    public static zzfzp zzk() {
        return zza;
    }

    public abstract int zza();

    public abstract zzfzp zzb(int i11, int i12);

    public abstract zzfzp zzc(long j11, long j12);

    public abstract zzfzp zzd(Object obj, Object obj2, Comparator comparator);

    public abstract zzfzp zze(boolean z11, boolean z12);

    public abstract zzfzp zzf(boolean z11, boolean z12);
}
