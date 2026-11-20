package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmj {
    public static final zzmj zza;
    public static final zzmj zzb;
    public static final zzmj zzc;
    public static final zzmj zzd;
    public static final zzmj zze;
    public final long zzf;
    public final long zzg;

    static {
        zzmj zzmjVar = new zzmj(0L, 0L);
        zza = zzmjVar;
        zzb = new zzmj(Long.MAX_VALUE, Long.MAX_VALUE);
        zzc = new zzmj(Long.MAX_VALUE, 0L);
        zzd = new zzmj(0L, Long.MAX_VALUE);
        zze = zzmjVar;
    }

    public zzmj(long j11, long j12) {
        zzek.zzd(j11 >= 0);
        zzek.zzd(j12 >= 0);
        this.zzf = j11;
        this.zzg = j12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmj.class == obj.getClass()) {
            zzmj zzmjVar = (zzmj) obj;
            if (this.zzf == zzmjVar.zzf && this.zzg == zzmjVar.zzg) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzf) * 31) + ((int) this.zzg);
    }
}
