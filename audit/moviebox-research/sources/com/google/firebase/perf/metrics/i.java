package com.google.firebase.perf.metrics;

import com.google.firebase.perf.util.Timer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ql.a f41000f = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f41001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Timer f41002b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f41005e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41004d = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f41003c = new ConcurrentHashMap();

    public i(String str, String str2, vl.k kVar, Timer timer) {
        this.f41005e = false;
        this.f41002b = timer;
        j jVarH = j.d(kVar).s(str).h(str2);
        this.f41001a = jVarH;
        jVarH.j();
        if (nl.a.g().K()) {
            return;
        }
        f41000f.g("HttpMetric feature is disabled. URL %s", str);
        this.f41005e = true;
    }

    public void a(int i11) {
        this.f41001a.i(i11);
    }
}
