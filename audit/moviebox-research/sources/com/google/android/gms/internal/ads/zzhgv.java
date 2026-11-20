package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzhgv {
    public static zzhgv zzb(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzhgq(cls.getSimpleName()) : new zzhgs(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
