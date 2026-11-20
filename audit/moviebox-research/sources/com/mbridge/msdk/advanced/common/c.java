package com.mbridge.msdk.advanced.common;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f42811a = new HashMap();

    public static void a(String str, boolean z11) {
        f42811a.put(str, Boolean.valueOf(z11));
    }

    public static boolean a(String str) {
        if (f42811a.containsKey(str)) {
            return f42811a.get(str).booleanValue();
        }
        return false;
    }

    public static void b(String str) {
        f42811a.remove(str);
    }
}
