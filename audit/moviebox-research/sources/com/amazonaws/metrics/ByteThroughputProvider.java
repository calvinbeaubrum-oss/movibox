package com.amazonaws.metrics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteThroughputProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThroughputMetricType f15774c;

    public ByteThroughputProvider(ThroughputMetricType throughputMetricType) {
        this.f15774c = throughputMetricType;
    }

    public int a() {
        return this.f15773b;
    }

    public long b() {
        return this.f15772a;
    }

    public String c() {
        return super.toString();
    }

    public void d(int i11, long j11) {
        this.f15773b += i11;
        this.f15772a += System.nanoTime() - j11;
    }

    public void e() {
        this.f15773b = 0;
        this.f15772a = 0L;
    }

    public String toString() {
        return String.format("providerId=%s, throughputType=%s, byteCount=%d, duration=%d", c(), this.f15774c, Integer.valueOf(this.f15773b), Long.valueOf(this.f15772a));
    }
}
