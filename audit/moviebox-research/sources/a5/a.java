package a5;

import java.io.IOException;
import u4.l0;
import u4.o0;
import u4.r;
import u4.s;
import u4.t;
import u4.u;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f412a = new c0(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f413b = new o0(-1, -1, "image/heif");

    public final boolean a(t tVar, int i11) throws IOException {
        this.f412a.Q(4);
        tVar.peekFully(this.f412a.e(), 0, 4);
        return this.f412a.J() == ((long) i11);
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        tVar.advancePeekPosition(4);
        return a(tVar, 1718909296) && a(tVar, 1751476579);
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        return this.f413b.d(tVar, l0Var);
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f413b.f(uVar);
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f413b.seek(j11, j12);
    }
}
