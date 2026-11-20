package androidx.media3.exoplayer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c3 implements y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.d f10081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10084d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.media3.common.g0 f10085f = androidx.media3.common.g0.f9218d;

    public c3(z3.d dVar) {
        this.f10081a = dVar;
    }

    public void a(long j11) {
        this.f10083c = j11;
        if (this.f10082b) {
            this.f10084d = this.f10081a.elapsedRealtime();
        }
    }

    @Override // androidx.media3.exoplayer.y1
    public void b(androidx.media3.common.g0 g0Var) {
        if (this.f10082b) {
            a(getPositionUs());
        }
        this.f10085f = g0Var;
    }

    public void c() {
        if (this.f10082b) {
            return;
        }
        this.f10084d = this.f10081a.elapsedRealtime();
        this.f10082b = true;
    }

    public void d() {
        if (this.f10082b) {
            a(getPositionUs());
            this.f10082b = false;
        }
    }

    @Override // androidx.media3.exoplayer.y1
    public androidx.media3.common.g0 getPlaybackParameters() {
        return this.f10085f;
    }

    @Override // androidx.media3.exoplayer.y1
    public long getPositionUs() {
        long j11 = this.f10083c;
        if (!this.f10082b) {
            return j11;
        }
        long jElapsedRealtime = this.f10081a.elapsedRealtime() - this.f10084d;
        androidx.media3.common.g0 g0Var = this.f10085f;
        return j11 + (g0Var.f9222a == 1.0f ? z3.u0.S0(jElapsedRealtime) : g0Var.a(jElapsedRealtime));
    }

    @Override // androidx.media3.exoplayer.y1
    public /* synthetic */ boolean h() {
        return x1.a(this);
    }
}
