package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfzm extends zzfzp {
    public zzfzm() {
        super(null);
    }

    public static final zzfzp zzg(int i11) {
        if (i11 < 0) {
            return zzfzp.zzb;
        }
        return i11 > 0 ? zzfzp.zzc : zzfzp.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zzb(int i11, int i12) {
        int i13;
        if (i11 < i12) {
            i13 = -1;
        } else {
            i13 = i11 > i12 ? 1 : 0;
        }
        return zzg(i13);
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zzc(long j11, long j12) {
        int i11;
        if (j11 < j12) {
            i11 = -1;
        } else {
            i11 = j11 > j12 ? 1 : 0;
        }
        return zzg(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zzd(Object obj, Object obj2, Comparator comparator) {
        return zzg(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zze(boolean z11, boolean z12) {
        return zzg(zzgcs.zza(z11, z12));
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zzf(boolean z11, boolean z12) {
        return zzg(zzgcs.zza(z12, z11));
    }
}
