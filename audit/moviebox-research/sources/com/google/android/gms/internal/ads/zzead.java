package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzead extends Exception {
    private final int zza;

    public zzead(int i11) {
        this.zza = i11;
    }

    public zzead(int i11, String str) {
        super(str);
        this.zza = i11;
    }

    public zzead(int i11, String str, Throwable th2) {
        super(str, th2);
        this.zza = 1;
    }

    public final int zza() {
        return this.zza;
    }
}
