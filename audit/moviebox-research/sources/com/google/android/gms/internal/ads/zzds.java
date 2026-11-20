package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzds extends Exception {
    public final zzdr zza;

    public zzds(String str, zzdr zzdrVar) {
        super("Unhandled input format: ".concat(String.valueOf(zzdrVar)));
        this.zza = zzdrVar;
    }
}
