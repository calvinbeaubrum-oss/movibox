package com.applovin.impl;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ck extends d2 {
    private int A;
    private int B;
    private n5 C;
    private n5 D;
    private int E;
    private l1 F;
    private float G;
    private boolean H;
    private List I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private r6 N;
    private xq O;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final qi[] f18201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c4 f18202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f18203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c8 f18204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f18205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f18206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CopyOnWriteArraySet f18207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r0 f18208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final m1 f18209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final o1 f18210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final il f18211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final gr f18212m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final cs f18213n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f18214o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private f9 f18215p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private f9 f18216q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AudioTrack f18217r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Object f18218s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Surface f18219t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SurfaceHolder f18220u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private rk f18221v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f18222w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextureView f18223x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f18224y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f18225z;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f18226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ti f18227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private l3 f18228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f18229d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private vo f18230e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private de f18231f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private lc f18232g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private y1 f18233h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private r0 f18234i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Looper f18235j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private l1 f18236k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f18237l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f18238m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f18239n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f18240o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f18241p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f18242q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f18243r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private jj f18244s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private long f18245t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private long f18246u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private kc f18247v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private long f18248w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private long f18249x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private boolean f18250y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private boolean f18251z;

        public b(Context context) {
            this(context, new k6(context), new c6());
        }

        public b(Context context, ti tiVar, o8 o8Var) {
            this(context, tiVar, new m6(context), new i6(context, o8Var), new f6(), t5.a(context), new r0(l3.f20326a));
        }

        public b(Context context, ti tiVar, vo voVar, de deVar, lc lcVar, y1 y1Var, r0 r0Var) {
            this.f18226a = context;
            this.f18227b = tiVar;
            this.f18230e = voVar;
            this.f18231f = deVar;
            this.f18232g = lcVar;
            this.f18233h = y1Var;
            this.f18234i = r0Var;
            this.f18235j = xp.d();
            this.f18236k = l1.f20312g;
            this.f18238m = 0;
            this.f18241p = 1;
            this.f18242q = 0;
            this.f18243r = true;
            this.f18244s = jj.f19979g;
            this.f18245t = 5000L;
            this.f18246u = 15000L;
            this.f18247v = new e6.b().a();
            this.f18228c = l3.f20326a;
            this.f18248w = 500L;
            this.f18249x = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
        }

        public static /* synthetic */ uh m(b bVar) {
            bVar.getClass();
            return null;
        }

        public ck a() {
            b1.b(!this.f18251z);
            this.f18251z = true;
            return new ck(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements wq, q1, ao, ff, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, rk.b, o1.b, m1.b, il.b, qh.c, b8 {
        private c() {
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(int i11) {
            c20.a(this, i11);
        }

        @Override // com.applovin.impl.wq
        public void a(int i11, long j11) {
            ck.this.f18208i.a(i11, j11);
        }

        @Override // com.applovin.impl.il.b
        public void a(int i11, boolean z11) {
            Iterator it = ck.this.f18207h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).b(i11, z11);
            }
        }

        @Override // com.applovin.impl.q1
        public void a(long j11) {
            ck.this.f18208i.a(j11);
        }

        @Override // com.applovin.impl.wq
        public void a(long j11, int i11) {
            ck.this.f18208i.a(j11, i11);
        }

        @Override // com.applovin.impl.rk.b
        public void a(Surface surface) {
            ck.this.a((Object) null);
        }

        @Override // com.applovin.impl.ff
        public void a(bf bfVar) {
            ck.this.f18208i.a(bfVar);
            ck.this.f18204e.a(bfVar);
            Iterator it = ck.this.f18207h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).a(bfVar);
            }
        }

        @Override // com.applovin.impl.wq
        public /* synthetic */ void a(f9 f9Var) {
            g80.a(this, f9Var);
        }

        @Override // com.applovin.impl.wq
        public void a(f9 f9Var, q5 q5Var) {
            ck.this.f18215p = f9Var;
            ck.this.f18208i.a(f9Var, q5Var);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(fo foVar, int i11) {
            c20.b(this, foVar, i11);
        }

        @Override // com.applovin.impl.q1
        public void a(n5 n5Var) {
            ck.this.D = n5Var;
            ck.this.f18208i.a(n5Var);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(nh nhVar) {
            c20.c(this, nhVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(ph phVar) {
            c20.d(this, phVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(po poVar, to toVar) {
            c20.e(this, poVar, toVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(qh.b bVar) {
            c20.f(this, bVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(qh.f fVar, qh.f fVar2, int i11) {
            c20.g(this, fVar, fVar2, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(qh qhVar, qh.d dVar) {
            c20.h(this, qhVar, dVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(td tdVar, int i11) {
            c20.i(this, tdVar, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(vd vdVar) {
            c20.j(this, vdVar);
        }

        @Override // com.applovin.impl.wq
        public void a(xq xqVar) {
            ck.this.O = xqVar;
            ck.this.f18208i.a(xqVar);
            Iterator it = ck.this.f18207h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).a(xqVar);
            }
        }

        @Override // com.applovin.impl.q1
        public void a(Exception exc) {
            ck.this.f18208i.a(exc);
        }

        @Override // com.applovin.impl.wq
        public void a(Object obj, long j11) {
            ck.this.f18208i.a(obj, j11);
            if (ck.this.f18218s == obj) {
                Iterator it = ck.this.f18207h.iterator();
                while (it.hasNext()) {
                    ((qh.e) it.next()).a();
                }
            }
        }

        @Override // com.applovin.impl.wq
        public void a(String str) {
            ck.this.f18208i.a(str);
        }

        @Override // com.applovin.impl.q1
        public void a(String str, long j11, long j12) {
            ck.this.f18208i.a(str, j11, j12);
        }

        @Override // com.applovin.impl.ao
        public void a(List list) {
            ck.this.I = list;
            Iterator it = ck.this.f18207h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).a(list);
            }
        }

        @Override // com.applovin.impl.q1
        public void a(boolean z11) {
            if (ck.this.H == z11) {
                return;
            }
            ck.this.H = z11;
            ck.this.U();
        }

        @Override // com.applovin.impl.qh.c
        public void a(boolean z11, int i11) {
            ck.this.Y();
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b() {
            c20.l(this);
        }

        @Override // com.applovin.impl.o1.b
        public void b(float f11) {
            ck.this.X();
        }

        @Override // com.applovin.impl.qh.c
        public void b(int i11) {
            ck.this.Y();
        }

        @Override // com.applovin.impl.q1
        public void b(int i11, long j11, long j12) {
            ck.this.f18208i.b(i11, j11, j12);
        }

        @Override // com.applovin.impl.rk.b
        public void b(Surface surface) {
            ck.this.a(surface);
        }

        @Override // com.applovin.impl.q1
        public /* synthetic */ void b(f9 f9Var) {
            l10.a(this, f9Var);
        }

        @Override // com.applovin.impl.q1
        public void b(f9 f9Var, q5 q5Var) {
            ck.this.f18216q = f9Var;
            ck.this.f18208i.b(f9Var, q5Var);
        }

        @Override // com.applovin.impl.wq
        public void b(n5 n5Var) {
            ck.this.f18208i.b(n5Var);
            ck.this.f18215p = null;
            ck.this.C = null;
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b(nh nhVar) {
            c20.m(this, nhVar);
        }

        @Override // com.applovin.impl.wq
        public void b(Exception exc) {
            ck.this.f18208i.b(exc);
        }

        @Override // com.applovin.impl.q1
        public void b(String str) {
            ck.this.f18208i.b(str);
        }

        @Override // com.applovin.impl.wq
        public void b(String str, long j11, long j12) {
            ck.this.f18208i.b(str, j11, j12);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b(boolean z11) {
            c20.n(this, z11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b(boolean z11, int i11) {
            c20.o(this, z11, i11);
        }

        @Override // com.applovin.impl.m1.b
        public void c() {
            ck.this.a(false, -1, 3);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void c(int i11) {
            c20.p(this, i11);
        }

        @Override // com.applovin.impl.q1
        public void c(n5 n5Var) {
            ck.this.f18208i.c(n5Var);
            ck.this.f18216q = null;
            ck.this.D = null;
        }

        @Override // com.applovin.impl.q1
        public void c(Exception exc) {
            ck.this.f18208i.c(exc);
        }

        @Override // com.applovin.impl.qh.c
        public void c(boolean z11) {
            ck.k(ck.this);
        }

        @Override // com.applovin.impl.il.b
        public void d(int i11) {
            r6 r6VarB = ck.b(ck.this.f18211l);
            if (r6VarB.equals(ck.this.N)) {
                return;
            }
            ck.this.N = r6VarB;
            Iterator it = ck.this.f18207h.iterator();
            while (it.hasNext()) {
                ((qh.e) it.next()).a(r6VarB);
            }
        }

        @Override // com.applovin.impl.wq
        public void d(n5 n5Var) {
            ck.this.C = n5Var;
            ck.this.f18208i.d(n5Var);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void d(boolean z11) {
            c20.r(this, z11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void e(int i11) {
            c20.s(this, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void e(boolean z11) {
            c20.t(this, z11);
        }

        @Override // com.applovin.impl.o1.b
        public void f(int i11) {
            boolean zL = ck.this.l();
            ck.this.a(zL, i11, ck.b(zL, i11));
        }

        @Override // com.applovin.impl.b8
        public /* synthetic */ void f(boolean z11) {
            gt.a(this, z11);
        }

        @Override // com.applovin.impl.b8
        public void g(boolean z11) {
            ck.this.Y();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            ck.this.a(surfaceTexture);
            ck.this.a(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ck.this.a((Object) null);
            ck.this.a(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            ck.this.a(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            ck.this.a(i12, i13);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (ck.this.f18222w) {
                ck.this.a(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (ck.this.f18222w) {
                ck.this.a((Object) null);
            }
            ck.this.a(0, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements uq, v2, rh.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private uq f18253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private v2 f18254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private uq f18255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private v2 f18256d;

        private d() {
        }

        @Override // com.applovin.impl.v2
        public void a() {
            v2 v2Var = this.f18256d;
            if (v2Var != null) {
                v2Var.a();
            }
            v2 v2Var2 = this.f18254b;
            if (v2Var2 != null) {
                v2Var2.a();
            }
        }

        @Override // com.applovin.impl.rh.b
        public void a(int i11, Object obj) {
            if (i11 == 7) {
                this.f18253a = (uq) obj;
                return;
            }
            if (i11 == 8) {
                this.f18254b = (v2) obj;
                return;
            }
            if (i11 != 10000) {
                return;
            }
            rk rkVar = (rk) obj;
            if (rkVar == null) {
                this.f18255c = null;
                this.f18256d = null;
            } else {
                this.f18255c = rkVar.getVideoFrameMetadataListener();
                this.f18256d = rkVar.getCameraMotionListener();
            }
        }

        @Override // com.applovin.impl.uq
        public void a(long j11, long j12, f9 f9Var, MediaFormat mediaFormat) {
            uq uqVar = this.f18255c;
            if (uqVar != null) {
                uqVar.a(j11, j12, f9Var, mediaFormat);
            }
            uq uqVar2 = this.f18253a;
            if (uqVar2 != null) {
                uqVar2.a(j11, j12, f9Var, mediaFormat);
            }
        }

        @Override // com.applovin.impl.v2
        public void a(long j11, float[] fArr) {
            v2 v2Var = this.f18256d;
            if (v2Var != null) {
                v2Var.a(j11, fArr);
            }
            v2 v2Var2 = this.f18254b;
            if (v2Var2 != null) {
                v2Var2.a(j11, fArr);
            }
        }
    }

    public ck(b bVar) throws Throwable {
        ck ckVar;
        c4 c4Var = new c4();
        this.f18202c = c4Var;
        try {
            Context applicationContext = bVar.f18226a.getApplicationContext();
            this.f18203d = applicationContext;
            r0 r0Var = bVar.f18234i;
            this.f18208i = r0Var;
            b.m(bVar);
            this.F = bVar.f18236k;
            this.f18224y = bVar.f18241p;
            this.f18225z = bVar.f18242q;
            this.H = bVar.f18240o;
            this.f18214o = bVar.f18249x;
            c cVar = new c();
            this.f18205f = cVar;
            d dVar = new d();
            this.f18206g = dVar;
            this.f18207h = new CopyOnWriteArraySet();
            Handler handler = new Handler(bVar.f18235j);
            qi[] qiVarArrA = bVar.f18227b.a(handler, cVar, cVar, cVar, cVar);
            this.f18201b = qiVarArrA;
            this.G = 1.0f;
            if (xp.f24372a < 21) {
                this.E = d(0);
            } else {
                this.E = t2.a(applicationContext);
            }
            this.I = Collections.emptyList();
            this.J = true;
            try {
                c8 c8Var = new c8(qiVarArrA, bVar.f18230e, bVar.f18231f, bVar.f18232g, bVar.f18233h, r0Var, bVar.f18243r, bVar.f18244s, bVar.f18245t, bVar.f18246u, bVar.f18247v, bVar.f18248w, bVar.f18250y, bVar.f18228c, bVar.f18235j, this, new qh.b.a().a(20, 21, 22, 23, 24, 25, 26, 27).a());
                ckVar = this;
                try {
                    ckVar.f18204e = c8Var;
                    c8Var.a((qh.c) cVar);
                    c8Var.a((b8) cVar);
                    if (bVar.f18229d > 0) {
                        c8Var.c(bVar.f18229d);
                    }
                    m1 m1Var = new m1(bVar.f18226a, handler, cVar);
                    ckVar.f18209j = m1Var;
                    m1Var.a(bVar.f18239n);
                    o1 o1Var = new o1(bVar.f18226a, handler, cVar);
                    ckVar.f18210k = o1Var;
                    o1Var.b(bVar.f18237l ? ckVar.F : null);
                    il ilVar = new il(bVar.f18226a, handler, cVar);
                    ckVar.f18211l = ilVar;
                    ilVar.a(xp.e(ckVar.F.f20316c));
                    gr grVar = new gr(bVar.f18226a);
                    ckVar.f18212m = grVar;
                    grVar.a(bVar.f18238m != 0);
                    cs csVar = new cs(bVar.f18226a);
                    ckVar.f18213n = csVar;
                    csVar.a(bVar.f18238m == 2);
                    ckVar.N = b(ilVar);
                    ckVar.O = xq.f24387f;
                    ckVar.a(1, 10, Integer.valueOf(ckVar.E));
                    ckVar.a(2, 10, Integer.valueOf(ckVar.E));
                    ckVar.a(1, 3, ckVar.F);
                    ckVar.a(2, 4, Integer.valueOf(ckVar.f18224y));
                    ckVar.a(2, 5, Integer.valueOf(ckVar.f18225z));
                    ckVar.a(1, 9, Boolean.valueOf(ckVar.H));
                    ckVar.a(2, 7, dVar);
                    ckVar.a(6, 8, dVar);
                    c4Var.e();
                } catch (Throwable th2) {
                    th = th2;
                    ckVar.f18202c.e();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                ckVar = this;
            }
        } catch (Throwable th4) {
            th = th4;
            ckVar = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.f18208i.a(this.H);
        Iterator it = this.f18207h.iterator();
        while (it.hasNext()) {
            ((qh.e) it.next()).a(this.H);
        }
    }

    private void W() {
        if (this.f18221v != null) {
            this.f18204e.a(this.f18206g).a(10000).a((Object) null).j();
            this.f18221v.b(this.f18205f);
            this.f18221v = null;
        }
        TextureView textureView = this.f18223x;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f18205f) {
                pc.d("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f18223x.setSurfaceTextureListener(null);
            }
            this.f18223x = null;
        }
        SurfaceHolder surfaceHolder = this.f18220u;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f18205f);
            this.f18220u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        a(1, 2, Float.valueOf(this.G * this.f18210k.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        int iO = o();
        if (iO != 1) {
            if (iO == 2 || iO == 3) {
                this.f18212m.b(l() && !S());
                this.f18213n.b(l());
                return;
            } else if (iO != 4) {
                throw new IllegalStateException();
            }
        }
        this.f18212m.b(false);
        this.f18213n.b(false);
    }

    private void Z() {
        this.f18202c.b();
        if (Thread.currentThread() != p().getThread()) {
            String strA = xp.a("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), p().getThread().getName());
            if (this.J) {
                throw new IllegalStateException(strA);
            }
            pc.c("SimpleExoPlayer", strA, this.K ? null : new IllegalStateException());
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, int i12) {
        if (i11 == this.A && i12 == this.B) {
            return;
        }
        this.A = i11;
        this.B = i12;
        this.f18208i.a(i11, i12);
        Iterator it = this.f18207h.iterator();
        while (it.hasNext()) {
            ((qh.e) it.next()).a(i11, i12);
        }
    }

    private void a(int i11, int i12, Object obj) {
        for (qi qiVar : this.f18201b) {
            if (qiVar.e() == i11) {
                this.f18204e.a(qiVar).a(i12).a(obj).j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        a(surface);
        this.f18219t = surface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        qi[] qiVarArr = this.f18201b;
        int length = qiVarArr.length;
        int i11 = 0;
        while (true) {
            z11 = true;
            if (i11 >= length) {
                break;
            }
            qi qiVar = qiVarArr[i11];
            if (qiVar.e() == 2) {
                arrayList.add(this.f18204e.a(qiVar).a(1).a(obj).j());
            }
            i11++;
        }
        Object obj2 = this.f18218s;
        if (obj2 == null || obj2 == obj) {
            z11 = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((rh) it.next()).a(this.f18214o);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z11 = false;
            Object obj3 = this.f18218s;
            Surface surface = this.f18219t;
            if (obj3 == surface) {
                surface.release();
                this.f18219t = null;
            }
        }
        this.f18218s = obj;
        if (z11) {
            this.f18204e.a(false, a8.a(new g8(3), 1003));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z11, int i11, int i12) {
        int i13 = 0;
        boolean z12 = z11 && i11 != -1;
        if (z12 && i11 != 1) {
            i13 = 1;
        }
        this.f18204e.a(z12, i13, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(boolean z11, int i11) {
        return (!z11 || i11 == 1) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r6 b(il ilVar) {
        return new r6(0, ilVar.b(), ilVar.a());
    }

    private void b(SurfaceHolder surfaceHolder) {
        this.f18222w = false;
        this.f18220u = surfaceHolder;
        surfaceHolder.addCallback(this.f18205f);
        Surface surface = this.f18220u.getSurface();
        if (surface == null || !surface.isValid()) {
            a(0, 0);
        } else {
            Rect surfaceFrame = this.f18220u.getSurfaceFrame();
            a(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    private int d(int i11) {
        AudioTrack audioTrack = this.f18217r;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i11) {
            this.f18217r.release();
            this.f18217r = null;
        }
        if (this.f18217r == null) {
            this.f18217r = new AudioTrack(3, 4000, 4, 2, 2, 0, i11);
        }
        return this.f18217r.getAudioSessionId();
    }

    public static /* synthetic */ uh k(ck ckVar) {
        ckVar.getClass();
        return null;
    }

    @Override // com.applovin.impl.qh
    public to A() {
        Z();
        return this.f18204e.A();
    }

    @Override // com.applovin.impl.qh
    public vd C() {
        return this.f18204e.C();
    }

    @Override // com.applovin.impl.qh
    public int E() {
        Z();
        return this.f18204e.E();
    }

    @Override // com.applovin.impl.qh
    public long F() {
        Z();
        return this.f18204e.F();
    }

    public void R() {
        Z();
        W();
        a((Object) null);
        a(0, 0);
    }

    public boolean S() {
        Z();
        return this.f18204e.S();
    }

    @Override // com.applovin.impl.qh
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public a8 c() {
        Z();
        return this.f18204e.c();
    }

    public void V() {
        AudioTrack audioTrack;
        Z();
        if (xp.f24372a < 21 && (audioTrack = this.f18217r) != null) {
            audioTrack.release();
            this.f18217r = null;
        }
        this.f18209j.a(false);
        this.f18211l.c();
        this.f18212m.b(false);
        this.f18213n.b(false);
        this.f18210k.e();
        this.f18204e.W();
        this.f18208i.i();
        W();
        Surface surface = this.f18219t;
        if (surface != null) {
            surface.release();
            this.f18219t = null;
        }
        if (this.L) {
            d8.a(b1.a((Object) null));
            throw null;
        }
        this.I = Collections.emptyList();
        this.M = true;
    }

    @Override // com.applovin.impl.qh
    public ph a() {
        Z();
        return this.f18204e.a();
    }

    public void a(float f11) {
        Z();
        float fA = xp.a(f11, 0.0f, 1.0f);
        if (this.G == fA) {
            return;
        }
        this.G = fA;
        X();
        this.f18208i.a(fA);
        Iterator it = this.f18207h.iterator();
        while (it.hasNext()) {
            ((qh.e) it.next()).a(fA);
        }
    }

    @Override // com.applovin.impl.qh
    public void a(int i11) {
        Z();
        this.f18204e.a(i11);
    }

    @Override // com.applovin.impl.qh
    public void a(int i11, long j11) {
        Z();
        this.f18208i.h();
        this.f18204e.a(i11, j11);
    }

    public void a(SurfaceHolder surfaceHolder) {
        Z();
        if (surfaceHolder == null || surfaceHolder != this.f18220u) {
            return;
        }
        R();
    }

    @Override // com.applovin.impl.qh
    public void a(SurfaceView surfaceView) {
        Z();
        if (surfaceView instanceof tq) {
            W();
            a((Object) surfaceView);
            b(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof rk)) {
                c(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            W();
            this.f18221v = (rk) surfaceView;
            this.f18204e.a(this.f18206g).a(10000).a(this.f18221v).j();
            this.f18221v.a(this.f18205f);
            a(this.f18221v.getVideoSurface());
            b(surfaceView.getHolder());
        }
    }

    @Override // com.applovin.impl.qh
    public void a(TextureView textureView) {
        Z();
        if (textureView == null) {
            R();
            return;
        }
        W();
        this.f18223x = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            pc.d("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f18205f);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            a((Object) null);
            a(0, 0);
        } else {
            a(surfaceTexture);
            a(textureView.getWidth(), textureView.getHeight());
        }
    }

    public void a(be beVar) {
        Z();
        this.f18204e.a(beVar);
    }

    public void a(qh.c cVar) {
        b1.a(cVar);
        this.f18204e.a(cVar);
    }

    @Override // com.applovin.impl.qh
    public void a(qh.e eVar) {
        b1.a(eVar);
        this.f18207h.remove(eVar);
        b((qh.c) eVar);
    }

    @Override // com.applovin.impl.qh
    public void a(boolean z11) {
        Z();
        int iA = this.f18210k.a(z11, o());
        a(z11, iA, b(z11, iA));
    }

    @Override // com.applovin.impl.qh
    public void b() {
        Z();
        boolean zL = l();
        int iA = this.f18210k.a(zL, 2);
        a(zL, iA, b(zL, iA));
        this.f18204e.b();
    }

    @Override // com.applovin.impl.qh
    public void b(SurfaceView surfaceView) {
        Z();
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.applovin.impl.qh
    public void b(TextureView textureView) {
        Z();
        if (textureView == null || textureView != this.f18223x) {
            return;
        }
        R();
    }

    public void b(qh.c cVar) {
        this.f18204e.e(cVar);
    }

    @Override // com.applovin.impl.qh
    public void b(qh.e eVar) {
        b1.a(eVar);
        this.f18207h.add(eVar);
        a((qh.c) eVar);
    }

    @Override // com.applovin.impl.qh
    public void b(boolean z11) {
        Z();
        this.f18204e.b(z11);
    }

    public void c(SurfaceHolder surfaceHolder) {
        Z();
        if (surfaceHolder == null) {
            R();
            return;
        }
        W();
        this.f18222w = true;
        this.f18220u = surfaceHolder;
        surfaceHolder.addCallback(this.f18205f);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            a((Object) null);
            a(0, 0);
        } else {
            a(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            a(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // com.applovin.impl.qh
    public boolean d() {
        Z();
        return this.f18204e.d();
    }

    @Override // com.applovin.impl.qh
    public long e() {
        Z();
        return this.f18204e.e();
    }

    @Override // com.applovin.impl.qh
    public int f() {
        Z();
        return this.f18204e.f();
    }

    @Override // com.applovin.impl.qh
    public long g() {
        Z();
        return this.f18204e.g();
    }

    @Override // com.applovin.impl.qh
    public long getCurrentPosition() {
        Z();
        return this.f18204e.getCurrentPosition();
    }

    @Override // com.applovin.impl.qh
    public long getDuration() {
        Z();
        return this.f18204e.getDuration();
    }

    @Override // com.applovin.impl.qh
    public long h() {
        Z();
        return this.f18204e.h();
    }

    @Override // com.applovin.impl.qh
    public qh.b i() {
        Z();
        return this.f18204e.i();
    }

    @Override // com.applovin.impl.qh
    public int j() {
        Z();
        return this.f18204e.j();
    }

    @Override // com.applovin.impl.qh
    public po k() {
        Z();
        return this.f18204e.k();
    }

    @Override // com.applovin.impl.qh
    public boolean l() {
        Z();
        return this.f18204e.l();
    }

    @Override // com.applovin.impl.qh
    public int m() {
        Z();
        return this.f18204e.m();
    }

    @Override // com.applovin.impl.qh
    public fo n() {
        Z();
        return this.f18204e.n();
    }

    @Override // com.applovin.impl.qh
    public int o() {
        Z();
        return this.f18204e.o();
    }

    @Override // com.applovin.impl.qh
    public Looper p() {
        return this.f18204e.p();
    }

    @Override // com.applovin.impl.qh
    public long q() {
        Z();
        return this.f18204e.q();
    }

    @Override // com.applovin.impl.qh
    public boolean r() {
        Z();
        return this.f18204e.r();
    }

    @Override // com.applovin.impl.qh
    public long s() {
        Z();
        return this.f18204e.s();
    }

    @Override // com.applovin.impl.qh
    public int t() {
        Z();
        return this.f18204e.t();
    }

    @Override // com.applovin.impl.qh
    public int v() {
        Z();
        return this.f18204e.v();
    }

    @Override // com.applovin.impl.qh
    public List x() {
        Z();
        return this.I;
    }

    @Override // com.applovin.impl.qh
    public xq z() {
        return this.O;
    }
}
