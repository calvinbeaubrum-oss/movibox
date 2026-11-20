package com.applovin.impl;

import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import com.applovin.exoplayer2.common.base.Objects;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface qh {

    /* JADX INFO: compiled from: source.java */
    public static final class b implements o2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f21935b = new a().a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final o2.a f21936c = new o2.a() { // from class: com.applovin.impl.b20
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return qh.b.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b9 f21937a;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final int[] f21938b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final b9.b f21939a = new b9.b();

            public a a(int i11) {
                this.f21939a.a(i11);
                return this;
            }

            public a a(int i11, boolean z11) {
                this.f21939a.a(i11, z11);
                return this;
            }

            public a a(b bVar) {
                this.f21939a.a(bVar.f21937a);
                return this;
            }

            public a a(int... iArr) {
                this.f21939a.a(iArr);
                return this;
            }

            public b a() {
                return new b(this.f21939a.a());
            }
        }

        private b(b9 b9Var) {
            this.f21937a = b9Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(b(0));
            if (integerArrayList == null) {
                return f21935b;
            }
            a aVar = new a();
            for (int i11 = 0; i11 < integerArrayList.size(); i11++) {
                aVar.a(integerArrayList.get(i11).intValue());
            }
            return aVar.a();
        }

        private static String b(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean a(int i11) {
            return this.f21937a.a(i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f21937a.equals(((b) obj).f21937a);
            }
            return false;
        }

        public int hashCode() {
            return this.f21937a.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(int i11);

        void a(fo foVar, int i11);

        void a(nh nhVar);

        void a(ph phVar);

        void a(po poVar, to toVar);

        void a(b bVar);

        void a(f fVar, f fVar2, int i11);

        void a(qh qhVar, d dVar);

        void a(td tdVar, int i11);

        void a(vd vdVar);

        void a(boolean z11, int i11);

        void b();

        void b(int i11);

        void b(nh nhVar);

        void b(boolean z11);

        void b(boolean z11, int i11);

        void c(int i11);

        void c(boolean z11);

        void d(boolean z11);

        void e(int i11);

        void e(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b9 f21940a;

        public d(b9 b9Var) {
            this.f21940a = b9Var;
        }

        public boolean a(int i11) {
            return this.f21940a.a(i11);
        }

        public boolean a(int... iArr) {
            return this.f21940a.a(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                return this.f21940a.equals(((d) obj).f21940a);
            }
            return false;
        }

        public int hashCode() {
            return this.f21940a.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface e extends c {
        void a();

        void a(float f11);

        @Override // com.applovin.impl.qh.c
        void a(int i11);

        void a(int i11, int i12);

        void a(bf bfVar);

        @Override // com.applovin.impl.qh.c
        void a(fo foVar, int i11);

        @Override // com.applovin.impl.qh.c
        void a(nh nhVar);

        @Override // com.applovin.impl.qh.c
        void a(ph phVar);

        @Override // com.applovin.impl.qh.c
        void a(po poVar, to toVar);

        @Override // com.applovin.impl.qh.c
        void a(b bVar);

        @Override // com.applovin.impl.qh.c
        void a(f fVar, f fVar2, int i11);

        @Override // com.applovin.impl.qh.c
        void a(qh qhVar, d dVar);

        void a(r6 r6Var);

        @Override // com.applovin.impl.qh.c
        void a(td tdVar, int i11);

        @Override // com.applovin.impl.qh.c
        void a(vd vdVar);

        void a(xq xqVar);

        void a(List list);

        void a(boolean z11);

        @Override // com.applovin.impl.qh.c
        void a(boolean z11, int i11);

        @Override // com.applovin.impl.qh.c
        void b(int i11);

        void b(int i11, boolean z11);

        @Override // com.applovin.impl.qh.c
        void b(nh nhVar);

        @Override // com.applovin.impl.qh.c
        void b(boolean z11);

        @Override // com.applovin.impl.qh.c
        void c(int i11);

        @Override // com.applovin.impl.qh.c
        void c(boolean z11);

        @Override // com.applovin.impl.qh.c
        void d(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements o2 {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final o2.a f21941k = new o2.a() { // from class: com.applovin.impl.e20
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return qh.f.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f21942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final td f21944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f21945d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f21946f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f21947g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f21948h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f21949i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f21950j;

        public f(Object obj, int i11, td tdVar, Object obj2, int i12, long j11, long j12, int i13, int i14) {
            this.f21942a = obj;
            this.f21943b = i11;
            this.f21944c = tdVar;
            this.f21945d = obj2;
            this.f21946f = i12;
            this.f21947g = j11;
            this.f21948h = j12;
            this.f21949i = i13;
            this.f21950j = i14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(Bundle bundle) {
            return new f(null, bundle.getInt(a(0), -1), (td) p2.a(td.f23245h, bundle.getBundle(a(1))), null, bundle.getInt(a(2), -1), bundle.getLong(a(3), C.TIME_UNSET), bundle.getLong(a(4), C.TIME_UNSET), bundle.getInt(a(5), -1), bundle.getInt(a(6), -1));
        }

        private static String a(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f21943b == fVar.f21943b && this.f21946f == fVar.f21946f && this.f21947g == fVar.f21947g && this.f21948h == fVar.f21948h && this.f21949i == fVar.f21949i && this.f21950j == fVar.f21950j && Objects.equal(this.f21942a, fVar.f21942a) && Objects.equal(this.f21945d, fVar.f21945d) && Objects.equal(this.f21944c, fVar.f21944c);
        }

        public int hashCode() {
            return Objects.hashCode(this.f21942a, Integer.valueOf(this.f21943b), this.f21944c, this.f21945d, Integer.valueOf(this.f21946f), Integer.valueOf(this.f21943b), Long.valueOf(this.f21947g), Long.valueOf(this.f21948h), Integer.valueOf(this.f21949i), Integer.valueOf(this.f21950j));
        }
    }

    to A();

    void B();

    vd C();

    void D();

    int E();

    long F();

    ph a();

    void a(int i11);

    void a(int i11, long j11);

    void a(long j11);

    void a(SurfaceView surfaceView);

    void a(TextureView textureView);

    void a(e eVar);

    void a(boolean z11);

    void b();

    void b(SurfaceView surfaceView);

    void b(TextureView textureView);

    void b(e eVar);

    void b(boolean z11);

    boolean b(int i11);

    nh c();

    boolean d();

    long e();

    int f();

    long g();

    long getCurrentPosition();

    long getDuration();

    long h();

    b i();

    boolean isPlaying();

    int j();

    po k();

    boolean l();

    int m();

    fo n();

    int o();

    Looper p();

    long q();

    boolean r();

    long s();

    int t();

    void u();

    int v();

    void w();

    List x();

    boolean y();

    xq z();
}
