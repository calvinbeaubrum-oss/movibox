package com.amazonaws.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TimingInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f16273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f16274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f16275c;

    public TimingInfo(Long l11, long j11, Long l12) {
        this.f16273a = l11;
        this.f16274b = j11;
        this.f16275c = l12;
    }

    public static double b(long j11, long j12) {
        return TimeUnit.NANOSECONDS.toMicros(j12 - j11) / 1000.0d;
    }

    public static TimingInfo m() {
        return new TimingInfo(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo n() {
        return new TimingInfoFullSupport(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo o(long j11) {
        return new TimingInfoFullSupport(null, j11, null);
    }

    public static TimingInfo p(long j11, Long l11) {
        return new TimingInfoUnmodifiable(null, j11, l11);
    }

    public void a(String str, TimingInfo timingInfo) {
    }

    public TimingInfo c() {
        this.f16275c = Long.valueOf(System.nanoTime());
        return this;
    }

    public Map<String, Number> d() {
        return Collections.emptyMap();
    }

    public final long e() {
        Long l11 = this.f16275c;
        if (l11 == null) {
            return -1L;
        }
        return l11.longValue();
    }

    public final long f() {
        return this.f16274b;
    }

    public Map<String, List<TimingInfo>> g() {
        return Collections.emptyMap();
    }

    @Deprecated
    public final double h() {
        Double dI = i();
        if (dI == null) {
            return -1.0d;
        }
        return dI.doubleValue();
    }

    public final Double i() {
        if (k()) {
            return Double.valueOf(b(this.f16274b, this.f16275c.longValue()));
        }
        return null;
    }

    public void j(String str) {
    }

    public final boolean k() {
        return this.f16275c != null;
    }

    public void l(String str, long j11) {
    }

    public final String toString() {
        return String.valueOf(h());
    }
}
