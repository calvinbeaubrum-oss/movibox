package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s2 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final androidx.media3.exoplayer.source.l.b f11064t = new androidx.media3.exoplayer.source.l.b(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.common.m0 f11065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.l.b f11066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final ExoPlaybackException f11070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f11071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p4.k0 f11072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s4.f0 f11073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Metadata> f11074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.l.b f11075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f11076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f11077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final androidx.media3.common.g0 f11078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f11079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile long f11080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f11081q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f11082r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f11083s;

    public s2(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar, long j11, long j12, int i11, @Nullable ExoPlaybackException exoPlaybackException, boolean z11, p4.k0 k0Var, s4.f0 f0Var, List<Metadata> list, androidx.media3.exoplayer.source.l.b bVar2, boolean z12, int i12, androidx.media3.common.g0 g0Var, long j13, long j14, long j15, long j16, boolean z13) {
        this.f11065a = m0Var;
        this.f11066b = bVar;
        this.f11067c = j11;
        this.f11068d = j12;
        this.f11069e = i11;
        this.f11070f = exoPlaybackException;
        this.f11071g = z11;
        this.f11072h = k0Var;
        this.f11073i = f0Var;
        this.f11074j = list;
        this.f11075k = bVar2;
        this.f11076l = z12;
        this.f11077m = i12;
        this.f11078n = g0Var;
        this.f11080p = j13;
        this.f11081q = j14;
        this.f11082r = j15;
        this.f11083s = j16;
        this.f11079o = z13;
    }

    public static s2 k(s4.f0 f0Var) {
        androidx.media3.common.m0 m0Var = androidx.media3.common.m0.f9282a;
        androidx.media3.exoplayer.source.l.b bVar = f11064t;
        return new s2(m0Var, bVar, C.TIME_UNSET, 0L, 1, null, false, p4.k0.f73571d, f0Var, ImmutableList.of(), bVar, false, 0, androidx.media3.common.g0.f9218d, 0L, 0L, 0L, 0L, false);
    }

    public static androidx.media3.exoplayer.source.l.b l() {
        return f11064t;
    }

    @CheckResult
    public s2 a() {
        return new s2(this.f11065a, this.f11066b, this.f11067c, this.f11068d, this.f11069e, this.f11070f, this.f11071g, this.f11072h, this.f11073i, this.f11074j, this.f11075k, this.f11076l, this.f11077m, this.f11078n, this.f11080p, this.f11081q, m(), SystemClock.elapsedRealtime(), this.f11079o);
    }

    @CheckResult
    public s2 b(boolean z11) {
        return new s2(this.f11065a, this.f11066b, this.f11067c, this.f11068d, this.f11069e, this.f11070f, z11, this.f11072h, this.f11073i, this.f11074j, this.f11075k, this.f11076l, this.f11077m, this.f11078n, this.f11080p, this.f11081q, this.f11082r, this.f11083s, this.f11079o);
    }

    @CheckResult
    public s2 c(androidx.media3.exoplayer.source.l.b bVar) {
        return new s2(this.f11065a, this.f11066b, this.f11067c, this.f11068d, this.f11069e, this.f11070f, this.f11071g, this.f11072h, this.f11073i, this.f11074j, bVar, this.f11076l, this.f11077m, this.f11078n, this.f11080p, this.f11081q, this.f11082r, this.f11083s, this.f11079o);
    }

    @CheckResult
    public s2 d(androidx.media3.exoplayer.source.l.b bVar, long j11, long j12, long j13, long j14, p4.k0 k0Var, s4.f0 f0Var, List<Metadata> list) {
        return new s2(this.f11065a, bVar, j12, j13, this.f11069e, this.f11070f, this.f11071g, k0Var, f0Var, list, this.f11075k, this.f11076l, this.f11077m, this.f11078n, this.f11080p, j14, j11, SystemClock.elapsedRealtime(), this.f11079o);
    }

    @CheckResult
    public s2 e(boolean z11, int i11) {
        return new s2(this.f11065a, this.f11066b, this.f11067c, this.f11068d, this.f11069e, this.f11070f, this.f11071g, this.f11072h, this.f11073i, this.f11074j, this.f11075k, z11, i11, this.f11078n, this.f11080p, this.f11081q, this.f11082r, this.f11083s, this.f11079o);
    }

    @CheckResult
    public s2 f(@Nullable ExoPlaybackException exoPlaybackException) {
        return new s2(this.f11065a, this.f11066b, this.f11067c, this.f11068d, this.f11069e, exoPlaybackException, this.f11071g, this.f11072h, this.f11073i, this.f11074j, this.f11075k, this.f11076l, this.f11077m, this.f11078n, this.f11080p, this.f11081q, this.f11082r, this.f11083s, this.f11079o);
    }

    @CheckResult
    public s2 g(androidx.media3.common.g0 g0Var) {
        return new s2(this.f11065a, this.f11066b, this.f11067c, this.f11068d, this.f11069e, this.f11070f, this.f11071g, this.f11072h, this.f11073i, this.f11074j, this.f11075k, this.f11076l, this.f11077m, g0Var, this.f11080p, this.f11081q, this.f11082r, this.f11083s, this.f11079o);
    }

    @CheckResult
    public s2 h(int i11) {
        return new s2(this.f11065a, this.f11066b, this.f11067c, this.f11068d, i11, this.f11070f, this.f11071g, this.f11072h, this.f11073i, this.f11074j, this.f11075k, this.f11076l, this.f11077m, this.f11078n, this.f11080p, this.f11081q, this.f11082r, this.f11083s, this.f11079o);
    }

    @CheckResult
    public s2 i(boolean z11) {
        return new s2(this.f11065a, this.f11066b, this.f11067c, this.f11068d, this.f11069e, this.f11070f, this.f11071g, this.f11072h, this.f11073i, this.f11074j, this.f11075k, this.f11076l, this.f11077m, this.f11078n, this.f11080p, this.f11081q, this.f11082r, this.f11083s, z11);
    }

    @CheckResult
    public s2 j(androidx.media3.common.m0 m0Var) {
        return new s2(m0Var, this.f11066b, this.f11067c, this.f11068d, this.f11069e, this.f11070f, this.f11071g, this.f11072h, this.f11073i, this.f11074j, this.f11075k, this.f11076l, this.f11077m, this.f11078n, this.f11080p, this.f11081q, this.f11082r, this.f11083s, this.f11079o);
    }

    public long m() {
        long j11;
        long j12;
        if (!n()) {
            return this.f11082r;
        }
        do {
            j11 = this.f11083s;
            j12 = this.f11082r;
        } while (j11 != this.f11083s);
        return z3.u0.S0(z3.u0.B1(j12) + ((long) ((SystemClock.elapsedRealtime() - j11) * this.f11078n.f9222a)));
    }

    public boolean n() {
        return this.f11069e == 3 && this.f11076l && this.f11077m == 0;
    }

    public void o(long j11) {
        this.f11082r = j11;
        this.f11083s = SystemClock.elapsedRealtime();
    }
}
