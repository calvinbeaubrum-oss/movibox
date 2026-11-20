package ch;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import java.io.IOException;
import java.util.Map;
import tg.a0;
import tg.e0;
import tg.l;
import tg.m;
import tg.n;
import tg.q;
import tg.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f14806d = new r() { // from class: ch.c
        @Override // tg.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // tg.r
        public final l[] createExtractors() {
            return d.e();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f14807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f14808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14809c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] e() {
        return new l[]{new d()};
    }

    public static c0 f(c0 c0Var) {
        c0Var.P(0);
        return c0Var;
    }

    @Override // tg.l
    public boolean b(m mVar) throws IOException {
        try {
            return g(mVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // tg.l
    public int c(m mVar, a0 a0Var) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f14807a);
        if (this.f14808b == null) {
            if (!g(mVar)) {
                throw ParserException.createForMalformedContainer("Failed to determine bitstream type", null);
            }
            mVar.resetPeekPosition();
        }
        if (!this.f14809c) {
            e0 e0VarTrack = this.f14807a.track(0, 1);
            this.f14807a.endTracks();
            this.f14808b.d(this.f14807a, e0VarTrack);
            this.f14809c = true;
        }
        return this.f14808b.g(mVar, a0Var);
    }

    @Override // tg.l
    public void d(n nVar) {
        this.f14807a = nVar;
    }

    public final boolean g(m mVar) throws IOException {
        f fVar = new f();
        if (fVar.a(mVar, true) && (fVar.f14816b & 2) == 2) {
            int iMin = Math.min(fVar.f14823i, 8);
            c0 c0Var = new c0(iMin);
            mVar.peekFully(c0Var.d(), 0, iMin);
            if (b.p(f(c0Var))) {
                this.f14808b = new b();
            } else if (j.r(f(c0Var))) {
                this.f14808b = new j();
            } else if (h.p(f(c0Var))) {
                this.f14808b = new h();
            }
            return true;
        }
        return false;
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        i iVar = this.f14808b;
        if (iVar != null) {
            iVar.m(j11, j12);
        }
    }
}
