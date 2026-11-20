package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgg extends zzkf implements zzln {
    private static final zzgg zza;
    private int zzd;
    private int zze = 1;
    private zzkm zzf = zzkf.zzbE();

    static {
        zzgg zzggVar = new zzgg();
        zza = zzggVar;
        zzkf.zzbL(zzgg.class, zzggVar);
    }

    private zzgg() {
    }

    public static zzge zza() {
        return (zzge) zza.zzbx();
    }

    public static /* synthetic */ void zzc(zzgg zzggVar, zzfv zzfvVar) {
        zzfvVar.getClass();
        zzkm zzkmVar = zzggVar.zzf;
        if (!zzkmVar.zzc()) {
            zzggVar.zzf = zzkf.zzbF(zzkmVar);
        }
        zzggVar.zzf.add(zzfvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzd", "zze", zzgf.zza, "zzf", zzfv.class});
        }
        if (i12 == 3) {
            return new zzgg();
        }
        zzfk zzfkVar = null;
        if (i12 == 4) {
            return new zzge(zzfkVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zza;
    }
}
