package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzek {
    public static int zza(int i11, int i12, int i13) {
        if (i11 < 0 || i11 >= i13) {
            throw new IndexOutOfBoundsException();
        }
        return i11;
    }

    public static Object zzb(@Nullable Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException();
    }

    public static String zzc(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static void zzd(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void zze(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzf(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }
}
