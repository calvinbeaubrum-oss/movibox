package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzo implements zzhbc {
    private static final zzgzo zza = new zzgzo();

    private zzgzo() {
    }

    public static zzgzo zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhbc
    public final zzhbb zzb(Class cls) {
        if (!zzgzu.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzhbb) zzgzu.zzaC(cls.asSubclass(zzgzu.class)).zzb(3, null, null);
        } catch (Exception e11) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbc
    public final boolean zzc(Class cls) {
        return zzgzu.class.isAssignableFrom(cls);
    }
}
