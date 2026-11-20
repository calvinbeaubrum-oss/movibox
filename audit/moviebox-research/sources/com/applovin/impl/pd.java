package com.applovin.impl;

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
import com.google.android.gms.common.Scopes;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pd extends ld {

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private static final int[] f21710s1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private static boolean f21711t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private static boolean f21712u1;
    private final Context J0;
    private final vq K0;
    private final wq.a L0;
    private final long M0;
    private final int N0;
    private final boolean O0;
    private a P0;
    private boolean Q0;
    private boolean R0;
    private Surface S0;
    private h7 T0;
    private boolean U0;
    private int V0;
    private boolean W0;
    private boolean X0;
    private boolean Y0;
    private long Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private long f21713a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private long f21714b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private int f21715c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private int f21716d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private int f21717e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private long f21718f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private long f21719g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private long f21720h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private int f21721i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private int f21722j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private int f21723k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private int f21724l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private float f21725m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private xq f21726n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private boolean f21727o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private int f21728p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    b f21729q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private uq f21730r1;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21733c;

        public a(int i11, int i12, int i13) {
            this.f21731a = i11;
            this.f21732b = i12;
            this.f21733c = i13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b implements hd.c, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f21734a;

        public b(hd hdVar) {
            Handler handlerA = xp.a((Handler.Callback) this);
            this.f21734a = handlerA;
            hdVar.a(this, handlerA);
        }

        private void a(long j11) {
            pd pdVar = pd.this;
            if (this != pdVar.f21729q1) {
                return;
            }
            if (j11 == Long.MAX_VALUE) {
                pdVar.m0();
                return;
            }
            try {
                pdVar.i(j11);
            } catch (a8 e11) {
                pd.this.a(e11);
            }
        }

        @Override // com.applovin.impl.hd.c
        public void a(hd hdVar, long j11, long j12) {
            if (xp.f24372a >= 30) {
                a(j11);
            } else {
                this.f21734a.sendMessageAtFrontOfQueue(Message.obtain(this.f21734a, 0, (int) (j11 >> 32), (int) j11));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a(xp.c(message.arg1, message.arg2));
            return true;
        }
    }

    public pd(Context context, hd.b bVar, md mdVar, long j11, boolean z11, Handler handler, wq wqVar, int i11) {
        super(2, bVar, mdVar, z11, 30.0f);
        this.M0 = j11;
        this.N0 = i11;
        Context applicationContext = context.getApplicationContext();
        this.J0 = applicationContext;
        this.K0 = new vq(applicationContext);
        this.L0 = new wq.a(handler, wqVar);
        this.O0 = e0();
        this.f21713a1 = C.TIME_UNSET;
        this.f21722j1 = -1;
        this.f21723k1 = -1;
        this.f21725m1 = -1.0f;
        this.V0 = 1;
        this.f21728p1 = 0;
        d0();
    }

    public pd(Context context, md mdVar, long j11, boolean z11, Handler handler, wq wqVar, int i11) {
        this(context, hd.b.f19478a, mdVar, j11, z11, handler, wqVar, i11);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    private static int a(kd kdVar, f9 f9Var) {
        int iA;
        int iIntValue;
        int i11 = f9Var.f18905r;
        int i12 = f9Var.f18906s;
        if (i11 == -1 || i12 == -1) {
            return -1;
        }
        String str = f9Var.f18900m;
        if ("video/dolby-vision".equals(str)) {
            Pair pairA = nd.a(f9Var);
            str = (pairA == null || !((iIntValue = ((Integer) pairA.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? MimeTypes.VIDEO_H265 : MimeTypes.VIDEO_H264;
        }
        str.hashCode();
        int i13 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iA = i11 * i12;
                i13 = 2;
                return (iA * 3) / (i13 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iA = i11 * i12;
                return (iA * 3) / (i13 * 2);
            case "video/avc":
                String str2 = xp.f24375d;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(xp.f24374c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && kdVar.f20205g)))) {
                    return -1;
                }
                iA = xp.a(i11, 16) * xp.a(i12, 16) * 256;
                i13 = 2;
                return (iA * 3) / (i13 * 2);
            default:
                return -1;
        }
    }

    private static List a(md mdVar, f9 f9Var, boolean z11, boolean z12) {
        Pair pairA;
        String str = f9Var.f18900m;
        if (str == null) {
            return Collections.emptyList();
        }
        List listA = nd.a(mdVar.a(str, z11, z12), f9Var);
        if ("video/dolby-vision".equals(str) && (pairA = nd.a(f9Var)) != null) {
            int iIntValue = ((Integer) pairA.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                listA.addAll(mdVar.a(MimeTypes.VIDEO_H265, z11, z12));
            } else if (iIntValue == 512) {
                listA.addAll(mdVar.a(MimeTypes.VIDEO_H264, z11, z12));
            }
        }
        return Collections.unmodifiableList(listA);
    }

    private void a(long j11, long j12, f9 f9Var) {
        uq uqVar = this.f21730r1;
        if (uqVar != null) {
            uqVar.a(j11, j12, f9Var, L());
        }
    }

    private static void a(MediaFormat mediaFormat, int i11) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i11);
    }

    private static void a(hd hdVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        hdVar.a(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.applovin.impl.vq] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.applovin.impl.e2, com.applovin.impl.ld, com.applovin.impl.pd] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.applovin.impl.h7] */
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
    private void a(Object obj) throws a8 {
        ?? A;
        Surface surface;
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            A = 0;
        }
        if (A == 0) {
            h7 h7Var = this.T0;
            if (h7Var != null) {
                A = surface;
                A = h7Var;
            } else {
                kd kdVarJ = J();
                if (kdVarJ != null && c(kdVarJ)) {
                    A = surface;
                    A = h7.a(this.J0, kdVarJ.f20205g);
                    this.T0 = A;
                }
            }
        }
        A = surface;
        A = surface;
        A = surface;
        if (this.S0 == A) {
            if (A == 0 || A == this.T0) {
                return;
            }
            l0();
            k0();
            return;
        }
        this.S0 = A;
        this.K0.a(A);
        this.U0 = false;
        int iB = b();
        hd hdVarI = I();
        if (hdVarI != null) {
            if (xp.f24372a < 23 || A == 0 || this.Q0) {
                U();
                P();
            } else {
                a(hdVarI, A);
            }
        }
        if (A == 0 || A == this.T0) {
            d0();
            c0();
            return;
        }
        l0();
        c0();
        if (iB == 2) {
            n0();
        }
    }

    private static Point b(kd kdVar, f9 f9Var) {
        int i11 = f9Var.f18906s;
        int i12 = f9Var.f18905r;
        boolean z11 = i11 > i12;
        int i13 = z11 ? i11 : i12;
        if (z11) {
            i11 = i12;
        }
        float f11 = i11 / i13;
        for (int i14 : f21710s1) {
            int i15 = (int) (i14 * f11);
            if (i14 <= i13 || i15 <= i11) {
                break;
            }
            if (xp.f24372a >= 21) {
                int i16 = z11 ? i15 : i14;
                if (!z11) {
                    i14 = i15;
                }
                Point pointA = kdVar.a(i16, i14);
                if (kdVar.a(pointA.x, pointA.y, f9Var.f18907t)) {
                    return pointA;
                }
            } else {
                try {
                    int iA = xp.a(i14, 16) * 16;
                    int iA2 = xp.a(i15, 16) * 16;
                    if (iA * iA2 <= nd.b()) {
                        int i17 = z11 ? iA2 : iA;
                        if (!z11) {
                            iA = iA2;
                        }
                        return new Point(i17, iA);
                    }
                } catch (nd.c unused) {
                }
            }
        }
        return null;
    }

    public static int c(kd kdVar, f9 f9Var) {
        if (f9Var.f18901n == -1) {
            return a(kdVar, f9Var);
        }
        int size = f9Var.f18902o.size();
        int length = 0;
        for (int i11 = 0; i11 < size; i11++) {
            length += ((byte[]) f9Var.f18902o.get(i11)).length;
        }
        return f9Var.f18901n + length;
    }

    private boolean c(kd kdVar) {
        return xp.f24372a >= 23 && !this.f21727o1 && !h(kdVar.f20199a) && (!kdVar.f20205g || h7.b(this.J0));
    }

    private void c0() {
        hd hdVarI;
        this.W0 = false;
        if (xp.f24372a < 23 || !this.f21727o1 || (hdVarI = I()) == null) {
            return;
        }
        this.f21729q1 = new b(hdVarI);
    }

    private void d0() {
        this.f21726n1 = null;
    }

    private static boolean e0() {
        return "NVIDIA".equals(xp.f24374c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:610:0x0829  */
    /* JADX WARN: Code duplicated, block: B:6:0x001a  */
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
    private static boolean f0() {
        /*
            Method dump skipped, instruction units count: 3046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.pd.f0():boolean");
    }

    private static boolean g(long j11) {
        return j11 < -30000;
    }

    private void g0() {
        if (this.f21715c1 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.L0.a(this.f21715c1, jElapsedRealtime - this.f21714b1);
            this.f21715c1 = 0;
            this.f21714b1 = jElapsedRealtime;
        }
    }

    private static boolean h(long j11) {
        return j11 < -500000;
    }

    private void i0() {
        int i11 = this.f21721i1;
        if (i11 != 0) {
            this.L0.b(this.f21720h1, i11);
            this.f21720h1 = 0L;
            this.f21721i1 = 0;
        }
    }

    private void j0() {
        int i11 = this.f21722j1;
        if (i11 == -1 && this.f21723k1 == -1) {
            return;
        }
        xq xqVar = this.f21726n1;
        if (xqVar != null && xqVar.f24389a == i11 && xqVar.f24390b == this.f21723k1 && xqVar.f24391c == this.f21724l1 && xqVar.f24392d == this.f21725m1) {
            return;
        }
        xq xqVar2 = new xq(this.f21722j1, this.f21723k1, this.f21724l1, this.f21725m1);
        this.f21726n1 = xqVar2;
        this.L0.b(xqVar2);
    }

    private void k0() {
        if (this.U0) {
            this.L0.a(this.S0);
        }
    }

    private void l0() {
        xq xqVar = this.f21726n1;
        if (xqVar != null) {
            this.L0.b(xqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        a0();
    }

    private void n0() {
        this.f21713a1 = this.M0 > 0 ? SystemClock.elapsedRealtime() + this.M0 : C.TIME_UNSET;
    }

    @Override // com.applovin.impl.ld
    public boolean K() {
        return this.f21727o1 && xp.f24372a < 23;
    }

    @Override // com.applovin.impl.ld
    public void Q() {
        super.Q();
        c0();
    }

    @Override // com.applovin.impl.ld
    public void W() {
        super.W();
        this.f21717e1 = 0;
    }

    @Override // com.applovin.impl.ld
    public float a(float f11, f9 f9Var, f9[] f9VarArr) {
        float fMax = -1.0f;
        for (f9 f9Var2 : f9VarArr) {
            float f12 = f9Var2.f18907t;
            if (f12 != -1.0f) {
                fMax = Math.max(fMax, f12);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f11;
    }

    @Override // com.applovin.impl.ld
    public int a(md mdVar, f9 f9Var) {
        int i11 = 0;
        if (!Cif.i(f9Var.f18900m)) {
            return v40.a(0);
        }
        boolean z11 = f9Var.f18903p != null;
        List listA = a(mdVar, f9Var, z11, false);
        if (z11 && listA.isEmpty()) {
            listA = a(mdVar, f9Var, false, false);
        }
        if (listA.isEmpty()) {
            return v40.a(1);
        }
        if (!ld.d(f9Var)) {
            return v40.a(2);
        }
        kd kdVar = (kd) listA.get(0);
        boolean zB = kdVar.b(f9Var);
        int i12 = kdVar.c(f9Var) ? 16 : 8;
        if (zB) {
            List listA2 = a(mdVar, f9Var, z11, true);
            if (!listA2.isEmpty()) {
                kd kdVar2 = (kd) listA2.get(0);
                if (kdVar2.b(f9Var) && kdVar2.c(f9Var)) {
                    i11 = 32;
                }
            }
        }
        return v40.b(zB ? 4 : 3, i12, i11);
    }

    public MediaFormat a(f9 f9Var, String str, a aVar, float f11, boolean z11, int i11) {
        Pair pairA;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", f9Var.f18905r);
        mediaFormat.setInteger("height", f9Var.f18906s);
        sd.a(mediaFormat, f9Var.f18902o);
        sd.a(mediaFormat, "frame-rate", f9Var.f18907t);
        sd.a(mediaFormat, "rotation-degrees", f9Var.f18908u);
        sd.a(mediaFormat, f9Var.f18912y);
        if ("video/dolby-vision".equals(f9Var.f18900m) && (pairA = nd.a(f9Var)) != null) {
            sd.a(mediaFormat, Scopes.PROFILE, ((Integer) pairA.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f21731a);
        mediaFormat.setInteger("max-height", aVar.f21732b);
        sd.a(mediaFormat, "max-input-size", aVar.f21733c);
        if (xp.f24372a >= 23) {
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
            a(mediaFormat, i11);
        }
        return mediaFormat;
    }

    @Override // com.applovin.impl.ld
    public hd.a a(kd kdVar, f9 f9Var, MediaCrypto mediaCrypto, float f11) {
        h7 h7Var = this.T0;
        if (h7Var != null && h7Var.f19384a != kdVar.f20205g) {
            h7Var.release();
            this.T0 = null;
        }
        String str = kdVar.f20201c;
        a aVarA = a(kdVar, f9Var, t());
        this.P0 = aVarA;
        MediaFormat mediaFormatA = a(f9Var, str, aVarA, f11, this.O0, this.f21727o1 ? this.f21728p1 : 0);
        if (this.S0 == null) {
            if (!c(kdVar)) {
                throw new IllegalStateException();
            }
            if (this.T0 == null) {
                this.T0 = h7.a(this.J0, kdVar.f20205g);
            }
            this.S0 = this.T0;
        }
        return hd.a.a(kdVar, mediaFormatA, f9Var, this.S0, mediaCrypto);
    }

    @Override // com.applovin.impl.ld
    public jd a(Throwable th2, kd kdVar) {
        return new od(th2, kdVar, this.S0);
    }

    public a a(kd kdVar, f9 f9Var, f9[] f9VarArr) {
        int iA;
        int iMax = f9Var.f18905r;
        int iMax2 = f9Var.f18906s;
        int iC = c(kdVar, f9Var);
        if (f9VarArr.length == 1) {
            if (iC != -1 && (iA = a(kdVar, f9Var)) != -1) {
                iC = Math.min((int) (iC * 1.5f), iA);
            }
            return new a(iMax, iMax2, iC);
        }
        int length = f9VarArr.length;
        boolean z11 = false;
        for (int i11 = 0; i11 < length; i11++) {
            f9 f9VarA = f9VarArr[i11];
            if (f9Var.f18912y != null && f9VarA.f18912y == null) {
                f9VarA = f9VarA.a().a(f9Var.f18912y).a();
            }
            if (kdVar.a(f9Var, f9VarA).f21903d != 0) {
                int i12 = f9VarA.f18905r;
                z11 |= i12 == -1 || f9VarA.f18906s == -1;
                iMax = Math.max(iMax, i12);
                iMax2 = Math.max(iMax2, f9VarA.f18906s);
                iC = Math.max(iC, c(kdVar, f9VarA));
            }
        }
        if (z11) {
            pc.d("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointB = b(kdVar, f9Var);
            if (pointB != null) {
                iMax = Math.max(iMax, pointB.x);
                iMax2 = Math.max(iMax2, pointB.y);
                iC = Math.max(iC, a(kdVar, f9Var.a().q(iMax).g(iMax2).a()));
                pc.d("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new a(iMax, iMax2, iC);
    }

    @Override // com.applovin.impl.ld
    public q5 a(g9 g9Var) throws a8 {
        q5 q5VarA = super.a(g9Var);
        this.L0.a(g9Var.f19165b, q5VarA);
        return q5VarA;
    }

    @Override // com.applovin.impl.ld
    public q5 a(kd kdVar, f9 f9Var, f9 f9Var2) {
        q5 q5VarA = kdVar.a(f9Var, f9Var2);
        int i11 = q5VarA.f21904e;
        int i12 = f9Var2.f18905r;
        a aVar = this.P0;
        if (i12 > aVar.f21731a || f9Var2.f18906s > aVar.f21732b) {
            i11 |= 256;
        }
        if (c(kdVar, f9Var2) > this.P0.f21733c) {
            i11 |= 64;
        }
        int i13 = i11;
        return new q5(kdVar.f20199a, f9Var, f9Var2, i13 != 0 ? 0 : q5VarA.f21903d, i13);
    }

    @Override // com.applovin.impl.ld
    public List a(md mdVar, f9 f9Var, boolean z11) {
        return a(mdVar, f9Var, z11, this.f21727o1);
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2, com.applovin.impl.qi
    public void a(float f11, float f12) throws a8 {
        super.a(f11, f12);
        this.K0.b(f11);
    }

    @Override // com.applovin.impl.e2, com.applovin.impl.rh.b
    public void a(int i11, Object obj) throws a8 {
        if (i11 == 1) {
            a(obj);
            return;
        }
        if (i11 == 7) {
            this.f21730r1 = (uq) obj;
            return;
        }
        if (i11 == 10) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.f21728p1 != iIntValue) {
                this.f21728p1 = iIntValue;
                if (this.f21727o1) {
                    U();
                    return;
                }
                return;
            }
            return;
        }
        if (i11 != 4) {
            if (i11 != 5) {
                super.a(i11, obj);
                return;
            } else {
                this.K0.a(((Integer) obj).intValue());
                return;
            }
        }
        this.V0 = ((Integer) obj).intValue();
        hd hdVarI = I();
        if (hdVarI != null) {
            hdVarI.c(this.V0);
        }
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void a(long j11, boolean z11) throws a8 {
        super.a(j11, z11);
        c0();
        this.K0.d();
        this.f21718f1 = C.TIME_UNSET;
        this.Z0 = C.TIME_UNSET;
        this.f21716d1 = 0;
        if (z11) {
            n0();
        } else {
            this.f21713a1 = C.TIME_UNSET;
        }
    }

    @Override // com.applovin.impl.ld
    public void a(f9 f9Var, MediaFormat mediaFormat) {
        hd hdVarI = I();
        if (hdVarI != null) {
            hdVarI.c(this.V0);
        }
        if (this.f21727o1) {
            this.f21722j1 = f9Var.f18905r;
            this.f21723k1 = f9Var.f18906s;
        } else {
            b1.a(mediaFormat);
            boolean z11 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.f21722j1 = z11 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.f21723k1 = z11 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f11 = f9Var.f18909v;
        this.f21725m1 = f11;
        if (xp.f24372a >= 21) {
            int i11 = f9Var.f18908u;
            if (i11 == 90 || i11 == 270) {
                int i12 = this.f21722j1;
                this.f21722j1 = this.f21723k1;
                this.f21723k1 = i12;
                this.f21725m1 = 1.0f / f11;
            }
        } else {
            this.f21724l1 = f9Var.f18908u;
        }
        this.K0.a(f9Var.f18907t);
    }

    public void a(hd hdVar, int i11, long j11) {
        ko.a("dropVideoBuffer");
        hdVar.a(i11, false);
        ko.a();
        f(1);
    }

    public void a(hd hdVar, int i11, long j11, long j12) {
        j0();
        ko.a("releaseOutputBuffer");
        hdVar.a(i11, j12);
        ko.a();
        this.f21719g1 = SystemClock.elapsedRealtime() * 1000;
        this.E0.f21280e++;
        this.f21716d1 = 0;
        h0();
    }

    public void a(hd hdVar, Surface surface) {
        hdVar.a(surface);
    }

    @Override // com.applovin.impl.ld
    public void a(p5 p5Var) {
        if (this.R0) {
            ByteBuffer byteBuffer = (ByteBuffer) b1.a(p5Var.f21658g);
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
                    a(I(), bArr);
                }
            }
        }
    }

    @Override // com.applovin.impl.ld
    public void a(Exception exc) {
        pc.a("MediaCodecVideoRenderer", "Video codec error", exc);
        this.L0.b(exc);
    }

    @Override // com.applovin.impl.ld
    public void a(String str, long j11, long j12) {
        this.L0.a(str, j11, j12);
        this.Q0 = h(str);
        this.R0 = ((kd) b1.a(J())).b();
        if (xp.f24372a < 23 || !this.f21727o1) {
            return;
        }
        this.f21729q1 = new b((hd) b1.a(I()));
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void a(boolean z11, boolean z12) {
        super.a(z11, z12);
        boolean z13 = q().f22910a;
        b1.b((z13 && this.f21728p1 == 0) ? false : true);
        if (this.f21727o1 != z13) {
            this.f21727o1 = z13;
            U();
        }
        this.L0.b(this.E0);
        this.K0.c();
        this.X0 = z12;
        this.Y0 = false;
    }

    @Override // com.applovin.impl.ld
    public boolean a(long j11, long j12, hd hdVar, ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, f9 f9Var) {
        b1.a(hdVar);
        if (this.Z0 == C.TIME_UNSET) {
            this.Z0 = j11;
        }
        if (j13 != this.f21718f1) {
            this.K0.b(j13);
            this.f21718f1 = j13;
        }
        long jM = M();
        long j14 = j13 - jM;
        if (z11 && !z12) {
            c(hdVar, i11, j14);
            return true;
        }
        double dN = N();
        boolean z13 = b() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j15 = (long) ((j13 - j11) / dN);
        if (z13) {
            j15 -= jElapsedRealtime - j12;
        }
        if (this.S0 == this.T0) {
            if (!g(j15)) {
                return false;
            }
            c(hdVar, i11, j14);
            j(j15);
            return true;
        }
        long j16 = jElapsedRealtime - this.f21719g1;
        boolean z14 = this.Y0 ? !this.W0 : z13 || this.X0;
        if (this.f21713a1 == C.TIME_UNSET && j11 >= jM && (z14 || (z13 && d(j15, j16)))) {
            long jNanoTime = System.nanoTime();
            a(j14, jNanoTime, f9Var);
            if (xp.f24372a >= 21) {
                a(hdVar, i11, j14, jNanoTime);
            } else {
                b(hdVar, i11, j14);
            }
            j(j15);
            return true;
        }
        if (z13 && j11 != this.Z0) {
            long jNanoTime2 = System.nanoTime();
            long jA = this.K0.a((j15 * 1000) + jNanoTime2);
            long j17 = (jA - jNanoTime2) / 1000;
            boolean z15 = this.f21713a1 != C.TIME_UNSET;
            if (a(j17, j12, z12) && b(j11, z15)) {
                return false;
            }
            if (b(j17, j12, z12)) {
                if (z15) {
                    c(hdVar, i11, j14);
                } else {
                    a(hdVar, i11, j14);
                }
                j(j17);
                return true;
            }
            if (xp.f24372a >= 21) {
                if (j17 < 50000) {
                    a(j14, jA, f9Var);
                    a(hdVar, i11, j14, jA);
                    j(j17);
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
                a(j14, jA, f9Var);
                b(hdVar, i11, j14);
                j(j17);
                return true;
            }
        }
        return false;
    }

    public boolean a(long j11, long j12, boolean z11) {
        return h(j11) && !z11;
    }

    public void b(hd hdVar, int i11, long j11) {
        j0();
        ko.a("releaseOutputBuffer");
        hdVar.a(i11, true);
        ko.a();
        this.f21719g1 = SystemClock.elapsedRealtime() * 1000;
        this.E0.f21280e++;
        this.f21716d1 = 0;
        h0();
    }

    @Override // com.applovin.impl.ld
    public void b(p5 p5Var) {
        boolean z11 = this.f21727o1;
        if (!z11) {
            this.f21717e1++;
        }
        if (xp.f24372a >= 23 || !z11) {
            return;
        }
        i(p5Var.f21657f);
    }

    public boolean b(long j11, long j12, boolean z11) {
        return g(j11) && !z11;
    }

    public boolean b(long j11, boolean z11) throws a8 {
        int iB = b(j11);
        if (iB == 0) {
            return false;
        }
        n5 n5Var = this.E0;
        n5Var.f21284i++;
        int i11 = this.f21717e1 + iB;
        if (z11) {
            n5Var.f21281f += i11;
        } else {
            f(i11);
        }
        G();
        return true;
    }

    @Override // com.applovin.impl.ld
    public boolean b(kd kdVar) {
        return this.S0 != null || c(kdVar);
    }

    public void c(hd hdVar, int i11, long j11) {
        ko.a("skipVideoBuffer");
        hdVar.a(i11, false);
        ko.a();
        this.E0.f21281f++;
    }

    @Override // com.applovin.impl.ld
    public void d(long j11) {
        super.d(j11);
        if (this.f21727o1) {
            return;
        }
        this.f21717e1--;
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.qi
    public boolean d() {
        h7 h7Var;
        if (super.d() && (this.W0 || (((h7Var = this.T0) != null && this.S0 == h7Var) || I() == null || this.f21727o1))) {
            this.f21713a1 = C.TIME_UNSET;
            return true;
        }
        if (this.f21713a1 == C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f21713a1) {
            return true;
        }
        this.f21713a1 = C.TIME_UNSET;
        return false;
    }

    public boolean d(long j11, long j12) {
        return g(j11) && j12 > 100000;
    }

    public void f(int i11) {
        n5 n5Var = this.E0;
        n5Var.f21282g += i11;
        this.f21715c1 += i11;
        int i12 = this.f21716d1 + i11;
        this.f21716d1 = i12;
        n5Var.f21283h = Math.max(i12, n5Var.f21283h);
        int i13 = this.N0;
        if (i13 <= 0 || this.f21715c1 < i13) {
            return;
        }
        g0();
    }

    @Override // com.applovin.impl.ld
    public void g(String str) {
        this.L0.a(str);
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public boolean h(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (pd.class) {
            try {
                if (!f21711t1) {
                    f21712u1 = f0();
                    f21711t1 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f21712u1;
    }

    public void h0() {
        this.Y0 = true;
        if (this.W0) {
            return;
        }
        this.W0 = true;
        this.L0.a(this.S0);
        this.U0 = true;
    }

    public void i(long j11) {
        f(j11);
        j0();
        this.E0.f21280e++;
        h0();
        d(j11);
    }

    public void j(long j11) {
        this.E0.a(j11);
        this.f21720h1 += j11;
        this.f21721i1++;
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void v() {
        d0();
        c0();
        this.U0 = false;
        this.K0.b();
        this.f21729q1 = null;
        try {
            super.v();
        } finally {
            this.L0.a(this.E0);
        }
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void w() {
        h7 h7Var;
        try {
            super.w();
            h7Var = this.T0;
            if (h7Var != null) {
                if (this.S0 == h7Var) {
                    this.S0 = null;
                }
            }
        } finally {
            if (this.T0 != null) {
                Surface surface = this.S0;
                h7Var = this.T0;
                if (surface == h7Var) {
                    this.S0 = null;
                }
                h7Var.release();
                this.T0 = null;
            }
        }
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void x() {
        super.x();
        this.f21715c1 = 0;
        this.f21714b1 = SystemClock.elapsedRealtime();
        this.f21719g1 = SystemClock.elapsedRealtime() * 1000;
        this.f21720h1 = 0L;
        this.f21721i1 = 0;
        this.K0.e();
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void y() {
        this.f21713a1 = C.TIME_UNSET;
        g0();
        i0();
        this.K0.f();
        super.y();
    }
}
