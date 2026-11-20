package com.google.firebase.perf.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import ll.a;
import nl.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class ConfigurationConstants$LogSourceName extends u<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConfigurationConstants$LogSourceName f40968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, String> f40969b = Collections.unmodifiableMap(new HashMap<Long, String>() { // from class: com.google.firebase.perf.config.ConfigurationConstants$LogSourceName.1
        {
            put(461L, "FIREPERF_AUTOPUSH");
            put(462L, "FIREPERF");
            put(675L, "FIREPERF_INTERNAL_LOW");
            put(676L, "FIREPERF_INTERNAL_HIGH");
        }
    });

    public static synchronized ConfigurationConstants$LogSourceName e() {
        try {
            if (f40968a == null) {
                f40968a = new ConfigurationConstants$LogSourceName();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f40968a;
    }

    public static String f(long j11) {
        return f40969b.get(Long.valueOf(j11));
    }

    public static boolean g(long j11) {
        return f40969b.containsKey(Long.valueOf(j11));
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.LogSourceName";
    }

    @Override // nl.u
    public String c() {
        return "fpr_log_source";
    }

    public String d() {
        return a.f70307c;
    }
}
