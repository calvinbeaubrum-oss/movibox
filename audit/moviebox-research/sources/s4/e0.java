package s4;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.m0;
import androidx.media3.common.p0;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.w2;
import androidx.media3.exoplayer.y2;
import p4.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public a f76006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public androidx.media3.exoplayer.upstream.e f76007b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b(w2 w2Var);

        void onTrackSelectionsInvalidated();
    }

    public final androidx.media3.exoplayer.upstream.e a() {
        return (androidx.media3.exoplayer.upstream.e) z3.a.i(this.f76007b);
    }

    public p0 c() {
        return p0.C;
    }

    @Nullable
    public y2.a d() {
        return null;
    }

    @CallSuper
    public void e(a aVar, androidx.media3.exoplayer.upstream.e eVar) {
        this.f76006a = aVar;
        this.f76007b = eVar;
    }

    public final void f() {
        a aVar = this.f76006a;
        if (aVar != null) {
            aVar.onTrackSelectionsInvalidated();
        }
    }

    public final void g(w2 w2Var) {
        a aVar = this.f76006a;
        if (aVar != null) {
            aVar.b(w2Var);
        }
    }

    public boolean h() {
        return false;
    }

    public abstract void i(@Nullable Object obj);

    @CallSuper
    public void j() {
        this.f76006a = null;
        this.f76007b = null;
    }

    public abstract f0 k(y2[] y2VarArr, k0 k0Var, androidx.media3.exoplayer.source.l.b bVar, m0 m0Var) throws ExoPlaybackException;

    public void l(androidx.media3.common.d dVar) {
    }

    public void m(p0 p0Var) {
    }
}
