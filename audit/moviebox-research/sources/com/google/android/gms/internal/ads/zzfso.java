package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfso extends Exception {
    private final int zza;

    public zzfso(int i11, String str) {
        super(str);
        this.zza = i11;
    }

    public zzfso(int i11, Throwable th2) {
        super(th2);
        this.zza = i11;
    }

    public final int zza() {
        return this.zza;
    }
}
