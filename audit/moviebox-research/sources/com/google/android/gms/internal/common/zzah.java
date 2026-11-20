package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@NullMarked
public final class zzah {
    public static Object[] zza(Object[] objArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (objArr[i12] == null) {
                throw new NullPointerException("at index " + i12);
            }
        }
        return objArr;
    }
}
