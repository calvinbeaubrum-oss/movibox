package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.w1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import p4.e0;
import p4.k0;
import s4.z;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements k, k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l.b f11188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.b f11190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f11191d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f11192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public k.a f11193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public a f11194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f11196j = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(l.b bVar, IOException iOException);

        void b(l.b bVar);
    }

    public i(l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        this.f11188a = bVar;
        this.f11190c = bVar2;
        this.f11189b = j11;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        k kVar = this.f11192f;
        return kVar != null && kVar.a(w1Var);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long b(long j11, b3 b3Var) {
        return ((k) u0.i(this.f11192f)).b(j11, b3Var);
    }

    public void c(l.b bVar) {
        long jK = k(this.f11189b);
        k kVarH = ((l) z3.a.e(this.f11191d)).h(bVar, this.f11190c, jK);
        this.f11192f = kVarH;
        if (this.f11193g != null) {
            kVarH.g(this, jK);
        }
    }

    @Override // androidx.media3.exoplayer.source.k
    public void discardBuffer(long j11, boolean z11) {
        ((k) u0.i(this.f11192f)).discardBuffer(j11, z11);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long e(z[] zVarArr, boolean[] zArr, e0[] e0VarArr, boolean[] zArr2, long j11) {
        long j12 = this.f11196j;
        long j13 = (j12 == C.TIME_UNSET || j11 != this.f11189b) ? j11 : j12;
        this.f11196j = C.TIME_UNSET;
        return ((k) u0.i(this.f11192f)).e(zVarArr, zArr, e0VarArr, zArr2, j13);
    }

    @Override // androidx.media3.exoplayer.source.k.a
    public void f(k kVar) {
        ((k.a) u0.i(this.f11193g)).f(this);
        a aVar = this.f11194h;
        if (aVar != null) {
            aVar.b(this.f11188a);
        }
    }

    @Override // androidx.media3.exoplayer.source.k
    public void g(k.a aVar, long j11) {
        this.f11193g = aVar;
        k kVar = this.f11192f;
        if (kVar != null) {
            kVar.g(this, k(this.f11189b));
        }
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        return ((k) u0.i(this.f11192f)).getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        return ((k) u0.i(this.f11192f)).getNextLoadPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.k
    public k0 getTrackGroups() {
        return ((k) u0.i(this.f11192f)).getTrackGroups();
    }

    public long i() {
        return this.f11196j;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        k kVar = this.f11192f;
        return kVar != null && kVar.isLoading();
    }

    public long j() {
        return this.f11189b;
    }

    public final long k(long j11) {
        long j12 = this.f11196j;
        return j12 != C.TIME_UNSET ? j12 : j11;
    }

    @Override // androidx.media3.exoplayer.source.t.a
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void h(k kVar) {
        ((k.a) u0.i(this.f11193g)).h(this);
    }

    public void m(long j11) {
        this.f11196j = j11;
    }

    @Override // androidx.media3.exoplayer.source.k
    public void maybeThrowPrepareError() throws IOException {
        try {
            k kVar = this.f11192f;
            if (kVar != null) {
                kVar.maybeThrowPrepareError();
            } else {
                l lVar = this.f11191d;
                if (lVar != null) {
                    lVar.maybeThrowSourceInfoRefreshError();
                }
            }
        } catch (IOException e11) {
            a aVar = this.f11194h;
            if (aVar == null) {
                throw e11;
            }
            if (this.f11195i) {
                return;
            }
            this.f11195i = true;
            aVar.a(this.f11188a, e11);
        }
    }

    public void n() {
        if (this.f11192f != null) {
            ((l) z3.a.e(this.f11191d)).l(this.f11192f);
        }
    }

    public void o(l lVar) {
        z3.a.g(this.f11191d == null);
        this.f11191d = lVar;
    }

    @Override // androidx.media3.exoplayer.source.k
    public long readDiscontinuity() {
        return ((k) u0.i(this.f11192f)).readDiscontinuity();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
        ((k) u0.i(this.f11192f)).reevaluateBuffer(j11);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long seekToUs(long j11) {
        return ((k) u0.i(this.f11192f)).seekToUs(j11);
    }
}
