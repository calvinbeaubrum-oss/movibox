package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgb extends zzkf implements zzln {
    private static final zzgb zza;
    private zzkm zzd = zzkf.zzbE();

    static {
        zzgb zzgbVar = new zzgb();
        zza = zzgbVar;
        zzkf.zzbL(zzgb.class, zzgbVar);
    }

    private zzgb() {
    }

    public static zzga zza() {
        return (zzga) zza.zzbx();
    }

    public static /* synthetic */ void zze(zzgb zzgbVar, zzgd zzgdVar) {
        zzgdVar.getClass();
        zzkm zzkmVar = zzgbVar.zzd;
        if (!zzkmVar.zzc()) {
            zzgbVar.zzd = zzkf.zzbF(zzkmVar);
        }
        zzgbVar.zzd.add(zzgdVar);
    }

    public final zzgd zzc(int i11) {
        return (zzgd) this.zzd.get(0);
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
            return zzkf.zzbI(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgd.class});
        }
        if (i12 == 3) {
            return new zzgb();
        }
        zzfk zzfkVar = null;
        if (i12 == 4) {
            return new zzga(zzfkVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zza;
    }
}
