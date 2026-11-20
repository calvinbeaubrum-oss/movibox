package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgtl extends zzgzu implements zzhbf {
    private static final zzgtl zzb;
    private int zzd;

    static {
        zzgtl zzgtlVar = new zzgtl();
        zzb = zzgtlVar;
        zzgzu.zzaU(zzgtl.class, zzgtlVar);
    }

    private zzgtl() {
    }

    public static zzgtk zzc() {
        return (zzgtk) zzb.zzaA();
    }

    public static zzgtl zze() {
        return zzb;
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
            return zzgzu.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        }
        if (i12 == 3) {
            return new zzgtl();
        }
        zzgtj zzgtjVar = null;
        if (i12 == 4) {
            return new zzgtk(zzgtjVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
