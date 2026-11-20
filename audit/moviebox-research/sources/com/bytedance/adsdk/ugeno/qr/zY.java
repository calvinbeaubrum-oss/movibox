package com.bytedance.adsdk.ugeno.qr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zY {
    public static double sc(String str, double d11) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d11;
        }
    }

    public static float sc(String str, float f11) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f11;
        }
    }

    public static int sc(String str, int i11) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public static long sc(String str, long j11) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j11;
        }
    }

    public static boolean sc(String str, boolean z11) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException unused) {
            return z11;
        }
    }
}
