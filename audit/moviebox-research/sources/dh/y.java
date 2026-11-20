package dh;

import com.google.android.exoplayer2.util.o0;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f63406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f63407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f63408e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.k0 f63404a = new com.google.android.exoplayer2.util.k0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f63409f = C.TIME_UNSET;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f63410g = C.TIME_UNSET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f63411h = C.TIME_UNSET;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63405b = new com.google.android.exoplayer2.util.c0();

    public static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public static long l(com.google.android.exoplayer2.util.c0 c0Var) {
        int iE = c0Var.e();
        if (c0Var.a() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        c0Var.j(bArr, 0, 9);
        c0Var.P(iE);
        return !a(bArr) ? C.TIME_UNSET : m(bArr);
    }

    public static long m(byte[] bArr) {
        byte b11 = bArr[0];
        long j11 = (((((long) b11) & 56) >> 3) << 30) | ((((long) b11) & 3) << 28) | ((((long) bArr[1]) & 255) << 20);
        byte b12 = bArr[2];
        return j11 | (((((long) b12) & 248) >> 3) << 15) | ((((long) b12) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public final int b(tg.m mVar) {
        this.f63405b.M(o0.f35613f);
        this.f63406c = true;
        mVar.resetPeekPosition();
        return 0;
    }

    public long c() {
        return this.f63411h;
    }

    public com.google.android.exoplayer2.util.k0 d() {
        return this.f63404a;
    }

    public boolean e() {
        return this.f63406c;
    }

    public final int f(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    public int g(tg.m mVar, tg.a0 a0Var) throws IOException {
        if (!this.f63408e) {
            return j(mVar, a0Var);
        }
        if (this.f63410g == C.TIME_UNSET) {
            return b(mVar);
        }
        if (!this.f63407d) {
            return h(mVar, a0Var);
        }
        long j11 = this.f63409f;
        if (j11 == C.TIME_UNSET) {
            return b(mVar);
        }
        long jB = this.f63404a.b(this.f63410g) - this.f63404a.b(j11);
        this.f63411h = jB;
        if (jB < 0) {
            com.google.android.exoplayer2.util.s.i("PsDurationReader", "Invalid duration: " + this.f63411h + ". Using TIME_UNSET instead.");
            this.f63411h = C.TIME_UNSET;
        }
        return b(mVar);
    }

    public final int h(tg.m mVar, tg.a0 a0Var) throws IOException {
        int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, mVar.getLength());
        long j11 = 0;
        if (mVar.getPosition() != j11) {
            a0Var.f76990a = j11;
            return 1;
        }
        this.f63405b.L(iMin);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f63405b.d(), 0, iMin);
        this.f63409f = i(this.f63405b);
        this.f63407d = true;
        return 0;
    }

    public final long i(com.google.android.exoplayer2.util.c0 c0Var) {
        int iF = c0Var.f();
        for (int iE = c0Var.e(); iE < iF - 3; iE++) {
            if (f(c0Var.d(), iE) == 442) {
                c0Var.P(iE + 4);
                long jL = l(c0Var);
                if (jL != C.TIME_UNSET) {
                    return jL;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public final int j(tg.m mVar, tg.a0 a0Var) throws IOException {
        long length = mVar.getLength();
        int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, length);
        long j11 = length - ((long) iMin);
        if (mVar.getPosition() != j11) {
            a0Var.f76990a = j11;
            return 1;
        }
        this.f63405b.L(iMin);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f63405b.d(), 0, iMin);
        this.f63410g = k(this.f63405b);
        this.f63408e = true;
        return 0;
    }

    public final long k(com.google.android.exoplayer2.util.c0 c0Var) {
        int iE = c0Var.e();
        for (int iF = c0Var.f() - 4; iF >= iE; iF--) {
            if (f(c0Var.d(), iF) == 442) {
                c0Var.P(iF + 4);
                long jL = l(c0Var);
                if (jL != C.TIME_UNSET) {
                    return jL;
                }
            }
        }
        return C.TIME_UNSET;
    }
}
