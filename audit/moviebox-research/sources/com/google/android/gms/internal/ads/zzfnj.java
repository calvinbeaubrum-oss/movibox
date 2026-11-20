package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfnj extends zzgzu implements zzhbf {
    private static final zzfnj zzb;
    private int zzd;
    private zzfnf zze;

    static {
        zzfnj zzfnjVar = new zzfnj();
        zzb = zzfnjVar;
        zzgzu.zzaU(zzfnj.class, zzfnjVar);
    }

    private zzfnj() {
    }

    public static zzfni zza() {
        return (zzfni) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzfnj zzfnjVar, zzfnf zzfnfVar) {
        zzfnfVar.getClass();
        zzfnjVar.zze = zzfnfVar;
        zzfnjVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i12 == 3) {
            return new zzfnj();
        }
        zzfng zzfngVar = null;
        if (i12 == 4) {
            return new zzfni(zzfngVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
