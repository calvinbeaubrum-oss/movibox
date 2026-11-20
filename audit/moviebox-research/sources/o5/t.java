package o5;

import java.io.IOException;
import u4.l0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class t implements u4.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4.s f72356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s.a f72357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f72358c;

    public t(u4.s sVar, s.a aVar) {
        this.f72356a = sVar;
        this.f72357b = aVar;
    }

    @Override // u4.s
    public boolean b(u4.t tVar) throws IOException {
        return this.f72356a.b(tVar);
    }

    @Override // u4.s
    public u4.s c() {
        return this.f72356a;
    }

    @Override // u4.s
    public int d(u4.t tVar, l0 l0Var) throws IOException {
        return this.f72356a.d(tVar, l0Var);
    }

    @Override // u4.s
    public void f(u4.u uVar) {
        u uVar2 = new u(uVar, this.f72357b);
        this.f72358c = uVar2;
        this.f72356a.f(uVar2);
    }

    @Override // u4.s
    public void release() {
        this.f72356a.release();
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        u uVar = this.f72358c;
        if (uVar != null) {
            uVar.a();
        }
        this.f72356a.seek(j11, j12);
    }
}
