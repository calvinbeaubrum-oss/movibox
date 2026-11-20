package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcu {

    @Nullable
    public Object zzb;

    @Nullable
    public Object zzc;
    public int zzd;
    public long zze;
    public long zzf;
    public boolean zzg;
    private zzd zzm = zzd.zza;
    private static final String zzh = Integer.toString(0, 36);
    private static final String zzi = Integer.toString(1, 36);
    private static final String zzj = Integer.toString(2, 36);
    private static final String zzk = Integer.toString(3, 36);
    private static final String zzl = Integer.toString(4, 36);

    @Deprecated
    public static final zzn zza = new zzn() { // from class: com.google.android.gms.internal.ads.zzct
    };

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcu.class.equals(obj.getClass())) {
            zzcu zzcuVar = (zzcu) obj;
            if (zzfy.zzF(this.zzb, zzcuVar.zzb) && zzfy.zzF(this.zzc, zzcuVar.zzc) && this.zzd == zzcuVar.zzd && this.zze == zzcuVar.zze && this.zzg == zzcuVar.zzg && zzfy.zzF(this.zzm, zzcuVar.zzm)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.zzb;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.zzc;
        int iHashCode2 = ((((iHashCode + 217) * 31) + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.zzd;
        long j11 = this.zze;
        return (((((iHashCode2 * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 961) + (this.zzg ? 1 : 0)) * 31) + this.zzm.hashCode();
    }

    public final int zza(int i11) {
        return this.zzm.zza(i11).zzd;
    }

    public final int zzb() {
        int i11 = this.zzm.zzc;
        return 0;
    }

    public final int zzc(long j11) {
        return -1;
    }

    public final int zzd(long j11) {
        this.zzm.zzb(-1);
        return -1;
    }

    public final int zze(int i11) {
        return this.zzm.zza(i11).zza(-1);
    }

    public final int zzf(int i11, int i12) {
        return this.zzm.zza(i11).zza(i12);
    }

    public final int zzg() {
        int i11 = this.zzm.zze;
        return 0;
    }

    public final long zzh(int i11, int i12) {
        zzc zzcVarZza = this.zzm.zza(i11);
        return zzcVarZza.zzd != -1 ? zzcVarZza.zzh[i12] : C.TIME_UNSET;
    }

    public final long zzi(int i11) {
        long j11 = this.zzm.zza(i11).zzc;
        return 0L;
    }

    public final long zzj() {
        long j11 = this.zzm.zzd;
        return 0L;
    }

    public final long zzk(int i11) {
        long j11 = this.zzm.zza(i11).zzi;
        return 0L;
    }

    public final zzcu zzl(@Nullable Object obj, @Nullable Object obj2, int i11, long j11, long j12, zzd zzdVar, boolean z11) {
        this.zzb = obj;
        this.zzc = obj2;
        this.zzd = i11;
        this.zze = j11;
        this.zzf = 0L;
        this.zzm = zzdVar;
        this.zzg = z11;
        return this;
    }

    public final boolean zzm(int i11) {
        zzb();
        if (i11 != -1) {
            return false;
        }
        this.zzm.zzb(-1);
        return false;
    }

    public final boolean zzn(int i11) {
        boolean z11 = this.zzm.zza(i11).zzj;
        return false;
    }
}
