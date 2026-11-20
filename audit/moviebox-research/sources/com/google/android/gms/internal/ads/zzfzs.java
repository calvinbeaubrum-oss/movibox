package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfzs {
    public static int zza(int i11) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i11) * (-862048943)), 15)) * 461845907);
    }

    public static int zzb(Object obj) {
        return zza(obj == null ? 0 : obj.hashCode());
    }
}
