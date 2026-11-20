package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import java.io.IOException;
import sg.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface i {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        i a(u1 u1Var);

        a b(u uVar);

        a c(z zVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends nh.p {
        public b(Object obj) {
            super(obj);
        }

        public b(Object obj, int i11, int i12, long j11) {
            super(obj, i11, i12, j11);
        }

        public b(Object obj, long j11) {
            super(obj, j11);
        }

        public b(Object obj, long j11, int i11) {
            super(obj, j11, i11);
        }

        public b(nh.p pVar) {
            super(pVar);
        }

        public b c(Object obj) {
            return new b(super.a(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(i iVar, j3 j3Var);
    }

    u1 a();

    boolean c();

    @Nullable
    j3 d();

    h e(b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11);

    void f(c cVar);

    void h(Handler handler, j jVar);

    void i(j jVar);

    void k(h hVar);

    void m(c cVar);

    void maybeThrowSourceInfoRefreshError() throws IOException;

    void o(c cVar, @Nullable k0 k0Var, qg.u1 u1Var);

    void p(c cVar);

    void q(Handler handler, com.google.android.exoplayer2.drm.b bVar);

    void r(com.google.android.exoplayer2.drm.b bVar);
}
