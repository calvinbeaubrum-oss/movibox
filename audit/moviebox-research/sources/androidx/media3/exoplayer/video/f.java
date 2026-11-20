package androidx.media3.exoplayer.video;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.j0;
import androidx.media3.common.l0;
import androidx.media3.common.r0;
import androidx.media3.common.s0;
import androidx.media3.common.t0;
import androidx.media3.exoplayer.ExoPlaybackException;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements g0, s0.a, t.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Executor f11571q = new Executor() { // from class: androidx.media3.exoplayer.video.c
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            f.B(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0.a f11573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z3.d f11574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f11575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f11576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.media3.common.y f11577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f11578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z3.j f11579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j0 f11580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f11581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<androidx.media3.common.p> f11582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public Pair<Surface, z3.e0> f11583l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VideoSink.a f11584m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Executor f11585n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11586o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11587p;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f11588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r0.a f11589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j0.a f11590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11591d;

        public b(Context context) {
            this.f11588a = context;
        }

        public f c() {
            z3.a.g(!this.f11591d);
            if (this.f11590c == null) {
                if (this.f11589b == null) {
                    this.f11589b = new c();
                }
                this.f11590c = new d(this.f11589b);
            }
            f fVar = new f(this);
            this.f11591d = true;
            return fVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements r0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.google.common.base.q<r0.a> f11592a = Suppliers.a(new com.google.common.base.q() { // from class: androidx.media3.exoplayer.video.g
            @Override // com.google.common.base.q
            /* JADX INFO: renamed from: get */
            public final Object get2() {
                return f.c.b();
            }
        });

        public c() {
        }

        public static /* synthetic */ r0.a b() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                return (r0.a) z3.a.e(cls.getMethod("build", new Class[0]).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]));
            } catch (Exception e11) {
                throw new IllegalStateException(e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements j0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.a f11593a;

        public d(r0.a aVar) {
            this.f11593a = aVar;
        }

        @Override // androidx.media3.common.j0.a
        public j0 a(Context context, androidx.media3.common.k kVar, androidx.media3.common.k kVar2, androidx.media3.common.n nVar, s0.a aVar, Executor executor, List<androidx.media3.common.p> list, long j11) throws VideoFrameProcessingException {
            try {
                Constructor<?> constructor = Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(r0.a.class);
                Object[] objArr = new Object[1];
                try {
                    objArr[0] = this.f11593a;
                    return ((j0.a) constructor.newInstance(objArr)).a(context, kVar, kVar2, nVar, aVar, executor, list, j11);
                } catch (Exception e11) {
                    e = e11;
                    throw VideoFrameProcessingException.from(e);
                }
            } catch (Exception e12) {
                e = e12;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements VideoSink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f11594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f11595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList<androidx.media3.common.p> f11597d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public androidx.media3.common.p f11598e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public androidx.media3.common.y f11599f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11600g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f11601h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f11602i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f11603j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f11604k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f11605l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f11606m;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static Constructor<?> f11607a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static Method f11608b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static Method f11609c;

            public static androidx.media3.common.p a(float f11) {
                try {
                    b();
                    Object objNewInstance = f11607a.newInstance(new Object[0]);
                    f11608b.invoke(objNewInstance, Float.valueOf(f11));
                    return (androidx.media3.common.p) z3.a.e(f11609c.invoke(objNewInstance, new Object[0]));
                } catch (Exception e11) {
                    throw new IllegalStateException(e11);
                }
            }

            public static void b() throws NoSuchMethodException, ClassNotFoundException {
                if (f11607a == null || f11608b == null || f11609c == null) {
                    Class<?> cls = Class.forName("androidx.media3.effect.ScaleAndRotateTransformation$Builder");
                    f11607a = cls.getConstructor(new Class[0]);
                    f11608b = cls.getMethod("setRotationDegrees", Float.TYPE);
                    f11609c = cls.getMethod("build", new Class[0]);
                }
            }
        }

        public e(Context context, f fVar, j0 j0Var) throws VideoFrameProcessingException {
            this.f11594a = context;
            this.f11595b = fVar;
            this.f11596c = u0.g0(context);
            j0Var.a(j0Var.d());
            this.f11597d = new ArrayList<>();
            this.f11603j = C.TIME_UNSET;
            this.f11604k = C.TIME_UNSET;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public long a(long j11, boolean z11) {
            z3.a.g(this.f11596c != -1);
            long j12 = this.f11606m;
            if (j12 != C.TIME_UNSET) {
                if (!this.f11595b.w(j12)) {
                    return C.TIME_UNSET;
                }
                f();
                this.f11606m = C.TIME_UNSET;
            }
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void b(int i11, androidx.media3.common.y yVar) {
            int i12;
            androidx.media3.common.y yVar2;
            if (i11 != 1 && i11 != 2) {
                throw new UnsupportedOperationException("Unsupported input type " + i11);
            }
            if (i11 != 1 || u0.f81838a >= 21 || (i12 = yVar.f9509u) == -1 || i12 == 0) {
                this.f11598e = null;
            } else if (this.f11598e == null || (yVar2 = this.f11599f) == null || yVar2.f9509u != i12) {
                this.f11598e = a.a(i12);
            }
            this.f11600g = i11;
            this.f11599f = yVar;
            if (this.f11605l) {
                z3.a.g(this.f11604k != C.TIME_UNSET);
                this.f11606m = this.f11604k;
            } else {
                f();
                this.f11605l = true;
                this.f11606m = C.TIME_UNSET;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean c() {
            return u0.J0(this.f11594a);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public Surface d() {
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void e(VideoSink.a aVar, Executor executor) {
            this.f11595b.E(aVar, executor);
        }

        public final void f() {
            if (this.f11599f == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            androidx.media3.common.p pVar = this.f11598e;
            if (pVar != null) {
                arrayList.add(pVar);
            }
            arrayList.addAll(this.f11597d);
            androidx.media3.common.y yVar = (androidx.media3.common.y) z3.a.e(this.f11599f);
            new androidx.media3.common.z.b(f.v(yVar.f9513y), yVar.f9506r, yVar.f9507s).b(yVar.f9510v).a();
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void flush() {
            throw null;
        }

        public void g(List<androidx.media3.common.p> list) {
            this.f11597d.clear();
            this.f11597d.addAll(list);
        }

        public void h(long j11) {
            this.f11602i = this.f11601h != j11;
            this.f11601h = j11;
        }

        public void i(List<androidx.media3.common.p> list) {
            g(list);
            f();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isEnded() {
            long j11 = this.f11603j;
            return j11 != C.TIME_UNSET && this.f11595b.w(j11);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isReady() {
            return this.f11595b.x();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void render(long j11, long j12) throws VideoSink.VideoSinkException {
            try {
                this.f11595b.D(j11, j12);
            } catch (ExoPlaybackException e11) {
                androidx.media3.common.y yVarI = this.f11599f;
                if (yVarI == null) {
                    yVarI = new androidx.media3.common.y.b().I();
                }
                throw new VideoSink.VideoSinkException(e11, yVarI);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void setPlaybackSpeed(float f11) {
            this.f11595b.F(f11);
        }
    }

    public f(b bVar) {
        this.f11572a = bVar.f11588a;
        this.f11573b = (j0.a) z3.a.i(bVar.f11590c);
        this.f11574c = z3.d.f81767a;
        this.f11584m = VideoSink.a.f11549a;
        this.f11585n = f11571q;
        this.f11587p = 0;
    }

    public static /* synthetic */ void B(Runnable runnable) {
    }

    public static androidx.media3.common.k v(@Nullable androidx.media3.common.k kVar) {
        return (kVar == null || !androidx.media3.common.k.j(kVar)) ? androidx.media3.common.k.f9256h : kVar;
    }

    public final void C(@Nullable Surface surface, int i11, int i12) {
        if (this.f11580i != null) {
            this.f11580i.c(surface != null ? new l0(surface, i11, i12) : null);
            ((p) z3.a.e(this.f11575d)).q(surface);
        }
    }

    public void D(long j11, long j12) throws ExoPlaybackException {
        if (this.f11586o == 0) {
            ((t) z3.a.i(this.f11576e)).f(j11, j12);
        }
    }

    public final void E(VideoSink.a aVar, Executor executor) {
        if (Objects.equals(aVar, this.f11584m)) {
            z3.a.g(Objects.equals(executor, this.f11585n));
        } else {
            this.f11584m = aVar;
            this.f11585n = executor;
        }
    }

    public final void F(float f11) {
        ((t) z3.a.i(this.f11576e)).h(f11);
    }

    @Override // androidx.media3.exoplayer.video.g0
    public void a(p pVar) {
        z3.a.g(!isInitialized());
        this.f11575d = pVar;
        this.f11576e = new t(this, pVar);
    }

    @Override // androidx.media3.exoplayer.video.t.a
    public void b() {
        final VideoSink.a aVar = this.f11584m;
        this.f11585n.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f11564a.y(aVar);
            }
        });
        ((j0) z3.a.i(this.f11580i)).b(-2L);
    }

    @Override // androidx.media3.exoplayer.video.g0
    public void c(o oVar) {
        this.f11578g = oVar;
    }

    @Override // androidx.media3.exoplayer.video.g0
    public void d(z3.d dVar) {
        z3.a.g(!isInitialized());
        this.f11574c = dVar;
    }

    @Override // androidx.media3.exoplayer.video.g0
    public void e(List<androidx.media3.common.p> list) {
        this.f11582k = list;
        if (isInitialized()) {
            ((e) z3.a.i(this.f11581j)).i(list);
        }
    }

    @Override // androidx.media3.exoplayer.video.g0
    @Nullable
    public p f() {
        return this.f11575d;
    }

    @Override // androidx.media3.exoplayer.video.g0
    public void g(androidx.media3.common.y yVar) throws VideoSink.VideoSinkException {
        boolean z11 = false;
        z3.a.g(this.f11587p == 0);
        z3.a.i(this.f11582k);
        if (this.f11576e != null && this.f11575d != null) {
            z11 = true;
        }
        z3.a.g(z11);
        this.f11579h = this.f11574c.createHandler((Looper) z3.a.i(Looper.myLooper()), null);
        androidx.media3.common.k kVarV = v(yVar.f9513y);
        androidx.media3.common.k kVarA = kVarV.f9267c == 7 ? kVarV.a().e(6).a() : kVarV;
        try {
            j0.a aVar = this.f11573b;
            Context context = this.f11572a;
            androidx.media3.common.n nVar = androidx.media3.common.n.f9326a;
            final z3.j jVar = this.f11579h;
            Objects.requireNonNull(jVar);
            this.f11580i = aVar.a(context, kVarV, kVarA, nVar, this, new Executor() { // from class: androidx.media3.exoplayer.video.e
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    jVar.post(runnable);
                }
            }, ImmutableList.of(), 0L);
            Pair<Surface, z3.e0> pair = this.f11583l;
            if (pair != null) {
                Surface surface = (Surface) pair.first;
                z3.e0 e0Var = (z3.e0) pair.second;
                C(surface, e0Var.b(), e0Var.a());
            }
            e eVar = new e(this.f11572a, this, this.f11580i);
            this.f11581j = eVar;
            eVar.i((List) z3.a.e(this.f11582k));
            this.f11587p = 1;
        } catch (VideoFrameProcessingException e11) {
            throw new VideoSink.VideoSinkException(e11, yVar);
        }
    }

    @Override // androidx.media3.exoplayer.video.t.a
    public void h(long j11, long j12, long j13, boolean z11) {
        if (z11 && this.f11585n != f11571q) {
            final e eVar = (e) z3.a.i(this.f11581j);
            final VideoSink.a aVar = this.f11584m;
            this.f11585n.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.b
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(eVar);
                }
            });
        }
        if (this.f11578g != null) {
            androidx.media3.common.y yVarI = this.f11577f;
            if (yVarI == null) {
                yVarI = new androidx.media3.common.y.b().I();
            }
            this.f11578g.e(j12 - j13, this.f11574c.nanoTime(), yVarI, null);
        }
        ((j0) z3.a.i(this.f11580i)).b(j11);
    }

    @Override // androidx.media3.exoplayer.video.g0
    public void i() {
        z3.e0 e0Var = z3.e0.f81770c;
        C(null, e0Var.b(), e0Var.a());
        this.f11583l = null;
    }

    @Override // androidx.media3.exoplayer.video.g0
    public boolean isInitialized() {
        return this.f11587p == 1;
    }

    @Override // androidx.media3.exoplayer.video.g0
    public void j(Surface surface, z3.e0 e0Var) {
        Pair<Surface, z3.e0> pair = this.f11583l;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((z3.e0) this.f11583l.second).equals(e0Var)) {
            return;
        }
        this.f11583l = Pair.create(surface, e0Var);
        C(surface, e0Var.b(), e0Var.a());
    }

    @Override // androidx.media3.exoplayer.video.g0
    public VideoSink k() {
        return (VideoSink) z3.a.i(this.f11581j);
    }

    @Override // androidx.media3.exoplayer.video.g0
    public void l(long j11) {
        ((e) z3.a.i(this.f11581j)).h(j11);
    }

    @Override // androidx.media3.exoplayer.video.t.a
    public void onVideoSizeChanged(final t0 t0Var) {
        this.f11577f = new androidx.media3.common.y.b().r0(t0Var.f9449a).V(t0Var.f9450b).k0("video/raw").I();
        final e eVar = (e) z3.a.i(this.f11581j);
        final VideoSink.a aVar = this.f11584m;
        this.f11585n.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.a
            @Override // java.lang.Runnable
            public final void run() {
                aVar.b(eVar, t0Var);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.g0
    public void release() {
        if (this.f11587p == 2) {
            return;
        }
        z3.j jVar = this.f11579h;
        if (jVar != null) {
            jVar.removeCallbacksAndMessages(null);
        }
        j0 j0Var = this.f11580i;
        if (j0Var != null) {
            j0Var.release();
        }
        this.f11583l = null;
        this.f11587p = 2;
    }

    public final boolean w(long j11) {
        return this.f11586o == 0 && ((t) z3.a.i(this.f11576e)).b(j11);
    }

    public final boolean x() {
        return this.f11586o == 0 && ((t) z3.a.i(this.f11576e)).c();
    }

    public final /* synthetic */ void y(VideoSink.a aVar) {
        aVar.c((VideoSink) z3.a.i(this.f11581j));
    }
}
