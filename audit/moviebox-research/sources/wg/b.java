package wg;

import java.io.IOException;
import java.util.Objects;
import tg.m;
import tg.s;
import tg.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends tg.a {

    /* JADX INFO: renamed from: wg.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0888b implements tg.a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f79416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f79417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s.a f79418c;

        public C0888b(v vVar, int i11) {
            this.f79416a = vVar;
            this.f79417b = i11;
            this.f79418c = new s.a();
        }

        @Override // tg.a.f
        public /* synthetic */ void a() {
            tg.b.a(this);
        }

        @Override // tg.a.f
        public tg.a.e b(m mVar, long j11) throws IOException {
            long position = mVar.getPosition();
            long jC = c(mVar);
            long peekPosition = mVar.getPeekPosition();
            mVar.advancePeekPosition(Math.max(6, this.f79416a.f77082c));
            long jC2 = c(mVar);
            long peekPosition2 = mVar.getPeekPosition();
            if (jC > j11 || jC2 <= j11) {
                return jC2 <= j11 ? tg.a.e.f(jC2, peekPosition2) : tg.a.e.d(jC, position);
            }
            return tg.a.e.e(peekPosition);
        }

        public final long c(m mVar) throws IOException {
            while (mVar.getPeekPosition() < mVar.getLength() - 6 && !s.h(mVar, this.f79416a, this.f79417b, this.f79418c)) {
                mVar.advancePeekPosition(1);
            }
            if (mVar.getPeekPosition() < mVar.getLength() - 6) {
                return this.f79418c.f77076a;
            }
            mVar.advancePeekPosition((int) (mVar.getLength() - mVar.getPeekPosition()));
            return this.f79416a.f77089j;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final v vVar, int i11, long j11, long j12) {
        super(new tg.a.d() { // from class: wg.a
            @Override // tg.a.d
            public final long a(long j13) {
                return vVar.i(j13);
            }
        }, new C0888b(vVar, i11), vVar.f(), 0L, vVar.f77089j, j11, j12, vVar.d(), Math.max(6, vVar.f77082c));
        Objects.requireNonNull(vVar);
    }
}
