package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ld extends e2 {
    private static final byte[] I0 = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private final long[] A;
    private boolean A0;
    private f9 B;
    private boolean B0;
    private f9 C;
    private boolean C0;
    private z6 D;
    private a8 D0;
    private z6 E;
    protected n5 E0;
    private MediaCrypto F;
    private long F0;
    private boolean G;
    private long G0;
    private long H;
    private int H0;
    private float I;
    private float J;
    private hd K;
    private f9 L;
    private MediaFormat M;
    private boolean N;
    private float O;
    private ArrayDeque P;
    private a Q;
    private kd R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f20407a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f20408b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f20409c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private s2 f20410d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private long f20411e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f20412f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f20413g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private ByteBuffer f20414h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f20415i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f20416j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f20417k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f20418l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private boolean f20419m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final hd.b f20420n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f20421n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final md f20422o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f20423o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f20424p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f20425p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final float f20426q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f20427q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final p5 f20428r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f20429r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final p5 f20430s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private boolean f20431s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final p5 f20432t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private boolean f20433t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final g2 f20434u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private long f20435u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final eo f20436v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private long f20437v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ArrayList f20438w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f20439w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final MediaCodec.BufferInfo f20440x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f20441x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final long[] f20442y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private boolean f20443y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final long[] f20444z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private boolean f20445z0;

    /* JADX INFO: compiled from: source.java */
    public static class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f20447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final kd f20448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f20449d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f20450f;

        public a(f9 f9Var, Throwable th2, boolean z11, int i11) {
            this("Decoder init failed: [" + i11 + "], " + f9Var, th2, f9Var.f18900m, z11, null, a(i11), null);
        }

        public a(f9 f9Var, Throwable th2, boolean z11, kd kdVar) {
            this("Decoder init failed: " + kdVar.f20199a + ", " + f9Var, th2, f9Var.f18900m, z11, kdVar, xp.f24372a >= 21 ? a(th2) : null, null);
        }

        private a(String str, Throwable th2, String str2, boolean z11, kd kdVar, String str3, a aVar) {
            super(str, th2);
            this.f20446a = str2;
            this.f20447b = z11;
            this.f20448c = kdVar;
            this.f20449d = str3;
            this.f20450f = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(a aVar) {
            return new a(getMessage(), getCause(), this.f20446a, this.f20447b, this.f20448c, this.f20449d, aVar);
        }

        private static String a(int i11) {
            return "com.applovin.exoplayer2.mediacodec.MediaCodecRenderer_" + (i11 < 0 ? "neg_" : "") + Math.abs(i11);
        }

        private static String a(Throwable th2) {
            if (th2 instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th2).getDiagnosticInfo();
            }
            return null;
        }
    }

    public ld(int i11, hd.b bVar, md mdVar, boolean z11, float f11) {
        super(i11);
        this.f20420n = bVar;
        this.f20422o = (md) b1.a(mdVar);
        this.f20424p = z11;
        this.f20426q = f11;
        this.f20428r = p5.i();
        this.f20430s = new p5(0);
        this.f20432t = new p5(2);
        g2 g2Var = new g2();
        this.f20434u = g2Var;
        this.f20436v = new eo();
        this.f20438w = new ArrayList();
        this.f20440x = new MediaCodec.BufferInfo();
        this.I = 1.0f;
        this.J = 1.0f;
        this.H = C.TIME_UNSET;
        this.f20442y = new long[10];
        this.f20444z = new long[10];
        this.A = new long[10];
        this.F0 = C.TIME_UNSET;
        this.G0 = C.TIME_UNSET;
        g2Var.g(0);
        g2Var.f21655c.order(ByteOrder.nativeOrder());
        this.O = -1.0f;
        this.S = 0;
        this.f20423o0 = 0;
        this.f20412f0 = -1;
        this.f20413g0 = -1;
        this.f20411e0 = C.TIME_UNSET;
        this.f20435u0 = C.TIME_UNSET;
        this.f20437v0 = C.TIME_UNSET;
        this.f20425p0 = 0;
        this.f20427q0 = 0;
    }

    private void A() {
        this.f20419m0 = false;
        this.f20434u.b();
        this.f20432t.b();
        this.f20418l0 = false;
        this.f20417k0 = false;
    }

    private boolean B() {
        if (this.f20429r0) {
            this.f20425p0 = 1;
            if (this.U || this.W) {
                this.f20427q0 = 3;
                return false;
            }
            this.f20427q0 = 1;
        }
        return true;
    }

    private void C() throws a8 {
        if (!this.f20429r0) {
            T();
        } else {
            this.f20425p0 = 1;
            this.f20427q0 = 3;
        }
    }

    private boolean D() throws a8 {
        if (this.f20429r0) {
            this.f20425p0 = 1;
            if (this.U || this.W) {
                this.f20427q0 = 3;
                return false;
            }
            this.f20427q0 = 2;
        } else {
            b0();
        }
        return true;
    }

    private boolean E() throws a8 {
        hd hdVar = this.K;
        if (hdVar == null || this.f20425p0 == 2 || this.f20439w0) {
            return false;
        }
        if (this.f20412f0 < 0) {
            int iD = hdVar.d();
            this.f20412f0 = iD;
            if (iD < 0) {
                return false;
            }
            this.f20430s.f21655c = this.K.a(iD);
            this.f20430s.b();
        }
        if (this.f20425p0 == 1) {
            if (!this.f20409c0) {
                this.f20431s0 = true;
                this.K.a(this.f20412f0, 0, 0, 0L, 4);
                Y();
            }
            this.f20425p0 = 2;
            return false;
        }
        if (this.f20407a0) {
            this.f20407a0 = false;
            ByteBuffer byteBuffer = this.f20430s.f21655c;
            byte[] bArr = I0;
            byteBuffer.put(bArr);
            this.K.a(this.f20412f0, 0, bArr.length, 0L, 0);
            Y();
            this.f20429r0 = true;
            return true;
        }
        if (this.f20423o0 == 1) {
            for (int i11 = 0; i11 < this.L.f18902o.size(); i11++) {
                this.f20430s.f21655c.put((byte[]) this.L.f18902o.get(i11));
            }
            this.f20423o0 = 2;
        }
        int iPosition = this.f20430s.f21655c.position();
        g9 g9VarR = r();
        try {
            int iA = a(g9VarR, this.f20430s, 0);
            if (j()) {
                this.f20437v0 = this.f20435u0;
            }
            if (iA == -3) {
                return false;
            }
            if (iA == -5) {
                if (this.f20423o0 == 2) {
                    this.f20430s.b();
                    this.f20423o0 = 1;
                }
                a(g9VarR);
                return true;
            }
            if (this.f20430s.e()) {
                if (this.f20423o0 == 2) {
                    this.f20430s.b();
                    this.f20423o0 = 1;
                }
                this.f20439w0 = true;
                if (!this.f20429r0) {
                    R();
                    return false;
                }
                try {
                    if (!this.f20409c0) {
                        this.f20431s0 = true;
                        this.K.a(this.f20412f0, 0, 0, 0L, 4);
                        Y();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e11) {
                    throw a(e11, this.B, t2.a(e11.getErrorCode()));
                }
            }
            if (!this.f20429r0 && !this.f20430s.f()) {
                this.f20430s.b();
                if (this.f20423o0 == 2) {
                    this.f20423o0 = 1;
                }
                return true;
            }
            boolean zH = this.f20430s.h();
            if (zH) {
                this.f20430s.f21654b.a(iPosition);
            }
            if (this.T && !zH) {
                zf.a(this.f20430s.f21655c);
                if (this.f20430s.f21655c.position() == 0) {
                    return true;
                }
                this.T = false;
            }
            p5 p5Var = this.f20430s;
            long jA = p5Var.f21657f;
            s2 s2Var = this.f20410d0;
            if (s2Var != null) {
                jA = s2Var.a(this.B, p5Var);
                this.f20435u0 = Math.max(this.f20435u0, this.f20410d0.a(this.B));
            }
            long j11 = jA;
            if (this.f20430s.d()) {
                this.f20438w.add(Long.valueOf(j11));
            }
            if (this.f20443y0) {
                this.f20436v.a(j11, this.B);
                this.f20443y0 = false;
            }
            this.f20435u0 = Math.max(this.f20435u0, j11);
            this.f20430s.g();
            if (this.f20430s.c()) {
                a(this.f20430s);
            }
            b(this.f20430s);
            try {
                if (zH) {
                    this.K.a(this.f20412f0, 0, this.f20430s.f21654b, j11, 0);
                } else {
                    this.K.a(this.f20412f0, 0, this.f20430s.f21655c.limit(), j11, 0);
                }
                Y();
                this.f20429r0 = true;
                this.f20423o0 = 0;
                this.E0.f21278c++;
                return true;
            } catch (MediaCodec.CryptoException e12) {
                throw a(e12, this.B, t2.a(e12.getErrorCode()));
            }
        } catch (p5.a e13) {
            a(e13);
            e(0);
            F();
            return true;
        }
    }

    private void F() {
        try {
            this.K.b();
        } finally {
            W();
        }
    }

    private boolean O() {
        return this.f20413g0 >= 0;
    }

    private void R() throws a8 {
        int i11 = this.f20427q0;
        if (i11 == 1) {
            F();
            return;
        }
        if (i11 == 2) {
            F();
            b0();
        } else if (i11 == 3) {
            T();
        } else {
            this.f20441x0 = true;
            V();
        }
    }

    private void S() {
        this.f20433t0 = true;
        MediaFormat mediaFormatE = this.K.e();
        if (this.S != 0 && mediaFormatE.getInteger("width") == 32 && mediaFormatE.getInteger("height") == 32) {
            this.f20408b0 = true;
            return;
        }
        if (this.Z) {
            mediaFormatE.setInteger("channel-count", 1);
        }
        this.M = mediaFormatE;
        this.N = true;
    }

    private void T() throws a8 {
        U();
        P();
    }

    private void Y() {
        this.f20412f0 = -1;
        this.f20430s.f21655c = null;
    }

    private void Z() {
        this.f20413g0 = -1;
        this.f20414h0 = null;
    }

    private int a(String str) {
        int i11 = xp.f24372a;
        if (i11 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = xp.f24375d;
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
        String str3 = xp.f24373b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private l9 a(z6 z6Var) throws a8 {
        z4 z4VarF = z6Var.f();
        if (z4VarF == null || (z4VarF instanceof l9)) {
            return (l9) z4VarF;
        }
        throw a(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + z4VarF), this.B, 6001);
    }

    private void a(MediaCrypto mediaCrypto, boolean z11) throws a {
        if (this.P == null) {
            try {
                List listD = d(z11);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.P = arrayDeque;
                if (this.f20424p) {
                    arrayDeque.addAll(listD);
                } else if (!listD.isEmpty()) {
                    this.P.add((kd) listD.get(0));
                }
                this.Q = null;
            } catch (nd.c e11) {
                throw new a(this.B, e11, z11, -49998);
            }
        }
        if (this.P.isEmpty()) {
            throw new a(this.B, (Throwable) null, z11, -49999);
        }
        while (this.K == null) {
            kd kdVar = (kd) this.P.peekFirst();
            if (!b(kdVar)) {
                return;
            }
            try {
                a(kdVar, mediaCrypto);
            } catch (Exception e12) {
                pc.c("MediaCodecRenderer", "Failed to initialize decoder: " + kdVar, e12);
                this.P.removeFirst();
                a aVar = new a(this.B, e12, z11, kdVar);
                a(aVar);
                if (this.Q == null) {
                    this.Q = aVar;
                } else {
                    this.Q = this.Q.a(aVar);
                }
                if (this.P.isEmpty()) {
                    throw this.Q;
                }
            }
        }
        this.P = null;
    }

    private void a(kd kdVar, MediaCrypto mediaCrypto) {
        String str = kdVar.f20199a;
        int i11 = xp.f24372a;
        float fA = i11 < 23 ? -1.0f : a(this.J, this.B, t());
        float f11 = fA > this.f20426q ? fA : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ko.a("createCodec:" + str);
        hd.a aVarA = a(kdVar, this.B, mediaCrypto, f11);
        hd hdVarA = (!this.A0 || i11 < 23) ? this.f20420n.a(aVarA) : new g1.b(e(), this.B0, this.C0).a(aVarA);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        this.K = hdVarA;
        this.R = kdVar;
        this.O = f11;
        this.L = this.B;
        this.S = a(str);
        this.T = a(str, this.L);
        this.U = e(str);
        this.V = f(str);
        this.W = c(str);
        this.X = d(str);
        this.Y = b(str);
        this.Z = b(str, this.L);
        this.f20409c0 = a(kdVar) || K();
        if (hdVarA.c()) {
            this.f20421n0 = true;
            this.f20423o0 = 1;
            this.f20407a0 = this.S != 0;
        }
        if ("c2.android.mp3.decoder".equals(kdVar.f20199a)) {
            this.f20410d0 = new s2();
        }
        if (b() == 2) {
            this.f20411e0 = SystemClock.elapsedRealtime() + 1000;
        }
        this.E0.f21276a++;
        a(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
    }

    private static boolean a(kd kdVar) {
        String str = kdVar.f20199a;
        int i11 = xp.f24372a;
        return (i11 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i11 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i11 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(xp.f24374c) && "AFTS".equals(xp.f24375d) && kdVar.f20205g));
    }

    private boolean a(kd kdVar, f9 f9Var, z6 z6Var, z6 z6Var2) {
        l9 l9VarA;
        if (z6Var == z6Var2) {
            return false;
        }
        if (z6Var2 == null || z6Var == null || xp.f24372a < 23) {
            return true;
        }
        UUID uuid = t2.f23171e;
        if (uuid.equals(z6Var.e()) || uuid.equals(z6Var2.e()) || (l9VarA = a(z6Var2)) == null) {
            return true;
        }
        return !kdVar.f20205g && (l9VarA.f20369c ? false : z6Var2.a(f9Var.f18900m));
    }

    private static boolean a(IllegalStateException illegalStateException) {
        if (xp.f24372a >= 21 && b(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private static boolean a(String str, f9 f9Var) {
        return xp.f24372a < 21 && f9Var.f18902o.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private void b(f9 f9Var) {
        A();
        String str = f9Var.f18900m;
        if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
            this.f20434u.i(32);
        } else {
            this.f20434u.i(1);
        }
        this.f20417k0 = true;
    }

    private void b(z6 z6Var) {
        ma0.a(this.D, z6Var);
        this.D = z6Var;
    }

    private boolean b(long j11, long j12) throws a8 {
        b1.b(!this.f20441x0);
        if (this.f20434u.m()) {
            g2 g2Var = this.f20434u;
            if (!a(j11, j12, null, g2Var.f21655c, this.f20413g0, 0, g2Var.l(), this.f20434u.j(), this.f20434u.d(), this.f20434u.e(), this.C)) {
                return false;
            }
            d(this.f20434u.k());
            this.f20434u.b();
        }
        if (this.f20439w0) {
            this.f20441x0 = true;
            return false;
        }
        if (this.f20418l0) {
            b1.b(this.f20434u.a(this.f20432t));
            this.f20418l0 = false;
        }
        if (this.f20419m0) {
            if (this.f20434u.m()) {
                return true;
            }
            A();
            this.f20419m0 = false;
            P();
            if (!this.f20417k0) {
                return false;
            }
        }
        z();
        if (this.f20434u.m()) {
            this.f20434u.g();
        }
        return this.f20434u.m() || this.f20439w0 || this.f20419m0;
    }

    private static boolean b(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean b(String str) {
        if (xp.f24372a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(xp.f24374c)) {
            String str2 = xp.f24373b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(String str, f9 f9Var) {
        return xp.f24372a <= 18 && f9Var.f18913z == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private void b0() throws a8 {
        try {
            this.F.setMediaDrmSession(a(this.E).f20368b);
            b(this.E);
            this.f20425p0 = 0;
            this.f20427q0 = 0;
        } catch (MediaCryptoException e11) {
            throw a(e11, this.B, 6006);
        }
    }

    private void c(z6 z6Var) {
        ma0.a(this.E, z6Var);
        this.E = z6Var;
    }

    private boolean c(long j11) {
        int size = this.f20438w.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((Long) this.f20438w.get(i11)).longValue() == j11) {
                this.f20438w.remove(i11);
                return true;
            }
        }
        return false;
    }

    private boolean c(long j11, long j12) throws a8 {
        boolean z11;
        boolean zA;
        int iA;
        if (!O()) {
            if (this.X && this.f20431s0) {
                try {
                    iA = this.K.a(this.f20440x);
                } catch (IllegalStateException unused) {
                    R();
                    if (this.f20441x0) {
                        U();
                    }
                    return false;
                }
            } else {
                iA = this.K.a(this.f20440x);
            }
            if (iA < 0) {
                if (iA == -2) {
                    S();
                    return true;
                }
                if (this.f20409c0 && (this.f20439w0 || this.f20425p0 == 2)) {
                    R();
                }
                return false;
            }
            if (this.f20408b0) {
                this.f20408b0 = false;
                this.K.a(iA, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.f20440x;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                R();
                return false;
            }
            this.f20413g0 = iA;
            ByteBuffer byteBufferB = this.K.b(iA);
            this.f20414h0 = byteBufferB;
            if (byteBufferB != null) {
                byteBufferB.position(this.f20440x.offset);
                ByteBuffer byteBuffer = this.f20414h0;
                MediaCodec.BufferInfo bufferInfo2 = this.f20440x;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.Y) {
                MediaCodec.BufferInfo bufferInfo3 = this.f20440x;
                if (bufferInfo3.presentationTimeUs == 0 && (bufferInfo3.flags & 4) != 0) {
                    long j13 = this.f20435u0;
                    if (j13 != C.TIME_UNSET) {
                        bufferInfo3.presentationTimeUs = j13;
                    }
                }
            }
            this.f20415i0 = c(this.f20440x.presentationTimeUs);
            long j14 = this.f20437v0;
            long j15 = this.f20440x.presentationTimeUs;
            this.f20416j0 = j14 == j15;
            f(j15);
        }
        if (this.X && this.f20431s0) {
            try {
                hd hdVar = this.K;
                ByteBuffer byteBuffer2 = this.f20414h0;
                int i11 = this.f20413g0;
                MediaCodec.BufferInfo bufferInfo4 = this.f20440x;
                z11 = false;
                try {
                    zA = a(j11, j12, hdVar, byteBuffer2, i11, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.f20415i0, this.f20416j0, this.C);
                } catch (IllegalStateException unused2) {
                    R();
                    if (this.f20441x0) {
                        U();
                    }
                    return z11;
                }
            } catch (IllegalStateException unused3) {
                z11 = false;
            }
        } else {
            z11 = false;
            hd hdVar2 = this.K;
            ByteBuffer byteBuffer3 = this.f20414h0;
            int i12 = this.f20413g0;
            MediaCodec.BufferInfo bufferInfo5 = this.f20440x;
            zA = a(j11, j12, hdVar2, byteBuffer3, i12, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f20415i0, this.f20416j0, this.C);
        }
        if (zA) {
            d(this.f20440x.presentationTimeUs);
            boolean z12 = (this.f20440x.flags & 4) != 0;
            Z();
            if (!z12) {
                return true;
            }
            R();
        }
        return z11;
    }

    private static boolean c(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    private static boolean c(String str) {
        int i11 = xp.f24372a;
        if (i11 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i11 <= 19) {
                String str2 = xp.f24373b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    private List d(boolean z11) {
        List listA = a(this.f20422o, this.B, z11);
        if (listA.isEmpty() && z11) {
            listA = a(this.f20422o, this.B, false);
            if (!listA.isEmpty()) {
                pc.d("MediaCodecRenderer", "Drm session requires secure decoder for " + this.B.f18900m + ", but no secure decoder available. Trying to proceed with " + listA + InstructionFileId.DOT);
            }
        }
        return listA;
    }

    public static boolean d(f9 f9Var) {
        int i11 = f9Var.F;
        return i11 == 0 || i11 == 2;
    }

    private static boolean d(String str) {
        return xp.f24372a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private boolean e(int i11) throws a8 {
        g9 g9VarR = r();
        this.f20428r.b();
        int iA = a(g9VarR, this.f20428r, i11 | 4);
        if (iA == -5) {
            a(g9VarR);
            return true;
        }
        if (iA != -4 || !this.f20428r.e()) {
            return false;
        }
        this.f20439w0 = true;
        R();
        return false;
    }

    private boolean e(long j11) {
        return this.H == C.TIME_UNSET || SystemClock.elapsedRealtime() - j11 < this.H;
    }

    private boolean e(f9 f9Var) throws a8 {
        if (xp.f24372a >= 23 && this.K != null && this.f20427q0 != 3 && b() != 0) {
            float fA = a(this.J, f9Var, t());
            float f11 = this.O;
            if (f11 == fA) {
                return true;
            }
            if (fA == -1.0f) {
                C();
                return false;
            }
            if (f11 == -1.0f && fA <= this.f20426q) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fA);
            this.K.a(bundle);
            this.O = fA;
        }
        return true;
    }

    private static boolean e(String str) {
        int i11 = xp.f24372a;
        return i11 < 18 || (i11 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i11 == 19 && xp.f24375d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean f(String str) {
        return xp.f24372a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void z() throws a8 {
        b1.b(!this.f20439w0);
        g9 g9VarR = r();
        this.f20432t.b();
        do {
            this.f20432t.b();
            int iA = a(g9VarR, this.f20432t, 0);
            if (iA == -5) {
                a(g9VarR);
                return;
            }
            if (iA != -4) {
                if (iA != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.f20432t.e()) {
                    this.f20439w0 = true;
                    return;
                }
                if (this.f20443y0) {
                    f9 f9Var = (f9) b1.a(this.B);
                    this.C = f9Var;
                    a(f9Var, (MediaFormat) null);
                    this.f20443y0 = false;
                }
                this.f20432t.g();
            }
        } while (this.f20434u.a(this.f20432t));
        this.f20418l0 = true;
    }

    public final boolean G() throws a8 {
        boolean zH = H();
        if (zH) {
            P();
        }
        return zH;
    }

    public boolean H() {
        if (this.K == null) {
            return false;
        }
        if (this.f20427q0 == 3 || this.U || ((this.V && !this.f20433t0) || (this.W && this.f20431s0))) {
            U();
            return true;
        }
        F();
        return false;
    }

    public final hd I() {
        return this.K;
    }

    public final kd J() {
        return this.R;
    }

    public boolean K() {
        return false;
    }

    public final MediaFormat L() {
        return this.M;
    }

    public final long M() {
        return this.G0;
    }

    public float N() {
        return this.I;
    }

    public final void P() throws a8 {
        f9 f9Var;
        if (this.K != null || this.f20417k0 || (f9Var = this.B) == null) {
            return;
        }
        if (this.E == null && c(f9Var)) {
            b(this.B);
            return;
        }
        b(this.E);
        String str = this.B.f18900m;
        z6 z6Var = this.D;
        if (z6Var != null) {
            if (this.F == null) {
                l9 l9VarA = a(z6Var);
                if (l9VarA != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(l9VarA.f20367a, l9VarA.f20368b);
                        this.F = mediaCrypto;
                        this.G = !l9VarA.f20369c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e11) {
                        throw a(e11, this.B, 6006);
                    }
                } else if (this.D.getError() == null) {
                    return;
                }
            }
            if (l9.f20366d) {
                int iB = this.D.b();
                if (iB == 1) {
                    z6.a aVar = (z6.a) b1.a(this.D.getError());
                    throw a(aVar, this.B, aVar.f24814a);
                }
                if (iB != 4) {
                    return;
                }
            }
        }
        try {
            a(this.F, this.G);
        } catch (a e12) {
            throw a(e12, this.B, 4001);
        }
    }

    public void Q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U() {
        try {
            hd hdVar = this.K;
            if (hdVar != null) {
                hdVar.a();
                this.E0.f21277b++;
                g(this.R.f20199a);
            }
            this.K = null;
            try {
                MediaCrypto mediaCrypto = this.F;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.F = null;
                b((z6) null);
                X();
            }
        } catch (Throwable th2) {
            this.K = null;
            try {
                MediaCrypto mediaCrypto2 = this.F;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th2;
            } finally {
                this.F = null;
                b((z6) null);
                X();
            }
        }
    }

    public void V() {
    }

    public void W() {
        Y();
        Z();
        this.f20411e0 = C.TIME_UNSET;
        this.f20431s0 = false;
        this.f20429r0 = false;
        this.f20407a0 = false;
        this.f20408b0 = false;
        this.f20415i0 = false;
        this.f20416j0 = false;
        this.f20438w.clear();
        this.f20435u0 = C.TIME_UNSET;
        this.f20437v0 = C.TIME_UNSET;
        s2 s2Var = this.f20410d0;
        if (s2Var != null) {
            s2Var.a();
        }
        this.f20425p0 = 0;
        this.f20427q0 = 0;
        this.f20423o0 = this.f20421n0 ? 1 : 0;
    }

    public void X() {
        W();
        this.D0 = null;
        this.f20410d0 = null;
        this.P = null;
        this.R = null;
        this.L = null;
        this.M = null;
        this.N = false;
        this.f20433t0 = false;
        this.O = -1.0f;
        this.S = 0;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f20409c0 = false;
        this.f20421n0 = false;
        this.f20423o0 = 0;
        this.G = false;
    }

    public abstract float a(float f11, f9 f9Var, f9[] f9VarArr);

    @Override // com.applovin.impl.ri
    public final int a(f9 f9Var) throws a8 {
        try {
            return a(this.f20422o, f9Var);
        } catch (nd.c e11) {
            throw a(e11, f9Var, 4002);
        }
    }

    public abstract int a(md mdVar, f9 f9Var);

    public abstract hd.a a(kd kdVar, f9 f9Var, MediaCrypto mediaCrypto, float f11);

    public jd a(Throwable th2, kd kdVar) {
        return new jd(th2, kdVar);
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cf  */
    public q5 a(g9 g9Var) throws a8 {
        int i11;
        boolean z11 = true;
        this.f20443y0 = true;
        f9 f9Var = (f9) b1.a(g9Var.f19165b);
        if (f9Var.f18900m == null) {
            throw a(new IllegalArgumentException(), f9Var, 4005);
        }
        c(g9Var.f19164a);
        this.B = f9Var;
        if (this.f20417k0) {
            this.f20419m0 = true;
            return null;
        }
        hd hdVar = this.K;
        if (hdVar == null) {
            this.P = null;
            P();
            return null;
        }
        kd kdVar = this.R;
        f9 f9Var2 = this.L;
        if (a(kdVar, f9Var, this.D, this.E)) {
            C();
            return new q5(kdVar.f20199a, f9Var2, f9Var, 0, 128);
        }
        boolean z12 = this.E != this.D;
        b1.b(!z12 || xp.f24372a >= 23);
        q5 q5VarA = a(kdVar, f9Var2, f9Var);
        int i12 = q5VarA.f21903d;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        throw new IllegalStateException();
                    }
                    if (e(f9Var)) {
                        this.L = f9Var;
                        if (z12 && !D()) {
                            i11 = 2;
                        }
                    } else {
                        i11 = 16;
                    }
                } else if (e(f9Var)) {
                    this.f20421n0 = true;
                    this.f20423o0 = 1;
                    int i13 = this.S;
                    if (i13 != 2 && (i13 != 1 || f9Var.f18905r != f9Var2.f18905r || f9Var.f18906s != f9Var2.f18906s)) {
                        z11 = false;
                    }
                    this.f20407a0 = z11;
                    this.L = f9Var;
                    if (z12 && !D()) {
                        i11 = 2;
                    }
                } else {
                    i11 = 16;
                }
            } else if (e(f9Var)) {
                this.L = f9Var;
                if (!z12 ? !B() : !D()) {
                    i11 = 2;
                }
            } else {
                i11 = 16;
            }
            return (q5VarA.f21903d != 0 || (this.K == hdVar && this.f20427q0 != 3)) ? q5VarA : new q5(kdVar.f20199a, f9Var2, f9Var, 0, i11);
        }
        C();
        i11 = 0;
        if (q5VarA.f21903d != 0) {
        }
    }

    public abstract q5 a(kd kdVar, f9 f9Var, f9 f9Var2);

    public abstract List a(md mdVar, f9 f9Var, boolean z11);

    @Override // com.applovin.impl.e2, com.applovin.impl.qi
    public void a(float f11, float f12) throws a8 {
        this.I = f11;
        this.J = f12;
        e(this.L);
    }

    @Override // com.applovin.impl.qi
    public void a(long j11, long j12) throws a8 {
        boolean z11 = false;
        if (this.f20445z0) {
            this.f20445z0 = false;
            R();
        }
        a8 a8Var = this.D0;
        if (a8Var != null) {
            this.D0 = null;
            throw a8Var;
        }
        try {
            if (this.f20441x0) {
                V();
                return;
            }
            if (this.B != null || e(2)) {
                P();
                if (this.f20417k0) {
                    ko.a("bypassRender");
                    while (b(j11, j12)) {
                    }
                    ko.a();
                } else if (this.K != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    ko.a("drainAndFeed");
                    while (c(j11, j12) && e(jElapsedRealtime)) {
                    }
                    while (E() && e(jElapsedRealtime)) {
                    }
                    ko.a();
                } else {
                    this.E0.f21279d += b(j11);
                    e(1);
                }
                this.E0.a();
            }
        } catch (IllegalStateException e11) {
            if (!a(e11)) {
                throw e11;
            }
            a((Exception) e11);
            if (xp.f24372a >= 21 && c(e11)) {
                z11 = true;
            }
            if (z11) {
                U();
            }
            throw a(a(e11, J()), this.B, z11, 4003);
        }
    }

    @Override // com.applovin.impl.e2
    public void a(long j11, boolean z11) throws a8 {
        this.f20439w0 = false;
        this.f20441x0 = false;
        this.f20445z0 = false;
        if (this.f20417k0) {
            this.f20434u.b();
            this.f20432t.b();
            this.f20418l0 = false;
        } else {
            G();
        }
        if (this.f20436v.e() > 0) {
            this.f20443y0 = true;
        }
        this.f20436v.a();
        int i11 = this.H0;
        if (i11 != 0) {
            int i12 = i11 - 1;
            this.G0 = this.f20444z[i12];
            this.F0 = this.f20442y[i12];
            this.H0 = 0;
        }
    }

    public final void a(a8 a8Var) {
        this.D0 = a8Var;
    }

    public abstract void a(f9 f9Var, MediaFormat mediaFormat);

    public void a(p5 p5Var) {
    }

    public abstract void a(Exception exc);

    public abstract void a(String str, long j11, long j12);

    public void a(boolean z11) {
        this.A0 = z11;
    }

    @Override // com.applovin.impl.e2
    public void a(boolean z11, boolean z12) {
        this.E0 = new n5();
    }

    @Override // com.applovin.impl.e2
    public void a(f9[] f9VarArr, long j11, long j12) {
        if (this.G0 == C.TIME_UNSET) {
            b1.b(this.F0 == C.TIME_UNSET);
            this.F0 = j11;
            this.G0 = j12;
            return;
        }
        int i11 = this.H0;
        if (i11 == this.f20444z.length) {
            pc.d("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.f20444z[this.H0 - 1]);
        } else {
            this.H0 = i11 + 1;
        }
        long[] jArr = this.f20442y;
        int i12 = this.H0 - 1;
        jArr[i12] = j11;
        this.f20444z[i12] = j12;
        this.A[i12] = this.f20435u0;
    }

    public abstract boolean a(long j11, long j12, hd hdVar, ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, f9 f9Var);

    public final void a0() {
        this.f20445z0 = true;
    }

    public abstract void b(p5 p5Var);

    public void b(boolean z11) {
        this.B0 = z11;
    }

    public boolean b(kd kdVar) {
        return true;
    }

    public void c(boolean z11) {
        this.C0 = z11;
    }

    @Override // com.applovin.impl.qi
    public boolean c() {
        return this.f20441x0;
    }

    public boolean c(f9 f9Var) {
        return false;
    }

    public void d(long j11) {
        while (true) {
            int i11 = this.H0;
            if (i11 == 0 || j11 < this.A[0]) {
                return;
            }
            long[] jArr = this.f20442y;
            this.F0 = jArr[0];
            this.G0 = this.f20444z[0];
            int i12 = i11 - 1;
            this.H0 = i12;
            System.arraycopy(jArr, 1, jArr, 0, i12);
            long[] jArr2 = this.f20444z;
            System.arraycopy(jArr2, 1, jArr2, 0, this.H0);
            long[] jArr3 = this.A;
            System.arraycopy(jArr3, 1, jArr3, 0, this.H0);
            Q();
        }
    }

    @Override // com.applovin.impl.qi
    public boolean d() {
        return this.B != null && (u() || O() || (this.f20411e0 != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.f20411e0));
    }

    public final void f(long j11) {
        f9 f9Var = (f9) this.f20436v.c(j11);
        if (f9Var == null && this.N) {
            f9Var = (f9) this.f20436v.c();
        }
        if (f9Var != null) {
            this.C = f9Var;
        } else if (!this.N || this.C == null) {
            return;
        }
        a(this.C, this.M);
        this.N = false;
    }

    public abstract void g(String str);

    @Override // com.applovin.impl.e2, com.applovin.impl.ri
    public final int m() {
        return 8;
    }

    @Override // com.applovin.impl.e2
    public void v() {
        this.B = null;
        this.F0 = C.TIME_UNSET;
        this.G0 = C.TIME_UNSET;
        this.H0 = 0;
        H();
    }

    @Override // com.applovin.impl.e2
    public void w() {
        try {
            A();
            U();
        } finally {
            c((z6) null);
        }
    }

    @Override // com.applovin.impl.e2
    public void x() {
    }

    @Override // com.applovin.impl.e2
    public void y() {
    }
}
