package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcx {
    public static final zzcx zza = new zzcs();
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(2, 36);

    @Deprecated
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzcr
    };

    public final boolean equals(@Nullable Object obj) {
        int iZzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcx)) {
            return false;
        }
        zzcx zzcxVar = (zzcx) obj;
        if (zzcxVar.zzc() == zzc() && zzcxVar.zzb() == zzb()) {
            zzcw zzcwVar = new zzcw();
            zzcu zzcuVar = new zzcu();
            zzcw zzcwVar2 = new zzcw();
            zzcu zzcuVar2 = new zzcu();
            for (int i11 = 0; i11 < zzc(); i11++) {
                if (!zze(i11, zzcwVar, 0L).equals(zzcxVar.zze(i11, zzcwVar2, 0L))) {
                    return false;
                }
            }
            for (int i12 = 0; i12 < zzb(); i12++) {
                if (!zzd(i12, zzcuVar, true).equals(zzcxVar.zzd(i12, zzcuVar2, true))) {
                    return false;
                }
            }
            int iZzg = zzg(true);
            if (iZzg == zzcxVar.zzg(true) && (iZzh = zzh(true)) == zzcxVar.zzh(true)) {
                while (iZzg != iZzh) {
                    int iZzj = zzj(iZzg, 0, true);
                    if (iZzj != zzcxVar.zzj(iZzg, 0, true)) {
                        return false;
                    }
                    iZzg = iZzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        zzcw zzcwVar = new zzcw();
        zzcu zzcuVar = new zzcu();
        int iZzc = zzc() + 217;
        int i12 = 0;
        while (true) {
            i11 = iZzc * 31;
            if (i12 >= zzc()) {
                break;
            }
            iZzc = i11 + zze(i12, zzcwVar, 0L).hashCode();
            i12++;
        }
        int iZzb = i11 + zzb();
        for (int i13 = 0; i13 < zzb(); i13++) {
            iZzb = (iZzb * 31) + zzd(i13, zzcuVar, true).hashCode();
        }
        int iZzg = zzg(true);
        while (iZzg != -1) {
            iZzb = (iZzb * 31) + iZzg;
            iZzg = zzj(iZzg, 0, true);
        }
        return iZzb;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzcu zzd(int i11, zzcu zzcuVar, boolean z11);

    public abstract zzcw zze(int i11, zzcw zzcwVar, long j11);

    public abstract Object zzf(int i11);

    public int zzg(boolean z11) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z11) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i11, zzcu zzcuVar, zzcw zzcwVar, int i12, boolean z11) {
        int i13 = zzd(i11, zzcuVar, false).zzd;
        if (zze(i13, zzcwVar, 0L).zzq != i11) {
            return i11 + 1;
        }
        int iZzj = zzj(i13, i12, z11);
        if (iZzj == -1) {
            return -1;
        }
        return zze(iZzj, zzcwVar, 0L).zzp;
    }

    public int zzj(int i11, int i12, boolean z11) {
        if (i12 == 0) {
            if (i11 == zzh(z11)) {
                return -1;
            }
            return i11 + 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == zzh(z11) ? zzg(z11) : i11 + 1;
        }
        throw new IllegalStateException();
    }

    public int zzk(int i11, int i12, boolean z11) {
        if (i11 == zzg(false)) {
            return -1;
        }
        return i11 - 1;
    }

    public final Pair zzl(zzcw zzcwVar, zzcu zzcuVar, int i11, long j11) {
        Pair pairZzm = zzm(zzcwVar, zzcuVar, i11, j11, 0L);
        pairZzm.getClass();
        return pairZzm;
    }

    @Nullable
    public final Pair zzm(zzcw zzcwVar, zzcu zzcuVar, int i11, long j11, long j12) {
        zzek.zza(i11, 0, zzc());
        zze(i11, zzcwVar, j12);
        if (j11 == C.TIME_UNSET) {
            long j13 = zzcwVar.zzn;
            j11 = 0;
        }
        int i12 = zzcwVar.zzp;
        zzd(i12, zzcuVar, false);
        while (i12 < zzcwVar.zzq) {
            long j14 = zzcuVar.zzf;
            if (j11 == 0) {
                break;
            }
            int i13 = i12 + 1;
            long j15 = zzd(i13, zzcuVar, false).zzf;
            if (j11 < 0) {
                break;
            }
            i12 = i13;
        }
        zzd(i12, zzcuVar, true);
        long j16 = zzcuVar.zzf;
        long j17 = zzcuVar.zze;
        if (j17 != C.TIME_UNSET) {
            j11 = Math.min(j11, j17 - 1);
        }
        long jMax = Math.max(0L, j11);
        Object obj = zzcuVar.zzc;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public zzcu zzn(Object obj, zzcu zzcuVar) {
        return zzd(zza(obj), zzcuVar, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }
}
