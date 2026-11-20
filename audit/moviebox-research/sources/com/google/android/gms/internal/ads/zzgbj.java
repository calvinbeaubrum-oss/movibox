package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgbj implements Comparator {
    public static zzgbj zzb(Comparator comparator) {
        return comparator instanceof zzgbj ? (zzgbj) comparator : new zzfzl(comparator);
    }

    public static zzgbj zzc() {
        return zzgbh.zza;
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzgbj zza() {
        return new zzgbs(this);
    }
}
