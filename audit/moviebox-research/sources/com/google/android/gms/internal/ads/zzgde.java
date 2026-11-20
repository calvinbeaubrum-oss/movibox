package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzgde {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j11, Object obj2, Object obj3) {
        while (!k.a(unsafe, obj, j11, obj2, obj3)) {
            if (unsafe.getObject(obj, j11) != obj2) {
                return false;
            }
        }
        return true;
    }
}
