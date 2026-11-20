package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzavb {
    private static final zzava zza;
    private static final zzava zzb;

    static {
        zzava zzavaVar;
        try {
            zzavaVar = (zzava) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzavaVar = null;
        }
        zza = zzavaVar;
        zzb = new zzava();
    }

    public static zzava zza() {
        return zza;
    }

    public static zzava zzb() {
        return zzb;
    }
}
