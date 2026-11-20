package com.applovin.impl;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class id extends ld implements gd {
    private final Context J0;
    private final q1.a K0;
    private final r1 L0;
    private int M0;
    private boolean N0;
    private f9 O0;
    private long P0;
    private boolean Q0;
    private boolean R0;
    private boolean S0;
    private boolean T0;
    private qi.a U0;

    /* JADX INFO: compiled from: source.java */
    public final class b implements r1.c {
        private b() {
        }

        @Override // com.applovin.impl.r1.c
        public void a() {
            if (id.this.U0 != null) {
                id.this.U0.a();
            }
        }

        @Override // com.applovin.impl.r1.c
        public void a(int i11, long j11, long j12) {
            id.this.K0.b(i11, j11, j12);
        }

        @Override // com.applovin.impl.r1.c
        public void a(long j11) {
            id.this.K0.b(j11);
        }

        @Override // com.applovin.impl.r1.c
        public void a(Exception exc) {
            pc.a("MediaCodecAudioRenderer", "Audio sink error", exc);
            id.this.K0.b(exc);
        }

        @Override // com.applovin.impl.r1.c
        public void a(boolean z11) {
            id.this.K0.b(z11);
        }

        @Override // com.applovin.impl.r1.c
        public void b() {
            id.this.d0();
        }

        @Override // com.applovin.impl.r1.c
        public void b(long j11) {
            if (id.this.U0 != null) {
                id.this.U0.a(j11);
            }
        }
    }

    public id(Context context, hd.b bVar, md mdVar, boolean z11, Handler handler, q1 q1Var, r1 r1Var) {
        super(1, bVar, mdVar, z11, 44100.0f);
        this.J0 = context.getApplicationContext();
        this.L0 = r1Var;
        this.K0 = new q1.a(handler, q1Var);
        r1Var.a(new b());
    }

    public id(Context context, md mdVar, boolean z11, Handler handler, q1 q1Var, r1 r1Var) {
        this(context, hd.b.f19478a, mdVar, z11, handler, q1Var, r1Var);
    }

    private int a(kd kdVar, f9 f9Var) {
        int i11;
        if (!"OMX.google.raw.decoder".equals(kdVar.f20199a) || (i11 = xp.f24372a) >= 24 || (i11 == 23 && xp.d(this.J0))) {
            return f9Var.f18901n;
        }
        return -1;
    }

    private static boolean c0() {
        if (xp.f24372a == 23) {
            String str = xp.f24375d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void e0() {
        long jA = this.L0.a(c());
        if (jA != Long.MIN_VALUE) {
            if (!this.R0) {
                jA = Math.max(this.P0, jA);
            }
            this.P0 = jA;
            this.R0 = false;
        }
    }

    private static boolean h(String str) {
        if (xp.f24372a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(xp.f24374c)) {
            String str2 = xp.f24373b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    @Override // com.applovin.impl.ld
    public void Q() {
        super.Q();
        this.L0.i();
    }

    @Override // com.applovin.impl.ld
    public void V() throws a8 {
        try {
            this.L0.f();
        } catch (r1.e e11) {
            throw a(e11, e11.f22021c, e11.f22020b, 5002);
        }
    }

    @Override // com.applovin.impl.ld
    public float a(float f11, f9 f9Var, f9[] f9VarArr) {
        int iMax = -1;
        for (f9 f9Var2 : f9VarArr) {
            int i11 = f9Var2.A;
            if (i11 != -1) {
                iMax = Math.max(iMax, i11);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f11 * iMax;
    }

    public int a(kd kdVar, f9 f9Var, f9[] f9VarArr) {
        int iA = a(kdVar, f9Var);
        if (f9VarArr.length == 1) {
            return iA;
        }
        for (f9 f9Var2 : f9VarArr) {
            if (kdVar.a(f9Var, f9Var2).f21903d != 0) {
                iA = Math.max(iA, a(kdVar, f9Var2));
            }
        }
        return iA;
    }

    @Override // com.applovin.impl.ld
    public int a(md mdVar, f9 f9Var) {
        if (!Cif.g(f9Var.f18900m)) {
            return v40.a(0);
        }
        int i11 = xp.f24372a >= 21 ? 32 : 0;
        boolean z11 = f9Var.F != 0;
        boolean zD = ld.d(f9Var);
        int i12 = 8;
        if (zD && this.L0.a(f9Var) && (!z11 || nd.a() != null)) {
            return v40.b(4, 8, i11);
        }
        if ((!MimeTypes.AUDIO_RAW.equals(f9Var.f18900m) || this.L0.a(f9Var)) && this.L0.a(xp.b(2, f9Var.f18913z, f9Var.A))) {
            List listA = a(mdVar, f9Var, false);
            if (listA.isEmpty()) {
                return v40.a(1);
            }
            if (!zD) {
                return v40.a(2);
            }
            kd kdVar = (kd) listA.get(0);
            boolean zB = kdVar.b(f9Var);
            if (zB && kdVar.c(f9Var)) {
                i12 = 16;
            }
            return v40.b(zB ? 4 : 3, i12, i11);
        }
        return v40.a(1);
    }

    public MediaFormat a(f9 f9Var, String str, int i11, float f11) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", f9Var.f18913z);
        mediaFormat.setInteger("sample-rate", f9Var.A);
        sd.a(mediaFormat, f9Var.f18902o);
        sd.a(mediaFormat, "max-input-size", i11);
        int i12 = xp.f24372a;
        if (i12 >= 23) {
            mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
            if (f11 != -1.0f && !c0()) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (i12 <= 28 && "audio/ac4".equals(f9Var.f18900m)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i12 >= 24 && this.L0.b(xp.b(4, f9Var.f18913z, f9Var.A)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        return mediaFormat;
    }

    @Override // com.applovin.impl.ld
    public hd.a a(kd kdVar, f9 f9Var, MediaCrypto mediaCrypto, float f11) {
        this.M0 = a(kdVar, f9Var, t());
        this.N0 = h(kdVar.f20199a);
        MediaFormat mediaFormatA = a(f9Var, kdVar.f20201c, this.M0, f11);
        this.O0 = (!MimeTypes.AUDIO_RAW.equals(kdVar.f20200b) || MimeTypes.AUDIO_RAW.equals(f9Var.f18900m)) ? null : f9Var;
        return hd.a.a(kdVar, mediaFormatA, f9Var, mediaCrypto);
    }

    @Override // com.applovin.impl.gd
    public ph a() {
        return this.L0.a();
    }

    @Override // com.applovin.impl.ld
    public q5 a(g9 g9Var) throws a8 {
        q5 q5VarA = super.a(g9Var);
        this.K0.a(g9Var.f19165b, q5VarA);
        return q5VarA;
    }

    @Override // com.applovin.impl.ld
    public q5 a(kd kdVar, f9 f9Var, f9 f9Var2) {
        q5 q5VarA = kdVar.a(f9Var, f9Var2);
        int i11 = q5VarA.f21904e;
        if (a(kdVar, f9Var2) > this.M0) {
            i11 |= 64;
        }
        int i12 = i11;
        return new q5(kdVar.f20199a, f9Var, f9Var2, i12 != 0 ? 0 : q5VarA.f21903d, i12);
    }

    @Override // com.applovin.impl.ld
    public List a(md mdVar, f9 f9Var, boolean z11) {
        kd kdVarA;
        String str = f9Var.f18900m;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.L0.a(f9Var) && (kdVarA = nd.a()) != null) {
            return Collections.singletonList(kdVarA);
        }
        List listA = nd.a(mdVar.a(str, z11, false), f9Var);
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(str)) {
            ArrayList arrayList = new ArrayList(listA);
            arrayList.addAll(mdVar.a(MimeTypes.AUDIO_E_AC3, z11, false));
            listA = arrayList;
        }
        return Collections.unmodifiableList(listA);
    }

    @Override // com.applovin.impl.e2, com.applovin.impl.rh.b
    public void a(int i11, Object obj) {
        if (i11 == 2) {
            this.L0.a(((Float) obj).floatValue());
        }
        if (i11 == 3) {
            this.L0.a((l1) obj);
            return;
        }
        if (i11 == 6) {
            this.L0.a((v1) obj);
            return;
        }
        switch (i11) {
            case 9:
                this.L0.b(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.L0.a(((Integer) obj).intValue());
                break;
            case 11:
                this.U0 = (qi.a) obj;
                break;
            default:
                super.a(i11, obj);
                break;
        }
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void a(long j11, boolean z11) throws a8 {
        super.a(j11, z11);
        if (this.T0) {
            this.L0.h();
        } else {
            this.L0.b();
        }
        this.P0 = j11;
        this.Q0 = true;
        this.R0 = true;
    }

    @Override // com.applovin.impl.ld
    public void a(f9 f9Var, MediaFormat mediaFormat) throws a8 {
        int iD;
        int i11;
        f9 f9Var2 = this.O0;
        int[] iArr = null;
        if (f9Var2 != null) {
            f9Var = f9Var2;
        } else if (I() != null) {
            if (MimeTypes.AUDIO_RAW.equals(f9Var.f18900m)) {
                iD = f9Var.B;
            } else if (xp.f24372a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                iD = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                iD = xp.d(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                iD = MimeTypes.AUDIO_RAW.equals(f9Var.f18900m) ? f9Var.B : 2;
            }
            f9 f9VarA = new f9.b().f(MimeTypes.AUDIO_RAW).j(iD).e(f9Var.C).f(f9Var.D).c(mediaFormat.getInteger("channel-count")).n(mediaFormat.getInteger("sample-rate")).a();
            if (this.N0 && f9VarA.f18913z == 6 && (i11 = f9Var.f18913z) < 6) {
                iArr = new int[i11];
                for (int i12 = 0; i12 < f9Var.f18913z; i12++) {
                    iArr[i12] = i12;
                }
            }
            f9Var = f9VarA;
        }
        try {
            this.L0.a(f9Var, 0, iArr);
        } catch (r1.a e11) {
            throw a(e11, e11.f22013a, 5001);
        }
    }

    @Override // com.applovin.impl.gd
    public void a(ph phVar) {
        this.L0.a(phVar);
    }

    @Override // com.applovin.impl.ld
    public void a(Exception exc) {
        pc.a("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.K0.a(exc);
    }

    @Override // com.applovin.impl.ld
    public void a(String str, long j11, long j12) {
        this.K0.a(str, j11, j12);
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void a(boolean z11, boolean z12) {
        super.a(z11, z12);
        this.K0.b(this.E0);
        if (q().f22910a) {
            this.L0.e();
        } else {
            this.L0.d();
        }
    }

    @Override // com.applovin.impl.ld
    public boolean a(long j11, long j12, hd hdVar, ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, f9 f9Var) throws a8 {
        b1.a(byteBuffer);
        if (this.O0 != null && (i12 & 2) != 0) {
            ((hd) b1.a(hdVar)).a(i11, false);
            return true;
        }
        if (z11) {
            if (hdVar != null) {
                hdVar.a(i11, false);
            }
            this.E0.f21281f += i13;
            this.L0.i();
            return true;
        }
        try {
            if (!this.L0.a(byteBuffer, j13, i13)) {
                return false;
            }
            if (hdVar != null) {
                hdVar.a(i11, false);
            }
            this.E0.f21280e += i13;
            return true;
        } catch (r1.b e11) {
            throw a(e11, e11.f22016c, e11.f22015b, 5001);
        } catch (r1.e e12) {
            throw a(e12, f9Var, e12.f22020b, 5002);
        }
    }

    @Override // com.applovin.impl.ld
    public void b(p5 p5Var) {
        if (!this.Q0 || p5Var.d()) {
            return;
        }
        if (Math.abs(p5Var.f21657f - this.P0) > 500000) {
            this.P0 = p5Var.f21657f;
        }
        this.Q0 = false;
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.qi
    public boolean c() {
        return super.c() && this.L0.c();
    }

    @Override // com.applovin.impl.ld
    public boolean c(f9 f9Var) {
        return this.L0.a(f9Var);
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.qi
    public boolean d() {
        return this.L0.g() || super.d();
    }

    public void d0() {
        this.R0 = true;
    }

    @Override // com.applovin.impl.ld
    public void g(String str) {
        this.K0.a(str);
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.applovin.impl.e2, com.applovin.impl.qi
    public gd l() {
        return this;
    }

    @Override // com.applovin.impl.gd
    public long p() {
        if (b() == 2) {
            e0();
        }
        return this.P0;
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void v() {
        this.S0 = true;
        try {
            this.L0.b();
            try {
                super.v();
            } finally {
                this.K0.a(this.E0);
            }
        } catch (Throwable th2) {
            try {
                super.v();
                throw th2;
            } finally {
                this.K0.a(this.E0);
            }
        }
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void w() {
        try {
            super.w();
        } finally {
            if (this.S0) {
                this.S0 = false;
                this.L0.reset();
            }
        }
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void x() {
        super.x();
        this.L0.j();
    }

    @Override // com.applovin.impl.ld, com.applovin.impl.e2
    public void y() {
        e0();
        this.L0.pause();
        super.y();
    }
}
