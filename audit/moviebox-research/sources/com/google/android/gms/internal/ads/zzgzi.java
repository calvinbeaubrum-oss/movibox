package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzi {
    private static final zzgzg zza = new zzgzh();
    private static final zzgzg zzb;

    static {
        zzgzg zzgzgVar;
        try {
            zzgzgVar = (zzgzg) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgzgVar = null;
        }
        zzb = zzgzgVar;
    }

    public static zzgzg zza() {
        zzgzg zzgzgVar = zzb;
        if (zzgzgVar != null) {
            return zzgzgVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzgzg zzb() {
        return zza;
    }
}
