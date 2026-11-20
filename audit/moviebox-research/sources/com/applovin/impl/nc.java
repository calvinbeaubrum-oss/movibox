package com.applovin.impl;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class nc {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicLong f21311h = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l5 f21313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f21314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f21315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f21316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f21317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f21318g;

    public nc(long j11, l5 l5Var, long j12) {
        this(j11, l5Var, l5Var.f20336a, Collections.emptyMap(), j12, 0L, 0L);
    }

    public nc(long j11, l5 l5Var, Uri uri, Map map, long j12, long j13, long j14) {
        this.f21312a = j11;
        this.f21313b = l5Var;
        this.f21314c = uri;
        this.f21315d = map;
        this.f21316e = j12;
        this.f21317f = j13;
        this.f21318g = j14;
    }

    public static long a() {
        return f21311h.getAndIncrement();
    }
}
