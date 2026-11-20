package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.m2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g0 implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f35569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f35570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f35571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f35572d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m2 f35573f = m2.f33485d;

    public g0(e eVar) {
        this.f35569a = eVar;
    }

    public void a(long j11) {
        this.f35571c = j11;
        if (this.f35570b) {
            this.f35572d = this.f35569a.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.u
    public void b(m2 m2Var) {
        if (this.f35570b) {
            a(getPositionUs());
        }
        this.f35573f = m2Var;
    }

    public void c() {
        if (this.f35570b) {
            return;
        }
        this.f35572d = this.f35569a.elapsedRealtime();
        this.f35570b = true;
    }

    public void d() {
        if (this.f35570b) {
            a(getPositionUs());
            this.f35570b = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.u
    public m2 getPlaybackParameters() {
        return this.f35573f;
    }

    @Override // com.google.android.exoplayer2.util.u
    public long getPositionUs() {
        long j11 = this.f35571c;
        if (!this.f35570b) {
            return j11;
        }
        long jElapsedRealtime = this.f35569a.elapsedRealtime() - this.f35572d;
        m2 m2Var = this.f35573f;
        return j11 + (m2Var.f33487a == 1.0f ? o0.C0(jElapsedRealtime) : m2Var.b(jElapsedRealtime));
    }
}
