package x5;

import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends u4.e {

    /* JADX INFO: compiled from: source.java */
    public static final class b implements u4.e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z3.i0 f80258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z3.c0 f80259b;

        public b(z3.i0 i0Var) {
            this.f80258a = i0Var;
            this.f80259b = new z3.c0();
        }

        public static void d(z3.c0 c0Var) {
            int iK;
            int iG = c0Var.g();
            if (c0Var.a() < 10) {
                c0Var.U(iG);
                return;
            }
            c0Var.V(9);
            int iH = c0Var.H() & 7;
            if (c0Var.a() < iH) {
                c0Var.U(iG);
                return;
            }
            c0Var.V(iH);
            if (c0Var.a() < 4) {
                c0Var.U(iG);
                return;
            }
            if (x.k(c0Var.e(), c0Var.f()) == 443) {
                c0Var.V(4);
                int iN = c0Var.N();
                if (c0Var.a() < iN) {
                    c0Var.U(iG);
                    return;
                }
                c0Var.V(iN);
            }
            while (c0Var.a() >= 4 && (iK = x.k(c0Var.e(), c0Var.f())) != 442 && iK != 441 && (iK >>> 8) == 1) {
                c0Var.V(4);
                if (c0Var.a() < 2) {
                    c0Var.U(iG);
                    return;
                }
                c0Var.U(Math.min(c0Var.g(), c0Var.f() + c0Var.N()));
            }
        }

        @Override // u4.e.f
        public void a() {
            this.f80259b.R(u0.f81843f);
        }

        @Override // u4.e.f
        public u4.e.C0862e b(u4.t tVar, long j11) throws IOException {
            long position = tVar.getPosition();
            int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, tVar.getLength() - position);
            this.f80259b.Q(iMin);
            tVar.peekFully(this.f80259b.e(), 0, iMin);
            return c(this.f80259b, j11, position);
        }

        public final u4.e.C0862e c(z3.c0 c0Var, long j11, long j12) {
            int iF = -1;
            long j13 = -9223372036854775807L;
            int iF2 = -1;
            while (c0Var.a() >= 4) {
                if (x.k(c0Var.e(), c0Var.f()) != 442) {
                    c0Var.V(1);
                } else {
                    c0Var.V(4);
                    long jL = y.l(c0Var);
                    if (jL != C.TIME_UNSET) {
                        long jB = this.f80258a.b(jL);
                        if (jB > j11) {
                            return j13 == C.TIME_UNSET ? u4.e.C0862e.d(jB, j12) : u4.e.C0862e.e(j12 + ((long) iF2));
                        }
                        if (100000 + jB > j11) {
                            return u4.e.C0862e.e(j12 + ((long) c0Var.f()));
                        }
                        iF2 = c0Var.f();
                        j13 = jB;
                    }
                    d(c0Var);
                    iF = c0Var.f();
                }
            }
            return j13 != C.TIME_UNSET ? u4.e.C0862e.f(j13, j12 + ((long) iF)) : u4.e.C0862e.f78264d;
        }
    }

    public x(z3.i0 i0Var, long j11, long j12) {
        super(new u4.e.b(), new b(i0Var), j11, 0L, j11 + 1, 0L, j12, 188L, 1000);
    }

    public static int k(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }
}
