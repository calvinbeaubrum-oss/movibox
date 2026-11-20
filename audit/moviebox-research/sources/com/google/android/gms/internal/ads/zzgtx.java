package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgtx extends zzgzu implements zzhbf {
    private static final zzgtx zzb;
    private int zzd;
    private int zze;

    static {
        zzgtx zzgtxVar = new zzgtx();
        zzb = zzgtxVar;
        zzgzu.zzaU(zzgtx.class, zzgtxVar);
    }

    private zzgtx() {
    }

    public static zzgtw zzd() {
        return (zzgtw) zzb.zzaA();
    }

    public static zzgtx zzf(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgtx) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        }
        if (i12 == 3) {
            return new zzgtx();
        }
        zzgtv zzgtvVar = null;
        if (i12 == 4) {
            return new zzgtw(zzgtvVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zze;
    }
}
