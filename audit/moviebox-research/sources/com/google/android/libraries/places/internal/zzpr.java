package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzpr {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    public zzpr(String str, Class cls, boolean z11) {
        this(str, cls, z11, true);
    }

    private zzpr(String str, Class cls, boolean z11, boolean z12) {
        zzrr.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z11;
        System.identityHashCode(this);
        for (int i11 = 0; i11 < 5; i11++) {
        }
    }

    public static zzpr zza(String str, Class cls) {
        return new zzpr(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        return getClass().getName() + "/" + this.zza + "[" + cls.getName() + "]";
    }

    public final boolean zzb() {
        return this.zzc;
    }
}
