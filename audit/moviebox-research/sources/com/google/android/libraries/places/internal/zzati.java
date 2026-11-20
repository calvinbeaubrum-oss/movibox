package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzati {
    private static final zzatg zza = new zzath();
    private static final zzatg zzb;

    static {
        zzatg zzatgVar;
        try {
            zzatgVar = (zzatg) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzatgVar = null;
        }
        zzb = zzatgVar;
    }

    public static zzatg zza() {
        zzatg zzatgVar = zzb;
        if (zzatgVar != null) {
            return zzatgVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzatg zzb() {
        return zza;
    }
}
