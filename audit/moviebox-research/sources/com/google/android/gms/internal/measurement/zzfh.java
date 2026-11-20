package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfh extends zzkf implements zzln {
    private static final zzfh zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzfh zzfhVar = new zzfh();
        zza = zzfhVar;
        zzkf.zzbL(zzfh.class, zzfhVar);
    }

    private zzfh() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzfh();
        }
        zzez zzezVar = null;
        if (i12 == 4) {
            return new zzfg(zzezVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zza;
    }
}
