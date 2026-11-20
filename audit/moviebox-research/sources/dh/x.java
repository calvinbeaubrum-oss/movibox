package dh;

import com.google.android.exoplayer2.util.o0;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class x extends tg.a {

    /* JADX INFO: compiled from: source.java */
    public static final class b implements tg.a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.k0 f63402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.c0 f63403b;

        public b(com.google.android.exoplayer2.util.k0 k0Var) {
            this.f63402a = k0Var;
            this.f63403b = new com.google.android.exoplayer2.util.c0();
        }

        public static void d(com.google.android.exoplayer2.util.c0 c0Var) {
            int iK;
            int iF = c0Var.f();
            if (c0Var.a() < 10) {
                c0Var.P(iF);
                return;
            }
            c0Var.Q(9);
            int iD = c0Var.D() & 7;
            if (c0Var.a() < iD) {
                c0Var.P(iF);
                return;
            }
            c0Var.Q(iD);
            if (c0Var.a() < 4) {
                c0Var.P(iF);
                return;
            }
            if (x.k(c0Var.d(), c0Var.e()) == 443) {
                c0Var.Q(4);
                int iJ = c0Var.J();
                if (c0Var.a() < iJ) {
                    c0Var.P(iF);
                    return;
                }
                c0Var.Q(iJ);
            }
            while (c0Var.a() >= 4 && (iK = x.k(c0Var.d(), c0Var.e())) != 442 && iK != 441 && (iK >>> 8) == 1) {
                c0Var.Q(4);
                if (c0Var.a() < 2) {
                    c0Var.P(iF);
                    return;
                }
                c0Var.P(Math.min(c0Var.f(), c0Var.e() + c0Var.J()));
            }
        }

        @Override // tg.a.f
        public void a() {
            this.f63403b.M(o0.f35613f);
        }

        @Override // tg.a.f
        public tg.a.e b(tg.m mVar, long j11) throws IOException {
            long position = mVar.getPosition();
            int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, mVar.getLength() - position);
            this.f63403b.L(iMin);
            mVar.peekFully(this.f63403b.d(), 0, iMin);
            return c(this.f63403b, j11, position);
        }

        public final tg.a.e c(com.google.android.exoplayer2.util.c0 c0Var, long j11, long j12) {
            int iE = -1;
            long j13 = -9223372036854775807L;
            int iE2 = -1;
            while (c0Var.a() >= 4) {
                if (x.k(c0Var.d(), c0Var.e()) != 442) {
                    c0Var.Q(1);
                } else {
                    c0Var.Q(4);
                    long jL = y.l(c0Var);
                    if (jL != C.TIME_UNSET) {
                        long jB = this.f63402a.b(jL);
                        if (jB > j11) {
                            return j13 == C.TIME_UNSET ? tg.a.e.d(jB, j12) : tg.a.e.e(j12 + ((long) iE2));
                        }
                        if (100000 + jB > j11) {
                            return tg.a.e.e(j12 + ((long) c0Var.e()));
                        }
                        iE2 = c0Var.e();
                        j13 = jB;
                    }
                    d(c0Var);
                    iE = c0Var.e();
                }
            }
            return j13 != C.TIME_UNSET ? tg.a.e.f(j13, j12 + ((long) iE)) : tg.a.e.f76986d;
        }
    }

    public x(com.google.android.exoplayer2.util.k0 k0Var, long j11, long j12) {
        super(new tg.a.b(), new b(k0Var), j11, 0L, j11 + 1, 0L, j12, 188L, 1000);
    }

    public static int k(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }
}
