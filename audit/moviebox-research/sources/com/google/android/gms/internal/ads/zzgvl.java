package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgvl extends zzgzu implements zzhbf {
    private static final zzgvl zzb;
    private int zzd;
    private zzhad zze = zzgzu.zzaN();

    static {
        zzgvl zzgvlVar = new zzgvl();
        zzb = zzgvlVar;
        zzgzu.zzaU(zzgvl.class, zzgvlVar);
    }

    private zzgvl() {
    }

    public static zzgvi zza() {
        return (zzgvi) zzb.zzaA();
    }

    public static /* synthetic */ void zze(zzgvl zzgvlVar, zzgvk zzgvkVar) {
        zzgvkVar.getClass();
        zzhad zzhadVar = zzgvlVar.zze;
        if (!zzhadVar.zzc()) {
            zzgvlVar.zze = zzgzu.zzaO(zzhadVar);
        }
        zzgvlVar.zze.add(zzgvkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzgvk.class});
        }
        if (i12 == 3) {
            return new zzgvl();
        }
        zzgvh zzgvhVar = null;
        if (i12 == 4) {
            return new zzgvi(zzgvhVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
