package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhed extends zzgzu implements zzhbf {
    private static final zzhed zzb;
    private int zzd;
    private String zze = "";

    static {
        zzhed zzhedVar = new zzhed();
        zzb = zzhedVar;
        zzgzu.zzaU(zzhed.class, zzhedVar);
    }

    private zzhed() {
    }

    public static zzhec zza() {
        return (zzhec) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzhed zzhedVar, String str) {
        zzhedVar.zzd |= 1;
        zzhedVar.zze = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i12 == 3) {
            return new zzhed();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhec(zzhdpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
