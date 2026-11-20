package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzgwc extends zzgzu implements zzhbf {
    private static final zzgwc zzb;
    private String zzd = "";
    private zzhad zze = zzgzu.zzaN();

    static {
        zzgwc zzgwcVar = new zzgwc();
        zzb = zzgwcVar;
        zzgzu.zzaU(zzgwc.class, zzgwcVar);
    }

    private zzgwc() {
    }

    public static zzgwc zzc() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgvb.class});
        }
        if (i12 == 3) {
            return new zzgwc();
        }
        zzgwa zzgwaVar = null;
        if (i12 == 4) {
            return new zzgwb(zzgwaVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
