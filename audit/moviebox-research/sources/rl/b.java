package rl;

import com.google.firebase.perf.v1.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f75614a;

    public b(f fVar) {
        this.f75614a = fVar;
    }

    @Override // rl.e
    public boolean c() {
        return this.f75614a.e0() && (this.f75614a.a0() > 0 || this.f75614a.Z() > 0 || (this.f75614a.d0() && this.f75614a.c0().V()));
    }
}
