package com.applovin.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final a f19591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final f f19592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected c f19593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19594d;

    /* JADX INFO: compiled from: source.java */
    public static class a implements ij {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f19595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f19596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f19597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f19598d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f19599e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f19600f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f19601g;

        public a(d dVar, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.f19595a = dVar;
            this.f19596b = j11;
            this.f19597c = j12;
            this.f19598d = j13;
            this.f19599e = j14;
            this.f19600f = j15;
            this.f19601g = j16;
        }

        @Override // com.applovin.impl.ij
        public ij.a b(long j11) {
            return new ij.a(new kj(j11, c.a(this.f19595a.a(j11), this.f19597c, this.f19598d, this.f19599e, this.f19600f, this.f19601g)));
        }

        @Override // com.applovin.impl.ij
        public boolean b() {
            return true;
        }

        public long c(long j11) {
            return this.f19595a.a(j11);
        }

        @Override // com.applovin.impl.ij
        public long d() {
            return this.f19596b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements d {
        @Override // com.applovin.impl.i2.d
        public long a(long j11) {
            return j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f19602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f19603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f19604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f19605d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f19606e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f19607f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f19608g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f19609h;

        public c(long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
            this.f19602a = j11;
            this.f19603b = j12;
            this.f19605d = j13;
            this.f19606e = j14;
            this.f19607f = j15;
            this.f19608g = j16;
            this.f19604c = j17;
            this.f19609h = a(j12, j13, j14, j15, j16, j17);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a() {
            return this.f19608g;
        }

        public static long a(long j11, long j12, long j13, long j14, long j15, long j16) {
            if (j14 + 1 >= j15 || j12 + 1 >= j13) {
                return j14;
            }
            long j17 = (long) ((j11 - j12) * ((j15 - j14) / (j13 - j12)));
            return xp.b(((j17 + j14) - j16) - (j17 / 20), j14, j15 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j11, long j12) {
            this.f19606e = j11;
            this.f19608g = j12;
            f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long b() {
            return this.f19607f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j11, long j12) {
            this.f19605d = j11;
            this.f19607f = j12;
            f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c() {
            return this.f19609h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long d() {
            return this.f19602a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long e() {
            return this.f19603b;
        }

        private void f() {
            this.f19609h = a(this.f19603b, this.f19605d, this.f19606e, this.f19607f, this.f19608g, this.f19604c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        long a(long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f19610d = new e(-3, C.TIME_UNSET, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f19612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f19613c;

        private e(int i11, long j11, long j12) {
            this.f19611a = i11;
            this.f19612b = j11;
            this.f19613c = j12;
        }

        public static e a(long j11) {
            return new e(0, C.TIME_UNSET, j11);
        }

        public static e a(long j11, long j12) {
            return new e(-1, j11, j12);
        }

        public static e b(long j11, long j12) {
            return new e(-2, j11, j12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        e a(l8 l8Var, long j11);

        void a();
    }

    public i2(d dVar, f fVar, long j11, long j12, long j13, long j14, long j15, long j16, int i11) {
        this.f19592b = fVar;
        this.f19594d = i11;
        this.f19591a = new a(dVar, j11, j12, j13, j14, j15, j16);
    }

    public final int a(l8 l8Var, long j11, th thVar) {
        if (j11 == l8Var.f()) {
            return 0;
        }
        thVar.f23379a = j11;
        return 1;
    }

    public int a(l8 l8Var, th thVar) {
        while (true) {
            c cVar = (c) b1.b(this.f19593c);
            long jB = cVar.b();
            long jA = cVar.a();
            long jC = cVar.c();
            if (jA - jB <= this.f19594d) {
                a(false, jB);
                return a(l8Var, jB, thVar);
            }
            if (!a(l8Var, jC)) {
                return a(l8Var, jC, thVar);
            }
            l8Var.b();
            e eVarA = this.f19592b.a(l8Var, cVar.e());
            int i11 = eVarA.f19611a;
            if (i11 == -3) {
                a(false, jC);
                return a(l8Var, jC, thVar);
            }
            if (i11 == -2) {
                cVar.b(eVarA.f19612b, eVarA.f19613c);
            } else {
                if (i11 != -1) {
                    if (i11 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    a(l8Var, eVarA.f19613c);
                    a(true, eVarA.f19613c);
                    return a(l8Var, eVarA.f19613c, thVar);
                }
                cVar.a(eVarA.f19612b, eVarA.f19613c);
            }
        }
    }

    public c a(long j11) {
        return new c(j11, this.f19591a.c(j11), this.f19591a.f19597c, this.f19591a.f19598d, this.f19591a.f19599e, this.f19591a.f19600f, this.f19591a.f19601g);
    }

    public final ij a() {
        return this.f19591a;
    }

    public final void a(boolean z11, long j11) {
        this.f19593c = null;
        this.f19592b.a();
        b(z11, j11);
    }

    public final boolean a(l8 l8Var, long j11) {
        long jF = j11 - l8Var.f();
        if (jF < 0 || jF > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        l8Var.a((int) jF);
        return true;
    }

    public final void b(long j11) {
        c cVar = this.f19593c;
        if (cVar == null || cVar.d() != j11) {
            this.f19593c = a(j11);
        }
    }

    public void b(boolean z11, long j11) {
    }

    public final boolean b() {
        return this.f19593c != null;
    }
}
