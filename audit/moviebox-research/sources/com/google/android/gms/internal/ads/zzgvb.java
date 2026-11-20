package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzgvb extends zzgzu implements zzhbf {
    private static final zzgvb zzb;
    private int zzf;
    private boolean zzg;
    private String zzd = "";
    private String zze = "";
    private String zzh = "";

    static {
        zzgvb zzgvbVar = new zzgvb();
        zzb = zzgvbVar;
        zzgzu.zzaU(zzgvb.class, zzgvbVar);
    }

    private zzgvb() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i12 == 3) {
            return new zzgvb();
        }
        zzguz zzguzVar = null;
        if (i12 == 4) {
            return new zzgva(zzguzVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
