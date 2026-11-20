package com.applovin.impl;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class u8 extends i2 {

    /* JADX INFO: compiled from: source.java */
    public static final class b implements i2.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a9 f23530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f23531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final w8.a f23532c;

        private b(a9 a9Var, int i11) {
            this.f23530a = a9Var;
            this.f23531b = i11;
            this.f23532c = new w8.a();
        }

        private long a(l8 l8Var) {
            while (l8Var.d() < l8Var.a() - 6 && !w8.a(l8Var, this.f23530a, this.f23531b, this.f23532c)) {
                l8Var.c(1);
            }
            if (l8Var.d() < l8Var.a() - 6) {
                return this.f23532c.f24075a;
            }
            l8Var.c((int) (l8Var.a() - l8Var.d()));
            return this.f23530a.f17488j;
        }

        @Override // com.applovin.impl.i2.f
        public i2.e a(l8 l8Var, long j11) {
            long jF = l8Var.f();
            long jA = a(l8Var);
            long jD = l8Var.d();
            l8Var.c(Math.max(6, this.f23530a.f17481c));
            long jA2 = a(l8Var);
            long jD2 = l8Var.d();
            if (jA > j11 || jA2 <= j11) {
                return jA2 <= j11 ? i2.e.b(jA2, jD2) : i2.e.a(jA, jF);
            }
            return i2.e.a(jD);
        }

        @Override // com.applovin.impl.i2.f
        public /* synthetic */ void a() {
            ly.a(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u8(final a9 a9Var, int i11, long j11, long j12) {
        super(new i2.d() { // from class: com.applovin.impl.o60
            @Override // com.applovin.impl.i2.d
            public final long a(long j13) {
                return a9Var.a(j13);
            }
        }, new b(a9Var, i11), a9Var.b(), 0L, a9Var.f17488j, j11, j12, a9Var.a(), Math.max(6, a9Var.f17481c));
        Objects.requireNonNull(a9Var);
    }
}
