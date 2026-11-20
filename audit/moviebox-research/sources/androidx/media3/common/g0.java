package androidx.media3.common;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g0 f9218d = new g0(1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9219e = u0.E0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9220f = u0.E0(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final i<g0> f9221g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f9222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9224c;

    public g0(float f11) {
        this(f11, 1.0f);
    }

    public g0(float f11, float f12) {
        z3.a.a(f11 > 0.0f);
        z3.a.a(f12 > 0.0f);
        this.f9222a = f11;
        this.f9223b = f12;
        this.f9224c = Math.round(f11 * 1000.0f);
    }

    public long a(long j11) {
        return j11 * ((long) this.f9224c);
    }

    @CheckResult
    public g0 b(float f11) {
        return new g0(f11, this.f9223b);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g0.class != obj.getClass()) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f9222a == g0Var.f9222a && this.f9223b == g0Var.f9223b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f9222a)) * 31) + Float.floatToRawIntBits(this.f9223b);
    }

    public String toString() {
        return u0.G("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f9222a), Float.valueOf(this.f9223b));
    }
}
