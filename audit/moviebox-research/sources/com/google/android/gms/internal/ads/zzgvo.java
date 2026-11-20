package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgvo extends zzgzu implements zzhbf {
    private static final zzgvo zzb;
    private static volatile zzhbl zzd;
    private int zze;
    private int zzf;
    private zzgvr zzg;

    static {
        zzgvo zzgvoVar = new zzgvo();
        zzb = zzgvoVar;
        zzgzu.zzaU(zzgvo.class, zzgvoVar);
    }

    private zzgvo() {
    }

    public static zzgvn zzc() {
        return (zzgvn) zzb.zzaA();
    }

    public static zzgvo zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgvo) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static zzhbl zzg() {
        return (zzhbl) zzb.zzb(7, null, null);
    }

    public static /* synthetic */ void zzh(zzgvo zzgvoVar, zzgvr zzgvrVar) {
        zzgvrVar.getClass();
        zzgvoVar.zzg = zzgvrVar;
        zzgvoVar.zze |= 1;
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
            return zzgzu.zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzgvo();
        }
        zzgvm zzgvmVar = null;
        if (i12 == 4) {
            return new zzgvn(zzgvmVar);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzhbl zzgzqVar = zzd;
        if (zzgzqVar == null) {
            synchronized (zzgvo.class) {
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

    public final zzgvr zzf() {
        zzgvr zzgvrVar = this.zzg;
        return zzgvrVar == null ? zzgvr.zzd() : zzgvrVar;
    }
}
