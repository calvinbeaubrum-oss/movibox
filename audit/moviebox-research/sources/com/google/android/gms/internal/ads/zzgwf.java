package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgwf extends zzgzu implements zzhbf {
    private static final zzgwf zzb;
    private static volatile zzhbl zzd;
    private int zze;
    private zzgyl zzf = zzgyl.zzb;

    static {
        zzgwf zzgwfVar = new zzgwf();
        zzb = zzgwfVar;
        zzgzu.zzaU(zzgwf.class, zzgwfVar);
    }

    private zzgwf() {
    }

    public static zzgwe zzc() {
        return (zzgwe) zzb.zzaA();
    }

    public static zzgwf zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgwf) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static zzhbl zzg() {
        return (zzhbl) zzb.zzb(7, null, null);
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzgwf();
        }
        zzgwd zzgwdVar = null;
        if (i12 == 4) {
            return new zzgwe(zzgwdVar);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzhbl zzgzqVar = zzd;
        if (zzgzqVar == null) {
            synchronized (zzgwf.class) {
                try {
                    zzgzqVar = zzd;
                    if (zzgzqVar == null) {
                        zzgzqVar = new zzgzq(zzb);
                        zzd = zzgzqVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return zzgzqVar;
    }

    public final zzgyl zzf() {
        return this.zzf;
    }
}
