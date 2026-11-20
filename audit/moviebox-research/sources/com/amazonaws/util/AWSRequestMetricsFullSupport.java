package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class AWSRequestMetricsFullSupport extends AWSRequestMetrics {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Log f16247d = LogFactory.c("com.amazonaws.latency");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f16248e = "=";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f16249f = ", ";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<Object>> f16250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, TimingInfo> f16251c;

    public AWSRequestMetricsFullSupport() {
        super(TimingInfo.n());
        this.f16250b = new HashMap();
        this.f16251c = new HashMap();
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void a(MetricType metricType, Object obj) {
        h(metricType.name(), obj);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void b(MetricType metricType) {
        i(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void d(MetricType metricType) {
        j(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void e() {
        if (f16247d.c()) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, List<Object>> entry : this.f16250b.entrySet()) {
                k(entry.getKey(), entry.getValue(), sb2);
            }
            for (Map.Entry<String, Number> entry2 : this.f16246a.d().entrySet()) {
                k(entry2.getKey(), entry2.getValue(), sb2);
            }
            for (Map.Entry<String, List<TimingInfo>> entry3 : this.f16246a.g().entrySet()) {
                k(entry3.getKey(), entry3.getValue(), sb2);
            }
            f16247d.d(sb2.toString());
        }
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void f(MetricType metricType, long j11) {
        l(metricType.name(), j11);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void g(MetricType metricType) {
        m(metricType.name());
    }

    public void h(String str, Object obj) {
        List<Object> arrayList = this.f16250b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f16250b.put(str, arrayList);
        }
        arrayList.add(obj);
    }

    public void i(String str) {
        TimingInfo timingInfo = this.f16251c.get(str);
        if (timingInfo != null) {
            timingInfo.c();
            this.f16246a.a(str, TimingInfo.p(timingInfo.f(), Long.valueOf(timingInfo.e())));
            return;
        }
        LogFactory.b(getClass()).j("Trying to end an event which was never started: " + str);
    }

    public void j(String str) {
        this.f16246a.j(str);
    }

    public final void k(Object obj, Object obj2, StringBuilder sb2) {
        sb2.append(obj);
        sb2.append(f16248e);
        sb2.append(obj2);
        sb2.append(f16249f);
    }

    public void l(String str, long j11) {
        this.f16246a.l(str, j11);
    }

    public void m(String str) {
        this.f16251c.put(str, TimingInfo.o(System.nanoTime()));
    }
}
