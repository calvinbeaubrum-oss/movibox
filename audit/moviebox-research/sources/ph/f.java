package ph;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i0;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f implements Loader.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f73806a = nh.n.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.n f73807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f73808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m1 f73809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f73810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Object f73811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f73812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f73813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i0 f73814i;

    public f(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, int i11, m1 m1Var, int i12, @Nullable Object obj, long j11, long j12) {
        this.f73814i = new i0(kVar);
        this.f73807b = (com.google.android.exoplayer2.upstream.n) com.google.android.exoplayer2.util.a.e(nVar);
        this.f73808c = i11;
        this.f73809d = m1Var;
        this.f73810e = i12;
        this.f73811f = obj;
        this.f73812g = j11;
        this.f73813h = j12;
    }

    public final long a() {
        return this.f73814i.f();
    }

    public final long b() {
        return this.f73813h - this.f73812g;
    }

    public final Map<String, List<String>> c() {
        return this.f73814i.i();
    }

    public final Uri d() {
        return this.f73814i.h();
    }
}
