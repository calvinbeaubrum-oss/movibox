package com.google.android.exoplayer2.video.spherical;

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
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.video.i;
import gi.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f35812n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f35813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SensorManager f35814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Sensor f35815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.video.spherical.a f35816d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f35817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.exoplayer2.video.spherical.b f35818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f35819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public SurfaceTexture f35820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Surface f35821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f35822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f35823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f35824m;

    /* JADX INFO: compiled from: source.java */
    public final class a implements GLSurfaceView.Renderer, com.google.android.exoplayer2.video.spherical.b.a, com.google.android.exoplayer2.video.spherical.a.InterfaceC0376a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f35825a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f35828d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float[] f35829f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float[] f35830g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f35831h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f35832i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f35826b = new float[16];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f35827c = new float[16];

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float[] f35833j = new float[16];

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float[] f35834k = new float[16];

        public a(h hVar) {
            float[] fArr = new float[16];
            this.f35828d = fArr;
            float[] fArr2 = new float[16];
            this.f35829f = fArr2;
            float[] fArr3 = new float[16];
            this.f35830g = fArr3;
            this.f35825a = hVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f35832i = 3.1415927f;
        }

        @Override // com.google.android.exoplayer2.video.spherical.a.InterfaceC0376a
        public synchronized void a(float[] fArr, float f11) {
            float[] fArr2 = this.f35828d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f35832i = -f11;
            d();
        }

        @Override // com.google.android.exoplayer2.video.spherical.b.a
        public synchronized void b(PointF pointF) {
            this.f35831h = pointF.y;
            d();
            Matrix.setRotateM(this.f35830g, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public final float c(float f11) {
            if (f11 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f11))) * 2.0d);
            }
            return 90.0f;
        }

        public final void d() {
            Matrix.setRotateM(this.f35829f, 0, -this.f35831h, (float) Math.cos(this.f35832i), (float) Math.sin(this.f35832i), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f35834k, 0, this.f35828d, 0, this.f35830g, 0);
                Matrix.multiplyMM(this.f35833j, 0, this.f35829f, 0, this.f35834k, 0);
            }
            Matrix.multiplyMM(this.f35827c, 0, this.f35826b, 0, this.f35833j, 0);
            this.f35825a.d(this.f35827c, false);
        }

        @Override // com.google.android.exoplayer2.video.spherical.b.a
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
            float f11 = i11 / i12;
            Matrix.perspectiveM(this.f35826b, 0, c(f11), f11, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.f(this.f35825a.f());
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
        this.f35813a = new CopyOnWriteArrayList<>();
        this.f35817f = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) com.google.android.exoplayer2.util.a.e(context.getSystemService("sensor"));
        this.f35814b = sensorManager;
        Sensor defaultSensor = o0.f35608a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f35815c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        h hVar = new h();
        this.f35819h = hVar;
        a aVar = new a(hVar);
        com.google.android.exoplayer2.video.spherical.b bVar = new com.google.android.exoplayer2.video.spherical.b(context, aVar, 25.0f);
        this.f35818g = bVar;
        this.f35816d = new com.google.android.exoplayer2.video.spherical.a(((WindowManager) com.google.android.exoplayer2.util.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), bVar, aVar);
        this.f35822k = true;
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
        this.f35813a.add(bVar);
    }

    public final /* synthetic */ void d() {
        Surface surface = this.f35821j;
        if (surface != null) {
            Iterator<b> it = this.f35813a.iterator();
            while (it.hasNext()) {
                it.next().p(surface);
            }
        }
        g(this.f35820i, surface);
        this.f35820i = null;
        this.f35821j = null;
    }

    public final /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f35820i;
        Surface surface = this.f35821j;
        Surface surface2 = new Surface(surfaceTexture);
        this.f35820i = surfaceTexture;
        this.f35821j = surface2;
        Iterator<b> it = this.f35813a.iterator();
        while (it.hasNext()) {
            it.next().q(surface2);
        }
        g(surfaceTexture2, surface);
    }

    public final void f(final SurfaceTexture surfaceTexture) {
        this.f35817f.post(new Runnable() { // from class: gi.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f65552a.e(surfaceTexture);
            }
        });
    }

    public gi.a getCameraMotionListener() {
        return this.f35819h;
    }

    public i getVideoFrameMetadataListener() {
        return this.f35819h;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f35821j;
    }

    public final void h() {
        boolean z11 = this.f35822k && this.f35823l;
        Sensor sensor = this.f35815c;
        if (sensor == null || z11 == this.f35824m) {
            return;
        }
        if (z11) {
            this.f35814b.registerListener(this.f35816d, sensor, 0);
        } else {
            this.f35814b.unregisterListener(this.f35816d);
        }
        this.f35824m = z11;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f35817f.post(new Runnable() { // from class: gi.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f65554a.d();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f35823l = false;
        h();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f35823l = true;
        h();
    }

    public void removeVideoSurfaceListener(b bVar) {
        this.f35813a.remove(bVar);
    }

    public void setDefaultStereoMode(int i11) {
        this.f35819h.h(i11);
    }

    public void setUseSensorRotation(boolean z11) {
        this.f35822k = z11;
        h();
    }
}
