package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzls {
    private static final zzlr zza;
    private static final zzlr zzb;

    static {
        zzlr zzlrVar;
        try {
            zzlrVar = (zzlr) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlrVar = null;
        }
        zza = zzlrVar;
        zzb = new zzlr();
    }

    public static zzlr zza() {
        return zza;
    }

    public static zzlr zzb() {
        return zzb;
    }
}
