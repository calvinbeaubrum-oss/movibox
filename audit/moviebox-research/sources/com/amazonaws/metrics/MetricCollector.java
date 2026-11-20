package com.amazonaws.metrics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MetricCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MetricCollector f15775a = new MetricCollector() { // from class: com.amazonaws.metrics.MetricCollector.1
        @Override // com.amazonaws.metrics.MetricCollector
        public RequestMetricCollector a() {
            return RequestMetricCollector.f15777a;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public ServiceMetricCollector b() {
            return ServiceMetricCollector.f15778a;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public boolean c() {
            return false;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public boolean d() {
            return true;
        }
    };

    /* JADX INFO: compiled from: source.java */
    public interface Factory {
        MetricCollector a();
    }

    public abstract RequestMetricCollector a();

    public abstract ServiceMetricCollector b();

    public abstract boolean c();

    public abstract boolean d();
}
