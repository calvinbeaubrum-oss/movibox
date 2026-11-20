package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Objects;
import p4.g0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends androidx.media3.exoplayer.source.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f11178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f11179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b0 f11180j;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f11181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f11182b;

        public b(long j11, e eVar) {
            this.f11181a = j11;
            this.f11182b = eVar;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        public /* synthetic */ l.a a(o5.s.a aVar) {
            return p4.q.c(this, aVar);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        public /* synthetic */ l.a b(boolean z11) {
            return p4.q.a(this, z11);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        public l.a d(i4.u uVar) {
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        public l.a e(androidx.media3.exoplayer.upstream.m mVar) {
            return this;
        }

        @Override // androidx.media3.exoplayer.source.l.a
        public /* synthetic */ l.a f(androidx.media3.exoplayer.upstream.f.a aVar) {
            return p4.q.b(this, aVar);
        }

        @Override // androidx.media3.exoplayer.source.l.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public g c(b0 b0Var) {
            return new g(b0Var, this.f11181a, this.f11182b);
        }
    }

    public g(b0 b0Var, long j11, e eVar) {
        this.f11180j = b0Var;
        this.f11179i = j11;
        this.f11178h = eVar;
    }

    @Override // androidx.media3.exoplayer.source.a
    public void B() {
    }

    @Override // androidx.media3.exoplayer.source.l
    public synchronized b0 a() {
        return this.f11180j;
    }

    @Override // androidx.media3.exoplayer.source.l
    public k h(l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        b0 b0VarA = a();
        z3.a.e(b0VarA.f8951b);
        z3.a.f(b0VarA.f8951b.f9048b, "Externally loaded mediaItems require a MIME type.");
        b0.h hVar = b0VarA.f8951b;
        return new f(hVar.f9047a, hVar.f9048b, this.f11178h);
    }

    @Override // androidx.media3.exoplayer.source.l
    public void l(k kVar) {
        ((f) kVar).i();
    }

    @Override // androidx.media3.exoplayer.source.l
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public synchronized void n(b0 b0Var) {
        this.f11180j = b0Var;
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public boolean q(b0 b0Var) {
        b0.h hVar = b0Var.f8951b;
        b0.h hVar2 = (b0.h) z3.a.e(a().f8951b);
        if (hVar != null && hVar.f9047a.equals(hVar2.f9047a) && Objects.equals(hVar.f9048b, hVar2.f9048b)) {
            long j11 = hVar.f9055i;
            if (j11 == C.TIME_UNSET || u0.S0(j11) == this.f11179i) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.a
    public void z(@Nullable c4.o oVar) {
        A(new g0(this.f11179i, true, false, false, null, a()));
    }
}
