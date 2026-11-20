package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgwi extends zzgzu implements zzhbf {
    private static final zzgwi zzb;
    private int zzd;

    static {
        zzgwi zzgwiVar = new zzgwi();
        zzb = zzgwiVar;
        zzgzu.zzaU(zzgwi.class, zzgwiVar);
    }

    private zzgwi() {
    }

    public static zzgwi zzd() {
        return zzb;
    }

    public static zzgwi zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgwi) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
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
            return new zzgwi();
        }
        zzgwg zzgwgVar = null;
        if (i12 == 4) {
            return new zzgwh(zzgwgVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
