package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.common.m0;
import e4.x3;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface l {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        a a(o5.s.a aVar);

        a b(boolean z11);

        l c(b0 b0Var);

        a d(i4.u uVar);

        a e(androidx.media3.exoplayer.upstream.m mVar);

        a f(androidx.media3.exoplayer.upstream.f.a aVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f11209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f11212d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f11213e;

        public b(Object obj) {
            this(obj, -1L);
        }

        public b(Object obj, int i11, int i12, long j11) {
            this(obj, i11, i12, j11, -1);
        }

        public b(Object obj, int i11, int i12, long j11, int i13) {
            this.f11209a = obj;
            this.f11210b = i11;
            this.f11211c = i12;
            this.f11212d = j11;
            this.f11213e = i13;
        }

        public b(Object obj, long j11) {
            this(obj, -1, -1, j11, -1);
        }

        public b(Object obj, long j11, int i11) {
            this(obj, -1, -1, j11, i11);
        }

        public b a(Object obj) {
            return this.f11209a.equals(obj) ? this : new b(obj, this.f11210b, this.f11211c, this.f11212d, this.f11213e);
        }

        public boolean b() {
            return this.f11210b != -1;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f11209a.equals(bVar.f11209a) && this.f11210b == bVar.f11210b && this.f11211c == bVar.f11211c && this.f11212d == bVar.f11212d && this.f11213e == bVar.f11213e;
        }

        public int hashCode() {
            return ((((((((527 + this.f11209a.hashCode()) * 31) + this.f11210b) * 31) + this.f11211c) * 31) + ((int) this.f11212d)) * 31) + this.f11213e;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(l lVar, m0 m0Var);
    }

    b0 a();

    boolean c();

    @Nullable
    m0 d();

    void e(Handler handler, m mVar);

    void f(m mVar);

    k h(b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11);

    void i(c cVar, @Nullable c4.o oVar, x3 x3Var);

    void j(Handler handler, androidx.media3.exoplayer.drm.b bVar);

    void k(androidx.media3.exoplayer.drm.b bVar);

    void l(k kVar);

    void m(c cVar);

    void maybeThrowSourceInfoRefreshError() throws IOException;

    void n(b0 b0Var);

    void o(c cVar);

    void p(c cVar);

    boolean q(b0 b0Var);
}
