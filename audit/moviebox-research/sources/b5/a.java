package b5;

import java.io.IOException;
import u4.l0;
import u4.o0;
import u4.r;
import u4.s;
import u4.t;
import u4.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f14009a;

    public a(int i11) {
        if ((i11 & 1) != 0) {
            this.f14009a = new o0(65496, 2, "image/jpeg");
        } else {
            this.f14009a = new b();
        }
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        return this.f14009a.b(tVar);
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        return this.f14009a.d(tVar, l0Var);
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f14009a.f(uVar);
    }

    @Override // u4.s
    public void release() {
        this.f14009a.release();
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f14009a.seek(j11, j12);
    }
}
