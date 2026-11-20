package p4;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicLong f73578h = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f73579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4.g f73580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f73581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f73582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f73583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f73584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f73585g;

    public n(long j11, c4.g gVar, long j12) {
        this(j11, gVar, gVar.f14598a, Collections.emptyMap(), j12, 0L, 0L);
    }

    public n(long j11, c4.g gVar, Uri uri, Map<String, List<String>> map, long j12, long j13, long j14) {
        this.f73579a = j11;
        this.f73580b = gVar;
        this.f73581c = uri;
        this.f73582d = map;
        this.f73583e = j12;
        this.f73584f = j13;
        this.f73585g = j14;
    }

    public static long a() {
        return f73578h.getAndIncrement();
    }
}
