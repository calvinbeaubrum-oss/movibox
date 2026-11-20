package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzka implements zzlk {
    private static final zzka zza = new zzka();

    private zzka() {
    }

    public static zzka zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final zzlj zzb(Class cls) {
        if (!zzkf.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzlj) zzkf.zzbz(cls.asSubclass(zzkf.class)).zzl(3, null, null);
        } catch (Exception e11) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final boolean zzc(Class cls) {
        return zzkf.class.isAssignableFrom(cls);
    }
}
