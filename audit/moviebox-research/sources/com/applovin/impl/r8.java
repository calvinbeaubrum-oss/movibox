package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class r8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f22060d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f22062f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f22057a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f22058b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f22061e = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f22063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f22064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f22065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f22066d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f22067e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f22068f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean[] f22069g = new boolean[15];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f22070h;

        private static int a(long j11) {
            return (int) (j11 % 15);
        }

        public long a() {
            long j11 = this.f22067e;
            if (j11 == 0) {
                return 0L;
            }
            return this.f22068f / j11;
        }

        public long b() {
            return this.f22068f;
        }

        public void b(long j11) {
            long j12 = this.f22066d;
            if (j12 == 0) {
                this.f22063a = j11;
            } else if (j12 == 1) {
                long j13 = j11 - this.f22063a;
                this.f22064b = j13;
                this.f22068f = j13;
                this.f22067e = 1L;
            } else {
                long j14 = j11 - this.f22065c;
                int iA = a(j12);
                if (Math.abs(j14 - this.f22064b) <= 1000000) {
                    this.f22067e++;
                    this.f22068f += j14;
                    boolean[] zArr = this.f22069g;
                    if (zArr[iA]) {
                        zArr[iA] = false;
                        this.f22070h--;
                    }
                } else {
                    boolean[] zArr2 = this.f22069g;
                    if (!zArr2[iA]) {
                        zArr2[iA] = true;
                        this.f22070h++;
                    }
                }
            }
            this.f22066d++;
            this.f22065c = j11;
        }

        public boolean c() {
            long j11 = this.f22066d;
            if (j11 == 0) {
                return false;
            }
            return this.f22069g[a(j11 - 1)];
        }

        public boolean d() {
            return this.f22066d > 15 && this.f22070h == 0;
        }

        public void e() {
            this.f22066d = 0L;
            this.f22067e = 0L;
            this.f22068f = 0L;
            this.f22070h = 0;
            Arrays.fill(this.f22069g, false);
        }
    }

    public long a() {
        return e() ? this.f22057a.a() : C.TIME_UNSET;
    }

    public void a(long j11) {
        this.f22057a.b(j11);
        if (this.f22057a.d() && !this.f22060d) {
            this.f22059c = false;
        } else if (this.f22061e != C.TIME_UNSET) {
            if (!this.f22059c || this.f22058b.c()) {
                this.f22058b.e();
                this.f22058b.b(this.f22061e);
            }
            this.f22059c = true;
            this.f22058b.b(j11);
        }
        if (this.f22059c && this.f22058b.d()) {
            a aVar = this.f22057a;
            this.f22057a = this.f22058b;
            this.f22058b = aVar;
            this.f22059c = false;
            this.f22060d = false;
        }
        this.f22061e = j11;
        this.f22062f = this.f22057a.d() ? 0 : this.f22062f + 1;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f22057a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f22062f;
    }

    public long d() {
        return e() ? this.f22057a.b() : C.TIME_UNSET;
    }

    public boolean e() {
        return this.f22057a.d();
    }

    public void f() {
        this.f22057a.e();
        this.f22058b.e();
        this.f22059c = false;
        this.f22061e = C.TIME_UNSET;
        this.f22062f = 0;
    }
}
