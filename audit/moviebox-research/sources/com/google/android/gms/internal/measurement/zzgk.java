package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgk extends zzkf implements zzln {
    private static final zzgk zza;
    private int zzd;
    private int zze;
    private zzkl zzf = zzkf.zzbC();

    static {
        zzgk zzgkVar = new zzgk();
        zza = zzgkVar;
        zzkf.zzbL(zzgk.class, zzgkVar);
    }

    private zzgk() {
    }

    public static zzgj zzd() {
        return (zzgj) zza.zzbx();
    }

    public static /* synthetic */ void zzg(zzgk zzgkVar, int i11) {
        zzgkVar.zzd |= 1;
        zzgkVar.zze = i11;
    }

    public static /* synthetic */ void zzh(zzgk zzgkVar, Iterable iterable) {
        zzkl zzklVar = zzgkVar.zzf;
        if (!zzklVar.zzc()) {
            zzgkVar.zzf = zzkf.zzbD(zzklVar);
        }
        zzio.zzbt(iterable, zzgkVar.zzf);
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc(int i11) {
        return this.zzf.zza(i11);
    }

    public final List zzf() {
        return this.zzf;
    }

    public final boolean zzi() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzgk();
        }
        zzfk zzfkVar = null;
        if (i12 == 4) {
            return new zzgj(zzfkVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zza;
    }
}
