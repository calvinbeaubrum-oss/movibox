package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f11757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11758c;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f11761c;

        public b() {
            this.f11759a = C.TIME_UNSET;
            this.f11760b = -3.4028235E38f;
            this.f11761c = C.TIME_UNSET;
        }

        public b(w1 w1Var) {
            this.f11759a = w1Var.f11756a;
            this.f11760b = w1Var.f11757b;
            this.f11761c = w1Var.f11758c;
        }

        public w1 d() {
            return new w1(this);
        }

        public b e(long j11) {
            z3.a.a(j11 >= 0 || j11 == C.TIME_UNSET);
            this.f11761c = j11;
            return this;
        }

        public b f(long j11) {
            this.f11759a = j11;
            return this;
        }

        public b g(float f11) {
            z3.a.a(f11 > 0.0f || f11 == -3.4028235E38f);
            this.f11760b = f11;
            return this;
        }
    }

    public w1(b bVar) {
        this.f11756a = bVar.f11759a;
        this.f11757b = bVar.f11760b;
        this.f11758c = bVar.f11761c;
    }

    public b a() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w1)) {
            return false;
        }
        w1 w1Var = (w1) obj;
        return this.f11756a == w1Var.f11756a && this.f11757b == w1Var.f11757b && this.f11758c == w1Var.f11758c;
    }

    public int hashCode() {
        return com.google.common.base.j.b(Long.valueOf(this.f11756a), Float.valueOf(this.f11757b), Long.valueOf(this.f11758c));
    }
}
