package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzguy extends zzgzu implements zzhbf {
    private static final zzguy zzb;
    private String zzd = "";
    private zzgyl zze = zzgyl.zzb;
    private int zzf;

    static {
        zzguy zzguyVar = new zzguy();
        zzb = zzguyVar;
        zzgzu.zzaU(zzguy.class, zzguyVar);
    }

    private zzguy() {
    }

    public static zzgux zza() {
        return (zzgux) zzb.zzaA();
    }

    public static zzguy zzd() {
        return zzb;
    }

    public static zzguy zze(byte[] bArr, zzgzf zzgzfVar) throws zzhag {
        return (zzguy) zzgzu.zzaI(zzb, bArr, zzgzfVar);
    }

    public static /* synthetic */ void zzi(zzguy zzguyVar, String str) {
        str.getClass();
        zzguyVar.zzd = str;
    }

    public static /* synthetic */ void zzj(zzguy zzguyVar, zzgyl zzgylVar) {
        zzgylVar.getClass();
        zzguyVar.zze = zzgylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzguy();
        }
        zzguw zzguwVar = null;
        if (i12 == 4) {
            return new zzgux(zzguwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgvz zzf() {
        zzgvz zzgvzVarZzb = zzgvz.zzb(this.zzf);
        return zzgvzVarZzb == null ? zzgvz.UNRECOGNIZED : zzgvzVarZzb;
    }

    public final zzgyl zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzd;
    }
}
