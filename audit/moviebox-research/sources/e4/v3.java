package e4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.UdpDataSource;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.warren.error.VungleException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(VungleException.WEB_CRASH)
public final class v3 implements c, w3.a {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f63975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w3 f63976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PlaybackSession f63977c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public String f63983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public PlaybackMetrics.Builder f63984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f63985k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public PlaybackException f63988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public b f63989o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public b f63990p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public b f63991q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public androidx.media3.common.y f63992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public androidx.media3.common.y f63993s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public androidx.media3.common.y f63994t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f63995u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f63996v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f63997w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f63998x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f63999y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f64000z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.media3.common.m0.c f63979e = new androidx.media3.common.m0.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.media3.common.m0.b f63980f = new androidx.media3.common.m0.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, Long> f63982h = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Long> f63981g = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f63978d = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f63986l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f63987m = 0;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f64001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f64002b;

        public a(int i11, int i12) {
            this.f64001a = i11;
            this.f64002b = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.y f64003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f64004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f64005c;

        public b(androidx.media3.common.y yVar, int i11, String str) {
            this.f64003a = yVar;
            this.f64004b = i11;
            this.f64005c = str;
        }
    }

    public v3(Context context, PlaybackSession playbackSession) {
        this.f63975a = context.getApplicationContext();
        this.f63977c = playbackSession;
        s1 s1Var = new s1();
        this.f63976b = s1Var;
        s1Var.f(this);
    }

    @SuppressLint({"SwitchIntDef"})
    public static int A0(int i11) {
        switch (z3.u0.b0(i11)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    @Nullable
    public static DrmInitData B0(ImmutableList<androidx.media3.common.q0.a> immutableList) {
        DrmInitData drmInitData;
        com.google.common.collect.g1<androidx.media3.common.q0.a> it = immutableList.iterator();
        while (it.hasNext()) {
            androidx.media3.common.q0.a next = it.next();
            for (int i11 = 0; i11 < next.f9435a; i11++) {
                if (next.h(i11) && (drmInitData = next.b(i11).f9504p) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    public static int C0(DrmInitData drmInitData) {
        for (int i11 = 0; i11 < drmInitData.schemeDataCount; i11++) {
            UUID uuid = drmInitData.get(i11).uuid;
            if (uuid.equals(androidx.media3.common.j.f9254d)) {
                return 3;
            }
            if (uuid.equals(androidx.media3.common.j.f9255e)) {
                return 2;
            }
            if (uuid.equals(androidx.media3.common.j.f9253c)) {
                return 6;
            }
        }
        return 1;
    }

    public static a D0(PlaybackException playbackException, Context context, boolean z11) {
        int i11;
        boolean z12;
        if (playbackException.errorCode == 1001) {
            return new a(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            z12 = exoPlaybackException.type == 1;
            i11 = exoPlaybackException.rendererFormatSupport;
        } else {
            i11 = 0;
            z12 = false;
        }
        Throwable th2 = (Throwable) z3.a.e(playbackException.getCause());
        if (!(th2 instanceof IOException)) {
            if (z12 && (i11 == 0 || i11 == 1)) {
                return new a(35, 0);
            }
            if (z12 && i11 == 3) {
                return new a(15, 0);
            }
            if (z12 && i11 == 2) {
                return new a(23, 0);
            }
            if (th2 instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new a(13, z3.u0.c0(((MediaCodecRenderer.DecoderInitializationException) th2).diagnosticInfo));
            }
            if (th2 instanceof MediaCodecDecoderException) {
                return new a(14, z3.u0.c0(((MediaCodecDecoderException) th2).diagnosticInfo));
            }
            if (th2 instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (th2 instanceof AudioSink.InitializationException) {
                return new a(17, ((AudioSink.InitializationException) th2).audioTrackState);
            }
            if (th2 instanceof AudioSink.WriteException) {
                return new a(18, ((AudioSink.WriteException) th2).errorCode);
            }
            if (z3.u0.f81838a < 16 || !(th2 instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th2).getErrorCode();
            return new a(A0(errorCode), errorCode);
        }
        if (th2 instanceof HttpDataSource.InvalidResponseCodeException) {
            return new a(5, ((HttpDataSource.InvalidResponseCodeException) th2).responseCode);
        }
        if ((th2 instanceof HttpDataSource.InvalidContentTypeException) || (th2 instanceof ParserException)) {
            return new a(z11 ? 10 : 11, 0);
        }
        if ((th2 instanceof HttpDataSource.HttpDataSourceException) || (th2 instanceof UdpDataSource.UdpDataSourceException)) {
            if (z3.t.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th2.getCause();
            if (cause instanceof UnknownHostException) {
                return new a(6, 0);
            }
            if (cause instanceof SocketTimeoutException) {
                return new a(7, 0);
            }
            return ((th2 instanceof HttpDataSource.HttpDataSourceException) && ((HttpDataSource.HttpDataSourceException) th2).type == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (playbackException.errorCode == 1002) {
            return new a(21, 0);
        }
        if (!(th2 instanceof DrmSession.DrmSessionException)) {
            if (!(th2 instanceof FileDataSource.FileDataSourceException) || !(th2.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            Throwable cause2 = ((Throwable) z3.a.e(th2.getCause())).getCause();
            return (z3.u0.f81838a >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        Throwable th3 = (Throwable) z3.a.e(th2.getCause());
        int i12 = z3.u0.f81838a;
        if (i12 >= 21 && (th3 instanceof MediaDrm.MediaDrmStateException)) {
            int iC0 = z3.u0.c0(((MediaDrm.MediaDrmStateException) th3).getDiagnosticInfo());
            return new a(A0(iC0), iC0);
        }
        if (i12 >= 23 && p3.a(th3)) {
            return new a(27, 0);
        }
        if (i12 >= 18 && (th3 instanceof NotProvisionedException)) {
            return new a(24, 0);
        }
        if (i12 >= 18 && (th3 instanceof DeniedByServerException)) {
            return new a(29, 0);
        }
        if (th3 instanceof UnsupportedDrmException) {
            return new a(23, 0);
        }
        return th3 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new a(28, 0) : new a(30, 0);
    }

    public static Pair<String, String> E0(String str) {
        String[] strArrO1 = z3.u0.o1(str, "-");
        return Pair.create(strArrO1[0], strArrO1.length >= 2 ? strArrO1[1] : null);
    }

    public static int G0(Context context) {
        switch (z3.t.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    public static int H0(androidx.media3.common.b0 b0Var) {
        androidx.media3.common.b0.h hVar = b0Var.f8951b;
        if (hVar == null) {
            return 0;
        }
        int iC0 = z3.u0.C0(hVar.f9047a, hVar.f9048b);
        if (iC0 == 0) {
            return 3;
        }
        if (iC0 != 1) {
            return iC0 != 2 ? 1 : 4;
        }
        return 5;
    }

    public static int I0(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 1 : 4;
        }
        return 3;
    }

    @Nullable
    public static v3 y0(Context context) {
        MediaMetricsManager mediaMetricsManagerA = q3.a(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerA == null) {
            return null;
        }
        return new v3(context, mediaMetricsManagerA.createPlaybackSession());
    }

    @Override // e4.c
    public /* synthetic */ void A(c.a aVar, int i11) {
        e4.b.w(this, aVar, i11);
    }

    @Override // e4.c
    public /* synthetic */ void B(c.a aVar, p4.n nVar, p4.o oVar) {
        e4.b.D(this, aVar, nVar, oVar);
    }

    @Override // e4.c
    public /* synthetic */ void C(c.a aVar, androidx.media3.exoplayer.n nVar) {
        e4.b.f(this, aVar, nVar);
    }

    @Override // e4.c
    public /* synthetic */ void D(c.a aVar, androidx.media3.exoplayer.n nVar) {
        e4.b.e(this, aVar, nVar);
    }

    @Override // e4.c
    public /* synthetic */ void E(c.a aVar, boolean z11) {
        e4.b.G(this, aVar, z11);
    }

    @Override // e4.c
    public /* synthetic */ void F(c.a aVar, p4.n nVar, p4.o oVar) {
        e4.b.F(this, aVar, nVar, oVar);
    }

    public LogSessionId F0() {
        return this.f63977c.getSessionId();
    }

    @Override // e4.c
    public /* synthetic */ void G(c.a aVar, long j11) {
        e4.b.i(this, aVar, j11);
    }

    @Override // e4.c
    public /* synthetic */ void H(c.a aVar, int i11) {
        e4.b.N(this, aVar, i11);
    }

    @Override // e4.c
    public /* synthetic */ void I(c.a aVar, androidx.media3.exoplayer.n nVar) {
        e4.b.g0(this, aVar, nVar);
    }

    @Override // e4.c
    public /* synthetic */ void J(c.a aVar, int i11, int i12) {
        e4.b.X(this, aVar, i11, i12);
    }

    public final void J0(c.b bVar) {
        for (int i11 = 0; i11 < bVar.d(); i11++) {
            int iB = bVar.b(i11);
            c.a aVarC = bVar.c(iB);
            if (iB == 0) {
                this.f63976b.g(aVarC);
            } else if (iB == 11) {
                this.f63976b.e(aVarC, this.f63985k);
            } else {
                this.f63976b.c(aVarC);
            }
        }
    }

    @Override // e4.c
    public void K(c.a aVar, androidx.media3.common.h0.e eVar, androidx.media3.common.h0.e eVar2, int i11) {
        if (i11 == 1) {
            this.f63995u = true;
        }
        this.f63985k = i11;
    }

    public final void K0(long j11) {
        int iG0 = G0(this.f63975a);
        if (iG0 != this.f63987m) {
            this.f63987m = iG0;
            this.f63977c.reportNetworkEvent(l3.a().setNetworkType(iG0).setTimeSinceCreatedMillis(j11 - this.f63978d).build());
        }
    }

    @Override // e4.c
    public /* synthetic */ void L(c.a aVar, String str) {
        e4.b.f0(this, aVar, str);
    }

    public final void L0(long j11) {
        PlaybackException playbackException = this.f63988n;
        if (playbackException == null) {
            return;
        }
        a aVarD0 = D0(playbackException, this.f63975a, this.f63996v == 4);
        this.f63977c.reportPlaybackErrorEvent(t1.a().setTimeSinceCreatedMillis(j11 - this.f63978d).setErrorCode(aVarD0.f64001a).setSubErrorCode(aVarD0.f64002b).setException(playbackException).build());
        this.A = true;
        this.f63988n = null;
    }

    @Override // e4.c
    public /* synthetic */ void M(c.a aVar, boolean z11) {
        e4.b.V(this, aVar, z11);
    }

    public final void M0(androidx.media3.common.h0 h0Var, c.b bVar, long j11) {
        if (h0Var.getPlaybackState() != 2) {
            this.f63995u = false;
        }
        if (h0Var.c() == null) {
            this.f63997w = false;
        } else if (bVar.a(10)) {
            this.f63997w = true;
        }
        int iU0 = U0(h0Var);
        if (this.f63986l != iU0) {
            this.f63986l = iU0;
            this.A = true;
            this.f63977c.reportPlaybackStateEvent(a3.a().setState(this.f63986l).setTimeSinceCreatedMillis(j11 - this.f63978d).build());
        }
    }

    @Override // e4.c
    public /* synthetic */ void N(c.a aVar, float f11) {
        e4.b.l0(this, aVar, f11);
    }

    public final void N0(androidx.media3.common.h0 h0Var, c.b bVar, long j11) {
        if (bVar.a(2)) {
            androidx.media3.common.q0 currentTracks = h0Var.getCurrentTracks();
            boolean zC = currentTracks.c(2);
            boolean zC2 = currentTracks.c(1);
            boolean zC3 = currentTracks.c(3);
            if (zC || zC2 || zC3) {
                if (!zC) {
                    S0(j11, null, 0);
                }
                if (!zC2) {
                    O0(j11, null, 0);
                }
                if (!zC3) {
                    Q0(j11, null, 0);
                }
            }
        }
        if (x0(this.f63989o)) {
            b bVar2 = this.f63989o;
            androidx.media3.common.y yVar = bVar2.f64003a;
            if (yVar.f9507s != -1) {
                S0(j11, yVar, bVar2.f64004b);
                this.f63989o = null;
            }
        }
        if (x0(this.f63990p)) {
            b bVar3 = this.f63990p;
            O0(j11, bVar3.f64003a, bVar3.f64004b);
            this.f63990p = null;
        }
        if (x0(this.f63991q)) {
            b bVar4 = this.f63991q;
            Q0(j11, bVar4.f64003a, bVar4.f64004b);
            this.f63991q = null;
        }
    }

    @Override // e4.c
    public /* synthetic */ void O(c.a aVar, AudioSink.a aVar2) {
        e4.b.k(this, aVar, aVar2);
    }

    public final void O0(long j11, @Nullable androidx.media3.common.y yVar, int i11) {
        if (z3.u0.c(this.f63993s, yVar)) {
            return;
        }
        int i12 = (this.f63993s == null && i11 == 0) ? 1 : i11;
        this.f63993s = yVar;
        T0(0, j11, yVar, i12);
    }

    @Override // e4.c
    public /* synthetic */ void P(c.a aVar) {
        e4.b.s(this, aVar);
    }

    public final void P0(androidx.media3.common.h0 h0Var, c.b bVar) {
        DrmInitData drmInitDataB0;
        if (bVar.a(0)) {
            c.a aVarC = bVar.c(0);
            if (this.f63984j != null) {
                R0(aVarC.f63813b, aVarC.f63815d);
            }
        }
        if (bVar.a(2) && this.f63984j != null && (drmInitDataB0 = B0(h0Var.getCurrentTracks().a())) != null) {
            o2.a(z3.u0.i(this.f63984j)).setDrmType(C0(drmInitDataB0));
        }
        if (bVar.a(1011)) {
            this.f64000z++;
        }
    }

    @Override // e4.c
    public /* synthetic */ void Q(c.a aVar, String str) {
        e4.b.d(this, aVar, str);
    }

    public final void Q0(long j11, @Nullable androidx.media3.common.y yVar, int i11) {
        if (z3.u0.c(this.f63994t, yVar)) {
            return;
        }
        int i12 = (this.f63994t == null && i11 == 0) ? 1 : i11;
        this.f63994t = yVar;
        T0(2, j11, yVar, i12);
    }

    @Override // e4.c
    public /* synthetic */ void R(c.a aVar, Exception exc) {
        e4.b.c0(this, aVar, exc);
    }

    public final void R0(androidx.media3.common.m0 m0Var, @Nullable androidx.media3.exoplayer.source.l.b bVar) {
        int iB;
        PlaybackMetrics.Builder builder = this.f63984j;
        if (bVar == null || (iB = m0Var.b(bVar.f11209a)) == -1) {
            return;
        }
        m0Var.f(iB, this.f63980f);
        m0Var.n(this.f63980f.f9295c, this.f63979e);
        builder.setStreamType(H0(this.f63979e.f9311c));
        androidx.media3.common.m0.c cVar = this.f63979e;
        if (cVar.f9322n != C.TIME_UNSET && !cVar.f9320l && !cVar.f9317i && !cVar.f()) {
            builder.setMediaDurationMillis(this.f63979e.d());
        }
        builder.setPlaybackType(this.f63979e.f() ? 2 : 1);
        this.A = true;
    }

    @Override // e4.c
    public /* synthetic */ void S(c.a aVar, int i11) {
        e4.b.M(this, aVar, i11);
    }

    public final void S0(long j11, @Nullable androidx.media3.common.y yVar, int i11) {
        if (z3.u0.c(this.f63992r, yVar)) {
            return;
        }
        int i12 = (this.f63992r == null && i11 == 0) ? 1 : i11;
        this.f63992r = yVar;
        T0(1, j11, yVar, i12);
    }

    @Override // e4.c
    public /* synthetic */ void T(c.a aVar, androidx.media3.common.y yVar, androidx.media3.exoplayer.o oVar) {
        e4.b.j0(this, aVar, yVar, oVar);
    }

    public final void T0(int i11, long j11, @Nullable androidx.media3.common.y yVar, int i12) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = e2.a(i11).setTimeSinceCreatedMillis(j11 - this.f63978d);
        if (yVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(I0(i12));
            String str = yVar.f9500l;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = yVar.f9501m;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = yVar.f9498j;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i13 = yVar.f9497i;
            if (i13 != -1) {
                timeSinceCreatedMillis.setBitrate(i13);
            }
            int i14 = yVar.f9506r;
            if (i14 != -1) {
                timeSinceCreatedMillis.setWidth(i14);
            }
            int i15 = yVar.f9507s;
            if (i15 != -1) {
                timeSinceCreatedMillis.setHeight(i15);
            }
            int i16 = yVar.f9514z;
            if (i16 != -1) {
                timeSinceCreatedMillis.setChannelCount(i16);
            }
            int i17 = yVar.A;
            if (i17 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i17);
            }
            String str4 = yVar.f9492d;
            if (str4 != null) {
                Pair<String, String> pairE0 = E0(str4);
                timeSinceCreatedMillis.setLanguage((String) pairE0.first);
                Object obj = pairE0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f11 = yVar.f9508t;
            if (f11 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f11);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        this.f63977c.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @Override // e4.c
    public /* synthetic */ void U(c.a aVar, String str, long j11) {
        e4.b.b(this, aVar, str, j11);
    }

    public final int U0(androidx.media3.common.h0 h0Var) {
        int playbackState = h0Var.getPlaybackState();
        if (this.f63995u) {
            return 5;
        }
        if (this.f63997w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i11 = this.f63986l;
            if (i11 == 0 || i11 == 2) {
                return 2;
            }
            if (h0Var.getPlayWhenReady()) {
                return h0Var.k() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (h0Var.getPlayWhenReady()) {
                return h0Var.k() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.f63986l == 0) {
            return this.f63986l;
        }
        return 12;
    }

    @Override // e4.c
    public /* synthetic */ void V(c.a aVar, androidx.media3.common.b0 b0Var, int i11) {
        e4.b.H(this, aVar, b0Var, i11);
    }

    @Override // e4.c
    public /* synthetic */ void W(c.a aVar, androidx.media3.common.y yVar, androidx.media3.exoplayer.o oVar) {
        e4.b.h(this, aVar, yVar, oVar);
    }

    @Override // e4.c
    public /* synthetic */ void X(c.a aVar, boolean z11, int i11) {
        e4.b.Q(this, aVar, z11, i11);
    }

    @Override // e4.c
    public /* synthetic */ void Y(c.a aVar, String str, long j11) {
        e4.b.d0(this, aVar, str, j11);
    }

    @Override // e4.c
    public /* synthetic */ void Z(c.a aVar, AudioSink.a aVar2) {
        e4.b.l(this, aVar, aVar2);
    }

    @Override // e4.w3.a
    public void a(c.a aVar, String str, String str2) {
    }

    @Override // e4.c
    public /* synthetic */ void a0(c.a aVar) {
        e4.b.y(this, aVar);
    }

    @Override // e4.c
    public /* synthetic */ void b(c.a aVar, List list) {
        e4.b.o(this, aVar, list);
    }

    @Override // e4.c
    public /* synthetic */ void b0(c.a aVar, androidx.media3.common.d0 d0Var) {
        e4.b.I(this, aVar, d0Var);
    }

    @Override // e4.c
    public /* synthetic */ void c(c.a aVar, boolean z11) {
        e4.b.W(this, aVar, z11);
    }

    @Override // e4.c
    public /* synthetic */ void c0(c.a aVar, androidx.media3.common.p0 p0Var) {
        e4.b.Z(this, aVar, p0Var);
    }

    @Override // e4.c
    public /* synthetic */ void d(c.a aVar, Exception exc) {
        e4.b.j(this, aVar, exc);
    }

    @Override // e4.c
    public /* synthetic */ void d0(c.a aVar, int i11) {
        e4.b.Y(this, aVar, i11);
    }

    @Override // e4.c
    public /* synthetic */ void e(c.a aVar, boolean z11) {
        e4.b.C(this, aVar, z11);
    }

    @Override // e4.c
    public void e0(androidx.media3.common.h0 h0Var, c.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        J0(bVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        P0(h0Var, bVar);
        L0(jElapsedRealtime);
        N0(h0Var, bVar, jElapsedRealtime);
        K0(jElapsedRealtime);
        M0(h0Var, bVar, jElapsedRealtime);
        if (bVar.a(1028)) {
            this.f63976b.d(bVar.c(1028));
        }
    }

    @Override // e4.c
    public /* synthetic */ void f(c.a aVar, androidx.media3.common.h0.b bVar) {
        e4.b.n(this, aVar, bVar);
    }

    @Override // e4.c
    public /* synthetic */ void f0(c.a aVar, p4.o oVar) {
        e4.b.b0(this, aVar, oVar);
    }

    @Override // e4.c
    public /* synthetic */ void g(c.a aVar, Object obj, long j11) {
        e4.b.S(this, aVar, obj, j11);
    }

    @Override // e4.c
    public void g0(c.a aVar, androidx.media3.exoplayer.n nVar) {
        this.f63998x += nVar.f10778g;
        this.f63999y += nVar.f10776e;
    }

    @Override // e4.c
    public /* synthetic */ void h(c.a aVar, int i11, long j11, long j12) {
        e4.b.m(this, aVar, i11, j11, j12);
    }

    @Override // e4.c
    public /* synthetic */ void h0(c.a aVar, androidx.media3.common.y yVar) {
        e4.b.i0(this, aVar, yVar);
    }

    @Override // e4.c
    public void i(c.a aVar, int i11, long j11, long j12) {
        androidx.media3.exoplayer.source.l.b bVar = aVar.f63815d;
        if (bVar != null) {
            String strB = this.f63976b.b(aVar.f63813b, (androidx.media3.exoplayer.source.l.b) z3.a.e(bVar));
            Long l11 = this.f63982h.get(strB);
            Long l12 = this.f63981g.get(strB);
            this.f63982h.put(strB, Long.valueOf((l11 == null ? 0L : l11.longValue()) + j11));
            this.f63981g.put(strB, Long.valueOf((l12 != null ? l12.longValue() : 0L) + ((long) i11)));
        }
    }

    @Override // e4.c
    public /* synthetic */ void i0(c.a aVar, int i11) {
        e4.b.T(this, aVar, i11);
    }

    @Override // e4.c
    public /* synthetic */ void j(c.a aVar, boolean z11, int i11) {
        e4.b.K(this, aVar, z11, i11);
    }

    @Override // e4.c
    public void j0(c.a aVar, androidx.media3.common.t0 t0Var) {
        b bVar = this.f63989o;
        if (bVar != null) {
            androidx.media3.common.y yVar = bVar.f64003a;
            if (yVar.f9507s == -1) {
                this.f63989o = new b(yVar.b().r0(t0Var.f9449a).V(t0Var.f9450b).I(), bVar.f64004b, bVar.f64005c);
            }
        }
    }

    @Override // e4.c
    public /* synthetic */ void k(c.a aVar) {
        e4.b.u(this, aVar);
    }

    @Override // e4.c
    public /* synthetic */ void k0(c.a aVar, p4.n nVar, p4.o oVar) {
        e4.b.E(this, aVar, nVar, oVar);
    }

    @Override // e4.c
    public /* synthetic */ void l(c.a aVar, int i11) {
        e4.b.R(this, aVar, i11);
    }

    @Override // e4.c
    public /* synthetic */ void l0(c.a aVar, int i11, long j11) {
        e4.b.z(this, aVar, i11, j11);
    }

    @Override // e4.c
    public /* synthetic */ void m(c.a aVar, androidx.media3.common.y yVar) {
        e4.b.g(this, aVar, yVar);
    }

    @Override // e4.c
    public void m0(c.a aVar, p4.n nVar, p4.o oVar, IOException iOException, boolean z11) {
        this.f63996v = oVar.f73586a;
    }

    @Override // e4.c
    public /* synthetic */ void n(c.a aVar, String str, long j11, long j12) {
        e4.b.c(this, aVar, str, j11, j12);
    }

    @Override // e4.c
    public /* synthetic */ void n0(c.a aVar, androidx.media3.common.q0 q0Var) {
        e4.b.a0(this, aVar, q0Var);
    }

    @Override // e4.c
    public /* synthetic */ void o(c.a aVar, boolean z11) {
        e4.b.B(this, aVar, z11);
    }

    @Override // e4.w3.a
    public void o0(c.a aVar, String str) {
    }

    @Override // e4.c
    public /* synthetic */ void p(c.a aVar) {
        e4.b.U(this, aVar);
    }

    @Override // e4.w3.a
    public void p0(c.a aVar, String str) {
        androidx.media3.exoplayer.source.l.b bVar = aVar.f63815d;
        if (bVar == null || !bVar.b()) {
            z0();
            this.f63983i = str;
            this.f63984j = p2.a().setPlayerName("AndroidXMedia3").setPlayerVersion("1.3.1");
            R0(aVar.f63813b, aVar.f63815d);
        }
    }

    @Override // e4.c
    public /* synthetic */ void q(c.a aVar, Exception exc) {
        e4.b.a(this, aVar, exc);
    }

    @Override // e4.w3.a
    public void q0(c.a aVar, String str, boolean z11) {
        androidx.media3.exoplayer.source.l.b bVar = aVar.f63815d;
        if ((bVar == null || !bVar.b()) && str.equals(this.f63983i)) {
            z0();
        }
        this.f63981g.remove(str);
        this.f63982h.remove(str);
    }

    @Override // e4.c
    public /* synthetic */ void r(c.a aVar, PlaybackException playbackException) {
        e4.b.O(this, aVar, playbackException);
    }

    @Override // e4.c
    public /* synthetic */ void r0(c.a aVar, int i11, int i12, int i13, float f11) {
        e4.b.k0(this, aVar, i11, i12, i13, f11);
    }

    @Override // e4.c
    public /* synthetic */ void s(c.a aVar) {
        e4.b.t(this, aVar);
    }

    @Override // e4.c
    public void s0(c.a aVar, p4.o oVar) {
        if (aVar.f63815d == null) {
            return;
        }
        b bVar = new b((androidx.media3.common.y) z3.a.e(oVar.f73588c), oVar.f73589d, this.f63976b.b(aVar.f63813b, (androidx.media3.exoplayer.source.l.b) z3.a.e(aVar.f63815d)));
        int i11 = oVar.f73587b;
        if (i11 != 0) {
            if (i11 == 1) {
                this.f63990p = bVar;
                return;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                this.f63991q = bVar;
                return;
            }
        }
        this.f63989o = bVar;
    }

    @Override // e4.c
    public void t(c.a aVar, PlaybackException playbackException) {
        this.f63988n = playbackException;
    }

    @Override // e4.c
    public /* synthetic */ void t0(c.a aVar) {
        e4.b.P(this, aVar);
    }

    @Override // e4.c
    public /* synthetic */ void u(c.a aVar, int i11, boolean z11) {
        e4.b.r(this, aVar, i11, z11);
    }

    @Override // e4.c
    public /* synthetic */ void u0(c.a aVar, androidx.media3.common.g0 g0Var) {
        e4.b.L(this, aVar, g0Var);
    }

    @Override // e4.c
    public /* synthetic */ void v(c.a aVar) {
        e4.b.v(this, aVar);
    }

    @Override // e4.c
    public /* synthetic */ void v0(c.a aVar, androidx.media3.common.o oVar) {
        e4.b.q(this, aVar, oVar);
    }

    @Override // e4.c
    public /* synthetic */ void w(c.a aVar, Metadata metadata) {
        e4.b.J(this, aVar, metadata);
    }

    @Override // e4.c
    public /* synthetic */ void w0(c.a aVar, long j11, int i11) {
        e4.b.h0(this, aVar, j11, i11);
    }

    @Override // e4.c
    public /* synthetic */ void x(c.a aVar, String str, long j11, long j12) {
        e4.b.e0(this, aVar, str, j11, j12);
    }

    public final boolean x0(@Nullable b bVar) {
        return bVar != null && bVar.f64005c.equals(this.f63976b.a());
    }

    @Override // e4.c
    public /* synthetic */ void y(c.a aVar, y3.b bVar) {
        e4.b.p(this, aVar, bVar);
    }

    @Override // e4.c
    public /* synthetic */ void z(c.a aVar, Exception exc) {
        e4.b.x(this, aVar, exc);
    }

    public final void z0() {
        PlaybackMetrics.Builder builder = this.f63984j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.f64000z);
            this.f63984j.setVideoFramesDropped(this.f63998x);
            this.f63984j.setVideoFramesPlayed(this.f63999y);
            Long l11 = this.f63981g.get(this.f63983i);
            this.f63984j.setNetworkTransferDurationMillis(l11 == null ? 0L : l11.longValue());
            Long l12 = this.f63982h.get(this.f63983i);
            this.f63984j.setNetworkBytesRead(l12 == null ? 0L : l12.longValue());
            this.f63984j.setStreamSource((l12 == null || l12.longValue() <= 0) ? 0 : 1);
            this.f63977c.reportPlaybackMetrics(this.f63984j.build());
        }
        this.f63984j = null;
        this.f63983i = null;
        this.f64000z = 0;
        this.f63998x = 0;
        this.f63999y = 0;
        this.f63992r = null;
        this.f63993s = null;
        this.f63994t = null;
        this.A = false;
    }
}
