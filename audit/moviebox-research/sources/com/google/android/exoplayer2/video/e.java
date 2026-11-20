package com.google.android.exoplayer2.video;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f35727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f35728d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35730f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f35725a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f35726b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f35729e = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f35731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f35732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f35733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f35734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f35735e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f35736f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean[] f35737g = new boolean[15];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f35738h;

        public static int c(long j11) {
            return (int) (j11 % 15);
        }

        public long a() {
            long j11 = this.f35735e;
            if (j11 == 0) {
                return 0L;
            }
            return this.f35736f / j11;
        }

        public long b() {
            return this.f35736f;
        }

        public boolean d() {
            long j11 = this.f35734d;
            if (j11 == 0) {
                return false;
            }
            return this.f35737g[c(j11 - 1)];
        }

        public boolean e() {
            return this.f35734d > 15 && this.f35738h == 0;
        }

        public void f(long j11) {
            long j12 = this.f35734d;
            if (j12 == 0) {
                this.f35731a = j11;
            } else if (j12 == 1) {
                long j13 = j11 - this.f35731a;
                this.f35732b = j13;
                this.f35736f = j13;
                this.f35735e = 1L;
            } else {
                long j14 = j11 - this.f35733c;
                int iC = c(j12);
                if (Math.abs(j14 - this.f35732b) <= 1000000) {
                    this.f35735e++;
                    this.f35736f += j14;
                    boolean[] zArr = this.f35737g;
                    if (zArr[iC]) {
                        zArr[iC] = false;
                        this.f35738h--;
                    }
                } else {
                    boolean[] zArr2 = this.f35737g;
                    if (!zArr2[iC]) {
                        zArr2[iC] = true;
                        this.f35738h++;
                    }
                }
            }
            this.f35734d++;
            this.f35733c = j11;
        }

        public void g() {
            this.f35734d = 0L;
            this.f35735e = 0L;
            this.f35736f = 0L;
            this.f35738h = 0;
            Arrays.fill(this.f35737g, false);
        }
    }

    public long a() {
        return e() ? this.f35725a.a() : C.TIME_UNSET;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f35725a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f35730f;
    }

    public long d() {
        return e() ? this.f35725a.b() : C.TIME_UNSET;
    }

    public boolean e() {
        return this.f35725a.e();
    }

    public void f(long j11) {
        this.f35725a.f(j11);
        if (this.f35725a.e() && !this.f35728d) {
            this.f35727c = false;
        } else if (this.f35729e != C.TIME_UNSET) {
            if (!this.f35727c || this.f35726b.d()) {
                this.f35726b.g();
                this.f35726b.f(this.f35729e);
            }
            this.f35727c = true;
            this.f35726b.f(j11);
        }
        if (this.f35727c && this.f35726b.e()) {
            a aVar = this.f35725a;
            this.f35725a = this.f35726b;
            this.f35726b = aVar;
            this.f35727c = false;
            this.f35728d = false;
        }
        this.f35729e = j11;
        this.f35730f = this.f35725a.e() ? 0 : this.f35730f + 1;
    }

    public void g() {
        this.f35725a.g();
        this.f35726b.g();
        this.f35727c = false;
        this.f35729e = C.TIME_UNSET;
        this.f35730f = 0;
    }
}
