package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhdo extends zzgzu implements zzhbf {
    private static final zzhdo zzb;
    private zzhad zzd = zzgzu.zzaN();

    static {
        zzhdo zzhdoVar = new zzhdo();
        zzb = zzhdoVar;
        zzgzu.zzaU(zzhdo.class, zzhdoVar);
    }

    private zzhdo() {
    }

    public static zzhdn zza() {
        return (zzhdn) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzhdo zzhdoVar, zzhdm zzhdmVar) {
        zzhdmVar.getClass();
        zzhad zzhadVar = zzhdoVar.zzd;
        if (!zzhadVar.zzc()) {
            zzhdoVar.zzd = zzgzu.zzaO(zzhadVar);
        }
        zzhdoVar.zzd.add(zzhdmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzhdm.class});
        }
        if (i12 == 3) {
            return new zzhdo();
        }
        zzhdk zzhdkVar = null;
        if (i12 == 4) {
            return new zzhdn(zzhdkVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
