package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements Loader.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f34464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f34465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f34466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final tg.n f34467d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c.a f34469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f34470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f34471h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f34473j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f34468e = o0.w();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f34472i = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(String str, c cVar);
    }

    public e(int i11, t tVar, a aVar, tg.n nVar, c.a aVar2) {
        this.f34464a = i11;
        this.f34465b = tVar;
        this.f34466c = aVar;
        this.f34467d = nVar;
        this.f34469f = aVar2;
    }

    public final /* synthetic */ void b(String str, c cVar) {
        this.f34466c.a(str, cVar);
    }

    public void c() {
        ((f) com.google.android.exoplayer2.util.a.e(this.f34470g)).f();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void cancelLoad() {
        this.f34471h = true;
    }

    public void d(long j11, long j12) {
        this.f34472i = j11;
        this.f34473j = j12;
    }

    public void e(int i11) {
        if (((f) com.google.android.exoplayer2.util.a.e(this.f34470g)).e()) {
            return;
        }
        this.f34470g.g(i11);
    }

    public void f(long j11) {
        if (j11 == C.TIME_UNSET || ((f) com.google.android.exoplayer2.util.a.e(this.f34470g)).e()) {
            return;
        }
        this.f34470g.h(j11);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void load() throws IOException {
        final c cVarA = null;
        try {
            cVarA = this.f34469f.a(this.f34464a);
            final String strC = cVarA.c();
            this.f34468e.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f34457a.b(strC, cVarA);
                }
            });
            tg.f fVar = new tg.f((com.google.android.exoplayer2.upstream.g) com.google.android.exoplayer2.util.a.e(cVarA), 0L, -1L);
            f fVar2 = new f(this.f34465b.f34607a, this.f34464a);
            this.f34470g = fVar2;
            fVar2.d(this.f34467d);
            while (!this.f34471h) {
                if (this.f34472i != C.TIME_UNSET) {
                    this.f34470g.seek(this.f34473j, this.f34472i);
                    this.f34472i = C.TIME_UNSET;
                }
                if (this.f34470g.c(fVar, new tg.a0()) == -1) {
                }
            }
        } finally {
            com.google.android.exoplayer2.upstream.m.a(cVarA);
        }
    }
}
