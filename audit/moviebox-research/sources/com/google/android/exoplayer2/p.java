package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface p extends n2 {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void x(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        public boolean A;
        public boolean B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f33665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.google.android.exoplayer2.util.e f33666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f33667c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.google.common.base.q<a3> f33668d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.google.common.base.q<com.google.android.exoplayer2.source.i.a> f33669e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.common.base.q<fi.b0> f33670f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.common.base.q<s1> f33671g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.google.common.base.q<com.google.android.exoplayer2.upstream.e> f33672h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public com.google.common.base.f<com.google.android.exoplayer2.util.e, qg.a> f33673i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Looper f33674j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public PriorityTaskManager f33675k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public com.google.android.exoplayer2.audio.e f33676l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f33677m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f33678n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f33679o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f33680p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f33681q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f33682r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f33683s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public b3 f33684t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public long f33685u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public long f33686v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public r1 f33687w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public long f33688x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public long f33689y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f33690z;

        public b(final Context context) {
            this(context, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.r
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return p.b.h(context);
                }
            }, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.s
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return p.b.i(context);
                }
            });
        }

        public b(final Context context, com.google.common.base.q<a3> qVar, com.google.common.base.q<com.google.android.exoplayer2.source.i.a> qVar2) {
            this(context, qVar, qVar2, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.u
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return p.b.j(context);
                }
            }, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.v
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return new j();
                }
            }, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.w
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return com.google.android.exoplayer2.upstream.q.m(context);
                }
            }, new com.google.common.base.f() { // from class: com.google.android.exoplayer2.x
                @Override // com.google.common.base.f
                public final Object apply(Object obj) {
                    return new qg.p1((com.google.android.exoplayer2.util.e) obj);
                }
            });
        }

        public b(Context context, com.google.common.base.q<a3> qVar, com.google.common.base.q<com.google.android.exoplayer2.source.i.a> qVar2, com.google.common.base.q<fi.b0> qVar3, com.google.common.base.q<s1> qVar4, com.google.common.base.q<com.google.android.exoplayer2.upstream.e> qVar5, com.google.common.base.f<com.google.android.exoplayer2.util.e, qg.a> fVar) {
            this.f33665a = context;
            this.f33668d = qVar;
            this.f33669e = qVar2;
            this.f33670f = qVar3;
            this.f33671g = qVar4;
            this.f33672h = qVar5;
            this.f33673i = fVar;
            this.f33674j = com.google.android.exoplayer2.util.o0.Q();
            this.f33676l = com.google.android.exoplayer2.audio.e.f32806h;
            this.f33678n = 0;
            this.f33681q = 1;
            this.f33682r = 0;
            this.f33683s = true;
            this.f33684t = b3.f32990g;
            this.f33685u = 5000L;
            this.f33686v = 15000L;
            this.f33687w = new i.b().a();
            this.f33666b = com.google.android.exoplayer2.util.e.f35556a;
            this.f33688x = 500L;
            this.f33689y = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
            this.A = true;
        }

        public static /* synthetic */ a3 h(Context context) {
            return new l(context);
        }

        public static /* synthetic */ com.google.android.exoplayer2.source.i.a i(Context context) {
            return new com.google.android.exoplayer2.source.d(context, new tg.i());
        }

        public static /* synthetic */ fi.b0 j(Context context) {
            return new fi.m(context);
        }

        public static /* synthetic */ com.google.android.exoplayer2.source.i.a l(com.google.android.exoplayer2.source.i.a aVar) {
            return aVar;
        }

        public static /* synthetic */ a3 m(a3 a3Var) {
            return a3Var;
        }

        public p g() {
            com.google.android.exoplayer2.util.a.g(!this.B);
            this.B = true;
            return new x0(this, null);
        }

        public b n(final com.google.android.exoplayer2.source.i.a aVar) {
            com.google.android.exoplayer2.util.a.g(!this.B);
            this.f33669e = new com.google.common.base.q() { // from class: com.google.android.exoplayer2.q
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return p.b.l(aVar);
                }
            };
            return this;
        }

        public b o(final a3 a3Var) {
            com.google.android.exoplayer2.util.a.g(!this.B);
            this.f33668d = new com.google.common.base.q() { // from class: com.google.android.exoplayer2.t
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return p.b.m(a3Var);
                }
            };
            return this;
        }
    }

    void a(com.google.android.exoplayer2.source.i iVar);
}
