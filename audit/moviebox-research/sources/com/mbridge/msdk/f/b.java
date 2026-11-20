package com.mbridge.msdk.f;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.MBConfiguration;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f43979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Boolean f43980b;

    public static boolean a() {
        if (f43979a == null) {
            try {
                Boolean boolValueOf = Boolean.valueOf(Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 2);
                f43979a = boolValueOf;
                return boolValueOf.booleanValue();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("CommonUtils", "isChina", e11);
                }
            }
        }
        return f43979a != null && f43979a.booleanValue();
    }

    public static boolean b() {
        if (f43980b == null) {
            try {
                Boolean boolValueOf = Boolean.valueOf(Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 1);
                f43980b = boolValueOf;
                return boolValueOf.booleanValue();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("CommonUtils", "isOversea", e11);
                }
            }
        }
        return f43980b != null && f43980b.booleanValue();
    }
}
