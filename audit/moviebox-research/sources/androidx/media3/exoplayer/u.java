package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface u extends androidx.media3.common.h0 {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void y(boolean z11);

        void z(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        public boolean A;
        public boolean B;

        @Nullable
        public Looper C;
        public boolean D;
        public boolean E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f11397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public z3.d f11398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f11399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.google.common.base.q<a3> f11400d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.google.common.base.q<androidx.media3.exoplayer.source.l.a> f11401e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.common.base.q<s4.e0> f11402f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.common.base.q<v1> f11403g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.google.common.base.q<androidx.media3.exoplayer.upstream.e> f11404h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public com.google.common.base.f<z3.d, e4.a> f11405i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Looper f11406j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public PriorityTaskManager f11407k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public androidx.media3.common.d f11408l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f11409m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11410n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f11411o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f11412p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f11413q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f11414r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f11415s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f11416t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public b3 f11417u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public long f11418v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public long f11419w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public u1 f11420x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public long f11421y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public long f11422z;

        public b(final Context context) {
            this(context, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.v
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return u.b.h(context);
                }
            }, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.w
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return u.b.i(context);
                }
            });
        }

        public b(final Context context, com.google.common.base.q<a3> qVar, com.google.common.base.q<androidx.media3.exoplayer.source.l.a> qVar2) {
            this(context, qVar, qVar2, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.z
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return u.b.j(context);
                }
            }, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.a0
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return new q();
                }
            }, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.b0
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return androidx.media3.exoplayer.upstream.j.m(context);
                }
            }, new com.google.common.base.f() { // from class: androidx.media3.exoplayer.c0
                @Override // com.google.common.base.f
                public final Object apply(Object obj) {
                    return new e4.q1((z3.d) obj);
                }
            });
        }

        public b(Context context, com.google.common.base.q<a3> qVar, com.google.common.base.q<androidx.media3.exoplayer.source.l.a> qVar2, com.google.common.base.q<s4.e0> qVar3, com.google.common.base.q<v1> qVar4, com.google.common.base.q<androidx.media3.exoplayer.upstream.e> qVar5, com.google.common.base.f<z3.d, e4.a> fVar) {
            this.f11397a = (Context) z3.a.e(context);
            this.f11400d = qVar;
            this.f11401e = qVar2;
            this.f11402f = qVar3;
            this.f11403g = qVar4;
            this.f11404h = qVar5;
            this.f11405i = fVar;
            this.f11406j = z3.u0.V();
            this.f11408l = androidx.media3.common.d.f9123g;
            this.f11410n = 0;
            this.f11414r = 1;
            this.f11415s = 0;
            this.f11416t = true;
            this.f11417u = b3.f10006g;
            this.f11418v = 5000L;
            this.f11419w = 15000L;
            this.f11420x = new p.b().a();
            this.f11398b = z3.d.f81767a;
            this.f11421y = 500L;
            this.f11422z = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
            this.B = true;
        }

        public static /* synthetic */ a3 h(Context context) {
            return new s(context);
        }

        public static /* synthetic */ androidx.media3.exoplayer.source.l.a i(Context context) {
            return new androidx.media3.exoplayer.source.d(context, new u4.m());
        }

        public static /* synthetic */ s4.e0 j(Context context) {
            return new s4.o(context);
        }

        public static /* synthetic */ androidx.media3.exoplayer.source.l.a l(androidx.media3.exoplayer.source.l.a aVar) {
            return aVar;
        }

        public static /* synthetic */ a3 m(a3 a3Var) {
            return a3Var;
        }

        public u g() {
            z3.a.g(!this.D);
            this.D = true;
            return new c1(this, null);
        }

        public b n(final androidx.media3.exoplayer.source.l.a aVar) {
            z3.a.g(!this.D);
            z3.a.e(aVar);
            this.f11401e = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.y
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return u.b.l(aVar);
                }
            };
            return this;
        }

        public b o(final a3 a3Var) {
            z3.a.g(!this.D);
            z3.a.e(a3Var);
            this.f11400d = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.x
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return u.b.m(a3Var);
                }
            };
            return this;
        }
    }

    void L(e4.c cVar);

    void O(int i11, androidx.media3.common.b0 b0Var);

    @Nullable
    androidx.media3.common.y Q();

    void S(androidx.media3.exoplayer.source.l lVar);

    @Nullable
    androidx.media3.common.y a();

    @Override // androidx.media3.common.h0
    @Nullable
    ExoPlaybackException c();
}
