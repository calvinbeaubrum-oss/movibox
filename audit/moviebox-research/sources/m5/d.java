package m5;

import android.net.Uri;
import androidx.media3.common.ParserException;
import java.io.IOException;
import java.util.Map;
import u4.l0;
import u4.r;
import u4.r0;
import u4.s;
import u4.t;
import u4.u;
import u4.x;
import u4.y;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f70810d = new y() { // from class: m5.c
        @Override // u4.y
        public /* synthetic */ y a(o5.s.a aVar) {
            return x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ s[] b(Uri uri, Map map) {
            return x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ y c(boolean z11) {
            return x.b(this, z11);
        }

        @Override // u4.y
        public final s[] createExtractors() {
            return d.e();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f70811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f70812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f70813c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s[] e() {
        return new s[]{new d()};
    }

    public static c0 g(c0 c0Var) {
        c0Var.U(0);
        return c0Var;
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        try {
            return h(tVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        z3.a.i(this.f70811a);
        if (this.f70812b == null) {
            if (!h(tVar)) {
                throw ParserException.createForMalformedContainer("Failed to determine bitstream type", null);
            }
            tVar.resetPeekPosition();
        }
        if (!this.f70813c) {
            r0 r0VarTrack = this.f70811a.track(0, 1);
            this.f70811a.endTracks();
            this.f70812b.d(this.f70811a, r0VarTrack);
            this.f70813c = true;
        }
        return this.f70812b.g(tVar, l0Var);
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f70811a = uVar;
    }

    public final boolean h(t tVar) throws IOException {
        f fVar = new f();
        if (fVar.a(tVar, true) && (fVar.f70820b & 2) == 2) {
            int iMin = Math.min(fVar.f70827i, 8);
            c0 c0Var = new c0(iMin);
            tVar.peekFully(c0Var.e(), 0, iMin);
            if (b.p(g(c0Var))) {
                this.f70812b = new b();
            } else if (j.r(g(c0Var))) {
                this.f70812b = new j();
            } else if (h.o(g(c0Var))) {
                this.f70812b = new h();
            }
            return true;
        }
        return false;
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        i iVar = this.f70812b;
        if (iVar != null) {
            iVar.m(j11, j12);
        }
    }
}
