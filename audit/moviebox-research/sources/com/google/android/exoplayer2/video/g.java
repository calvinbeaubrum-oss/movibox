package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.x2;
import com.google.android.gms.common.Scopes;
import com.google.common.collect.ImmutableList;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g extends MediaCodecRenderer {

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final int[] f35745q1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static boolean f35746r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static boolean f35747s1;
    public final Context H0;
    public final k I0;
    public final w.a J0;
    public final long K0;
    public final int L0;
    public final boolean M0;
    public a N0;
    public boolean O0;
    public boolean P0;

    @Nullable
    public Surface Q0;

    @Nullable
    public PlaceholderSurface R0;
    public boolean S0;
    public int T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;
    public long X0;
    public long Y0;
    public long Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public int f35748a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f35749b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f35750c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public long f35751d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public long f35752e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public long f35753f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f35754g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f35755h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public int f35756i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public int f35757j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f35758k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    @Nullable
    public y f35759l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f35760m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public int f35761n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    @Nullable
    public b f35762o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    @Nullable
    public i f35763p1;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35766c;

        public a(int i11, int i12, int i13) {
            this.f35764a = i11;
            this.f35765b = i12;
            this.f35766c = i13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public final class b implements com.google.android.exoplayer2.mediacodec.c.InterfaceC0362c, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f35767a;

        public b(com.google.android.exoplayer2.mediacodec.c cVar) {
            Handler handlerX = o0.x(this);
            this.f35767a = handlerX;
            cVar.m(this, handlerX);
        }

        @Override // com.google.android.exoplayer2.mediacodec.c.InterfaceC0362c
        public void a(com.google.android.exoplayer2.mediacodec.c cVar, long j11, long j12) {
            if (o0.f35608a >= 30) {
                b(j11);
            } else {
                this.f35767a.sendMessageAtFrontOfQueue(Message.obtain(this.f35767a, 0, (int) (j11 >> 32), (int) j11));
            }
        }

        public final void b(long j11) {
            g gVar = g.this;
            if (this != gVar.f35762o1) {
                return;
            }
            if (j11 == Long.MAX_VALUE) {
                gVar.x1();
                return;
            }
            try {
                gVar.w1(j11);
            } catch (ExoPlaybackException e11) {
                g.this.M0(e11);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(o0.b1(message.arg1, message.arg2));
            return true;
        }
    }

    public g(Context context, com.google.android.exoplayer2.mediacodec.c.b bVar, com.google.android.exoplayer2.mediacodec.e eVar, long j11, boolean z11, @Nullable Handler handler, @Nullable w wVar, int i11) {
        this(context, bVar, eVar, j11, z11, handler, wVar, i11, 30.0f);
    }

    public g(Context context, com.google.android.exoplayer2.mediacodec.c.b bVar, com.google.android.exoplayer2.mediacodec.e eVar, long j11, boolean z11, @Nullable Handler handler, @Nullable w wVar, int i11, float f11) {
        super(2, bVar, eVar, z11, f11);
        this.K0 = j11;
        this.L0 = i11;
        Context applicationContext = context.getApplicationContext();
        this.H0 = applicationContext;
        this.I0 = new k(applicationContext);
        this.J0 = new w.a(handler, wVar);
        this.M0 = d1();
        this.Y0 = C.TIME_UNSET;
        this.f35755h1 = -1;
        this.f35756i1 = -1;
        this.f35758k1 = -1.0f;
        this.T0 = 1;
        this.f35761n1 = 0;
        a1();
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static void B1(com.google.android.exoplayer2.mediacodec.c cVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        cVar.b(bundle);
    }

    @RequiresApi(21)
    public static void c1(MediaFormat mediaFormat, int i11) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i11);
    }

    public static boolean d1() {
        return "NVIDIA".equals(o0.f35610c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:51:0x0099  */
    /* JADX WARN: Code duplicated, block: B:614:0x0836  */
    /* JADX WARN: Code duplicated, block: B:6:0x001b  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static boolean f1() {
        /*
            Method dump skipped, instruction units count: 3064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.g.f1():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    public static int g1(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var) {
        int iL;
        int iIntValue;
        int i11 = m1Var.f33450r;
        int i12 = m1Var.f33451s;
        if (i11 == -1 || i12 == -1) {
            return -1;
        }
        String str = m1Var.f33445m;
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> pairQ = MediaCodecUtil.q(m1Var);
            str = (pairQ == null || !((iIntValue = ((Integer) pairQ.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? MimeTypes.VIDEO_H265 : MimeTypes.VIDEO_H264;
        }
        str.hashCode();
        int i13 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/av01":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iL = i11 * i12;
                i13 = 2;
                return (iL * 3) / (i13 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iL = i11 * i12;
                return (iL * 3) / (i13 * 2);
            case "video/avc":
                String str2 = o0.f35611d;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(o0.f35610c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && dVar.f33559g)))) {
                    return -1;
                }
                iL = o0.l(i11, 16) * o0.l(i12, 16) * 256;
                i13 = 2;
                return (iL * 3) / (i13 * 2);
            default:
                return -1;
        }
    }

    @Nullable
    public static Point h1(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var) {
        int i11 = m1Var.f33451s;
        int i12 = m1Var.f33450r;
        boolean z11 = i11 > i12;
        int i13 = z11 ? i11 : i12;
        if (z11) {
            i11 = i12;
        }
        float f11 = i11 / i13;
        for (int i14 : f35745q1) {
            int i15 = (int) (i14 * f11);
            if (i14 <= i13 || i15 <= i11) {
                break;
            }
            if (o0.f35608a >= 21) {
                int i16 = z11 ? i15 : i14;
                if (!z11) {
                    i14 = i15;
                }
                Point pointB = dVar.b(i16, i14);
                if (dVar.u(pointB.x, pointB.y, m1Var.f33452t)) {
                    return pointB;
                }
            } else {
                try {
                    int iL = o0.l(i14, 16) * 16;
                    int iL2 = o0.l(i15, 16) * 16;
                    if (iL * iL2 <= MediaCodecUtil.N()) {
                        int i17 = z11 ? iL2 : iL;
                        if (!z11) {
                            iL = iL2;
                        }
                        return new Point(i17, iL);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    public static List<com.google.android.exoplayer2.mediacodec.d> j1(com.google.android.exoplayer2.mediacodec.e eVar, m1 m1Var, boolean z11, boolean z12) throws MediaCodecUtil.DecoderQueryException {
        String str = m1Var.f33445m;
        if (str == null) {
            return ImmutableList.of();
        }
        List<com.google.android.exoplayer2.mediacodec.d> listA = eVar.a(str, z11, z12);
        String strM = MediaCodecUtil.m(m1Var);
        if (strM == null) {
            return ImmutableList.copyOf((Collection) listA);
        }
        return ImmutableList.builder().k(listA).k(eVar.a(strM, z11, z12)).m();
    }

    public static int k1(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var) {
        if (m1Var.f33446n == -1) {
            return g1(dVar, m1Var);
        }
        int size = m1Var.f33447o.size();
        int length = 0;
        for (int i11 = 0; i11 < size; i11++) {
            length += m1Var.f33447o.get(i11).length;
        }
        return m1Var.f33446n + length;
    }

    public static boolean m1(long j11) {
        return j11 < -30000;
    }

    public static boolean n1(long j11) {
        return j11 < -500000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean A0(long j11, long j12, @Nullable com.google.android.exoplayer2.mediacodec.c cVar, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, m1 m1Var) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.e(cVar);
        if (this.X0 == C.TIME_UNSET) {
            this.X0 = j11;
        }
        if (j13 != this.f35751d1) {
            this.I0.h(j13);
            this.f35751d1 = j13;
        }
        long jF0 = f0();
        long j14 = j13 - jF0;
        if (z11 && !z12) {
            J1(cVar, i11, j14);
            return true;
        }
        double dG0 = g0();
        boolean z13 = getState() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j15 = (long) ((j13 - j11) / dG0);
        if (z13) {
            j15 -= jElapsedRealtime - j12;
        }
        if (this.Q0 == this.R0) {
            if (!m1(j15)) {
                return false;
            }
            J1(cVar, i11, j14);
            L1(j15);
            return true;
        }
        long j16 = jElapsedRealtime - this.f35752e1;
        boolean z14 = this.W0 ? !this.U0 : z13 || this.V0;
        if (this.Y0 == C.TIME_UNSET && j11 >= jF0 && (z14 || (z13 && H1(j15, j16)))) {
            long jNanoTime = System.nanoTime();
            v1(j14, jNanoTime, m1Var);
            if (o0.f35608a >= 21) {
                A1(cVar, i11, j14, jNanoTime);
            } else {
                z1(cVar, i11, j14);
            }
            L1(j15);
            return true;
        }
        if (z13 && j11 != this.X0) {
            long jNanoTime2 = System.nanoTime();
            long jB = this.I0.b((j15 * 1000) + jNanoTime2);
            long j17 = (jB - jNanoTime2) / 1000;
            boolean z15 = this.Y0 != C.TIME_UNSET;
            if (F1(j17, j12, z12) && o1(j11, z15)) {
                return false;
            }
            if (G1(j17, j12, z12)) {
                if (z15) {
                    J1(cVar, i11, j14);
                } else {
                    e1(cVar, i11, j14);
                }
                L1(j17);
                return true;
            }
            if (o0.f35608a >= 21) {
                if (j17 < 50000) {
                    v1(j14, jB, m1Var);
                    A1(cVar, i11, j14, jB);
                    L1(j17);
                    return true;
                }
            } else if (j17 < 30000) {
                if (j17 > 11000) {
                    try {
                        Thread.sleep((j17 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                v1(j14, jB, m1Var);
                z1(cVar, i11, j14);
                L1(j17);
                return true;
            }
        }
        return false;
    }

    @RequiresApi(21)
    public void A1(com.google.android.exoplayer2.mediacodec.c cVar, int i11, long j11, long j12) {
        s1();
        l0.a("releaseOutputBuffer");
        cVar.h(i11, j12);
        l0.c();
        this.f35752e1 = SystemClock.elapsedRealtime() * 1000;
        this.C0.f33066e++;
        this.f35749b1 = 0;
        q1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public com.google.android.exoplayer2.decoder.g B(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var, m1 m1Var2) {
        com.google.android.exoplayer2.decoder.g gVarE = dVar.e(m1Var, m1Var2);
        int i11 = gVarE.f33080e;
        int i12 = m1Var2.f33450r;
        a aVar = this.N0;
        if (i12 > aVar.f35764a || m1Var2.f33451s > aVar.f35765b) {
            i11 |= 256;
        }
        if (k1(dVar, m1Var2) > this.N0.f35766c) {
            i11 |= 64;
        }
        int i13 = i11;
        return new com.google.android.exoplayer2.decoder.g(dVar.f33553a, m1Var, m1Var2, i13 != 0 ? 0 : gVarE.f33079d, i13);
    }

    public final void C1() {
        this.Y0 = this.K0 > 0 ? SystemClock.elapsedRealtime() + this.K0 : C.TIME_UNSET;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.exoplayer2.video.k] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.exoplayer2.e, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.video.g] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.android.exoplayer2.video.PlaceholderSurface] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void D1(@Nullable Object obj) throws ExoPlaybackException {
        ?? NewInstanceV17;
        Surface surface;
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            NewInstanceV17 = 0;
        }
        if (NewInstanceV17 == 0) {
            PlaceholderSurface placeholderSurface = this.R0;
            if (placeholderSurface != null) {
                NewInstanceV17 = surface;
                NewInstanceV17 = placeholderSurface;
            } else {
                com.google.android.exoplayer2.mediacodec.d dVarY = Y();
                if (dVarY != null && I1(dVarY)) {
                    NewInstanceV17 = surface;
                    NewInstanceV17 = PlaceholderSurface.newInstanceV17(this.H0, dVarY.f33559g);
                    this.R0 = NewInstanceV17;
                }
            }
        }
        NewInstanceV17 = surface;
        NewInstanceV17 = surface;
        NewInstanceV17 = surface;
        if (this.Q0 == NewInstanceV17) {
            if (NewInstanceV17 == 0 || NewInstanceV17 == this.R0) {
                return;
            }
            u1();
            t1();
            return;
        }
        this.Q0 = NewInstanceV17;
        this.I0.m(NewInstanceV17);
        this.S0 = false;
        int state = getState();
        com.google.android.exoplayer2.mediacodec.c cVarX = X();
        if (cVarX != null) {
            if (o0.f35608a < 23 || NewInstanceV17 == 0 || this.O0) {
                E0();
                p0();
            } else {
                E1(cVarX, NewInstanceV17);
            }
        }
        if (NewInstanceV17 == 0 || NewInstanceV17 == this.R0) {
            a1();
            Z0();
            return;
        }
        u1();
        Z0();
        if (state == 2) {
            C1();
        }
    }

    @RequiresApi(23)
    public void E1(com.google.android.exoplayer2.mediacodec.c cVar, Surface surface) {
        cVar.e(surface);
    }

    public boolean F1(long j11, long j12, boolean z11) {
        return n1(j11) && !z11;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void G0() {
        super.G0();
        this.f35750c1 = 0;
    }

    public boolean G1(long j11, long j12, boolean z11) {
        return m1(j11) && !z11;
    }

    public boolean H1(long j11, long j12) {
        return m1(j11) && j12 > 100000;
    }

    public final boolean I1(com.google.android.exoplayer2.mediacodec.d dVar) {
        return o0.f35608a >= 23 && !this.f35760m1 && !b1(dVar.f33553a) && (!dVar.f33559g || PlaceholderSurface.isSecureSupported(this.H0));
    }

    public void J1(com.google.android.exoplayer2.mediacodec.c cVar, int i11, long j11) {
        l0.a("skipVideoBuffer");
        cVar.k(i11, false);
        l0.c();
        this.C0.f33067f++;
    }

    public void K1(int i11, int i12) {
        com.google.android.exoplayer2.decoder.e eVar = this.C0;
        eVar.f33069h += i11;
        int i13 = i11 + i12;
        eVar.f33068g += i13;
        this.f35748a1 += i13;
        int i14 = this.f35749b1 + i13;
        this.f35749b1 = i14;
        eVar.f33070i = Math.max(i14, eVar.f33070i);
        int i15 = this.L0;
        if (i15 <= 0 || this.f35748a1 < i15) {
            return;
        }
        p1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException L(Throwable th2, @Nullable com.google.android.exoplayer2.mediacodec.d dVar) {
        return new MediaCodecVideoDecoderException(th2, dVar, this.Q0);
    }

    public void L1(long j11) {
        this.C0.a(j11);
        this.f35753f1 += j11;
        this.f35754g1++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean P0(com.google.android.exoplayer2.mediacodec.d dVar) {
        return this.Q0 != null || I1(dVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int S0(com.google.android.exoplayer2.mediacodec.e eVar, m1 m1Var) throws MediaCodecUtil.DecoderQueryException {
        boolean z11;
        int i11 = 0;
        if (!com.google.android.exoplayer2.util.w.s(m1Var.f33445m)) {
            return x2.a(0);
        }
        boolean z12 = m1Var.f33448p != null;
        List<com.google.android.exoplayer2.mediacodec.d> listJ1 = j1(eVar, m1Var, z12, false);
        if (z12 && listJ1.isEmpty()) {
            listJ1 = j1(eVar, m1Var, false, false);
        }
        if (listJ1.isEmpty()) {
            return x2.a(1);
        }
        if (!MediaCodecRenderer.T0(m1Var)) {
            return x2.a(2);
        }
        com.google.android.exoplayer2.mediacodec.d dVar = listJ1.get(0);
        boolean zM = dVar.m(m1Var);
        if (!zM) {
            int i12 = 1;
            while (true) {
                if (i12 >= listJ1.size()) {
                    z11 = true;
                    break;
                }
                com.google.android.exoplayer2.mediacodec.d dVar2 = listJ1.get(i12);
                if (dVar2.m(m1Var)) {
                    dVar = dVar2;
                    z11 = false;
                    zM = true;
                    break;
                }
                i12++;
            }
        } else {
            z11 = true;
            break;
        }
        int i13 = zM ? 4 : 3;
        int i14 = dVar.p(m1Var) ? 16 : 8;
        int i15 = dVar.f33560h ? 64 : 0;
        int i16 = z11 ? 128 : 0;
        if (zM) {
            List<com.google.android.exoplayer2.mediacodec.d> listJ2 = j1(eVar, m1Var, z12, true);
            if (!listJ2.isEmpty()) {
                com.google.android.exoplayer2.mediacodec.d dVar3 = MediaCodecUtil.u(listJ2, m1Var).get(0);
                if (dVar3.m(m1Var) && dVar3.p(m1Var)) {
                    i11 = 32;
                }
            }
        }
        return x2.c(i13, i14, i11, i15, i16);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean Z() {
        return this.f35760m1 && o0.f35608a < 23;
    }

    public final void Z0() {
        com.google.android.exoplayer2.mediacodec.c cVarX;
        this.U0 = false;
        if (o0.f35608a < 23 || !this.f35760m1 || (cVarX = X()) == null) {
            return;
        }
        this.f35762o1 = new b(cVarX);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float a0(float f11, m1 m1Var, m1[] m1VarArr) {
        float fMax = -1.0f;
        for (m1 m1Var2 : m1VarArr) {
            float f12 = m1Var2.f33452t;
            if (f12 != -1.0f) {
                fMax = Math.max(fMax, f12);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f11;
    }

    public final void a1() {
        this.f35759l1 = null;
    }

    public boolean b1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (g.class) {
            try {
                if (!f35746r1) {
                    f35747s1 = f1();
                    f35746r1 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f35747s1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e, com.google.android.exoplayer2.w2
    public void c(float f11, float f12) throws ExoPlaybackException {
        super.c(f11, f12);
        this.I0.i(f11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.d> c0(com.google.android.exoplayer2.mediacodec.e eVar, m1 m1Var, boolean z11) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.u(j1(eVar, m1Var, z11, this.f35760m1), m1Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    public com.google.android.exoplayer2.mediacodec.c.a e0(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var, @Nullable MediaCrypto mediaCrypto, float f11) {
        PlaceholderSurface placeholderSurface = this.R0;
        if (placeholderSurface != null && placeholderSurface.secure != dVar.f33559g) {
            y1();
        }
        String str = dVar.f33555c;
        a aVarI1 = i1(dVar, m1Var, n());
        this.N0 = aVarI1;
        MediaFormat mediaFormatL1 = l1(m1Var, str, aVarI1, f11, this.M0, this.f35760m1 ? this.f35761n1 : 0);
        if (this.Q0 == null) {
            if (!I1(dVar)) {
                throw new IllegalStateException();
            }
            if (this.R0 == null) {
                this.R0 = PlaceholderSurface.newInstanceV17(this.H0, dVar.f33559g);
            }
            this.Q0 = this.R0;
        }
        return com.google.android.exoplayer2.mediacodec.c.a.b(dVar, mediaFormatL1, m1Var, this.Q0, mediaCrypto);
    }

    public void e1(com.google.android.exoplayer2.mediacodec.c cVar, int i11, long j11) {
        l0.a("dropVideoBuffer");
        cVar.k(i11, false);
        l0.c();
        K1(0, 1);
    }

    @Override // com.google.android.exoplayer2.w2, com.google.android.exoplayer2.y2
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public void h0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.P0) {
            ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(decoderInputBuffer.f33033g);
            if (byteBuffer.remaining() >= 7) {
                byte b11 = byteBuffer.get();
                short s11 = byteBuffer.getShort();
                short s12 = byteBuffer.getShort();
                byte b12 = byteBuffer.get();
                byte b13 = byteBuffer.get();
                byteBuffer.position(0);
                if (b11 == -75 && s11 == 60 && s12 == 1 && b12 == 4 && b13 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    B1(X(), bArr);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.r2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 1) {
            D1(obj);
            return;
        }
        if (i11 == 7) {
            this.f35763p1 = (i) obj;
            return;
        }
        if (i11 == 10) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.f35761n1 != iIntValue) {
                this.f35761n1 = iIntValue;
                if (this.f35760m1) {
                    E0();
                    return;
                }
                return;
            }
            return;
        }
        if (i11 != 4) {
            if (i11 != 5) {
                super.handleMessage(i11, obj);
                return;
            } else {
                this.I0.o(((Integer) obj).intValue());
                return;
            }
        }
        this.T0 = ((Integer) obj).intValue();
        com.google.android.exoplayer2.mediacodec.c cVarX = X();
        if (cVarX != null) {
            cVarX.setVideoScalingMode(this.T0);
        }
    }

    public a i1(com.google.android.exoplayer2.mediacodec.d dVar, m1 m1Var, m1[] m1VarArr) {
        int iG1;
        int iMax = m1Var.f33450r;
        int iMax2 = m1Var.f33451s;
        int iK1 = k1(dVar, m1Var);
        if (m1VarArr.length == 1) {
            if (iK1 != -1 && (iG1 = g1(dVar, m1Var)) != -1) {
                iK1 = Math.min((int) (iK1 * 1.5f), iG1);
            }
            return new a(iMax, iMax2, iK1);
        }
        int length = m1VarArr.length;
        boolean z11 = false;
        for (int i11 = 0; i11 < length; i11++) {
            m1 m1VarE = m1VarArr[i11];
            if (m1Var.f33457y != null && m1VarE.f33457y == null) {
                m1VarE = m1VarE.b().J(m1Var.f33457y).E();
            }
            if (dVar.e(m1Var, m1VarE).f33079d != 0) {
                int i12 = m1VarE.f33450r;
                z11 |= i12 == -1 || m1VarE.f33451s == -1;
                iMax = Math.max(iMax, i12);
                iMax2 = Math.max(iMax2, m1VarE.f33451s);
                iK1 = Math.max(iK1, k1(dVar, m1VarE));
            }
        }
        if (z11) {
            com.google.android.exoplayer2.util.s.i("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointH1 = h1(dVar, m1Var);
            if (pointH1 != null) {
                iMax = Math.max(iMax, pointH1.x);
                iMax2 = Math.max(iMax2, pointH1.y);
                iK1 = Math.max(iK1, g1(dVar, m1Var.b().j0(iMax).Q(iMax2).E()));
                com.google.android.exoplayer2.util.s.i("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new a(iMax, iMax2, iK1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.w2
    public boolean isReady() {
        PlaceholderSurface placeholderSurface;
        if (super.isReady() && (this.U0 || (((placeholderSurface = this.R0) != null && this.Q0 == placeholderSurface) || X() == null || this.f35760m1))) {
            this.Y0 = C.TIME_UNSET;
            return true;
        }
        if (this.Y0 == C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.Y0) {
            return true;
        }
        this.Y0 = C.TIME_UNSET;
        return false;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat l1(m1 m1Var, String str, a aVar, float f11, boolean z11, int i11) {
        Pair<Integer, Integer> pairQ;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", m1Var.f33450r);
        mediaFormat.setInteger("height", m1Var.f33451s);
        com.google.android.exoplayer2.util.v.e(mediaFormat, m1Var.f33447o);
        com.google.android.exoplayer2.util.v.c(mediaFormat, "frame-rate", m1Var.f33452t);
        com.google.android.exoplayer2.util.v.d(mediaFormat, "rotation-degrees", m1Var.f33453u);
        com.google.android.exoplayer2.util.v.b(mediaFormat, m1Var.f33457y);
        if ("video/dolby-vision".equals(m1Var.f33445m) && (pairQ = MediaCodecUtil.q(m1Var)) != null) {
            com.google.android.exoplayer2.util.v.d(mediaFormat, Scopes.PROFILE, ((Integer) pairQ.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f35764a);
        mediaFormat.setInteger("max-height", aVar.f35765b);
        com.google.android.exoplayer2.util.v.d(mediaFormat, "max-input-size", aVar.f35766c);
        if (o0.f35608a >= 23) {
            mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
            if (f11 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (z11) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i11 != 0) {
            c1(mediaFormat, i11);
        }
        return mediaFormat;
    }

    public boolean o1(long j11, boolean z11) throws ExoPlaybackException {
        int iY = y(j11);
        if (iY == 0) {
            return false;
        }
        if (z11) {
            com.google.android.exoplayer2.decoder.e eVar = this.C0;
            eVar.f33065d += iY;
            eVar.f33067f += this.f35750c1;
        } else {
            this.C0.f33071j++;
            K1(iY, this.f35750c1);
        }
        U();
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void p() {
        a1();
        Z0();
        this.S0 = false;
        this.f35762o1 = null;
        try {
            super.p();
        } finally {
            this.J0.m(this.C0);
        }
    }

    public final void p1() {
        if (this.f35748a1 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.J0.n(this.f35748a1, jElapsedRealtime - this.Z0);
            this.f35748a1 = 0;
            this.Z0 = jElapsedRealtime;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void q(boolean z11, boolean z12) throws ExoPlaybackException {
        super.q(z11, z12);
        boolean z13 = j().f35982a;
        com.google.android.exoplayer2.util.a.g((z13 && this.f35761n1 == 0) ? false : true);
        if (this.f35760m1 != z13) {
            this.f35760m1 = z13;
            E0();
        }
        this.J0.o(this.C0);
        this.V0 = z12;
        this.W0 = false;
    }

    public void q1() {
        this.W0 = true;
        if (this.U0) {
            return;
        }
        this.U0 = true;
        this.J0.A(this.Q0);
        this.S0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void r(long j11, boolean z11) throws ExoPlaybackException {
        super.r(j11, z11);
        Z0();
        this.I0.j();
        this.f35751d1 = C.TIME_UNSET;
        this.X0 = C.TIME_UNSET;
        this.f35749b1 = 0;
        if (z11) {
            C1();
        } else {
            this.Y0 = C.TIME_UNSET;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void r0(Exception exc) {
        com.google.android.exoplayer2.util.s.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.J0.C(exc);
    }

    public final void r1() {
        int i11 = this.f35754g1;
        if (i11 != 0) {
            this.J0.B(this.f35753f1, i11);
            this.f35753f1 = 0L;
            this.f35754g1 = 0;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    @TargetApi(17)
    public void s() {
        try {
            super.s();
        } finally {
            if (this.R0 != null) {
                y1();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void s0(String str, com.google.android.exoplayer2.mediacodec.c.a aVar, long j11, long j12) {
        this.J0.k(str, j11, j12);
        this.O0 = b1(str);
        this.P0 = ((com.google.android.exoplayer2.mediacodec.d) com.google.android.exoplayer2.util.a.e(Y())).n();
        if (o0.f35608a < 23 || !this.f35760m1) {
            return;
        }
        this.f35762o1 = new b((com.google.android.exoplayer2.mediacodec.c) com.google.android.exoplayer2.util.a.e(X()));
    }

    public final void s1() {
        int i11 = this.f35755h1;
        if (i11 == -1 && this.f35756i1 == -1) {
            return;
        }
        y yVar = this.f35759l1;
        if (yVar != null && yVar.f35863a == i11 && yVar.f35864b == this.f35756i1 && yVar.f35865c == this.f35757j1 && yVar.f35866d == this.f35758k1) {
            return;
        }
        y yVar2 = new y(this.f35755h1, this.f35756i1, this.f35757j1, this.f35758k1);
        this.f35759l1 = yVar2;
        this.J0.D(yVar2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void t() {
        super.t();
        this.f35748a1 = 0;
        this.Z0 = SystemClock.elapsedRealtime();
        this.f35752e1 = SystemClock.elapsedRealtime() * 1000;
        this.f35753f1 = 0L;
        this.f35754g1 = 0;
        this.I0.k();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void t0(String str) {
        this.J0.l(str);
    }

    public final void t1() {
        if (this.S0) {
            this.J0.A(this.Q0);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void u() {
        this.Y0 = C.TIME_UNSET;
        p1();
        r1();
        this.I0.l();
        super.u();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public com.google.android.exoplayer2.decoder.g u0(n1 n1Var) throws ExoPlaybackException {
        com.google.android.exoplayer2.decoder.g gVarU0 = super.u0(n1Var);
        this.J0.p(n1Var.f33603b, gVarU0);
        return gVarU0;
    }

    public final void u1() {
        y yVar = this.f35759l1;
        if (yVar != null) {
            this.J0.D(yVar);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void v0(m1 m1Var, @Nullable MediaFormat mediaFormat) {
        com.google.android.exoplayer2.mediacodec.c cVarX = X();
        if (cVarX != null) {
            cVarX.setVideoScalingMode(this.T0);
        }
        if (this.f35760m1) {
            this.f35755h1 = m1Var.f33450r;
            this.f35756i1 = m1Var.f33451s;
        } else {
            com.google.android.exoplayer2.util.a.e(mediaFormat);
            boolean z11 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.f35755h1 = z11 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.f35756i1 = z11 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f11 = m1Var.f33454v;
        this.f35758k1 = f11;
        if (o0.f35608a >= 21) {
            int i11 = m1Var.f33453u;
            if (i11 == 90 || i11 == 270) {
                int i12 = this.f35755h1;
                this.f35755h1 = this.f35756i1;
                this.f35756i1 = i12;
                this.f35758k1 = 1.0f / f11;
            }
        } else {
            this.f35757j1 = m1Var.f33453u;
        }
        this.I0.g(m1Var.f33452t);
    }

    public final void v1(long j11, long j12, m1 m1Var) {
        i iVar = this.f35763p1;
        if (iVar != null) {
            iVar.e(j11, j12, m1Var, b0());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void w0(long j11) {
        super.w0(j11);
        if (this.f35760m1) {
            return;
        }
        this.f35750c1--;
    }

    public void w1(long j11) throws ExoPlaybackException {
        W0(j11);
        s1();
        this.C0.f33066e++;
        q1();
        w0(j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void x0() {
        super.x0();
        Z0();
    }

    public final void x1() {
        L0();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void y0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z11 = this.f35760m1;
        if (!z11) {
            this.f35750c1++;
        }
        if (o0.f35608a >= 23 || !z11) {
            return;
        }
        w1(decoderInputBuffer.f33032f);
    }

    @RequiresApi(17)
    public final void y1() {
        Surface surface = this.Q0;
        PlaceholderSurface placeholderSurface = this.R0;
        if (surface == placeholderSurface) {
            this.Q0 = null;
        }
        placeholderSurface.release();
        this.R0 = null;
    }

    public void z1(com.google.android.exoplayer2.mediacodec.c cVar, int i11, long j11) {
        s1();
        l0.a("releaseOutputBuffer");
        cVar.k(i11, true);
        l0.c();
        this.f35752e1 = SystemClock.elapsedRealtime() * 1000;
        this.C0.f33066e++;
        this.f35749b1 = 0;
        q1();
    }
}
