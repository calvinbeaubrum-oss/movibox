package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgvf extends zzgzu implements zzhbf {
    private static final zzgvf zzb;
    private int zzd;
    private zzgut zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzgvf zzgvfVar = new zzgvf();
        zzb = zzgvfVar;
        zzgzu.zzaU(zzgvf.class, zzgvfVar);
    }

    private zzgvf() {
    }

    public static zzgve zzd() {
        return (zzgve) zzb.zzaA();
    }

    public static /* synthetic */ void zzg(zzgvf zzgvfVar, zzgut zzgutVar) {
        zzgutVar.getClass();
        zzgvfVar.zze = zzgutVar;
        zzgvfVar.zzd |= 1;
    }

    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i12 == 3) {
            return new zzgvf();
        }
        zzgvc zzgvcVar = null;
        if (i12 == 4) {
            return new zzgve(zzgvcVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgut zzc() {
        zzgut zzgutVar = this.zze;
        return zzgutVar == null ? zzgut.zze() : zzgutVar;
    }

    public final zzgvz zzf() {
        zzgvz zzgvzVarZzb = zzgvz.zzb(this.zzh);
        return zzgvzVarZzb == null ? zzgvz.UNRECOGNIZED : zzgvzVarZzb;
    }

    public final boolean zzj() {
        return (this.zzd & 1) != 0;
    }

    public final int zzk() {
        int i11 = this.zzf;
        int i12 = 2;
        if (i11 != 0) {
            if (i11 == 1) {
                i12 = 3;
            } else if (i11 != 2) {
                i12 = i11 != 3 ? 0 : 5;
            } else {
                i12 = 4;
            }
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }
}
