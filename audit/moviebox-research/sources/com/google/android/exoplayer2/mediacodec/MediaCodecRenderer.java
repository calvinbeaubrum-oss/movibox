package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import fh.g;
import fh.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import qg.u1;
import sg.j;
import sg.w;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MediaCodecRenderer extends com.google.android.exoplayer2.e {
    public static final byte[] G0 = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    public final long[] A;
    public boolean A0;
    public final long[] B;

    @Nullable
    public ExoPlaybackException B0;

    @Nullable
    public m1 C;
    public com.google.android.exoplayer2.decoder.e C0;

    @Nullable
    public m1 D;
    public long D0;

    @Nullable
    public DrmSession E;
    public long E0;

    @Nullable
    public DrmSession F;
    public int F0;

    @Nullable
    public MediaCrypto G;
    public boolean H;
    public long I;
    public float J;
    public float K;

    @Nullable
    public c L;

    @Nullable
    public m1 M;

    @Nullable
    public MediaFormat N;
    public boolean O;
    public float P;

    @Nullable
    public ArrayDeque<d> Q;

    @Nullable
    public DecoderInitializationException R;

    @Nullable
    public d S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f33490a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f33491b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f33492c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f33493d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @Nullable
    public h f33494e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f33495f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f33496g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f33497h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @Nullable
    public ByteBuffer f33498i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f33499j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f33500k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f33501l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f33502m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f33503n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c.b f33504o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f33505o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f33506p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f33507p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f33508q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f33509q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f33510r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f33511r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DecoderInputBuffer f33512s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f33513s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DecoderInputBuffer f33514t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f33515t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DecoderInputBuffer f33516u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f33517u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f33518v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public long f33519v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j0<m1> f33520w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public long f33521w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList<Long> f33522x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f33523x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final MediaCodec.BufferInfo f33524y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f33525y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long[] f33526z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f33527z0;

    /* JADX INFO: compiled from: source.java */
    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;

        @Nullable
        public final d codecInfo;

        @Nullable
        public final String diagnosticInfo;

        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(m1 m1Var, @Nullable Throwable th2, boolean z11, int i11) {
            this("Decoder init failed: [" + i11 + "], " + m1Var, th2, m1Var.f33445m, z11, null, buildCustomDiagnosticInfo(i11), null);
        }

        public DecoderInitializationException(m1 m1Var, @Nullable Throwable th2, boolean z11, d dVar) {
            this("Decoder init failed: " + dVar.f33553a + ", " + m1Var, th2, m1Var.f33445m, z11, dVar, o0.f35608a >= 21 ? getDiagnosticInfoV21(th2) : null, null);
        }

        private DecoderInitializationException(String str, @Nullable Throwable th2, String str2, boolean z11, @Nullable d dVar, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th2);
            this.mimeType = str2;
            this.secureDecoderRequired = z11;
            this.codecInfo = dVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        private static String buildCustomDiagnosticInfo(int i11) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i11 < 0 ? "neg_" : "") + Math.abs(i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CheckResult
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        @Nullable
        @RequiresApi(21)
        private static String getDiagnosticInfoV21(@Nullable Throwable th2) {
            if (th2 instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th2).getDiagnosticInfo();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class a {
        public static void a(c.a aVar, u1 u1Var) {
            LogSessionId logSessionIdA = u1Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            aVar.f33548b.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    public MediaCodecRenderer(int i11, c.b bVar, e eVar, boolean z11, float f11) {
        super(i11);
        this.f33504o = bVar;
        this.f33506p = (e) com.google.android.exoplayer2.util.a.e(eVar);
        this.f33508q = z11;
        this.f33510r = f11;
        this.f33512s = DecoderInputBuffer.q();
        this.f33514t = new DecoderInputBuffer(0);
        this.f33516u = new DecoderInputBuffer(2);
        g gVar = new g();
        this.f33518v = gVar;
        this.f33520w = new j0<>();
        this.f33522x = new ArrayList<>();
        this.f33524y = new MediaCodec.BufferInfo();
        this.J = 1.0f;
        this.K = 1.0f;
        this.I = C.TIME_UNSET;
        this.f33526z = new long[10];
        this.A = new long[10];
        this.B = new long[10];
        this.D0 = C.TIME_UNSET;
        this.E0 = C.TIME_UNSET;
        gVar.n(0);
        gVar.f33030c.order(ByteOrder.nativeOrder());
        this.P = -1.0f;
        this.T = 0;
        this.f33507p0 = 0;
        this.f33496g0 = -1;
        this.f33497h0 = -1;
        this.f33495f0 = C.TIME_UNSET;
        this.f33519v0 = C.TIME_UNSET;
        this.f33521w0 = C.TIME_UNSET;
        this.f33509q0 = 0;
        this.f33511r0 = 0;
    }

    public static boolean D(String str, m1 m1Var) {
        return o0.f35608a < 21 && m1Var.f33447o.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    public static boolean E(String str) {
        if (o0.f35608a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(o0.f35610c)) {
            String str2 = o0.f35609b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean F(String str) {
        int i11 = o0.f35608a;
        if (i11 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i11 <= 19) {
                String str2 = o0.f35609b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean G(String str) {
        return o0.f35608a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public static boolean H(d dVar) {
        String str = dVar.f33553a;
        int i11 = o0.f35608a;
        return (i11 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i11 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i11 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(o0.f35610c) && "AFTS".equals(o0.f35611d) && dVar.f33559g));
    }

    public static boolean I(String str) {
        int i11 = o0.f35608a;
        return i11 < 18 || (i11 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i11 == 19 && o0.f35611d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    public static boolean J(String str, m1 m1Var) {
        return o0.f35608a <= 18 && m1Var.f33458z == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    public static boolean K(String str) {
        return o0.f35608a == 29 && "c2.android.aac.decoder".equals(str);
    }

    public static boolean T0(m1 m1Var) {
        int i11 = m1Var.F;
        return i11 == 0 || i11 == 2;
    }

    public static boolean m0(IllegalStateException illegalStateException) {
        if (o0.f35608a >= 21 && n0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    @RequiresApi(21)
    public static boolean n0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    @RequiresApi(21)
    public static boolean o0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    public final boolean A(long j11, long j12) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(!this.f33525y0);
        if (this.f33518v.x()) {
            g gVar = this.f33518v;
            if (!A0(j11, j12, null, gVar.f33030c, this.f33497h0, 0, gVar.w(), this.f33518v.u(), this.f33518v.h(), this.f33518v.i(), this.D)) {
                return false;
            }
            w0(this.f33518v.v());
            this.f33518v.b();
        }
        if (this.f33523x0) {
            this.f33525y0 = true;
            return false;
        }
        if (this.f33502m0) {
            com.google.android.exoplayer2.util.a.g(this.f33518v.s(this.f33516u));
            this.f33502m0 = false;
        }
        if (this.f33503n0) {
            if (this.f33518v.x()) {
                return true;
            }
            M();
            this.f33503n0 = false;
            p0();
            if (!this.f33501l0) {
                return false;
            }
        }
        z();
        if (this.f33518v.x()) {
            this.f33518v.o();
        }
        return this.f33518v.x() || this.f33523x0 || this.f33503n0;
    }

    public abstract boolean A0(long j11, long j12, @Nullable c cVar, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, m1 m1Var) throws ExoPlaybackException;

    public abstract com.google.android.exoplayer2.decoder.g B(d dVar, m1 m1Var, m1 m1Var2);

    public final void B0() {
        this.f33517u0 = true;
        MediaFormat mediaFormatC = this.L.c();
        if (this.T != 0 && mediaFormatC.getInteger("width") == 32 && mediaFormatC.getInteger("height") == 32) {
            this.f33492c0 = true;
            return;
        }
        if (this.f33490a0) {
            mediaFormatC.setInteger("channel-count", 1);
        }
        this.N = mediaFormatC;
        this.O = true;
    }

    public final int C(String str) {
        int i11 = o0.f35608a;
        if (i11 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = o0.f35611d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i11 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = o0.f35609b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    public final boolean C0(int i11) throws ExoPlaybackException {
        n1 n1VarK = k();
        this.f33512s.b();
        int iW = w(n1VarK, this.f33512s, i11 | 4);
        if (iW == -5) {
            u0(n1VarK);
            return true;
        }
        if (iW != -4 || !this.f33512s.i()) {
            return false;
        }
        this.f33523x0 = true;
        z0();
        return false;
    }

    public final void D0() throws ExoPlaybackException {
        E0();
        p0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void E0() {
        try {
            c cVar = this.L;
            if (cVar != null) {
                cVar.release();
                this.C0.f33063b++;
                t0(this.S.f33553a);
            }
            this.L = null;
            try {
                MediaCrypto mediaCrypto = this.G;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.G = null;
                K0(null);
                H0();
            }
        } catch (Throwable th2) {
            this.L = null;
            try {
                MediaCrypto mediaCrypto2 = this.G;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th2;
            } finally {
                this.G = null;
                K0(null);
                H0();
            }
        }
    }

    public void F0() throws ExoPlaybackException {
    }

    @CallSuper
    public void G0() {
        I0();
        J0();
        this.f33495f0 = C.TIME_UNSET;
        this.f33515t0 = false;
        this.f33513s0 = false;
        this.f33491b0 = false;
        this.f33492c0 = false;
        this.f33499j0 = false;
        this.f33500k0 = false;
        this.f33522x.clear();
        this.f33519v0 = C.TIME_UNSET;
        this.f33521w0 = C.TIME_UNSET;
        h hVar = this.f33494e0;
        if (hVar != null) {
            hVar.c();
        }
        this.f33509q0 = 0;
        this.f33511r0 = 0;
        this.f33507p0 = this.f33505o0 ? 1 : 0;
    }

    @CallSuper
    public void H0() {
        G0();
        this.B0 = null;
        this.f33494e0 = null;
        this.Q = null;
        this.S = null;
        this.M = null;
        this.N = null;
        this.O = false;
        this.f33517u0 = false;
        this.P = -1.0f;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f33490a0 = false;
        this.f33493d0 = false;
        this.f33505o0 = false;
        this.f33507p0 = 0;
        this.H = false;
    }

    public final void I0() {
        this.f33496g0 = -1;
        this.f33514t.f33030c = null;
    }

    public final void J0() {
        this.f33497h0 = -1;
        this.f33498i0 = null;
    }

    public final void K0(@Nullable DrmSession drmSession) {
        j.a(this.E, drmSession);
        this.E = drmSession;
    }

    public MediaCodecDecoderException L(Throwable th2, @Nullable d dVar) {
        return new MediaCodecDecoderException(th2, dVar);
    }

    public final void L0() {
        this.A0 = true;
    }

    public final void M() {
        this.f33503n0 = false;
        this.f33518v.b();
        this.f33516u.b();
        this.f33502m0 = false;
        this.f33501l0 = false;
    }

    public final void M0(ExoPlaybackException exoPlaybackException) {
        this.B0 = exoPlaybackException;
    }

    public final boolean N() {
        if (this.f33513s0) {
            this.f33509q0 = 1;
            if (this.V || this.X) {
                this.f33511r0 = 3;
                return false;
            }
            this.f33511r0 = 1;
        }
        return true;
    }

    public final void N0(@Nullable DrmSession drmSession) {
        j.a(this.F, drmSession);
        this.F = drmSession;
    }

    public final void O() throws ExoPlaybackException {
        if (!this.f33513s0) {
            D0();
        } else {
            this.f33509q0 = 1;
            this.f33511r0 = 3;
        }
    }

    public final boolean O0(long j11) {
        return this.I == C.TIME_UNSET || SystemClock.elapsedRealtime() - j11 < this.I;
    }

    @TargetApi(23)
    public final boolean P() throws ExoPlaybackException {
        if (this.f33513s0) {
            this.f33509q0 = 1;
            if (this.V || this.X) {
                this.f33511r0 = 3;
                return false;
            }
            this.f33511r0 = 2;
        } else {
            V0();
        }
        return true;
    }

    public boolean P0(d dVar) {
        return true;
    }

    public final boolean Q(long j11, long j12) throws ExoPlaybackException {
        boolean z11;
        boolean zA0;
        int iJ;
        if (!i0()) {
            if (this.Y && this.f33515t0) {
                try {
                    iJ = this.L.j(this.f33524y);
                } catch (IllegalStateException unused) {
                    z0();
                    if (this.f33525y0) {
                        E0();
                    }
                    return false;
                }
            } else {
                iJ = this.L.j(this.f33524y);
            }
            if (iJ < 0) {
                if (iJ == -2) {
                    B0();
                    return true;
                }
                if (this.f33493d0 && (this.f33523x0 || this.f33509q0 == 2)) {
                    z0();
                }
                return false;
            }
            if (this.f33492c0) {
                this.f33492c0 = false;
                this.L.k(iJ, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.f33524y;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                z0();
                return false;
            }
            this.f33497h0 = iJ;
            ByteBuffer byteBufferL = this.L.l(iJ);
            this.f33498i0 = byteBufferL;
            if (byteBufferL != null) {
                byteBufferL.position(this.f33524y.offset);
                ByteBuffer byteBuffer = this.f33498i0;
                MediaCodec.BufferInfo bufferInfo2 = this.f33524y;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.Z) {
                MediaCodec.BufferInfo bufferInfo3 = this.f33524y;
                if (bufferInfo3.presentationTimeUs == 0 && (bufferInfo3.flags & 4) != 0) {
                    long j13 = this.f33519v0;
                    if (j13 != C.TIME_UNSET) {
                        bufferInfo3.presentationTimeUs = j13;
                    }
                }
            }
            this.f33499j0 = l0(this.f33524y.presentationTimeUs);
            long j14 = this.f33521w0;
            long j15 = this.f33524y.presentationTimeUs;
            this.f33500k0 = j14 == j15;
            W0(j15);
        }
        if (this.Y && this.f33515t0) {
            try {
                c cVar = this.L;
                ByteBuffer byteBuffer2 = this.f33498i0;
                int i11 = this.f33497h0;
                MediaCodec.BufferInfo bufferInfo4 = this.f33524y;
                z11 = false;
                try {
                    zA0 = A0(j11, j12, cVar, byteBuffer2, i11, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.f33499j0, this.f33500k0, this.D);
                } catch (IllegalStateException unused2) {
                    z0();
                    if (this.f33525y0) {
                        E0();
                    }
                    return z11;
                }
            } catch (IllegalStateException unused3) {
                z11 = false;
            }
        } else {
            z11 = false;
            c cVar2 = this.L;
            ByteBuffer byteBuffer3 = this.f33498i0;
            int i12 = this.f33497h0;
            MediaCodec.BufferInfo bufferInfo5 = this.f33524y;
            zA0 = A0(j11, j12, cVar2, byteBuffer3, i12, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f33499j0, this.f33500k0, this.D);
        }
        if (zA0) {
            w0(this.f33524y.presentationTimeUs);
            boolean z12 = (this.f33524y.flags & 4) != 0;
            J0();
            if (!z12) {
                return true;
            }
            z0();
        }
        return z11;
    }

    public boolean Q0() {
        return false;
    }

    public final boolean R(d dVar, m1 m1Var, @Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) throws ExoPlaybackException {
        w wVarD0;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 == null || drmSession == null || o0.f35608a < 23) {
            return true;
        }
        UUID uuid = com.google.android.exoplayer2.h.f33257e;
        if (uuid.equals(drmSession.a()) || uuid.equals(drmSession2.a()) || (wVarD0 = d0(drmSession2)) == null) {
            return true;
        }
        return !dVar.f33559g && (wVarD0.f76352c ? false : drmSession2.d(m1Var.f33445m));
    }

    public boolean R0(m1 m1Var) {
        return false;
    }

    public final boolean S() throws ExoPlaybackException {
        int i11;
        if (this.L == null || (i11 = this.f33509q0) == 2 || this.f33523x0) {
            return false;
        }
        if (i11 == 0 && Q0()) {
            O();
        }
        if (this.f33496g0 < 0) {
            int i12 = this.L.i();
            this.f33496g0 = i12;
            if (i12 < 0) {
                return false;
            }
            this.f33514t.f33030c = this.L.d(i12);
            this.f33514t.b();
        }
        if (this.f33509q0 == 1) {
            if (!this.f33493d0) {
                this.f33515t0 = true;
                this.L.a(this.f33496g0, 0, 0, 0L, 4);
                I0();
            }
            this.f33509q0 = 2;
            return false;
        }
        if (this.f33491b0) {
            this.f33491b0 = false;
            ByteBuffer byteBuffer = this.f33514t.f33030c;
            byte[] bArr = G0;
            byteBuffer.put(bArr);
            this.L.a(this.f33496g0, 0, bArr.length, 0L, 0);
            I0();
            this.f33513s0 = true;
            return true;
        }
        if (this.f33507p0 == 1) {
            for (int i13 = 0; i13 < this.M.f33447o.size(); i13++) {
                this.f33514t.f33030c.put(this.M.f33447o.get(i13));
            }
            this.f33507p0 = 2;
        }
        int iPosition = this.f33514t.f33030c.position();
        n1 n1VarK = k();
        try {
            int iW = w(n1VarK, this.f33514t, 0);
            if (hasReadStreamToEnd()) {
                this.f33521w0 = this.f33519v0;
            }
            if (iW == -3) {
                return false;
            }
            if (iW == -5) {
                if (this.f33507p0 == 2) {
                    this.f33514t.b();
                    this.f33507p0 = 1;
                }
                u0(n1VarK);
                return true;
            }
            if (this.f33514t.i()) {
                if (this.f33507p0 == 2) {
                    this.f33514t.b();
                    this.f33507p0 = 1;
                }
                this.f33523x0 = true;
                if (!this.f33513s0) {
                    z0();
                    return false;
                }
                try {
                    if (!this.f33493d0) {
                        this.f33515t0 = true;
                        this.L.a(this.f33496g0, 0, 0, 0L, 4);
                        I0();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e11) {
                    throw e(e11, this.C, o0.V(e11.getErrorCode()));
                }
            }
            if (!this.f33513s0 && !this.f33514t.k()) {
                this.f33514t.b();
                if (this.f33507p0 == 2) {
                    this.f33507p0 = 1;
                }
                return true;
            }
            boolean zP = this.f33514t.p();
            if (zP) {
                this.f33514t.f33029b.b(iPosition);
            }
            if (this.U && !zP) {
                x.b(this.f33514t.f33030c);
                if (this.f33514t.f33030c.position() == 0) {
                    return true;
                }
                this.U = false;
            }
            DecoderInputBuffer decoderInputBuffer = this.f33514t;
            long jD = decoderInputBuffer.f33032f;
            h hVar = this.f33494e0;
            if (hVar != null) {
                jD = hVar.d(this.C, decoderInputBuffer);
                this.f33519v0 = Math.max(this.f33519v0, this.f33494e0.b(this.C));
            }
            long j11 = jD;
            if (this.f33514t.h()) {
                this.f33522x.add(Long.valueOf(j11));
            }
            if (this.f33527z0) {
                this.f33520w.a(j11, this.C);
                this.f33527z0 = false;
            }
            this.f33519v0 = Math.max(this.f33519v0, j11);
            this.f33514t.o();
            if (this.f33514t.e()) {
                h0(this.f33514t);
            }
            y0(this.f33514t);
            try {
                if (zP) {
                    this.L.f(this.f33496g0, 0, this.f33514t.f33029b, j11, 0);
                } else {
                    this.L.a(this.f33496g0, 0, this.f33514t.f33030c.limit(), j11, 0);
                }
                I0();
                this.f33513s0 = true;
                this.f33507p0 = 0;
                this.C0.f33064c++;
                return true;
            } catch (MediaCodec.CryptoException e12) {
                throw e(e12, this.C, o0.V(e12.getErrorCode()));
            }
        } catch (DecoderInputBuffer.InsufficientCapacityException e13) {
            r0(e13);
            C0(0);
            T();
            return true;
        }
    }

    public abstract int S0(e eVar, m1 m1Var) throws MediaCodecUtil.DecoderQueryException;

    public final void T() {
        try {
            this.L.flush();
        } finally {
            G0();
        }
    }

    public final boolean U() throws ExoPlaybackException {
        boolean zV = V();
        if (zV) {
            p0();
        }
        return zV;
    }

    public final boolean U0(m1 m1Var) throws ExoPlaybackException {
        if (o0.f35608a >= 23 && this.L != null && this.f33511r0 != 3 && getState() != 0) {
            float fA0 = a0(this.K, m1Var, n());
            float f11 = this.P;
            if (f11 == fA0) {
                return true;
            }
            if (fA0 == -1.0f) {
                O();
                return false;
            }
            if (f11 == -1.0f && fA0 <= this.f33510r) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fA0);
            this.L.b(bundle);
            this.P = fA0;
        }
        return true;
    }

    public boolean V() {
        if (this.L == null) {
            return false;
        }
        int i11 = this.f33511r0;
        if (i11 == 3 || this.V || ((this.W && !this.f33517u0) || (this.X && this.f33515t0))) {
            E0();
            return true;
        }
        if (i11 == 2) {
            int i12 = o0.f35608a;
            com.google.android.exoplayer2.util.a.g(i12 >= 23);
            if (i12 >= 23) {
                try {
                    V0();
                } catch (ExoPlaybackException e11) {
                    s.j("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e11);
                    E0();
                    return true;
                }
            }
        }
        T();
        return false;
    }

    @RequiresApi(23)
    public final void V0() throws ExoPlaybackException {
        try {
            this.G.setMediaDrmSession(d0(this.F).f76351b);
            K0(this.F);
            this.f33509q0 = 0;
            this.f33511r0 = 0;
        } catch (MediaCryptoException e11) {
            throw e(e11, this.C, 6006);
        }
    }

    public final List<d> W(boolean z11) throws MediaCodecUtil.DecoderQueryException {
        List<d> listC0 = c0(this.f33506p, this.C, z11);
        if (listC0.isEmpty() && z11) {
            listC0 = c0(this.f33506p, this.C, false);
            if (!listC0.isEmpty()) {
                s.i("MediaCodecRenderer", "Drm session requires secure decoder for " + this.C.f33445m + ", but no secure decoder available. Trying to proceed with " + listC0 + InstructionFileId.DOT);
            }
        }
        return listC0;
    }

    public final void W0(long j11) throws ExoPlaybackException {
        m1 m1VarJ = this.f33520w.j(j11);
        if (m1VarJ == null && this.O) {
            m1VarJ = this.f33520w.i();
        }
        if (m1VarJ != null) {
            this.D = m1VarJ;
        } else if (!this.O || this.D == null) {
            return;
        }
        v0(this.D, this.N);
        this.O = false;
    }

    @Nullable
    public final c X() {
        return this.L;
    }

    @Nullable
    public final d Y() {
        return this.S;
    }

    public boolean Z() {
        return false;
    }

    @Override // com.google.android.exoplayer2.y2
    public final int a(m1 m1Var) throws ExoPlaybackException {
        try {
            return S0(this.f33506p, m1Var);
        } catch (MediaCodecUtil.DecoderQueryException e11) {
            throw e(e11, m1Var, 4002);
        }
    }

    public abstract float a0(float f11, m1 m1Var, m1[] m1VarArr);

    @Nullable
    public final MediaFormat b0() {
        return this.N;
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.w2
    public void c(float f11, float f12) throws ExoPlaybackException {
        this.J = f11;
        this.K = f12;
        U0(this.M);
    }

    public abstract List<d> c0(e eVar, m1 m1Var, boolean z11) throws MediaCodecUtil.DecoderQueryException;

    @Nullable
    public final w d0(DrmSession drmSession) throws ExoPlaybackException {
        com.google.android.exoplayer2.decoder.b bVarC = drmSession.c();
        if (bVarC == null || (bVarC instanceof w)) {
            return (w) bVarC;
        }
        throw e(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + bVarC), this.C, 6001);
    }

    public abstract c.a e0(d dVar, m1 m1Var, @Nullable MediaCrypto mediaCrypto, float f11);

    public final long f0() {
        return this.E0;
    }

    public float g0() {
        return this.J;
    }

    public void h0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    public final boolean i0() {
        return this.f33497h0 >= 0;
    }

    @Override // com.google.android.exoplayer2.w2
    public boolean isEnded() {
        return this.f33525y0;
    }

    @Override // com.google.android.exoplayer2.w2
    public boolean isReady() {
        return this.C != null && (o() || i0() || (this.f33495f0 != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.f33495f0));
    }

    public final void j0(m1 m1Var) {
        M();
        String str = m1Var.f33445m;
        if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
            this.f33518v.y(32);
        } else {
            this.f33518v.y(1);
        }
        this.f33501l0 = true;
    }

    public final void k0(d dVar, MediaCrypto mediaCrypto) throws Exception {
        String str = dVar.f33553a;
        int i11 = o0.f35608a;
        float fA0 = i11 < 23 ? -1.0f : a0(this.K, this.C, n());
        float f11 = fA0 > this.f33510r ? fA0 : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c.a aVarE0 = e0(dVar, this.C, mediaCrypto, f11);
        if (i11 >= 31) {
            a.a(aVarE0, m());
        }
        try {
            l0.a("createCodec:" + str);
            this.L = this.f33504o.a(aVarE0);
            l0.c();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.S = dVar;
            this.P = f11;
            this.M = this.C;
            this.T = C(str);
            this.U = D(str, this.M);
            this.V = I(str);
            this.W = K(str);
            this.X = F(str);
            this.Y = G(str);
            this.Z = E(str);
            this.f33490a0 = J(str, this.M);
            this.f33493d0 = H(dVar) || Z();
            if (this.L.g()) {
                this.f33505o0 = true;
                this.f33507p0 = 1;
                this.f33491b0 = this.T != 0;
            }
            if ("c2.android.mp3.decoder".equals(dVar.f33553a)) {
                this.f33494e0 = new h();
            }
            if (getState() == 2) {
                this.f33495f0 = SystemClock.elapsedRealtime() + 1000;
            }
            this.C0.f33062a++;
            s0(str, aVarE0, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Throwable th2) {
            l0.c();
            throw th2;
        }
    }

    public final boolean l0(long j11) {
        int size = this.f33522x.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f33522x.get(i11).longValue() == j11) {
                this.f33522x.remove(i11);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.e
    public void p() {
        this.C = null;
        this.D0 = C.TIME_UNSET;
        this.E0 = C.TIME_UNSET;
        this.F0 = 0;
        V();
    }

    public final void p0() throws ExoPlaybackException {
        m1 m1Var;
        if (this.L != null || this.f33501l0 || (m1Var = this.C) == null) {
            return;
        }
        if (this.F == null && R0(m1Var)) {
            j0(this.C);
            return;
        }
        K0(this.F);
        String str = this.C.f33445m;
        DrmSession drmSession = this.E;
        if (drmSession != null) {
            if (this.G == null) {
                w wVarD0 = d0(drmSession);
                if (wVarD0 != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(wVarD0.f76350a, wVarD0.f76351b);
                        this.G = mediaCrypto;
                        this.H = !wVarD0.f76352c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e11) {
                        throw e(e11, this.C, 6006);
                    }
                } else if (this.E.getError() == null) {
                    return;
                }
            }
            if (w.f76349d) {
                int state = this.E.getState();
                if (state == 1) {
                    DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(this.E.getError());
                    throw e(drmSessionException, this.C, drmSessionException.errorCode);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            q0(this.G, this.H);
        } catch (DecoderInitializationException e12) {
            throw e(e12, this.C, 4001);
        }
    }

    @Override // com.google.android.exoplayer2.e
    public void q(boolean z11, boolean z12) throws ExoPlaybackException {
        this.C0 = new com.google.android.exoplayer2.decoder.e();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x009e  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x004a A[SYNTHETIC] */
    public final void q0(MediaCrypto mediaCrypto, boolean z11) throws DecoderInitializationException {
        DecoderInitializationException decoderInitializationException;
        DecoderInitializationException decoderInitializationException2;
        if (this.Q == null) {
            try {
                List<d> listW = W(z11);
                ArrayDeque<d> arrayDeque = new ArrayDeque<>();
                this.Q = arrayDeque;
                if (this.f33508q) {
                    arrayDeque.addAll(listW);
                } else if (!listW.isEmpty()) {
                    this.Q.add(listW.get(0));
                }
                this.R = null;
            } catch (MediaCodecUtil.DecoderQueryException e11) {
                throw new DecoderInitializationException(this.C, e11, z11, -49998);
            }
        }
        if (this.Q.isEmpty()) {
            throw new DecoderInitializationException(this.C, (Throwable) null, z11, -49999);
        }
        d dVarPeekFirst = this.Q.peekFirst();
        while (this.L == null) {
            d dVarPeekFirst2 = this.Q.peekFirst();
            if (!P0(dVarPeekFirst2)) {
                return;
            }
            try {
                k0(dVarPeekFirst2, mediaCrypto);
            } catch (Exception e12) {
                if (dVarPeekFirst2 != dVarPeekFirst) {
                    throw e12;
                }
                try {
                    s.i("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                    Thread.sleep(50L);
                    k0(dVarPeekFirst2, mediaCrypto);
                } catch (Exception e13) {
                    s.j("MediaCodecRenderer", "Failed to initialize decoder: " + dVarPeekFirst2, e13);
                    this.Q.removeFirst();
                    decoderInitializationException = new DecoderInitializationException(this.C, e13, z11, dVarPeekFirst2);
                    r0(decoderInitializationException);
                    decoderInitializationException2 = this.R;
                    if (decoderInitializationException2 == null) {
                        this.R = decoderInitializationException;
                    } else {
                        this.R = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                    }
                    if (!this.Q.isEmpty()) {
                        throw this.R;
                    }
                }
                s.j("MediaCodecRenderer", "Failed to initialize decoder: " + dVarPeekFirst2, e13);
                this.Q.removeFirst();
                decoderInitializationException = new DecoderInitializationException(this.C, e13, z11, dVarPeekFirst2);
                r0(decoderInitializationException);
                decoderInitializationException2 = this.R;
                if (decoderInitializationException2 == null) {
                    this.R = decoderInitializationException;
                } else {
                    this.R = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                }
                if (!this.Q.isEmpty()) {
                    throw this.R;
                }
            }
        }
        this.Q = null;
    }

    @Override // com.google.android.exoplayer2.e
    public void r(long j11, boolean z11) throws ExoPlaybackException {
        this.f33523x0 = false;
        this.f33525y0 = false;
        this.A0 = false;
        if (this.f33501l0) {
            this.f33518v.b();
            this.f33516u.b();
            this.f33502m0 = false;
        } else {
            U();
        }
        if (this.f33520w.l() > 0) {
            this.f33527z0 = true;
        }
        this.f33520w.c();
        int i11 = this.F0;
        if (i11 != 0) {
            this.E0 = this.A[i11 - 1];
            this.D0 = this.f33526z[i11 - 1];
            this.F0 = 0;
        }
    }

    public abstract void r0(Exception exc);

    @Override // com.google.android.exoplayer2.w2
    public void render(long j11, long j12) throws ExoPlaybackException {
        boolean z11 = false;
        if (this.A0) {
            this.A0 = false;
            z0();
        }
        ExoPlaybackException exoPlaybackException = this.B0;
        if (exoPlaybackException != null) {
            this.B0 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.f33525y0) {
                F0();
                return;
            }
            if (this.C != null || C0(2)) {
                p0();
                if (this.f33501l0) {
                    l0.a("bypassRender");
                    while (A(j11, j12)) {
                    }
                    l0.c();
                } else if (this.L != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    l0.a("drainAndFeed");
                    while (Q(j11, j12) && O0(jElapsedRealtime)) {
                    }
                    while (S() && O0(jElapsedRealtime)) {
                    }
                    l0.c();
                } else {
                    this.C0.f33065d += y(j11);
                    C0(1);
                }
                this.C0.c();
            }
        } catch (IllegalStateException e11) {
            if (!m0(e11)) {
                throw e11;
            }
            r0(e11);
            if (o0.f35608a >= 21 && o0(e11)) {
                z11 = true;
            }
            if (z11) {
                E0();
            }
            throw i(L(e11, Y()), this.C, z11, 4003);
        }
    }

    @Override // com.google.android.exoplayer2.e
    public void s() {
        try {
            M();
            E0();
        } finally {
            N0(null);
        }
    }

    public abstract void s0(String str, c.a aVar, long j11, long j12);

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.y2
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.e
    public void t() {
    }

    public abstract void t0(String str);

    @Override // com.google.android.exoplayer2.e
    public void u() {
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x0084  */
    @Nullable
    @CallSuper
    public com.google.android.exoplayer2.decoder.g u0(n1 n1Var) throws ExoPlaybackException {
        int i11;
        boolean z11 = true;
        this.f33527z0 = true;
        m1 m1Var = (m1) com.google.android.exoplayer2.util.a.e(n1Var.f33603b);
        if (m1Var.f33445m == null) {
            throw e(new IllegalArgumentException(), m1Var, 4005);
        }
        N0(n1Var.f33602a);
        this.C = m1Var;
        if (this.f33501l0) {
            this.f33503n0 = true;
            return null;
        }
        c cVar = this.L;
        if (cVar == null) {
            this.Q = null;
            p0();
            return null;
        }
        d dVar = this.S;
        m1 m1Var2 = this.M;
        if (R(dVar, m1Var, this.E, this.F)) {
            O();
            return new com.google.android.exoplayer2.decoder.g(dVar.f33553a, m1Var2, m1Var, 0, 128);
        }
        boolean z12 = this.F != this.E;
        com.google.android.exoplayer2.util.a.g(!z12 || o0.f35608a >= 23);
        com.google.android.exoplayer2.decoder.g gVarB = B(dVar, m1Var2, m1Var);
        int i12 = gVarB.f33079d;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        throw new IllegalStateException();
                    }
                    if (U0(m1Var)) {
                        this.M = m1Var;
                        if (z12 && !P()) {
                            i11 = 2;
                        }
                    } else {
                        i11 = 16;
                    }
                } else if (U0(m1Var)) {
                    this.f33505o0 = true;
                    this.f33507p0 = 1;
                    int i13 = this.T;
                    if (i13 != 2 && (i13 != 1 || m1Var.f33450r != m1Var2.f33450r || m1Var.f33451s != m1Var2.f33451s)) {
                        z11 = false;
                    }
                    this.f33491b0 = z11;
                    this.M = m1Var;
                    if (z12 && !P()) {
                        i11 = 2;
                    }
                } else {
                    i11 = 16;
                }
            } else if (U0(m1Var)) {
                this.M = m1Var;
                if (!z12 ? !N() : !P()) {
                    i11 = 2;
                }
            } else {
                i11 = 16;
            }
            return (gVarB.f33079d != 0 || (this.L == cVar && this.f33511r0 != 3)) ? gVarB : new com.google.android.exoplayer2.decoder.g(dVar.f33553a, m1Var2, m1Var, 0, i11);
        }
        O();
        i11 = 0;
        if (gVarB.f33079d != 0) {
        }
    }

    @Override // com.google.android.exoplayer2.e
    public void v(m1[] m1VarArr, long j11, long j12) throws ExoPlaybackException {
        if (this.E0 == C.TIME_UNSET) {
            com.google.android.exoplayer2.util.a.g(this.D0 == C.TIME_UNSET);
            this.D0 = j11;
            this.E0 = j12;
            return;
        }
        int i11 = this.F0;
        if (i11 == this.A.length) {
            s.i("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.A[this.F0 - 1]);
        } else {
            this.F0 = i11 + 1;
        }
        long[] jArr = this.f33526z;
        int i12 = this.F0;
        jArr[i12 - 1] = j11;
        this.A[i12 - 1] = j12;
        this.B[i12 - 1] = this.f33519v0;
    }

    public abstract void v0(m1 m1Var, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException;

    @CallSuper
    public void w0(long j11) {
        while (true) {
            int i11 = this.F0;
            if (i11 == 0 || j11 < this.B[0]) {
                return;
            }
            long[] jArr = this.f33526z;
            this.D0 = jArr[0];
            this.E0 = this.A[0];
            int i12 = i11 - 1;
            this.F0 = i12;
            System.arraycopy(jArr, 1, jArr, 0, i12);
            long[] jArr2 = this.A;
            System.arraycopy(jArr2, 1, jArr2, 0, this.F0);
            long[] jArr3 = this.B;
            System.arraycopy(jArr3, 1, jArr3, 0, this.F0);
            x0();
        }
    }

    public void x0() {
    }

    public abstract void y0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException;

    public final void z() throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(!this.f33523x0);
        n1 n1VarK = k();
        this.f33516u.b();
        do {
            this.f33516u.b();
            int iW = w(n1VarK, this.f33516u, 0);
            if (iW == -5) {
                u0(n1VarK);
                return;
            }
            if (iW != -4) {
                if (iW != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.f33516u.i()) {
                    this.f33523x0 = true;
                    return;
                }
                if (this.f33527z0) {
                    m1 m1Var = (m1) com.google.android.exoplayer2.util.a.e(this.C);
                    this.D = m1Var;
                    v0(m1Var, null);
                    this.f33527z0 = false;
                }
                this.f33516u.o();
            }
        } while (this.f33518v.s(this.f33516u));
        this.f33502m0 = true;
    }

    @TargetApi(23)
    public final void z0() throws ExoPlaybackException {
        int i11 = this.f33511r0;
        if (i11 == 1) {
            T();
            return;
        }
        if (i11 == 2) {
            T();
            V0();
        } else if (i11 == 3) {
            D0();
        } else {
            this.f33525y0 = true;
            F0();
        }
    }
}
