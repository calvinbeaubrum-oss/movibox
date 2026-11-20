package nh;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicLong f71945h = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f71946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.n f71947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f71948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f71949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f71950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f71951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f71952g;

    public n(long j11, com.google.android.exoplayer2.upstream.n nVar, long j12) {
        this(j11, nVar, nVar.f35422a, Collections.emptyMap(), j12, 0L, 0L);
    }

    public n(long j11, com.google.android.exoplayer2.upstream.n nVar, Uri uri, Map<String, List<String>> map, long j12, long j13, long j14) {
        this.f71946a = j11;
        this.f71947b = nVar;
        this.f71948c = uri;
        this.f71949d = map;
        this.f71950e = j12;
        this.f71951f = j13;
        this.f71952g = j14;
    }

    public static long a() {
        return f71945h.getAndIncrement();
    }
}
