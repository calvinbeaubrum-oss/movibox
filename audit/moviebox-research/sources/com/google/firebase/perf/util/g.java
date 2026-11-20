package com.google.firebase.perf.util;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f41029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f41030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeUnit f41031c;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41032a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f41032a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41032a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41032a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(long j11, long j12, TimeUnit timeUnit) {
        this.f41029a = j11;
        this.f41030b = j12;
        this.f41031c = timeUnit;
    }

    public double a() {
        int i11 = a.f41032a[this.f41031c.ordinal()];
        if (i11 == 1) {
            return (this.f41029a / this.f41030b) * TimeUnit.SECONDS.toNanos(1L);
        }
        if (i11 != 2) {
            return i11 != 3 ? this.f41029a / this.f41031c.toSeconds(this.f41030b) : (this.f41029a / this.f41030b) * TimeUnit.SECONDS.toMillis(1L);
        }
        return (this.f41029a / this.f41030b) * TimeUnit.SECONDS.toMicros(1L);
    }
}
