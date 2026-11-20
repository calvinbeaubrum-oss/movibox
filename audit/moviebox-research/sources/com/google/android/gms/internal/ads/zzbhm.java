package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzbhm {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    public zzbhm(String str, Object obj, int i11) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i11;
    }

    public static zzbhm zza(String str, double d11) {
        return new zzbhm(str, Double.valueOf(d11), 3);
    }

    public static zzbhm zzb(String str, long j11) {
        return new zzbhm(str, Long.valueOf(j11), 2);
    }

    public static zzbhm zzc(String str, String str2) {
        return new zzbhm(str, str2, 4);
    }

    public static zzbhm zzd(String str, boolean z11) {
        return new zzbhm(str, Boolean.valueOf(z11), 1);
    }

    public final Object zze() {
        zzbiq zzbiqVarZza = zzbis.zza();
        if (zzbiqVarZza == null) {
            if (zzbis.zzb() != null) {
                zzbis.zzb().zza();
            }
            return this.zzb;
        }
        int i11 = this.zzc - 1;
        if (i11 == 0) {
            return zzbiqVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i11 != 1) {
            return i11 != 2 ? zzbiqVarZza.zzd(this.zza, (String) this.zzb) : zzbiqVarZza.zzb(this.zza, ((Double) this.zzb).doubleValue());
        }
        return zzbiqVarZza.zzc(this.zza, ((Long) this.zzb).longValue());
    }
}
