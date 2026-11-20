package x5;

import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import u4.l0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f80262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f80263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f80264e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.i0 f80260a = new z3.i0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f80265f = C.TIME_UNSET;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f80266g = C.TIME_UNSET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f80267h = C.TIME_UNSET;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z3.c0 f80261b = new z3.c0();

    public static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public static long l(z3.c0 c0Var) {
        int iF = c0Var.f();
        if (c0Var.a() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        c0Var.l(bArr, 0, 9);
        c0Var.U(iF);
        return !a(bArr) ? C.TIME_UNSET : m(bArr);
    }

    public static long m(byte[] bArr) {
        byte b11 = bArr[0];
        long j11 = (((((long) b11) & 56) >> 3) << 30) | ((((long) b11) & 3) << 28) | ((((long) bArr[1]) & 255) << 20);
        byte b12 = bArr[2];
        return j11 | (((((long) b12) & 248) >> 3) << 15) | ((((long) b12) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public final int b(u4.t tVar) {
        this.f80261b.R(u0.f81843f);
        this.f80262c = true;
        tVar.resetPeekPosition();
        return 0;
    }

    public long c() {
        return this.f80267h;
    }

    public z3.i0 d() {
        return this.f80260a;
    }

    public boolean e() {
        return this.f80262c;
    }

    public final int f(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    public int g(u4.t tVar, l0 l0Var) throws IOException {
        if (!this.f80264e) {
            return j(tVar, l0Var);
        }
        if (this.f80266g == C.TIME_UNSET) {
            return b(tVar);
        }
        if (!this.f80263d) {
            return h(tVar, l0Var);
        }
        long j11 = this.f80265f;
        if (j11 == C.TIME_UNSET) {
            return b(tVar);
        }
        this.f80267h = this.f80260a.c(this.f80266g) - this.f80260a.b(j11);
        return b(tVar);
    }

    public final int h(u4.t tVar, l0 l0Var) throws IOException {
        int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, tVar.getLength());
        long j11 = 0;
        if (tVar.getPosition() != j11) {
            l0Var.f78322a = j11;
            return 1;
        }
        this.f80261b.Q(iMin);
        tVar.resetPeekPosition();
        tVar.peekFully(this.f80261b.e(), 0, iMin);
        this.f80265f = i(this.f80261b);
        this.f80263d = true;
        return 0;
    }

    public final long i(z3.c0 c0Var) {
        int iG = c0Var.g();
        for (int iF = c0Var.f(); iF < iG - 3; iF++) {
            if (f(c0Var.e(), iF) == 442) {
                c0Var.U(iF + 4);
                long jL = l(c0Var);
                if (jL != C.TIME_UNSET) {
                    return jL;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public final int j(u4.t tVar, l0 l0Var) throws IOException {
        long length = tVar.getLength();
        int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, length);
        long j11 = length - ((long) iMin);
        if (tVar.getPosition() != j11) {
            l0Var.f78322a = j11;
            return 1;
        }
        this.f80261b.Q(iMin);
        tVar.resetPeekPosition();
        tVar.peekFully(this.f80261b.e(), 0, iMin);
        this.f80266g = k(this.f80261b);
        this.f80264e = true;
        return 0;
    }

    public final long k(z3.c0 c0Var) {
        int iF = c0Var.f();
        for (int iG = c0Var.g() - 4; iG >= iF; iG--) {
            if (f(c0Var.e(), iG) == 442) {
                c0Var.U(iG + 4);
                long jL = l(c0Var);
                if (jL != C.TIME_UNSET) {
                    return jL;
                }
            }
        }
        return C.TIME_UNSET;
    }
}
