package gi;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements com.google.android.exoplayer2.video.i, a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f65547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SurfaceTexture f65548k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public byte[] f65551n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f65539a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f65540b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f65541c = new f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f65542d = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0<Long> f65543f = new j0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j0<d> f65544g = new j0<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f65545h = new float[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f65546i = new float[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile int f65549l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f65550m = -1;

    @Override // gi.a
    public void a(long j11, float[] fArr) {
        this.f65542d.e(j11, fArr);
    }

    @Override // gi.a
    public void b() {
        this.f65543f.c();
        this.f65542d.d();
        this.f65540b.set(true);
    }

    public void d(float[] fArr, boolean z11) {
        GLES20.glClear(16384);
        GlUtil.c();
        if (this.f65539a.compareAndSet(true, false)) {
            ((SurfaceTexture) com.google.android.exoplayer2.util.a.e(this.f65548k)).updateTexImage();
            GlUtil.c();
            if (this.f65540b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f65545h, 0);
            }
            long timestamp = this.f65548k.getTimestamp();
            Long lG = this.f65543f.g(timestamp);
            if (lG != null) {
                this.f65542d.c(this.f65545h, lG.longValue());
            }
            d dVarJ = this.f65544g.j(timestamp);
            if (dVarJ != null) {
                this.f65541c.d(dVarJ);
            }
        }
        Matrix.multiplyMM(this.f65546i, 0, fArr, 0, this.f65545h, 0);
        this.f65541c.a(this.f65547j, this.f65546i, z11);
    }

    @Override // com.google.android.exoplayer2.video.i
    public void e(long j11, long j12, m1 m1Var, @Nullable MediaFormat mediaFormat) {
        this.f65543f.a(j12, Long.valueOf(j11));
        i(m1Var.f33455w, m1Var.f33456x, j12);
    }

    public SurfaceTexture f() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.c();
        this.f65541c.b();
        GlUtil.c();
        this.f65547j = GlUtil.f();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f65547j);
        this.f65548k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: gi.g
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f65538a.g(surfaceTexture2);
            }
        });
        return this.f65548k;
    }

    public final /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.f65539a.set(true);
    }

    public void h(int i11) {
        this.f65549l = i11;
    }

    public final void i(@Nullable byte[] bArr, int i11, long j11) {
        byte[] bArr2 = this.f65551n;
        int i12 = this.f65550m;
        this.f65551n = bArr;
        if (i11 == -1) {
            i11 = this.f65549l;
        }
        this.f65550m = i11;
        if (i12 == i11 && Arrays.equals(bArr2, this.f65551n)) {
            return;
        }
        byte[] bArr3 = this.f65551n;
        d dVarA = bArr3 != null ? e.a(bArr3, this.f65550m) : null;
        if (dVarA == null || !f.c(dVarA)) {
            dVarA = d.b(this.f65550m);
        }
        this.f65544g.a(j11, dVarA);
    }
}
