package x5;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends u4.e {

    /* JADX INFO: compiled from: source.java */
    public static final class a implements u4.e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z3.i0 f79941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z3.c0 f79942b = new z3.c0();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f79943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f79944d;

        public a(int i11, z3.i0 i0Var, int i12) {
            this.f79943c = i11;
            this.f79941a = i0Var;
            this.f79944d = i12;
        }

        @Override // u4.e.f
        public void a() {
            this.f79942b.R(u0.f81843f);
        }

        @Override // u4.e.f
        public u4.e.C0862e b(u4.t tVar, long j11) throws IOException {
            long position = tVar.getPosition();
            int iMin = (int) Math.min(this.f79944d, tVar.getLength() - position);
            this.f79942b.Q(iMin);
            tVar.peekFully(this.f79942b.e(), 0, iMin);
            return c(this.f79942b, j11, position);
        }

        public final u4.e.C0862e c(z3.c0 c0Var, long j11, long j12) {
            int iA;
            int iA2;
            int iG = c0Var.g();
            long j13 = -1;
            long j14 = -1;
            long j15 = -9223372036854775807L;
            while (c0Var.a() >= 188 && (iA2 = (iA = j0.a(c0Var.e(), c0Var.f(), iG)) + 188) <= iG) {
                long jC = j0.c(c0Var, iA, this.f79943c);
                if (jC != C.TIME_UNSET) {
                    long jB = this.f79941a.b(jC);
                    if (jB > j11) {
                        return j15 == C.TIME_UNSET ? u4.e.C0862e.d(jB, j12) : u4.e.C0862e.e(j12 + j14);
                    }
                    if (100000 + jB > j11) {
                        return u4.e.C0862e.e(j12 + ((long) iA));
                    }
                    j14 = iA;
                    j15 = jB;
                }
                c0Var.U(iA2);
                j13 = iA2;
            }
            return j15 != C.TIME_UNSET ? u4.e.C0862e.f(j15, j12 + j13) : u4.e.C0862e.f78264d;
        }
    }

    public e0(z3.i0 i0Var, long j11, long j12, int i11, int i12) {
        super(new u4.e.b(), new a(i11, i0Var, i12), j11, 0L, j11 + 1, 0L, j12, 188L, 940);
    }
}
