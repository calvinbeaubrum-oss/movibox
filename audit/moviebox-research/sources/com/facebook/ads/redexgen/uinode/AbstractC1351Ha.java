package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.facebook.ads.internal.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ha, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1351Ha {
    public static int A00(int i11, int i12, int i13) {
        if (i11 < i12 || i11 >= i13) {
            throw new IndexOutOfBoundsException();
        }
        return i11;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T A01(T t11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException();
    }

    @EnsuresNonNull({"#1"})
    public static String A02(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static void A03(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void A04(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void A05(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void A06(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
