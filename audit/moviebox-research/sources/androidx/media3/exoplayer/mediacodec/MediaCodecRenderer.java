package androidx.media3.exoplayer.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.n;
import androidx.media3.exoplayer.source.l;
import androidx.media3.exoplayer.t1;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import e4.x3;
import f4.o1;
import i4.j;
import i4.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import m4.k;
import u4.k0;
import z3.h0;
import z3.j0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MediaCodecRenderer extends m {
    public static final byte[] G0 = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    public final MediaCodec.BufferInfo A;
    public boolean A0;
    public final ArrayDeque<b> B;

    @Nullable
    public ExoPlaybackException B0;
    public final o1 C;
    public n C0;

    @Nullable
    public y D;
    public b D0;

    @Nullable
    public y E;
    public long E0;

    @Nullable
    public DrmSession F;
    public boolean F0;

    @Nullable
    public DrmSession G;

    @Nullable
    public MediaCrypto H;
    public boolean I;
    public long J;
    public float K;
    public float L;

    @Nullable
    public c M;

    @Nullable
    public y N;

    @Nullable
    public MediaFormat O;
    public boolean P;
    public float Q;

    @Nullable
    public ArrayDeque<d> R;

    @Nullable
    public DecoderInitializationException S;

    @Nullable
    public d T;
    public int U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f10692a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f10693b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f10694c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f10695d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f10696e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f10697f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f10698g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f10699h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @Nullable
    public ByteBuffer f10700i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f10701j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f10702k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f10703l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f10704m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f10705n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f10706o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f10707p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f10708q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f10709r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c.b f10710s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f10711s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final f f10712t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f10713t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f10714u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f10715u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f10716v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public long f10717v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final DecoderInputBuffer f10718w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public long f10719w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DecoderInputBuffer f10720x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f10721x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final DecoderInputBuffer f10722y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f10723y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final k f10724z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f10725z0;

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

        @Nullable
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(y yVar, @Nullable Throwable th2, boolean z11, int i11) {
            this("Decoder init failed: [" + i11 + "], " + yVar, th2, yVar.f9501m, z11, null, buildCustomDiagnosticInfo(i11), null);
        }

        public DecoderInitializationException(y yVar, @Nullable Throwable th2, boolean z11, d dVar) {
            this("Decoder init failed: " + dVar.f10756a + ", " + yVar, th2, yVar.f9501m, z11, dVar, u0.f81838a >= 21 ? getDiagnosticInfoV21(th2) : null, null);
        }

        private DecoderInitializationException(@Nullable String str, @Nullable Throwable th2, @Nullable String str2, boolean z11, @Nullable d dVar, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th2);
            this.mimeType = str2;
            this.secureDecoderRequired = z11;
            this.codecInfo = dVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        private static String buildCustomDiagnosticInfo(int i11) {
            return "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i11 < 0 ? "neg_" : "") + Math.abs(i11);
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
        public static void a(c.a aVar, x3 x3Var) {
            LogSessionId logSessionIdA = x3Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            aVar.f10751b.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f10726e = new b(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f10729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h0<y> f10730d = new h0<>();

        public b(long j11, long j12, long j13) {
            this.f10727a = j11;
            this.f10728b = j12;
            this.f10729c = j13;
        }
    }

    public MediaCodecRenderer(int i11, c.b bVar, f fVar, boolean z11, float f11) {
        super(i11);
        this.f10710s = bVar;
        this.f10712t = (f) z3.a.e(fVar);
        this.f10714u = z11;
        this.f10716v = f11;
        this.f10718w = DecoderInputBuffer.e();
        this.f10720x = new DecoderInputBuffer(0);
        this.f10722y = new DecoderInputBuffer(2);
        k kVar = new k();
        this.f10724z = kVar;
        this.A = new MediaCodec.BufferInfo();
        this.K = 1.0f;
        this.L = 1.0f;
        this.J = C.TIME_UNSET;
        this.B = new ArrayDeque<>();
        this.D0 = b.f10726e;
        kVar.b(0);
        kVar.f9780c.order(ByteOrder.nativeOrder());
        this.C = new o1();
        this.Q = -1.0f;
        this.U = 0;
        this.f10707p0 = 0;
        this.f10698g0 = -1;
        this.f10699h0 = -1;
        this.f10697f0 = C.TIME_UNSET;
        this.f10717v0 = C.TIME_UNSET;
        this.f10719w0 = C.TIME_UNSET;
        this.E0 = C.TIME_UNSET;
        this.f10708q0 = 0;
        this.f10709r0 = 0;
        this.C0 = new n();
    }

    public static boolean E0(IllegalStateException illegalStateException) {
        if (u0.f81838a >= 21 && F0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    @RequiresApi(21)
    public static boolean F0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    @RequiresApi(21)
    public static boolean G0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    public static boolean R(String str, y yVar) {
        return u0.f81838a < 21 && yVar.f9503o.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    public static boolean S(String str) {
        if (u0.f81838a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(u0.f81840c)) {
            String str2 = u0.f81839b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean T(String str) {
        int i11 = u0.f81838a;
        if (i11 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i11 <= 19) {
                String str2 = u0.f81839b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    @TargetApi(23)
    private void T0() throws ExoPlaybackException {
        int i11 = this.f10709r0;
        if (i11 == 1) {
            h0();
            return;
        }
        if (i11 == 2) {
            h0();
            q1();
        } else if (i11 == 3) {
            X0();
        } else {
            this.f10723y0 = true;
            Z0();
        }
    }

    public static boolean U(String str) {
        return u0.f81838a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public static boolean V(d dVar) {
        String str = dVar.f10756a;
        int i11 = u0.f81838a;
        return (i11 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i11 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i11 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) || ("Amazon".equals(u0.f81840c) && "AFTS".equals(u0.f81841d) && dVar.f10762g));
    }

    public static boolean W(String str) {
        int i11 = u0.f81838a;
        return i11 < 18 || (i11 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i11 == 19 && u0.f81841d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    public static boolean X(String str, y yVar) {
        return u0.f81838a <= 18 && yVar.f9514z == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    public static boolean Y(String str) {
        return u0.f81838a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private boolean g0() throws ExoPlaybackException {
        int i11;
        if (this.M == null || (i11 = this.f10708q0) == 2 || this.f10721x0) {
            return false;
        }
        if (i11 == 0 && l1()) {
            c0();
        }
        c cVar = (c) z3.a.e(this.M);
        if (this.f10698g0 < 0) {
            int i12 = cVar.i();
            this.f10698g0 = i12;
            if (i12 < 0) {
                return false;
            }
            this.f10720x.f9780c = cVar.d(i12);
            this.f10720x.clear();
        }
        if (this.f10708q0 == 1) {
            if (!this.f10696e0) {
                this.f10713t0 = true;
                cVar.a(this.f10698g0, 0, 0, 0L, 4);
                c1();
            }
            this.f10708q0 = 2;
            return false;
        }
        if (this.f10694c0) {
            this.f10694c0 = false;
            ByteBuffer byteBuffer = (ByteBuffer) z3.a.e(this.f10720x.f9780c);
            byte[] bArr = G0;
            byteBuffer.put(bArr);
            cVar.a(this.f10698g0, 0, bArr.length, 0L, 0);
            c1();
            this.f10711s0 = true;
            return true;
        }
        if (this.f10707p0 == 1) {
            for (int i13 = 0; i13 < ((y) z3.a.e(this.N)).f9503o.size(); i13++) {
                ((ByteBuffer) z3.a.e(this.f10720x.f9780c)).put(this.N.f9503o.get(i13));
            }
            this.f10707p0 = 2;
        }
        int iPosition = ((ByteBuffer) z3.a.e(this.f10720x.f9780c)).position();
        t1 t1VarT = t();
        try {
            int iK = K(t1VarT, this.f10720x, 0);
            if (iK == -3) {
                if (hasReadStreamToEnd()) {
                    this.f10719w0 = this.f10717v0;
                }
                return false;
            }
            if (iK == -5) {
                if (this.f10707p0 == 2) {
                    this.f10720x.clear();
                    this.f10707p0 = 1;
                }
                M0(t1VarT);
                return true;
            }
            if (this.f10720x.isEndOfStream()) {
                this.f10719w0 = this.f10717v0;
                if (this.f10707p0 == 2) {
                    this.f10720x.clear();
                    this.f10707p0 = 1;
                }
                this.f10721x0 = true;
                if (!this.f10711s0) {
                    T0();
                    return false;
                }
                try {
                    if (!this.f10696e0) {
                        this.f10713t0 = true;
                        cVar.a(this.f10698g0, 0, 0, 0L, 4);
                        c1();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e11) {
                    throw p(e11, this.D, u0.b0(e11.getErrorCode()));
                }
            }
            if (!this.f10711s0 && !this.f10720x.isKeyFrame()) {
                this.f10720x.clear();
                if (this.f10707p0 == 2) {
                    this.f10707p0 = 1;
                }
                return true;
            }
            boolean zD = this.f10720x.d();
            if (zD) {
                this.f10720x.f9779b.b(iPosition);
            }
            if (this.V && !zD) {
                a4.a.b((ByteBuffer) z3.a.e(this.f10720x.f9780c));
                if (((ByteBuffer) z3.a.e(this.f10720x.f9780c)).position() == 0) {
                    return true;
                }
                this.V = false;
            }
            long j11 = this.f10720x.f9782f;
            if (this.f10725z0) {
                if (this.B.isEmpty()) {
                    this.D0.f10730d.a(j11, (y) z3.a.e(this.D));
                } else {
                    this.B.peekLast().f10730d.a(j11, (y) z3.a.e(this.D));
                }
                this.f10725z0 = false;
            }
            this.f10717v0 = Math.max(this.f10717v0, j11);
            if (hasReadStreamToEnd() || this.f10720x.isLastSample()) {
                this.f10719w0 = this.f10717v0;
            }
            this.f10720x.c();
            if (this.f10720x.hasSupplementalData()) {
                v0(this.f10720x);
            }
            R0(this.f10720x);
            int iM0 = m0(this.f10720x);
            try {
                if (zD) {
                    ((c) z3.a.e(cVar)).f(this.f10698g0, 0, this.f10720x.f9779b, j11, iM0);
                } else {
                    ((c) z3.a.e(cVar)).a(this.f10698g0, 0, ((ByteBuffer) z3.a.e(this.f10720x.f9780c)).limit(), j11, iM0);
                }
                c1();
                this.f10711s0 = true;
                this.f10707p0 = 0;
                this.C0.f10774c++;
                return true;
            } catch (MediaCodec.CryptoException e12) {
                throw p(e12, this.D, u0.b0(e12.getErrorCode()));
            }
        } catch (DecoderInputBuffer.InsufficientCapacityException e13) {
            J0(e13);
            W0(0);
            h0();
            return true;
        }
    }

    private void i1(@Nullable DrmSession drmSession) {
        j.a(this.G, drmSession);
        this.G = drmSession;
    }

    public static boolean o1(y yVar) {
        int i11 = yVar.I;
        return i11 == 0 || i11 == 2;
    }

    @Override // androidx.media3.exoplayer.m
    public void A(boolean z11, boolean z12) throws ExoPlaybackException {
        this.C0 = new n();
    }

    public final boolean A0() throws ExoPlaybackException {
        boolean z11 = false;
        z3.a.g(this.H == null);
        DrmSession drmSession = this.F;
        String str = ((y) z3.a.e(this.D)).f9501m;
        androidx.media3.decoder.b bVarC = drmSession.c();
        if (w.f67139d && (bVarC instanceof w)) {
            int state = drmSession.getState();
            if (state == 1) {
                DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) z3.a.e(drmSession.getError());
                throw p(drmSessionException, this.D, drmSessionException.errorCode);
            }
            if (state != 4) {
                return false;
            }
        }
        if (bVarC == null) {
            return drmSession.getError() != null;
        }
        if (bVarC instanceof w) {
            w wVar = (w) bVarC;
            try {
                MediaCrypto mediaCrypto = new MediaCrypto(wVar.f67140a, wVar.f67141b);
                this.H = mediaCrypto;
                if (!wVar.f67142c && mediaCrypto.requiresSecureDecoderComponent((String) z3.a.i(str))) {
                    z11 = true;
                }
                this.I = z11;
            } catch (MediaCryptoException e11) {
                throw p(e11, this.D, 6006);
            }
        }
        return true;
    }

    public final boolean B0() {
        return this.f10703l0;
    }

    @Override // androidx.media3.exoplayer.m
    public void C(long j11, boolean z11) throws ExoPlaybackException {
        this.f10721x0 = false;
        this.f10723y0 = false;
        this.A0 = false;
        if (this.f10703l0) {
            this.f10724z.clear();
            this.f10722y.clear();
            this.f10704m0 = false;
            this.C.d();
        } else {
            i0();
        }
        if (this.D0.f10730d.l() > 0) {
            this.f10725z0 = true;
        }
        this.D0.f10730d.c();
        this.B.clear();
    }

    public final boolean C0(y yVar) {
        return this.G == null && m1(yVar);
    }

    public final boolean D0(long j11, long j12) {
        y yVar;
        return j12 < j11 && !((yVar = this.E) != null && Objects.equals(yVar.f9501m, MimeTypes.AUDIO_OPUS) && k0.g(j11, j12));
    }

    @Override // androidx.media3.exoplayer.m
    public void F() {
        try {
            a0();
            Y0();
        } finally {
            i1(null);
        }
    }

    @Override // androidx.media3.exoplayer.m
    public void G() {
    }

    @Override // androidx.media3.exoplayer.m
    public void H() {
    }

    public final void H0() throws ExoPlaybackException {
        y yVar;
        if (this.M != null || this.f10703l0 || (yVar = this.D) == null) {
            return;
        }
        if (C0(yVar)) {
            y0(this.D);
            return;
        }
        e1(this.G);
        if (this.F == null || A0()) {
            try {
                I0(this.H, this.I);
            } catch (DecoderInitializationException e11) {
                throw p(e11, this.D, 4001);
            }
        }
        MediaCrypto mediaCrypto = this.H;
        if (mediaCrypto == null || this.M != null) {
            return;
        }
        mediaCrypto.release();
        this.H = null;
        this.I = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        if (r5 >= r1) goto L13;
     */
    @Override // androidx.media3.exoplayer.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I(y[] yVarArr, long j11, long j12, l.b bVar) throws ExoPlaybackException {
        if (this.D0.f10729c == C.TIME_UNSET) {
            f1(new b(C.TIME_UNSET, j11, j12));
            return;
        }
        if (this.B.isEmpty()) {
            long j13 = this.f10717v0;
            if (j13 != C.TIME_UNSET) {
                long j14 = this.E0;
                if (j14 != C.TIME_UNSET) {
                }
            }
            f1(new b(C.TIME_UNSET, j11, j12));
            if (this.D0.f10729c != C.TIME_UNSET) {
                Q0();
                return;
            }
            return;
        }
        this.B.add(new b(this.f10717v0, j11, j12));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0056 A[SYNTHETIC] */
    public final void I0(@Nullable MediaCrypto mediaCrypto, boolean z11) throws DecoderInitializationException {
        DecoderInitializationException decoderInitializationException;
        DecoderInitializationException decoderInitializationException2;
        y yVar = (y) z3.a.e(this.D);
        if (this.R == null) {
            try {
                List<d> listK0 = k0(z11);
                ArrayDeque<d> arrayDeque = new ArrayDeque<>();
                this.R = arrayDeque;
                if (this.f10714u) {
                    arrayDeque.addAll(listK0);
                } else if (!listK0.isEmpty()) {
                    this.R.add(listK0.get(0));
                }
                this.S = null;
            } catch (MediaCodecUtil.DecoderQueryException e11) {
                throw new DecoderInitializationException(yVar, e11, z11, -49998);
            }
        }
        if (this.R.isEmpty()) {
            throw new DecoderInitializationException(yVar, (Throwable) null, z11, -49999);
        }
        ArrayDeque arrayDeque2 = (ArrayDeque) z3.a.e(this.R);
        d dVar = (d) arrayDeque2.peekFirst();
        while (this.M == null) {
            d dVar2 = (d) z3.a.e((d) arrayDeque2.peekFirst());
            if (!k1(dVar2)) {
                return;
            }
            try {
                z0(dVar2, mediaCrypto);
            } catch (Exception e12) {
                if (dVar2 != dVar) {
                    throw e12;
                }
                try {
                    o.h("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                    Thread.sleep(50L);
                    z0(dVar2, mediaCrypto);
                } catch (Exception e13) {
                    o.i("MediaCodecRenderer", "Failed to initialize decoder: " + dVar2, e13);
                    arrayDeque2.removeFirst();
                    decoderInitializationException = new DecoderInitializationException(yVar, e13, z11, dVar2);
                    J0(decoderInitializationException);
                    decoderInitializationException2 = this.S;
                    if (decoderInitializationException2 == null) {
                        this.S = decoderInitializationException;
                    } else {
                        this.S = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                    }
                    if (!arrayDeque2.isEmpty()) {
                        throw this.S;
                    }
                }
                o.i("MediaCodecRenderer", "Failed to initialize decoder: " + dVar2, e13);
                arrayDeque2.removeFirst();
                decoderInitializationException = new DecoderInitializationException(yVar, e13, z11, dVar2);
                J0(decoderInitializationException);
                decoderInitializationException2 = this.S;
                if (decoderInitializationException2 == null) {
                    this.S = decoderInitializationException;
                } else {
                    this.S = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                }
                if (!arrayDeque2.isEmpty()) {
                    throw this.S;
                }
            }
        }
        this.R = null;
    }

    public abstract void J0(Exception exc);

    public abstract void K0(String str, c.a aVar, long j11, long j12);

    public abstract void L0(String str);

    /* JADX WARN: Code duplicated, block: B:34:0x0084  */
    /* JADX WARN: Code duplicated, block: B:39:0x0091  */
    @Nullable
    @CallSuper
    public androidx.media3.exoplayer.o M0(t1 t1Var) throws ExoPlaybackException {
        int i11;
        boolean z11 = true;
        this.f10725z0 = true;
        y yVar = (y) z3.a.e(t1Var.f11382b);
        if (yVar.f9501m == null) {
            throw p(new IllegalArgumentException("Sample MIME type is null."), yVar, 4005);
        }
        i1(t1Var.f11381a);
        this.D = yVar;
        if (this.f10703l0) {
            this.f10705n0 = true;
            return null;
        }
        c cVar = this.M;
        if (cVar == null) {
            this.R = null;
            H0();
            return null;
        }
        d dVar = (d) z3.a.e(this.T);
        y yVar2 = (y) z3.a.e(this.N);
        if (f0(dVar, yVar, this.F, this.G)) {
            c0();
            return new androidx.media3.exoplayer.o(dVar.f10756a, yVar2, yVar, 0, 128);
        }
        boolean z12 = this.G != this.F;
        z3.a.g(!z12 || u0.f81838a >= 23);
        androidx.media3.exoplayer.o oVarP = P(dVar, yVar2, yVar);
        int i12 = oVarP.f10792d;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        throw new IllegalStateException();
                    }
                    if (p1(yVar)) {
                        this.N = yVar;
                        if (z12 && !d0()) {
                            i11 = 2;
                        }
                    } else {
                        i11 = 16;
                    }
                } else if (p1(yVar)) {
                    this.f10706o0 = true;
                    this.f10707p0 = 1;
                    int i13 = this.U;
                    if (i13 != 2 && (i13 != 1 || yVar.f9506r != yVar2.f9506r || yVar.f9507s != yVar2.f9507s)) {
                        z11 = false;
                    }
                    this.f10694c0 = z11;
                    this.N = yVar;
                    if (z12 && !d0()) {
                        i11 = 2;
                    }
                } else {
                    i11 = 16;
                }
            } else if (p1(yVar)) {
                this.N = yVar;
                if (!z12 ? !b0() : !d0()) {
                    i11 = 2;
                }
            } else {
                i11 = 16;
            }
            return (oVarP.f10792d != 0 || (this.M == cVar && this.f10709r0 != 3)) ? oVarP : new androidx.media3.exoplayer.o(dVar.f10756a, yVar2, yVar, 0, i11);
        }
        c0();
        i11 = 0;
        if (oVarP.f10792d != 0) {
        }
    }

    public final void N() throws ExoPlaybackException {
        z3.a.g(!this.f10721x0);
        t1 t1VarT = t();
        this.f10722y.clear();
        do {
            this.f10722y.clear();
            int iK = K(t1VarT, this.f10722y, 0);
            if (iK == -5) {
                M0(t1VarT);
                return;
            }
            if (iK == -4) {
                if (!this.f10722y.isEndOfStream()) {
                    if (this.f10725z0) {
                        y yVar = (y) z3.a.e(this.D);
                        this.E = yVar;
                        if (Objects.equals(yVar.f9501m, MimeTypes.AUDIO_OPUS) && !this.E.f9503o.isEmpty()) {
                            this.E = ((y) z3.a.e(this.E)).b().S(k0.f(this.E.f9503o.get(0))).I();
                        }
                        N0(this.E, null);
                        this.f10725z0 = false;
                    }
                    this.f10722y.c();
                    y yVar2 = this.E;
                    if (yVar2 != null && Objects.equals(yVar2.f9501m, MimeTypes.AUDIO_OPUS)) {
                        if (this.f10722y.hasSupplementalData()) {
                            DecoderInputBuffer decoderInputBuffer = this.f10722y;
                            decoderInputBuffer.f9778a = this.E;
                            v0(decoderInputBuffer);
                        }
                        if (k0.g(v(), this.f10722y.f9782f)) {
                            this.C.a(this.f10722y, ((y) z3.a.e(this.E)).f9503o);
                        }
                    }
                    if (!x0()) {
                        break;
                    }
                } else {
                    this.f10721x0 = true;
                    return;
                }
            } else {
                if (iK != -3) {
                    throw new IllegalStateException();
                }
                return;
            }
        } while (this.f10724z.i(this.f10722y));
        this.f10704m0 = true;
    }

    public abstract void N0(y yVar, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException;

    public final boolean O(long j11, long j12) throws ExoPlaybackException {
        z3.a.g(!this.f10723y0);
        if (this.f10724z.n()) {
            k kVar = this.f10724z;
            if (!U0(j11, j12, null, kVar.f9780c, this.f10699h0, 0, kVar.m(), this.f10724z.k(), D0(v(), this.f10724z.l()), this.f10724z.isEndOfStream(), (y) z3.a.e(this.E))) {
                return false;
            }
            P0(this.f10724z.l());
            this.f10724z.clear();
        }
        if (this.f10721x0) {
            this.f10723y0 = true;
            return false;
        }
        if (this.f10704m0) {
            z3.a.g(this.f10724z.i(this.f10722y));
            this.f10704m0 = false;
        }
        if (this.f10705n0) {
            if (this.f10724z.n()) {
                return true;
            }
            a0();
            this.f10705n0 = false;
            H0();
            if (!this.f10703l0) {
                return false;
            }
        }
        N();
        if (this.f10724z.n()) {
            this.f10724z.c();
        }
        return this.f10724z.n() || this.f10721x0 || this.f10705n0;
    }

    public void O0(long j11) {
    }

    public abstract androidx.media3.exoplayer.o P(d dVar, y yVar, y yVar2);

    @CallSuper
    public void P0(long j11) {
        this.E0 = j11;
        while (!this.B.isEmpty() && j11 >= this.B.peek().f10727a) {
            f1((b) z3.a.e(this.B.poll()));
            Q0();
        }
    }

    public final int Q(String str) {
        int i11 = u0.f81838a;
        if (i11 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = u0.f81841d;
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
        String str3 = u0.f81839b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    public void Q0() {
    }

    public void R0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    public void S0(y yVar) throws ExoPlaybackException {
    }

    public abstract boolean U0(long j11, long j12, @Nullable c cVar, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, y yVar) throws ExoPlaybackException;

    public final void V0() {
        this.f10715u0 = true;
        MediaFormat mediaFormatC = ((c) z3.a.e(this.M)).c();
        if (this.U != 0 && mediaFormatC.getInteger("width") == 32 && mediaFormatC.getInteger("height") == 32) {
            this.f10695d0 = true;
            return;
        }
        if (this.f10693b0) {
            mediaFormatC.setInteger("channel-count", 1);
        }
        this.O = mediaFormatC;
        this.P = true;
    }

    public final boolean W0(int i11) throws ExoPlaybackException {
        t1 t1VarT = t();
        this.f10718w.clear();
        int iK = K(t1VarT, this.f10718w, i11 | 4);
        if (iK == -5) {
            M0(t1VarT);
            return true;
        }
        if (iK != -4 || !this.f10718w.isEndOfStream()) {
            return false;
        }
        this.f10721x0 = true;
        T0();
        return false;
    }

    public final void X0() throws ExoPlaybackException {
        Y0();
        H0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Y0() {
        try {
            c cVar = this.M;
            if (cVar != null) {
                cVar.release();
                this.C0.f10773b++;
                L0(((d) z3.a.e(this.T)).f10756a);
            }
            this.M = null;
            try {
                MediaCrypto mediaCrypto = this.H;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.H = null;
                e1(null);
                b1();
            }
        } catch (Throwable th2) {
            this.M = null;
            try {
                MediaCrypto mediaCrypto2 = this.H;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th2;
            } finally {
                this.H = null;
                e1(null);
                b1();
            }
        }
    }

    public MediaCodecDecoderException Z(Throwable th2, @Nullable d dVar) {
        return new MediaCodecDecoderException(th2, dVar);
    }

    public void Z0() throws ExoPlaybackException {
    }

    @Override // androidx.media3.exoplayer.y2
    public final int a(y yVar) throws ExoPlaybackException {
        try {
            return n1(this.f10712t, yVar);
        } catch (MediaCodecUtil.DecoderQueryException e11) {
            throw p(e11, yVar, 4002);
        }
    }

    public final void a0() {
        this.f10705n0 = false;
        this.f10724z.clear();
        this.f10722y.clear();
        this.f10704m0 = false;
        this.f10703l0 = false;
        this.C.d();
    }

    @CallSuper
    public void a1() {
        c1();
        d1();
        this.f10697f0 = C.TIME_UNSET;
        this.f10713t0 = false;
        this.f10711s0 = false;
        this.f10694c0 = false;
        this.f10695d0 = false;
        this.f10701j0 = false;
        this.f10702k0 = false;
        this.f10717v0 = C.TIME_UNSET;
        this.f10719w0 = C.TIME_UNSET;
        this.E0 = C.TIME_UNSET;
        this.f10708q0 = 0;
        this.f10709r0 = 0;
        this.f10707p0 = this.f10706o0 ? 1 : 0;
    }

    public final boolean b0() {
        if (this.f10711s0) {
            this.f10708q0 = 1;
            if (this.W || this.Y) {
                this.f10709r0 = 3;
                return false;
            }
            this.f10709r0 = 1;
        }
        return true;
    }

    @CallSuper
    public void b1() {
        a1();
        this.B0 = null;
        this.R = null;
        this.T = null;
        this.N = null;
        this.O = null;
        this.P = false;
        this.f10715u0 = false;
        this.Q = -1.0f;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f10692a0 = false;
        this.f10693b0 = false;
        this.f10696e0 = false;
        this.f10706o0 = false;
        this.f10707p0 = 0;
        this.I = false;
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.w2
    public void c(float f11, float f12) throws ExoPlaybackException {
        this.K = f11;
        this.L = f12;
        p1(this.N);
    }

    public final void c0() throws ExoPlaybackException {
        if (!this.f10711s0) {
            X0();
        } else {
            this.f10708q0 = 1;
            this.f10709r0 = 3;
        }
    }

    public final void c1() {
        this.f10698g0 = -1;
        this.f10720x.f9780c = null;
    }

    @TargetApi(23)
    public final boolean d0() throws ExoPlaybackException {
        if (this.f10711s0) {
            this.f10708q0 = 1;
            if (this.W || this.Y) {
                this.f10709r0 = 3;
                return false;
            }
            this.f10709r0 = 2;
        } else {
            q1();
        }
        return true;
    }

    public final void d1() {
        this.f10699h0 = -1;
        this.f10700i0 = null;
    }

    public final boolean e0(long j11, long j12) throws ExoPlaybackException {
        boolean z11;
        boolean zU0;
        int iJ;
        c cVar = (c) z3.a.e(this.M);
        if (!w0()) {
            if (this.Z && this.f10713t0) {
                try {
                    iJ = cVar.j(this.A);
                } catch (IllegalStateException unused) {
                    T0();
                    if (this.f10723y0) {
                        Y0();
                    }
                    return false;
                }
            } else {
                iJ = cVar.j(this.A);
            }
            if (iJ < 0) {
                if (iJ == -2) {
                    V0();
                    return true;
                }
                if (this.f10696e0 && (this.f10721x0 || this.f10708q0 == 2)) {
                    T0();
                }
                return false;
            }
            if (this.f10695d0) {
                this.f10695d0 = false;
                cVar.k(iJ, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.A;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                T0();
                return false;
            }
            this.f10699h0 = iJ;
            ByteBuffer byteBufferL = cVar.l(iJ);
            this.f10700i0 = byteBufferL;
            if (byteBufferL != null) {
                byteBufferL.position(this.A.offset);
                ByteBuffer byteBuffer = this.f10700i0;
                MediaCodec.BufferInfo bufferInfo2 = this.A;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.f10692a0) {
                MediaCodec.BufferInfo bufferInfo3 = this.A;
                if (bufferInfo3.presentationTimeUs == 0 && (bufferInfo3.flags & 4) != 0 && this.f10717v0 != C.TIME_UNSET) {
                    bufferInfo3.presentationTimeUs = this.f10719w0;
                }
            }
            this.f10701j0 = this.A.presentationTimeUs < v();
            long j13 = this.f10719w0;
            this.f10702k0 = j13 != C.TIME_UNSET && j13 <= this.A.presentationTimeUs;
            r1(this.A.presentationTimeUs);
        }
        if (this.Z && this.f10713t0) {
            try {
                ByteBuffer byteBuffer2 = this.f10700i0;
                int i11 = this.f10699h0;
                MediaCodec.BufferInfo bufferInfo4 = this.A;
                z11 = false;
                try {
                    zU0 = U0(j11, j12, cVar, byteBuffer2, i11, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.f10701j0, this.f10702k0, (y) z3.a.e(this.E));
                } catch (IllegalStateException unused2) {
                    T0();
                    if (this.f10723y0) {
                        Y0();
                    }
                    return z11;
                }
            } catch (IllegalStateException unused3) {
                z11 = false;
            }
        } else {
            z11 = false;
            ByteBuffer byteBuffer3 = this.f10700i0;
            int i12 = this.f10699h0;
            MediaCodec.BufferInfo bufferInfo5 = this.A;
            zU0 = U0(j11, j12, cVar, byteBuffer3, i12, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f10701j0, this.f10702k0, (y) z3.a.e(this.E));
        }
        if (zU0) {
            P0(this.A.presentationTimeUs);
            boolean z12 = (this.A.flags & 4) != 0;
            d1();
            if (!z12) {
                return true;
            }
            T0();
        }
        return z11;
    }

    public final void e1(@Nullable DrmSession drmSession) {
        j.a(this.F, drmSession);
        this.F = drmSession;
    }

    public final boolean f0(d dVar, y yVar, @Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) throws ExoPlaybackException {
        androidx.media3.decoder.b bVarC;
        androidx.media3.decoder.b bVarC2;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 != null && drmSession != null && (bVarC = drmSession2.c()) != null && (bVarC2 = drmSession.c()) != null && bVarC.getClass().equals(bVarC2.getClass())) {
            if (!(bVarC instanceof w)) {
                return false;
            }
            w wVar = (w) bVarC;
            if (!drmSession2.a().equals(drmSession.a()) || u0.f81838a < 23) {
                return true;
            }
            UUID uuid = androidx.media3.common.j.f9255e;
            if (!uuid.equals(drmSession.a()) && !uuid.equals(drmSession2.a())) {
                return !dVar.f10762g && (wVar.f67142c ? false : drmSession2.d((String) z3.a.e(yVar.f9501m)));
            }
        }
        return true;
    }

    public final void f1(b bVar) {
        this.D0 = bVar;
        long j11 = bVar.f10729c;
        if (j11 != C.TIME_UNSET) {
            this.F0 = true;
            O0(j11);
        }
    }

    public final void g1() {
        this.A0 = true;
    }

    public final void h0() {
        try {
            ((c) z3.a.i(this.M)).flush();
        } finally {
            a1();
        }
    }

    public final void h1(ExoPlaybackException exoPlaybackException) {
        this.B0 = exoPlaybackException;
    }

    public final boolean i0() throws ExoPlaybackException {
        boolean zJ0 = j0();
        if (zJ0) {
            H0();
        }
        return zJ0;
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isEnded() {
        return this.f10723y0;
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isReady() {
        return this.D != null && (y() || w0() || (this.f10697f0 != C.TIME_UNSET && r().elapsedRealtime() < this.f10697f0));
    }

    public boolean j0() {
        if (this.M == null) {
            return false;
        }
        int i11 = this.f10709r0;
        if (i11 == 3 || this.W || ((this.X && !this.f10715u0) || (this.Y && this.f10713t0))) {
            Y0();
            return true;
        }
        if (i11 == 2) {
            int i12 = u0.f81838a;
            z3.a.g(i12 >= 23);
            if (i12 >= 23) {
                try {
                    q1();
                } catch (ExoPlaybackException e11) {
                    o.i("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e11);
                    Y0();
                    return true;
                }
            }
        }
        h0();
        return false;
    }

    public final boolean j1(long j11) {
        return this.J == C.TIME_UNSET || r().elapsedRealtime() - j11 < this.J;
    }

    public final List<d> k0(boolean z11) throws MediaCodecUtil.DecoderQueryException {
        y yVar = (y) z3.a.e(this.D);
        List<d> listR0 = r0(this.f10712t, yVar, z11);
        if (listR0.isEmpty() && z11) {
            listR0 = r0(this.f10712t, yVar, false);
            if (!listR0.isEmpty()) {
                o.h("MediaCodecRenderer", "Drm session requires secure decoder for " + yVar.f9501m + ", but no secure decoder available. Trying to proceed with " + listR0 + InstructionFileId.DOT);
            }
        }
        return listR0;
    }

    public boolean k1(d dVar) {
        return true;
    }

    @Nullable
    public final c l0() {
        return this.M;
    }

    public boolean l1() {
        return false;
    }

    public int m0(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    public boolean m1(y yVar) {
        return false;
    }

    @Nullable
    public final d n0() {
        return this.T;
    }

    public abstract int n1(f fVar, y yVar) throws MediaCodecUtil.DecoderQueryException;

    public boolean o0() {
        return false;
    }

    public abstract float p0(float f11, y yVar, y[] yVarArr);

    public final boolean p1(@Nullable y yVar) throws ExoPlaybackException {
        if (u0.f81838a >= 23 && this.M != null && this.f10709r0 != 3 && getState() != 0) {
            float fP0 = p0(this.L, (y) z3.a.e(yVar), x());
            float f11 = this.Q;
            if (f11 == fP0) {
                return true;
            }
            if (fP0 == -1.0f) {
                c0();
                return false;
            }
            if (f11 == -1.0f && fP0 <= this.f10716v) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fP0);
            ((c) z3.a.e(this.M)).b(bundle);
            this.Q = fP0;
        }
        return true;
    }

    @Nullable
    public final MediaFormat q0() {
        return this.O;
    }

    @RequiresApi(23)
    public final void q1() throws ExoPlaybackException {
        androidx.media3.decoder.b bVarC = ((DrmSession) z3.a.e(this.G)).c();
        if (bVarC instanceof w) {
            try {
                ((MediaCrypto) z3.a.e(this.H)).setMediaDrmSession(((w) bVarC).f67141b);
            } catch (MediaCryptoException e11) {
                throw p(e11, this.D, 6006);
            }
        }
        e1(this.G);
        this.f10708q0 = 0;
        this.f10709r0 = 0;
    }

    public abstract List<d> r0(f fVar, y yVar, boolean z11) throws MediaCodecUtil.DecoderQueryException;

    public final void r1(long j11) throws ExoPlaybackException {
        y yVarJ = this.D0.f10730d.j(j11);
        if (yVarJ == null && this.F0 && this.O != null) {
            yVarJ = this.D0.f10730d.i();
        }
        if (yVarJ != null) {
            this.E = yVarJ;
        } else if (!this.P || this.E == null) {
            return;
        }
        N0((y) z3.a.e(this.E), this.O);
        this.P = false;
        this.F0 = false;
    }

    @Override // androidx.media3.exoplayer.w2
    public void render(long j11, long j12) throws ExoPlaybackException {
        boolean z11 = false;
        if (this.A0) {
            this.A0 = false;
            T0();
        }
        ExoPlaybackException exoPlaybackException = this.B0;
        if (exoPlaybackException != null) {
            this.B0 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.f10723y0) {
                Z0();
                return;
            }
            if (this.D != null || W0(2)) {
                H0();
                if (this.f10703l0) {
                    j0.a("bypassRender");
                    while (O(j11, j12)) {
                    }
                    j0.c();
                } else if (this.M != null) {
                    long jElapsedRealtime = r().elapsedRealtime();
                    j0.a("drainAndFeed");
                    while (e0(j11, j12) && j1(jElapsedRealtime)) {
                    }
                    while (g0() && j1(jElapsedRealtime)) {
                    }
                    j0.c();
                } else {
                    this.C0.f10775d += M(j11);
                    W0(1);
                }
                this.C0.c();
            }
        } catch (IllegalStateException e11) {
            if (!E0(e11)) {
                throw e11;
            }
            J0(e11);
            if (u0.f81838a >= 21 && G0(e11)) {
                z11 = true;
            }
            if (z11) {
                Y0();
            }
            throw q(Z(e11, n0()), this.D, z11, 4003);
        }
    }

    public abstract c.a s0(d dVar, y yVar, @Nullable MediaCrypto mediaCrypto, float f11);

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.y2
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public final long t0() {
        return this.D0.f10729c;
    }

    public final long u0() {
        return this.D0.f10728b;
    }

    public abstract void v0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException;

    public final boolean w0() {
        return this.f10699h0 >= 0;
    }

    public final boolean x0() {
        if (!this.f10724z.n()) {
            return true;
        }
        long jV = v();
        return D0(jV, this.f10724z.l()) == D0(jV, this.f10722y.f9782f);
    }

    public final void y0(y yVar) {
        a0();
        String str = yVar.f9501m;
        if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
            this.f10724z.o(32);
        } else {
            this.f10724z.o(1);
        }
        this.f10703l0 = true;
    }

    @Override // androidx.media3.exoplayer.m
    public void z() {
        this.D = null;
        f1(b.f10726e);
        this.B.clear();
        j0();
    }

    public final void z0(d dVar, @Nullable MediaCrypto mediaCrypto) throws Exception {
        y yVar = (y) z3.a.e(this.D);
        String str = dVar.f10756a;
        int i11 = u0.f81838a;
        float fP0 = i11 < 23 ? -1.0f : p0(this.L, yVar, x());
        float f11 = fP0 > this.f10716v ? fP0 : -1.0f;
        S0(yVar);
        long jElapsedRealtime = r().elapsedRealtime();
        c.a aVarS0 = s0(dVar, yVar, mediaCrypto, f11);
        if (i11 >= 31) {
            a.a(aVarS0, w());
        }
        try {
            j0.a("createCodec:" + str);
            this.M = this.f10710s.a(aVarS0);
            j0.c();
            long jElapsedRealtime2 = r().elapsedRealtime();
            if (!dVar.n(yVar)) {
                o.h("MediaCodecRenderer", u0.G("Format exceeds selected codec's capabilities [%s, %s]", y.m(yVar), str));
            }
            this.T = dVar;
            this.Q = f11;
            this.N = yVar;
            this.U = Q(str);
            this.V = R(str, (y) z3.a.e(this.N));
            this.W = W(str);
            this.X = Y(str);
            this.Y = T(str);
            this.Z = U(str);
            this.f10692a0 = S(str);
            this.f10693b0 = X(str, (y) z3.a.e(this.N));
            this.f10696e0 = V(dVar) || o0();
            if (((c) z3.a.e(this.M)).g()) {
                this.f10706o0 = true;
                this.f10707p0 = 1;
                this.f10694c0 = this.U != 0;
            }
            if (getState() == 2) {
                this.f10697f0 = r().elapsedRealtime() + 1000;
            }
            this.C0.f10772a++;
            K0(str, aVarS0, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Throwable th2) {
            j0.c();
            throw th2;
        }
    }
}
