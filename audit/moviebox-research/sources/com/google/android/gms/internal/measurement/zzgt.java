package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgt extends zzkf implements zzln {
    private static final zzgt zza;
    private int zzd;
    private zzkm zze = zzkf.zzbE();
    private zzgp zzf;

    static {
        zzgt zzgtVar = new zzgt();
        zza = zzgtVar;
        zzkf.zzbL(zzgt.class, zzgtVar);
    }

    private zzgt() {
    }

    public final zzgp zza() {
        zzgp zzgpVar = this.zzf;
        return zzgpVar == null ? zzgp.zzc() : zzgpVar;
    }

    public final List zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzd", "zze", zzgy.class, "zzf"});
        }
        if (i12 == 3) {
            return new zzgt();
        }
        zzgn zzgnVar = null;
        if (i12 == 4) {
            return new zzgs(zzgnVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zza;
    }
}
