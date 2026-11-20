package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgtf extends zzgzu implements zzhbf {
    private static final zzgtf zzb;
    private static volatile zzhbl zzd;
    private int zze;
    private int zzf;
    private zzgtl zzg;
    private zzgyl zzh = zzgyl.zzb;

    static {
        zzgtf zzgtfVar = new zzgtf();
        zzb = zzgtfVar;
        zzgzu.zzaU(zzgtf.class, zzgtfVar);
    }

    private zzgtf() {
    }

    public static zzgte zzc() {
        return (zzgte) zzb.zzaA();
    }

    public static zzgtf zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgtf) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static zzhbl zzh() {
        return (zzhbl) zzb.zzb(7, null, null);
    }

    public static /* synthetic */ void zzi(zzgtf zzgtfVar, zzgtl zzgtlVar) {
        zzgtlVar.getClass();
        zzgtfVar.zzg = zzgtlVar;
        zzgtfVar.zze |= 1;
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
            return zzgzu.zzaR(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i12 == 3) {
            return new zzgtf();
        }
        zzgtd zzgtdVar = null;
        if (i12 == 4) {
            return new zzgte(zzgtdVar);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzhbl zzgzqVar = zzd;
        if (zzgzqVar == null) {
            synchronized (zzgtf.class) {
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

    public final zzgtl zzf() {
        zzgtl zzgtlVar = this.zzg;
        return zzgtlVar == null ? zzgtl.zze() : zzgtlVar;
    }

    public final zzgyl zzg() {
        return this.zzh;
    }
}
