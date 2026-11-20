package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class x0 extends com.google.android.exoplayer2.d implements p {
    public final com.google.android.exoplayer2.c A;
    public final e3 B;
    public final p3 C;
    public final q3 D;
    public final long E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public boolean J;
    public int K;
    public b3 L;
    public nh.e0 M;
    public boolean N;
    public n2.b O;
    public z1 P;
    public z1 Q;

    @Nullable
    public m1 R;

    @Nullable
    public m1 S;

    @Nullable
    public AudioTrack T;

    @Nullable
    public Object U;

    @Nullable
    public Surface V;

    @Nullable
    public SurfaceHolder W;

    @Nullable
    public SphericalGLSurfaceView X;
    public boolean Y;

    @Nullable
    public TextureView Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f35868a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fi.c0 f35869b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f35870b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n2.b f35871c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f35872c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.h f35873d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f35874d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f35875e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.decoder.e f35876e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n2 f35877f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.decoder.e f35878f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w2[] f35879g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f35880g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final fi.b0 f35881h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public com.google.android.exoplayer2.audio.e f35882h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.o f35883i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f35884i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j1.f f35885j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f35886j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j1 f35887k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public vh.f f35888k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.r<n2.d> f35889l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f35890l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArraySet<p.a> f35891m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f35892m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j3.b f35893n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    @Nullable
    public PriorityTaskManager f35894n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<e> f35895o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f35896o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f35897p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f35898p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.i.a f35899q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public n f35900q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final qg.a f35901r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public com.google.android.exoplayer2.video.y f35902r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Looper f35903s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public z1 f35904s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.e f35905t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public k2 f35906t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f35907u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f35908u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f35909v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f35910v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.e f35911w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public long f35912w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f35913x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f35914y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AudioBecomingNoisyManager f35915z;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class b {
        public static qg.u1 a(Context context, x0 x0Var, boolean z11) {
            qg.s1 s1VarB0 = qg.s1.B0(context);
            if (s1VarB0 == null) {
                com.google.android.exoplayer2.util.s.i("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new qg.u1(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z11) {
                x0Var.P0(s1VarB0);
            }
            return new qg.u1(s1VarB0.I0());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements com.google.android.exoplayer2.video.w, com.google.android.exoplayer2.audio.r, vh.o, gh.e, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, com.google.android.exoplayer2.c.b, AudioBecomingNoisyManager.a, e3.b, p.a {
        public c() {
        }

        public final /* synthetic */ void J(n2.d dVar) {
            dVar.onMediaMetadataChanged(x0.this.P);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void a(Exception exc) {
            x0.this.f35901r.a(exc);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void b(String str) {
            x0.this.f35901r.b(str);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void c(String str) {
            x0.this.f35901r.c(str);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void d(long j11) {
            x0.this.f35901r.d(j11);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void e(Exception exc) {
            x0.this.f35901r.e(exc);
        }

        @Override // com.google.android.exoplayer2.e3.b
        public void f(int i11) {
            final n nVarU0 = x0.U0(x0.this.B);
            if (nVarU0.equals(x0.this.f35900q0)) {
                return;
            }
            x0.this.f35900q0 = nVarU0;
            x0.this.f35889l.l(29, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.b1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onDeviceInfoChanged(nVarU0);
                }
            });
        }

        @Override // com.google.android.exoplayer2.video.w
        public void g(Object obj, long j11) {
            x0.this.f35901r.g(obj, j11);
            if (x0.this.U == obj) {
                x0.this.f35889l.l(26, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.e1
                    @Override // com.google.android.exoplayer2.util.r.a
                    public final void invoke(Object obj2) {
                        ((n2.d) obj2).onRenderedFirstFrame();
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void h(Exception exc) {
            x0.this.f35901r.h(exc);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void i(int i11, long j11, long j12) {
            x0.this.f35901r.i(i11, j11, j12);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void j(long j11, int i11) {
            x0.this.f35901r.j(j11, i11);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void k(com.google.android.exoplayer2.decoder.e eVar) {
            x0.this.f35878f0 = eVar;
            x0.this.f35901r.k(eVar);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void l(m1 m1Var, @Nullable com.google.android.exoplayer2.decoder.g gVar) {
            x0.this.R = m1Var;
            x0.this.f35901r.l(m1Var, gVar);
        }

        @Override // com.google.android.exoplayer2.AudioBecomingNoisyManager.a
        public void m() {
            x0.this.c2(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void n(com.google.android.exoplayer2.decoder.e eVar) {
            x0.this.f35901r.n(eVar);
            x0.this.R = null;
            x0.this.f35876e0 = null;
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void o(com.google.android.exoplayer2.decoder.e eVar) {
            x0.this.f35901r.o(eVar);
            x0.this.S = null;
            x0.this.f35878f0 = null;
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void onAudioDecoderInitialized(String str, long j11, long j12) {
            x0.this.f35901r.onAudioDecoderInitialized(str, j11, j12);
        }

        @Override // vh.o
        public void onCues(final List<vh.b> list) {
            x0.this.f35889l.l(27, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.a1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onCues((List<vh.b>) list);
                }
            });
        }

        @Override // vh.o
        public void onCues(final vh.f fVar) {
            x0.this.f35888k0 = fVar;
            x0.this.f35889l.l(27, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.d1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onCues(fVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.video.w
        public void onDroppedFrames(int i11, long j11) {
            x0.this.f35901r.onDroppedFrames(i11, j11);
        }

        @Override // gh.e
        public void onMetadata(final Metadata metadata) {
            x0 x0Var = x0.this;
            x0Var.f35904s0 = x0Var.f35904s0.b().I(metadata).F();
            z1 z1VarS0 = x0.this.S0();
            if (!z1VarS0.equals(x0.this.P)) {
                x0.this.P = z1VarS0;
                x0.this.f35889l.i(14, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.y0
                    @Override // com.google.android.exoplayer2.util.r.a
                    public final void invoke(Object obj) {
                        this.f35925a.J((n2.d) obj);
                    }
                });
            }
            x0.this.f35889l.i(28, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.z0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onMetadata(metadata);
                }
            });
            x0.this.f35889l.f();
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void onSkipSilenceEnabledChanged(final boolean z11) {
            if (x0.this.f35886j0 == z11) {
                return;
            }
            x0.this.f35886j0 = z11;
            x0.this.f35889l.l(23, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.g1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onSkipSilenceEnabledChanged(z11);
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            x0.this.W1(surfaceTexture);
            x0.this.L1(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            x0.this.X1(null);
            x0.this.L1(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            x0.this.L1(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.video.w
        public void onVideoDecoderInitialized(String str, long j11, long j12) {
            x0.this.f35901r.onVideoDecoderInitialized(str, j11, j12);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void onVideoSizeChanged(final com.google.android.exoplayer2.video.y yVar) {
            x0.this.f35902r0 = yVar;
            x0.this.f35889l.l(25, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.f1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onVideoSizeChanged(yVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void p(Surface surface) {
            x0.this.X1(null);
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void q(Surface surface) {
            x0.this.X1(surface);
        }

        @Override // com.google.android.exoplayer2.e3.b
        public void r(final int i11, final boolean z11) {
            x0.this.f35889l.l(30, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.c1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onDeviceVolumeChanged(i11, z11);
                }
            });
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void s(m1 m1Var, @Nullable com.google.android.exoplayer2.decoder.g gVar) {
            x0.this.S = m1Var;
            x0.this.f35901r.s(m1Var, gVar);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            x0.this.L1(i12, i13);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (x0.this.Y) {
                x0.this.X1(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (x0.this.Y) {
                x0.this.X1(null);
            }
            x0.this.L1(0, 0);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void t(com.google.android.exoplayer2.decoder.e eVar) {
            x0.this.f35876e0 = eVar;
            x0.this.f35901r.t(eVar);
        }

        @Override // com.google.android.exoplayer2.c.b
        public void u(float f11) {
            x0.this.R1();
        }

        @Override // com.google.android.exoplayer2.c.b
        public void v(int i11) {
            boolean playWhenReady = x0.this.getPlayWhenReady();
            x0.this.c2(playWhenReady, i11, x0.d1(playWhenReady, i11));
        }

        @Override // com.google.android.exoplayer2.video.w
        public /* synthetic */ void w(m1 m1Var) {
            com.google.android.exoplayer2.video.l.a(this, m1Var);
        }

        @Override // com.google.android.exoplayer2.p.a
        public void x(boolean z11) {
            x0.this.f2();
        }

        @Override // com.google.android.exoplayer2.audio.r
        public /* synthetic */ void y(m1 m1Var) {
            com.google.android.exoplayer2.audio.g.a(this, m1Var);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements com.google.android.exoplayer2.video.i, gi.a, r2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.video.i f35917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public gi.a f35918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.video.i f35919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public gi.a f35920d;

        public d() {
        }

        @Override // gi.a
        public void a(long j11, float[] fArr) {
            gi.a aVar = this.f35920d;
            if (aVar != null) {
                aVar.a(j11, fArr);
            }
            gi.a aVar2 = this.f35918b;
            if (aVar2 != null) {
                aVar2.a(j11, fArr);
            }
        }

        @Override // gi.a
        public void b() {
            gi.a aVar = this.f35920d;
            if (aVar != null) {
                aVar.b();
            }
            gi.a aVar2 = this.f35918b;
            if (aVar2 != null) {
                aVar2.b();
            }
        }

        @Override // com.google.android.exoplayer2.video.i
        public void e(long j11, long j12, m1 m1Var, @Nullable MediaFormat mediaFormat) {
            com.google.android.exoplayer2.video.i iVar = this.f35919c;
            if (iVar != null) {
                iVar.e(j11, j12, m1Var, mediaFormat);
            }
            com.google.android.exoplayer2.video.i iVar2 = this.f35917a;
            if (iVar2 != null) {
                iVar2.e(j11, j12, m1Var, mediaFormat);
            }
        }

        @Override // com.google.android.exoplayer2.r2.b
        public void handleMessage(int i11, @Nullable Object obj) {
            if (i11 == 7) {
                this.f35917a = (com.google.android.exoplayer2.video.i) obj;
                return;
            }
            if (i11 == 8) {
                this.f35918b = (gi.a) obj;
                return;
            }
            if (i11 != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.f35919c = null;
                this.f35920d = null;
            } else {
                this.f35919c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f35920d = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements e2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f35921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j3 f35922b;

        public e(Object obj, j3 j3Var) {
            this.f35921a = obj;
            this.f35922b = j3Var;
        }

        @Override // com.google.android.exoplayer2.e2
        public Object a() {
            return this.f35921a;
        }

        @Override // com.google.android.exoplayer2.e2
        public j3 b() {
            return this.f35922b;
        }
    }

    static {
        k1.a("goog.exo.exoplayer");
    }

    @SuppressLint({"HandlerLeak"})
    public x0(p.b bVar, @Nullable n2 n2Var) {
        com.google.android.exoplayer2.util.h hVar = new com.google.android.exoplayer2.util.h();
        this.f35873d = hVar;
        try {
            com.google.android.exoplayer2.util.s.f("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.1] [" + com.google.android.exoplayer2.util.o0.f35612e + "]");
            Context applicationContext = bVar.f33665a.getApplicationContext();
            this.f35875e = applicationContext;
            qg.a aVarApply = bVar.f33673i.apply(bVar.f33666b);
            this.f35901r = aVarApply;
            this.f35894n0 = bVar.f33675k;
            this.f35882h0 = bVar.f33676l;
            this.f35868a0 = bVar.f33681q;
            this.f35870b0 = bVar.f33682r;
            this.f35886j0 = bVar.f33680p;
            this.E = bVar.f33689y;
            c cVar = new c();
            this.f35913x = cVar;
            d dVar = new d();
            this.f35914y = dVar;
            Handler handler = new Handler(bVar.f33674j);
            w2[] w2VarArrA = bVar.f33668d.get2().a(handler, cVar, cVar, cVar, cVar);
            this.f35879g = w2VarArrA;
            com.google.android.exoplayer2.util.a.g(w2VarArrA.length > 0);
            fi.b0 b0Var = bVar.f33670f.get2();
            this.f35881h = b0Var;
            this.f35899q = bVar.f33669e.get2();
            com.google.android.exoplayer2.upstream.e eVar = bVar.f33672h.get2();
            this.f35905t = eVar;
            this.f35897p = bVar.f33683s;
            this.L = bVar.f33684t;
            this.f35907u = bVar.f33685u;
            this.f35909v = bVar.f33686v;
            this.N = bVar.f33690z;
            Looper looper = bVar.f33674j;
            this.f35903s = looper;
            com.google.android.exoplayer2.util.e eVar2 = bVar.f33666b;
            this.f35911w = eVar2;
            n2 n2Var2 = n2Var == null ? this : n2Var;
            this.f35877f = n2Var2;
            this.f35889l = new com.google.android.exoplayer2.util.r<>(looper, eVar2, new com.google.android.exoplayer2.util.r.b() { // from class: com.google.android.exoplayer2.j0
                @Override // com.google.android.exoplayer2.util.r.b
                public final void a(Object obj, com.google.android.exoplayer2.util.m mVar) {
                    this.f33304a.m1((n2.d) obj, mVar);
                }
            });
            this.f35891m = new CopyOnWriteArraySet<>();
            this.f35895o = new ArrayList();
            this.M = new nh.e0.a(0);
            fi.c0 c0Var = new fi.c0(new z2[w2VarArrA.length], new fi.s[w2VarArrA.length], o3.f33625b, null);
            this.f35869b = c0Var;
            this.f35893n = new j3.b();
            n2.b bVarE = new n2.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).d(29, b0Var.e()).e();
            this.f35871c = bVarE;
            this.O = new n2.b.a().b(bVarE).a(4).a(10).e();
            this.f35883i = eVar2.createHandler(looper, null);
            j1.f fVar = new j1.f() { // from class: com.google.android.exoplayer2.p0
                @Override // com.google.android.exoplayer2.j1.f
                public final void a(j1.e eVar3) {
                    this.f33691a.o1(eVar3);
                }
            };
            this.f35885j = fVar;
            this.f35906t0 = k2.j(c0Var);
            aVarApply.r(n2Var2, looper);
            int i11 = com.google.android.exoplayer2.util.o0.f35608a;
            j1 j1Var = new j1(w2VarArrA, b0Var, c0Var, bVar.f33671g.get2(), eVar, this.F, this.G, aVarApply, this.L, bVar.f33687w, bVar.f33688x, this.N, looper, eVar2, fVar, i11 < 31 ? new qg.u1() : b.a(applicationContext, this, bVar.A));
            this.f35887k = j1Var;
            this.f35884i0 = 1.0f;
            this.F = 0;
            z1 z1Var = z1.H;
            this.P = z1Var;
            this.Q = z1Var;
            this.f35904s0 = z1Var;
            this.f35908u0 = -1;
            if (i11 < 21) {
                this.f35880g0 = j1(0);
            } else {
                this.f35880g0 = com.google.android.exoplayer2.util.o0.F(applicationContext);
            }
            this.f35888k0 = vh.f.f78852b;
            this.f35890l0 = true;
            E(aVarApply);
            eVar.f(new Handler(looper), aVarApply);
            Q0(cVar);
            long j11 = bVar.f33667c;
            if (j11 > 0) {
                j1Var.s(j11);
            }
            AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(bVar.f33665a, handler, cVar);
            this.f35915z = audioBecomingNoisyManager;
            audioBecomingNoisyManager.b(bVar.f33679o);
            com.google.android.exoplayer2.c cVar2 = new com.google.android.exoplayer2.c(bVar.f33665a, handler, cVar);
            this.A = cVar2;
            cVar2.m(bVar.f33677m ? this.f35882h0 : null);
            e3 e3Var = new e3(bVar.f33665a, handler, cVar);
            this.B = e3Var;
            e3Var.h(com.google.android.exoplayer2.util.o0.g0(this.f35882h0.f32810c));
            p3 p3Var = new p3(bVar.f33665a);
            this.C = p3Var;
            p3Var.a(bVar.f33678n != 0);
            q3 q3Var = new q3(bVar.f33665a);
            this.D = q3Var;
            q3Var.a(bVar.f33678n == 2);
            this.f35900q0 = U0(e3Var);
            this.f35902r0 = com.google.android.exoplayer2.video.y.f35861f;
            b0Var.i(this.f35882h0);
            Q1(1, 10, Integer.valueOf(this.f35880g0));
            Q1(2, 10, Integer.valueOf(this.f35880g0));
            Q1(1, 3, this.f35882h0);
            Q1(2, 4, Integer.valueOf(this.f35868a0));
            Q1(2, 5, Integer.valueOf(this.f35870b0));
            Q1(1, 9, Boolean.valueOf(this.f35886j0));
            Q1(2, 7, dVar);
            Q1(6, 8, dVar);
            hVar.f();
        } catch (Throwable th2) {
            this.f35873d.f();
            throw th2;
        }
    }

    public static /* synthetic */ void A1(k2 k2Var, n2.d dVar) {
        dVar.onTracksChanged(k2Var.f33412i.f64965d);
    }

    public static /* synthetic */ void C1(k2 k2Var, n2.d dVar) {
        dVar.onLoadingChanged(k2Var.f33410g);
        dVar.onIsLoadingChanged(k2Var.f33410g);
    }

    public static /* synthetic */ void D1(k2 k2Var, n2.d dVar) {
        dVar.onPlayerStateChanged(k2Var.f33415l, k2Var.f33408e);
    }

    public static /* synthetic */ void E1(k2 k2Var, n2.d dVar) {
        dVar.onPlaybackStateChanged(k2Var.f33408e);
    }

    public static /* synthetic */ void F1(k2 k2Var, int i11, n2.d dVar) {
        dVar.onPlayWhenReadyChanged(k2Var.f33415l, i11);
    }

    public static /* synthetic */ void G1(k2 k2Var, n2.d dVar) {
        dVar.onPlaybackSuppressionReasonChanged(k2Var.f33416m);
    }

    public static /* synthetic */ void H1(k2 k2Var, n2.d dVar) {
        dVar.onIsPlayingChanged(k1(k2Var));
    }

    public static /* synthetic */ void I1(k2 k2Var, n2.d dVar) {
        dVar.onPlaybackParametersChanged(k2Var.f33417n);
    }

    public static n U0(e3 e3Var) {
        return new n(0, e3Var.d(), e3Var.c());
    }

    public static int d1(boolean z11, int i11) {
        return (!z11 || i11 == 1) ? 1 : 2;
    }

    public static long h1(k2 k2Var) {
        j3.d dVar = new j3.d();
        j3.b bVar = new j3.b();
        k2Var.f33404a.l(k2Var.f33405b.f71960a, bVar);
        return k2Var.f33406c == C.TIME_UNSET ? k2Var.f33404a.r(bVar.f33364c, dVar).f() : bVar.q() + k2Var.f33406c;
    }

    public static boolean k1(k2 k2Var) {
        return k2Var.f33408e == 3 && k2Var.f33415l && k2Var.f33416m == 0;
    }

    public static /* synthetic */ void p1(n2.d dVar) {
        dVar.onPlayerError(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }

    public static /* synthetic */ void v1(k2 k2Var, int i11, n2.d dVar) {
        dVar.onTimelineChanged(k2Var.f33404a, i11);
    }

    public static /* synthetic */ void w1(int i11, n2.e eVar, n2.e eVar2, n2.d dVar) {
        dVar.onPositionDiscontinuity(i11);
        dVar.onPositionDiscontinuity(eVar, eVar2, i11);
    }

    public static /* synthetic */ void y1(k2 k2Var, n2.d dVar) {
        dVar.onPlayerErrorChanged(k2Var.f33409f);
    }

    public static /* synthetic */ void z1(k2 k2Var, n2.d dVar) {
        dVar.onPlayerError(k2Var.f33409f);
    }

    @Override // com.google.android.exoplayer2.n2
    public void B(final fi.z zVar) {
        g2();
        if (!this.f35881h.e() || zVar.equals(this.f35881h.b())) {
            return;
        }
        this.f35881h.j(zVar);
        this.f35889l.l(19, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.n0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((n2.d) obj).onTrackSelectionParametersChanged(zVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2
    public void C(n2.d dVar) {
        com.google.android.exoplayer2.util.a.e(dVar);
        this.f35889l.k(dVar);
    }

    @Override // com.google.android.exoplayer2.n2
    public void E(n2.d dVar) {
        com.google.android.exoplayer2.util.a.e(dVar);
        this.f35889l.c(dVar);
    }

    public final k2 J1(k2 k2Var, j3 j3Var, @Nullable Pair<Object, Long> pair) {
        com.google.android.exoplayer2.util.a.a(j3Var.u() || pair != null);
        j3 j3Var2 = k2Var.f33404a;
        k2 k2VarI = k2Var.i(j3Var);
        if (j3Var.u()) {
            com.google.android.exoplayer2.source.i.b bVarK = k2.k();
            long jC0 = com.google.android.exoplayer2.util.o0.C0(this.f35912w0);
            k2 k2VarB = k2VarI.c(bVarK, jC0, jC0, jC0, 0L, nh.k0.f71939d, this.f35869b, ImmutableList.of()).b(bVarK);
            k2VarB.f33419p = k2VarB.f33421r;
            return k2VarB;
        }
        Object obj = k2VarI.f33405b.f71960a;
        boolean z11 = !obj.equals(((Pair) com.google.android.exoplayer2.util.o0.j(pair)).first);
        com.google.android.exoplayer2.source.i.b bVar = z11 ? new com.google.android.exoplayer2.source.i.b(pair.first) : k2VarI.f33405b;
        long jLongValue = ((Long) pair.second).longValue();
        long jC1 = com.google.android.exoplayer2.util.o0.C0(getContentPosition());
        if (!j3Var2.u()) {
            jC1 -= j3Var2.l(obj, this.f35893n).q();
        }
        if (z11 || jLongValue < jC1) {
            com.google.android.exoplayer2.util.a.g(!bVar.b());
            k2 k2VarB2 = k2VarI.c(bVar, jLongValue, jLongValue, jLongValue, 0L, z11 ? nh.k0.f71939d : k2VarI.f33411h, z11 ? this.f35869b : k2VarI.f33412i, z11 ? ImmutableList.of() : k2VarI.f33413j).b(bVar);
            k2VarB2.f33419p = jLongValue;
            return k2VarB2;
        }
        if (jLongValue == jC1) {
            int iF = j3Var.f(k2VarI.f33414k.f71960a);
            if (iF == -1 || j3Var.j(iF, this.f35893n).f33364c != j3Var.l(bVar.f71960a, this.f35893n).f33364c) {
                j3Var.l(bVar.f71960a, this.f35893n);
                long jE = bVar.b() ? this.f35893n.e(bVar.f71961b, bVar.f71962c) : this.f35893n.f33365d;
                k2VarI = k2VarI.c(bVar, k2VarI.f33421r, k2VarI.f33421r, k2VarI.f33407d, jE - k2VarI.f33421r, k2VarI.f33411h, k2VarI.f33412i, k2VarI.f33413j).b(bVar);
                k2VarI.f33419p = jE;
            }
        } else {
            com.google.android.exoplayer2.util.a.g(!bVar.b());
            long jMax = Math.max(0L, k2VarI.f33420q - (jLongValue - jC1));
            long j11 = k2VarI.f33419p;
            if (k2VarI.f33414k.equals(k2VarI.f33405b)) {
                j11 = jLongValue + jMax;
            }
            k2VarI = k2VarI.c(bVar, jLongValue, jLongValue, jLongValue, jMax, k2VarI.f33411h, k2VarI.f33412i, k2VarI.f33413j);
            k2VarI.f33419p = j11;
        }
        return k2VarI;
    }

    @Nullable
    public final Pair<Object, Long> K1(j3 j3Var, int i11, long j11) {
        if (j3Var.u()) {
            this.f35908u0 = i11;
            if (j11 == C.TIME_UNSET) {
                j11 = 0;
            }
            this.f35912w0 = j11;
            this.f35910v0 = 0;
            return null;
        }
        if (i11 == -1 || i11 >= j3Var.t()) {
            i11 = j3Var.e(this.G);
            j11 = j3Var.r(i11, this.f33010a).e();
        }
        return j3Var.n(this.f33010a, this.f35893n, i11, com.google.android.exoplayer2.util.o0.C0(j11));
    }

    public final void L1(final int i11, final int i12) {
        if (i11 == this.f35872c0 && i12 == this.f35874d0) {
            return;
        }
        this.f35872c0 = i11;
        this.f35874d0 = i12;
        this.f35889l.l(24, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.y
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((n2.d) obj).onSurfaceSizeChanged(i11, i12);
            }
        });
    }

    public final long M1(j3 j3Var, com.google.android.exoplayer2.source.i.b bVar, long j11) {
        j3Var.l(bVar.f71960a, this.f35893n);
        return j11 + this.f35893n.q();
    }

    public final k2 N1(int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0 && i12 >= i11 && i12 <= this.f35895o.size());
        int iU = u();
        j3 currentTimeline = getCurrentTimeline();
        int size = this.f35895o.size();
        this.H++;
        O1(i11, i12);
        j3 j3VarV0 = V0();
        k2 k2VarJ1 = J1(this.f35906t0, j3VarV0, c1(currentTimeline, j3VarV0));
        int i13 = k2VarJ1.f33408e;
        if (i13 != 1 && i13 != 4 && i11 < i12 && i12 == size && iU >= k2VarJ1.f33404a.t()) {
            k2VarJ1 = k2VarJ1.g(4);
        }
        this.f35887k.l0(i11, i12, this.M);
        return k2VarJ1;
    }

    public final void O1(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            this.f35895o.remove(i13);
        }
        this.M = this.M.a(i11, i12);
    }

    public void P0(qg.c cVar) {
        com.google.android.exoplayer2.util.a.e(cVar);
        this.f35901r.x(cVar);
    }

    public final void P1() {
        if (this.X != null) {
            X0(this.f35914y).n(10000).m(null).l();
            this.X.removeVideoSurfaceListener(this.f35913x);
            this.X = null;
        }
        TextureView textureView = this.Z;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f35913x) {
                com.google.android.exoplayer2.util.s.i("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.Z.setSurfaceTextureListener(null);
            }
            this.Z = null;
        }
        SurfaceHolder surfaceHolder = this.W;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f35913x);
            this.W = null;
        }
    }

    public void Q0(p.a aVar) {
        this.f35891m.add(aVar);
    }

    public final void Q1(int i11, int i12, @Nullable Object obj) {
        for (w2 w2Var : this.f35879g) {
            if (w2Var.getTrackType() == i11) {
                X0(w2Var).n(i12).m(obj).l();
            }
        }
    }

    public final List<g2.c> R0(int i11, List<com.google.android.exoplayer2.source.i> list) {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            g2.c cVar = new g2.c(list.get(i12), this.f35897p);
            arrayList.add(cVar);
            this.f35895o.add(i12 + i11, new e(cVar.f33249b, cVar.f33248a.P()));
        }
        this.M = this.M.cloneAndInsert(i11, arrayList.size());
        return arrayList;
    }

    public final void R1() {
        Q1(1, 2, Float.valueOf(this.f35884i0 * this.A.g()));
    }

    public final z1 S0() {
        j3 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return this.f35904s0;
        }
        return this.f35904s0.b().H(currentTimeline.r(u(), this.f33010a).f33379c.f34779f).F();
    }

    public void S1(List<com.google.android.exoplayer2.source.i> list) {
        g2();
        T1(list, true);
    }

    public void T0(@Nullable SurfaceHolder surfaceHolder) {
        g2();
        if (surfaceHolder == null || surfaceHolder != this.W) {
            return;
        }
        clearVideoSurface();
    }

    public void T1(List<com.google.android.exoplayer2.source.i> list, boolean z11) {
        g2();
        U1(list, -1, C.TIME_UNSET, z11);
    }

    public final void U1(List<com.google.android.exoplayer2.source.i> list, int i11, long j11, boolean z11) {
        int i12;
        long j12;
        int iB1 = b1();
        long currentPosition = getCurrentPosition();
        this.H++;
        if (!this.f35895o.isEmpty()) {
            O1(0, this.f35895o.size());
        }
        List<g2.c> listR0 = R0(0, list);
        j3 j3VarV0 = V0();
        if (!j3VarV0.u() && i11 >= j3VarV0.t()) {
            throw new IllegalSeekPositionException(j3VarV0, i11, j11);
        }
        if (z11) {
            int iE = j3VarV0.e(this.G);
            j12 = C.TIME_UNSET;
            i12 = iE;
        } else if (i11 == -1) {
            i12 = iB1;
            j12 = currentPosition;
        } else {
            i12 = i11;
            j12 = j11;
        }
        k2 k2VarJ1 = J1(this.f35906t0, j3VarV0, K1(j3VarV0, i12, j12));
        int i13 = k2VarJ1.f33408e;
        if (i12 != -1 && i13 != 1) {
            i13 = (j3VarV0.u() || i12 >= j3VarV0.t()) ? 4 : 2;
        }
        k2 k2VarG = k2VarJ1.g(i13);
        this.f35887k.K0(listR0, i12, com.google.android.exoplayer2.util.o0.C0(j12), this.M);
        d2(k2VarG, 0, 1, false, (this.f35906t0.f33405b.f71960a.equals(k2VarG.f33405b.f71960a) || this.f35906t0.f33404a.u()) ? false : true, 4, a1(k2VarG), -1);
    }

    public final j3 V0() {
        return new s2(this.f35895o, this.M);
    }

    public final void V1(SurfaceHolder surfaceHolder) {
        this.Y = false;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.f35913x);
        Surface surface = this.W.getSurface();
        if (surface == null || !surface.isValid()) {
            L1(0, 0);
        } else {
            Rect surfaceFrame = this.W.getSurfaceFrame();
            L1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final List<com.google.android.exoplayer2.source.i> W0(List<u1> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(this.f35899q.a(list.get(i11)));
        }
        return arrayList;
    }

    public final void W1(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        X1(surface);
        this.V = surface;
    }

    public final r2 X0(r2.b bVar) {
        int iB1 = b1();
        j1 j1Var = this.f35887k;
        return new r2(j1Var, bVar, this.f35906t0.f33404a, iB1 == -1 ? 0 : iB1, this.f35911w, j1Var.z());
    }

    public final void X1(@Nullable Object obj) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        w2[] w2VarArr = this.f35879g;
        int length = w2VarArr.length;
        int i11 = 0;
        while (true) {
            z11 = true;
            if (i11 >= length) {
                break;
            }
            w2 w2Var = w2VarArr[i11];
            if (w2Var.getTrackType() == 2) {
                arrayList.add(X0(w2Var).n(1).m(obj).l());
            }
            i11++;
        }
        Object obj2 = this.U;
        if (obj2 == null || obj2 == obj) {
            z11 = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((r2) it.next()).a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z11 = false;
            Object obj3 = this.U;
            Surface surface = this.V;
            if (obj3 == surface) {
                surface.release();
                this.V = null;
            }
        }
        this.U = obj;
        if (z11) {
            a2(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
        }
    }

    public final Pair<Boolean, Integer> Y0(k2 k2Var, k2 k2Var2, boolean z11, int i11, boolean z12) {
        j3 j3Var = k2Var2.f33404a;
        j3 j3Var2 = k2Var.f33404a;
        if (j3Var2.u() && j3Var.u()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i12 = 3;
        if (j3Var2.u() != j3Var.u()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (j3Var.r(j3Var.l(k2Var2.f33405b.f71960a, this.f35893n).f33364c, this.f33010a).f33377a.equals(j3Var2.r(j3Var2.l(k2Var.f33405b.f71960a, this.f35893n).f33364c, this.f33010a).f33377a)) {
            return (z11 && i11 == 0 && k2Var2.f33405b.f71963d < k2Var.f33405b.f71963d) ? new Pair<>(Boolean.TRUE, 0) : new Pair<>(Boolean.FALSE, -1);
        }
        if (z11 && i11 == 0) {
            i12 = 1;
        } else if (z11 && i11 == 1) {
            i12 = 2;
        } else if (!z12) {
            throw new IllegalStateException();
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(i12));
    }

    public void Y1(@Nullable SurfaceHolder surfaceHolder) {
        g2();
        if (surfaceHolder == null) {
            clearVideoSurface();
            return;
        }
        P1();
        this.Y = true;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.f35913x);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            X1(null);
            L1(0, 0);
        } else {
            X1(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            L1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public boolean Z0() {
        g2();
        return this.f35906t0.f33418o;
    }

    public void Z1(boolean z11) {
        g2();
        this.A.p(getPlayWhenReady(), 1);
        a2(z11, null);
        this.f35888k0 = vh.f.f78852b;
    }

    @Override // com.google.android.exoplayer2.p
    public void a(com.google.android.exoplayer2.source.i iVar) {
        g2();
        S1(Collections.singletonList(iVar));
    }

    public final long a1(k2 k2Var) {
        if (k2Var.f33404a.u()) {
            return com.google.android.exoplayer2.util.o0.C0(this.f35912w0);
        }
        return k2Var.f33405b.b() ? k2Var.f33421r : M1(k2Var.f33404a, k2Var.f33405b, k2Var.f33421r);
    }

    public final void a2(boolean z11, @Nullable ExoPlaybackException exoPlaybackException) {
        k2 k2VarB;
        if (z11) {
            k2VarB = N1(0, this.f35895o.size()).e(null);
        } else {
            k2 k2Var = this.f35906t0;
            k2VarB = k2Var.b(k2Var.f33405b);
            k2VarB.f33419p = k2VarB.f33421r;
            k2VarB.f33420q = 0L;
        }
        k2 k2VarG = k2VarB.g(1);
        if (exoPlaybackException != null) {
            k2VarG = k2VarG.e(exoPlaybackException);
        }
        k2 k2Var2 = k2VarG;
        this.H++;
        this.f35887k.e1();
        d2(k2Var2, 0, 1, false, k2Var2.f33404a.u() && !this.f35906t0.f33404a.u(), 4, a1(k2Var2), -1);
    }

    @Override // com.google.android.exoplayer2.n2
    public void b(m2 m2Var) {
        g2();
        if (m2Var == null) {
            m2Var = m2.f33485d;
        }
        if (this.f35906t0.f33417n.equals(m2Var)) {
            return;
        }
        k2 k2VarF = this.f35906t0.f(m2Var);
        this.H++;
        this.f35887k.P0(m2Var);
        d2(k2VarF, 0, 1, false, false, 5, C.TIME_UNSET, -1);
    }

    public final int b1() {
        if (this.f35906t0.f33404a.u()) {
            return this.f35908u0;
        }
        k2 k2Var = this.f35906t0;
        return k2Var.f33404a.l(k2Var.f33405b.f71960a, this.f35893n).f33364c;
    }

    public final void b2() {
        n2.b bVar = this.O;
        n2.b bVarH = com.google.android.exoplayer2.util.o0.H(this.f35877f, this.f35871c);
        this.O = bVarH;
        if (bVarH.equals(bVar)) {
            return;
        }
        this.f35889l.i(13, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.o0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                this.f33621a.u1((n2.d) obj);
            }
        });
    }

    @Nullable
    public final Pair<Object, Long> c1(j3 j3Var, j3 j3Var2) {
        long contentPosition = getContentPosition();
        if (j3Var.u() || j3Var2.u()) {
            boolean z11 = !j3Var.u() && j3Var2.u();
            int iB1 = z11 ? -1 : b1();
            if (z11) {
                contentPosition = -9223372036854775807L;
            }
            return K1(j3Var2, iB1, contentPosition);
        }
        Pair<Object, Long> pairN = j3Var.n(this.f33010a, this.f35893n, u(), com.google.android.exoplayer2.util.o0.C0(contentPosition));
        Object obj = ((Pair) com.google.android.exoplayer2.util.o0.j(pairN)).first;
        if (j3Var2.f(obj) != -1) {
            return pairN;
        }
        Object objW0 = j1.w0(this.f33010a, this.f35893n, this.F, this.G, obj, j3Var, j3Var2);
        if (objW0 == null) {
            return K1(j3Var2, -1, C.TIME_UNSET);
        }
        j3Var2.l(objW0, this.f35893n);
        int i11 = this.f35893n.f33364c;
        return K1(j3Var2, i11, j3Var2.r(i11, this.f33010a).e());
    }

    public final void c2(boolean z11, int i11, int i12) {
        int i13 = 0;
        boolean z12 = z11 && i11 != -1;
        if (z12 && i11 != 1) {
            i13 = 1;
        }
        k2 k2Var = this.f35906t0;
        if (k2Var.f33415l == z12 && k2Var.f33416m == i13) {
            return;
        }
        this.H++;
        k2 k2VarD = k2Var.d(z12, i13);
        this.f35887k.N0(z12, i13);
        d2(k2VarD, 0, i12, false, false, 5, C.TIME_UNSET, -1);
    }

    @Override // com.google.android.exoplayer2.n2
    public void clearVideoSurface() {
        g2();
        P1();
        X1(null);
        L1(0, 0);
    }

    @Override // com.google.android.exoplayer2.n2
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        g2();
        T0(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.n2
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        g2();
        if (textureView == null || textureView != this.Z) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.n2
    public long d() {
        g2();
        return com.google.android.exoplayer2.util.o0.f1(this.f35906t0.f33420q);
    }

    public final void d2(final k2 k2Var, final int i11, final int i12, boolean z11, boolean z12, final int i13, long j11, int i14) {
        k2 k2Var2 = this.f35906t0;
        this.f35906t0 = k2Var;
        Pair<Boolean, Integer> pairY0 = Y0(k2Var, k2Var2, z12, i13, !k2Var2.f33404a.equals(k2Var.f33404a));
        boolean zBooleanValue = ((Boolean) pairY0.first).booleanValue();
        final int iIntValue = ((Integer) pairY0.second).intValue();
        z1 z1VarS0 = this.P;
        final u1 u1Var = null;
        if (zBooleanValue) {
            if (!k2Var.f33404a.u()) {
                u1Var = k2Var.f33404a.r(k2Var.f33404a.l(k2Var.f33405b.f71960a, this.f35893n).f33364c, this.f33010a).f33379c;
            }
            this.f35904s0 = z1.H;
        }
        if (zBooleanValue || !k2Var2.f33413j.equals(k2Var.f33413j)) {
            this.f35904s0 = this.f35904s0.b().J(k2Var.f33413j).F();
            z1VarS0 = S0();
        }
        boolean z13 = !z1VarS0.equals(this.P);
        this.P = z1VarS0;
        boolean z14 = k2Var2.f33415l != k2Var.f33415l;
        boolean z15 = k2Var2.f33408e != k2Var.f33408e;
        if (z15 || z14) {
            f2();
        }
        boolean z16 = k2Var2.f33410g;
        boolean z17 = k2Var.f33410g;
        boolean z18 = z16 != z17;
        if (z18) {
            e2(z17);
        }
        if (!k2Var2.f33404a.equals(k2Var.f33404a)) {
            this.f35889l.i(0, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.r0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.v1(k2Var, i11, (n2.d) obj);
                }
            });
        }
        if (z12) {
            final n2.e eVarG1 = g1(i13, k2Var2, i14);
            final n2.e eVarF1 = f1(j11);
            this.f35889l.i(11, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.z
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.w1(i13, eVarG1, eVarF1, (n2.d) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.f35889l.i(1, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.a0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onMediaItemTransition(u1Var, iIntValue);
                }
            });
        }
        if (k2Var2.f33409f != k2Var.f33409f) {
            this.f35889l.i(10, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.b0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.y1(k2Var, (n2.d) obj);
                }
            });
            if (k2Var.f33409f != null) {
                this.f35889l.i(10, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.c0
                    @Override // com.google.android.exoplayer2.util.r.a
                    public final void invoke(Object obj) {
                        x0.z1(k2Var, (n2.d) obj);
                    }
                });
            }
        }
        fi.c0 c0Var = k2Var2.f33412i;
        fi.c0 c0Var2 = k2Var.f33412i;
        if (c0Var != c0Var2) {
            this.f35881h.f(c0Var2.f64966e);
            this.f35889l.i(2, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.d0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.A1(k2Var, (n2.d) obj);
                }
            });
        }
        if (z13) {
            final z1 z1Var = this.P;
            this.f35889l.i(14, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.e0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onMediaMetadataChanged(z1Var);
                }
            });
        }
        if (z18) {
            this.f35889l.i(3, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.f0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.C1(k2Var, (n2.d) obj);
                }
            });
        }
        if (z15 || z14) {
            this.f35889l.i(-1, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.g0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.D1(k2Var, (n2.d) obj);
                }
            });
        }
        if (z15) {
            this.f35889l.i(4, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.h0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.E1(k2Var, (n2.d) obj);
                }
            });
        }
        if (z14) {
            this.f35889l.i(5, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.s0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.F1(k2Var, i12, (n2.d) obj);
                }
            });
        }
        if (k2Var2.f33416m != k2Var.f33416m) {
            this.f35889l.i(6, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.t0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.G1(k2Var, (n2.d) obj);
                }
            });
        }
        if (k1(k2Var2) != k1(k2Var)) {
            this.f35889l.i(7, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.u0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.H1(k2Var, (n2.d) obj);
                }
            });
        }
        if (!k2Var2.f33417n.equals(k2Var.f33417n)) {
            this.f35889l.i(12, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.v0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.I1(k2Var, (n2.d) obj);
                }
            });
        }
        if (z11) {
            this.f35889l.i(-1, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.w0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onSeekProcessed();
                }
            });
        }
        b2();
        this.f35889l.f();
        if (k2Var2.f33418o != k2Var.f33418o) {
            Iterator<p.a> it = this.f35891m.iterator();
            while (it.hasNext()) {
                it.next().x(k2Var.f33418o);
            }
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public void e(List<u1> list, boolean z11) {
        g2();
        T1(W0(list), z11);
    }

    @Override // com.google.android.exoplayer2.n2
    @Nullable
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public ExoPlaybackException c() {
        g2();
        return this.f35906t0.f33409f;
    }

    public final void e2(boolean z11) {
        PriorityTaskManager priorityTaskManager = this.f35894n0;
        if (priorityTaskManager != null) {
            if (z11 && !this.f35896o0) {
                priorityTaskManager.a(0);
                this.f35896o0 = true;
            } else {
                if (z11 || !this.f35896o0) {
                    return;
                }
                priorityTaskManager.d(0);
                this.f35896o0 = false;
            }
        }
    }

    public final n2.e f1(long j11) {
        Object obj;
        u1 u1Var;
        Object obj2;
        int iF;
        int iU = u();
        if (this.f35906t0.f33404a.u()) {
            obj = null;
            u1Var = null;
            obj2 = null;
            iF = -1;
        } else {
            k2 k2Var = this.f35906t0;
            Object obj3 = k2Var.f33405b.f71960a;
            k2Var.f33404a.l(obj3, this.f35893n);
            iF = this.f35906t0.f33404a.f(obj3);
            obj2 = obj3;
            obj = this.f35906t0.f33404a.r(iU, this.f33010a).f33377a;
            u1Var = this.f33010a.f33379c;
        }
        long jF1 = com.google.android.exoplayer2.util.o0.f1(j11);
        long jF2 = this.f35906t0.f33405b.b() ? com.google.android.exoplayer2.util.o0.f1(h1(this.f35906t0)) : jF1;
        com.google.android.exoplayer2.source.i.b bVar = this.f35906t0.f33405b;
        return new n2.e(obj, iU, u1Var, obj2, iF, jF1, jF2, bVar.f71961b, bVar.f71962c);
    }

    public final void f2() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.C.b(getPlayWhenReady() && !Z0());
                this.D.b(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }

    public final n2.e g1(int i11, k2 k2Var, int i12) {
        int i13;
        Object obj;
        u1 u1Var;
        Object obj2;
        int i14;
        long jH1;
        long jH2;
        j3.b bVar = new j3.b();
        if (k2Var.f33404a.u()) {
            i13 = i12;
            obj = null;
            u1Var = null;
            obj2 = null;
            i14 = -1;
        } else {
            Object obj3 = k2Var.f33405b.f71960a;
            k2Var.f33404a.l(obj3, bVar);
            int i15 = bVar.f33364c;
            int iF = k2Var.f33404a.f(obj3);
            Object obj4 = k2Var.f33404a.r(i15, this.f33010a).f33377a;
            u1Var = this.f33010a.f33379c;
            obj2 = obj3;
            i14 = iF;
            obj = obj4;
            i13 = i15;
        }
        if (i11 == 0) {
            if (k2Var.f33405b.b()) {
                com.google.android.exoplayer2.source.i.b bVar2 = k2Var.f33405b;
                jH1 = bVar.e(bVar2.f71961b, bVar2.f71962c);
                jH2 = h1(k2Var);
            } else {
                jH1 = k2Var.f33405b.f71964e != -1 ? h1(this.f35906t0) : bVar.f33366f + bVar.f33365d;
                jH2 = jH1;
            }
        } else if (k2Var.f33405b.b()) {
            jH1 = k2Var.f33421r;
            jH2 = h1(k2Var);
        } else {
            jH1 = bVar.f33366f + k2Var.f33421r;
            jH2 = jH1;
        }
        long jF1 = com.google.android.exoplayer2.util.o0.f1(jH1);
        long jF2 = com.google.android.exoplayer2.util.o0.f1(jH2);
        com.google.android.exoplayer2.source.i.b bVar3 = k2Var.f33405b;
        return new n2.e(obj, i13, u1Var, obj2, i14, jF1, jF2, bVar3.f71961b, bVar3.f71962c);
    }

    public final void g2() {
        this.f35873d.c();
        if (Thread.currentThread() != l().getThread()) {
            String strC = com.google.android.exoplayer2.util.o0.C("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), l().getThread().getName());
            if (this.f35890l0) {
                throw new IllegalStateException(strC);
            }
            com.google.android.exoplayer2.util.s.j("ExoPlayerImpl", strC, this.f35892m0 ? null : new IllegalStateException());
            this.f35892m0 = true;
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public long getContentPosition() {
        g2();
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        k2 k2Var = this.f35906t0;
        k2Var.f33404a.l(k2Var.f33405b.f71960a, this.f35893n);
        k2 k2Var2 = this.f35906t0;
        return k2Var2.f33406c == C.TIME_UNSET ? k2Var2.f33404a.r(u(), this.f33010a).e() : this.f35893n.p() + com.google.android.exoplayer2.util.o0.f1(this.f35906t0.f33406c);
    }

    @Override // com.google.android.exoplayer2.n2
    public int getCurrentAdGroupIndex() {
        g2();
        if (isPlayingAd()) {
            return this.f35906t0.f33405b.f71961b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.n2
    public int getCurrentAdIndexInAdGroup() {
        g2();
        if (isPlayingAd()) {
            return this.f35906t0.f33405b.f71962c;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.n2
    public int getCurrentPeriodIndex() {
        g2();
        if (this.f35906t0.f33404a.u()) {
            return this.f35910v0;
        }
        k2 k2Var = this.f35906t0;
        return k2Var.f33404a.f(k2Var.f33405b.f71960a);
    }

    @Override // com.google.android.exoplayer2.n2
    public long getCurrentPosition() {
        g2();
        return com.google.android.exoplayer2.util.o0.f1(a1(this.f35906t0));
    }

    @Override // com.google.android.exoplayer2.n2
    public j3 getCurrentTimeline() {
        g2();
        return this.f35906t0.f33404a;
    }

    @Override // com.google.android.exoplayer2.n2
    public o3 getCurrentTracks() {
        g2();
        return this.f35906t0.f33412i.f64965d;
    }

    @Override // com.google.android.exoplayer2.n2
    public long getDuration() {
        g2();
        if (!isPlayingAd()) {
            return F();
        }
        k2 k2Var = this.f35906t0;
        com.google.android.exoplayer2.source.i.b bVar = k2Var.f33405b;
        k2Var.f33404a.l(bVar.f71960a, this.f35893n);
        return com.google.android.exoplayer2.util.o0.f1(this.f35893n.e(bVar.f71961b, bVar.f71962c));
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean getPlayWhenReady() {
        g2();
        return this.f35906t0.f33415l;
    }

    @Override // com.google.android.exoplayer2.n2
    public m2 getPlaybackParameters() {
        g2();
        return this.f35906t0.f33417n;
    }

    @Override // com.google.android.exoplayer2.n2
    public int getPlaybackState() {
        g2();
        return this.f35906t0.f33408e;
    }

    @Override // com.google.android.exoplayer2.n2
    public int getRepeatMode() {
        g2();
        return this.F;
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean getShuffleModeEnabled() {
        g2();
        return this.G;
    }

    @Override // com.google.android.exoplayer2.n2
    public float getVolume() {
        g2();
        return this.f35884i0;
    }

    @Override // com.google.android.exoplayer2.n2
    public vh.f h() {
        g2();
        return this.f35888k0;
    }

    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public final void n1(j1.e eVar) {
        long j11;
        boolean z11;
        long jM1;
        int i11 = this.H - eVar.f33345c;
        this.H = i11;
        boolean z12 = true;
        if (eVar.f33346d) {
            this.I = eVar.f33347e;
            this.J = true;
        }
        if (eVar.f33348f) {
            this.K = eVar.f33349g;
        }
        if (i11 == 0) {
            j3 j3Var = eVar.f33344b.f33404a;
            if (!this.f35906t0.f33404a.u() && j3Var.u()) {
                this.f35908u0 = -1;
                this.f35912w0 = 0L;
                this.f35910v0 = 0;
            }
            if (!j3Var.u()) {
                List<j3> listK = ((s2) j3Var).K();
                com.google.android.exoplayer2.util.a.g(listK.size() == this.f35895o.size());
                for (int i12 = 0; i12 < listK.size(); i12++) {
                    this.f35895o.get(i12).f35922b = listK.get(i12);
                }
            }
            if (this.J) {
                if (eVar.f33344b.f33405b.equals(this.f35906t0.f33405b) && eVar.f33344b.f33407d == this.f35906t0.f33421r) {
                    z12 = false;
                }
                if (z12) {
                    if (j3Var.u() || eVar.f33344b.f33405b.b()) {
                        jM1 = eVar.f33344b.f33407d;
                    } else {
                        k2 k2Var = eVar.f33344b;
                        jM1 = M1(j3Var, k2Var.f33405b, k2Var.f33407d);
                    }
                    j11 = jM1;
                } else {
                    j11 = -9223372036854775807L;
                }
                z11 = z12;
            } else {
                j11 = -9223372036854775807L;
                z11 = false;
            }
            this.J = false;
            d2(eVar.f33344b, 1, this.K, false, z11, this.I, j11, -1);
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean isPlayingAd() {
        g2();
        return this.f35906t0.f33405b.b();
    }

    public final int j1(int i11) {
        AudioTrack audioTrack = this.T;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i11) {
            this.T.release();
            this.T = null;
        }
        if (this.T == null) {
            this.T = new AudioTrack(3, 4000, 4, 2, 2, 0, i11);
        }
        return this.T.getAudioSessionId();
    }

    @Override // com.google.android.exoplayer2.n2
    public int k() {
        g2();
        return this.f35906t0.f33416m;
    }

    @Override // com.google.android.exoplayer2.n2
    public Looper l() {
        return this.f35903s;
    }

    @Override // com.google.android.exoplayer2.n2
    public fi.z m() {
        g2();
        return this.f35881h.b();
    }

    public final /* synthetic */ void m1(n2.d dVar, com.google.android.exoplayer2.util.m mVar) {
        dVar.onEvents(this.f35877f, new n2.c(mVar));
    }

    @Override // com.google.android.exoplayer2.n2
    public n2.b o() {
        g2();
        return this.O;
    }

    public final /* synthetic */ void o1(final j1.e eVar) {
        this.f35883i.post(new Runnable() { // from class: com.google.android.exoplayer2.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f33432a.n1(eVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2
    public long p() {
        g2();
        return 3000L;
    }

    @Override // com.google.android.exoplayer2.n2
    public void prepare() {
        g2();
        boolean playWhenReady = getPlayWhenReady();
        int iP = this.A.p(playWhenReady, 2);
        c2(playWhenReady, iP, d1(playWhenReady, iP));
        k2 k2Var = this.f35906t0;
        if (k2Var.f33408e != 1) {
            return;
        }
        k2 k2VarE = k2Var.e(null);
        k2 k2VarG = k2VarE.g(k2VarE.f33404a.u() ? 4 : 2);
        this.H++;
        this.f35887k.g0();
        d2(k2VarG, 1, 1, false, false, 5, C.TIME_UNSET, -1);
    }

    @Override // com.google.android.exoplayer2.n2
    public com.google.android.exoplayer2.video.y q() {
        g2();
        return this.f35902r0;
    }

    @Override // com.google.android.exoplayer2.n2
    public void release() {
        AudioTrack audioTrack;
        com.google.android.exoplayer2.util.s.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.1] [" + com.google.android.exoplayer2.util.o0.f35612e + "] [" + k1.b() + "]");
        g2();
        if (com.google.android.exoplayer2.util.o0.f35608a < 21 && (audioTrack = this.T) != null) {
            audioTrack.release();
            this.T = null;
        }
        this.f35915z.b(false);
        this.B.g();
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.f35887k.i0()) {
            this.f35889l.l(10, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.i0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    x0.p1((n2.d) obj);
                }
            });
        }
        this.f35889l.j();
        this.f35883i.removeCallbacksAndMessages(null);
        this.f35905t.d(this.f35901r);
        k2 k2VarG = this.f35906t0.g(1);
        this.f35906t0 = k2VarG;
        k2 k2VarB = k2VarG.b(k2VarG.f33405b);
        this.f35906t0 = k2VarB;
        k2VarB.f33419p = k2VarB.f33421r;
        this.f35906t0.f33420q = 0L;
        this.f35901r.release();
        this.f35881h.g();
        P1();
        Surface surface = this.V;
        if (surface != null) {
            surface.release();
            this.V = null;
        }
        if (this.f35896o0) {
            ((PriorityTaskManager) com.google.android.exoplayer2.util.a.e(this.f35894n0)).d(0);
            this.f35896o0 = false;
        }
        this.f35888k0 = vh.f.f78852b;
        this.f35898p0 = true;
    }

    @Override // com.google.android.exoplayer2.n2
    public long s() {
        g2();
        return this.f35909v;
    }

    @Override // com.google.android.exoplayer2.n2
    public void seekTo(int i11, long j11) {
        g2();
        this.f35901r.m();
        j3 j3Var = this.f35906t0.f33404a;
        if (i11 < 0 || (!j3Var.u() && i11 >= j3Var.t())) {
            throw new IllegalSeekPositionException(j3Var, i11, j11);
        }
        this.H++;
        if (isPlayingAd()) {
            com.google.android.exoplayer2.util.s.i("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            j1.e eVar = new j1.e(this.f35906t0);
            eVar.b(1);
            this.f35885j.a(eVar);
            return;
        }
        int i12 = getPlaybackState() != 1 ? 2 : 1;
        int iU = u();
        k2 k2VarJ1 = J1(this.f35906t0.g(i12), j3Var, K1(j3Var, i11, j11));
        this.f35887k.y0(j3Var, i11, com.google.android.exoplayer2.util.o0.C0(j11));
        d2(k2VarJ1, 0, 1, true, true, 1, a1(k2VarJ1), iU);
    }

    @Override // com.google.android.exoplayer2.n2
    public void setPlayWhenReady(boolean z11) {
        g2();
        int iP = this.A.p(z11, getPlaybackState());
        c2(z11, iP, d1(z11, iP));
    }

    @Override // com.google.android.exoplayer2.n2
    public void setRepeatMode(final int i11) {
        g2();
        if (this.F != i11) {
            this.F = i11;
            this.f35887k.R0(i11);
            this.f35889l.i(8, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.l0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onRepeatModeChanged(i11);
                }
            });
            b2();
            this.f35889l.f();
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public void setShuffleModeEnabled(final boolean z11) {
        g2();
        if (this.G != z11) {
            this.G = z11;
            this.f35887k.U0(z11);
            this.f35889l.i(9, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.q0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((n2.d) obj).onShuffleModeEnabledChanged(z11);
                }
            });
            b2();
            this.f35889l.f();
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        g2();
        if (surfaceView instanceof com.google.android.exoplayer2.video.h) {
            P1();
            X1(surfaceView);
            V1(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof SphericalGLSurfaceView)) {
                Y1(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            P1();
            this.X = (SphericalGLSurfaceView) surfaceView;
            X0(this.f35914y).n(10000).m(this.X).l();
            this.X.addVideoSurfaceListener(this.f35913x);
            X1(this.X.getVideoSurface());
            V1(surfaceView.getHolder());
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public void setVideoTextureView(@Nullable TextureView textureView) {
        g2();
        if (textureView == null) {
            clearVideoSurface();
            return;
        }
        P1();
        this.Z = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            com.google.android.exoplayer2.util.s.i("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f35913x);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            X1(null);
            L1(0, 0);
        } else {
            W1(surfaceTexture);
            L1(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public void setVolume(float f11) {
        g2();
        final float fP = com.google.android.exoplayer2.util.o0.p(f11, 0.0f, 1.0f);
        if (this.f35884i0 == fP) {
            return;
        }
        this.f35884i0 = fP;
        R1();
        this.f35889l.l(22, new com.google.android.exoplayer2.util.r.a() { // from class: com.google.android.exoplayer2.k0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((n2.d) obj).onVolumeChanged(fP);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2
    public void stop() {
        g2();
        Z1(false);
    }

    @Override // com.google.android.exoplayer2.n2
    public int u() {
        g2();
        int iB1 = b1();
        if (iB1 == -1) {
            return 0;
        }
        return iB1;
    }

    public final /* synthetic */ void u1(n2.d dVar) {
        dVar.onAvailableCommandsChanged(this.O);
    }

    @Override // com.google.android.exoplayer2.n2
    public long v() {
        g2();
        if (this.f35906t0.f33404a.u()) {
            return this.f35912w0;
        }
        k2 k2Var = this.f35906t0;
        if (k2Var.f33414k.f71963d != k2Var.f33405b.f71963d) {
            return k2Var.f33404a.r(u(), this.f33010a).g();
        }
        long j11 = k2Var.f33419p;
        if (this.f35906t0.f33414k.b()) {
            k2 k2Var2 = this.f35906t0;
            j3.b bVarL = k2Var2.f33404a.l(k2Var2.f33414k.f71960a, this.f35893n);
            long jI = bVarL.i(this.f35906t0.f33414k.f71961b);
            j11 = jI == Long.MIN_VALUE ? bVarL.f33365d : jI;
        }
        k2 k2Var3 = this.f35906t0;
        return com.google.android.exoplayer2.util.o0.f1(M1(k2Var3.f33404a, k2Var3.f33414k, j11));
    }

    @Override // com.google.android.exoplayer2.n2
    public z1 y() {
        g2();
        return this.P;
    }

    @Override // com.google.android.exoplayer2.n2
    public long z() {
        g2();
        return this.f35907u;
    }
}
