package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.k0;
import dh.h0;
import java.io.IOException;
import tg.a0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a0 f33980d = new a0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tg.l f33981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1 f33982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f33983c;

    public b(tg.l lVar, m1 m1Var, k0 k0Var) {
        this.f33981a = lVar;
        this.f33982b = m1Var;
        this.f33983c = k0Var;
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public boolean a(tg.m mVar) throws IOException {
        return this.f33981a.c(mVar, f33980d) == 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public void b() {
        this.f33981a.seek(0L, 0L);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public boolean c() {
        tg.l lVar = this.f33981a;
        return (lVar instanceof h0) || (lVar instanceof bh.g);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public void d(tg.n nVar) {
        this.f33981a.d(nVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public boolean e() {
        tg.l lVar = this.f33981a;
        return (lVar instanceof dh.h) || (lVar instanceof dh.b) || (lVar instanceof dh.e) || (lVar instanceof ah.f);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public j g() {
        tg.l fVar;
        com.google.android.exoplayer2.util.a.g(!c());
        tg.l lVar = this.f33981a;
        if (lVar instanceof r) {
            fVar = new r(this.f33982b.f33436c, this.f33983c);
        } else if (lVar instanceof dh.h) {
            fVar = new dh.h();
        } else if (lVar instanceof dh.b) {
            fVar = new dh.b();
        } else if (lVar instanceof dh.e) {
            fVar = new dh.e();
        } else {
            if (!(lVar instanceof ah.f)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f33981a.getClass().getSimpleName());
            }
            fVar = new ah.f();
        }
        return new b(fVar, this.f33982b, this.f33983c);
    }
}
