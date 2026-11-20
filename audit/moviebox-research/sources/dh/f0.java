package dh;

import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f63115a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f63118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f63119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f63120f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.k0 f63116b = new com.google.android.exoplayer2.util.k0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f63121g = C.TIME_UNSET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f63122h = C.TIME_UNSET;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f63123i = C.TIME_UNSET;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63117c = new com.google.android.exoplayer2.util.c0();

    public f0(int i11) {
        this.f63115a = i11;
    }

    public final int a(tg.m mVar) {
        this.f63117c.M(o0.f35613f);
        this.f63118d = true;
        mVar.resetPeekPosition();
        return 0;
    }

    public long b() {
        return this.f63123i;
    }

    public com.google.android.exoplayer2.util.k0 c() {
        return this.f63116b;
    }

    public boolean d() {
        return this.f63118d;
    }

    public int e(tg.m mVar, tg.a0 a0Var, int i11) throws IOException {
        if (i11 <= 0) {
            return a(mVar);
        }
        if (!this.f63120f) {
            return h(mVar, a0Var, i11);
        }
        if (this.f63122h == C.TIME_UNSET) {
            return a(mVar);
        }
        if (!this.f63119e) {
            return f(mVar, a0Var, i11);
        }
        long j11 = this.f63121g;
        if (j11 == C.TIME_UNSET) {
            return a(mVar);
        }
        long jB = this.f63116b.b(this.f63122h) - this.f63116b.b(j11);
        this.f63123i = jB;
        if (jB < 0) {
            com.google.android.exoplayer2.util.s.i("TsDurationReader", "Invalid duration: " + this.f63123i + ". Using TIME_UNSET instead.");
            this.f63123i = C.TIME_UNSET;
        }
        return a(mVar);
    }

    public final int f(tg.m mVar, tg.a0 a0Var, int i11) throws IOException {
        int iMin = (int) Math.min(this.f63115a, mVar.getLength());
        long j11 = 0;
        if (mVar.getPosition() != j11) {
            a0Var.f76990a = j11;
            return 1;
        }
        this.f63117c.L(iMin);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f63117c.d(), 0, iMin);
        this.f63121g = g(this.f63117c, i11);
        this.f63119e = true;
        return 0;
    }

    public final long g(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
        int iF = c0Var.f();
        for (int iE = c0Var.e(); iE < iF; iE++) {
            if (c0Var.d()[iE] == 71) {
                long jC = j0.c(c0Var, iE, i11);
                if (jC != C.TIME_UNSET) {
                    return jC;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public final int h(tg.m mVar, tg.a0 a0Var, int i11) throws IOException {
        long length = mVar.getLength();
        int iMin = (int) Math.min(this.f63115a, length);
        long j11 = length - ((long) iMin);
        if (mVar.getPosition() != j11) {
            a0Var.f76990a = j11;
            return 1;
        }
        this.f63117c.L(iMin);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f63117c.d(), 0, iMin);
        this.f63122h = i(this.f63117c, i11);
        this.f63120f = true;
        return 0;
    }

    public final long i(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
        int iE = c0Var.e();
        int iF = c0Var.f();
        for (int i12 = iF - 188; i12 >= iE; i12--) {
            if (j0.b(c0Var.d(), iE, iF, i12)) {
                long jC = j0.c(c0Var, i12, i11);
                if (jC != C.TIME_UNSET) {
                    return jC;
                }
            }
        }
        return C.TIME_UNSET;
    }
}
