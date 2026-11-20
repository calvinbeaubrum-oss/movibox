package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class u5 implements t4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f23521b = C.TIME_UNSET;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f23520a = C.TIME_UNSET;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23522c = false;

    private static void a(qh qhVar, long j11) {
        long currentPosition = qhVar.getCurrentPosition() + j11;
        long duration = qhVar.getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        qhVar.a(Math.max(currentPosition, 0L));
    }

    @Override // com.applovin.impl.t4
    public boolean a() {
        return !this.f23522c || this.f23521b > 0;
    }

    @Override // com.applovin.impl.t4
    public boolean a(qh qhVar) {
        qhVar.u();
        return true;
    }

    @Override // com.applovin.impl.t4
    public boolean a(qh qhVar, int i11) {
        qhVar.a(i11);
        return true;
    }

    @Override // com.applovin.impl.t4
    public boolean a(qh qhVar, int i11, long j11) {
        qhVar.a(i11, j11);
        return true;
    }

    @Override // com.applovin.impl.t4
    public boolean a(qh qhVar, boolean z11) {
        qhVar.b(z11);
        return true;
    }

    @Override // com.applovin.impl.t4
    public boolean b() {
        return !this.f23522c || this.f23520a > 0;
    }

    @Override // com.applovin.impl.t4
    public boolean b(qh qhVar) {
        qhVar.b();
        return true;
    }

    @Override // com.applovin.impl.t4
    public boolean b(qh qhVar, boolean z11) {
        qhVar.a(z11);
        return true;
    }

    @Override // com.applovin.impl.t4
    public boolean c(qh qhVar) {
        if (!this.f23522c) {
            qhVar.B();
            return true;
        }
        if (!b() || !qhVar.y()) {
            return true;
        }
        a(qhVar, -this.f23520a);
        return true;
    }

    @Override // com.applovin.impl.t4
    public boolean d(qh qhVar) {
        if (!this.f23522c) {
            qhVar.w();
            return true;
        }
        if (!a() || !qhVar.y()) {
            return true;
        }
        a(qhVar, this.f23521b);
        return true;
    }

    @Override // com.applovin.impl.t4
    public boolean e(qh qhVar) {
        qhVar.D();
        return true;
    }
}
