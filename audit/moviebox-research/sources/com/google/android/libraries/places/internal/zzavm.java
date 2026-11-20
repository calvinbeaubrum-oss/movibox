package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzavm {
    private static final zzavl zza;
    private static final zzavl zzb;

    static {
        zzavl zzavlVar;
        try {
            zzavlVar = (zzavl) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzavlVar = null;
        }
        zza = zzavlVar;
        zzb = new zzavl();
    }

    public static zzavl zza() {
        return zza;
    }

    public static zzavl zzb() {
        return zzb;
    }
}
