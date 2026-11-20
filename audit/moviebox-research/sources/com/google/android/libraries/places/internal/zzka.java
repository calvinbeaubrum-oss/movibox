package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzka {
    public abstract zzka zzb(int i11);

    public abstract zzkb zzc();

    public abstract zzka zzd(int i11);

    public final zzkb zze() {
        zzkb zzkbVarZzc = zzc();
        zzmt.zzp(!zzkbVarZzc.zzb().isEmpty(), "Package name must not be empty.");
        return zzkbVarZzc;
    }
}
