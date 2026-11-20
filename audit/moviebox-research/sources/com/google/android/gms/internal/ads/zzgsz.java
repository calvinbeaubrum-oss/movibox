package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgsz extends zzgzu implements zzhbf {
    private static final zzgsz zzb;
    private int zzd;
    private zzgtc zze;
    private int zzf;

    static {
        zzgsz zzgszVar = new zzgsz();
        zzb = zzgszVar;
        zzgzu.zzaU(zzgsz.class, zzgszVar);
    }

    private zzgsz() {
    }

    public static zzgsy zzc() {
        return (zzgsy) zzb.zzaA();
    }

    public static zzgsz zze() {
        return zzb;
    }

    public static /* synthetic */ void zzg(zzgsz zzgszVar, zzgtc zzgtcVar) {
        zzgtcVar.getClass();
        zzgszVar.zze = zzgtcVar;
        zzgszVar.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzgsz();
        }
        zzgsx zzgsxVar = null;
        if (i12 == 4) {
            return new zzgsy(zzgsxVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgtc zzf() {
        zzgtc zzgtcVar = this.zze;
        return zzgtcVar == null ? zzgtc.zze() : zzgtcVar;
    }
}
