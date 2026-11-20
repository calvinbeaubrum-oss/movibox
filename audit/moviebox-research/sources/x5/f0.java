package x5;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import u4.l0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79959a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f79962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f79963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f79964f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z3.i0 f79960b = new z3.i0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f79965g = C.TIME_UNSET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f79966h = C.TIME_UNSET;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f79967i = C.TIME_UNSET;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z3.c0 f79961c = new z3.c0();

    public f0(int i11) {
        this.f79959a = i11;
    }

    public final int a(u4.t tVar) {
        this.f79961c.R(u0.f81843f);
        this.f79962d = true;
        tVar.resetPeekPosition();
        return 0;
    }

    public long b() {
        return this.f79967i;
    }

    public z3.i0 c() {
        return this.f79960b;
    }

    public boolean d() {
        return this.f79962d;
    }

    public int e(u4.t tVar, l0 l0Var, int i11) throws IOException {
        if (i11 <= 0) {
            return a(tVar);
        }
        if (!this.f79964f) {
            return h(tVar, l0Var, i11);
        }
        if (this.f79966h == C.TIME_UNSET) {
            return a(tVar);
        }
        if (!this.f79963e) {
            return f(tVar, l0Var, i11);
        }
        long j11 = this.f79965g;
        if (j11 == C.TIME_UNSET) {
            return a(tVar);
        }
        this.f79967i = this.f79960b.c(this.f79966h) - this.f79960b.b(j11);
        return a(tVar);
    }

    public final int f(u4.t tVar, l0 l0Var, int i11) throws IOException {
        int iMin = (int) Math.min(this.f79959a, tVar.getLength());
        long j11 = 0;
        if (tVar.getPosition() != j11) {
            l0Var.f78322a = j11;
            return 1;
        }
        this.f79961c.Q(iMin);
        tVar.resetPeekPosition();
        tVar.peekFully(this.f79961c.e(), 0, iMin);
        this.f79965g = g(this.f79961c, i11);
        this.f79963e = true;
        return 0;
    }

    public final long g(z3.c0 c0Var, int i11) {
        int iG = c0Var.g();
        for (int iF = c0Var.f(); iF < iG; iF++) {
            if (c0Var.e()[iF] == 71) {
                long jC = j0.c(c0Var, iF, i11);
                if (jC != C.TIME_UNSET) {
                    return jC;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public final int h(u4.t tVar, l0 l0Var, int i11) throws IOException {
        long length = tVar.getLength();
        int iMin = (int) Math.min(this.f79959a, length);
        long j11 = length - ((long) iMin);
        if (tVar.getPosition() != j11) {
            l0Var.f78322a = j11;
            return 1;
        }
        this.f79961c.Q(iMin);
        tVar.resetPeekPosition();
        tVar.peekFully(this.f79961c.e(), 0, iMin);
        this.f79966h = i(this.f79961c, i11);
        this.f79964f = true;
        return 0;
    }

    public final long i(z3.c0 c0Var, int i11) {
        int iF = c0Var.f();
        int iG = c0Var.g();
        for (int i12 = iG - 188; i12 >= iF; i12--) {
            if (j0.b(c0Var.e(), iF, iG, i12)) {
                long jC = j0.c(c0Var, i12, i11);
                if (jC != C.TIME_UNSET) {
                    return jC;
                }
            }
        }
        return C.TIME_UNSET;
    }
}
