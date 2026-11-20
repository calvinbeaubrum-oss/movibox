package com.applovin.impl;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class dj implements uq, v2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SurfaceTexture f18458k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f18461n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f18449a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f18450b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ei f18451c = new ei();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k9 f18452d = new k9();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final eo f18453f = new eo();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final eo f18454g = new eo();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f18455h = new float[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f18456i = new float[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile int f18459l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18460m = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        this.f18449a.set(true);
    }

    private void a(byte[] bArr, int i11, long j11) {
        byte[] bArr2 = this.f18461n;
        int i12 = this.f18460m;
        this.f18461n = bArr;
        if (i11 == -1) {
            i11 = this.f18459l;
        }
        this.f18460m = i11;
        if (i12 == i11 && Arrays.equals(bArr2, this.f18461n)) {
            return;
        }
        byte[] bArr3 = this.f18461n;
        ci ciVarA = bArr3 != null ? di.a(bArr3, this.f18460m) : null;
        if (ciVarA == null || !ei.a(ciVarA)) {
            ciVarA = ci.a(this.f18460m);
        }
        this.f18454g.a(j11, ciVarA);
    }

    @Override // com.applovin.impl.v2
    public void a() {
        this.f18453f.a();
        this.f18452d.a();
        this.f18450b.set(true);
    }

    public void a(int i11) {
        this.f18459l = i11;
    }

    @Override // com.applovin.impl.uq
    public void a(long j11, long j12, f9 f9Var, MediaFormat mediaFormat) {
        this.f18453f.a(j12, Long.valueOf(j11));
        a(f9Var.f18910w, f9Var.f18911x, j12);
    }

    @Override // com.applovin.impl.v2
    public void a(long j11, float[] fArr) {
        this.f18452d.a(j11, fArr);
    }

    public void a(float[] fArr, boolean z11) {
        GLES20.glClear(16384);
        ba.a();
        if (this.f18449a.compareAndSet(true, false)) {
            ((SurfaceTexture) b1.a(this.f18458k)).updateTexImage();
            ba.a();
            if (this.f18450b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f18455h, 0);
            }
            long timestamp = this.f18458k.getTimestamp();
            Long l11 = (Long) this.f18453f.b(timestamp);
            if (l11 != null) {
                this.f18452d.a(this.f18455h, l11.longValue());
            }
            ci ciVar = (ci) this.f18454g.c(timestamp);
            if (ciVar != null) {
                this.f18451c.b(ciVar);
            }
        }
        Matrix.multiplyMM(this.f18456i, 0, fArr, 0, this.f18455h, 0);
        this.f18451c.a(this.f18457j, this.f18456i, z11);
    }

    public SurfaceTexture b() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        ba.a();
        this.f18451c.a();
        ba.a();
        this.f18457j = ba.b();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f18457j);
        this.f18458k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.applovin.impl.dv
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f18510a.a(surfaceTexture2);
            }
        });
        return this.f18458k;
    }
}
