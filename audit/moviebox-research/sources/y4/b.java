package y4;

import java.io.IOException;
import java.util.Objects;
import u4.c0;
import u4.e;
import u4.f;
import u4.t;
import u4.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends e {

    /* JADX INFO: renamed from: y4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0912b implements e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f81165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f81166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z.a f81167c;

        public C0912b(c0 c0Var, int i11) {
            this.f81165a = c0Var;
            this.f81166b = i11;
            this.f81167c = new z.a();
        }

        @Override // u4.e.f
        public /* synthetic */ void a() {
            f.a(this);
        }

        @Override // u4.e.f
        public e.C0862e b(t tVar, long j11) throws IOException {
            long position = tVar.getPosition();
            long jC = c(tVar);
            long peekPosition = tVar.getPeekPosition();
            tVar.advancePeekPosition(Math.max(6, this.f81165a.f78221c));
            long jC2 = c(tVar);
            long peekPosition2 = tVar.getPeekPosition();
            if (jC > j11 || jC2 <= j11) {
                return jC2 <= j11 ? e.C0862e.f(jC2, peekPosition2) : e.C0862e.d(jC, position);
            }
            return e.C0862e.e(peekPosition);
        }

        public final long c(t tVar) throws IOException {
            while (tVar.getPeekPosition() < tVar.getLength() - 6 && !z.h(tVar, this.f81165a, this.f81166b, this.f81167c)) {
                tVar.advancePeekPosition(1);
            }
            if (tVar.getPeekPosition() < tVar.getLength() - 6) {
                return this.f81167c.f78414a;
            }
            tVar.advancePeekPosition((int) (tVar.getLength() - tVar.getPeekPosition()));
            return this.f81165a.f78228j;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final c0 c0Var, int i11, long j11, long j12) {
        super(new e.d() { // from class: y4.a
            @Override // u4.e.d
            public final long a(long j13) {
                return c0Var.i(j13);
            }
        }, new C0912b(c0Var, i11), c0Var.f(), 0L, c0Var.f78228j, j11, j12, c0Var.d(), Math.max(6, c0Var.f78221c));
        Objects.requireNonNull(c0Var);
    }
}
