package androidx.media3.exoplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
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
import androidx.media3.common.IllegalSeekPositionException;
import androidx.media3.common.Metadata;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import e4.v3;
import e4.x3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c1 extends androidx.media3.common.h implements u {
    public final l A;

    @Nullable
    public final f3 B;
    public final h3 C;
    public final i3 D;
    public final long E;

    @Nullable
    public AudioManager F;
    public final boolean G;
    public int H;
    public boolean I;
    public int J;
    public int K;
    public boolean L;
    public int M;
    public b3 N;
    public p4.f0 O;
    public boolean P;
    public androidx.media3.common.h0.b Q;
    public androidx.media3.common.d0 R;
    public androidx.media3.common.d0 S;

    @Nullable
    public androidx.media3.common.y T;

    @Nullable
    public androidx.media3.common.y U;

    @Nullable
    public AudioTrack V;

    @Nullable
    public Object W;

    @Nullable
    public Surface X;

    @Nullable
    public SurfaceHolder Y;

    @Nullable
    public SphericalGLSurfaceView Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f10009a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s4.f0 f10010b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @Nullable
    public TextureView f10011b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.media3.common.h0.b f10012c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f10013c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z3.g f10014d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f10015d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f10016e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public z3.e0 f10017e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.media3.common.h0 f10018f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @Nullable
    public n f10019f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w2[] f10020g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @Nullable
    public n f10021g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s4.e0 f10022h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f10023h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z3.j f10024i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public androidx.media3.common.d f10025i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s1.f f10026j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f10027j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s1 f10028k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f10029k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final z3.n<androidx.media3.common.h0.d> f10030l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public y3.b f10031l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArraySet<u.a> f10032m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f10033m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final androidx.media3.common.m0.b f10034n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f10035n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<f> f10036o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @Nullable
    public PriorityTaskManager f10037o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f10038p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f10039p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.l.a f10040q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f10041q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final e4.a f10042r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public androidx.media3.common.o f10043r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Looper f10044s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public androidx.media3.common.t0 f10045s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.e f10046t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public androidx.media3.common.d0 f10047t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f10048u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public s2 f10049u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f10050v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f10051v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final z3.d f10052w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f10053w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d f10054x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public long f10055x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final e f10056y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AudioBecomingNoisyManager f10057z;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static final class b {
        public static boolean a(Context context, AudioDeviceInfo[] audioDeviceInfoArr) {
            if (!z3.u0.N0(context)) {
                return true;
            }
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 5 || audioDeviceInfo.getType() == 6 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                    return true;
                }
                int i11 = z3.u0.f81838a;
                if (i11 >= 26 && audioDeviceInfo.getType() == 22) {
                    return true;
                }
                if (i11 >= 28 && audioDeviceInfo.getType() == 23) {
                    return true;
                }
                if (i11 >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
                    return true;
                }
                if (i11 >= 33 && audioDeviceInfo.getType() == 30) {
                    return true;
                }
            }
            return false;
        }

        public static void b(AudioManager audioManager, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            audioManager.registerAudioDeviceCallback(audioDeviceCallback, handler);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class c {
        public static x3 a(Context context, c1 c1Var, boolean z11) {
            v3 v3VarY0 = v3.y0(context);
            if (v3VarY0 == null) {
                z3.o.h("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new x3(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z11) {
                c1Var.L(v3VarY0);
            }
            return new x3(v3VarY0.F0());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d implements androidx.media3.exoplayer.video.f0, androidx.media3.exoplayer.audio.c, r4.h, n4.b, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, l.b, AudioBecomingNoisyManager.a, f3.b, u.a {
        public d() {
        }

        @Override // androidx.media3.exoplayer.audio.c
        public /* synthetic */ void A(androidx.media3.common.y yVar) {
            f4.l.a(this, yVar);
        }

        @Override // androidx.media3.exoplayer.video.f0
        public /* synthetic */ void B(androidx.media3.common.y yVar) {
            androidx.media3.exoplayer.video.u.a(this, yVar);
        }

        public final /* synthetic */ void M(androidx.media3.common.h0.d dVar) {
            dVar.onMediaMetadataChanged(c1.this.R);
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void a(Exception exc) {
            c1.this.f10042r.a(exc);
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void b(String str) {
            c1.this.f10042r.b(str);
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void c(String str) {
            c1.this.f10042r.c(str);
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void d(long j11) {
            c1.this.f10042r.d(j11);
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void e(Exception exc) {
            c1.this.f10042r.e(exc);
        }

        @Override // androidx.media3.exoplayer.f3.b
        public void f(int i11) {
            final androidx.media3.common.o oVarS1 = c1.s1(c1.this.B);
            if (oVarS1.equals(c1.this.f10043r0)) {
                return;
            }
            c1.this.f10043r0 = oVarS1;
            c1.this.f10030l.l(29, new z3.n.a() { // from class: androidx.media3.exoplayer.l1
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onDeviceInfoChanged(oVarS1);
                }
            });
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void g(Object obj, long j11) {
            c1.this.f10042r.g(obj, j11);
            if (c1.this.W == obj) {
                c1.this.f10030l.l(26, new z3.n.a() { // from class: androidx.media3.exoplayer.m1
                    @Override // z3.n.a
                    public final void invoke(Object obj2) {
                        ((androidx.media3.common.h0.d) obj2).onRenderedFirstFrame();
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void h(Exception exc) {
            c1.this.f10042r.h(exc);
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void i(int i11, long j11, long j12) {
            c1.this.f10042r.i(i11, j11, j12);
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void j(long j11, int i11) {
            c1.this.f10042r.j(j11, i11);
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void k(AudioSink.a aVar) {
            c1.this.f10042r.k(aVar);
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void l(AudioSink.a aVar) {
            c1.this.f10042r.l(aVar);
        }

        @Override // androidx.media3.exoplayer.AudioBecomingNoisyManager.a
        public void m() {
            c1.this.A2(false, -1, 3);
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void n(n nVar) {
            c1.this.f10021g0 = nVar;
            c1.this.f10042r.n(nVar);
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void o(n nVar) {
            c1.this.f10019f0 = nVar;
            c1.this.f10042r.o(nVar);
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void onAudioDecoderInitialized(String str, long j11, long j12) {
            c1.this.f10042r.onAudioDecoderInitialized(str, j11, j12);
        }

        @Override // r4.h
        public void onCues(final List<y3.a> list) {
            c1.this.f10030l.l(27, new z3.n.a() { // from class: androidx.media3.exoplayer.g1
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onCues((List<y3.a>) list);
                }
            });
        }

        @Override // r4.h
        public void onCues(final y3.b bVar) {
            c1.this.f10031l0 = bVar;
            c1.this.f10030l.l(27, new z3.n.a() { // from class: androidx.media3.exoplayer.k1
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onCues(bVar);
                }
            });
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void onDroppedFrames(int i11, long j11) {
            c1.this.f10042r.onDroppedFrames(i11, j11);
        }

        @Override // n4.b
        public void onMetadata(final Metadata metadata) {
            c1 c1Var = c1.this;
            c1Var.f10047t0 = c1Var.f10047t0.a().K(metadata).H();
            androidx.media3.common.d0 d0VarO1 = c1.this.o1();
            if (!d0VarO1.equals(c1.this.R)) {
                c1.this.R = d0VarO1;
                c1.this.f10030l.i(14, new z3.n.a() { // from class: androidx.media3.exoplayer.h1
                    @Override // z3.n.a
                    public final void invoke(Object obj) {
                        this.f10330a.M((androidx.media3.common.h0.d) obj);
                    }
                });
            }
            c1.this.f10030l.i(28, new z3.n.a() { // from class: androidx.media3.exoplayer.i1
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onMetadata(metadata);
                }
            });
            c1.this.f10030l.f();
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void onSkipSilenceEnabledChanged(final boolean z11) {
            if (c1.this.f10029k0 == z11) {
                return;
            }
            c1.this.f10029k0 = z11;
            c1.this.f10030l.l(23, new z3.n.a() { // from class: androidx.media3.exoplayer.o1
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onSkipSilenceEnabledChanged(z11);
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            c1.this.u2(surfaceTexture);
            c1.this.j2(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            c1.this.v2(null);
            c1.this.j2(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            c1.this.j2(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void onVideoDecoderInitialized(String str, long j11, long j12) {
            c1.this.f10042r.onVideoDecoderInitialized(str, j11, j12);
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void onVideoSizeChanged(final androidx.media3.common.t0 t0Var) {
            c1.this.f10045s0 = t0Var;
            c1.this.f10030l.l(25, new z3.n.a() { // from class: androidx.media3.exoplayer.n1
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onVideoSizeChanged(t0Var);
                }
            });
        }

        @Override // androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView.b
        public void p(Surface surface) {
            c1.this.v2(null);
        }

        @Override // androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView.b
        public void q(Surface surface) {
            c1.this.v2(surface);
        }

        @Override // androidx.media3.exoplayer.f3.b
        public void r(final int i11, final boolean z11) {
            c1.this.f10030l.l(30, new z3.n.a() { // from class: androidx.media3.exoplayer.j1
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onDeviceVolumeChanged(i11, z11);
                }
            });
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void s(androidx.media3.common.y yVar, @Nullable o oVar) {
            c1.this.U = yVar;
            c1.this.f10042r.s(yVar, oVar);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            c1.this.j2(i12, i13);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (c1.this.f10009a0) {
                c1.this.v2(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (c1.this.f10009a0) {
                c1.this.v2(null);
            }
            c1.this.j2(0, 0);
        }

        @Override // androidx.media3.exoplayer.audio.c
        public void t(n nVar) {
            c1.this.f10042r.t(nVar);
            c1.this.U = null;
            c1.this.f10021g0 = null;
        }

        @Override // androidx.media3.exoplayer.l.b
        public void u(float f11) {
            c1.this.p2();
        }

        @Override // androidx.media3.exoplayer.l.b
        public void v(int i11) {
            boolean playWhenReady = c1.this.getPlayWhenReady();
            c1.this.A2(playWhenReady, i11, c1.B1(playWhenReady, i11));
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void w(androidx.media3.common.y yVar, @Nullable o oVar) {
            c1.this.T = yVar;
            c1.this.f10042r.w(yVar, oVar);
        }

        @Override // androidx.media3.exoplayer.video.f0
        public void x(n nVar) {
            c1.this.f10042r.x(nVar);
            c1.this.T = null;
            c1.this.f10019f0 = null;
        }

        @Override // androidx.media3.exoplayer.u.a
        public /* synthetic */ void y(boolean z11) {
            t.a(this, z11);
        }

        @Override // androidx.media3.exoplayer.u.a
        public void z(boolean z11) {
            c1.this.E2();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements androidx.media3.exoplayer.video.o, t4.a, t2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public androidx.media3.exoplayer.video.o f10059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public t4.a f10060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public androidx.media3.exoplayer.video.o f10061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public t4.a f10062d;

        public e() {
        }

        @Override // t4.a
        public void a(long j11, float[] fArr) {
            t4.a aVar = this.f10062d;
            if (aVar != null) {
                aVar.a(j11, fArr);
            }
            t4.a aVar2 = this.f10060b;
            if (aVar2 != null) {
                aVar2.a(j11, fArr);
            }
        }

        @Override // t4.a
        public void b() {
            t4.a aVar = this.f10062d;
            if (aVar != null) {
                aVar.b();
            }
            t4.a aVar2 = this.f10060b;
            if (aVar2 != null) {
                aVar2.b();
            }
        }

        @Override // androidx.media3.exoplayer.video.o
        public void e(long j11, long j12, androidx.media3.common.y yVar, @Nullable MediaFormat mediaFormat) {
            androidx.media3.exoplayer.video.o oVar = this.f10061c;
            if (oVar != null) {
                oVar.e(j11, j12, yVar, mediaFormat);
            }
            androidx.media3.exoplayer.video.o oVar2 = this.f10059a;
            if (oVar2 != null) {
                oVar2.e(j11, j12, yVar, mediaFormat);
            }
        }

        @Override // androidx.media3.exoplayer.t2.b
        public void handleMessage(int i11, @Nullable Object obj) {
            if (i11 == 7) {
                this.f10059a = (androidx.media3.exoplayer.video.o) obj;
                return;
            }
            if (i11 == 8) {
                this.f10060b = (t4.a) obj;
                return;
            }
            if (i11 != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.f10061c = null;
                this.f10062d = null;
            } else {
                this.f10061c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f10062d = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f10063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.media3.exoplayer.source.l f10064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.media3.common.m0 f10065c;

        public f(Object obj, androidx.media3.exoplayer.source.j jVar) {
            this.f10063a = obj;
            this.f10064b = jVar;
            this.f10065c = jVar.W();
        }

        @Override // androidx.media3.exoplayer.d2
        public Object a() {
            return this.f10063a;
        }

        @Override // androidx.media3.exoplayer.d2
        public androidx.media3.common.m0 b() {
            return this.f10065c;
        }

        public void d(androidx.media3.common.m0 m0Var) {
            this.f10065c = m0Var;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public final class g extends AudioDeviceCallback {
        public g() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (c1.this.G1() && c1.this.f10049u0.f11077m == 3) {
                c1 c1Var = c1.this;
                c1Var.C2(c1Var.f10049u0.f11076l, 1, 0);
            }
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (c1.this.G1()) {
                return;
            }
            c1 c1Var = c1.this;
            c1Var.C2(c1Var.f10049u0.f11076l, 1, 3);
        }
    }

    static {
        androidx.media3.common.c0.a("media3.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"HandlerLeak"})
    public c1(u.b bVar, @Nullable androidx.media3.common.h0 h0Var) {
        f3 f3Var;
        z3.g gVar = new z3.g();
        this.f10014d = gVar;
        try {
            z3.o.f("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.3.1] [" + z3.u0.f81842e + "]");
            Context applicationContext = bVar.f11397a.getApplicationContext();
            this.f10016e = applicationContext;
            e4.a aVarApply = bVar.f11405i.apply(bVar.f11398b);
            this.f10042r = aVarApply;
            this.f10037o0 = bVar.f11407k;
            this.f10025i0 = bVar.f11408l;
            this.f10013c0 = bVar.f11414r;
            this.f10015d0 = bVar.f11415s;
            this.f10029k0 = bVar.f11412p;
            this.E = bVar.f11422z;
            d dVar = new d();
            this.f10054x = dVar;
            e eVar = new e();
            this.f10056y = eVar;
            Handler handler = new Handler(bVar.f11406j);
            w2[] w2VarArrA = bVar.f11400d.get2().a(handler, dVar, dVar, dVar, dVar);
            this.f10020g = w2VarArrA;
            z3.a.g(w2VarArrA.length > 0);
            s4.e0 e0Var = bVar.f11402f.get2();
            this.f10022h = e0Var;
            this.f10040q = bVar.f11401e.get2();
            androidx.media3.exoplayer.upstream.e eVar2 = bVar.f11404h.get2();
            this.f10046t = eVar2;
            this.f10038p = bVar.f11416t;
            this.N = bVar.f11417u;
            this.f10048u = bVar.f11418v;
            this.f10050v = bVar.f11419w;
            this.P = bVar.A;
            Looper looper = bVar.f11406j;
            this.f10044s = looper;
            z3.d dVar2 = bVar.f11398b;
            this.f10052w = dVar2;
            androidx.media3.common.h0 h0Var2 = h0Var == null ? this : h0Var;
            this.f10018f = h0Var2;
            boolean z11 = bVar.E;
            this.G = z11;
            this.f10030l = new z3.n<>(looper, dVar2, new z3.n.b() { // from class: androidx.media3.exoplayer.k0
                @Override // z3.n.b
                public final void a(Object obj, androidx.media3.common.s sVar) {
                    this.f10649a.K1((androidx.media3.common.h0.d) obj, sVar);
                }
            });
            this.f10032m = new CopyOnWriteArraySet<>();
            this.f10036o = new ArrayList();
            this.O = new p4.f0.a(0);
            s4.f0 f0Var = new s4.f0(new z2[w2VarArrA.length], new s4.z[w2VarArrA.length], androidx.media3.common.q0.f9426b, null);
            this.f10010b = f0Var;
            this.f10034n = new androidx.media3.common.m0.b();
            androidx.media3.common.h0.b bVarE = new androidx.media3.common.h0.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32).d(29, e0Var.h()).d(23, bVar.f11413q).d(25, bVar.f11413q).d(33, bVar.f11413q).d(26, bVar.f11413q).d(34, bVar.f11413q).e();
            this.f10012c = bVarE;
            this.Q = new androidx.media3.common.h0.b.a().b(bVarE).a(4).a(10).e();
            this.f10024i = dVar2.createHandler(looper, null);
            s1.f fVar = new s1.f() { // from class: androidx.media3.exoplayer.l0
                @Override // androidx.media3.exoplayer.s1.f
                public final void a(s1.e eVar3) {
                    this.f10666a.M1(eVar3);
                }
            };
            this.f10026j = fVar;
            this.f10049u0 = s2.k(f0Var);
            aVarApply.G(h0Var2, looper);
            int i11 = z3.u0.f81838a;
            s1 s1Var = new s1(w2VarArrA, e0Var, f0Var, bVar.f11403g.get2(), eVar2, this.H, this.I, aVarApply, this.N, bVar.f11420x, bVar.f11421y, this.P, looper, dVar2, fVar, i11 < 31 ? new x3() : c.a(applicationContext, this, bVar.B), bVar.C);
            this.f10028k = s1Var;
            this.f10027j0 = 1.0f;
            this.H = 0;
            androidx.media3.common.d0 d0Var = androidx.media3.common.d0.G;
            this.R = d0Var;
            this.S = d0Var;
            this.f10047t0 = d0Var;
            this.f10051v0 = -1;
            if (i11 < 21) {
                this.f10023h0 = H1(0);
            } else {
                this.f10023h0 = z3.u0.J(applicationContext);
            }
            this.f10031l0 = y3.b.f81143c;
            this.f10033m0 = true;
            K(aVarApply);
            eVar2.d(new Handler(looper), aVarApply);
            k1(dVar);
            long j11 = bVar.f11399c;
            if (j11 > 0) {
                s1Var.x(j11);
            }
            AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(bVar.f11397a, handler, dVar);
            this.f10057z = audioBecomingNoisyManager;
            audioBecomingNoisyManager.b(bVar.f11411o);
            l lVar = new l(bVar.f11397a, handler, dVar);
            this.A = lVar;
            lVar.m(bVar.f11409m ? this.f10025i0 : null);
            if (!z11 || i11 < 23) {
                f3Var = null;
            } else {
                AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                this.F = audioManager;
                f3Var = null;
                b.b(audioManager, new g(), new Handler(looper));
            }
            if (bVar.f11413q) {
                f3 f3Var2 = new f3(bVar.f11397a, handler, dVar);
                this.B = f3Var2;
                f3Var2.j(z3.u0.p0(this.f10025i0.f9132c));
            } else {
                this.B = f3Var;
            }
            h3 h3Var = new h3(bVar.f11397a);
            this.C = h3Var;
            h3Var.a(bVar.f11410n != 0);
            i3 i3Var = new i3(bVar.f11397a);
            this.D = i3Var;
            i3Var.a(bVar.f11410n == 2);
            this.f10043r0 = s1(this.B);
            this.f10045s0 = androidx.media3.common.t0.f9443e;
            this.f10017e0 = z3.e0.f81770c;
            e0Var.l(this.f10025i0);
            o2(1, 10, Integer.valueOf(this.f10023h0));
            o2(2, 10, Integer.valueOf(this.f10023h0));
            o2(1, 3, this.f10025i0);
            o2(2, 4, Integer.valueOf(this.f10013c0));
            o2(2, 5, Integer.valueOf(this.f10015d0));
            o2(1, 9, Boolean.valueOf(this.f10029k0));
            o2(2, 7, eVar);
            o2(6, 8, eVar);
            gVar.f();
        } catch (Throwable th2) {
            this.f10014d.f();
            throw th2;
        }
    }

    public static int B1(boolean z11, int i11) {
        return (!z11 || i11 == 1) ? 1 : 2;
    }

    public static long E1(s2 s2Var) {
        androidx.media3.common.m0.c cVar = new androidx.media3.common.m0.c();
        androidx.media3.common.m0.b bVar = new androidx.media3.common.m0.b();
        s2Var.f11065a.h(s2Var.f11066b.f11209a, bVar);
        return s2Var.f11067c == C.TIME_UNSET ? s2Var.f11065a.n(bVar.f9295c, cVar).c() : bVar.o() + s2Var.f11067c;
    }

    public static /* synthetic */ void N1(androidx.media3.common.h0.d dVar) {
        dVar.onPlayerError(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }

    public static /* synthetic */ void T1(s2 s2Var, int i11, androidx.media3.common.h0.d dVar) {
        dVar.onTimelineChanged(s2Var.f11065a, i11);
    }

    public static /* synthetic */ void U1(int i11, androidx.media3.common.h0.e eVar, androidx.media3.common.h0.e eVar2, androidx.media3.common.h0.d dVar) {
        dVar.onPositionDiscontinuity(i11);
        dVar.onPositionDiscontinuity(eVar, eVar2, i11);
    }

    public static /* synthetic */ void W1(s2 s2Var, androidx.media3.common.h0.d dVar) {
        dVar.onPlayerErrorChanged(s2Var.f11070f);
    }

    public static /* synthetic */ void X1(s2 s2Var, androidx.media3.common.h0.d dVar) {
        dVar.onPlayerError(s2Var.f11070f);
    }

    public static /* synthetic */ void Y1(s2 s2Var, androidx.media3.common.h0.d dVar) {
        dVar.onTracksChanged(s2Var.f11073i.f76011d);
    }

    public static /* synthetic */ void a2(s2 s2Var, androidx.media3.common.h0.d dVar) {
        dVar.onLoadingChanged(s2Var.f11071g);
        dVar.onIsLoadingChanged(s2Var.f11071g);
    }

    public static /* synthetic */ void b2(s2 s2Var, androidx.media3.common.h0.d dVar) {
        dVar.onPlayerStateChanged(s2Var.f11076l, s2Var.f11069e);
    }

    public static /* synthetic */ void c2(s2 s2Var, androidx.media3.common.h0.d dVar) {
        dVar.onPlaybackStateChanged(s2Var.f11069e);
    }

    public static /* synthetic */ void d2(s2 s2Var, int i11, androidx.media3.common.h0.d dVar) {
        dVar.onPlayWhenReadyChanged(s2Var.f11076l, i11);
    }

    public static /* synthetic */ void e2(s2 s2Var, androidx.media3.common.h0.d dVar) {
        dVar.onPlaybackSuppressionReasonChanged(s2Var.f11077m);
    }

    public static /* synthetic */ void f2(s2 s2Var, androidx.media3.common.h0.d dVar) {
        dVar.onIsPlayingChanged(s2Var.n());
    }

    public static /* synthetic */ void g2(s2 s2Var, androidx.media3.common.h0.d dVar) {
        dVar.onPlaybackParametersChanged(s2Var.f11078n);
    }

    public static androidx.media3.common.o s1(@Nullable f3 f3Var) {
        return new androidx.media3.common.o.b(0).g(f3Var != null ? f3Var.d() : 0).f(f3Var != null ? f3Var.c() : 0).e();
    }

    @Nullable
    public final Pair<Object, Long> A1(androidx.media3.common.m0 m0Var, androidx.media3.common.m0 m0Var2, int i11, long j11) {
        boolean zQ = m0Var.q();
        long j12 = C.TIME_UNSET;
        if (zQ || m0Var2.q()) {
            boolean z11 = !m0Var.q() && m0Var2.q();
            int i12 = z11 ? -1 : i11;
            if (!z11) {
                j12 = j11;
            }
            return i2(m0Var2, i12, j12);
        }
        Pair<Object, Long> pairJ = m0Var.j(this.f9225a, this.f10034n, i11, z3.u0.S0(j11));
        Object obj = ((Pair) z3.u0.i(pairJ)).first;
        if (m0Var2.b(obj) != -1) {
            return pairJ;
        }
        Object objE0 = s1.E0(this.f9225a, this.f10034n, this.H, this.I, obj, m0Var, m0Var2);
        if (objE0 == null) {
            return i2(m0Var2, -1, C.TIME_UNSET);
        }
        m0Var2.h(objE0, this.f10034n);
        int i13 = this.f10034n.f9295c;
        return i2(m0Var2, i13, m0Var2.n(i13, this.f9225a).b());
    }

    public final void A2(boolean z11, int i11, int i12) {
        boolean z12 = z11 && i11 != -1;
        int iR1 = r1(z12, i11);
        s2 s2Var = this.f10049u0;
        if (s2Var.f11076l == z12 && s2Var.f11077m == iR1) {
            return;
        }
        C2(z12, i12, iR1);
    }

    @Override // androidx.media3.common.h0
    public void B(boolean z11, int i11) {
        F2();
        f3 f3Var = this.B;
        if (f3Var != null) {
            f3Var.i(z11, i11);
        }
    }

    public final void B2(final s2 s2Var, final int i11, final int i12, boolean z11, final int i13, long j11, int i14, boolean z12) {
        s2 s2Var2 = this.f10049u0;
        this.f10049u0 = s2Var;
        boolean z13 = !s2Var2.f11065a.equals(s2Var.f11065a);
        Pair<Boolean, Integer> pairW1 = w1(s2Var, s2Var2, z11, i13, z13, z12);
        boolean zBooleanValue = ((Boolean) pairW1.first).booleanValue();
        final int iIntValue = ((Integer) pairW1.second).intValue();
        final androidx.media3.common.b0 b0Var = null;
        if (zBooleanValue) {
            if (!s2Var.f11065a.q()) {
                b0Var = s2Var.f11065a.n(s2Var.f11065a.h(s2Var.f11066b.f11209a, this.f10034n).f9295c, this.f9225a).f9311c;
            }
            this.f10047t0 = androidx.media3.common.d0.G;
        }
        if (zBooleanValue || !s2Var2.f11074j.equals(s2Var.f11074j)) {
            this.f10047t0 = this.f10047t0.a().L(s2Var.f11074j).H();
        }
        androidx.media3.common.d0 d0VarO1 = o1();
        boolean z14 = !d0VarO1.equals(this.R);
        this.R = d0VarO1;
        boolean z15 = s2Var2.f11076l != s2Var.f11076l;
        boolean z16 = s2Var2.f11069e != s2Var.f11069e;
        if (z16 || z15) {
            E2();
        }
        boolean z17 = s2Var2.f11071g;
        boolean z18 = s2Var.f11071g;
        boolean z19 = z17 != z18;
        if (z19) {
            D2(z18);
        }
        if (z13) {
            this.f10030l.i(0, new z3.n.a() { // from class: androidx.media3.exoplayer.u0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.T1(s2Var, i11, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        if (z11) {
            final androidx.media3.common.h0.e eVarD1 = D1(i13, s2Var2, i14);
            final androidx.media3.common.h0.e eVarC1 = C1(j11);
            this.f10030l.i(11, new z3.n.a() { // from class: androidx.media3.exoplayer.z0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.U1(i13, eVarD1, eVarC1, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.f10030l.i(1, new z3.n.a() { // from class: androidx.media3.exoplayer.a1
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onMediaItemTransition(b0Var, iIntValue);
                }
            });
        }
        if (s2Var2.f11070f != s2Var.f11070f) {
            this.f10030l.i(10, new z3.n.a() { // from class: androidx.media3.exoplayer.b1
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.W1(s2Var, (androidx.media3.common.h0.d) obj);
                }
            });
            if (s2Var.f11070f != null) {
                this.f10030l.i(10, new z3.n.a() { // from class: androidx.media3.exoplayer.e0
                    @Override // z3.n.a
                    public final void invoke(Object obj) {
                        c1.X1(s2Var, (androidx.media3.common.h0.d) obj);
                    }
                });
            }
        }
        s4.f0 f0Var = s2Var2.f11073i;
        s4.f0 f0Var2 = s2Var.f11073i;
        if (f0Var != f0Var2) {
            this.f10022h.i(f0Var2.f76012e);
            this.f10030l.i(2, new z3.n.a() { // from class: androidx.media3.exoplayer.f0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.Y1(s2Var, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        if (z14) {
            final androidx.media3.common.d0 d0Var = this.R;
            this.f10030l.i(14, new z3.n.a() { // from class: androidx.media3.exoplayer.g0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onMediaMetadataChanged(d0Var);
                }
            });
        }
        if (z19) {
            this.f10030l.i(3, new z3.n.a() { // from class: androidx.media3.exoplayer.h0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.a2(s2Var, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        if (z16 || z15) {
            this.f10030l.i(-1, new z3.n.a() { // from class: androidx.media3.exoplayer.i0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.b2(s2Var, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        if (z16) {
            this.f10030l.i(4, new z3.n.a() { // from class: androidx.media3.exoplayer.j0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.c2(s2Var, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        if (z15) {
            this.f10030l.i(5, new z3.n.a() { // from class: androidx.media3.exoplayer.v0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.d2(s2Var, i12, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        if (s2Var2.f11077m != s2Var.f11077m) {
            this.f10030l.i(6, new z3.n.a() { // from class: androidx.media3.exoplayer.w0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.e2(s2Var, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        if (s2Var2.n() != s2Var.n()) {
            this.f10030l.i(7, new z3.n.a() { // from class: androidx.media3.exoplayer.x0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.f2(s2Var, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        if (!s2Var2.f11078n.equals(s2Var.f11078n)) {
            this.f10030l.i(12, new z3.n.a() { // from class: androidx.media3.exoplayer.y0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.g2(s2Var, (androidx.media3.common.h0.d) obj);
                }
            });
        }
        y2();
        this.f10030l.f();
        if (s2Var2.f11079o != s2Var.f11079o) {
            Iterator<u.a> it = this.f10032m.iterator();
            while (it.hasNext()) {
                it.next().z(s2Var.f11079o);
            }
        }
    }

    public final androidx.media3.common.h0.e C1(long j11) {
        Object obj;
        androidx.media3.common.b0 b0Var;
        Object obj2;
        int iB;
        int iU = u();
        if (this.f10049u0.f11065a.q()) {
            obj = null;
            b0Var = null;
            obj2 = null;
            iB = -1;
        } else {
            s2 s2Var = this.f10049u0;
            Object obj3 = s2Var.f11066b.f11209a;
            s2Var.f11065a.h(obj3, this.f10034n);
            iB = this.f10049u0.f11065a.b(obj3);
            obj2 = obj3;
            obj = this.f10049u0.f11065a.n(iU, this.f9225a).f9309a;
            b0Var = this.f9225a.f9311c;
        }
        long jB1 = z3.u0.B1(j11);
        long jB2 = this.f10049u0.f11066b.b() ? z3.u0.B1(E1(this.f10049u0)) : jB1;
        androidx.media3.exoplayer.source.l.b bVar = this.f10049u0.f11066b;
        return new androidx.media3.common.h0.e(obj, iU, b0Var, obj2, iB, jB1, jB2, bVar.f11210b, bVar.f11211c);
    }

    public final void C2(boolean z11, int i11, int i12) {
        this.J++;
        s2 s2VarA = this.f10049u0;
        if (s2VarA.f11079o) {
            s2VarA = s2VarA.a();
        }
        s2 s2VarE = s2VarA.e(z11, i12);
        this.f10028k.W0(z11, i12);
        B2(s2VarE, 0, i11, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // androidx.media3.common.h0
    public void D(int i11, int i12, List<androidx.media3.common.b0> list) {
        F2();
        z3.a.a(i11 >= 0 && i12 >= i11);
        int size = this.f10036o.size();
        if (i11 > size) {
            return;
        }
        int iMin = Math.min(i12, size);
        if (p1(i11, iMin, list)) {
            z2(i11, iMin, list);
            return;
        }
        List<androidx.media3.exoplayer.source.l> listU1 = u1(list);
        if (this.f10036o.isEmpty()) {
            r2(listU1, this.f10051v0 == -1);
        } else {
            s2 s2VarL2 = l2(n1(this.f10049u0, iMin, listU1), i11, iMin);
            B2(s2VarL2, 0, 1, !s2VarL2.f11066b.f11209a.equals(this.f10049u0.f11066b.f11209a), 4, y1(s2VarL2), -1, false);
        }
    }

    public final androidx.media3.common.h0.e D1(int i11, s2 s2Var, int i12) {
        int i13;
        Object obj;
        androidx.media3.common.b0 b0Var;
        Object obj2;
        int i14;
        long jE1;
        long jE2;
        androidx.media3.common.m0.b bVar = new androidx.media3.common.m0.b();
        if (s2Var.f11065a.q()) {
            i13 = i12;
            obj = null;
            b0Var = null;
            obj2 = null;
            i14 = -1;
        } else {
            Object obj3 = s2Var.f11066b.f11209a;
            s2Var.f11065a.h(obj3, bVar);
            int i15 = bVar.f9295c;
            int iB = s2Var.f11065a.b(obj3);
            Object obj4 = s2Var.f11065a.n(i15, this.f9225a).f9309a;
            b0Var = this.f9225a.f9311c;
            obj2 = obj3;
            i14 = iB;
            obj = obj4;
            i13 = i15;
        }
        if (i11 == 0) {
            if (s2Var.f11066b.b()) {
                androidx.media3.exoplayer.source.l.b bVar2 = s2Var.f11066b;
                jE1 = bVar.b(bVar2.f11210b, bVar2.f11211c);
                jE2 = E1(s2Var);
            } else {
                jE1 = s2Var.f11066b.f11213e != -1 ? E1(this.f10049u0) : bVar.f9297e + bVar.f9296d;
                jE2 = jE1;
            }
        } else if (s2Var.f11066b.b()) {
            jE1 = s2Var.f11082r;
            jE2 = E1(s2Var);
        } else {
            jE1 = bVar.f9297e + s2Var.f11082r;
            jE2 = jE1;
        }
        long jB1 = z3.u0.B1(jE1);
        long jB2 = z3.u0.B1(jE2);
        androidx.media3.exoplayer.source.l.b bVar3 = s2Var.f11066b;
        return new androidx.media3.common.h0.e(obj, i13, b0Var, obj2, i14, jB1, jB2, bVar3.f11210b, bVar3.f11211c);
    }

    public final void D2(boolean z11) {
        PriorityTaskManager priorityTaskManager = this.f10037o0;
        if (priorityTaskManager != null) {
            if (z11 && !this.f10039p0) {
                priorityTaskManager.a(0);
                this.f10039p0 = true;
            } else {
                if (z11 || !this.f10039p0) {
                    return;
                }
                priorityTaskManager.d(0);
                this.f10039p0 = false;
            }
        }
    }

    public final void E2() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.C.b(getPlayWhenReady() && !I1());
                this.D.b(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }

    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public final void L1(s1.e eVar) {
        long j11;
        boolean z11;
        long jK2;
        int i11 = this.J - eVar.f11050c;
        this.J = i11;
        boolean z12 = true;
        if (eVar.f11051d) {
            this.K = eVar.f11052e;
            this.L = true;
        }
        if (eVar.f11053f) {
            this.M = eVar.f11054g;
        }
        if (i11 == 0) {
            androidx.media3.common.m0 m0Var = eVar.f11049b.f11065a;
            if (!this.f10049u0.f11065a.q() && m0Var.q()) {
                this.f10051v0 = -1;
                this.f10055x0 = 0L;
                this.f10053w0 = 0;
            }
            if (!m0Var.q()) {
                List<androidx.media3.common.m0> listF = ((u2) m0Var).F();
                z3.a.g(listF.size() == this.f10036o.size());
                for (int i12 = 0; i12 < listF.size(); i12++) {
                    this.f10036o.get(i12).d(listF.get(i12));
                }
            }
            if (this.L) {
                if (eVar.f11049b.f11066b.equals(this.f10049u0.f11066b) && eVar.f11049b.f11068d == this.f10049u0.f11082r) {
                    z12 = false;
                }
                if (z12) {
                    if (m0Var.q() || eVar.f11049b.f11066b.b()) {
                        jK2 = eVar.f11049b.f11068d;
                    } else {
                        s2 s2Var = eVar.f11049b;
                        jK2 = k2(m0Var, s2Var.f11066b, s2Var.f11068d);
                    }
                    j11 = jK2;
                } else {
                    j11 = -9223372036854775807L;
                }
                z11 = z12;
            } else {
                j11 = -9223372036854775807L;
                z11 = false;
            }
            this.L = false;
            B2(eVar.f11049b, 1, this.M, z11, this.K, j11, -1, false);
        }
    }

    public final void F2() {
        this.f10014d.c();
        if (Thread.currentThread() != l().getThread()) {
            String strG = z3.u0.G("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), l().getThread().getName());
            if (this.f10033m0) {
                throw new IllegalStateException(strG);
            }
            z3.o.i("ExoPlayerImpl", strG, this.f10035n0 ? null : new IllegalStateException());
            this.f10035n0 = true;
        }
    }

    @Override // androidx.media3.common.h0
    public void G(int i11, int i12) {
        F2();
        z3.a.a(i11 >= 0 && i12 >= i11);
        int size = this.f10036o.size();
        int iMin = Math.min(i12, size);
        if (i11 >= size || i11 == iMin) {
            return;
        }
        s2 s2VarL2 = l2(this.f10049u0, i11, iMin);
        B2(s2VarL2, 0, 1, !s2VarL2.f11066b.f11209a.equals(this.f10049u0.f11066b.f11209a), 4, y1(s2VarL2), -1, false);
    }

    public final boolean G1() {
        AudioManager audioManager = this.F;
        if (audioManager == null || z3.u0.f81838a < 23) {
            return true;
        }
        return b.a(this.f10016e, audioManager.getDevices(2));
    }

    public final int H1(int i11) {
        AudioTrack audioTrack = this.V;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i11) {
            this.V.release();
            this.V = null;
        }
        if (this.V == null) {
            this.V = new AudioTrack(3, 4000, 4, 2, 2, 0, i11);
        }
        return this.V.getAudioSessionId();
    }

    public boolean I1() {
        F2();
        return this.f10049u0.f11079o;
    }

    @Override // androidx.media3.common.h0
    public void J(androidx.media3.common.h0.d dVar) {
        F2();
        this.f10030l.k((androidx.media3.common.h0.d) z3.a.e(dVar));
    }

    @Override // androidx.media3.common.h0
    public void K(androidx.media3.common.h0.d dVar) {
        this.f10030l.c((androidx.media3.common.h0.d) z3.a.e(dVar));
    }

    public final /* synthetic */ void K1(androidx.media3.common.h0.d dVar, androidx.media3.common.s sVar) {
        dVar.onEvents(this.f10018f, new androidx.media3.common.h0.c(sVar));
    }

    @Override // androidx.media3.exoplayer.u
    public void L(e4.c cVar) {
        this.f10042r.C((e4.c) z3.a.e(cVar));
    }

    public final /* synthetic */ void M1(final s1.e eVar) {
        this.f10024i.post(new Runnable() { // from class: androidx.media3.exoplayer.t0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11379a.L1(eVar);
            }
        });
    }

    @Override // androidx.media3.exoplayer.u
    @Nullable
    public androidx.media3.common.y Q() {
        F2();
        return this.U;
    }

    @Override // androidx.media3.common.h0
    public void R(int i11, List<androidx.media3.common.b0> list) {
        F2();
        m1(i11, u1(list));
    }

    @Override // androidx.media3.exoplayer.u
    public void S(androidx.media3.exoplayer.source.l lVar) {
        F2();
        q2(Collections.singletonList(lVar));
    }

    public final /* synthetic */ void S1(androidx.media3.common.h0.d dVar) {
        dVar.onAvailableCommandsChanged(this.Q);
    }

    @Override // androidx.media3.common.h0
    public void T(final androidx.media3.common.p0 p0Var) {
        F2();
        if (!this.f10022h.h() || p0Var.equals(this.f10022h.c())) {
            return;
        }
        this.f10022h.m(p0Var);
        this.f10030l.l(19, new z3.n.a() { // from class: androidx.media3.exoplayer.o0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((androidx.media3.common.h0.d) obj).onTrackSelectionParametersChanged(p0Var);
            }
        });
    }

    @Override // androidx.media3.common.h0
    public boolean U() {
        F2();
        f3 f3Var = this.B;
        if (f3Var != null) {
            return f3Var.g();
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.u
    @Nullable
    public androidx.media3.common.y a() {
        F2();
        return this.T;
    }

    @Override // androidx.media3.common.h
    public void a0(int i11, long j11, int i12, boolean z11) {
        F2();
        z3.a.a(i11 >= 0);
        this.f10042r.m();
        androidx.media3.common.m0 m0Var = this.f10049u0.f11065a;
        if (m0Var.q() || i11 < m0Var.p()) {
            this.J++;
            if (isPlayingAd()) {
                z3.o.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                s1.e eVar = new s1.e(this.f10049u0);
                eVar.b(1);
                this.f10026j.a(eVar);
                return;
            }
            s2 s2VarH = this.f10049u0;
            int i13 = s2VarH.f11069e;
            if (i13 == 3 || (i13 == 4 && !m0Var.q())) {
                s2VarH = this.f10049u0.h(2);
            }
            int iU = u();
            s2 s2VarH2 = h2(s2VarH, m0Var, i2(m0Var, i11, j11));
            this.f10028k.G0(m0Var, i11, z3.u0.S0(j11));
            B2(s2VarH2, 0, 1, true, 1, y1(s2VarH2), iU, z11);
        }
    }

    @Override // androidx.media3.common.h0
    public void b(androidx.media3.common.g0 g0Var) {
        F2();
        if (g0Var == null) {
            g0Var = androidx.media3.common.g0.f9218d;
        }
        if (this.f10049u0.f11078n.equals(g0Var)) {
            return;
        }
        s2 s2VarG = this.f10049u0.g(g0Var);
        this.J++;
        this.f10028k.Y0(g0Var);
        B2(s2VarG, 0, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // androidx.media3.common.h0
    @Nullable
    public ExoPlaybackException c() {
        F2();
        return this.f10049u0.f11070f;
    }

    @Override // androidx.media3.common.h0
    public void clearVideoSurface() {
        F2();
        n2();
        v2(null);
        j2(0, 0);
    }

    @Override // androidx.media3.common.h0
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        F2();
        q1(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // androidx.media3.common.h0
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        F2();
        if (textureView == null || textureView != this.f10011b0) {
            return;
        }
        clearVideoSurface();
    }

    @Override // androidx.media3.common.h0
    public long d() {
        F2();
        return z3.u0.B1(this.f10049u0.f11081q);
    }

    @Override // androidx.media3.common.h0
    public void e(List<androidx.media3.common.b0> list, boolean z11) {
        F2();
        r2(u1(list), z11);
    }

    @Override // androidx.media3.common.h0
    public long getContentPosition() {
        F2();
        return x1(this.f10049u0);
    }

    @Override // androidx.media3.common.h0
    public int getCurrentAdGroupIndex() {
        F2();
        if (isPlayingAd()) {
            return this.f10049u0.f11066b.f11210b;
        }
        return -1;
    }

    @Override // androidx.media3.common.h0
    public int getCurrentAdIndexInAdGroup() {
        F2();
        if (isPlayingAd()) {
            return this.f10049u0.f11066b.f11211c;
        }
        return -1;
    }

    @Override // androidx.media3.common.h0
    public int getCurrentPeriodIndex() {
        F2();
        if (this.f10049u0.f11065a.q()) {
            return this.f10053w0;
        }
        s2 s2Var = this.f10049u0;
        return s2Var.f11065a.b(s2Var.f11066b.f11209a);
    }

    @Override // androidx.media3.common.h0
    public long getCurrentPosition() {
        F2();
        return z3.u0.B1(y1(this.f10049u0));
    }

    @Override // androidx.media3.common.h0
    public androidx.media3.common.m0 getCurrentTimeline() {
        F2();
        return this.f10049u0.f11065a;
    }

    @Override // androidx.media3.common.h0
    public androidx.media3.common.q0 getCurrentTracks() {
        F2();
        return this.f10049u0.f11073i.f76011d;
    }

    @Override // androidx.media3.common.h0
    public long getDuration() {
        F2();
        if (!isPlayingAd()) {
            return P();
        }
        s2 s2Var = this.f10049u0;
        androidx.media3.exoplayer.source.l.b bVar = s2Var.f11066b;
        s2Var.f11065a.h(bVar.f11209a, this.f10034n);
        return z3.u0.B1(this.f10034n.b(bVar.f11210b, bVar.f11211c));
    }

    @Override // androidx.media3.common.h0
    public boolean getPlayWhenReady() {
        F2();
        return this.f10049u0.f11076l;
    }

    @Override // androidx.media3.common.h0
    public androidx.media3.common.g0 getPlaybackParameters() {
        F2();
        return this.f10049u0.f11078n;
    }

    @Override // androidx.media3.common.h0
    public int getPlaybackState() {
        F2();
        return this.f10049u0.f11069e;
    }

    @Override // androidx.media3.common.h0
    public int getRepeatMode() {
        F2();
        return this.H;
    }

    @Override // androidx.media3.common.h0
    public boolean getShuffleModeEnabled() {
        F2();
        return this.I;
    }

    @Override // androidx.media3.common.h0
    public float getVolume() {
        F2();
        return this.f10027j0;
    }

    @Override // androidx.media3.common.h0
    public y3.b h() {
        F2();
        return this.f10031l0;
    }

    public final s2 h2(s2 s2Var, androidx.media3.common.m0 m0Var, @Nullable Pair<Object, Long> pair) {
        z3.a.a(m0Var.q() || pair != null);
        androidx.media3.common.m0 m0Var2 = s2Var.f11065a;
        long jX1 = x1(s2Var);
        s2 s2VarJ = s2Var.j(m0Var);
        if (m0Var.q()) {
            androidx.media3.exoplayer.source.l.b bVarL = s2.l();
            long jS0 = z3.u0.S0(this.f10055x0);
            s2 s2VarC = s2VarJ.d(bVarL, jS0, jS0, jS0, 0L, p4.k0.f73571d, this.f10010b, ImmutableList.of()).c(bVarL);
            s2VarC.f11080p = s2VarC.f11082r;
            return s2VarC;
        }
        Object obj = s2VarJ.f11066b.f11209a;
        boolean z11 = !obj.equals(((Pair) z3.u0.i(pair)).first);
        androidx.media3.exoplayer.source.l.b bVar = z11 ? new androidx.media3.exoplayer.source.l.b(pair.first) : s2VarJ.f11066b;
        long jLongValue = ((Long) pair.second).longValue();
        long jS1 = z3.u0.S0(jX1);
        if (!m0Var2.q()) {
            jS1 -= m0Var2.h(obj, this.f10034n).o();
        }
        if (z11 || jLongValue < jS1) {
            z3.a.g(!bVar.b());
            s2 s2VarC2 = s2VarJ.d(bVar, jLongValue, jLongValue, jLongValue, 0L, z11 ? p4.k0.f73571d : s2VarJ.f11072h, z11 ? this.f10010b : s2VarJ.f11073i, z11 ? ImmutableList.of() : s2VarJ.f11074j).c(bVar);
            s2VarC2.f11080p = jLongValue;
            return s2VarC2;
        }
        if (jLongValue == jS1) {
            int iB = m0Var.b(s2VarJ.f11075k.f11209a);
            if (iB == -1 || m0Var.f(iB, this.f10034n).f9295c != m0Var.h(bVar.f11209a, this.f10034n).f9295c) {
                m0Var.h(bVar.f11209a, this.f10034n);
                long jB = bVar.b() ? this.f10034n.b(bVar.f11210b, bVar.f11211c) : this.f10034n.f9296d;
                s2VarJ = s2VarJ.d(bVar, s2VarJ.f11082r, s2VarJ.f11082r, s2VarJ.f11068d, jB - s2VarJ.f11082r, s2VarJ.f11072h, s2VarJ.f11073i, s2VarJ.f11074j).c(bVar);
                s2VarJ.f11080p = jB;
            }
        } else {
            z3.a.g(!bVar.b());
            long jMax = Math.max(0L, s2VarJ.f11081q - (jLongValue - jS1));
            long j11 = s2VarJ.f11080p;
            if (s2VarJ.f11075k.equals(s2VarJ.f11066b)) {
                j11 = jLongValue + jMax;
            }
            s2VarJ = s2VarJ.d(bVar, jLongValue, jLongValue, jLongValue, jMax, s2VarJ.f11072h, s2VarJ.f11073i, s2VarJ.f11074j);
            s2VarJ.f11080p = j11;
        }
        return s2VarJ;
    }

    @Nullable
    public final Pair<Object, Long> i2(androidx.media3.common.m0 m0Var, int i11, long j11) {
        if (m0Var.q()) {
            this.f10051v0 = i11;
            if (j11 == C.TIME_UNSET) {
                j11 = 0;
            }
            this.f10055x0 = j11;
            this.f10053w0 = 0;
            return null;
        }
        if (i11 == -1 || i11 >= m0Var.p()) {
            i11 = m0Var.a(this.I);
            j11 = m0Var.n(i11, this.f9225a).b();
        }
        return m0Var.j(this.f9225a, this.f10034n, i11, z3.u0.S0(j11));
    }

    @Override // androidx.media3.common.h0
    public boolean isPlayingAd() {
        F2();
        return this.f10049u0.f11066b.b();
    }

    public final void j2(final int i11, final int i12) {
        if (i11 == this.f10017e0.b() && i12 == this.f10017e0.a()) {
            return;
        }
        this.f10017e0 = new z3.e0(i11, i12);
        this.f10030l.l(24, new z3.n.a() { // from class: androidx.media3.exoplayer.q0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((androidx.media3.common.h0.d) obj).onSurfaceSizeChanged(i11, i12);
            }
        });
        o2(2, 14, new z3.e0(i11, i12));
    }

    @Override // androidx.media3.common.h0
    public int k() {
        F2();
        return this.f10049u0.f11077m;
    }

    public void k1(u.a aVar) {
        this.f10032m.add(aVar);
    }

    public final long k2(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar, long j11) {
        m0Var.h(bVar.f11209a, this.f10034n);
        return j11 + this.f10034n.o();
    }

    @Override // androidx.media3.common.h0
    public Looper l() {
        return this.f10044s;
    }

    public final List<r2.c> l1(int i11, List<androidx.media3.exoplayer.source.l> list) {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            r2.c cVar = new r2.c(list.get(i12), this.f10038p);
            arrayList.add(cVar);
            this.f10036o.add(i12 + i11, new f(cVar.f10997b, cVar.f10996a));
        }
        this.O = this.O.cloneAndInsert(i11, arrayList.size());
        return arrayList;
    }

    public final s2 l2(s2 s2Var, int i11, int i12) {
        int iZ1 = z1(s2Var);
        long jX1 = x1(s2Var);
        androidx.media3.common.m0 m0Var = s2Var.f11065a;
        int size = this.f10036o.size();
        this.J++;
        m2(i11, i12);
        androidx.media3.common.m0 m0VarT1 = t1();
        s2 s2VarH2 = h2(s2Var, m0VarT1, A1(m0Var, m0VarT1, iZ1, jX1));
        int i13 = s2VarH2.f11069e;
        if (i13 != 1 && i13 != 4 && i11 < i12 && i12 == size && iZ1 >= s2VarH2.f11065a.p()) {
            s2VarH2 = s2VarH2.h(4);
        }
        this.f10028k.s0(i11, i12, this.O);
        return s2VarH2;
    }

    @Override // androidx.media3.common.h0
    public androidx.media3.common.p0 m() {
        F2();
        return this.f10022h.c();
    }

    public void m1(int i11, List<androidx.media3.exoplayer.source.l> list) {
        F2();
        z3.a.a(i11 >= 0);
        int iMin = Math.min(i11, this.f10036o.size());
        if (this.f10036o.isEmpty()) {
            r2(list, this.f10051v0 == -1);
        } else {
            B2(n1(this.f10049u0, iMin, list), 0, 1, false, 5, C.TIME_UNSET, -1, false);
        }
    }

    public final void m2(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            this.f10036o.remove(i13);
        }
        this.O = this.O.a(i11, i12);
    }

    public final s2 n1(s2 s2Var, int i11, List<androidx.media3.exoplayer.source.l> list) {
        androidx.media3.common.m0 m0Var = s2Var.f11065a;
        this.J++;
        List<r2.c> listL1 = l1(i11, list);
        androidx.media3.common.m0 m0VarT1 = t1();
        s2 s2VarH2 = h2(s2Var, m0VarT1, A1(m0Var, m0VarT1, z1(s2Var), x1(s2Var)));
        this.f10028k.m(i11, listL1, this.O);
        return s2VarH2;
    }

    public final void n2() {
        if (this.Z != null) {
            v1(this.f10056y).n(10000).m(null).l();
            this.Z.removeVideoSurfaceListener(this.f10054x);
            this.Z = null;
        }
        TextureView textureView = this.f10011b0;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f10054x) {
                z3.o.h("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f10011b0.setSurfaceTextureListener(null);
            }
            this.f10011b0 = null;
        }
        SurfaceHolder surfaceHolder = this.Y;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f10054x);
            this.Y = null;
        }
    }

    @Override // androidx.media3.common.h0
    public androidx.media3.common.h0.b o() {
        F2();
        return this.Q;
    }

    public final androidx.media3.common.d0 o1() {
        androidx.media3.common.m0 currentTimeline = getCurrentTimeline();
        if (currentTimeline.q()) {
            return this.f10047t0;
        }
        return this.f10047t0.a().J(currentTimeline.n(u(), this.f9225a).f9311c.f8954e).H();
    }

    public final void o2(int i11, int i12, @Nullable Object obj) {
        for (w2 w2Var : this.f10020g) {
            if (w2Var.getTrackType() == i11) {
                v1(w2Var).n(i12).m(obj).l();
            }
        }
    }

    @Override // androidx.media3.common.h0
    public long p() {
        F2();
        return 3000L;
    }

    public final boolean p1(int i11, int i12, List<androidx.media3.common.b0> list) {
        if (i12 - i11 != list.size()) {
            return false;
        }
        for (int i13 = i11; i13 < i12; i13++) {
            if (!this.f10036o.get(i13).f10064b.q(list.get(i13 - i11))) {
                return false;
            }
        }
        return true;
    }

    public final void p2() {
        o2(1, 2, Float.valueOf(this.f10027j0 * this.A.g()));
    }

    @Override // androidx.media3.common.h0
    public void prepare() {
        F2();
        boolean playWhenReady = getPlayWhenReady();
        int iP = this.A.p(playWhenReady, 2);
        A2(playWhenReady, iP, B1(playWhenReady, iP));
        s2 s2Var = this.f10049u0;
        if (s2Var.f11069e != 1) {
            return;
        }
        s2 s2VarF = s2Var.f(null);
        s2 s2VarH = s2VarF.h(s2VarF.f11065a.q() ? 4 : 2);
        this.J++;
        this.f10028k.m0();
        B2(s2VarH, 1, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // androidx.media3.common.h0
    public androidx.media3.common.t0 q() {
        F2();
        return this.f10045s0;
    }

    public void q1(@Nullable SurfaceHolder surfaceHolder) {
        F2();
        if (surfaceHolder == null || surfaceHolder != this.Y) {
            return;
        }
        clearVideoSurface();
    }

    public void q2(List<androidx.media3.exoplayer.source.l> list) {
        F2();
        r2(list, true);
    }

    public final int r1(boolean z11, int i11) {
        if (z11 && i11 != 1) {
            return 1;
        }
        if (!this.G) {
            return 0;
        }
        if (!z11 || G1()) {
            return (z11 || this.f10049u0.f11077m != 3) ? 0 : 3;
        }
        return 3;
    }

    public void r2(List<androidx.media3.exoplayer.source.l> list, boolean z11) {
        F2();
        s2(list, -1, C.TIME_UNSET, z11);
    }

    @Override // androidx.media3.common.h0
    public void release() {
        AudioTrack audioTrack;
        z3.o.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.3.1] [" + z3.u0.f81842e + "] [" + androidx.media3.common.c0.b() + "]");
        F2();
        if (z3.u0.f81838a < 21 && (audioTrack = this.V) != null) {
            audioTrack.release();
            this.V = null;
        }
        this.f10057z.b(false);
        f3 f3Var = this.B;
        if (f3Var != null) {
            f3Var.h();
        }
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.f10028k.o0()) {
            this.f10030l.l(10, new z3.n.a() { // from class: androidx.media3.exoplayer.n0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    c1.N1((androidx.media3.common.h0.d) obj);
                }
            });
        }
        this.f10030l.j();
        this.f10024i.removeCallbacksAndMessages(null);
        this.f10046t.c(this.f10042r);
        s2 s2Var = this.f10049u0;
        if (s2Var.f11079o) {
            this.f10049u0 = s2Var.a();
        }
        s2 s2VarH = this.f10049u0.h(1);
        this.f10049u0 = s2VarH;
        s2 s2VarC = s2VarH.c(s2VarH.f11066b);
        this.f10049u0 = s2VarC;
        s2VarC.f11080p = s2VarC.f11082r;
        this.f10049u0.f11081q = 0L;
        this.f10042r.release();
        this.f10022h.j();
        n2();
        Surface surface = this.X;
        if (surface != null) {
            surface.release();
            this.X = null;
        }
        if (this.f10039p0) {
            ((PriorityTaskManager) z3.a.e(this.f10037o0)).d(0);
            this.f10039p0 = false;
        }
        this.f10031l0 = y3.b.f81143c;
        this.f10041q0 = true;
    }

    @Override // androidx.media3.common.h0
    public long s() {
        F2();
        return this.f10050v;
    }

    public final void s2(List<androidx.media3.exoplayer.source.l> list, int i11, long j11, boolean z11) {
        int i12;
        long j12;
        int iZ1 = z1(this.f10049u0);
        long currentPosition = getCurrentPosition();
        this.J++;
        if (!this.f10036o.isEmpty()) {
            m2(0, this.f10036o.size());
        }
        List<r2.c> listL1 = l1(0, list);
        androidx.media3.common.m0 m0VarT1 = t1();
        if (!m0VarT1.q() && i11 >= m0VarT1.p()) {
            throw new IllegalSeekPositionException(m0VarT1, i11, j11);
        }
        if (z11) {
            int iA = m0VarT1.a(this.I);
            j12 = C.TIME_UNSET;
            i12 = iA;
        } else if (i11 == -1) {
            i12 = iZ1;
            j12 = currentPosition;
        } else {
            i12 = i11;
            j12 = j11;
        }
        s2 s2VarH2 = h2(this.f10049u0, m0VarT1, i2(m0VarT1, i12, j12));
        int i13 = s2VarH2.f11069e;
        if (i12 != -1 && i13 != 1) {
            i13 = (m0VarT1.q() || i12 >= m0VarT1.p()) ? 4 : 2;
        }
        s2 s2VarH = s2VarH2.h(i13);
        this.f10028k.T0(listL1, i12, z3.u0.S0(j12), this.O);
        B2(s2VarH, 0, 1, (this.f10049u0.f11066b.f11209a.equals(s2VarH.f11066b.f11209a) || this.f10049u0.f11065a.q()) ? false : true, 4, y1(s2VarH), -1, false);
    }

    @Override // androidx.media3.common.h0
    public void setPlayWhenReady(boolean z11) {
        F2();
        int iP = this.A.p(z11, getPlaybackState());
        A2(z11, iP, B1(z11, iP));
    }

    @Override // androidx.media3.common.h0
    public void setRepeatMode(final int i11) {
        F2();
        if (this.H != i11) {
            this.H = i11;
            this.f10028k.a1(i11);
            this.f10030l.i(8, new z3.n.a() { // from class: androidx.media3.exoplayer.m0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onRepeatModeChanged(i11);
                }
            });
            y2();
            this.f10030l.f();
        }
    }

    @Override // androidx.media3.common.h0
    public void setShuffleModeEnabled(final boolean z11) {
        F2();
        if (this.I != z11) {
            this.I = z11;
            this.f10028k.d1(z11);
            this.f10030l.i(9, new z3.n.a() { // from class: androidx.media3.exoplayer.p0
                @Override // z3.n.a
                public final void invoke(Object obj) {
                    ((androidx.media3.common.h0.d) obj).onShuffleModeEnabledChanged(z11);
                }
            });
            y2();
            this.f10030l.f();
        }
    }

    @Override // androidx.media3.common.h0
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        F2();
        if (surfaceView instanceof androidx.media3.exoplayer.video.n) {
            n2();
            v2(surfaceView);
            t2(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof SphericalGLSurfaceView)) {
                w2(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            n2();
            this.Z = (SphericalGLSurfaceView) surfaceView;
            v1(this.f10056y).n(10000).m(this.Z).l();
            this.Z.addVideoSurfaceListener(this.f10054x);
            v2(this.Z.getVideoSurface());
            t2(surfaceView.getHolder());
        }
    }

    @Override // androidx.media3.common.h0
    public void setVideoTextureView(@Nullable TextureView textureView) {
        F2();
        if (textureView == null) {
            clearVideoSurface();
            return;
        }
        n2();
        this.f10011b0 = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            z3.o.h("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f10054x);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            v2(null);
            j2(0, 0);
        } else {
            u2(surfaceTexture);
            j2(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // androidx.media3.common.h0
    public void setVolume(float f11) {
        F2();
        final float fO = z3.u0.o(f11, 0.0f, 1.0f);
        if (this.f10027j0 == fO) {
            return;
        }
        this.f10027j0 = fO;
        p2();
        this.f10030l.l(22, new z3.n.a() { // from class: androidx.media3.exoplayer.r0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                ((androidx.media3.common.h0.d) obj).onVolumeChanged(fO);
            }
        });
    }

    @Override // androidx.media3.common.h0
    public void stop() {
        F2();
        this.A.p(getPlayWhenReady(), 1);
        x2(null);
        this.f10031l0 = new y3.b(ImmutableList.of(), this.f10049u0.f11082r);
    }

    public final androidx.media3.common.m0 t1() {
        return new u2(this.f10036o, this.O);
    }

    public final void t2(SurfaceHolder surfaceHolder) {
        this.f10009a0 = false;
        this.Y = surfaceHolder;
        surfaceHolder.addCallback(this.f10054x);
        Surface surface = this.Y.getSurface();
        if (surface == null || !surface.isValid()) {
            j2(0, 0);
        } else {
            Rect surfaceFrame = this.Y.getSurfaceFrame();
            j2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // androidx.media3.common.h0
    public int u() {
        F2();
        int iZ1 = z1(this.f10049u0);
        if (iZ1 == -1) {
            return 0;
        }
        return iZ1;
    }

    public final List<androidx.media3.exoplayer.source.l> u1(List<androidx.media3.common.b0> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(this.f10040q.c(list.get(i11)));
        }
        return arrayList;
    }

    public final void u2(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        v2(surface);
        this.X = surface;
    }

    @Override // androidx.media3.common.h0
    public long v() {
        F2();
        if (this.f10049u0.f11065a.q()) {
            return this.f10055x0;
        }
        s2 s2Var = this.f10049u0;
        if (s2Var.f11075k.f11212d != s2Var.f11066b.f11212d) {
            return s2Var.f11065a.n(u(), this.f9225a).d();
        }
        long j11 = s2Var.f11080p;
        if (this.f10049u0.f11075k.b()) {
            s2 s2Var2 = this.f10049u0;
            androidx.media3.common.m0.b bVarH = s2Var2.f11065a.h(s2Var2.f11075k.f11209a, this.f10034n);
            long jF = bVarH.f(this.f10049u0.f11075k.f11210b);
            j11 = jF == Long.MIN_VALUE ? bVarH.f9296d : jF;
        }
        s2 s2Var3 = this.f10049u0;
        return z3.u0.B1(k2(s2Var3.f11065a, s2Var3.f11075k, j11));
    }

    public final t2 v1(t2.b bVar) {
        int iZ1 = z1(this.f10049u0);
        s1 s1Var = this.f10028k;
        return new t2(s1Var, bVar, this.f10049u0.f11065a, iZ1 == -1 ? 0 : iZ1, this.f10052w, s1Var.E());
    }

    public final void v2(@Nullable Object obj) {
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (w2 w2Var : this.f10020g) {
            if (w2Var.getTrackType() == 2) {
                arrayList.add(v1(w2Var).n(1).m(obj).l());
            }
        }
        Object obj2 = this.W;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((t2) it.next()).a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z11 = true;
            }
            Object obj3 = this.W;
            Surface surface = this.X;
            if (obj3 == surface) {
                surface.release();
                this.X = null;
            }
        }
        this.W = obj;
        if (z11) {
            x2(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
        }
    }

    public final Pair<Boolean, Integer> w1(s2 s2Var, s2 s2Var2, boolean z11, int i11, boolean z12, boolean z13) {
        androidx.media3.common.m0 m0Var = s2Var2.f11065a;
        androidx.media3.common.m0 m0Var2 = s2Var.f11065a;
        if (m0Var2.q() && m0Var.q()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i12 = 3;
        if (m0Var2.q() != m0Var.q()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (m0Var.n(m0Var.h(s2Var2.f11066b.f11209a, this.f10034n).f9295c, this.f9225a).f9309a.equals(m0Var2.n(m0Var2.h(s2Var.f11066b.f11209a, this.f10034n).f9295c, this.f9225a).f9309a)) {
            if (z11 && i11 == 0 && s2Var2.f11066b.f11212d < s2Var.f11066b.f11212d) {
                return new Pair<>(Boolean.TRUE, 0);
            }
            return (z11 && i11 == 1 && z13) ? new Pair<>(Boolean.TRUE, 2) : new Pair<>(Boolean.FALSE, -1);
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

    public void w2(@Nullable SurfaceHolder surfaceHolder) {
        F2();
        if (surfaceHolder == null) {
            clearVideoSurface();
            return;
        }
        n2();
        this.f10009a0 = true;
        this.Y = surfaceHolder;
        surfaceHolder.addCallback(this.f10054x);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            v2(null);
            j2(0, 0);
        } else {
            v2(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            j2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final long x1(s2 s2Var) {
        if (!s2Var.f11066b.b()) {
            return z3.u0.B1(y1(s2Var));
        }
        s2Var.f11065a.h(s2Var.f11066b.f11209a, this.f10034n);
        return s2Var.f11067c == C.TIME_UNSET ? s2Var.f11065a.n(z1(s2Var), this.f9225a).b() : this.f10034n.n() + z3.u0.B1(s2Var.f11067c);
    }

    public final void x2(@Nullable ExoPlaybackException exoPlaybackException) {
        s2 s2Var = this.f10049u0;
        s2 s2VarC = s2Var.c(s2Var.f11066b);
        s2VarC.f11080p = s2VarC.f11082r;
        s2VarC.f11081q = 0L;
        s2 s2VarH = s2VarC.h(1);
        if (exoPlaybackException != null) {
            s2VarH = s2VarH.f(exoPlaybackException);
        }
        this.J++;
        this.f10028k.n1();
        B2(s2VarH, 0, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // androidx.media3.common.h0
    public androidx.media3.common.d0 y() {
        F2();
        return this.R;
    }

    public final long y1(s2 s2Var) {
        if (s2Var.f11065a.q()) {
            return z3.u0.S0(this.f10055x0);
        }
        long jM = s2Var.f11079o ? s2Var.m() : s2Var.f11082r;
        return s2Var.f11066b.b() ? jM : k2(s2Var.f11065a, s2Var.f11066b, jM);
    }

    public final void y2() {
        androidx.media3.common.h0.b bVar = this.Q;
        androidx.media3.common.h0.b bVarN = z3.u0.N(this.f10018f, this.f10012c);
        this.Q = bVarN;
        if (bVarN.equals(bVar)) {
            return;
        }
        this.f10030l.i(13, new z3.n.a() { // from class: androidx.media3.exoplayer.s0
            @Override // z3.n.a
            public final void invoke(Object obj) {
                this.f11009a.S1((androidx.media3.common.h0.d) obj);
            }
        });
    }

    @Override // androidx.media3.common.h0
    public long z() {
        F2();
        return this.f10048u;
    }

    public final int z1(s2 s2Var) {
        return s2Var.f11065a.q() ? this.f10051v0 : s2Var.f11065a.h(s2Var.f11066b.f11209a, this.f10034n).f9295c;
    }

    public final void z2(int i11, int i12, List<androidx.media3.common.b0> list) {
        this.J++;
        this.f10028k.s1(i11, i12, list);
        for (int i13 = i11; i13 < i12; i13++) {
            f fVar = this.f10036o.get(i13);
            fVar.d(new p4.i0(fVar.b(), list.get(i13 - i11)));
        }
        B2(this.f10049u0.j(t1()), 0, 1, false, 4, C.TIME_UNSET, -1, false);
    }
}
