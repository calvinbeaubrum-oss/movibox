package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgvk extends zzgzu implements zzhbf {
    private static final zzgvk zzb;
    private String zzd = "";
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgvk zzgvkVar = new zzgvk();
        zzb = zzgvkVar;
        zzgzu.zzaU(zzgvk.class, zzgvkVar);
    }

    private zzgvk() {
    }

    public static zzgvj zza() {
        return (zzgvj) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzgvk zzgvkVar, String str) {
        str.getClass();
        zzgvkVar.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzgvk();
        }
        zzgvh zzgvhVar = null;
        if (i12 == 4) {
            return new zzgvj(zzgvhVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
