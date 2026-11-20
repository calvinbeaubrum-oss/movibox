package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgut extends zzgzu implements zzhbf {
    private static final zzgut zzb;
    private String zzd = "";
    private zzgyl zze = zzgyl.zzb;
    private int zzf;

    static {
        zzgut zzgutVar = new zzgut();
        zzb = zzgutVar;
        zzgzu.zzaU(zzgut.class, zzgutVar);
    }

    private zzgut() {
    }

    public static zzguq zza() {
        return (zzguq) zzb.zzaA();
    }

    public static zzgut zze() {
        return zzb;
    }

    public static /* synthetic */ void zzh(zzgut zzgutVar, String str) {
        str.getClass();
        zzgutVar.zzd = str;
    }

    public static /* synthetic */ void zzi(zzgut zzgutVar, zzgyl zzgylVar) {
        zzgylVar.getClass();
        zzgutVar.zze = zzgylVar;
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
            return new zzgut();
        }
        zzgup zzgupVar = null;
        if (i12 == 4) {
            return new zzguq(zzgupVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgus zzc() {
        zzgus zzgusVar;
        int i11 = this.zzf;
        zzgus zzgusVar2 = zzgus.UNKNOWN_KEYMATERIAL;
        if (i11 == 0) {
            zzgusVar = zzgus.UNKNOWN_KEYMATERIAL;
        } else if (i11 == 1) {
            zzgusVar = zzgus.SYMMETRIC;
        } else if (i11 == 2) {
            zzgusVar = zzgus.ASYMMETRIC_PRIVATE;
        } else if (i11 != 3) {
            zzgusVar = i11 != 4 ? null : zzgus.REMOTE;
        } else {
            zzgusVar = zzgus.ASYMMETRIC_PUBLIC;
        }
        return zzgusVar == null ? zzgus.UNRECOGNIZED : zzgusVar;
    }

    public final zzgyl zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }
}
