package com.amazonaws.metrics;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class ByteThroughputHelper extends ByteThroughputProvider {
    public ByteThroughputHelper(ThroughputMetricType throughputMetricType) {
        super(throughputMetricType);
    }

    @Override // com.amazonaws.metrics.ByteThroughputProvider
    public void d(int i11, long j11) {
        super.d(i11, j11);
    }

    public void f() {
        if (a() > 0) {
            AwsSdkMetrics.getServiceMetricCollector().a(this);
            e();
        }
    }

    public long g() {
        if (TimeUnit.NANOSECONDS.toSeconds(b()) > 10) {
            f();
        }
        return System.nanoTime();
    }
}
