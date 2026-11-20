package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfz extends zzkf implements zzln {
    private static final zzfz zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfn zzg;

    static {
        zzfz zzfzVar = new zzfz();
        zza = zzfzVar;
        zzkf.zzbL(zzfz.class, zzfzVar);
    }

    private zzfz() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzfz();
        }
        zzfk zzfkVar = null;
        if (i12 == 4) {
            return new zzfy(zzfkVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zza;
    }
}
