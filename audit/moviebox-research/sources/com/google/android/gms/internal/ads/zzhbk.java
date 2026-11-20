package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhbk {
    private static final zzhbj zza;
    private static final zzhbj zzb;

    static {
        zzhbj zzhbjVar;
        try {
            zzhbjVar = (zzhbj) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzhbjVar = null;
        }
        zza = zzhbjVar;
        zzb = new zzhbj();
    }

    public static zzhbj zza() {
        return zza;
    }

    public static zzhbj zzb() {
        return zzb;
    }
}
