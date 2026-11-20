package t4;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.y;
import androidx.media3.exoplayer.video.o;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import z3.h0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements o, a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f76902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SurfaceTexture f76903k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public byte[] f76906n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f76894a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f76895b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f76896c = new f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f76897d = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0<Long> f76898f = new h0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h0<d> f76899g = new h0<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f76900h = new float[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f76901i = new float[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile int f76904l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f76905m = -1;

    @Override // t4.a
    public void a(long j11, float[] fArr) {
        this.f76897d.e(j11, fArr);
    }

    @Override // t4.a
    public void b() {
        this.f76898f.c();
        this.f76897d.d();
        this.f76895b.set(true);
    }

    public void d(float[] fArr, boolean z11) {
        GLES20.glClear(16384);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e11) {
            z3.o.d("SceneRenderer", "Failed to draw a frame", e11);
        }
        if (this.f76894a.compareAndSet(true, false)) {
            ((SurfaceTexture) z3.a.e(this.f76903k)).updateTexImage();
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e12) {
                z3.o.d("SceneRenderer", "Failed to draw a frame", e12);
            }
            if (this.f76895b.compareAndSet(true, false)) {
                GlUtil.k(this.f76900h);
            }
            long timestamp = this.f76903k.getTimestamp();
            Long lG = this.f76898f.g(timestamp);
            if (lG != null) {
                this.f76897d.c(this.f76900h, lG.longValue());
            }
            d dVarJ = this.f76899g.j(timestamp);
            if (dVarJ != null) {
                this.f76896c.d(dVarJ);
            }
        }
        Matrix.multiplyMM(this.f76901i, 0, fArr, 0, this.f76900h, 0);
        this.f76896c.a(this.f76902j, this.f76901i, z11);
    }

    @Override // androidx.media3.exoplayer.video.o
    public void e(long j11, long j12, y yVar, @Nullable MediaFormat mediaFormat) {
        this.f76898f.a(j12, Long.valueOf(j11));
        i(yVar.f9511w, yVar.f9512x, j12);
    }

    public SurfaceTexture f() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GlUtil.b();
            this.f76896c.b();
            GlUtil.b();
            this.f76902j = GlUtil.f();
        } catch (GlUtil.GlException e11) {
            z3.o.d("SceneRenderer", "Failed to initialize the renderer", e11);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f76902j);
        this.f76903k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: t4.g
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f76893a.g(surfaceTexture2);
            }
        });
        return this.f76903k;
    }

    public final /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.f76894a.set(true);
    }

    public void h(int i11) {
        this.f76904l = i11;
    }

    public final void i(@Nullable byte[] bArr, int i11, long j11) {
        byte[] bArr2 = this.f76906n;
        int i12 = this.f76905m;
        this.f76906n = bArr;
        if (i11 == -1) {
            i11 = this.f76904l;
        }
        this.f76905m = i11;
        if (i12 == i11 && Arrays.equals(bArr2, this.f76906n)) {
            return;
        }
        byte[] bArr3 = this.f76906n;
        d dVarA = bArr3 != null ? e.a(bArr3, this.f76905m) : null;
        if (dVarA == null || !f.c(dVarA)) {
            dVarA = d.b(this.f76905m);
        }
        this.f76899g.a(j11, dVarA);
    }
}
