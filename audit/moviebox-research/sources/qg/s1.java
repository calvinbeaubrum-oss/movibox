package qg;

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
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o3;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.z1;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.warren.error.VungleException;
import e4.a3;
import e4.e2;
import e4.l3;
import e4.o2;
import e4.p2;
import e4.p3;
import e4.q3;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(VungleException.WEB_CRASH)
public final class s1 implements c, t1.a {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f74713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1 f74714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PlaybackSession f74715c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public String f74721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public PlaybackMetrics.Builder f74722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f74723k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public PlaybackException f74726n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public b f74727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public b f74728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public b f74729q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.m1 f74730r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.m1 f74731s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.m1 f74732t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f74733u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f74734v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f74735w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f74736x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f74737y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f74738z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j3.d f74717e = new j3.d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j3.b f74718f = new j3.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, Long> f74720h = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Long> f74719g = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f74716d = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f74724l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f74725m = 0;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f74740b;

        public a(int i11, int i12) {
            this.f74739a = i11;
            this.f74740b = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.m1 f74741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f74742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f74743c;

        public b(com.google.android.exoplayer2.m1 m1Var, int i11, String str) {
            this.f74741a = m1Var;
            this.f74742b = i11;
            this.f74743c = str;
        }
    }

    public s1(Context context, PlaybackSession playbackSession) {
        this.f74713a = context.getApplicationContext();
        this.f74715c = playbackSession;
        r1 r1Var = new r1();
        this.f74714b = r1Var;
        r1Var.b(this);
    }

    @Nullable
    public static s1 B0(Context context) {
        MediaMetricsManager mediaMetricsManagerA = q3.a(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerA == null) {
            return null;
        }
        return new s1(context, mediaMetricsManagerA.createPlaybackSession());
    }

    @SuppressLint({"SwitchIntDef"})
    public static int D0(int i11) {
        switch (com.google.android.exoplayer2.util.o0.V(i11)) {
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
    public static DrmInitData E0(ImmutableList<o3.a> immutableList) {
        DrmInitData drmInitData;
        com.google.common.collect.g1<o3.a> it = immutableList.iterator();
        while (it.hasNext()) {
            o3.a next = it.next();
            for (int i11 = 0; i11 < next.f33629a; i11++) {
                if (next.g(i11) && (drmInitData = next.c(i11).f33448p) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    public static int F0(DrmInitData drmInitData) {
        for (int i11 = 0; i11 < drmInitData.schemeDataCount; i11++) {
            UUID uuid = drmInitData.get(i11).uuid;
            if (uuid.equals(com.google.android.exoplayer2.h.f33256d)) {
                return 3;
            }
            if (uuid.equals(com.google.android.exoplayer2.h.f33257e)) {
                return 2;
            }
            if (uuid.equals(com.google.android.exoplayer2.h.f33255c)) {
                return 6;
            }
        }
        return 1;
    }

    public static a G0(PlaybackException playbackException, Context context, boolean z11) {
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
        Throwable th2 = (Throwable) com.google.android.exoplayer2.util.a.e(playbackException.getCause());
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
                return new a(13, com.google.android.exoplayer2.util.o0.W(((MediaCodecRenderer.DecoderInitializationException) th2).diagnosticInfo));
            }
            if (th2 instanceof MediaCodecDecoderException) {
                return new a(14, com.google.android.exoplayer2.util.o0.W(((MediaCodecDecoderException) th2).diagnosticInfo));
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
            if (com.google.android.exoplayer2.util.o0.f35608a < 16 || !(th2 instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th2).getErrorCode();
            return new a(D0(errorCode), errorCode);
        }
        if (th2 instanceof HttpDataSource$InvalidResponseCodeException) {
            return new a(5, ((HttpDataSource$InvalidResponseCodeException) th2).responseCode);
        }
        if ((th2 instanceof HttpDataSource$InvalidContentTypeException) || (th2 instanceof ParserException)) {
            return new a(z11 ? 10 : 11, 0);
        }
        if ((th2 instanceof HttpDataSource$HttpDataSourceException) || (th2 instanceof UdpDataSource.UdpDataSourceException)) {
            if (com.google.android.exoplayer2.util.z.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th2.getCause();
            if (cause instanceof UnknownHostException) {
                return new a(6, 0);
            }
            if (cause instanceof SocketTimeoutException) {
                return new a(7, 0);
            }
            return ((th2 instanceof HttpDataSource$HttpDataSourceException) && ((HttpDataSource$HttpDataSourceException) th2).type == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (playbackException.errorCode == 1002) {
            return new a(21, 0);
        }
        if (!(th2 instanceof DrmSession.DrmSessionException)) {
            if (!(th2 instanceof FileDataSource.FileDataSourceException) || !(th2.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            Throwable cause2 = ((Throwable) com.google.android.exoplayer2.util.a.e(th2.getCause())).getCause();
            return (com.google.android.exoplayer2.util.o0.f35608a >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        Throwable th3 = (Throwable) com.google.android.exoplayer2.util.a.e(th2.getCause());
        int i12 = com.google.android.exoplayer2.util.o0.f35608a;
        if (i12 >= 21 && (th3 instanceof MediaDrm.MediaDrmStateException)) {
            int iW = com.google.android.exoplayer2.util.o0.W(((MediaDrm.MediaDrmStateException) th3).getDiagnosticInfo());
            return new a(D0(iW), iW);
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

    public static Pair<String, String> H0(String str) {
        String[] strArrT0 = com.google.android.exoplayer2.util.o0.T0(str, "-");
        return Pair.create(strArrT0[0], strArrT0.length >= 2 ? strArrT0[1] : null);
    }

    public static int J0(Context context) {
        switch (com.google.android.exoplayer2.util.z.d(context).f()) {
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

    public static int K0(com.google.android.exoplayer2.u1 u1Var) {
        com.google.android.exoplayer2.u1.h hVar = u1Var.f34776b;
        if (hVar == null) {
            return 0;
        }
        int iQ0 = com.google.android.exoplayer2.util.o0.q0(hVar.f34839a, hVar.f34840b);
        if (iQ0 == 0) {
            return 3;
        }
        if (iQ0 != 1) {
            return iQ0 != 2 ? 1 : 4;
        }
        return 5;
    }

    public static int L0(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 1 : 4;
        }
        return 3;
    }

    @Override // qg.c
    public /* synthetic */ void A(c.a aVar, int i11, boolean z11) {
        qg.b.t(this, aVar, i11, z11);
    }

    public final boolean A0(@Nullable b bVar) {
        return bVar != null && bVar.f74743c.equals(this.f74714b.a());
    }

    @Override // qg.c
    public /* synthetic */ void B(c.a aVar, nh.n nVar, nh.o oVar) {
        qg.b.G(this, aVar, nVar, oVar);
    }

    @Override // qg.c
    public /* synthetic */ void C(c.a aVar, fi.z zVar) {
        qg.b.b0(this, aVar, zVar);
    }

    public final void C0() {
        PlaybackMetrics.Builder builder = this.f74722j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.f74738z);
            this.f74722j.setVideoFramesDropped(this.f74736x);
            this.f74722j.setVideoFramesPlayed(this.f74737y);
            Long l11 = this.f74719g.get(this.f74721i);
            this.f74722j.setNetworkTransferDurationMillis(l11 == null ? 0L : l11.longValue());
            Long l12 = this.f74720h.get(this.f74721i);
            this.f74722j.setNetworkBytesRead(l12 == null ? 0L : l12.longValue());
            this.f74722j.setStreamSource((l12 == null || l12.longValue() <= 0) ? 0 : 1);
            this.f74715c.reportPlaybackMetrics(this.f74722j.build());
        }
        this.f74722j = null;
        this.f74721i = null;
        this.f74738z = 0;
        this.f74736x = 0;
        this.f74737y = 0;
        this.f74730r = null;
        this.f74731s = null;
        this.f74732t = null;
        this.A = false;
    }

    @Override // qg.c
    public /* synthetic */ void D(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        qg.b.f(this, aVar, eVar);
    }

    @Override // qg.c
    public /* synthetic */ void E(c.a aVar) {
        qg.b.w(this, aVar);
    }

    @Override // qg.c
    public /* synthetic */ void F(c.a aVar, com.google.android.exoplayer2.u1 u1Var, int i11) {
        qg.b.I(this, aVar, u1Var, i11);
    }

    @Override // qg.c
    public /* synthetic */ void G(c.a aVar, o3 o3Var) {
        qg.b.c0(this, aVar, o3Var);
    }

    @Override // qg.c
    public /* synthetic */ void H(c.a aVar, String str, long j11, long j12) {
        qg.b.c(this, aVar, str, j11, j12);
    }

    @Override // qg.c
    public /* synthetic */ void I(c.a aVar, int i11, long j11, long j12) {
        qg.b.k(this, aVar, i11, j11, j12);
    }

    public LogSessionId I0() {
        return this.f74715c.getSessionId();
    }

    @Override // qg.c
    public /* synthetic */ void J(c.a aVar, int i11) {
        qg.b.S(this, aVar, i11);
    }

    @Override // qg.c
    public /* synthetic */ void K(c.a aVar, int i11, com.google.android.exoplayer2.m1 m1Var) {
        qg.b.r(this, aVar, i11, m1Var);
    }

    @Override // qg.c
    public /* synthetic */ void L(c.a aVar, boolean z11, int i11) {
        qg.b.R(this, aVar, z11, i11);
    }

    @Override // qg.t1.a
    public void M(c.a aVar, String str, boolean z11) {
        com.google.android.exoplayer2.source.i.b bVar = aVar.f74573d;
        if ((bVar == null || !bVar.b()) && str.equals(this.f74721i)) {
            C0();
        }
        this.f74719g.remove(str);
        this.f74720h.remove(str);
    }

    public final void M0(c.b bVar) {
        for (int i11 = 0; i11 < bVar.d(); i11++) {
            int iB = bVar.b(i11);
            c.a aVarC = bVar.c(iB);
            if (iB == 0) {
                this.f74714b.d(aVarC);
            } else if (iB == 11) {
                this.f74714b.g(aVarC, this.f74723k);
            } else {
                this.f74714b.e(aVarC);
            }
        }
    }

    @Override // qg.c
    public /* synthetic */ void N(c.a aVar, com.google.android.exoplayer2.m1 m1Var) {
        qg.b.k0(this, aVar, m1Var);
    }

    public final void N0(long j11) {
        int iJ0 = J0(this.f74713a);
        if (iJ0 != this.f74725m) {
            this.f74725m = iJ0;
            this.f74715c.reportNetworkEvent(l3.a().setNetworkType(iJ0).setTimeSinceCreatedMillis(j11 - this.f74716d).build());
        }
    }

    @Override // qg.c
    public /* synthetic */ void O(c.a aVar, Exception exc) {
        qg.b.e0(this, aVar, exc);
    }

    public final void O0(long j11) {
        PlaybackException playbackException = this.f74726n;
        if (playbackException == null) {
            return;
        }
        a aVarG0 = G0(playbackException, this.f74713a, this.f74734v == 4);
        this.f74715c.reportPlaybackErrorEvent(e4.t1.a().setTimeSinceCreatedMillis(j11 - this.f74716d).setErrorCode(aVarG0.f74739a).setSubErrorCode(aVarG0.f74740b).setException(playbackException).build());
        this.A = true;
        this.f74726n = null;
    }

    @Override // qg.c
    public /* synthetic */ void P(c.a aVar, int i11, long j11) {
        qg.b.B(this, aVar, i11, j11);
    }

    public final void P0(n2 n2Var, c.b bVar, long j11) {
        if (n2Var.getPlaybackState() != 2) {
            this.f74733u = false;
        }
        if (n2Var.c() == null) {
            this.f74735w = false;
        } else if (bVar.a(10)) {
            this.f74735w = true;
        }
        int iX0 = X0(n2Var);
        if (this.f74724l != iX0) {
            this.f74724l = iX0;
            this.A = true;
            this.f74715c.reportPlaybackStateEvent(a3.a().setState(this.f74724l).setTimeSinceCreatedMillis(j11 - this.f74716d).build());
        }
    }

    @Override // qg.c
    public /* synthetic */ void Q(c.a aVar, String str) {
        qg.b.d(this, aVar, str);
    }

    public final void Q0(n2 n2Var, c.b bVar, long j11) {
        if (bVar.a(2)) {
            o3 currentTracks = n2Var.getCurrentTracks();
            boolean zD = currentTracks.d(2);
            boolean zD2 = currentTracks.d(1);
            boolean zD3 = currentTracks.d(3);
            if (zD || zD2 || zD3) {
                if (!zD) {
                    V0(j11, null, 0);
                }
                if (!zD2) {
                    R0(j11, null, 0);
                }
                if (!zD3) {
                    T0(j11, null, 0);
                }
            }
        }
        if (A0(this.f74727o)) {
            b bVar2 = this.f74727o;
            com.google.android.exoplayer2.m1 m1Var = bVar2.f74741a;
            if (m1Var.f33451s != -1) {
                V0(j11, m1Var, bVar2.f74742b);
                this.f74727o = null;
            }
        }
        if (A0(this.f74728p)) {
            b bVar3 = this.f74728p;
            R0(j11, bVar3.f74741a, bVar3.f74742b);
            this.f74728p = null;
        }
        if (A0(this.f74729q)) {
            b bVar4 = this.f74729q;
            T0(j11, bVar4.f74741a, bVar4.f74742b);
            this.f74729q = null;
        }
    }

    @Override // qg.c
    public /* synthetic */ void R(c.a aVar, String str, long j11, long j12) {
        qg.b.g0(this, aVar, str, j11, j12);
    }

    public final void R0(long j11, @Nullable com.google.android.exoplayer2.m1 m1Var, int i11) {
        if (com.google.android.exoplayer2.util.o0.c(this.f74731s, m1Var)) {
            return;
        }
        int i12 = (this.f74731s == null && i11 == 0) ? 1 : i11;
        this.f74731s = m1Var;
        W0(0, j11, m1Var, i12);
    }

    @Override // qg.c
    public void S(c.a aVar, n2.e eVar, n2.e eVar2, int i11) {
        if (i11 == 1) {
            this.f74733u = true;
        }
        this.f74723k = i11;
    }

    public final void S0(n2 n2Var, c.b bVar) {
        DrmInitData drmInitDataE0;
        if (bVar.a(0)) {
            c.a aVarC = bVar.c(0);
            if (this.f74722j != null) {
                U0(aVarC.f74571b, aVarC.f74573d);
            }
        }
        if (bVar.a(2) && this.f74722j != null && (drmInitDataE0 = E0(n2Var.getCurrentTracks().b())) != null) {
            o2.a(com.google.android.exoplayer2.util.o0.j(this.f74722j)).setDrmType(F0(drmInitDataE0));
        }
        if (bVar.a(1011)) {
            this.f74738z++;
        }
    }

    @Override // qg.c
    public /* synthetic */ void T(c.a aVar, int i11) {
        qg.b.a0(this, aVar, i11);
    }

    public final void T0(long j11, @Nullable com.google.android.exoplayer2.m1 m1Var, int i11) {
        if (com.google.android.exoplayer2.util.o0.c(this.f74732t, m1Var)) {
            return;
        }
        int i12 = (this.f74732t == null && i11 == 0) ? 1 : i11;
        this.f74732t = m1Var;
        W0(2, j11, m1Var, i12);
    }

    @Override // qg.c
    public /* synthetic */ void U(c.a aVar, nh.o oVar) {
        qg.b.d0(this, aVar, oVar);
    }

    public final void U0(j3 j3Var, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
        int iF;
        PlaybackMetrics.Builder builder = this.f74722j;
        if (bVar == null || (iF = j3Var.f(bVar.f71960a)) == -1) {
            return;
        }
        j3Var.j(iF, this.f74718f);
        j3Var.r(this.f74718f.f33364c, this.f74717e);
        builder.setStreamType(K0(this.f74717e.f33379c));
        j3.d dVar = this.f74717e;
        if (dVar.f33390o != C.TIME_UNSET && !dVar.f33388m && !dVar.f33385j && !dVar.i()) {
            builder.setMediaDurationMillis(this.f74717e.g());
        }
        builder.setPlaybackType(this.f74717e.i() ? 2 : 1);
        this.A = true;
    }

    @Override // qg.c
    public /* synthetic */ void V(c.a aVar, int i11) {
        qg.b.U(this, aVar, i11);
    }

    public final void V0(long j11, @Nullable com.google.android.exoplayer2.m1 m1Var, int i11) {
        if (com.google.android.exoplayer2.util.o0.c(this.f74730r, m1Var)) {
            return;
        }
        int i12 = (this.f74730r == null && i11 == 0) ? 1 : i11;
        this.f74730r = m1Var;
        W0(1, j11, m1Var, i12);
    }

    @Override // qg.t1.a
    public void W(c.a aVar, String str) {
    }

    public final void W0(int i11, long j11, @Nullable com.google.android.exoplayer2.m1 m1Var, int i12) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = e2.a(i11).setTimeSinceCreatedMillis(j11 - this.f74716d);
        if (m1Var != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(L0(i12));
            String str = m1Var.f33444l;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = m1Var.f33445m;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = m1Var.f33442j;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i13 = m1Var.f33441i;
            if (i13 != -1) {
                timeSinceCreatedMillis.setBitrate(i13);
            }
            int i14 = m1Var.f33450r;
            if (i14 != -1) {
                timeSinceCreatedMillis.setWidth(i14);
            }
            int i15 = m1Var.f33451s;
            if (i15 != -1) {
                timeSinceCreatedMillis.setHeight(i15);
            }
            int i16 = m1Var.f33458z;
            if (i16 != -1) {
                timeSinceCreatedMillis.setChannelCount(i16);
            }
            int i17 = m1Var.A;
            if (i17 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i17);
            }
            String str4 = m1Var.f33436c;
            if (str4 != null) {
                Pair<String, String> pairH0 = H0(str4);
                timeSinceCreatedMillis.setLanguage((String) pairH0.first);
                Object obj = pairH0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f11 = m1Var.f33452t;
            if (f11 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f11);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        this.f74715c.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @Override // qg.c
    public /* synthetic */ void X(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        qg.b.i0(this, aVar, eVar);
    }

    public final int X0(n2 n2Var) {
        int playbackState = n2Var.getPlaybackState();
        if (this.f74733u) {
            return 5;
        }
        if (this.f74735w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i11 = this.f74724l;
            if (i11 == 0 || i11 == 2) {
                return 2;
            }
            if (n2Var.getPlayWhenReady()) {
                return n2Var.k() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (n2Var.getPlayWhenReady()) {
                return n2Var.k() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.f74724l == 0) {
            return this.f74724l;
        }
        return 12;
    }

    @Override // qg.c
    public /* synthetic */ void Y(c.a aVar) {
        qg.b.Q(this, aVar);
    }

    @Override // qg.c
    public /* synthetic */ void Z(c.a aVar, int i11) {
        qg.b.N(this, aVar, i11);
    }

    @Override // qg.c
    public /* synthetic */ void a(c.a aVar, Exception exc) {
        qg.b.j(this, aVar, exc);
    }

    @Override // qg.c
    public /* synthetic */ void a0(c.a aVar, com.google.android.exoplayer2.m1 m1Var) {
        qg.b.g(this, aVar, m1Var);
    }

    @Override // qg.c
    public /* synthetic */ void b(c.a aVar, boolean z11) {
        qg.b.Y(this, aVar, z11);
    }

    @Override // qg.c
    public /* synthetic */ void b0(c.a aVar, boolean z11) {
        qg.b.X(this, aVar, z11);
    }

    @Override // qg.c
    public void c(c.a aVar, com.google.android.exoplayer2.video.y yVar) {
        b bVar = this.f74727o;
        if (bVar != null) {
            com.google.android.exoplayer2.m1 m1Var = bVar.f74741a;
            if (m1Var.f33451s == -1) {
                this.f74727o = new b(m1Var.b().j0(yVar.f35863a).Q(yVar.f35864b).E(), bVar.f74742b, bVar.f74743c);
            }
        }
    }

    @Override // qg.c
    public /* synthetic */ void c0(c.a aVar) {
        qg.b.u(this, aVar);
    }

    @Override // qg.c
    public /* synthetic */ void d(c.a aVar, List list) {
        qg.b.m(this, aVar, list);
    }

    @Override // qg.c
    public void d0(c.a aVar, nh.n nVar, nh.o oVar, IOException iOException, boolean z11) {
        this.f74734v = oVar.f71953a;
    }

    @Override // qg.c
    public /* synthetic */ void e(c.a aVar, boolean z11, int i11) {
        qg.b.L(this, aVar, z11, i11);
    }

    @Override // qg.c
    public void e0(c.a aVar, int i11, long j11, long j12) {
        com.google.android.exoplayer2.source.i.b bVar = aVar.f74573d;
        if (bVar != null) {
            String strF = this.f74714b.f(aVar.f74571b, (com.google.android.exoplayer2.source.i.b) com.google.android.exoplayer2.util.a.e(bVar));
            Long l11 = this.f74720h.get(strF);
            Long l12 = this.f74719g.get(strF);
            this.f74720h.put(strF, Long.valueOf((l11 == null ? 0L : l11.longValue()) + j11));
            this.f74719g.put(strF, Long.valueOf((l12 != null ? l12.longValue() : 0L) + ((long) i11)));
        }
    }

    @Override // qg.c
    public /* synthetic */ void f(c.a aVar, int i11, com.google.android.exoplayer2.decoder.e eVar) {
        qg.b.p(this, aVar, i11, eVar);
    }

    @Override // qg.c
    public /* synthetic */ void f0(c.a aVar, Object obj, long j11) {
        qg.b.T(this, aVar, obj, j11);
    }

    @Override // qg.c
    public /* synthetic */ void g(c.a aVar, nh.n nVar, nh.o oVar) {
        qg.b.E(this, aVar, nVar, oVar);
    }

    @Override // qg.c
    public /* synthetic */ void g0(c.a aVar, int i11, int i12, int i13, float f11) {
        qg.b.m0(this, aVar, i11, i12, i13, f11);
    }

    @Override // qg.c
    public /* synthetic */ void h(c.a aVar, boolean z11) {
        qg.b.D(this, aVar, z11);
    }

    @Override // qg.c
    public /* synthetic */ void h0(c.a aVar, int i11) {
        qg.b.y(this, aVar, i11);
    }

    @Override // qg.c
    public /* synthetic */ void i(c.a aVar, nh.n nVar, nh.o oVar) {
        qg.b.F(this, aVar, nVar, oVar);
    }

    @Override // qg.c
    public /* synthetic */ void i0(c.a aVar, int i11, com.google.android.exoplayer2.decoder.e eVar) {
        qg.b.o(this, aVar, i11, eVar);
    }

    @Override // qg.t1.a
    public void j(c.a aVar, String str, String str2) {
    }

    @Override // qg.c
    public /* synthetic */ void j0(c.a aVar, vh.f fVar) {
        qg.b.n(this, aVar, fVar);
    }

    @Override // qg.c
    public /* synthetic */ void k(c.a aVar, long j11, int i11) {
        qg.b.j0(this, aVar, j11, i11);
    }

    @Override // qg.c
    public void k0(c.a aVar, PlaybackException playbackException) {
        this.f74726n = playbackException;
    }

    @Override // qg.c
    public /* synthetic */ void l(c.a aVar) {
        qg.b.V(this, aVar);
    }

    @Override // qg.c
    public /* synthetic */ void l0(c.a aVar, com.google.android.exoplayer2.m1 m1Var, com.google.android.exoplayer2.decoder.g gVar) {
        qg.b.h(this, aVar, m1Var, gVar);
    }

    @Override // qg.t1.a
    public void m(c.a aVar, String str) {
        com.google.android.exoplayer2.source.i.b bVar = aVar.f74573d;
        if (bVar == null || !bVar.b()) {
            C0();
            this.f74721i = str;
            this.f74722j = p2.a().setPlayerName("ExoPlayerLib").setPlayerVersion("2.18.1");
            U0(aVar.f74571b, aVar.f74573d);
        }
    }

    @Override // qg.c
    public /* synthetic */ void m0(c.a aVar, String str) {
        qg.b.h0(this, aVar, str);
    }

    @Override // qg.c
    public /* synthetic */ void n(c.a aVar, com.google.android.exoplayer2.m1 m1Var, com.google.android.exoplayer2.decoder.g gVar) {
        qg.b.l0(this, aVar, m1Var, gVar);
    }

    @Override // qg.c
    public /* synthetic */ void n0(c.a aVar, boolean z11) {
        qg.b.H(this, aVar, z11);
    }

    @Override // qg.c
    public /* synthetic */ void o(c.a aVar, Metadata metadata) {
        qg.b.K(this, aVar, metadata);
    }

    @Override // qg.c
    public /* synthetic */ void o0(c.a aVar, Exception exc) {
        qg.b.z(this, aVar, exc);
    }

    @Override // qg.c
    public /* synthetic */ void p(c.a aVar, int i11, int i12) {
        qg.b.Z(this, aVar, i11, i12);
    }

    @Override // qg.c
    public /* synthetic */ void p0(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        qg.b.e(this, aVar, eVar);
    }

    @Override // qg.c
    public /* synthetic */ void q(c.a aVar, long j11) {
        qg.b.i(this, aVar, j11);
    }

    @Override // qg.c
    public /* synthetic */ void q0(c.a aVar, int i11) {
        qg.b.O(this, aVar, i11);
    }

    @Override // qg.c
    public void r(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        this.f74736x += eVar.f33068g;
        this.f74737y += eVar.f33066e;
    }

    @Override // qg.c
    public void r0(c.a aVar, nh.o oVar) {
        if (aVar.f74573d == null) {
            return;
        }
        b bVar = new b((com.google.android.exoplayer2.m1) com.google.android.exoplayer2.util.a.e(oVar.f71955c), oVar.f71956d, this.f74714b.f(aVar.f74571b, (com.google.android.exoplayer2.source.i.b) com.google.android.exoplayer2.util.a.e(aVar.f74573d)));
        int i11 = oVar.f71954b;
        if (i11 != 0) {
            if (i11 == 1) {
                this.f74728p = bVar;
                return;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                this.f74729q = bVar;
                return;
            }
        }
        this.f74727o = bVar;
    }

    @Override // qg.c
    public /* synthetic */ void s(c.a aVar, float f11) {
        qg.b.n0(this, aVar, f11);
    }

    @Override // qg.c
    public /* synthetic */ void s0(c.a aVar, n2.b bVar) {
        qg.b.l(this, aVar, bVar);
    }

    @Override // qg.c
    public /* synthetic */ void t(c.a aVar, String str, long j11) {
        qg.b.b(this, aVar, str, j11);
    }

    @Override // qg.c
    public /* synthetic */ void t0(c.a aVar, String str, long j11) {
        qg.b.f0(this, aVar, str, j11);
    }

    @Override // qg.c
    public void u(n2 n2Var, c.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        M0(bVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        S0(n2Var, bVar);
        O0(jElapsedRealtime);
        Q0(n2Var, bVar, jElapsedRealtime);
        N0(jElapsedRealtime);
        P0(n2Var, bVar, jElapsedRealtime);
        if (bVar.a(1028)) {
            this.f74714b.c(bVar.c(1028));
        }
    }

    @Override // qg.c
    public /* synthetic */ void u0(c.a aVar) {
        qg.b.W(this, aVar);
    }

    @Override // qg.c
    public /* synthetic */ void v(c.a aVar) {
        qg.b.A(this, aVar);
    }

    @Override // qg.c
    public /* synthetic */ void v0(c.a aVar, boolean z11) {
        qg.b.C(this, aVar, z11);
    }

    @Override // qg.c
    public /* synthetic */ void w(c.a aVar, int i11, String str, long j11) {
        qg.b.q(this, aVar, i11, str, j11);
    }

    @Override // qg.c
    public /* synthetic */ void w0(c.a aVar, com.google.android.exoplayer2.n nVar) {
        qg.b.s(this, aVar, nVar);
    }

    @Override // qg.c
    public /* synthetic */ void x(c.a aVar, z1 z1Var) {
        qg.b.J(this, aVar, z1Var);
    }

    @Override // qg.c
    public /* synthetic */ void x0(c.a aVar, Exception exc) {
        qg.b.a(this, aVar, exc);
    }

    @Override // qg.c
    public /* synthetic */ void y(c.a aVar, m2 m2Var) {
        qg.b.M(this, aVar, m2Var);
    }

    @Override // qg.c
    public /* synthetic */ void y0(c.a aVar) {
        qg.b.v(this, aVar);
    }

    @Override // qg.c
    public /* synthetic */ void z(c.a aVar, PlaybackException playbackException) {
        qg.b.P(this, aVar, playbackException);
    }

    @Override // qg.c
    public /* synthetic */ void z0(c.a aVar) {
        qg.b.x(this, aVar);
    }
}
