package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhba {
    private static final zzhaz zza;
    private static final zzhaz zzb;

    static {
        zzhaz zzhazVar;
        try {
            zzhazVar = (zzhaz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzhazVar = null;
        }
        zza = zzhazVar;
        zzb = new zzhaz();
    }

    public static zzhaz zza() {
        return zza;
    }

    public static zzhaz zzb() {
        return zzb;
    }
}
