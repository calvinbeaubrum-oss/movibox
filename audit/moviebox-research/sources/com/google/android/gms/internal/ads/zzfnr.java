package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfnr extends zzgzu implements zzhbf {
    private static final zzfnr zzb;
    private zzhad zzd = zzgzu.zzaN();

    static {
        zzfnr zzfnrVar = new zzfnr();
        zzb = zzfnrVar;
        zzgzu.zzaU(zzfnr.class, zzfnrVar);
    }

    private zzfnr() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfno.class});
        }
        if (i12 == 3) {
            return new zzfnr();
        }
        zzfnp zzfnpVar = null;
        if (i12 == 4) {
            return new zzfnq(zzfnpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
