package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import nh.d0;
import nh.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements h, h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i.b f33928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f33929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f33930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f33931d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f33932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public h.a f33933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public a f33934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f33935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f33936j = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(i.b bVar);

        void b(i.b bVar, IOException iOException);
    }

    public f(i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        this.f33928a = bVar;
        this.f33930c = bVar2;
        this.f33929b = j11;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j11, b3 b3Var) {
        return ((h) o0.j(this.f33932f)).a(j11, b3Var);
    }

    public void b(i.b bVar) {
        long j11 = j(this.f33929b);
        h hVarE = ((i) com.google.android.exoplayer2.util.a.e(this.f33931d)).e(bVar, this.f33930c, j11);
        this.f33932f = hVarE;
        if (this.f33933g != null) {
            hVarE.f(this, j11);
        }
    }

    public long c() {
        return this.f33936j;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        h hVar = this.f33932f;
        return hVar != null && hVar.continueLoading(j11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j11, boolean z11) {
        ((h) o0.j(this.f33932f)).discardBuffer(j11, z11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long e(fi.s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11) {
        long j12;
        long j13 = this.f33936j;
        if (j13 == C.TIME_UNSET || j11 != this.f33929b) {
            j12 = j11;
        } else {
            this.f33936j = C.TIME_UNSET;
            j12 = j13;
        }
        return ((h) o0.j(this.f33932f)).e(sVarArr, zArr, d0VarArr, zArr2, j12);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void f(h.a aVar, long j11) {
        this.f33933g = aVar;
        h hVar = this.f33932f;
        if (hVar != null) {
            hVar.f(this, j(this.f33929b));
        }
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return ((h) o0.j(this.f33932f)).getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return ((h) o0.j(this.f33932f)).getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public k0 getTrackGroups() {
        return ((h) o0.j(this.f33932f)).getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.h.a
    public void h(h hVar) {
        ((h.a) o0.j(this.f33933g)).h(this);
        a aVar = this.f33934h;
        if (aVar != null) {
            aVar.a(this.f33928a);
        }
    }

    public long i() {
        return this.f33929b;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        h hVar = this.f33932f;
        return hVar != null && hVar.isLoading();
    }

    public final long j(long j11) {
        long j12 = this.f33936j;
        return j12 != C.TIME_UNSET ? j12 : j11;
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void g(h hVar) {
        ((h.a) o0.j(this.f33933g)).g(this);
    }

    public void l(long j11) {
        this.f33936j = j11;
    }

    public void m() {
        if (this.f33932f != null) {
            ((i) com.google.android.exoplayer2.util.a.e(this.f33931d)).k(this.f33932f);
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        try {
            h hVar = this.f33932f;
            if (hVar != null) {
                hVar.maybeThrowPrepareError();
            } else {
                i iVar = this.f33931d;
                if (iVar != null) {
                    iVar.maybeThrowSourceInfoRefreshError();
                }
            }
        } catch (IOException e11) {
            a aVar = this.f33934h;
            if (aVar == null) {
                throw e11;
            }
            if (this.f33935i) {
                return;
            }
            this.f33935i = true;
            aVar.b(this.f33928a, e11);
        }
    }

    public void n(i iVar) {
        com.google.android.exoplayer2.util.a.g(this.f33931d == null);
        this.f33931d = iVar;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        return ((h) o0.j(this.f33932f)).readDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
        ((h) o0.j(this.f33932f)).reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j11) {
        return ((h) o0.j(this.f33932f)).seekToUs(j11);
    }
}
