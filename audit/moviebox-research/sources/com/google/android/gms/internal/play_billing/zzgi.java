package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgi {
    private static final zzgh zza;
    private static final zzgh zzb;

    static {
        zzgh zzghVar;
        try {
            zzghVar = (zzgh) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzghVar = null;
        }
        zza = zzghVar;
        zzb = new zzgh();
    }

    public static zzgh zza() {
        return zza;
    }

    public static zzgh zzb() {
        return zzb;
    }
}
