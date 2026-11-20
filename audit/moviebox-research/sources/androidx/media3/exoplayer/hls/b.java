package androidx.media3.exoplayer.hls;

import androidx.media3.common.y;
import java.io.IOException;
import u4.l0;
import u4.t;
import u4.u;
import x5.h0;
import z3.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l0 f10369f = new l0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4.s f10370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f10371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i0 f10372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o5.s.a f10373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10374e;

    public b(u4.s sVar, y yVar, i0 i0Var, o5.s.a aVar, boolean z11) {
        this.f10370a = sVar;
        this.f10371b = yVar;
        this.f10372c = i0Var;
        this.f10373d = aVar;
        this.f10374e = z11;
    }

    @Override // androidx.media3.exoplayer.hls.j
    public boolean a(t tVar) throws IOException {
        return this.f10370a.d(tVar, f10369f) == 0;
    }

    @Override // androidx.media3.exoplayer.hls.j
    public void b() {
        this.f10370a.seek(0L, 0L);
    }

    @Override // androidx.media3.exoplayer.hls.j
    public boolean c() {
        u4.s sVarC = this.f10370a.c();
        return (sVarC instanceof h0) || (sVarC instanceof l5.g);
    }

    @Override // androidx.media3.exoplayer.hls.j
    public boolean e() {
        u4.s sVarC = this.f10370a.c();
        return (sVarC instanceof x5.h) || (sVarC instanceof x5.b) || (sVarC instanceof x5.e) || (sVarC instanceof k5.f);
    }

    @Override // androidx.media3.exoplayer.hls.j
    public void f(u uVar) {
        this.f10370a.f(uVar);
    }

    @Override // androidx.media3.exoplayer.hls.j
    public j g() {
        u4.s fVar;
        z3.a.g(!c());
        z3.a.h(this.f10370a.c() == this.f10370a, "Can't recreate wrapped extractors. Outer type: " + this.f10370a.getClass());
        u4.s sVar = this.f10370a;
        if (sVar instanceof s) {
            fVar = new s(this.f10371b.f9492d, this.f10372c, this.f10373d, this.f10374e);
        } else if (sVar instanceof x5.h) {
            fVar = new x5.h();
        } else if (sVar instanceof x5.b) {
            fVar = new x5.b();
        } else if (sVar instanceof x5.e) {
            fVar = new x5.e();
        } else {
            if (!(sVar instanceof k5.f)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f10370a.getClass().getSimpleName());
            }
            fVar = new k5.f();
        }
        return new b(fVar, this.f10371b, this.f10372c, this.f10373d, this.f10374e);
    }
}
