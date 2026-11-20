package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgtr extends zzgzu implements zzhbf {
    private static final zzgtr zzb;
    private int zzd;
    private int zze;

    static {
        zzgtr zzgtrVar = new zzgtr();
        zzb = zzgtrVar;
        zzgzu.zzaU(zzgtr.class, zzgtrVar);
    }

    private zzgtr() {
    }

    public static zzgtq zzd() {
        return (zzgtq) zzb.zzaA();
    }

    public static zzgtr zzf(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgtr) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
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
            return zzgzu.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze"});
        }
        if (i12 == 3) {
            return new zzgtr();
        }
        zzgtp zzgtpVar = null;
        if (i12 == 4) {
            return new zzgtq(zzgtpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zze;
    }
}
