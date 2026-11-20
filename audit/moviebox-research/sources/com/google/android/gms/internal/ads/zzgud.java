package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgud extends zzgzu implements zzhbf {
    private static final zzgud zzb;

    static {
        zzgud zzgudVar = new zzgud();
        zzb = zzgudVar;
        zzgzu.zzaU(zzgud.class, zzgudVar);
    }

    private zzgud() {
    }

    public static zzgud zzc() {
        return zzb;
    }

    public static zzgud zzd(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgud) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        zzgub zzgubVar = null;
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0000", null);
        }
        if (i12 == 3) {
            return new zzgud();
        }
        if (i12 == 4) {
            return new zzguc(zzgubVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
