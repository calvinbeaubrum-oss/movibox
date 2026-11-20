package fi;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.y2;
import nh.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public a f64953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.e f64954b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onTrackSelectionsInvalidated();
    }

    public final com.google.android.exoplayer2.upstream.e a() {
        return (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.i(this.f64954b);
    }

    public z b() {
        return z.B;
    }

    @CallSuper
    public void c(a aVar, com.google.android.exoplayer2.upstream.e eVar) {
        this.f64953a = aVar;
        this.f64954b = eVar;
    }

    public final void d() {
        a aVar = this.f64953a;
        if (aVar != null) {
            aVar.onTrackSelectionsInvalidated();
        }
    }

    public boolean e() {
        return false;
    }

    public abstract void f(@Nullable Object obj);

    @CallSuper
    public void g() {
        this.f64953a = null;
        this.f64954b = null;
    }

    public abstract c0 h(y2[] y2VarArr, k0 k0Var, com.google.android.exoplayer2.source.i.b bVar, j3 j3Var) throws ExoPlaybackException;

    public void i(com.google.android.exoplayer2.audio.e eVar) {
    }

    public void j(z zVar) {
    }
}
