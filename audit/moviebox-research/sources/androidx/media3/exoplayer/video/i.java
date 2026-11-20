package androidx.media3.exoplayer.video;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11623d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11625f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f11620a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f11621b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f11624e = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f11628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f11629d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f11630e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f11631f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean[] f11632g = new boolean[15];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11633h;

        public static int c(long j11) {
            return (int) (j11 % 15);
        }

        public long a() {
            long j11 = this.f11630e;
            if (j11 == 0) {
                return 0L;
            }
            return this.f11631f / j11;
        }

        public long b() {
            return this.f11631f;
        }

        public boolean d() {
            long j11 = this.f11629d;
            if (j11 == 0) {
                return false;
            }
            return this.f11632g[c(j11 - 1)];
        }

        public boolean e() {
            return this.f11629d > 15 && this.f11633h == 0;
        }

        public void f(long j11) {
            long j12 = this.f11629d;
            if (j12 == 0) {
                this.f11626a = j11;
            } else if (j12 == 1) {
                long j13 = j11 - this.f11626a;
                this.f11627b = j13;
                this.f11631f = j13;
                this.f11630e = 1L;
            } else {
                long j14 = j11 - this.f11628c;
                int iC = c(j12);
                if (Math.abs(j14 - this.f11627b) <= 1000000) {
                    this.f11630e++;
                    this.f11631f += j14;
                    boolean[] zArr = this.f11632g;
                    if (zArr[iC]) {
                        zArr[iC] = false;
                        this.f11633h--;
                    }
                } else {
                    boolean[] zArr2 = this.f11632g;
                    if (!zArr2[iC]) {
                        zArr2[iC] = true;
                        this.f11633h++;
                    }
                }
            }
            this.f11629d++;
            this.f11628c = j11;
        }

        public void g() {
            this.f11629d = 0L;
            this.f11630e = 0L;
            this.f11631f = 0L;
            this.f11633h = 0;
            Arrays.fill(this.f11632g, false);
        }
    }

    public long a() {
        return e() ? this.f11620a.a() : C.TIME_UNSET;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f11620a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f11625f;
    }

    public long d() {
        return e() ? this.f11620a.b() : C.TIME_UNSET;
    }

    public boolean e() {
        return this.f11620a.e();
    }

    public void f(long j11) {
        this.f11620a.f(j11);
        if (this.f11620a.e() && !this.f11623d) {
            this.f11622c = false;
        } else if (this.f11624e != C.TIME_UNSET) {
            if (!this.f11622c || this.f11621b.d()) {
                this.f11621b.g();
                this.f11621b.f(this.f11624e);
            }
            this.f11622c = true;
            this.f11621b.f(j11);
        }
        if (this.f11622c && this.f11621b.e()) {
            a aVar = this.f11620a;
            this.f11620a = this.f11621b;
            this.f11621b = aVar;
            this.f11622c = false;
            this.f11623d = false;
        }
        this.f11624e = j11;
        this.f11625f = this.f11620a.e() ? 0 : this.f11625f + 1;
    }

    public void g() {
        this.f11620a.g();
        this.f11621b.g();
        this.f11622c = false;
        this.f11624e = C.TIME_UNSET;
        this.f11625f = 0;
    }
}
