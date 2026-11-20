package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgsn extends zzgzu implements zzhbf {
    private static final zzgsn zzb;
    private int zzd;

    static {
        zzgsn zzgsnVar = new zzgsn();
        zzb = zzgsnVar;
        zzgzu.zzaU(zzgsn.class, zzgsnVar);
    }

    private zzgsn() {
    }

    public static zzgsm zzc() {
        return (zzgsm) zzb.zzaA();
    }

    public static zzgsn zze() {
        return zzb;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        }
        if (i12 == 3) {
            return new zzgsn();
        }
        zzgsl zzgslVar = null;
        if (i12 == 4) {
            return new zzgsm(zzgslVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
