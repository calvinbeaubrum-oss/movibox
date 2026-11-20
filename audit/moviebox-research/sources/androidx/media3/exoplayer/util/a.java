package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.b0;
import androidx.media3.common.d0;
import androidx.media3.common.g0;
import androidx.media3.common.h0;
import androidx.media3.common.m0;
import androidx.media3.common.p0;
import androidx.media3.common.q0;
import androidx.media3.common.t0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.audio.AudioSink;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.c;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import p4.n;
import p4.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final NumberFormat f11518e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0.c f11520b = new m0.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0.b f11521c = new m0.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11522d = SystemClock.elapsedRealtime();

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f11518e = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public a(String str) {
        this.f11519a = str;
    }

    public static String A0(int i11) {
        if (i11 == 0) {
            return "OFF";
        }
        if (i11 != 1) {
            return i11 != 2 ? "?" : "ALL";
        }
        return "ONE";
    }

    public static String B0(int i11) {
        if (i11 == 1) {
            return "IDLE";
        }
        if (i11 == 2) {
            return "BUFFERING";
        }
        if (i11 != 3) {
            return i11 != 4 ? "?" : "ENDED";
        }
        return "READY";
    }

    public static String C0(long j11) {
        return j11 == C.TIME_UNSET ? "?" : f11518e.format(j11 / 1000.0f);
    }

    public static String D0(int i11) {
        if (i11 != 0) {
            return i11 != 1 ? "?" : "SOURCE_UPDATE";
        }
        return "PLAYLIST_CHANGED";
    }

    public static String E0(boolean z11) {
        return z11 ? "[X]" : "[ ]";
    }

    public static String a(AudioSink.a aVar) {
        return aVar.f9833a + "," + aVar.f9835c + "," + aVar.f9834b + "," + aVar.f9836d + "," + aVar.f9837e + "," + aVar.f9838f;
    }

    public static String o0(int i11) {
        switch (i11) {
            case 0:
                return "AUTO_TRANSITION";
            case 1:
                return "SEEK";
            case 2:
                return "SEEK_ADJUSTMENT";
            case 3:
                return "SKIP";
            case 4:
                return "REMOVE";
            case 5:
                return "INTERNAL";
            case 6:
                return "SILENCE_SKIP";
            default:
                return "?";
        }
    }

    public static String x0(int i11) {
        if (i11 == 0) {
            return "REPEAT";
        }
        if (i11 == 1) {
            return "AUTO";
        }
        if (i11 != 2) {
            return i11 != 3 ? "?" : "PLAYLIST_CHANGED";
        }
        return "SEEK";
    }

    public static String y0(int i11) {
        if (i11 == 1) {
            return "USER_REQUEST";
        }
        if (i11 == 2) {
            return "AUDIO_FOCUS_LOSS";
        }
        if (i11 == 3) {
            return "AUDIO_BECOMING_NOISY";
        }
        if (i11 != 4) {
            return i11 != 5 ? "?" : "END_OF_MEDIA_ITEM";
        }
        return "REMOTE";
    }

    public static String z0(int i11) {
        if (i11 != 0) {
            return i11 != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS";
        }
        return "NONE";
    }

    @Override // e4.c
    public void A(c.a aVar, int i11) {
        G0(aVar, "drmSessionAcquired", "state=" + i11);
    }

    @Override // e4.c
    public void B(c.a aVar, n nVar, o oVar) {
    }

    @Override // e4.c
    public void C(c.a aVar, androidx.media3.exoplayer.n nVar) {
        F0(aVar, "audioEnabled");
    }

    @Override // e4.c
    public void D(c.a aVar, androidx.media3.exoplayer.n nVar) {
        F0(aVar, "audioDisabled");
    }

    @Override // e4.c
    public /* synthetic */ void E(c.a aVar, boolean z11) {
        e4.b.G(this, aVar, z11);
    }

    @Override // e4.c
    public void F(c.a aVar, n nVar, o oVar) {
    }

    public final void F0(c.a aVar, String str) {
        H0(p0(aVar, str, null, null));
    }

    @Override // e4.c
    public /* synthetic */ void G(c.a aVar, long j11) {
        e4.b.i(this, aVar, j11);
    }

    public final void G0(c.a aVar, String str, String str2) {
        H0(p0(aVar, str, str2, null));
    }

    @Override // e4.c
    public void H(c.a aVar, int i11) {
        G0(aVar, "playbackSuppressionReason", z0(i11));
    }

    public void H0(String str) {
        z3.o.b(this.f11519a, str);
    }

    @Override // e4.c
    public void I(c.a aVar, androidx.media3.exoplayer.n nVar) {
        F0(aVar, "videoEnabled");
    }

    public final void I0(c.a aVar, String str, String str2, @Nullable Throwable th2) {
        K0(p0(aVar, str, str2, th2));
    }

    @Override // e4.c
    public void J(c.a aVar, int i11, int i12) {
        G0(aVar, "surfaceSize", i11 + ", " + i12);
    }

    public final void J0(c.a aVar, String str, @Nullable Throwable th2) {
        K0(p0(aVar, str, null, th2));
    }

    @Override // e4.c
    public void K(c.a aVar, h0.e eVar, h0.e eVar2, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reason=");
        sb2.append(o0(i11));
        sb2.append(", PositionInfo:old [");
        sb2.append("mediaItem=");
        sb2.append(eVar.f9243c);
        sb2.append(", period=");
        sb2.append(eVar.f9246f);
        sb2.append(", pos=");
        sb2.append(eVar.f9247g);
        if (eVar.f9249i != -1) {
            sb2.append(", contentPos=");
            sb2.append(eVar.f9248h);
            sb2.append(", adGroup=");
            sb2.append(eVar.f9249i);
            sb2.append(", ad=");
            sb2.append(eVar.f9250j);
        }
        sb2.append("], PositionInfo:new [");
        sb2.append("mediaItem=");
        sb2.append(eVar2.f9243c);
        sb2.append(", period=");
        sb2.append(eVar2.f9246f);
        sb2.append(", pos=");
        sb2.append(eVar2.f9247g);
        if (eVar2.f9249i != -1) {
            sb2.append(", contentPos=");
            sb2.append(eVar2.f9248h);
            sb2.append(", adGroup=");
            sb2.append(eVar2.f9249i);
            sb2.append(", ad=");
            sb2.append(eVar2.f9250j);
        }
        sb2.append("]");
        G0(aVar, "positionDiscontinuity", sb2.toString());
    }

    public void K0(String str) {
        z3.o.c(this.f11519a, str);
    }

    @Override // e4.c
    public void L(c.a aVar, String str) {
        G0(aVar, "videoDecoderReleased", str);
    }

    public final void L0(c.a aVar, String str, Exception exc) {
        I0(aVar, "internalError", str, exc);
    }

    @Override // e4.c
    public void M(c.a aVar, boolean z11) {
        G0(aVar, "shuffleModeEnabled", Boolean.toString(z11));
    }

    public final void M0(Metadata metadata, String str) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            H0(str + metadata.get(i11));
        }
    }

    @Override // e4.c
    public void N(c.a aVar, float f11) {
        G0(aVar, "volume", Float.toString(f11));
    }

    @Override // e4.c
    public void O(c.a aVar, AudioSink.a aVar2) {
        G0(aVar, "audioTrackInit", a(aVar2));
    }

    @Override // e4.c
    public void P(c.a aVar) {
        F0(aVar, "drmKeysLoaded");
    }

    @Override // e4.c
    public void Q(c.a aVar, String str) {
        G0(aVar, "audioDecoderReleased", str);
    }

    @Override // e4.c
    public /* synthetic */ void R(c.a aVar, Exception exc) {
        e4.b.c0(this, aVar, exc);
    }

    @Override // e4.c
    public void S(c.a aVar, int i11) {
        G0(aVar, "state", B0(i11));
    }

    @Override // e4.c
    public void T(c.a aVar, y yVar, @Nullable androidx.media3.exoplayer.o oVar) {
        G0(aVar, "videoInputFormat", y.m(yVar));
    }

    @Override // e4.c
    public /* synthetic */ void U(c.a aVar, String str, long j11) {
        e4.b.b(this, aVar, str, j11);
    }

    @Override // e4.c
    public void V(c.a aVar, @Nullable b0 b0Var, int i11) {
        H0("mediaItem [" + q0(aVar) + ", reason=" + x0(i11) + "]");
    }

    @Override // e4.c
    public void W(c.a aVar, y yVar, @Nullable androidx.media3.exoplayer.o oVar) {
        G0(aVar, "audioInputFormat", y.m(yVar));
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
    public void Z(c.a aVar, AudioSink.a aVar2) {
        G0(aVar, "audioTrackReleased", a(aVar2));
    }

    @Override // e4.c
    public void a0(c.a aVar) {
        F0(aVar, "drmSessionReleased");
    }

    @Override // e4.c
    public /* synthetic */ void b(c.a aVar, List list) {
        e4.b.o(this, aVar, list);
    }

    @Override // e4.c
    public /* synthetic */ void b0(c.a aVar, d0 d0Var) {
        e4.b.I(this, aVar, d0Var);
    }

    @Override // e4.c
    public void c(c.a aVar, boolean z11) {
        G0(aVar, "skipSilenceEnabled", Boolean.toString(z11));
    }

    @Override // e4.c
    public /* synthetic */ void c0(c.a aVar, p0 p0Var) {
        e4.b.Z(this, aVar, p0Var);
    }

    @Override // e4.c
    public /* synthetic */ void d(c.a aVar, Exception exc) {
        e4.b.j(this, aVar, exc);
    }

    @Override // e4.c
    public void d0(c.a aVar, int i11) {
        int i12 = aVar.f63813b.i();
        int iP = aVar.f63813b.p();
        H0("timeline [" + q0(aVar) + ", periodCount=" + i12 + ", windowCount=" + iP + ", reason=" + D0(i11));
        for (int i13 = 0; i13 < Math.min(i12, 3); i13++) {
            aVar.f63813b.f(i13, this.f11521c);
            H0("  period [" + C0(this.f11521c.j()) + "]");
        }
        if (i12 > 3) {
            H0("  ...");
        }
        for (int i14 = 0; i14 < Math.min(iP, 3); i14++) {
            aVar.f63813b.n(i14, this.f11520b);
            H0("  window [" + C0(this.f11520b.d()) + ", seekable=" + this.f11520b.f9316h + ", dynamic=" + this.f11520b.f9317i + "]");
        }
        if (iP > 3) {
            H0("  ...");
        }
        H0("]");
    }

    @Override // e4.c
    public void e(c.a aVar, boolean z11) {
        G0(aVar, "isPlaying", Boolean.toString(z11));
    }

    @Override // e4.c
    public /* synthetic */ void e0(h0 h0Var, c.b bVar) {
        e4.b.A(this, h0Var, bVar);
    }

    @Override // e4.c
    public /* synthetic */ void f(c.a aVar, h0.b bVar) {
        e4.b.n(this, aVar, bVar);
    }

    @Override // e4.c
    public void f0(c.a aVar, o oVar) {
        G0(aVar, "upstreamDiscarded", y.m(oVar.f73588c));
    }

    @Override // e4.c
    public void g(c.a aVar, Object obj, long j11) {
        G0(aVar, "renderedFirstFrame", String.valueOf(obj));
    }

    @Override // e4.c
    public void g0(c.a aVar, androidx.media3.exoplayer.n nVar) {
        F0(aVar, "videoDisabled");
    }

    @Override // e4.c
    public void h(c.a aVar, int i11, long j11, long j12) {
        I0(aVar, "audioTrackUnderrun", i11 + ", " + j11 + ", " + j12, null);
    }

    @Override // e4.c
    public /* synthetic */ void h0(c.a aVar, y yVar) {
        e4.b.i0(this, aVar, yVar);
    }

    @Override // e4.c
    public void i(c.a aVar, int i11, long j11, long j12) {
    }

    @Override // e4.c
    public void i0(c.a aVar, int i11) {
        G0(aVar, "repeatMode", A0(i11));
    }

    @Override // e4.c
    public void j(c.a aVar, boolean z11, int i11) {
        G0(aVar, "playWhenReady", z11 + ", " + y0(i11));
    }

    @Override // e4.c
    public void j0(c.a aVar, t0 t0Var) {
        G0(aVar, "videoSize", t0Var.f9449a + ", " + t0Var.f9450b);
    }

    @Override // e4.c
    public void k(c.a aVar) {
        F0(aVar, "drmKeysRestored");
    }

    @Override // e4.c
    public void k0(c.a aVar, n nVar, o oVar) {
    }

    @Override // e4.c
    public /* synthetic */ void l(c.a aVar, int i11) {
        e4.b.R(this, aVar, i11);
    }

    @Override // e4.c
    public void l0(c.a aVar, int i11, long j11) {
        G0(aVar, "droppedFrames", Integer.toString(i11));
    }

    @Override // e4.c
    public /* synthetic */ void m(c.a aVar, y yVar) {
        e4.b.g(this, aVar, yVar);
    }

    @Override // e4.c
    public void m0(c.a aVar, n nVar, o oVar, IOException iOException, boolean z11) {
        L0(aVar, "loadError", iOException);
    }

    @Override // e4.c
    public void n(c.a aVar, String str, long j11, long j12) {
        G0(aVar, "audioDecoderInitialized", str);
    }

    @Override // e4.c
    public void n0(c.a aVar, q0 q0Var) {
        Metadata metadata;
        H0("tracks [" + q0(aVar));
        ImmutableList<q0.a> immutableListA = q0Var.a();
        for (int i11 = 0; i11 < immutableListA.size(); i11++) {
            q0.a aVar2 = immutableListA.get(i11);
            H0("  group [");
            for (int i12 = 0; i12 < aVar2.f9435a; i12++) {
                H0("    " + E0(aVar2.h(i12)) + " Track:" + i12 + ", " + y.m(aVar2.b(i12)) + ", supported=" + u0.d0(aVar2.c(i12)));
            }
            H0("  ]");
        }
        boolean z11 = false;
        for (int i13 = 0; !z11 && i13 < immutableListA.size(); i13++) {
            q0.a aVar3 = immutableListA.get(i13);
            for (int i14 = 0; !z11 && i14 < aVar3.f9435a; i14++) {
                if (aVar3.h(i14) && (metadata = aVar3.b(i14).f9499k) != null && metadata.length() > 0) {
                    H0("  Metadata [");
                    M0(metadata, "    ");
                    H0("  ]");
                    z11 = true;
                }
            }
        }
        H0("]");
    }

    @Override // e4.c
    public void o(c.a aVar, boolean z11) {
        G0(aVar, "loading", Boolean.toString(z11));
    }

    @Override // e4.c
    public /* synthetic */ void p(c.a aVar) {
        e4.b.U(this, aVar);
    }

    public final String p0(c.a aVar, String str, @Nullable String str2, @Nullable Throwable th2) {
        String str3 = str + " [" + q0(aVar);
        if (th2 instanceof PlaybackException) {
            str3 = str3 + ", errorCode=" + ((PlaybackException) th2).getErrorCodeName();
        }
        if (str2 != null) {
            str3 = str3 + ", " + str2;
        }
        String strE = z3.o.e(th2);
        if (!TextUtils.isEmpty(strE)) {
            str3 = str3 + "\n  " + strE.replace("\n", "\n  ") + '\n';
        }
        return str3 + "]";
    }

    @Override // e4.c
    public /* synthetic */ void q(c.a aVar, Exception exc) {
        e4.b.a(this, aVar, exc);
    }

    public final String q0(c.a aVar) {
        String str = "window=" + aVar.f63814c;
        if (aVar.f63815d != null) {
            str = str + ", period=" + aVar.f63813b.b(aVar.f63815d.f11209a);
            if (aVar.f63815d.b()) {
                str = (str + ", adGroup=" + aVar.f63815d.f11210b) + ", ad=" + aVar.f63815d.f11211c;
            }
        }
        return "eventTime=" + C0(aVar.f63812a - this.f11522d) + ", mediaPos=" + C0(aVar.f63816e) + ", " + str;
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
    public void s(c.a aVar) {
        F0(aVar, "drmKeysRemoved");
    }

    @Override // e4.c
    public void s0(c.a aVar, o oVar) {
        G0(aVar, "downstreamFormat", y.m(oVar.f73588c));
    }

    @Override // e4.c
    public void t(c.a aVar, PlaybackException playbackException) {
        J0(aVar, "playerFailed", playbackException);
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
    public void u0(c.a aVar, g0 g0Var) {
        G0(aVar, "playbackParameters", g0Var.toString());
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
    public void w(c.a aVar, Metadata metadata) {
        H0("metadata [" + q0(aVar));
        M0(metadata, "  ");
        H0("]");
    }

    @Override // e4.c
    public /* synthetic */ void w0(c.a aVar, long j11, int i11) {
        e4.b.h0(this, aVar, j11, i11);
    }

    @Override // e4.c
    public void x(c.a aVar, String str, long j11, long j12) {
        G0(aVar, "videoDecoderInitialized", str);
    }

    @Override // e4.c
    public /* synthetic */ void y(c.a aVar, y3.b bVar) {
        e4.b.p(this, aVar, bVar);
    }

    @Override // e4.c
    public void z(c.a aVar, Exception exc) {
        L0(aVar, "drmSessionManagerError", exc);
    }
}
