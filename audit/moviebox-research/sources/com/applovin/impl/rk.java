package com.applovin.impl;

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
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class rk extends GLSurfaceView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f22121n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f22122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f22123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Sensor f22124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final xg f22125d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f22126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final jo f22127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final dj f22128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SurfaceTexture f22129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Surface f22130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f22131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f22132l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f22133m;

    /* JADX INFO: compiled from: source.java */
    public final class a implements GLSurfaceView.Renderer, jo.a, xg.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final dj f22134a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float[] f22137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float[] f22138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float[] f22139f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f22140g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f22141h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f22135b = new float[16];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f22136c = new float[16];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final float[] f22142i = new float[16];

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final float[] f22143j = new float[16];

        public a(dj djVar) {
            float[] fArr = new float[16];
            this.f22137d = fArr;
            float[] fArr2 = new float[16];
            this.f22138e = fArr2;
            float[] fArr3 = new float[16];
            this.f22139f = fArr3;
            this.f22134a = djVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f22141h = 3.1415927f;
        }

        private float a(float f11) {
            if (f11 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f11))) * 2.0d);
            }
            return 90.0f;
        }

        private void a() {
            Matrix.setRotateM(this.f22138e, 0, -this.f22140g, (float) Math.cos(this.f22141h), (float) Math.sin(this.f22141h), 0.0f);
        }

        @Override // com.applovin.impl.jo.a
        public synchronized void a(PointF pointF) {
            this.f22140g = pointF.y;
            a();
            Matrix.setRotateM(this.f22139f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // com.applovin.impl.xg.a
        public synchronized void a(float[] fArr, float f11) {
            float[] fArr2 = this.f22137d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f22141h = -f11;
            a();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f22143j, 0, this.f22137d, 0, this.f22139f, 0);
                Matrix.multiplyMM(this.f22142i, 0, this.f22138e, 0, this.f22143j, 0);
            }
            Matrix.multiplyMM(this.f22136c, 0, this.f22135b, 0, this.f22142i, 0);
            this.f22134a.a(this.f22136c, false);
        }

        @Override // com.applovin.impl.jo.a
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return rk.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
            float f11 = i11 / i12;
            Matrix.perspectiveM(this.f22135b, 0, a(f11), f11, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            rk.this.b(this.f22134a.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(Surface surface);

        void b(Surface surface);
    }

    public rk(Context context) {
        this(context, null);
    }

    public rk(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22122a = new CopyOnWriteArrayList();
        this.f22126f = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) b1.a(context.getSystemService("sensor"));
        this.f22123b = sensorManager;
        Sensor defaultSensor = xp.f24372a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f22124c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        dj djVar = new dj();
        this.f22128h = djVar;
        a aVar = new a(djVar);
        jo joVar = new jo(context, aVar, 25.0f);
        this.f22127g = joVar;
        this.f22125d = new xg(((WindowManager) b1.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), joVar, aVar);
        this.f22131k = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(joVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        Surface surface = this.f22130j;
        if (surface != null) {
            Iterator it = this.f22122a.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(surface);
            }
        }
        a(this.f22129i, surface);
        this.f22129i = null;
        this.f22130j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f22129i;
        Surface surface = this.f22130j;
        Surface surface2 = new Surface(surfaceTexture);
        this.f22129i = surfaceTexture;
        this.f22130j = surface2;
        Iterator it = this.f22122a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b(surface2);
        }
        a(surfaceTexture2, surface);
    }

    private static void a(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void b() {
        boolean z11 = this.f22131k && this.f22132l;
        Sensor sensor = this.f22124c;
        if (sensor == null || z11 == this.f22133m) {
            return;
        }
        if (z11) {
            this.f22123b.registerListener(this.f22125d, sensor, 0);
        } else {
            this.f22123b.unregisterListener(this.f22125d);
        }
        this.f22133m = z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final SurfaceTexture surfaceTexture) {
        this.f22126f.post(new Runnable() { // from class: com.applovin.impl.x40
            @Override // java.lang.Runnable
            public final void run() {
                this.f24226a.a(surfaceTexture);
            }
        });
    }

    public void a(b bVar) {
        this.f22122a.add(bVar);
    }

    public void b(b bVar) {
        this.f22122a.remove(bVar);
    }

    public v2 getCameraMotionListener() {
        return this.f22128h;
    }

    public uq getVideoFrameMetadataListener() {
        return this.f22128h;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f22130j;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f22126f.post(new Runnable() { // from class: com.applovin.impl.w40
            @Override // java.lang.Runnable
            public final void run() {
                this.f24054a.a();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f22132l = false;
        b();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f22132l = true;
        b();
    }

    public void setDefaultStereoMode(int i11) {
        this.f22128h.a(i11);
    }

    public void setUseSensorRotation(boolean z11) {
        this.f22131k = z11;
        b();
    }
}
