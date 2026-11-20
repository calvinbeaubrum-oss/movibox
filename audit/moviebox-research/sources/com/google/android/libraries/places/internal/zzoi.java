package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoi {
    public static Object zza(Object obj, int i11) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i11);
    }

    public static Object[] zzb(Object[] objArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            zza(objArr[i12], i12);
        }
        return objArr;
    }
}
