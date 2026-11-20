package dh;

import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e0 extends tg.a {

    /* JADX INFO: compiled from: source.java */
    public static final class a implements tg.a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.k0 f63098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.c0 f63099b = new com.google.android.exoplayer2.util.c0();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f63100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f63101d;

        public a(int i11, com.google.android.exoplayer2.util.k0 k0Var, int i12) {
            this.f63100c = i11;
            this.f63098a = k0Var;
            this.f63101d = i12;
        }

        @Override // tg.a.f
        public void a() {
            this.f63099b.M(o0.f35613f);
        }

        @Override // tg.a.f
        public tg.a.e b(tg.m mVar, long j11) throws IOException {
            long position = mVar.getPosition();
            int iMin = (int) Math.min(this.f63101d, mVar.getLength() - position);
            this.f63099b.L(iMin);
            mVar.peekFully(this.f63099b.d(), 0, iMin);
            return c(this.f63099b, j11, position);
        }

        public final tg.a.e c(com.google.android.exoplayer2.util.c0 c0Var, long j11, long j12) {
            int iA;
            int iA2;
            int iF = c0Var.f();
            long j13 = -1;
            long j14 = -1;
            long j15 = -9223372036854775807L;
            while (c0Var.a() >= 188 && (iA2 = (iA = j0.a(c0Var.d(), c0Var.e(), iF)) + 188) <= iF) {
                long jC = j0.c(c0Var, iA, this.f63100c);
                if (jC != C.TIME_UNSET) {
                    long jB = this.f63098a.b(jC);
                    if (jB > j11) {
                        return j15 == C.TIME_UNSET ? tg.a.e.d(jB, j12) : tg.a.e.e(j12 + j14);
                    }
                    if (100000 + jB > j11) {
                        return tg.a.e.e(j12 + ((long) iA));
                    }
                    j14 = iA;
                    j15 = jB;
                }
                c0Var.P(iA2);
                j13 = iA2;
            }
            return j15 != C.TIME_UNSET ? tg.a.e.f(j15, j12 + j13) : tg.a.e.f76986d;
        }
    }

    public e0(com.google.android.exoplayer2.util.k0 k0Var, long j11, long j12, int i11, int i12) {
        super(new tg.a.b(), new a(i11, k0Var, i12), j11, 0L, j11 + 1, 0L, j12, 188L, 940);
    }
}
