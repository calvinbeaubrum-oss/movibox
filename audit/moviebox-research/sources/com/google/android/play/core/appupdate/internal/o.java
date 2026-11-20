package com.google.android.play.core.appupdate.internal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f38052a = new HashSet(Arrays.asList("app_update", "review"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f38053b = new HashSet(Arrays.asList("native", "unity"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f38054c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f38055d = new s("PlayCoreVersion");

    public static synchronized Map a(String str) {
        Map map;
        try {
            map = f38054c;
            if (!map.containsKey("app_update")) {
                HashMap map2 = new HashMap();
                map2.put("java", 11004);
                map.put("app_update", map2);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (Map) map.get("app_update");
    }
}
