package com.amazonaws.metrics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleServiceMetricType extends SimpleMetricType implements ServiceMetricType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15780b;

    public SimpleServiceMetricType(String str, String str2) {
        this.f15779a = str;
        this.f15780b = str2;
    }

    @Override // com.amazonaws.metrics.SimpleMetricType, com.amazonaws.metrics.MetricType
    public String name() {
        return this.f15779a;
    }
}
