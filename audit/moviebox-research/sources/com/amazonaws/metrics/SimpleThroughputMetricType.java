package com.amazonaws.metrics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleThroughputMetricType extends SimpleServiceMetricType implements ThroughputMetricType {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ServiceMetricType f15781c;

    public SimpleThroughputMetricType(String str, String str2, String str3) {
        super(str, str2);
        this.f15781c = new SimpleServiceMetricType(str3, str2);
    }
}
