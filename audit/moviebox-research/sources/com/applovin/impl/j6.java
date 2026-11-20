package com.applovin.impl;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class j6 implements kg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jg f19857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final gl f19860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f19862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f19863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f19864h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f19865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f19866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f19867k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f19868l;

    /* JADX INFO: compiled from: source.java */
    public final class b implements ij {
        private b() {
        }

        @Override // com.applovin.impl.ij
        public ij.a b(long j11) {
            return new ij.a(new kj(j11, xp.b((j6.this.f19858b + ((j6.this.f19860d.b(j11) * (j6.this.f19859c - j6.this.f19858b)) / j6.this.f19862f)) - 30000, j6.this.f19858b, j6.this.f19859c - 1)));
        }

        @Override // com.applovin.impl.ij
        public boolean b() {
            return true;
        }

        @Override // com.applovin.impl.ij
        public long d() {
            return j6.this.f19860d.a(j6.this.f19862f);
        }
    }

    public j6(gl glVar, long j11, long j12, long j13, long j14, boolean z11) {
        b1.a(j11 >= 0 && j12 > j11);
        this.f19860d = glVar;
        this.f19858b = j11;
        this.f19859c = j12;
        if (j13 == j12 - j11 || z11) {
            this.f19862f = j14;
            this.f19861e = 4;
        } else {
            this.f19861e = 0;
        }
        this.f19857a = new jg();
    }

    private long b(l8 l8Var) throws IOException {
        if (this.f19865i == this.f19866j) {
            return -1L;
        }
        long jF = l8Var.f();
        if (!this.f19857a.a(l8Var, this.f19866j)) {
            long j11 = this.f19865i;
            if (j11 != jF) {
                return j11;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f19857a.a(l8Var, false);
        l8Var.b();
        long j12 = this.f19864h;
        jg jgVar = this.f19857a;
        long j13 = jgVar.f19950c;
        long j14 = j12 - j13;
        int i11 = jgVar.f19955h + jgVar.f19956i;
        if (0 <= j14 && j14 < 72000) {
            return -1L;
        }
        if (j14 < 0) {
            this.f19866j = jF;
            this.f19868l = j13;
        } else {
            this.f19865i = l8Var.f() + ((long) i11);
            this.f19867k = this.f19857a.f19950c;
        }
        long j15 = this.f19866j;
        long j16 = this.f19865i;
        if (j15 - j16 < 100000) {
            this.f19866j = j16;
            return j16;
        }
        long jF2 = l8Var.f() - (((long) i11) * (j14 <= 0 ? 2L : 1L));
        long j17 = this.f19866j;
        long j18 = this.f19865i;
        return xp.b(jF2 + ((j14 * (j17 - j18)) / (this.f19868l - this.f19867k)), j18, j17 - 1);
    }

    private void d(l8 l8Var) throws dh {
        while (true) {
            this.f19857a.a(l8Var);
            this.f19857a.a(l8Var, false);
            jg jgVar = this.f19857a;
            if (jgVar.f19950c > this.f19864h) {
                l8Var.b();
                return;
            } else {
                l8Var.a(jgVar.f19955h + jgVar.f19956i);
                this.f19865i = l8Var.f();
                this.f19867k = this.f19857a.f19950c;
            }
        }
    }

    @Override // com.applovin.impl.kg
    public long a(l8 l8Var) throws IOException {
        int i11 = this.f19861e;
        if (i11 == 0) {
            long jF = l8Var.f();
            this.f19863g = jF;
            this.f19861e = 1;
            long j11 = this.f19859c - 65307;
            if (j11 > jF) {
                return j11;
            }
        } else if (i11 != 1) {
            if (i11 == 2) {
                long jB = b(l8Var);
                if (jB != -1) {
                    return jB;
                }
                this.f19861e = 3;
            } else if (i11 != 3) {
                if (i11 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            d(l8Var);
            this.f19861e = 4;
            return -(this.f19867k + 2);
        }
        this.f19862f = c(l8Var);
        this.f19861e = 4;
        return this.f19863g;
    }

    @Override // com.applovin.impl.kg
    public void a(long j11) {
        this.f19864h = xp.b(j11, 0L, this.f19862f - 1);
        this.f19861e = 2;
        this.f19865i = this.f19858b;
        this.f19866j = this.f19859c;
        this.f19867k = 0L;
        this.f19868l = this.f19862f;
    }

    @Override // com.applovin.impl.kg
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a() {
        if (this.f19862f != 0) {
            return new b();
        }
        return null;
    }

    public long c(l8 l8Var) throws dh, EOFException {
        this.f19857a.a();
        if (!this.f19857a.a(l8Var)) {
            throw new EOFException();
        }
        this.f19857a.a(l8Var, false);
        jg jgVar = this.f19857a;
        l8Var.a(jgVar.f19955h + jgVar.f19956i);
        long j11 = this.f19857a.f19950c;
        while (true) {
            jg jgVar2 = this.f19857a;
            if ((jgVar2.f19949b & 4) == 4 || !jgVar2.a(l8Var) || l8Var.f() >= this.f19859c || !this.f19857a.a(l8Var, true)) {
                break;
            }
            jg jgVar3 = this.f19857a;
            if (!n8.a(l8Var, jgVar3.f19955h + jgVar3.f19956i)) {
                break;
            }
            j11 = this.f19857a.f19950c;
        }
        return j11;
    }
}
