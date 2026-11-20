package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhen extends zzgzu implements zzhbf {
    private static final zzhen zzb;
    private int zzd;
    private zzgyl zze;
    private zzgyl zzf;
    private byte zzg = 2;

    static {
        zzhen zzhenVar = new zzhen();
        zzb = zzhenVar;
        zzgzu.zzaU(zzhen.class, zzhenVar);
    }

    private zzhen() {
        zzgyl zzgylVar = zzgyl.zzb;
        this.zze = zzgylVar;
        this.zzf = zzgylVar;
    }

    public static zzhem zza() {
        return (zzhem) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzhen zzhenVar, zzgyl zzgylVar) {
        zzhenVar.zzd |= 1;
        zzhenVar.zze = zzgylVar;
    }

    public static /* synthetic */ void zze(zzhen zzhenVar, zzgyl zzgylVar) {
        zzhenVar.zzd |= 2;
        zzhenVar.zzf = zzgylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzhen();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhem(zzhdpVar);
        }
        if (i12 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
