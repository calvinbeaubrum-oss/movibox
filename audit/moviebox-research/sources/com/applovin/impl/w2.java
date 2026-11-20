package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w2 extends e2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final p5 f24012n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final bh f24013o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f24014p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private v2 f24015q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f24016r;

    public w2() {
        super(6);
        this.f24012n = new p5(1);
        this.f24013o = new bh();
    }

    private float[] a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f24013o.a(byteBuffer.array(), byteBuffer.limit());
        this.f24013o.f(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i11 = 0; i11 < 3; i11++) {
            fArr[i11] = Float.intBitsToFloat(this.f24013o.m());
        }
        return fArr;
    }

    private void z() {
        v2 v2Var = this.f24015q;
        if (v2Var != null) {
            v2Var.a();
        }
    }

    @Override // com.applovin.impl.ri
    public int a(f9 f9Var) {
        return MimeTypes.APPLICATION_CAMERA_MOTION.equals(f9Var.f18900m) ? v40.a(4) : v40.a(0);
    }

    @Override // com.applovin.impl.e2, com.applovin.impl.rh.b
    public void a(int i11, Object obj) {
        if (i11 == 8) {
            this.f24015q = (v2) obj;
        } else {
            super.a(i11, obj);
        }
    }

    @Override // com.applovin.impl.qi
    public void a(long j11, long j12) {
        while (!j() && this.f24016r < 100000 + j11) {
            this.f24012n.b();
            if (a(r(), this.f24012n, 0) != -4 || this.f24012n.e()) {
                return;
            }
            p5 p5Var = this.f24012n;
            this.f24016r = p5Var.f21657f;
            if (this.f24015q != null && !p5Var.d()) {
                this.f24012n.g();
                float[] fArrA = a((ByteBuffer) xp.a(this.f24012n.f21655c));
                if (fArrA != null) {
                    ((v2) xp.a(this.f24015q)).a(this.f24016r - this.f24014p, fArrA);
                }
            }
        }
    }

    @Override // com.applovin.impl.e2
    public void a(long j11, boolean z11) {
        this.f24016r = Long.MIN_VALUE;
        z();
    }

    @Override // com.applovin.impl.e2
    public void a(f9[] f9VarArr, long j11, long j12) {
        this.f24014p = j12;
    }

    @Override // com.applovin.impl.qi
    public boolean c() {
        return j();
    }

    @Override // com.applovin.impl.qi
    public boolean d() {
        return true;
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.applovin.impl.e2
    public void v() {
        z();
    }
}
