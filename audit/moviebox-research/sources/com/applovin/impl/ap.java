package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ap extends i2 {

    /* JADX INFO: compiled from: source.java */
    public static final class a implements i2.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ho f17739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final bh f17740b = new bh();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f17741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f17742d;

        public a(int i11, ho hoVar, int i12) {
            this.f17741c = i11;
            this.f17739a = hoVar;
            this.f17742d = i12;
        }

        private i2.e a(bh bhVar, long j11, long j12) {
            int iA;
            int iA2;
            int iE = bhVar.e();
            long j13 = -1;
            long j14 = -1;
            long j15 = -9223372036854775807L;
            while (bhVar.a() >= 188 && (iA2 = (iA = ep.a(bhVar.c(), bhVar.d(), iE)) + 188) <= iE) {
                long jA = ep.a(bhVar, iA, this.f17741c);
                if (jA != C.TIME_UNSET) {
                    long jB = this.f17739a.b(jA);
                    if (jB > j11) {
                        return j15 == C.TIME_UNSET ? i2.e.a(jB, j12) : i2.e.a(j12 + j14);
                    }
                    if (100000 + jB > j11) {
                        return i2.e.a(j12 + ((long) iA));
                    }
                    j14 = iA;
                    j15 = jB;
                }
                bhVar.f(iA2);
                j13 = iA2;
            }
            return j15 != C.TIME_UNSET ? i2.e.b(j15, j12 + j13) : i2.e.f19610d;
        }

        @Override // com.applovin.impl.i2.f
        public i2.e a(l8 l8Var, long j11) {
            long jF = l8Var.f();
            int iMin = (int) Math.min(this.f17742d, l8Var.a() - jF);
            this.f17740b.d(iMin);
            l8Var.c(this.f17740b.c(), 0, iMin);
            return a(this.f17740b, j11, jF);
        }

        @Override // com.applovin.impl.i2.f
        public void a() {
            this.f17740b.a(xp.f24377f);
        }
    }

    public ap(ho hoVar, long j11, long j12, int i11, int i12) {
        super(new i2.b(), new a(i11, hoVar, i12), j11, 0L, j11 + 1, 0L, j12, 188L, 940);
    }
}
