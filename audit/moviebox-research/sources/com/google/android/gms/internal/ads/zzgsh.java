package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgsh extends zzgzu implements zzhbf {
    private static final zzgsh zzb;
    private static volatile zzhbl zzd;
    private int zze;
    private int zzf;
    private zzgyl zzg = zzgyl.zzb;
    private zzgsn zzh;

    static {
        zzgsh zzgshVar = new zzgsh();
        zzb = zzgshVar;
        zzgzu.zzaU(zzgsh.class, zzgshVar);
    }

    private zzgsh() {
    }

    public static zzgsg zzc() {
        return (zzgsg) zzb.zzaA();
    }

    public static zzgsh zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgsh) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static zzhbl zzh() {
        return (zzhbl) zzb.zzb(7, null, null);
    }

    public static /* synthetic */ void zzj(zzgsh zzgshVar, zzgsn zzgsnVar) {
        zzgsnVar.getClass();
        zzgshVar.zzh = zzgsnVar;
        zzgshVar.zze |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i12 == 3) {
            return new zzgsh();
        }
        zzgsf zzgsfVar = null;
        if (i12 == 4) {
            return new zzgsg(zzgsfVar);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzhbl zzgzqVar = zzd;
        if (zzgzqVar == null) {
            synchronized (zzgsh.class) {
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

    public final zzgsn zzf() {
        zzgsn zzgsnVar = this.zzh;
        return zzgsnVar == null ? zzgsn.zze() : zzgsnVar;
    }

    public final zzgyl zzg() {
        return this.zzg;
    }
}
