package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfnk extends zzgzu implements zzhbf {
    private static final zzfnk zzb;
    private zzhad zzd = zzgzu.zzaN();

    static {
        zzfnk zzfnkVar = new zzfnk();
        zzb = zzfnkVar;
        zzgzu.zzaU(zzfnk.class, zzfnkVar);
    }

    private zzfnk() {
    }

    public static zzfnh zzc() {
        return (zzfnh) zzb.zzaA();
    }

    public static /* synthetic */ void zzf(zzfnk zzfnkVar, zzfnj zzfnjVar) {
        zzfnjVar.getClass();
        zzhad zzhadVar = zzfnkVar.zzd;
        if (!zzhadVar.zzc()) {
            zzfnkVar.zzd = zzgzu.zzaO(zzhadVar);
        }
        zzfnkVar.zzd.add(zzfnjVar);
    }

    public final int zza() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfnj.class});
        }
        if (i12 == 3) {
            return new zzfnk();
        }
        zzfng zzfngVar = null;
        if (i12 == 4) {
            return new zzfnh(zzfngVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
