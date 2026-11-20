package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbck extends zzgzu implements zzhbf {
    private static final zzbck zzb;
    private zzhad zzd = zzgzu.zzaN();

    static {
        zzbck zzbckVar = new zzbck();
        zzb = zzbckVar;
        zzgzu.zzaU(zzbck.class, zzbckVar);
    }

    private zzbck() {
    }

    public static zzbce zza() {
        return (zzbce) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzbck zzbckVar, zzbcd zzbcdVar) {
        zzbcdVar.getClass();
        zzhad zzhadVar = zzbckVar.zzd;
        if (!zzhadVar.zzc()) {
            zzbckVar.zzd = zzgzu.zzaO(zzhadVar);
        }
        zzbckVar.zzd.add(zzbcdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzbcd.class});
        }
        if (i12 == 3) {
            return new zzbck();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbce(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
