package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgp extends zzkf implements zzln {
    private static final zzgp zza;
    private zzkm zzd = zzkf.zzbE();

    static {
        zzgp zzgpVar = new zzgp();
        zza = zzgpVar;
        zzkf.zzbL(zzgp.class, zzgpVar);
    }

    private zzgp() {
    }

    public static zzgp zzc() {
        return zza;
    }

    public final int zza() {
        return this.zzd.size();
    }

    public final List zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgr.class});
        }
        if (i12 == 3) {
            return new zzgp();
        }
        zzgn zzgnVar = null;
        if (i12 == 4) {
            return new zzgo(zzgnVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zza;
    }
}
