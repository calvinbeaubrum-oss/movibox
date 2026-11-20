package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgvr extends zzgzu implements zzhbf {
    private static final zzgvr zzb;
    private String zzd = "";

    static {
        zzgvr zzgvrVar = new zzgvr();
        zzb = zzgvrVar;
        zzgzu.zzaU(zzgvr.class, zzgvrVar);
    }

    private zzgvr() {
    }

    public static zzgvq zza() {
        return (zzgvq) zzb.zzaA();
    }

    public static zzgvr zzd() {
        return zzb;
    }

    public static zzgvr zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgvr) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static /* synthetic */ void zzg(zzgvr zzgvrVar, String str) {
        str.getClass();
        zzgvrVar.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        }
        if (i12 == 3) {
            return new zzgvr();
        }
        zzgvp zzgvpVar = null;
        if (i12 == 4) {
            return new zzgvq(zzgvpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzf() {
        return this.zzd;
    }
}
