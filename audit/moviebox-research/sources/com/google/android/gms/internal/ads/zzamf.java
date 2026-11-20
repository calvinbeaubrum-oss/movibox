package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzamf implements Comparable {
    public final int zza;
    public final zzalz zzb;

    public zzamf(int i11, zzalz zzalzVar) {
        this.zza = i11;
        this.zzb = zzalzVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.zza, ((zzamf) obj).zza);
    }
}
