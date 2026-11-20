package androidx.media3.exoplayer.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.media3.common.util.GlUtil;
import androidx.media3.exoplayer.video.o;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import t4.h;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f11695n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f11696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SensorManager f11697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Sensor f11698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.exoplayer.video.spherical.a f11699d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f11700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.media3.exoplayer.video.spherical.b f11701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f11702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public SurfaceTexture f11703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Surface f11704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11707m;

    /* JADX INFO: compiled from: source.java */
    public final class a implements GLSurfaceView.Renderer, androidx.media3.exoplayer.video.spherical.b.a, androidx.media3.exoplayer.video.spherical.a.InterfaceC0109a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f11708a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f11711d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float[] f11712f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float[] f11713g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f11714h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f11715i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f11709b = new float[16];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f11710c = new float[16];

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float[] f11716j = new float[16];

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float[] f11717k = new float[16];

        public a(h hVar) {
            float[] fArr = new float[16];
            this.f11711d = fArr;
            float[] fArr2 = new float[16];
            this.f11712f = fArr2;
            float[] fArr3 = new float[16];
            this.f11713g = fArr3;
            this.f11708a = hVar;
            GlUtil.k(fArr);
            GlUtil.k(fArr2);
            GlUtil.k(fArr3);
            this.f11715i = 3.1415927f;
        }

        @Override // androidx.media3.exoplayer.video.spherical.a.InterfaceC0109a
        public synchronized void a(float[] fArr, float f11) {
            float[] fArr2 = this.f11711d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f11715i = -f11;
            d();
        }

        @Override // androidx.media3.exoplayer.video.spherical.b.a
        public synchronized void b(PointF pointF) {
            this.f11714h = pointF.y;
            d();
            Matrix.setRotateM(this.f11713g, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public final float c(float f11) {
            if (f11 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f11))) * 2.0d);
            }
            return 90.0f;
        }

        public final void d() {
            Matrix.setRotateM(this.f11712f, 0, -this.f11714h, (float) Math.cos(this.f11715i), (float) Math.sin(this.f11715i), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f11717k, 0, this.f11711d, 0, this.f11713g, 0);
                Matrix.multiplyMM(this.f11716j, 0, this.f11712f, 0, this.f11717k, 0);
            }
            Matrix.multiplyMM(this.f11710c, 0, this.f11709b, 0, this.f11716j, 0);
            this.f11708a.d(this.f11710c, false);
        }

        @Override // androidx.media3.exoplayer.video.spherical.b.a
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
            float f11 = i11 / i12;
            Matrix.perspectiveM(this.f11709b, 0, c(f11), f11, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.f(this.f11708a.f());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void p(Surface surface);

        void q(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11696a = new CopyOnWriteArrayList<>();
        this.f11700f = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) z3.a.e(context.getSystemService("sensor"));
        this.f11697b = sensorManager;
        Sensor defaultSensor = u0.f81838a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f11698c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        h hVar = new h();
        this.f11702h = hVar;
        a aVar = new a(hVar);
        androidx.media3.exoplayer.video.spherical.b bVar = new androidx.media3.exoplayer.video.spherical.b(context, aVar, 25.0f);
        this.f11701g = bVar;
        this.f11699d = new androidx.media3.exoplayer.video.spherical.a(((WindowManager) z3.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), bVar, aVar);
        this.f11705k = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(bVar);
    }

    public static void g(@Nullable SurfaceTexture surfaceTexture, @Nullable Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    public void addVideoSurfaceListener(b bVar) {
        this.f11696a.add(bVar);
    }

    public final /* synthetic */ void d() {
        Surface surface = this.f11704j;
        if (surface != null) {
            Iterator<b> it = this.f11696a.iterator();
            while (it.hasNext()) {
                it.next().p(surface);
            }
        }
        g(this.f11703i, surface);
        this.f11703i = null;
        this.f11704j = null;
    }

    public final /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f11703i;
        Surface surface = this.f11704j;
        Surface surface2 = new Surface(surfaceTexture);
        this.f11703i = surfaceTexture;
        this.f11704j = surface2;
        Iterator<b> it = this.f11696a.iterator();
        while (it.hasNext()) {
            it.next().q(surface2);
        }
        g(surfaceTexture2, surface);
    }

    public final void f(final SurfaceTexture surfaceTexture) {
        this.f11700f.post(new Runnable() { // from class: t4.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f76907a.e(surfaceTexture);
            }
        });
    }

    public t4.a getCameraMotionListener() {
        return this.f11702h;
    }

    public o getVideoFrameMetadataListener() {
        return this.f11702h;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f11704j;
    }

    public final void h() {
        boolean z11 = this.f11705k && this.f11706l;
        Sensor sensor = this.f11698c;
        if (sensor == null || z11 == this.f11707m) {
            return;
        }
        if (z11) {
            this.f11697b.registerListener(this.f11699d, sensor, 0);
        } else {
            this.f11697b.unregisterListener(this.f11699d);
        }
        this.f11707m = z11;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11700f.post(new Runnable() { // from class: t4.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f76909a.d();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f11706l = false;
        h();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f11706l = true;
        h();
    }

    public void removeVideoSurfaceListener(b bVar) {
        this.f11696a.remove(bVar);
    }

    public void setDefaultStereoMode(int i11) {
        this.f11702h.h(i11);
    }

    public void setUseSensorRotation(boolean z11) {
        this.f11705k = z11;
        h();
    }
}
