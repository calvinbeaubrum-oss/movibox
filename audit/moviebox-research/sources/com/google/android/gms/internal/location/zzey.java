package com.google.android.gms.internal.location;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzey extends zzex {
    static final zzex zza = new zzey(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzey(Object[] objArr, int i11) {
        this.zzb = objArr;
        this.zzc = i11;
    }

    @Override // java.util.List
    public final Object get(int i11) {
        zzer.zzc(i11, this.zzc, "index");
        Object obj = this.zzb[i11];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.location.zzex, com.google.android.gms.internal.location.zzeu
    public final int zzg(Object[] objArr, int i11) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
