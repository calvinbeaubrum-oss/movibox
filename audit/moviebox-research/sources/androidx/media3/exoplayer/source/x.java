package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.common.m0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x extends c<Void> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Void f11377l = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l f11378k;

    public x(l lVar) {
        this.f11378k = lVar;
    }

    @Nullable
    public l.b J(l.b bVar) {
        return bVar;
    }

    @Override // androidx.media3.exoplayer.source.c
    @Nullable
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final l.b D(Void r11, l.b bVar) {
        return J(bVar);
    }

    public long L(long j11, @Nullable l.b bVar) {
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.c
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public final long E(Void r11, long j11, @Nullable l.b bVar) {
        return L(j11, bVar);
    }

    public int N(int i11) {
        return i11;
    }

    @Override // androidx.media3.exoplayer.source.c
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public final int F(Void r11, int i11) {
        return N(i11);
    }

    public abstract void P(m0 m0Var);

    @Override // androidx.media3.exoplayer.source.c
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final void G(Void r11, l lVar, m0 m0Var) {
        P(m0Var);
    }

    public final void R() {
        I(f11377l, this.f11378k);
    }

    public void S() {
        R();
    }

    @Override // androidx.media3.exoplayer.source.l
    public b0 a() {
        return this.f11378k.a();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public boolean c() {
        return this.f11378k.c();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    @Nullable
    public m0 d() {
        return this.f11378k.d();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public void n(b0 b0Var) {
        this.f11378k.n(b0Var);
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public final void z(@Nullable c4.o oVar) {
        super.z(oVar);
        S();
    }
}
