package z5;

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
    public final c0 f81875a = new c0(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f81876b = new o0(-1, -1, "image/webp");

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        this.f81875a.Q(4);
        tVar.peekFully(this.f81875a.e(), 0, 4);
        if (this.f81875a.J() != 1380533830) {
            return false;
        }
        tVar.advancePeekPosition(4);
        this.f81875a.Q(4);
        tVar.peekFully(this.f81875a.e(), 0, 4);
        return this.f81875a.J() == 1464156752;
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        return this.f81876b.d(tVar, l0Var);
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f81876b.f(uVar);
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f81876b.seek(j11, j12);
    }
}
